package Admin;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import dto.*;
import bus.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class newUsersManage extends JFrame {
    DefaultTableModel tableModel;
    JTable table;
    JScrollPane table_scroll;
    JPanel navigator;
    List<UsersDTO> currentList;

    public static void main(String[] args) {
        JFrame newWindow = new newUsersManage();
        newWindow.setResizable(false);
        newWindow.setLocation(480, 190);
        newWindow.setVisible(true);
    }

    public newUsersManage() {
        setTitle("User Registration List");
        setSize(600, 400);
        setLocation(450, 170);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

    JButton chart_button = new JButton("Chart");
    chart_button.setFont(new Font("Segoe UI", 1, 14));

    JPopupMenu year_menu = new JPopupMenu();

    JMenuItem year1 = new JMenuItem("2024");
    year1.addActionListener(e -> openChartView(year1.getText(), null));
    year_menu.add(year1);
    chart_button.addActionListener(e -> year_menu.show(chart_button, 0, chart_button.getHeight()));

    JLabel fromLabel = new JLabel("From:");
    fromLabel.setFont(new Font("Segoe UI", 1, 14));
    fromLabel.setForeground(Color.WHITE);

    JLabel toLabel = new JLabel("To:");
    toLabel.setFont(new Font("Segoe UI", 1, 14));
    toLabel.setForeground(Color.WHITE);

    JDateChooser fromDateChooser = new JDateChooser();
    JDateChooser toDateChooser = new JDateChooser();

    JButton search_button = new JButton("Filter");
    search_button.setFont(new Font("Segoe UI", 1, 14));

    JTextField search_input = new JTextField("");
    search_input.setFont(new Font("Segoe UI", 0, 14));

    search_button.addActionListener(e -> {
        String username = search_input.getText();
        Date fromDate = fromDateChooser.getDate();
        LocalDateTime from = getStartOfDay(fromDate);
        Date toDate = toDateChooser.getDate();
        LocalDateTime to = getEndOfDay(toDate);

        UsersBUS usersBUS = new UsersBUS();
        currentList = usersBUS.filterByUsername(usersBUS.getByRegisterTime(from, to), username);
        tableModel.setRowCount(0);
        loadTable(currentList);
    });
    
    JButton sort_button = new JButton("Sort");
    sort_button.setFont(new Font("Segoe UI", 1, 14));

    JPopupMenu sort_menu = new JPopupMenu();

    JMenuItem ByName = new JMenuItem("By Name");
    JMenuItem ByTime = new JMenuItem("By Time");
    ByName.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tableModel.setRowCount(0);
            currentList.sort((o1, o2) -> o1.getuName().compareTo(o2.getuName()));
            loadTable(currentList);
        }
    }); //function
    ByTime.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tableModel.setRowCount(0);
            currentList.sort((o1, o2) -> o2.getCreateTime().compareTo(o1.getCreateTime()));
            loadTable(currentList);
        }
    });


    sort_menu.add(ByName);
    sort_menu.add(ByTime);

    sort_button.addActionListener(e -> sort_menu.show(sort_button, 0, sort_button.getHeight()));

    GroupLayout navigatorLayout = new GroupLayout(navigator);
    navigator.setLayout(navigatorLayout);
    navigatorLayout.setHorizontalGroup(
        navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addContainerGap(80, 80)
                .addGroup(navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                        .addContainerGap(20, 40)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, navigatorLayout.createSequentialGroup()
                        .addContainerGap(20, 40)
                        .addComponent(fromLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(toLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, navigatorLayout.createSequentialGroup()
                        .addComponent(sort_button, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chart_button, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_button))))
    );
    navigatorLayout.setVerticalGroup(
        navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fromLabel)
                    .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toLabel)
                    .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sort_button, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chart_button, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(search_button, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(10, 10, 10))
    );
}

    public static LocalDateTime getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static LocalDateTime getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    private void createTableLayout() {
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Username", "Register Date"});
        table = new JTable(tableModel);

        table.setRowHeight(30);

        table.getColumnModel().getColumn(0).setPreferredWidth(90);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        table_scroll = new JScrollPane(table);
        UsersBUS usersBUS = new UsersBUS();
        currentList = usersBUS.getAll();
        loadTable(currentList);
    }

    private void loadTable(List<UsersDTO> users) {
        tableModel.setRowCount(0);
        for (UsersDTO user : users) {
            addRowToTable(user.getuID(), user.getuName(), user.getCreateTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
        }
    }

    private void addRowToTable(int uID, String username, String date) {
        tableModel.addRow(new Object[]{uID, username, date});
    }

    private Map<String, Integer> generateData(String year) {
        UsersBUS usersBUS = new UsersBUS();
        List<Integer> list = usersBUS.countByRegisterYear(Integer.parseInt(year));
        Map<String, Integer> data = new LinkedHashMap<>();
        data.put("Jan", list.get(1));
        data.put("Feb", list.get(2));
        data.put("Mar", list.get(3));
        data.put("Apr", list.get(4));
        data.put("May", list.get(5));
        data.put("Jun", list.get(6));
        data.put("Jul", list.get(7));
        data.put("Aug", list.get(8));
        data.put("Sep", list.get(9));
        data.put("Oct", list.get(10));
        data.put("Nov", list.get(11));
        data.put("Dec", list.get(12));
        return data;
    }

    private void openChartView(String year, Map<String, Integer> data) {
        JFrame chartFrame = new JFrame("Registration Chart Year " + year);
        chartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        chartFrame.setSize(800, 600);
        data = generateData(year);
        JPanel chartPanel = new Admin.chartDisplay(year, data, true);
        chartFrame.add(chartPanel);
        chartFrame.setVisible(true);
    }
}
