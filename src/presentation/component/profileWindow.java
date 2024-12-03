package component;
import java.awt.*;
import javax.swing.*;
import bus.*;
import dto.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class profileWindow extends JFrame {
    private JPanel navigator;

    public profileWindow(int uid) {
        UsersBUS usersBUS = new UsersBUS();
        UsersDTO user = usersBUS.getById(uid);
        FriendListBUS friendListBUS = new FriendListBUS();
        List<UsersDTO> friendList = friendListBUS.getFriends(uid);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); // You can change the pattern as needed
        String birthDateString = formatter.format(user.getBirthDate());

        JPanel main_panel = new JPanel();
        JPanel content_side = new JPanel();
        JLabel username_label = new JLabel("Name: ");
        JLabel fullname_label = new JLabel("Fullname: ");
        JLabel gender_label = new JLabel("Gender: ");
        JLabel address_label = new JLabel("Address: ");
        JLabel birthdate_label = new JLabel("Birthday: ");
        JLabel email_label = new JLabel("Email: ");
        JLabel num_friend_label = new JLabel("No. Friends: ");
        JLabel username_value_label = new JLabel(user.getuName());
        JLabel fullname_value_label = new JLabel(user.getFullname());
        JLabel address_value_label = new JLabel(user.getAddress());
        JLabel birthdate_value_label = new JLabel(birthDateString);
        JLabel gender_value_label = new JLabel(user.getGender());
        JLabel email_value_label = new JLabel(user.getEmail());
        JLabel num_of_friend_value_label = new JLabel(String.valueOf(friendList.size()));

        setupNavigatorLayout();

        username_label.setFont(new Font("Segoe UI", 1, 18));
        fullname_label.setFont(new Font("Segoe UI", 1, 18));
        address_label.setFont(new Font("Segoe UI", 1, 18));
        birthdate_label.setFont(new Font("Segoe UI", 1, 18));
        gender_label.setFont(new Font("Segoe UI", 1, 18));
        email_label.setFont(new Font("Segoe UI", 1, 18));
        num_friend_label.setFont(new Font("Segoe UI", 1, 18));

        username_value_label.setFont(new Font("Segoe UI", 0, 18));
        fullname_value_label.setFont(new Font("Segoe UI", 0, 18));
        address_value_label.setFont(new Font("Segoe UI", 0, 18));
        birthdate_value_label.setFont(new Font("Segoe UI", 0, 18));
        gender_value_label.setFont(new Font("Segoe UI", 0, 18));
        email_value_label.setFont(new Font("Segoe UI", 0, 18));
        num_of_friend_value_label.setFont(new Font("Segoe UI", 0, 18));

        JButton manage_button = new JButton("Manage");
        manage_button.setBackground(new Color(153, 204, 255));
        manage_button.setFont(new Font("Segoe UI", 1, 18));
        manage_button.setForeground(new Color(255, 255, 255));
        
        main_panel.setBackground(new Color(255, 255, 255));
        main_panel.setRequestFocusEnabled(false);

        content_side.setBackground(new Color(255, 255, 255));
        JLabel password_label = new JLabel("Change password:");
        password_label.setFont(new Font("Segoe UI", 1, 18));

        JButton change_password_button = new JButton("Change");
        change_password_button.setBackground(new Color(153, 204, 255));
        change_password_button.setFont(new Font("Segoe UI", 1, 18));
        change_password_button.setForeground(new Color(255, 255, 255));

        change_password_button.addActionListener(e -> changePassword());

        GroupLayout content_sideLayout = new GroupLayout(content_side);
        content_side.setLayout(content_sideLayout);
        content_sideLayout.setHorizontalGroup(
                content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(content_sideLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(content_sideLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, content_sideLayout.createSequentialGroup()
                                                .addGap(0, 16, Short.MAX_VALUE)
                                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(username_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(fullname_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(address_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(birthdate_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(gender_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(email_label, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(num_friend_label, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(gender_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(birthdate_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(address_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(fullname_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(username_value_label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(email_value_label, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(num_of_friend_value_label, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20))))
                        .addGroup(GroupLayout.Alignment.TRAILING, content_sideLayout.createSequentialGroup()
                                .addComponent(manage_button)
                                .addGap(201, 201, 201))
                        .addGroup(GroupLayout.Alignment.TRAILING, content_sideLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(password_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(change_password_button)
                                .addGap(90, 90, 90))
        );
        content_sideLayout.setVerticalGroup(
                content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(content_sideLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(content_sideLayout.createSequentialGroup()
                                                .addComponent(username_value_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(fullname_value_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(address_value_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(birthdate_value_label)
                                                .addGap(17, 17, 17)
                                                .addComponent(gender_value_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(email_value_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(num_of_friend_value_label))
                                        .addGroup(content_sideLayout.createSequentialGroup()
                                                .addComponent(username_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(fullname_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(address_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(birthdate_label)
                                                .addGap(17, 17, 17)
                                                .addComponent(gender_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(email_label)
                                                .addGap(18, 18, 18)
                                                .addComponent(num_friend_label)))
                                .addGap(18, 18, 18)
                                .addComponent(manage_button)
                                .addGap(23, 23, 23)
                                .addGroup(content_sideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(password_label)
                                        .addComponent(change_password_button))
                                .addGap(30, 30, 30))
        );

        JScrollPane main_scroll = new JScrollPane(content_side);
        main_scroll.setBorder(null);

        GroupLayout main_panelLayout = new GroupLayout(main_panel);
        main_panel.setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
            main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(content_side, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        main_panelLayout.setVerticalGroup(
            main_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(main_panelLayout.createSequentialGroup()
                .addComponent(navigator, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addComponent(content_side, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension panelSize = main_panel.getPreferredSize();
        add(main_panel);
        setResizable(false);
        setLocation(600, 180);
        setSize(panelSize);
    }

    private void setupNavigatorLayout() {
        navigator = new JPanel();
        navigator.setBackground(new Color(153, 204, 255));
        navigator.setPreferredSize(new Dimension(400, 70));

        JLabel title = new JLabel("Personal Profile");
        title.setFont(new Font("Segoe UI", 1, 24));
        title.setForeground(new Color(255, 255, 255));

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(title)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addContainerGap(8, Short.MAX_VALUE))
        );

    }
    
    private void changePassword() {}

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new profileWindow(1).setVisible(true));
    }
}