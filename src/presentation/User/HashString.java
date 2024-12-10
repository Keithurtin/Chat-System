package presentation.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class HashString {
    private static final int SALT_LENGTH = 16;
    private static final int ITERATIONS = 1000;

    public static String hashString(String str) {
        try {
            byte[] salt = new byte[SALT_LENGTH];
            SecureRandom random = new SecureRandom();
            random.nextBytes(salt);

            // Hash the string with the salt
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedBytes = md.digest(str.getBytes());

            // Perform additional iterations
            for (int i = 0; i < ITERATIONS; i++) {
                md.reset();
                hashedBytes = md.digest(hashedBytes);
            }

            // Combine salt and hash
            byte[] hashWithSalt = new byte[salt.length + hashedBytes.length];
            System.arraycopy(salt, 0, hashWithSalt, 0, salt.length);
            System.arraycopy(hashedBytes, 0, hashWithSalt, salt.length, hashedBytes.length);

            // Encode to Base64 for storage
            return Base64.getEncoder().encodeToString(hashWithSalt);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }

    public static boolean verifyHash(String originalString, String storedHash) {
        try {
            byte[] hashWithSalt = Base64.getDecoder().decode(storedHash);

            // Extract the salt
            byte[] salt = new byte[SALT_LENGTH];
            System.arraycopy(hashWithSalt, 0, salt, 0, SALT_LENGTH);

            // Extract the hash
            byte[] storedHashBytes = new byte[hashWithSalt.length - SALT_LENGTH];
            System.arraycopy(hashWithSalt, SALT_LENGTH, storedHashBytes, 0, storedHashBytes.length);

            // Hash the original string with the extracted salt
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedBytes = md.digest(originalString.getBytes());

            // Perform additional iterations
            for (int i = 0; i < ITERATIONS; i++) {
                md.reset();
                hashedBytes = md.digest(hashedBytes);
            }

            // Compare the hashes
            return MessageDigest.isEqual(hashedBytes, storedHashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }

    public static void main(String[] args) {
        String originalString = "mySecurePassword";
        String hashedString = HashString.hashString(originalString);

        System.out.println("Original: " + originalString);
        System.out.println("Hashed: " + hashedString);

        boolean isMatch = HashString.verifyHash(originalString, hashedString);
        System.out.println("Do they match? " + isMatch);
    }
}
