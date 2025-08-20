import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class BookTicket extends JFrame implements ActionListener {

    Container c_094;
    JButton confirmBtn_094, proceedBtn_094;
    JPanel top_094, right_094, left_094, bottom_094;
    JLabel totalSeatsLabel_094, seatFareLabel_094, totalPriceLabel_094;
    ArrayList<JButton> seatButtons_094 = new ArrayList<>();
    ArrayList<String> selectedSeats_094 = new ArrayList<>();

    int response_094 = -1;
    double seatFare_094=0;
    int count_094 = 0;
    String pickupPoint_094, destinationPoint_094, day_094, month_094, year_094, seatType_094,seatsJoined_094,usr_094;
    File csvFile_094 = new File("resources/data/bookings.csv");
    File pricesFile_094 = new File("resources/data/prices.csv");

    public BookTicket(String pp_094, String dp_094, String d_094, String m_094, String yr_094, String st_094,String usr_094) {
        this.pickupPoint_094 = pp_094;
        this.destinationPoint_094 = dp_094;
        this.day_094 = d_094;
        this.month_094 = m_094;
        this.year_094 = yr_094;
        this.seatType_094 = st_094;
        this.usr_094 = usr_094;
        seatFare_094 = calculateFare_094();
        ImageIcon ticket_094 = new ImageIcon("resources/images/ticket.png");
        this.setIconImage(ticket_094.getImage());
        this.setTitle("Bus Ticket Booking");
        this.setSize(600, 710);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        c_094 = getContentPane();
        c_094.setLayout(null);
        c_094.setBackground(new Color(230, 242, 255));

        Font titleFont_094 = new Font("Consolas", Font.BOLD, 25);
        Font infoFont_094 = new Font("Consolas", Font.BOLD, 12);
        Font nFont_094 = new Font("Consolas", Font.BOLD, 15);
        Border border_094 = new LineBorder(Color.darkGray, 2);

        // ================= TOP PANEL =================
        top_094 = new JPanel(null);
        top_094.setBounds(0, 0, 600, 100);
        top_094.setBackground(new Color(230, 242, 255));

        JLabel titleLabel_094 = new JLabel("Ena Travels 2.0");
        titleLabel_094.setFont(titleFont_094);
        titleLabel_094.setForeground(Color.decode("#15A3C7"));
        titleLabel_094.setBounds(190, 20, 300, 25);
        top_094.add(titleLabel_094);

        JLabel instrLabel_094 = new JLabel("Select maximum 2 seats -> Confirm seat -> Proceed to pay");
        instrLabel_094.setFont(infoFont_094);
        instrLabel_094.setForeground(Color.BLACK);
        instrLabel_094.setBounds(130, 50, 400, 20);
        top_094.add(instrLabel_094);

        // Legend
        JLabel greenLabel_094 = new JLabel(new ImageIcon("resources/images/Green.png"));
        greenLabel_094.setBounds(195, 80, 8, 8);
        greenLabel_094.setBorder(border_094);
        top_094.add(greenLabel_094);
        JLabel greenText_094 = new JLabel("Selected");
        greenText_094.setFont(infoFont_094);
        greenText_094.setForeground(Color.BLACK);
        greenText_094.setBounds(210, 78, 60, 15);
        top_094.add(greenText_094);

        JLabel whiteLabel_094 = new JLabel(new ImageIcon("resources/images/white.jpeg"));
        whiteLabel_094.setBounds(270, 80, 8, 8);
        whiteLabel_094.setBorder(border_094);
        top_094.add(whiteLabel_094);
        JLabel whiteText_094 = new JLabel("Available");
        whiteText_094.setFont(infoFont_094);
        whiteText_094.setForeground(Color.BLACK);
        whiteText_094.setBounds(285, 78, 70, 15);
        top_094.add(whiteText_094);

        JLabel grayLabel_094 = new JLabel(new ImageIcon("resources/images/gray.png"));
        grayLabel_094.setBounds(350, 80, 8, 8);
        top_094.add(grayLabel_094);
        JLabel grayText_094 = new JLabel("Booked");
        grayText_094.setFont(infoFont_094);
        grayText_094.setForeground(Color.BLACK);
        grayText_094.setBounds(365, 78, 70, 15);
        top_094.add(grayText_094);


        // ================= LEFT PANEL =================
        left_094 = new JPanel(null);
        left_094.setBounds(0, 100, 150, 500);
        left_094.setBackground(Color.WHITE);

        JLabel details_094 = new JLabel("Seat Info:");
        details_094.setBounds(10, 20, 120, 30);
        details_094.setForeground(Color.decode("#15A3C7"));
        details_094.setFont(new Font("Consolas",Font.BOLD,16));
        left_094.add(details_094);


        JLabel seatFareText_094 = new JLabel("Seat Fare:");
        seatFareText_094.setBounds(10, 50, 120, 30);
        seatFareText_094.setFont(nFont_094);
        left_094.add(seatFareText_094);

        seatFareLabel_094 = new JLabel("");
        seatFareLabel_094.setBounds(10, 80, 120, 30);
        seatFareLabel_094.setFont(nFont_094);
        left_094.add(seatFareLabel_094);

        JLabel totalSeatsText_094 = new JLabel("Total Seats:");
        totalSeatsText_094.setBounds(10, 110, 120, 30);
        totalSeatsText_094.setFont(nFont_094);
        left_094.add(totalSeatsText_094);

        totalSeatsLabel_094 = new JLabel("");
        totalSeatsLabel_094.setBounds(10, 140, 120, 30);
        totalSeatsLabel_094.setFont(nFont_094);
        left_094.add(totalSeatsLabel_094);

        JLabel totalText_094 = new JLabel("Total:");
        totalText_094.setBounds(10, 170, 120, 30);
        totalText_094.setFont(nFont_094);
        left_094.add(totalText_094);

        totalPriceLabel_094 = new JLabel("");
        totalPriceLabel_094.setBounds(10, 200, 120, 30);
        totalPriceLabel_094.setFont(nFont_094);
        left_094.add(totalPriceLabel_094);

        JLabel bd_094 = new JLabel("Journey Info:");
        bd_094.setBounds(10, 250, 120, 30);
        bd_094.setForeground(Color.decode("#15A3C7"));
        bd_094.setFont(new Font("Consolas",Font.BOLD,16));
        left_094.add(bd_094);


        JLabel boardingPointText_094 = new JLabel("Depart From:");
        boardingPointText_094.setBounds(10, 280, 120, 30);
        boardingPointText_094.setFont(nFont_094);
        left_094.add(boardingPointText_094);

        JLabel boardingPointLabel_094 = new JLabel(pickupPoint_094);
        boardingPointLabel_094.setBounds(10, 300, 120, 30);
        boardingPointLabel_094.setFont(nFont_094);
        left_094.add(boardingPointLabel_094);

        JLabel droppingPointText_094 = new JLabel("Arrive At:");
        droppingPointText_094.setBounds(10, 330, 120, 30);
        droppingPointText_094.setFont(nFont_094);
        left_094.add(droppingPointText_094);

        JLabel droppingPointLabel_094 = new JLabel(destinationPoint_094);
        droppingPointLabel_094.setBounds(10, 350, 120, 30);
        droppingPointLabel_094.setFont(nFont_094);
        left_094.add(droppingPointLabel_094);

        JLabel dateText_094 = new JLabel("Date:");
        dateText_094.setBounds(10, 380, 120, 30);
        dateText_094.setFont(nFont_094);
        left_094.add(dateText_094);

        JLabel dateLabel_094 = new JLabel(day_094+" "+month_094+" "+year_094);
        dateLabel_094.setBounds(10, 400, 120, 30);
        dateLabel_094.setFont(nFont_094);
        left_094.add(dateLabel_094);

        // ================= RIGHT PANEL =================
        right_094 = new JPanel(null);
        right_094.setBounds(150, 100, 450, 500);
        right_094.setBackground(Color.decode("#e8e8e8"));

        JLabel BookSeats_094 = new JLabel("Book Seats");
        BookSeats_094.setBounds(160, 5, 150, 30);
        BookSeats_094.setFont(new Font("Consolas",Font.BOLD,20));
        BookSeats_094.setForeground(Color.BLACK);
        right_094.add(BookSeats_094);

        String[] totalseats_094 = {
                "A1", "A2", "A3", "A4",
                "B1", "B2", "B3", "B4",
                "C1", "C2", "C3", "C4",
                "D1", "D2", "D3", "D4",
                "E1", "E2", "E3", "E4",
                "F1", "F2", "F3", "F4",
                "G1", "G2", "G3", "G4",
                "H1", "H2", "H3", "H4"
        };

        int x_094 = 90, y_094 = 45, col_094 = 4, btnW_094 = 50, btnH_094 = 50, i_094 = 1;
        for (String s_094 : totalseats_094) {
            JButton seatBtn_094 = new JButton(s_094);
            seatBtn_094.setBackground(Color.white);
            seatBtn_094.setFont(nFont_094);
            seatBtn_094.setBounds(x_094, y_094, btnW_094, btnH_094);

            seatBtn_094.addActionListener(ev_094 -> {
                if (selectedSeats_094.contains(s_094)) {
                    selectedSeats_094.remove(s_094);
                    seatBtn_094.setBackground(Color.white);
                } else {
                    if (selectedSeats_094.size() < 2) {
                        selectedSeats_094.add(s_094);
                        seatBtn_094.setBackground(Color.green);
                    } else {
                        JOptionPane.showMessageDialog(null, "You can only select maximum 2 seats.", "Limit reached", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });

            if (i_094 < col_094) {
                if (i_094 == 2) x_094 += btnW_094 + 40;
                else x_094 += btnW_094 + 10;
                i_094++;
            } else {
                i_094 = 1;
                x_094 = 90;
                y_094 += btnH_094 + 5;
            }

            seatButtons_094.add(seatBtn_094);
            right_094.add(seatBtn_094);
        }

        // Load already booked seats for this trip
        loadBookedSeats_094();

        // ================= BOTTOM PANEL =================
        bottom_094 = new JPanel(null);
        bottom_094.setBounds(0, 600, 600, 110);
        bottom_094.setBackground(new Color(230, 242, 255));

        confirmBtn_094 = new JButton("Confirm ticket");
        confirmBtn_094.setFont(nFont_094);
        confirmBtn_094.setBounds(200, 10, 180, 40);
        confirmBtn_094.setBackground(Color.WHITE);
        confirmBtn_094.setForeground(Color.decode("#15A3C7"));
        confirmBtn_094.setBorder(new LineBorder(new Color(230, 242, 255), 1, true));
        confirmBtn_094.addActionListener(this);
        bottom_094.add(confirmBtn_094);

        proceedBtn_094 = new JButton("Proceed to Pay");
        proceedBtn_094.setFont(nFont_094);
        proceedBtn_094.setBounds(200, 10, 180, 40);
        proceedBtn_094.setBackground(Color.decode("#15A3C7"));
        proceedBtn_094.setForeground(Color.WHITE);
        proceedBtn_094.addActionListener(this);
        proceedBtn_094.setBorder(new LineBorder(Color.decode("#15A3C7"), 1, true));
        proceedBtn_094.setVisible(false);
        
        bottom_094.add(proceedBtn_094);
        
        JLabel footer = new JLabel("Developed by @enayethussain");
        footer.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        footer.setForeground(Color.decode("#15A3C7"));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        footer.setBounds(210, 48, 200, 30);
        bottom_094.add(footer);
        // Add panels
        c_094.add(top_094);
        c_094.add(left_094);
        c_094.add(right_094);
        c_094.add(bottom_094);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e_094) {
        if (e_094.getSource() == confirmBtn_094) {
            if (selectedSeats_094.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select at least 1 seat first.", "No seat selected", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String seatsMsg_094 = String.join(",", selectedSeats_094);
            String msg_094 = "Are you sure you want to book seats: " + seatsMsg_094 + "?";
            response_094 = JOptionPane.showConfirmDialog(null, msg_094, "Confirmation", JOptionPane.YES_NO_OPTION);

            if (response_094 == JOptionPane.YES_OPTION) {
                count_094 = selectedSeats_094.size();
                totalSeatsLabel_094.setText(String.valueOf(count_094+"("+seatsMsg_094+")"));
                seatFareLabel_094.setText(String.valueOf(seatFare_094));
                totalPriceLabel_094.setText(String.valueOf(seatFare_094 * count_094));

                // Save booking to CSV
                saveBookingToCSV_094();

                // Mark seats as booked
                for (JButton btn_094 : seatButtons_094) {
                    if (selectedSeats_094.contains(btn_094.getText())) {
                        btn_094.setBackground(Color.GRAY);
                        btn_094.setEnabled(false);
                    }
                }

                confirmBtn_094.setVisible(false);
                proceedBtn_094.setVisible(true);
            }
            else{
                    for (JButton btn_094 : seatButtons_094) {
                        if (selectedSeats_094.contains(btn_094.getText())) {
                            btn_094.setBackground(Color.WHITE);
                        }
                    }    
            }
        }

        if (e_094.getSource() == proceedBtn_094) {
            this.dispose();
            new PaymentFrame(pickupPoint_094, destinationPoint_094, day_094, month_094, year_094, seatType_094,String.valueOf(count_094*seatFare_094),seatsJoined_094,usr_094);
        }
    }

    private void saveBookingToCSV_094() {
        try (BufferedWriter writer_094 = new BufferedWriter(new FileWriter(csvFile_094, true))) {
            seatsJoined_094 = String.join("|", selectedSeats_094);
            double totalCost_094 = seatFare_094 * selectedSeats_094.size();
            writer_094.write(String.join(",", pickupPoint_094, destinationPoint_094, day_094, month_094, year_094, seatType_094, seatsJoined_094, String.valueOf(totalCost_094)));
            writer_094.newLine();
        } catch (IOException ex_094) {
            ex_094.printStackTrace();
        }
    }

private double calculateFare_094() {
    if (!pricesFile_094.exists()) {
        JOptionPane.showMessageDialog(null, "Prices file not found!", "Error", JOptionPane.ERROR_MESSAGE);
        return 0;
    }
    try (BufferedReader reader_094 = new BufferedReader(new FileReader(pricesFile_094))) {
        String line_094;
        while ((line_094 = reader_094.readLine()) != null) {
            String[] parts_094 = line_094.split(",");
            if (parts_094.length >= 3) {
                if ((parts_094[0].equals(pickupPoint_094) ||
                    parts_094[0].equals(destinationPoint_094)) &&
                    (parts_094[1].equals(pickupPoint_094) || parts_094[1].equals(destinationPoint_094))) {
                    double fare_094 = Double.parseDouble(parts_094[2]);
                    if (seatType_094.equals("AC")) {
                        fare_094 *= 1.25; 
                    }
                    return fare_094;
                }
            }
        }
    } catch (IOException ex_094) {
        ex_094.printStackTrace();
    }
    
    // Default return if no match found or exception occurs
    return 0;
}

private void loadBookedSeats_094() {
    if (!csvFile_094.exists()) return;
    try (BufferedReader reader_094 = new BufferedReader(new FileReader(csvFile_094))) {
        String line_094;
        while ((line_094 = reader_094.readLine()) != null) {
            String[] parts_094 = line_094.split(",");
            if (parts_094.length >= 8) {
                if (parts_094[0].equals(pickupPoint_094) &&
                    parts_094[1].equals(destinationPoint_094) &&
                    parts_094[2].equals(day_094) &&
                    parts_094[3].equals(month_094) &&
                    parts_094[4].equals(year_094) &&
                    parts_094[5].equals(seatType_094)) {

                    String[] bookedSeats_094 = parts_094[6].split("\\|");
                    for (String seat_094 : bookedSeats_094) {
                        for (JButton btn_094 : seatButtons_094) {
                            if (btn_094.getText().equals(seat_094)) {
                                btn_094.setBackground(Color.GRAY);
                                btn_094.setEnabled(false);
                            }
                        }
                    }
                }
            }
        }
    } catch (IOException ex_094) {
        ex_094.printStackTrace();
    }
}
}
