import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JTextArea fortuneDisplay;
    private ArrayList<String> fortunes;
    private int lastIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setLayout(new BorderLayout());

        // Top Panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel("Fortune Teller", SwingConstants.CENTER);
        ImageIcon fortuneTellerImage = new ImageIcon("fortuneteller.png"); // Replace with your image file path
        JLabel imageLabel = new JLabel(fortuneTellerImage, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        topPanel.add(titleLabel, BorderLayout.NORTH);
        topPanel.add(imageLabel, BorderLayout.CENTER);

        // Middle Panel
        fortuneDisplay = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(fortuneDisplay);
        fortuneDisplay.setFont(new Font("SansSerif", Font.PLAIN, 16));
        fortuneDisplay.setEditable(false);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        JButton readButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");
        bottomPanel.add(readButton);
        bottomPanel.add(quitButton);

        // Add components to the main frame
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Create fortunes
        fortunes = new ArrayList<>();
        fortunes.add("Fortune 1: Your lucky number is 7.");
        fortunes.add("Fortune 2: Expect good news today.");
        fortunes.add("Fortune 3: You will meet someone special soon.");
        fortunes.add("Fortune 4: A surprise is waiting for you.");
        fortunes.add("Fortune 5: Success is on the horizon.");
        fortunes.add("Fortune 6: Your hard work will pay off.");
        fortunes.add("Fortune 7: Travel plans will bring joy.");
        fortunes.add("Fortune 8: Embrace new opportunities.");
        fortunes.add("Fortune 9: Stay positive and good things will come.");
        fortunes.add("Fortune 10: Love and happiness will fill your life.");
        fortunes.add("Fortune 11: Your creativity will shine.");
        fortunes.add("Fortune 12: Trust your instincts.");


        readButton.addActionListener(e -> displayRandomFortune());
        quitButton.addActionListener(e -> System.exit(0));

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        centerOnScreen();
    }

    private void displayRandomFortune() {
        int newIndex;
        do {
            newIndex = new Random().nextInt(fortunes.size());
        } while (newIndex == lastIndex);

        fortuneDisplay.append(fortunes.get(newIndex) + "\n");
        lastIndex = newIndex;
    }

    private void centerOnScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.getWidth() * 0.75);
        int height = (int) (screenSize.getHeight() * 0.75);
        setLocation((screenSize.width - width) / 2, (screenSize.height - height) / 2);
        setSize(width, height);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame frame = new FortuneTellerFrame();
            frame.setVisible(true);
        });
    }
}
