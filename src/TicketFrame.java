import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;


class TicketFrame extends JFrame implements ActionListener {
    Container t_094;
    JLabel title_094, Fname_094, fname_094, Lname_094, lname_094, Mobile_094, mobile_094, Date_094, date_094, Dest_094, dest_094, Stype_094, stype_094, Seats_094, seats_094, Total_094, total_094, Method_094, method_094, thanks_094, verdict_094;
    JButton printBtn_094;
    String fn_094, ln_094, mb_094, dt_094, dst_094, sts_094, sty_094, met_094, tot_094,usr_094;
    File file_094 = new File("resources/data/ticket.csv");

    TicketFrame(String usr_094) {
        this.setTitle("Ticket");
        this.setSize(350, 440);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        ImageIcon image_094 = new ImageIcon("resources/images/ticket.png");
        this.setIconImage(image_094.getImage());
        t_094 = getContentPane();
        t_094.setLayout(null); 
        t_094.setBackground(new Color(240, 248, 255)); 
        this.usr_094 = usr_094;

        Font f_094 = new Font("Courier New", Font.PLAIN, 13);

        try (BufferedReader br_094 = new BufferedReader(new FileReader(file_094))) {
            if (!file_094.exists()) {
                JOptionPane.showMessageDialog(this, "No ticket data found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String line_094;
            String[] data_094 = null;

            while ((line_094 = br_094.readLine()) != null) {
                String[] row = line_094.split(",");
                if (row.length >= 9) {
                    String fileuser = row[8].trim();
                    if (fileuser.equals(usr_094)) {
                        data_094 = row;
                    }
                }
            }

            if (data_094 == null) {
                JOptionPane.showMessageDialog(this, "No ticket found for the user.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            fn_094 = data_094[0];
            ln_094 = data_094[1];
            mb_094 = data_094[2];
            dt_094 = data_094[3];
            dst_094 = data_094[4];
            sts_094 = data_094[5];
            met_094 = data_094[6];
            tot_094 = data_094[7];

        } catch (IOException e_094) {
            e_094.printStackTrace();
        }


        title_094 = new JLabel("Ticket");
        title_094.setBounds(130, 10, 250, 30);
        title_094.setForeground(Color.decode("#15A3C7"));
        title_094.setFont(new Font("Courier New", Font.BOLD, 20));
        t_094.add(title_094);

        Fname_094 = new JLabel();
        Fname_094.setText("First Name");
        Fname_094.setBounds(20, 50, 250, 30);
        Fname_094.setForeground(Color.BLACK);
        Fname_094.setFont(f_094);
        t_094.add(Fname_094);

        fname_094 = new JLabel();
        fname_094.setText(fn_094);
        fname_094.setBounds(210, 50, 250, 30);
        fname_094.setForeground(Color.BLACK);
        fname_094.setFont(f_094);
        t_094.add(fname_094);

        Lname_094 = new JLabel();
        Lname_094.setText("Last Name");
        Lname_094.setBounds(20, 80, 250, 30);
        Lname_094.setForeground(Color.BLACK);
        Lname_094.setFont(f_094);
        t_094.add(Lname_094);

        lname_094 = new JLabel();
        lname_094.setText(ln_094);
        lname_094.setBounds(210, 80, 250, 30);
        lname_094.setForeground(Color.BLACK);
        lname_094.setFont(f_094);
        t_094.add(lname_094);

        Mobile_094 = new JLabel();
        Mobile_094.setText("Mobile Number");
        Mobile_094.setBounds(20, 110, 250, 30);
        Mobile_094.setForeground(Color.BLACK);
        Mobile_094.setFont(f_094);
        t_094.add(Mobile_094);

        mobile_094 = new JLabel();
        mobile_094.setText(mb_094);
        mobile_094.setBounds(210, 110, 250, 30);
        mobile_094.setForeground(Color.BLACK);
        mobile_094.setFont(f_094);
        t_094.add(mobile_094);

        Date_094 = new JLabel();
        Date_094.setText("Date");
        Date_094.setBounds(20, 140, 250, 30);
        Date_094.setForeground(Color.BLACK);
        Date_094.setFont(f_094);
        t_094.add(Date_094);

        date_094 = new JLabel();
        date_094.setText(dt_094);
        date_094.setBounds(210, 140, 250, 30);
        date_094.setForeground(Color.BLACK);
        date_094.setFont(f_094);
        t_094.add(date_094);

        Dest_094 = new JLabel();
        Dest_094.setText("Destination");
        Dest_094.setBounds(20, 170, 250, 30);
        Dest_094.setForeground(Color.BLACK);
        Dest_094.setFont(f_094);
        t_094.add(Dest_094);

        dest_094 = new JLabel();
        dest_094.setText(dst_094);
        dest_094.setBounds(210, 170, 250, 30);
        dest_094.setForeground(Color.BLACK);
        dest_094.setFont(f_094);
        t_094.add(dest_094);

        Seats_094 = new JLabel();
        Seats_094.setText("Seats");
        Seats_094.setBounds(20, 200, 250, 30);
        Seats_094.setForeground(Color.BLACK);
        Seats_094.setFont(f_094);
        t_094.add(Seats_094);

        seats_094 = new JLabel();
        seats_094.setText(sts_094);
        seats_094.setBounds(210, 200, 250, 30);
        seats_094.setForeground(Color.BLACK);
        seats_094.setFont(f_094);
        t_094.add(seats_094);

        Total_094 = new JLabel();
        Total_094.setText("Total");
        Total_094.setBounds(20, 230, 50, 30);
        Total_094.setForeground(Color.BLACK);
        Total_094.setFont(f_094);
        t_094.add(Total_094);

        total_094 = new JLabel();
        total_094.setText(tot_094);
        total_094.setBounds(210, 230, 50, 30);
        total_094.setForeground(Color.BLACK);
        total_094.setFont(f_094);
        t_094.add(total_094);

        Method_094 = new JLabel();
        Method_094.setText("Payment Method");
        Method_094.setBounds(20, 260, 150, 30);
        Method_094.setForeground(Color.BLACK);
        Method_094.setFont(f_094);
        t_094.add(Method_094);

        method_094 = new JLabel();
        method_094.setText(met_094);
        method_094.setBounds(210, 260, 100, 30);
        method_094.setForeground(Color.BLACK);
        method_094.setFont(f_094);
        t_094.add(method_094);
    
        JPanel colorLine_094 = new JPanel();
        colorLine_094.setBackground(Color.decode("#18b0d6ff")); 
        colorLine_094.setBounds(20, 300, 290, 1);
        t_094.add(colorLine_094);

        verdict_094 = new JLabel("PAID");
        verdict_094.setBounds(140, 310, 350, 30);
        verdict_094.setForeground(Color.RED);
        verdict_094.setFont(new Font("Courier New", Font.BOLD, 16));
        t_094.add(verdict_094);

        thanks_094 = new JLabel("Thank you for travelling with us");
        thanks_094.setBounds(48, 332, 350, 30);
        thanks_094.setForeground(Color.GRAY);
        thanks_094.setFont(new Font("Courier New", Font.ITALIC, 12));
        t_094.add(thanks_094);

        printBtn_094 = new JButton("Download Ticket");
        printBtn_094.setBounds(95, 364, 150, 30);
        printBtn_094.setFont(new Font("Consolas", Font.BOLD, 12));
        printBtn_094.setBackground(Color.decode("#15A3C7"));
        printBtn_094.setForeground(Color.WHITE);
        printBtn_094.addActionListener(this);
        t_094.add(printBtn_094);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e_094) {
        if (e_094.getSource() == printBtn_094) {
            try {
                JOptionPane.showMessageDialog(this, "Ticket downloaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                new HomeFrame(usr_094);
                this.dispose();
            } catch (Exception ex_094) {
                JOptionPane.showMessageDialog(this, "Error downloading ticket: " + ex_094.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }



}
