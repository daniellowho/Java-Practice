import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NoteMakingApp {
    private JFrame frame;
    private JTextPane headingPane;
    private JTextPane bodyPane;
    private JFileChooser fileChooser;

    private static final Color DARK_GRAY = new Color(40, 40, 40);
    private static final Color MEDIUM_GRAY = new Color(45, 45, 45);
    private static final Color LIGHT_GRAY = new Color(50, 50, 50);
    private static final Color SELECTION_COLOR = new Color(70, 130, 180);
    private static final Font HEADING_FONT = new Font("Consolas", Font.BOLD, 20);
    private static final Font BODY_FONT = new Font("Consolas", Font.PLAIN, 14);
    private static final String BULLET = "\u2022 "; // Unicode for bullet character

    public NoteMakingApp() {
        frame = new JFrame("Note Making App");
        headingPane = createTextPane(HEADING_FONT, DARK_GRAY, Color.WHITE);
        bodyPane = createTextPane(BODY_FONT, MEDIUM_GRAY, Color.WHITE);
        fileChooser = new JFileChooser();

        setupTextPanes();
        setupGUI();
    }

    private JTextPane createTextPane(Font font, Color background, Color foreground) {
        JTextPane textPane = new JTextPane();
        textPane.setFont(font);
        textPane.setBackground(background);
        textPane.setForeground(foreground);
        textPane.setCaretColor(foreground);
        textPane.setSelectionColor(SELECTION_COLOR);
        return textPane;
    }

    private void setupTextPanes() {
        headingPane.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        headingPane.setText("Heading");
        headingPane.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (headingPane.getText().equals("Heading")) {
                    headingPane.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (headingPane.getText().trim().isEmpty()) {
                    headingPane.setText("Heading");
                }
            }
        });

        bodyPane.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        bodyPane.addKeyListener(createBulletKeyListener());
        headingPane.addKeyListener(createTabKeyListener(bodyPane));
        bodyPane.addKeyListener(createTabKeyListener(null));
    }

    private KeyAdapter createTabKeyListener(JTextPane nextPane) {
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    e.consume();
                    if (nextPane != null) {
                        nextPane.requestFocus();
                    } else {
                        bodyPane.replaceSelection("    "); // Insert spaces instead of tab
                    }
                }
            }
        };
    }

    private KeyAdapter createBulletKeyListener() {
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // Prevent default Enter behavior
                    handleBulletOrNumbering();
                }
            }
        };
    }

    private void handleBulletOrNumbering() {
        try {
            int caretPos = bodyPane.getCaretPosition();
            Document doc = bodyPane.getDocument();
            Element paragraph = doc.getDefaultRootElement().getElement(doc.getDefaultRootElement().getElementIndex(caretPos));
            int start = paragraph.getStartOffset();
            int end = paragraph.getEndOffset();
            String line = doc.getText(start, end - start).trim();

            if (line.startsWith("-")) {
                // Continue bullet list with "-"
                doc.insertString(caretPos, "\n- ", null);
            } else if (line.matches("^(\\d+)\\.$")) {
                // Detect numbers like "1.", "2." at the start of the line
                int num = Integer.parseInt(line.replace(".", ""));
                doc.insertString(caretPos, "\n" + (num + 1) + ". ", null);
            } else {
                // Just add a normal newline if no bullet or number found
                doc.insertString(caretPos, "\n", null);
            }
        } catch (BadLocationException e) {
            showError("Error handling bullets/numbers: " + e.getMessage());
        }
    }


    private void insertBullet() {
        try {
            Document doc = bodyPane.getDocument();
            int caretPosition = bodyPane.getCaretPosition();
            doc.insertString(caretPosition, BULLET, null);
            bodyPane.setCaretPosition(caretPosition + BULLET.length());
        } catch (BadLocationException e) {
            showError("Error inserting bullet: " + e.getMessage());
        }
    }

    private void setupGUI() {
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(frame.getWidth(), 35));
        menuBar.setBackground(DARK_GRAY);
        menuBar.setBorder(BorderFactory.createEmptyBorder());

        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(new Font("Lucida Console", Font.PLAIN, 14));
        fileMenu.setForeground(Color.WHITE);

        JMenuItem openItem = createMenuItem("Open", e -> openFile());
        JMenuItem saveItem = createMenuItem("Save", e -> saveFile());

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBackground(MEDIUM_GRAY);
        textPanel.add(headingPane, BorderLayout.NORTH);
        textPanel.add(bodyPane, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(textPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JMenuItem createMenuItem(String title, ActionListener action) {
        JMenuItem menuItem = new JMenuItem(title);
        menuItem.setForeground(Color.WHITE);
        menuItem.setBackground(LIGHT_GRAY);
        menuItem.addActionListener(action);
        return menuItem;
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
                bodyPane.setText(content.toString());
            } catch (IOException e) {
                showError("Error opening file: " + e.getMessage());
            }
        }
    }

    private void saveFile() {
        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(bodyPane.getText());
            } catch (IOException e) {
                showError("Error saving file: " + e.getMessage());
            }
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NoteMakingApp::new);
    }
}