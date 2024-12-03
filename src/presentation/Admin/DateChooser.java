package Admin;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class DateChooser extends JPanel {
    private JTextField dateField;
    private JButton pickerButton;
    private JPopupMenu popupMenu;
    private JSpinner dateSpinner;

    public DateChooser() {
        setLayout(new BorderLayout());

        // Date Field
        dateField = new JTextField(10);
        dateField.setEditable(false);
        dateField.setHorizontalAlignment(JTextField.CENTER);

        // Picker Button
        pickerButton = new JButton("...");
        pickerButton.setMargin(new Insets(0, 5, 0, 5));

        popupMenu = new JPopupMenu();

        SpinnerDateModel model = new SpinnerDateModel();
        dateSpinner = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
        dateSpinner.setEditor(editor);

        JButton selectButton = new JButton("Select");
        selectButton.addActionListener(e -> {
            Date selectedDate = (Date) dateSpinner.getValue();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            dateField.setText(formatter.format(selectedDate));
            popupMenu.setVisible(false);
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> popupMenu.setVisible(false));

        JPanel spinnerPanel = new JPanel();
        spinnerPanel.setLayout(new BorderLayout());
        spinnerPanel.add(dateSpinner, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(cancelButton);
        buttonPanel.add(selectButton);

        JPanel popupPanel = new JPanel();
        popupPanel.setLayout(new BorderLayout());
        popupPanel.add(spinnerPanel, BorderLayout.CENTER);
        popupPanel.add(buttonPanel, BorderLayout.SOUTH);

        popupMenu.add(popupPanel);

        pickerButton.addActionListener(e -> {
            popupMenu.show(pickerButton, 0, pickerButton.getHeight());
        });

        add(dateField, BorderLayout.CENTER);
        add(pickerButton, BorderLayout.EAST);
    }

    public String getSelectedDate() {
        return dateField.getText();
    }
}
