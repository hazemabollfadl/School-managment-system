package schoolproject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class UpdateStaff extends JFrame implements ActionListener {

    JLabel StaffID, Fname, Lname, FathName, Address, Gender, DofBirth, DofJoin, Qualification, PhoneNumber, Email, Caste, Relegion, Nation, Identification, Password, Designation, l18, l19, l20;
    JTextField ltextf1, ltextf2, ltextf3, ltextf4, ltextf6, ltextf7, ltextf8, ltextf9, ltextf10, ltextf11, ltextf12, ltextf13, ltextf14, ltextf15, ltextf16, ltextf17, ltextf18, ltextf19, ltextf20;
    JTextArea ltextf5;
    JButton submit, reset, delete, getstudent;
    String Staff1, Staff2, Staff3, Staff4, Staff5, Staff6, Staff7, Staff8, Staff9, Staff10, Staff11, Staff12, Staff13, Staff14, Staff15, Staff16, Staff17, s18, s19, s20;
    Connection con;
    PreparedStatement stm;
    Statement stm2;
    ResultSet rs2;
    String username = "System";
    String password = "System";
    String dl = "";
    UpdateStaff obj;
    java.time.LocalDateTime now = java.time.LocalDateTime.now();
    java.time.format.DateTimeFormatter format = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String is = now.format(format);
    JRadioButton box1, box2, box3;
    Choice choice3, choice4, choice5;
    ButtonGroup group;
    int pass9, ph, ph2, ph3, ch1;

    public UpdateStaff() {

        obj = this;
        Container container = getContentPane();
        setLayout(new BorderLayout());
        setTitle("SCHOOL MANAGEMENT SYSTEM");
        setIconImage(new ImageIcon("logo.png").getImage());
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel.setLayout(null);

        panel2.setBackground(Color.white);
        panel2.setLayout(null);
        panel3.setLayout(null);
        panel2.setBounds(20, 80, 780, 400);
        panel2.setBorder(new TitledBorder(new LineBorder(Color.orange, 5), "Fill Details", 0, 0, new Font("Segoe Script", Font.BOLD, 10), Color.red));

        //Label
        JLabel toplabel = new JLabel("Edit Staff form");
        Font font = new Font("Lucida Handwriting", Font.BOLD, 33);
        toplabel.setFont(font);
        toplabel.setBounds(300, 20, 300, 40);
        panel.add(toplabel);

        StaffID = new JLabel("Staff ID:");
        StaffID.setBounds(20, 60, 100, 20);
        Fname = new JLabel("First Name:");
        Fname.setBounds(20, 90, 100, 20);
        Lname = new JLabel("Last Name:");
        Lname.setBounds(20, 120, 100, 20);
        FathName = new JLabel("Father Name:");
        FathName.setBounds(20, 150, 100, 20);
        Address = new JLabel("Address:");
        Address.setBounds(20, 180, 100, 20);

        Gender = new JLabel("Gender:");
        Gender.setBounds(20, 240, 100, 20);
        DofBirth = new JLabel("Date of Birth:");
        DofBirth.setBounds(20, 270, 100, 20);
        DofJoin = new JLabel("Date of Join:");
        DofJoin.setBounds(20, 300, 100, 20);
        Qualification = new JLabel("Qualification:");
        Qualification.setBounds(20, 330, 100, 20);
        PhoneNumber = new JLabel("Phone no:");
        PhoneNumber.setBounds(20, 360, 100, 20);
        Email = new JLabel("Email:");
        Email.setBounds(430, 60, 100, 20);
        Caste = new JLabel("Caste:");
        Caste.setBounds(430, 90, 100, 20);
        Relegion = new JLabel("Religion:");
        Relegion.setBounds(430, 120, 100, 20);
        Nation = new JLabel("Nationality:");
        Nation.setBounds(430, 150, 100, 20);
        Identification = new JLabel("Identification mark:");
        Identification.setBounds(430, 180, 130, 20);
        Password = new JLabel("Password:");
        Password.setBounds(430, 210, 100, 20);
        Designation = new JLabel("Designation:");

        group = new ButtonGroup();
        box1 = new JRadioButton("Male");
        box1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getItemSelectable() == box1) {
                    ltextf6.setText("Male");
                }
            }
        });
        box1.setBounds(200, 240, 60, 10);
        panel2.add(box1);
        box2 = new JRadioButton("Female");
        box2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getItemSelectable() == box2) {
                    ltextf6.setText("Female");
                }
            }
        });
        box2.setBounds(260, 240, 80, 10);
        group.add(box1);
        group.add(box2);
        panel2.add(box2);
        box1.setBackground(new Color(192, 192, 192));
        box2.setBackground(new Color(192, 192, 192));

        panel2.add(StaffID);
        panel2.add(Fname);
        panel2.add(Lname);
        panel2.add(FathName);
        panel2.add(Address);
        panel2.add(Gender);
        panel2.add(DofBirth);
        panel2.add(DofJoin);
        panel2.add(Qualification);
        panel2.add(PhoneNumber);
        panel2.add(Email);
        panel2.add(Caste);
        panel2.add(Relegion);
        panel2.add(Nation);
        panel2.add(Identification);
        panel2.add(Password);
        panel2.add(Designation);

        ltextf1 = new JTextField();
        ltextf1.setBounds(200, 60, 150, 20);
        ltextf2 = new JTextField();
        ltextf2.setBounds(200, 90, 150, 20);

        ltextf3 = new JTextField();
        ltextf3.setBounds(200, 120, 150, 20);
        ltextf4 = new JTextField();
        ltextf4.setBounds(200, 150, 150, 20);
        //ltf5 = new JTextField();
        //ltf5.setBounds(200,180,150,20);

        ltextf5 = new JTextArea();
        JScrollPane jscroll = new JScrollPane(ltextf5, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jscroll.setBounds(200, 180, 200, 50);

        ltextf6 = new JTextField();
        ltextf6.setBounds(200, 240, 150, 20);
        ltextf7 = new JTextField();
        ltextf7.setBounds(200, 270, 150, 20);
        JLabel birth = new JLabel("DD-MM-YYYY");
        birth.setBounds(380, 270, 150, 20);
        panel2.add(birth);
        ltextf8 = new JTextField();
        ltextf8.setBounds(200, 300, 150, 20);
        ltextf9 = new JTextField();
        //ltf9.setBounds(200,340,150,20);
        choice5 = new Choice();
        choice5.addItem("");
        choice5.addItem("B.A");
        choice5.addItem("M.A");
        choice5.addItem("B.com");
        choice5.addItem("M.com");
        choice5.addItem("B.Sc");
        choice5.addItem("M.Sc");
        choice5.addItem("B.Tech");
        choice5.addItem("M.Tech");
        choice5.addItem("10 th");
        choice5.addItem("12 th");
        choice5.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent v) {
                ltextf9.setText((String) choice5.getSelectedItem());
            }
        });
        choice5.setBounds(200, 330, 150, 20);
        panel2.add(choice5);

        ltextf10 = new JTextField();
        ltextf10.setBounds(200, 360, 150, 20);
        JLabel only10 = new JLabel("Only 10 Digits");
        only10.setBounds(380, 360, 150, 20);
        panel2.add(only10);
        ltextf11 = new JTextField();
        ltextf11.setBounds(590, 60, 150, 20);
        ltextf12 = new JTextField();
        //ltf12.setBounds(590,90,150,20);

        choice3 = new Choice();
        choice3.addItem("");
        choice3.addItem("Genral");
        choice3.addItem("OBC");
        choice3.addItem("SC");
        choice3.addItem("ST");
        choice3.addItem("Other");
        choice3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent v) {
                ltextf12.setText((String) choice3.getSelectedItem());
            }
        });
        choice3.setBounds(590, 90, 150, 20);
        panel2.add(choice3);

        ltextf13 = new JTextField();
        ltextf13.setBounds(590, 120, 150, 20);
        ltextf14 = new JTextField();
        ltextf14.setBounds(590, 150, 150, 20);
        ltextf15 = new JTextField();
        ltextf15.setBounds(590, 180, 150, 20);
        ltextf16 = new JTextField();
        ltextf16.setBounds(590, 210, 150, 20);
        ltextf17 = new JTextField();
        //ltf17.setBounds(590,240,150,20);
        choice4 = new Choice();
        choice4.addItem("");
        choice4.addItem("Teacher");
        choice4.addItem("Principal");
        choice4.addItem("Faculty");
        choice4.addItem("Guard");
        choice4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent v) {
                ltextf17.setText((String) choice4.getSelectedItem());
            }
        });
        choice4.setBounds(590, 240, 150, 20);
        panel2.add(choice4);

        panel2.add(ltextf1);
        panel2.add(ltextf2);
        panel2.add(ltextf3);
        panel2.add(ltextf4);
        panel2.add(jscroll);
        //panel2.add(ltf6);
        panel2.add(ltextf7);
        panel2.add(ltextf8);
        //panel2.add(ltf9);
        panel2.add(ltextf10);
        panel2.add(ltextf11);
        panel2.add(ltextf12);
        panel2.add(ltextf13);
        panel2.add(ltextf14);
        panel2.add(ltextf15);
        panel2.add(ltextf16);
        //panel2.add(ltf17);
        ltextf8.setText(is);

        submit = new JButton("Update", new ImageIcon("images/add.png"));
        submit.setBounds(200, 500, 110, 30);
        reset = new JButton("Reset", new ImageIcon("images/clear.png"));
        reset.setBounds(340, 500, 110, 30);
        getstudent = new JButton("Get Details", new ImageIcon("images/add1.png"));
        getstudent.addActionListener(new SearchEvent1());
        getstudent.setBounds(480, 500, 130, 30);
        delete = new JButton("Delete", new ImageIcon("images/de.png"));
        delete.addActionListener(new DeleteEvent1());
        delete.setBounds(630, 500, 120, 30);

        submit.addActionListener(this);
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ltextf1.setText("");
                ltextf2.setText("");
                ltextf3.setText("");
                ltextf4.setText("");
                ltextf5.setText("");
                ltextf6.setText("Male");
                ltextf7.setText("");
                //ltf8.setText("");
                ltextf8.setText(is);
                ltextf9.setText("");
                ltextf10.setText("");
                ltextf11.setText("");
                ltextf12.setText("");
                ltextf13.setText("");
                ltextf14.setText("");
                ltextf15.setText("");
                ltextf16.setText("");
                ltextf17.setText("");
                choice5.select(0);
                choice4.select(0);
                choice3.select(0);
                box1.setSelected(true);
                box2.setSelected(false);

            }

        });

        JLabel limg2 = new JLabel(new ImageIcon("images/3.png"));
        limg2.setBounds(30, 5, 75, 75);
        panel.add(limg2);

        panel.add(panel2);
        panel.add(submit);
        panel.add(reset);
        panel.add(getstudent);
        panel.add(delete);

        add(BorderLayout.CENTER, panel);
        setSize(830, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        ph = 0;
        ph2 = 0;
        ph3 = 0;
        ch1 = 0;
        Staff1 = ltextf1.getText();
        Staff2 = ltextf2.getText();
        Staff3 = ltextf3.getText();
        Staff4 = ltextf4.getText();
        Staff5 = ltextf5.getText();
        Staff6 = ltextf6.getText();
        Staff7 = ltextf7.getText();
        Staff8 = ltextf8.getText();
        Staff9 = ltextf9.getText();
        Staff10 = ltextf10.getText();
        Staff11 = ltextf11.getText();
        Staff12 = ltextf12.getText();
        Staff13 = ltextf13.getText();
        Staff14 = ltextf14.getText();
        Staff15 = ltextf15.getText();
        Staff16 = ltextf16.getText();
        Staff17 = ltextf17.getText();
        if (e.getSource() == submit) {

            if (Staff1.isEmpty() || Staff2.isEmpty() || Staff3.isEmpty() || Staff4.isEmpty() || Staff5.isEmpty() || Staff6.isEmpty() || Staff7.isEmpty() || Staff8.isEmpty() || Staff9.isEmpty() || Staff10.isEmpty() || Staff11.isEmpty() || Staff12.isEmpty() || Staff13.isEmpty() || Staff14.isEmpty() || Staff15.isEmpty() || Staff16.isEmpty() || Staff17.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Some fields is empty", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                pass9 = 0;
                String i = ltextf10.getText();

                for (int y = 0; y < i.length(); ++y) {
                    if (i.length() <= 9) {
                        pass9 = 7;
                        ph = 1;
                    }
                    if (!Character.isDigit(i.charAt(y))) {
                        pass9 = 7;
                        ph = 1;
                    }
                    if (i.length() > 10) {
                        pass9 = 7;
                        ph = 1;
                    }
                }

                if (ch1 == 0) {
                    if (pass9 == 0) {
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", username, password);
                            String query = "delete from vstaff where id1 = ?";
                            PreparedStatement preparedStmt = conn.prepareStatement(query);
                            preparedStmt.setString(1, Staff1);
                            preparedStmt.execute();
                            conn.close();
                        } catch (Exception r) {
                        }

                        try {

                            JOptionPane.showMessageDialog(this, "Update Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                            ltextf1.setText("");
                            ltextf2.setText("");
                            ltextf3.setText("");
                            ltextf4.setText("");
                            ltextf5.setText("");
                            ltextf6.setText("Male");
                            ltextf7.setText("");
                            ltextf8.setText("");
                            ltextf9.setText("");
                            ltextf10.setText("");
                            ltextf11.setText("");
                            ltextf12.setText("");
                            ltextf13.setText("");
                            ltextf14.setText("");
                            ltextf15.setText("");
                            ltextf16.setText("");
                            ltextf17.setText("");
                            choice5.select(0);
                            box1.setSelected(true);
                            box2.setSelected(false);

                            con.close();

                        } catch (Exception ee) {
                        }
                    } else {
                        if (ph == 1) {
                            JOptionPane.showMessageDialog(this, "Invalid Phone No", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        if (ph3 == 1) {
                            JOptionPane.showMessageDialog(this, "Staff ID only number accepted", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    if (ch1 == 1) {
                        JOptionPane.showMessageDialog(this, "Staff ID already added", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }

        }
    }

    private class DeleteEvent1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == delete) {
                int de = 0;
                dl = JOptionPane.showInputDialog(obj, "Enter Staff ID");
                if (!dl.isEmpty()) {
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", username, password);
                        stm2 = con.createStatement();
                        rs2 = stm2.executeQuery("Select id1 from vstaff");
                        while (rs2.next()) {
                            if (dl.equals(rs2.getString(1))) {
                                de = 1;
                                break;
                            }
                        }
                        con.close();
                    } catch (Exception ep) {
                    }
                    if (de == 1) {

                        try {

                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", username, password);
                            String query = "delete from vstaff where id1 = ?";
                            PreparedStatement preparedStmt = conn.prepareStatement(query);
                            preparedStmt.setString(1, dl);
                            preparedStmt.execute();
                            JOptionPane.showMessageDialog(obj, "Delete Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                            conn.close();

                        } catch (Exception p) {
                            JOptionPane.showMessageDialog(obj, p, "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(obj, "Data not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(obj, "Textfield is empty", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }

    }

    private class SearchEvent1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == getstudent) {
                int de = 0;
                dl = JOptionPane.showInputDialog(obj, "Enter Staff ID");
                if (!dl.isEmpty()) {
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", username, password);
                        stm2 = con.createStatement();
                        rs2 = stm2.executeQuery("Select id1 from vstaff");
                        while (rs2.next()) {
                            if (dl.equals(rs2.getString(1))) {
                                de = 1;
                                break;
                            }
                        }
                        con.close();
                    } catch (Exception ep) {
                    }
                    if (de == 1) {

                        try {

                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", username, password);
                            stm2 = con.createStatement();
                            rs2 = stm2.executeQuery("SELECT  *  FROM vstaff WHERE id1=" + dl + " ");

                            while (rs2.next()) {

                                ltextf1.setText(rs2.getString(1));
                                ltextf2.setText(rs2.getString(2));
                                ltextf3.setText(rs2.getString(3));
                                ltextf4.setText(rs2.getString(4));
                                ltextf5.setText(rs2.getString(5));
                                ltextf6.setText(rs2.getString(6));
                                ltextf7.setText(rs2.getString(7));
                                ltextf8.setText(rs2.getString(8));
                                ltextf9.setText(rs2.getString(9));
                                ltextf10.setText(rs2.getString(10));
                                ltextf11.setText(rs2.getString(11));
                                ltextf12.setText(rs2.getString(12));
                                ltextf13.setText(rs2.getString(13));
                                ltextf14.setText(rs2.getString(14));
                                ltextf15.setText(rs2.getString(15));
                                ltextf16.setText(rs2.getString(16));
                                ltextf17.setText(rs2.getString(17));

                            }
                            String sk = ltextf6.getText();
                            String sk2 = ltextf9.getText();
                            String sk3 = ltextf12.getText();
                            String sk4 = ltextf17.getText();
                            if (sk.equalsIgnoreCase("Male")) {
                                box1.setSelected(true);
                            }
                            if (sk.equalsIgnoreCase("Female")) {
                                box2.setSelected(true);
                            }
                            choice5.select(sk2);
                            choice3.select(sk3);
                            choice4.select(sk4);
                            con.close();

                        } catch (Exception p) {
                            JOptionPane.showMessageDialog(obj, p, "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(obj, "Data not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(obj, "Textfield is empty", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }

    }

    public static void main(String[] args) {

        new UpdateStaff();
    }

}
