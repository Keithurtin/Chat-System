
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class spam_menu_demo extends JFrame {

    private JPanel menu;
    private JPanel navigator;
    private JScrollPane table_scroll;
    private JTable table;
    private DefaultTableModel tableModel;

    public spam_menu_demo() {
        initComponents();
    }

    private void initComponents() {
        menu = new JPanel();
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
        JComboBox<String> sort_options = new JComboBox<>(new String[]{"Name", "Registration Date"});

        sort_options.addActionListener(e -> {
            String selectedOption = (String) sort_options.getSelectedItem();
            System.out.println("Sorting by: " + selectedOption);
        });

        sort_options.setFont(new java.awt.Font("Segoe UI", 0, 14));

        JButton search_button = new JButton("Search");
        search_button.setFont(new java.awt.Font("Segoe UI", 1, 14));

        JTextField search_input = new JTextField("Search");
        search_input.setFont(new java.awt.Font("Segoe UI", 0, 14));

        search_button.addActionListener(e -> {
            String filterText = search_input.getText();
            System.out.println("Filtering by name: " + filterText);
        });

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
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"STT", "Username", "Status", "Ban", "Reject"});
        table = new JTable(tableModel);

        table.setRowHeight(30);

        table.getColumnModel().getColumn(0).setPreferredWidth(90);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());

        table.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JButton("Ban")));
        table.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JButton("Reject")));

        table_scroll.setViewportView(table);

        // Add sample data
        addRowToTable("1", "Username1", "On");
        addRowToTable("2", "Username2", "Off");
    }

    private void addRowToTable(String stt, String username, String status) {
        tableModel.addRow(new Object[]{stt, username, status, "Ban", "Reject"});
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

    class ButtonEditor extends AbstractCellEditor implements javax.swing.table.TableCellEditor, ActionListener {

        private final JButton button;
        private String label;

        public ButtonEditor(JButton button) {
            this.button = button;
            button.addActionListener(this);
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

        @Override
        public void actionPerformed(ActionEvent e) {
            fireEditingStopped();
            System.out.println("Button clicked in row " + table.getSelectedRow() + ", column " + table.getSelectedColumn());
            // Handle the button click here
            if (table.getSelectedColumn() == 3) {
                System.out.println("Ban button clicked.");
            } else if (table.getSelectedColumn() == 4) {
                System.out.println("Reject button clicked.");
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            spam_menu_demo frame = new spam_menu_demo();
            frame.setVisible(true);
        });
    }
}
