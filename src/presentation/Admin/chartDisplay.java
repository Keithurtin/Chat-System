package Admin;

import java.awt.*;
import java.util.Map;
import javax.swing.*;

public class chartDisplay extends JPanel {
    private final Map<String, Integer> data;
    private final String year;
    private final String label;

    public chartDisplay(String year, Map<String, Integer> input_data, boolean isRegister) {
        this.year = year;
        data = input_data;
        label = isRegister?"Registrations": "Active Users";
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        
        g.setFont(new Font("Segoe UI", Font.BOLD, 18));
        g.drawString(label + " Chart for " + year, width / 2 - 100, 30);

        g.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        g.drawString("Months", width / 2 - 20, height - 10);
        g.drawString(label, 10, 40);

        int topMargin = 50;
        int leftMargin = 40;
        int bottomMargin = 40;
        int rightMargin = 20;

        int chartHeight = height - topMargin - bottomMargin;
        int chartWidth = width - leftMargin - rightMargin;

        g.drawLine(leftMargin, topMargin, leftMargin, height - bottomMargin);
        g.drawLine(leftMargin, height - bottomMargin, width - rightMargin, height - bottomMargin);

        int barWidth = chartWidth / data.size() - 10;
        int maxRegistration = data.values().stream().max(Integer::compareTo).orElse(200);

        int x = leftMargin + 10;
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            String month = entry.getKey();
            int registrations = entry.getValue();

            int barHeight = (int) ((double) registrations / maxRegistration * chartHeight);

            g.setColor(new Color(100, 150, 250));
            g.fillRect(x, height - bottomMargin - barHeight, barWidth, barHeight);

            g.setColor(Color.BLACK);
            g.drawString(month, x + (barWidth / 2) - 10, height - bottomMargin + 20);

            g.drawString(String.valueOf(registrations), x + (barWidth / 2) - 10, height - bottomMargin - barHeight - 5);

            x += barWidth + 10;
        }
    }
}
