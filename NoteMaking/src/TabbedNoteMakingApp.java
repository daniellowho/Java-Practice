import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TabbedNoteMakingApp {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private JFileChooser fileChooser;

    private static final Color DARK_GRAY = new Color(40, 40, 40);
    private static final Color MEDIUM_GRAY = new Color(45, 45, 45);
    private static final Color LIGHT_GRAY = new Color(50, 50, 50);
    private static final Color SELECTION_COLOR = new Color(70, 130, 180);
    private static final Font BODY_FONT = new Font("Consolas", Font.PLAIN, 14);

    public TabbedNoteMakingApp() {
        frame = new JFrame("Tabbed Note Making App");
        tabbedPane = new JTabbedPane();
        fileChooser = new JFileChooser();

        setupGUI();
        addNewTab("Untitled");
    }

    private void setupGUI() {
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(DARK_GRAY);
        menuBar.setBorder(BorderFactory.createEmptyBorder());

        JMenu fileMenu = new JMenu("File");
        fileMenu.setForeground(Color.WHITE);
        fileMenu.add(createMenuItem("New Tab", e -> addNewTab("Untitled")));
        fileMenu.add(createMenuItem("Open", e -> openFile()));
        fileMenu.add(createMenuItem("Save", e -> saveFile()));

        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        tabbedPane.setBackground(DARK_GRAY);
        tabbedPane.setForeground(Color.WHITE);
        frame.add(tabbedPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private JMenuItem createMenuItem(String title, ActionListener action) {
        JMenuItem menuItem = new JMenuItem(title);
        menuItem.setForeground(Color.WHITE);
        menuItem.setBackground(LIGHT_GRAY);
        menuItem.addActionListener(action);
        return menuItem;
    }

    private void addNewTab(String title) {
        JTextPane textPane = createTextPane();
        JScrollPane scrollPane = new JScrollPane(textPane);
        tabbedPane.addTab(title, scrollPane);
    }

    private JTextPane createTextPane() {
        JTextPane textPane = new JTextPane();
        textPane.setFont(BODY_FONT);
        textPane.setBackground(MEDIUM_GRAY);
        textPane.setForeground(Color.WHITE);
        textPane.setCaretColor(Color.WHITE);
        textPane.setSelectionColor(SELECTION_COLOR);
        return textPane;
    }

    private void openFile() {
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                JTextPane textPane = createTextPane();
                textPane.setText(content.toString());
                tabbedPane.addTab(file.getName(), new JScrollPane(textPane));
            } catch (IOException e) {
                showError("Error opening file: " + e.getMessage());
            }
        }
    }

    private void saveFile() {
        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                JScrollPane scrollPane = (JScrollPane) tabbedPane.getSelectedComponent();
                JTextPane textPane = (JTextPane) scrollPane.getViewport().getView();
                writer.write(textPane.getText());
            } catch (IOException e) {
                showError("Error saving file: " + e.getMessage());
            }
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TabbedNoteMakingApp::new);
    }
}
