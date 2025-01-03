package Admin;

import dto.SpamDTO;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import dto.*;
import bus.*;

import static Admin.adminMenu.reloadAdminTable;

public class spamManage extends JFrame {
    private JPanel navigator;
    private JScrollPane table_scroll;
    private JTable table;
    private DefaultTableModel tableModel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            spamManage frame = new spamManage();
            frame.setVisible(true);
        });
    }

    public spamManage() {
        initComponents();
    }

    private void initComponents() {
        JPanel menu = new JPanel();
        navigator = new JPanel();
        table_scroll = new JScrollPane();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setPreferredSize(new java.awt.Dimension(620, 500));

        setupNavigatorLayout();
        createTableLayout();

        GroupLayout admin_menuLayout = new GroupLayout(menu);
        menu.setLayout(admin_menuLayout);
        admin_menuLayout.setHorizontalGroup(
                admin_menuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(navigator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(table_scroll, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );
        admin_menuLayout.setVerticalGroup(
                admin_menuLayout.createSequentialGroup()
                        .addComponent(navigator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(table_scroll, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(menu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(menu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        setResizable(false); 
        setLocation(400, 150);
        pack();
    }

    private void setupNavigatorLayout() {
        navigator = new JPanel();
        navigator.setBackground(new Color(153, 204, 255));
        JLabel title = new JLabel("Spam Report Management");
        title.setFont(new Font("Segoe UI", 1, 24));
        title.setForeground(Color.WHITE);

        JLabel sortLabel = new JLabel("Sort by:");
        sortLabel.setFont(new java.awt.Font("Segoe UI", 1, 16));
        sortLabel.setForeground(new java.awt.Color(255, 255, 255));
        JComboBox<String> sort_options = new JComboBox<>(new String[]{"Name", "Time"});

        sort_options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                List<SpamDTO> list = null;
                SpamBUS spamBUS = new SpamBUS();
                String comp = (String) sort_options.getSelectedItem();
                if (comp == "Name") {
                    list = spamBUS.sortByName();
                } else list = spamBUS.sortReportTime();
                loadTable(list);
            }
        });

        sort_options.addActionListener(e -> {
            String selectedOption = (String) sort_options.getSelectedItem();
        });

        sort_options.setFont(new java.awt.Font("Segoe UI", 0, 14));

        JButton search_button = new JButton("Filter");
        search_button.setFont(new java.awt.Font("Segoe UI", 1, 14));

        JTextField search_input = new JTextField("");
        search_input.setFont(new java.awt.Font("Segoe UI", 0, 14));

        JPopupMenu search_menu = new JPopupMenu();

        JMenuItem by_username = new JMenuItem("By Username");
        JMenuItem by_time = new JMenuItem("By Time");

        search_menu.add(by_username);
        search_menu.add(by_time);

        by_username.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = search_input.getText();
                tableModel.setRowCount(0);
                SpamBUS spamBUS = new SpamBUS();
                loadTable(spamBUS.getByName(name));
            }
        });

        by_time.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String time = search_input.getText();
                tableModel.setRowCount(0);
                SpamBUS spamBUS = new SpamBUS();
                loadTable(spamBUS.getByDate(time));
            }
        });

        search_button.addActionListener(e -> search_menu.show(search_button, 0, search_button.getHeight()));

        GroupLayout navigatorLayout = new GroupLayout(navigator);
        navigator.setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                        .addComponent(title, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                        .addComponent(sortLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sort_options, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(search_input, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_button)
                        .addGap(66, 66, 66))))
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(navigatorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sortLabel)
                    .addComponent(sort_options)
                    .addComponent(search_input, GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(search_button, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
    }

    private void createTableLayout() {
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Username", "Report Time", "Ban"});
        table = new JTable(tableModel);

        table.setRowHeight(30);

        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JButton("Ban")));

        table_scroll.setViewportView(table);

        SpamBUS spamBUS = new SpamBUS();
        loadTable(spamBUS.getAll());
    }

    private void loadTable(List<SpamDTO> list) {
        for (SpamDTO spam : list) {
            addRowToTable(spam.getuID(), spam.getuName(), spam.getReportTime());
        }
    }

    private void addRowToTable(int uID, String username, LocalDateTime reportTime) {
        tableModel.addRow(new Object[]{uID, username, reportTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")), "Ban"});
    }

    class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends AbstractCellEditor implements javax.swing.table.TableCellEditor {

        private final JButton button;
        private String label;

        public ButtonEditor(JButton button) {
            this.button = button;
            button.addActionListener(e -> {
                fireEditingStopped();
                int row = table.getSelectedRow();
                int id = (Integer) table.getValueAt(row, 0);
                int res = JOptionPane.showConfirmDialog(null, "Do you want to ban this user?", "Ban User", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    UsersBUS usersBUS = new UsersBUS();
                    if (usersBUS.banUser(id) == true) {
                        JOptionPane.showMessageDialog(null, "User banned successfully", "Success", JOptionPane.PLAIN_MESSAGE);
                        reloadAdminTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            });
        }

        @Override
        public java.awt.Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return label;
        }
    }
}
