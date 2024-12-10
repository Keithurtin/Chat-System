import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Server {
    private static final int PORT = 12345;
    private static Set<PrintWriter> clientWriters = new HashSet<>();
    private static Map<PrintWriter, String> clientNicknames = new HashMap<>();
    private static Map<String, PrintWriter> nicknameToWriter = new HashMap<>(); // Map nicknames to PrintWriters

    public static void main(String[] args) {
        System.out.println("Chat server started...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String nickname;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Ask the client for a nickname
                nickname = in.readLine();
                synchronized (clientWriters) {
                    clientWriters.add(out);
                    clientNicknames.put(out, nickname);
                    nicknameToWriter.put(nickname, out);
                }

                // Send a welcome message to the client

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("quit") || message.equalsIgnoreCase("exit")) {
                        break;  // Client requested to quit
                    }

                    // Check if the message is a private message
                    if (message.startsWith("/private")) {
                        String[] parts = message.split(" ", 3); // Split into at least 3 parts
                        if (parts.length == 3) {
                            String recipientNickname = parts[1];
                            String privateMessage = parts[2]; // The remaining message could contain spaces
                            sendPrivateMessage(recipientNickname, privateMessage);
                        } else {
                            out.println("Incorrect private message format. Use /private <nickname> <message>");
                        }
                    }
                }

                // Handle client disconnection
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                    clientNicknames.remove(out);
                    nicknameToWriter.remove(nickname);
                }
                System.out.println(nickname + " has disconnected.");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void sendPrivateMessage(String recipientNickname, String message) {
            PrintWriter recipientWriter = nicknameToWriter.get(recipientNickname);
            if (recipientWriter != null) {
                recipientWriter.println(message);
            }
        }
    }
}
