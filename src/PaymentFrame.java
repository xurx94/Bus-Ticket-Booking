import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class PaymentFrame extends JFrame implements ActionListener {

    Container c_094;
    JLabel nameLabel_094, numberLabel_094, otpLabel_094, mtd_094, Flabel_094, Llabel_094;
    JTextField numberArea_094, otpArea_094, FArea_094, LArea_094;
    JButton OTP_094, pay_094;
    JRadioButton bkash_094, nagad_094, rocket_094;
    ButtonGroup grp_094;
    String p_094, des_094, da_094, mo_094, year_094, sty_094, tot_094, stts_094,usr_094;

    PaymentFrame(String pp_094, String dp_094, String d_094, String m_094, String yr_094, String st_094, String cst_094, String sts_094,String usr_094) {
        this.p_094 = pp_094;
        this.des_094 = dp_094;
        this.da_094 = d_094;
        this.mo_094 = m_094;
        this.year_094 = yr_094;
        this.sty_094 = st_094;
        this.tot_094 = cst_094;
        this.stts_094 = sts_094;
        this.usr_094 = usr_094;

        this.setTitle("Payment");
        this.setSize(400, 430);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        ImageIcon image_094 = new ImageIcon("resources/images/pay.png");
        this.setIconImage(image_094.getImage());
        c_094 = getContentPane();
        c_094.setLayout(null); 
        c_094.setBackground(new Color(240, 248, 255)); 
        
        Font fn_094 = new Font("Consolas", Font.PLAIN, 14);
        Border border_094 = new LineBorder(Color.darkGray, 2);

        nameLabel_094 = new JLabel("Make Payment");
        nameLabel_094.setBounds(140, 30, 250, 30);
        nameLabel_094.setForeground(Color.decode("#15A3C7"));
        nameLabel_094.setFont(new Font("Consolas", Font.BOLD, 20));
        c_094.add(nameLabel_094);

        Flabel_094 = new JLabel("F.Name: ");
        Flabel_094.setBounds(20, 80, 100, 30);
        Flabel_094.setForeground(Color.black);
        Flabel_094.setFont(fn_094);
        c_094.add(Flabel_094);

        FArea_094 = new JTextField(" ");
        FArea_094.setBounds(110, 80, 230, 30);
        FArea_094.setForeground(Color.black);
        FArea_094.setBackground(new Color(245, 245, 245));
        FArea_094.setFont(fn_094);
        FArea_094.setCaretColor(Color.black);
        FArea_094.setBorder(border_094);
        c_094.add(FArea_094);
          
        Llabel_094 = new JLabel("L.Name: ");
        Llabel_094.setBounds(20, 120, 100, 30);
        Llabel_094.setForeground(Color.black);
        Llabel_094.setFont(fn_094);
        c_094.add(Llabel_094);

        LArea_094 = new JTextField(" ");
        LArea_094.setBounds(110, 120, 230, 30);
        LArea_094.setForeground(Color.black);
        LArea_094.setBackground(new Color(245, 245, 245));
        LArea_094.setFont(fn_094);
        LArea_094.setCaretColor(Color.black);
        LArea_094.setBorder(border_094);
        c_094.add(LArea_094);
          
        mtd_094 = new JLabel("Payment Method:");
        mtd_094.setBounds(20, 160, 200, 30);
        mtd_094.setForeground(Color.BLACK);
        mtd_094.setFont(fn_094);
        c_094.add(mtd_094);

        bkash_094 = new JRadioButton("Bkash");
        bkash_094.setBounds(20, 190, 70, 30);
        bkash_094.setActionCommand("Bkash");
        bkash_094.setBackground(new Color(240, 248, 255));
        bkash_094.setForeground(Color.BLACK);
        bkash_094.setFont(fn_094);

        nagad_094 = new JRadioButton("Nagad");
        nagad_094.setBounds(100, 190, 70, 30);
        nagad_094.setActionCommand("Nagad");
        nagad_094.setForeground(Color.BLACK);
        nagad_094.setBackground(new Color(240, 248, 255));
        nagad_094.setFont(fn_094);

        rocket_094 = new JRadioButton("Rocket");
        rocket_094.setBounds(180, 190, 90, 30);
        rocket_094.setActionCommand("Rocket");
        rocket_094.setForeground(Color.BLACK);
        rocket_094.setBackground(new Color(240, 248, 255));
        rocket_094.setFont(fn_094);

        grp_094 = new ButtonGroup();
        grp_094.add(bkash_094);
        grp_094.add(nagad_094);
        grp_094.add(rocket_094);
        
        c_094.add(bkash_094);
        c_094.add(nagad_094);
        c_094.add(rocket_094);

        numberLabel_094 = new JLabel("Mobile: ");
        numberLabel_094.setBounds(20, 240, 100, 30);
        numberLabel_094.setForeground(Color.black);
        numberLabel_094.setFont(fn_094);
        c_094.add(numberLabel_094);

        numberArea_094 = new JTextField(" ");
        numberArea_094.setBounds(110, 240, 230, 30);
        numberArea_094.setForeground(Color.black);
        numberArea_094.setBackground(new Color(245, 245, 245));
        numberArea_094.setFont(fn_094);
        numberArea_094.setCaretColor(Color.black);
        numberArea_094.setBorder(border_094);
        c_094.add(numberArea_094);
  
        otpLabel_094 = new JLabel("OTP: ");
        otpLabel_094.setBounds(20, 280, 100, 30);
        otpLabel_094.setForeground(Color.black);
        otpLabel_094.setFont(fn_094);
        c_094.add(otpLabel_094);

        otpArea_094 = new JTextField(" ");
        otpArea_094.setBounds(110, 280, 230, 30);
        otpArea_094.setForeground(Color.black);
        otpArea_094.setBackground(new Color(245, 245, 245));
        otpArea_094.setFont(fn_094);
        otpArea_094.setCaretColor(Color.black);
        otpArea_094.setBorder(border_094);
        c_094.add(otpArea_094);
  
        OTP_094 = new JButton("OTP");
        OTP_094.setFont(fn_094);
        OTP_094.setBounds(130, 330, 120, 30);
        OTP_094.setBackground(Color.decode("#15A3C7"));
        OTP_094.setForeground(Color.WHITE);
        OTP_094.addActionListener(this);
        c_094.add(OTP_094);

        pay_094 = new JButton("Pay");
        pay_094.setFont(fn_094);
        pay_094.setBounds(130, 330, 120, 30);
        pay_094.setBackground(Color.WHITE);
        pay_094.setForeground(Color.decode("#15A3C7"));
        pay_094.setBorder(new LineBorder(Color.decode("#15A3C7"), 2));
        pay_094.addActionListener(this);
        pay_094.setVisible(false);
        c_094.add(pay_094);

        JLabel footer_094 = new JLabel("Developed by @enayethussain");
        footer_094.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        footer_094.setForeground(Color.decode("#15A3C7"));
        footer_094.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        footer_094.setBounds(120, 370, 200, 30);
        c_094.add(footer_094);

        this.setVisible(true);
    }
Random random_094 = new Random();
String otpp_094;
public void actionPerformed(ActionEvent e_094){
    String number_094 = numberArea_094.getText().trim();
    ButtonModel selectedOption_094 = grp_094.getSelection();
    String meth_094 = selectedOption_094.getActionCommand();
    String fnam_094 = FArea_094.getText().trim();
    String lnam_094 = LArea_094.getText().trim();
    String date_094 = da_094+" "+mo_094+" "+year_094;
    if (e_094.getSource() == OTP_094) {
        int otp_094 = 100000 + random_094.nextInt(900000); 
        otpp_094 = Integer.toString(otp_094);
        if(number_094.length()==11 && selectedOption_094!=null){
            JOptionPane.showMessageDialog(null,"Your OTP: "+otp_094,"OTP", JOptionPane.INFORMATION_MESSAGE);
            pay_094.setVisible(true);
            OTP_094.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "Please enter your 11 digit mobile number and Select a proper payment method", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    else{
        if (fnam_094.isEmpty() || lnam_094.isEmpty() || number_094.isEmpty() || meth_094.isEmpty() || otpArea_094.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }
    String code_094 = otpArea_094.getText().trim();
    if(e_094.getSource() == pay_094){
        if(!code_094.equals(otpp_094)){
            JOptionPane.showMessageDialog(null, "Wrong OTP, Try again", "Warning", JOptionPane.WARNING_MESSAGE);
            FArea_094.setText(" ");
            LArea_094.setText(" ");
            numberArea_094.setText(" ");
            otpArea_094.setText(" ");
            grp_094.clearSelection();
            pay_094.setVisible(false);
            OTP_094.setVisible(true);                 
        }
        else{
            addTicket(fnam_094, lnam_094, number_094,des_094, date_094,stts_094,sty_094, meth_094, tot_094,usr_094);
            new TicketFrame(usr_094);
            this.dispose();
        }
    }
}
    private void addTicket(String fname_094, String lname_094, String mobile_094, String dest_094,String date_094, String seats_094, String sty_094,String method_094, String total_094,String usr_094) {
        File file_094 = new File("resources/data/ticket.csv");
        try(BufferedWriter bw_094 = new BufferedWriter(new FileWriter(file_094, true))) {
            bw_094.write(fname_094 + "," + lname_094 + "," + mobile_094 + "," + date_094 + "," + dest_094 + "," + seats_094 + "," + method_094 + "," + total_094 + "," + usr_094);
            bw_094.newLine();
        } catch (IOException ex_094) {
            JOptionPane.showMessageDialog(null, "Error saving ticket data: " + ex_094.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
