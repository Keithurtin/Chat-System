package component;

import com.toedter.calendar.JDateChooser;
import presentation.component.PlaceHolder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dto.*;
import bus.*;

public class activeUserManage extends JFrame {
    DefaultTableModel tableModel;
    JTable table;
    JScrollPane table_scroll;
    JPanel navigator;
    List<ActivityDTO> currentList;

    public activeUserManage() {
        setTitle("Active Users List");
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
    JLabel title = new JLabel("Active Users Menu");
    title.setFont(new Font("Segoe UI", 1, 24));
    title.setForeground(Color.WHITE);

    JButton chart_button = new JButton("Chart");
    chart_button.setFont(new java.awt.Font("Segoe UI", 1, 14));

    JPopupMenu year_menu = new JPopupMenu();

    JMenuItem year1 = new JMenuItem("2024");
    year1.addActionListener(e -> openChartView(year1.getText(), null));
    year_menu.add(year1);
    chart_button.addActionListener(e -> year_menu.show(chart_button, 0, chart_button.getHeight()));

    JLabel fromLabel = new JLabel("From:");
    fromLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
    fromLabel.setForeground(Color.WHITE);

    JLabel toLabel = new JLabel("To:");
    toLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
    toLabel.setForeground(Color.WHITE);

    JDateChooser fromDateChooser = new JDateChooser();
    JDateChooser toDateChooser = new JDateChooser();

    JButton search_button = new JButton("Filter");
    search_button.setFont(new java.awt.Font("Segoe UI", 1, 14));

    PlaceHolder search_input = new PlaceHolder("");
    search_input.setFont(new java.awt.Font("Segoe UI", 0, 14));

    JPopupMenu search_menu = new JPopupMenu();

    JMenuItem by_username = new JMenuItem("By Username");
    JMenuItem by_activities = new JMenuItem("By Activities (equal)");
    JMenuItem by_activities_more = new JMenuItem("By Activities (more)");
    JMenuItem by_activities_less = new JMenuItem("By Activities (less)");

    search_menu.add(by_username);
    search_menu.add(by_activities);
    search_menu.add(by_activities_more);
    search_menu.add(by_activities_less);

    by_username.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Date fromDate = fromDateChooser.getDate();
            LocalDateTime from = getStartOfDay(fromDate);
            Date toDate = toDateChooser.getDate();
            LocalDateTime to = getEndOfDay(toDate);

            String name = search_input.getText();
            ActivityBUS activityBUS = new ActivityBUS();
            currentList = activityBUS.filterByName(activityBUS.getByTime(from, to), name);
            loadTable(currentList);
        }
    });

    by_activities.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Date fromDate = fromDateChooser.getDate();
            LocalDateTime from = getStartOfDay(fromDate);
            Date toDate = toDateChooser.getDate();
            LocalDateTime to = getEndOfDay(toDate);

            int activities = Integer.parseInt(search_input.getText());
            ActivityBUS activityBUS = new ActivityBUS();
            currentList = activityBUS.filterByActivities(activityBUS.getByTime(from, to), activities, 0);
            loadTable(currentList);
        }
    });

    by_activities_more.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Date fromDate = fromDateChooser.getDate();
            LocalDateTime from = getStartOfDay(fromDate);
            Date toDate = toDateChooser.getDate();
            LocalDateTime to = getEndOfDay(toDate);

            int activities = Integer.parseInt(search_input.getText());
            ActivityBUS activityBUS = new ActivityBUS();
            currentList = activityBUS.filterByActivities(activityBUS.getByTime(from, to), activities, 1);
            loadTable(currentList);
        }
    });

    by_activities_less.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Date fromDate = fromDateChooser.getDate();
            LocalDateTime from = getStartOfDay(fromDate);
            Date toDate = toDateChooser.getDate();
            LocalDateTime to = getEndOfDay(toDate);

            int activities = Integer.parseInt(search_input.getText());
            ActivityBUS activityBUS = new ActivityBUS();
            currentList = activityBUS.filterByActivities(activityBUS.getByTime(from, to), activities, -1);
            loadTable(currentList);
        }
    });

    search_button.addActionListener(e -> search_menu.show(search_button, 0, search_button.getHeight()));

    GroupLayout navigatorLayout = new GroupLayout(navigator);
    navigator.setLayout(navigatorLayout);
    navigatorLayout.setHorizontalGroup(
        navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigatorLayout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navigatorLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, navigatorLayout.createSequentialGroup()
                        .addComponent(fromLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(toLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, navigatorLayout.createSequentialGroup()
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
                    .addComponent(chart_button, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(search_button, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(10, 10, 10))
    );
}

    private void createTableLayout() {
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Username", "Open App", "Chat Friend", "Chat Group", "Last Active"});
        table = new JTable(tableModel);

        table.setRowHeight(30);

        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);
        table.getColumnModel().getColumn(3).setPreferredWidth(90);
        table.getColumnModel().getColumn(4).setPreferredWidth(90);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

        table_scroll = new JScrollPane(table);

        ActivityBUS activityBUS = new ActivityBUS();
        currentList = activityBUS.getAll();
        loadTable(currentList);
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

    private void loadTable(List<ActivityDTO> list) {
        tableModel.setRowCount(0);
        for (ActivityDTO activity : list) {
            if (activity.getLastActive() != null) {
                addRowToTable(activity.getuID(), activity.getUsername(), activity.getOpenApp(), activity.getChatDM(), activity.getChatGroup(), activity.getLastActive().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
            }
        }
    }

    private void addRowToTable(int uID, String username, int open_app, int chat_friend, int chat_group, String last_active) {
        tableModel.addRow(new Object[]{uID, username, open_app, chat_friend, chat_group, last_active});
    }

    private Map<String, Integer> generateData(String year) {
        ActivityBUS activityBUS = new ActivityBUS();
        List<Integer> list = activityBUS.countByYear(Integer.parseInt(year));
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
        JPanel chartPanel = new component.chartDisplay(year, data, false);
        chartFrame.add(chartPanel);
        chartFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            activeUserManage frame = new activeUserManage();
            frame.setVisible(true);
        });
    }
}
