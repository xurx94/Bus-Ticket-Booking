import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.Vector;

class DashboardFrame extends JFrame {

    String usr_094;
    File file_094 = new File("resources/data/ticket.csv");
    JTable table_094;
    DefaultTableModel model_094;

    DashboardFrame(String usr_094) {
        this.usr_094 = usr_094;

        setTitle("My Tickets");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // table model with column names
        String[] columns = {"First Name", "Last Name", "Mobile", "Date", "Destination", "Seats", "Payment Method", "Total"};
        model_094 = new DefaultTableModel(columns, 0);
        table_094 = new JTable(model_094);
        JScrollPane scrollPane = new JScrollPane(table_094);
        getContentPane().setBackground(new Color(230, 242, 255));
        table_094.setFont(new Font("Consolas", Font.PLAIN, 14));
        table_094.setRowHeight(25);
        
        table_094.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table_094.setDefaultEditor(Object.class, null);
        table_094.setFillsViewportHeight(true);
        table_094.setBackground(new Color(255, 255, 255));
        table_094.setForeground(Color.BLACK);
        table_094.setSelectionBackground(new Color(173, 216, 230));
        table_094.setSelectionForeground(Color.BLACK);
        table_094.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        table_094.getTableHeader().setFont(new Font("Consolas", Font.BOLD, 14));
        table_094.getTableHeader().setBackground(new Color(230, 242, 255));
        table_094.getTableHeader().setForeground(Color.BLACK);
        
        loadTickets();

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void loadTickets() {
        try (BufferedReader br_094 = new BufferedReader(new FileReader(file_094))) {
            String line;
            while ((line = br_094.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 9) {
                    String fileuser = data[8].trim();
                    if (fileuser.equals(usr_094)) {
                        // add to table
                        Vector<String> row = new Vector<>();
                        row.add(data[0]); // First Name
                        row.add(data[1]); // Last Name
                        row.add(data[2]); // Mobile
                        row.add(data[3]); // Date
                        row.add(data[4]); // Destination
                        row.add(data[5]); // Seats
                        row.add(data[6]); // Payment Method
                        row.add(data[7]); // Total
                        model_094.addRow(row);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading tickets: " + e.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
