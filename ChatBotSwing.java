package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatBotSwing extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public ChatBotSwing() {
        setTitle("SpaceBot - Powered by GPT");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/space.jpg")));
        background.setLayout(new BorderLayout());
        setContentPane(background);

        
        chatArea = new JTextArea();
        chatArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        chatArea.setBackground(new Color(10, 10, 30, 180));
        chatArea.setForeground(Color.GREEN);
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        // Input
        inputField = new JTextField();
        sendButton = new JButton("Send");
        sendButton.setBackground(Color.DARK_GRAY);
        sendButton.setForeground(Color.CYAN);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setOpaque(false);
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        background.add(scrollPane, BorderLayout.CENTER);
        background.add(inputPanel, BorderLayout.SOUTH);

        
        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());
    }

    private void sendMessage() {
        String userText = inputField.getText().trim();
        if (!userText.isEmpty()) {
            chatArea.append("🧑 You: " + userText + "\n");
            inputField.setText("");

            new Thread(() -> {
                try {
                	 String response = BotResponder.askGPT(userText);  
                     SwingUtilities.invokeLater(() -> {
                         chatArea.append("🤖 SpaceBot: " + response + "\n\n");
                         chatArea.setCaretPosition(chatArea.getDocument().getLength());
                    });
                } catch (Exception e) {
                	e.printStackTrace();
                    chatArea.append("🤖 SpaceBot: Sorry, there was an error.\n\n");
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChatBotSwing bot = new ChatBotSwing();
            bot.setVisible(true);
        });
    }
}

