import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SortedListGUI extends JFrame {
    private SortedList sortedList = new SortedList();
    private JTextArea textArea = new JTextArea(10, 30);
    private JTextField inputField = new JTextField(15);
    private JTextField searchField = new JTextField(15);

    public SortedListGUI() {
        setTitle("Sorted List GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");

        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(new JLabel("Enter string:"));
        add(inputField);
        add(addButton);
        add(new JLabel("Search string:"));
        add(searchField);
        add(searchButton);
        add(scrollPane);

        addButton.addActionListener(e -> {
            String text = inputField.getText().trim();
            if (!text.isEmpty()) {
                sortedList.add(text);
                inputField.setText("");
                displayList("Added \"" + text + "\" to list.");
            }
        });

        searchButton.addActionListener(e -> {
            String text = searchField.getText().trim();
            if (!text.isEmpty()) {
                int result = sortedList.search(text);
                if (result >= 0) {
                    displayList("Found \"" + text + "\" at index " + result + ".");
                } else {
                    int insertionPoint = -result - 1;
                    displayList("\"" + text + "\" not found. Would be at index " + insertionPoint + ".");
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void displayList(String message) {
        textArea.setText(message + "\n\nCurrent Sorted List:\n" + sortedList.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SortedListGUI::new);
    }
}
