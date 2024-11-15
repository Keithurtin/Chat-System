import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class new_register_demo extends JFrame {
    DefaultTableModel tableModel;
    JTable table;
    JScrollPane table_scroll;
    JPanel navigator;

    public new_register_demo() {
        setTitle("User Registration List");
        setSize(600, 400);
        setLocation(450, 170);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setupNavigatorLayout();
        createTableLayout();

        add(navigator, BorderLayout.NORTH);
        add(table_scroll, BorderLayout.CENTER);
    }

    private void setupNavigatorLayout() {
        navigator = new JPanel();
        navigator.setBackground(new Color(153, 204, 255));
        JLabel title = new JLabel("New Register Menu");
        title.setFont(new Font("Segoe UI", 1, 24));
        title.setForeground(Color.WHITE);

        JButton chart_review = new JButton("Chart");
        chart_review.setFont(new java.awt.Font("Segoe UI", 1, 14));

        JPopupMenu year_menu = new JPopupMenu();

        JMenuItem year1 = new JMenuItem("2024");

        year1.addActionListener(e -> openChartView(year1.getText(), null));

        year_menu.add(year1);

        chart_review.addActionListener(e -> year_menu.show(chart_review, 0, chart_review.getHeight()));

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
            navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                        .addComponent(chart_review, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                        .addComponent(sortLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sort_options, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_button)
                        .addGap(66, 66, 66))))
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chart_review)
                    .addComponent(title))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortLabel)
                    .addComponent(sort_options)
                    .addComponent(search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(search_button, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
    }

    private void createTableLayout() {
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Index", "Username", "Register Date"});
        table = new JTable(tableModel);

        table.setRowHeight(30);

        table.getColumnModel().getColumn(0).setPreferredWidth(90);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        table_scroll = new JScrollPane(table);

        addRowToTable("1", "Username1", "11/02/2004");
        addRowToTable("2", "Username2", "12/04/2004");
    }

    private void addRowToTable(String stt, String username, String date) {
        tableModel.addRow(new Object[]{stt, username, date});
    }

    private Map<String, Integer> generateExampleData() {
        Map<String, Integer> data = new HashMap<>();
        data.put("Jan", 120);
        data.put("Feb", 80);
        data.put("Mar", 150);
        data.put("Apr", 90);
        data.put("May", 130);
        data.put("Jun", 170);
        data.put("Jul", 160);
        data.put("Aug", 140);
        data.put("Sep", 180);
        data.put("Oct", 110);
        data.put("Nov", 190);
        data.put("Dec", 200);
        return data;
    }

    private void openChartView(String year, Map<String, Integer> data) {
        JFrame chartFrame = new JFrame("Registration Chart Year " + year);
        chartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        chartFrame.setSize(800, 600);
        if(data == null){
            data = generateExampleData();
        }
        chart_panel_demo chartPanel = new chart_panel_demo(year, data, true);
        chartFrame.add(chartPanel);
        chartFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new_register_demo frame = new new_register_demo();
            frame.setVisible(true);
        });
    }
}
