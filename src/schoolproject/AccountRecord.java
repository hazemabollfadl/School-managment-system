package schoolproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.regex.*;
import java.sql.*;

public class AccountRecord extends JFrame implements ActionListener {

    JTextField tf1;
    JButton b1, b2;
    String columns[] = {"Student ID", "First Name", "Last Name", "Section", "Year of pay", "Mode of pay", "Amount"};
    TableModel tmodel;
    JTable jtable;
    TableRowSorter<TableModel> rsorter;

    int z1, z2, z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, z13, z14, z15, z16;
    Connection con;
    Statement stm;
    String username = "system";
    String password = "system";

    Count1 count = new Count1();
    int g = count.call3();
    Object array[][] = new Object[g][7];

    ResultSet rs;

    public AccountRecord() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", username, password);
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT *  FROM saccount ");

            while (rs.next()) {
                array[z1++][0] = rs.getObject(1);
                array[z2++][1] = rs.getObject(2);
                array[z3++][2] = rs.getObject(3);
                array[z4++][3] = rs.getObject(4);
                array[z5++][4] = rs.getObject(5);
                array[z6++][5] = rs.getObject(6);
                array[z7++][6] = rs.getObject(7);
            }
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        setTitle("SCHOOL MANAGEMENT SYSTEM");
        setSize(830, 550);

        JPanel p2 = new JPanel();

        p2.setBackground(Color.white);
        add(p2, BorderLayout.NORTH);

        JLabel l1 = new JLabel("Fees Record");
        Font font = new Font("Lucida Sans Typewriter", Font.BOLD, 25);
        l1.setFont(font);
        p2.add(l1);
        tf1 = new JTextField(10);
        p2.add(tf1);
        b1 = new JButton("Search", new ImageIcon("images/se.png"));
        b1.addActionListener(this);
        p2.add(b1);
        tmodel = new DefaultTableModel(array, columns);
        jtable = new JTable(tmodel);
        rsorter = new TableRowSorter<TableModel>(tmodel);
        JScrollPane jspane = new JScrollPane(jtable);
        jtable.setRowSorter(rsorter);
        add(jspane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent er) {
        if (er.getSource() == b1) {
            String text = tf1.getText();
            if (text.length() == 0) {
                rsorter.setRowFilter(null);
            }
            rsorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }

}
