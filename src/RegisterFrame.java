import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class RegisterFrame extends JFrame implements ActionListener {

    Container c_094;
    JLabel titleLabel_094,nameLabel_094, genderLabel_094, cityLabel_094, userLabel_094, addressLabel_094, passLabel_094;
    JTextField nameField_094, userField_094;
    JPasswordField passField_094;
    JRadioButton male_094, female_094;
    ButtonGroup genderGroup_094;
    JComboBox<String> cityBox_094;
    JButton submitBtn_094, resetBtn_094;
    JTextArea addressArea_094;
    JCheckBox termsCheckbox_094;
    
    private void saveUserDataToCSV(String name_094, String gender_094, String city_094, String user_094, String address_094, String password_094) {
        File file_094 = new File("resources/data/users.csv");
        try (BufferedWriter bw_094 = new BufferedWriter(new FileWriter(file_094, true))) {  // append mode
            name_094 = name_094.replace(",", " ");
            gender_094 = gender_094.replace(",", " ");
            city_094 = city_094.replace(",", " ");
            user_094 = user_094.replace(",", " ");
            address_094 = address_094.replace(",", " ");
            password_094 = password_094.replace(",", " ");
            
            String line_094 = String.join(",", name_094, gender_094, city_094, user_094, address_094, password_094);
            bw_094.write(line_094);
            bw_094.newLine();
        } catch (IOException ex_094) {
            ex_094.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving user data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    RegisterFrame() {
        this.setTitle("User Registration");
        this.setSize(420, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        ImageIcon image_094 = new ImageIcon("resources/images/registration.png");
        this.setIconImage(image_094.getImage());
        this.setResizable(false);

        c_094 = getContentPane();
        c_094.setLayout(null);
        c_094.setBackground(new Color(230, 242, 255)); // same as login page

        Font fn_094 = new Font("Consolas", Font.PLAIN, 14);
        Border border_094 = new LineBorder(Color.darkGray, 2, true);


        titleLabel_094 = new JLabel("Ticket Booking System");
        titleLabel_094.setBounds(90, 20, 300, 30);
        titleLabel_094.setForeground(Color.decode("#008CBA"));
        titleLabel_094.setFont(new Font("Consolas", Font.BOLD, 20));
        c_094.add(titleLabel_094);
        // --- Name ---
        nameLabel_094 = new JLabel("Name:");
        nameLabel_094.setBounds(50, 60, 100, 30);
        nameLabel_094.setForeground(Color.BLACK);
        nameLabel_094.setFont(fn_094);
        c_094.add(nameLabel_094);

        nameField_094 = new JTextField();
        nameField_094.setBounds(150, 60, 200, 30);
        nameField_094.setForeground(Color.BLACK);
        nameField_094.setBackground(new Color(245, 245, 245));
        nameField_094.setFont(fn_094);
        nameField_094.setCaretColor(Color.BLACK);
        nameField_094.setBorder(border_094);
        c_094.add(nameField_094);

        // --- Gender ---
        genderLabel_094 = new JLabel("Gender:");
        genderLabel_094.setBounds(50, 100, 100, 30);
        genderLabel_094.setForeground(Color.BLACK);
        genderLabel_094.setFont(fn_094);
        c_094.add(genderLabel_094);

        male_094 = new JRadioButton("Male");
        male_094.setBounds(150, 100, 70, 30);
        female_094 = new JRadioButton("Female");
        female_094.setBounds(230, 100, 80, 30);
        male_094.setBackground(new Color(230, 242, 255));
        female_094.setBackground(new Color(230, 242, 255));
        male_094.setForeground(Color.BLACK);
        female_094.setForeground(Color.BLACK);
        male_094.setFont(fn_094);
        female_094.setFont(fn_094);

        genderGroup_094 = new ButtonGroup();
        genderGroup_094.add(male_094);
        genderGroup_094.add(female_094);
        c_094.add(male_094);
        c_094.add(female_094);

        // --- City ---
        cityLabel_094 = new JLabel("City:");
        cityLabel_094.setBounds(50, 140, 100, 30);
        cityLabel_094.setForeground(Color.BLACK);
        cityLabel_094.setFont(fn_094);
        c_094.add(cityLabel_094);

        String depts_094[] = { "Sylhet", "Rajshahi", "Dhaka", "Chittagong", "Khulna","Mymensingh","Cumilla","Rangpur"};
        cityBox_094 = new JComboBox<>(depts_094);
        cityBox_094.setBounds(150, 140, 200, 30);
        cityBox_094.setBackground(new Color(245, 245, 245));
        cityBox_094.setForeground(Color.BLACK);
        cityBox_094.setFont(fn_094);
        cityBox_094.setBorder(border_094);
        c_094.add(cityBox_094);

        // --- Username ---
        userLabel_094 = new JLabel("Username:");
        userLabel_094.setBounds(50, 190, 100, 30);
        userLabel_094.setForeground(Color.BLACK);
        userLabel_094.setFont(fn_094);
        c_094.add(userLabel_094);

        userField_094 = new JTextField();
        userField_094.setBounds(150, 190, 200, 30);
        userField_094.setForeground(Color.BLACK);
        userField_094.setBackground(new Color(245, 245, 245));
        userField_094.setFont(fn_094);
        userField_094.setCaretColor(Color.BLACK);
        userField_094.setBorder(border_094);
        c_094.add(userField_094);

        // --- Address ---
        addressLabel_094 = new JLabel("Address:");
        addressLabel_094.setBounds(50, 240, 100, 30);
        addressLabel_094.setForeground(Color.BLACK);
        addressLabel_094.setFont(fn_094);
        c_094.add(addressLabel_094);

        addressArea_094 = new JTextArea(3,20);
        addressArea_094.setBounds(150, 240, 200, 60);
        addressArea_094.setBackground(new Color(245, 245, 245));
        addressArea_094.setForeground(Color.BLACK);
        addressArea_094.setFont(fn_094);
        addressArea_094.setBorder(border_094);
        addressArea_094.setCaretColor(Color.BLACK);
        addressArea_094.setLineWrap(true);
        addressArea_094.setWrapStyleWord(true); 
        c_094.add(addressArea_094);

        // --- Password ---
        passLabel_094 = new JLabel("Password:");
        passLabel_094.setBounds(50, 320, 100, 30);
        passLabel_094.setForeground(Color.BLACK);
        passLabel_094.setFont(fn_094);
        c_094.add(passLabel_094);

        passField_094 = new JPasswordField();
        passField_094.setBounds(150, 320, 200, 30);
        passField_094.setForeground(Color.BLACK);
        passField_094.setBackground(new Color(245, 245, 245));
        passField_094.setFont(fn_094);
        passField_094.setCaretColor(Color.BLACK);
        passField_094.setBorder(border_094);
        c_094.add(passField_094);

        // --- Terms ---
        termsCheckbox_094 = new JCheckBox("I agree to all terms and conditions");
        termsCheckbox_094.setBounds(90, 360, 300, 30);
        termsCheckbox_094.setBackground(new Color(230, 242, 255));
        termsCheckbox_094.setForeground(Color.BLACK);
        termsCheckbox_094.setFont(new Font("Consolas",Font.BOLD,12));
        c_094.add(termsCheckbox_094);

        // --- Buttons ---
        submitBtn_094 = new JButton("Register");
        submitBtn_094.setFont(new Font("Consolas",Font.BOLD,14));
        submitBtn_094.setBounds(80, 410, 120, 35);
        submitBtn_094.setBackground(Color.decode("#15A3C7"));
        submitBtn_094.setForeground(Color.WHITE);
        submitBtn_094.setFocusPainted(false);
        submitBtn_094.setBorder(new LineBorder(Color.decode("#15A3C7"), 1, true));
        submitBtn_094.addActionListener(this);
        c_094.add(submitBtn_094);

        resetBtn_094 = new JButton("Reset");
        resetBtn_094.setFont(new Font("Consolas",Font.BOLD,14));
        resetBtn_094.setBounds(220, 410, 120, 35);
        resetBtn_094.setBackground(Color.WHITE);
        resetBtn_094.setForeground(Color.decode("#15A3C7"));
        resetBtn_094.setFocusPainted(false);
        resetBtn_094.setBorder(new LineBorder(Color.decode("#15A3C7"), 1, true));
        resetBtn_094.addActionListener(this);
        c_094.add(resetBtn_094);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e_094) {
        if (e_094.getSource() == submitBtn_094) {
            String name_094 = nameField_094.getText().trim();
            String gender_094 = male_094.isSelected() ? "Male" : (female_094.isSelected() ? "Female" : "");
            String city_094 = (String) cityBox_094.getSelectedItem();
            String user_094 = userField_094.getText().trim();
            String password_094 = new String(passField_094.getPassword());
            String address_094 = addressArea_094.getText().trim();

            boolean acceptedTerms_094 = termsCheckbox_094.isSelected();

            if (!acceptedTerms_094) {
                JOptionPane.showMessageDialog(this, "You must accept terms to submit.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            saveUserDataToCSV(name_094, gender_094, city_094, user_094, address_094, password_094);

            JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

            new LoginFrame();
            this.dispose();

        } else if (e_094.getSource() == resetBtn_094) {
            nameField_094.setText("");
            genderGroup_094.clearSelection();
            cityBox_094.setSelectedIndex(0);
            userField_094.setText("");
            passField_094.setText("");
            addressArea_094.setText("");
            termsCheckbox_094.setSelected(false);
        }
    }
}
