import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class LoginFrame extends JFrame implements ActionListener{

    Container c_094;
    JLabel nameLabel_094, forgotLabel_094;
    JTextField username_094;
    JPasswordField password_094;
    JButton submitBtn_094, regBtn_094;
    String usr_094;
    private boolean verifyLogin(String username_094, String password_094) {
        File file_094 = new File("resources/data/users.csv");
        if (!file_094.exists()) {
            JOptionPane.showMessageDialog(this, "No users registered yet.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try (BufferedReader br_094 = new BufferedReader(new FileReader(file_094))) {
            String line_094;
            while ((line_094 = br_094.readLine()) != null) {
                // CSV format: name,gender,city,user,address,password
                String[] parts_094 = line_094.split(",", -1); // -1 to include trailing empty strings if any
                if (parts_094.length >= 6) {
                    String fileUsername_094 = parts_094[3].trim();
                    String filePassword_094 = parts_094[5].trim();
                    if (username_094.equals(fileUsername_094) && password_094.equals(filePassword_094)) {
                        usr_094 = fileUsername_094;
                        return true;  // Found matching user & password
                    }
                }
            }
        } catch (Exception e_094) {
            e_094.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading user app/data.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return false; 
    }

    LoginFrame() {
        this.setTitle("Login");
        this.setSize(430, 320);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        ImageIcon image_094 = new ImageIcon("app/images/login.png");
        this.setIconImage(image_094.getImage());
        c_094 = getContentPane();
        c_094.setLayout(null); 
        c_094.setBackground(new Color(230, 242, 255)); 
        
        Font fn_094 = new Font("Consolas",Font.PLAIN,14);
        Border border_094 = new LineBorder(Color.darkGray, 2, true);

        nameLabel_094 = new JLabel("Ticket Booking System");
        nameLabel_094.setBounds(80, 30, 280, 30);
        nameLabel_094.setForeground(Color.decode("#008CBA"));
        nameLabel_094.setFont(new Font("Consolas",Font.BOLD,22));
        c_094.add(nameLabel_094);

        username_094 = new JTextField();
        username_094.setBounds(90, 80, 240, 35);
        username_094.setText("username");
        username_094.setForeground(Color.black);
        username_094.setBackground(new Color(245, 245, 245));
        username_094.setFont(fn_094);
        username_094.setCaretColor(Color.black);
        username_094.setBorder(border_094);
        c_094.add(username_094);
  
        password_094 = new JPasswordField();
        password_094.setBounds(90, 125, 240, 35);
        password_094.setText("password");
        password_094.setForeground(Color.black);
        password_094.setBackground(new Color(245, 245, 245));
        password_094.setFont(fn_094);
        password_094.setCaretColor(Color.black);
        password_094.setBorder(border_094);
        c_094.add(password_094);

        forgotLabel_094 = new JLabel("Forgot your password?");
        forgotLabel_094.setBounds(90, 165, 200, 12);
        forgotLabel_094.setForeground(Color.GRAY);
        forgotLabel_094.setFont(new Font("Consolas",Font.BOLD,10));
        c_094.add(forgotLabel_094);

        submitBtn_094 = new JButton("Login");
        submitBtn_094.setFont(new Font("Consolas",Font.BOLD,14));
        submitBtn_094.setBounds(85, 200, 115, 35);
        submitBtn_094.setBackground(Color.decode("#15A3C7"));
        submitBtn_094.setForeground(Color.WHITE);
        submitBtn_094.setFocusPainted(false);
        submitBtn_094.setBorder(new LineBorder(Color.decode("#15A3C7"), 1, true));
        submitBtn_094.addActionListener(this);
        c_094.add(submitBtn_094);

        regBtn_094 = new JButton("Register");
        regBtn_094.setFont(new Font("Consolas",Font.BOLD,14));
        regBtn_094.setBounds(210, 200, 115, 35);
        regBtn_094.setBackground(Color.WHITE);
        regBtn_094.setForeground(Color.decode("#15A3C7"));
        regBtn_094.setFocusPainted(false);
        regBtn_094.setBorder(new LineBorder(Color.decode("#15A3C7"), 1, true));
        regBtn_094.addActionListener(this);
        c_094.add(regBtn_094);

        JLabel footer = new JLabel("Developed by @enayethussain");
        footer.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        footer.setForeground(Color.decode("#15A3C7"));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        footer.setBounds(120, 250, 200, 30);
        c_094.add(footer);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e_094){
        if (e_094.getSource() == submitBtn_094) {
            String user_094 = username_094.getText().trim();
            String pass_094 = new String(password_094.getPassword());

            if (verifyLogin(user_094, pass_094)) {
                this.dispose();
                new HomeFrame(usr_094);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password!", "Login Failed", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e_094.getSource()==regBtn_094){
            this.dispose();
            new RegisterFrame();
        }
    }
}
