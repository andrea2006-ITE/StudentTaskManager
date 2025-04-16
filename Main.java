import javax.swing.SwingUtilities;
import gui.LoginWindow; // or TaskManagerWindow if skipping login

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginWindow(); // Start with login screen
            // Or: new TaskManagerWindow(); if you want to skip login
        });
    }
}
