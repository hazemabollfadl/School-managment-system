package schoolproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel userid, password1;
    JTextField useridtf;
    JPasswordField passwordtf;
    JButton login, login2, exit;
    Statement stm;
    Connection con;
    ResultSet rs;
    String user = "Admin";
    String pass = "S123";
    JPanel panel;

    public Login() {

        setTitle("Login");
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 450, 300);
        setTitle("School Management System");
        setIconImage(new ImageIcon("logo.png").getImage());
        JLabel label1 = new JLabel("English International school");
        label1.setLayout(null);
        label1.setBounds(50, 10, 500, 60);
        label1.setForeground(Color.blue);
        Font font = new Font("Algerian", Font.BOLD, 20);
        label1.setFont(font);
        userid = new JLabel("Admin Name :");
        userid.setLayout(null);
        userid.setBounds(100, 100, 100, 20);
        panel.add(userid);
        password1 = new JLabel("Password :");
        password1.setLayout(null);
        password1.setBounds(100, 140, 130, 20);
        panel.add(password1);
        useridtf = new JTextField();
        useridtf.setLayout(null);
        useridtf.setBounds(250, 100, 100, 20);
        panel.add(useridtf);
        passwordtf = new JPasswordField();
        passwordtf.setBounds(250, 140, 100, 20);
        passwordtf.setEchoChar('*');
        panel.add(passwordtf);
        login = new JButton("Login", new ImageIcon("images/exit.png"));
        login.setLayout(null);
        login.setBounds(100, 200, 100, 30);
        login.addActionListener(this);
        panel.add(login);
        exit = new JButton("Exit", new ImageIcon("images/cancel.png"));
        exit.setLayout(null);
        exit.setBounds(250, 200, 100, 30);
        exit.addActionListener(this);
        panel.add(exit);
        setSize(450, 300);
        setLayout(null);

        setLocationRelativeTo(null);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        panel.add(label1);
        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent Pass) {
        char[] c5 = passwordtf.getPassword();
        String p5 = String.valueOf(c5);
        int i = 0, i1 = 0;
        if (Pass.getSource() == exit) {
            System.exit(0);
        }

        if (Pass.getSource() == login) {
            String s1, s2;
            s1 = useridtf.getText();
            s2 = p5;
            if ((s1.isEmpty()) || (s2.isEmpty())) {
                JOptionPane.showMessageDialog(this, "Text Field is Empty", "Details", JOptionPane.ERROR_MESSAGE);
            } else {
                if (Pass.getSource() == login) {

                    /*		try
				{	
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
						stm=con.createStatement();
						rs=stm.executeQuery("Select * from login9");
							while (rs.next())
							{
								if(useridtf.getText().equals(rs.getString(1))&&p5.equals(rs.getString(2)))
								{
									i=1;
                                                                        
									break;
								}
							}
						if(i==1)
						{
						
							
							dispose();
							i=0;
                                                        new Main();
						}
						else
						{             	
							
						JOptionPane.showMessageDialog(this,"Incorrect ID Or Password ","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
							
					
				
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this,e,"Details",JOptionPane.ERROR_MESSAGE);
					
				}*/
                    new Main();
                }

            }
        }

    }

}
