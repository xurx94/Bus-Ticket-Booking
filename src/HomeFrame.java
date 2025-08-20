import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class HomeFrame extends JFrame implements ActionListener, ItemListener {

    Container c_094;

    JButton searchBtn_094,DashboardBtn_094, logoutBtn_094;
    JComboBox<String> pickup_094, destination_094, comfort_094, dayBox_094, monthBox_094, yearBox_094;
    JLabel from_094, to_094, dateLabel_094, type_094, titleLabel_094;
    String pickupPoint_094, destinationPoint_094, day_094, month_094, year_094, seatType_094,usr_094;

    private int checkAvaialableroutes(String pickup_094, String destination_094) {
        File file_094 = new File("resources/data/prices.csv");
        try(BufferedReader br_094 = new BufferedReader(new FileReader(file_094))) {
            String line_094;
            while ((line_094 = br_094.readLine()) != null) {
                String[] parts_094 = line_094.split(",", -1);
                if (parts_094.length >= 3) {
                    String filePickup_094 = parts_094[0].trim();
                    String fileDestination_094 = parts_094[1].trim();
                    if ((pickup_094.equals(filePickup_094)||pickup_094.equals(fileDestination_094)) && (destination_094.equals(fileDestination_094)||destination_094.equals(filePickup_094))) {
                        return 1;
                    }
                }
            }
        } catch (Exception e_094) {
            e_094.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading price data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0; 
    }
    HomeFrame(String usr_094) {
        this.setTitle("Ena Travels 2.0");
        this.setSize(330, 580); // bigger window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        ImageIcon image_094 = new ImageIcon("resources/images/bus.png");
        this.setIconImage(image_094.getImage());
        this.setResizable(false);
        c_094 = getContentPane();
        c_094.setLayout(null);
        c_094.setBackground(new Color(230, 242, 255));

        Font fnt_094 = new Font("Consolas", Font.BOLD, 15); // bigger font
        Border border_094 = new LineBorder(new Color(230, 242, 255), 2, true);
        this.usr_094 = usr_094;
        titleLabel_094 = new JLabel("Search Buses");
        titleLabel_094.setBounds(100, 10, 150, 30);
        titleLabel_094.setFont(new Font("Consolas", Font.BOLD, 21));
        titleLabel_094.setForeground(Color.decode("#15A3C7"));  
        c_094.add(titleLabel_094);

        from_094 = new JLabel();
        from_094.setBounds(30, 50, 150, 25);
        from_094.setText("Departure:");
        from_094.setFont(fnt_094);
        from_094.setBorder(border_094);
        c_094.add(from_094);

        pickup_094 = new JComboBox<>();
        pickup_094.addItem("Select Departure");
        pickup_094.addItem("Rajshahi");
        pickup_094.addItem("Dhaka");
        pickup_094.addItem("Khulna");
        pickup_094.addItem("Sylhet");
        pickup_094.addItem("Sreemangal");
        pickup_094.addItem("Chittagong");
        pickup_094.addItem("Cox's Bazar");
        pickup_094.addItem("Barisal");
        pickup_094.addItem("Mymensingh");
        pickup_094.addItem("Rangpur");

        pickup_094.setFont(fnt_094);
        pickup_094.addItemListener(this);
        pickup_094.setBounds(30, 80, 250, 35);
        pickup_094.setBorder(border_094);
        c_094.add(pickup_094);

        to_094 = new JLabel();
        to_094.setBounds(30, 130, 150, 25);
        to_094.setText("Destination:");
        to_094.setFont(fnt_094);
        to_094.setBorder(border_094);
        c_094.add(to_094);

        destination_094 = new JComboBox<>();
        destination_094.addItem("Select Destination");
        destination_094.addItem("Rajshahi");
        destination_094.addItem("Dhaka");
        destination_094.addItem("Khulna");
        destination_094.addItem("Sylhet");
        destination_094.addItem("Sreemangal");
        destination_094.addItem("Chittagong");
        destination_094.addItem("Cox's Bazar");
        destination_094.addItem("Barisal");
        destination_094.addItem("Mymensingh");
        destination_094.addItem("Rangpur");

        destination_094.setFont(fnt_094);
        destination_094.addItemListener(this);
        destination_094.setBounds(30, 170, 250, 35);
        destination_094.setBorder(border_094);
        c_094.add(destination_094);

        // Date Label
        dateLabel_094 = new JLabel("Select Journey Date:");
        dateLabel_094.setBounds(30, 220, 250, 25);
        dateLabel_094.setFont(fnt_094);
        c_094.add(dateLabel_094);

        // Day combo (1-31)
        String[] days_094 = new String[31];
        for (int d_094 = 0; d_094 <= 30; d_094++) {
            days_094[d_094] = String.valueOf(d_094 + 1);
        }
        dayBox_094 = new JComboBox<>(days_094);
        dayBox_094.setBounds(30, 250, 60, 35);
        dayBox_094.setBorder(border_094);
        dayBox_094.addItemListener(this);
        dayBox_094.setFont(new Font("Consolas", Font.BOLD, 14));
        c_094.add(dayBox_094);

        // Month combo
        monthBox_094 = new JComboBox<>();
        monthBox_094.setBounds(100, 250, 100, 35);
        monthBox_094.addItem("Sept");
        monthBox_094.setBorder(border_094);
        monthBox_094.addItemListener(this);
        monthBox_094.setFont(new Font("Consolas", Font.BOLD, 14));
        c_094.add(monthBox_094);

        yearBox_094 = new JComboBox<>();
        yearBox_094.addItem("2025");
        yearBox_094.setBounds(210, 250, 70, 35);
        yearBox_094.setBorder(border_094);
        yearBox_094.addItemListener(this);
        yearBox_094.setFont(new Font("Consolas", Font.BOLD, 14));
        c_094.add(yearBox_094);

        type_094 = new JLabel();
        type_094.setBounds(30, 300, 150, 25);
        type_094.setText("Seat Type:");
        type_094.setFont(fnt_094);
        type_094.setBorder(border_094);
        c_094.add(type_094);

        comfort_094 = new JComboBox<>();
        comfort_094.addItem("AC");
        comfort_094.addItem("Non-AC");
        comfort_094.addItemListener(this);
        comfort_094.setBounds(30, 330, 250, 35);
        comfort_094.setBorder(border_094);
        comfort_094.setFont(fnt_094);
        c_094.add(comfort_094);

        searchBtn_094 = new JButton("Search Buses");
        searchBtn_094.setFont(fnt_094);
        searchBtn_094.setBounds(30, 390, 250, 40);
        searchBtn_094.setBackground(Color.decode("#15A3C7"));
        searchBtn_094.setForeground(Color.WHITE);
        searchBtn_094.addActionListener(this);
        searchBtn_094.setBorder(border_094);
        c_094.add(searchBtn_094);

        DashboardBtn_094 = new JButton("My Tickets");
        DashboardBtn_094.setFont(fnt_094);
        DashboardBtn_094.setBounds(30, 450, 120, 40);
        DashboardBtn_094.setBackground(Color.WHITE);
        DashboardBtn_094.setForeground(Color.decode("#15A3C7"));
        DashboardBtn_094.addActionListener(this);
        DashboardBtn_094.setBorder(new LineBorder(Color.decode("#15A3C7"), 2, true));
        c_094.add(DashboardBtn_094);

        logoutBtn_094 = new JButton("Logout");
        logoutBtn_094.setFont(fnt_094);
        logoutBtn_094.setBounds(160, 450, 120, 40);
        logoutBtn_094.setBackground(Color.WHITE);
        logoutBtn_094.setForeground(Color.decode("#15A3C7"));
        logoutBtn_094.addActionListener(this);
        logoutBtn_094.setBorder(new LineBorder(Color.decode("#15A3C7"), 2, true));
        c_094.add(logoutBtn_094);

        JLabel footer = new JLabel("Developed by @enayethussain");
        footer.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        footer.setForeground(Color.decode("#15A3C7"));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        footer.setBounds(75, 510, 200, 30);
        c_094.add(footer);

        this.setVisible(true);
    }

    public void itemStateChanged(ItemEvent i_094) {
        pickupPoint_094 = (String) pickup_094.getSelectedItem();
        destinationPoint_094 = (String) destination_094.getSelectedItem();
        day_094 = (String) dayBox_094.getSelectedItem();
        month_094 = (String) monthBox_094.getSelectedItem();
        year_094 = (String) yearBox_094.getSelectedItem();
        seatType_094 = (String) comfort_094.getSelectedItem();
    }

    public void actionPerformed(ActionEvent e_094) {
        if (e_094.getSource() == searchBtn_094) {
            if (pickupPoint_094 == destinationPoint_094) {
                JOptionPane.showConfirmDialog(null,
                        "Departure and Destination cannot be the same place!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if( pickupPoint_094.equals("Select Departure") || destinationPoint_094.equals("Select Destination")) {
                JOptionPane.showConfirmDialog(null,
                        "Please select both Departure and Destination!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if (day_094 == null || month_094 == null || year_094 == null) {
                JOptionPane.showConfirmDialog(null,
                        "Please select a valid date!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if (checkAvaialableroutes(pickupPoint_094, destinationPoint_094) == 0) {
                JOptionPane.showConfirmDialog(null,
                        "No available routes found for the selected departure and destination.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
            else {
                new BookTicket(pickupPoint_094, destinationPoint_094, day_094, month_094, year_094, seatType_094,usr_094);
                this.dispose();
            }
        }
        if(e_094.getSource() == logoutBtn_094) {
            int response_094 = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
            if (response_094 == JOptionPane.YES_OPTION) {
                this.dispose();
                new LoginFrame();
            }
        }
        if(e_094.getSource() == DashboardBtn_094) {
            new DashboardFrame(usr_094);
        }
    }
    public static void main(String[] args) {
        new HomeFrame("tamtamdesu");
    }
}

