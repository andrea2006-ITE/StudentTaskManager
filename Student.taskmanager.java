import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentTaskManager {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginWindow());
    }
}

class LoginWindow extends JFrame {
    public LoginWindow() {
        setTitle("Student Task Manager - Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginBtn = new JButton("Login");

        loginBtn.addActionListener(e -> {
            dispose();
            new TaskManagerWindow();
        });

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel(""));
        panel.add(loginBtn);

        add(panel);
        setVisible(true);
    }
}

class TaskManagerWindow extends JFrame {
    private ArrayList<Task> tasks = new ArrayList<>();
    private DefaultListModel<String> taskListModel = new DefaultListModel<>();
    private JList<String> taskList = new JList<>(taskListModel);

    public TaskManagerWindow() {
        setTitle("Task Manager");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField taskInput = new JTextField(20);
        JButton addBtn = new JButton("Add Task");

        addBtn.addActionListener(e -> {
            String taskName = taskInput.getText();
            if (!taskName.isEmpty()) {
                Task newTask = new Task(taskName, "Pending");
                tasks.add(newTask);
                taskListModel.addElement(newTask.toString());
                taskInput.setText("");
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(taskInput);
        inputPanel.add(addBtn);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        setVisible(true);
    }
}

class Task {
    private String name;
    private String status;

    public Task(String name, String status) {
        this.name = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return name + " [" + status + "]";
    }
}
