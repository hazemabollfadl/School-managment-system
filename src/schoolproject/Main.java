package schoolproject ;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener{

		JMenuBar Menu;
	JMenu file,staff,student,course,about;
	JMenuItem student1,student2,student3,student4,student5,student6,student7;
	JMenuItem staff1,staff2,staff3,staff4,staff5,staff6,staff7;
	JMenuItem course1,course2,course3,course4,course5,course6,course7;
	JMenuItem l1,file1,file2,a1;
	JToolBar tbar;
	JButton AddStaff,EditStaff,Staffrecord,PaySalary,Salaryrecord,Addimition,EditStudent,Studentrecord,fees,fessrecord,t11,t12;
		public Main(){
	
			setSize(700,500);
			setTitle("SCHOOL MANAGEMENT SYSTEM");
			setIconImage(new ImageIcon("logo.png").getImage());
			Container container = getContentPane();
			JPanel p = new JPanel();
			Menu=new JMenuBar();
			file=new JMenu("Logout");
			Menu.add(file);
			staff=new JMenu("Staff");
			
			student=new JMenu("Student");
			Menu.add(student);
			Menu.add(staff);
			course=new JMenu("Course");
			Menu.add(course);
			about=new JMenu("About");
			Menu.add(about);
		//file
		file1=new JMenuItem("Logout",new ImageIcon("images/logout.png"));
		file.add(file1);
		file1.addActionListener(this);
		file2=new JMenuItem("Exit",new ImageIcon("images/exit.png"));
		file.add(file2);
		file2.addActionListener(this);
		
		//about
		a1=new JMenuItem("About",new ImageIcon("images/about.png"));
		about.add(a1);
		a1.addActionListener(this);
		
	

		//Staff
		staff1=new JMenuItem("Add Staff",new ImageIcon("images/staff.png"));
		staff.add(staff1);
		staff1.addActionListener(this);
		staff2=new JMenuItem("Edit Staff",new ImageIcon("images/editstaff.png"));
		staff2.addActionListener(this);
		staff.add(staff2);
		staff3=new JMenuItem("Staff Record",new ImageIcon("images/staffrecord.png"));
		staff.add(staff3);
		staff3.addActionListener(this);
		staff4=new JMenuItem("Pay Salary",new ImageIcon("images/pay.png"));
		staff4.addActionListener(this);
		staff.add(staff4);
		staff5=new JMenuItem("Salary Record",new ImageIcon("images/salary.png"));
		staff.add(staff5);
		staff5.addActionListener(this);


		//Student
		student1=new JMenuItem("Admission form",new ImageIcon("images/admission.png"));
		student.add(student1);
		student1.addActionListener(this);
		student2=new JMenuItem("Edit Student",new ImageIcon("images/editstudent.png"));
		student.add(student2);
		student2.addActionListener(this);
		student3=new JMenuItem("Student Record",new ImageIcon("images/studentrecord.png"));
		student.add(student3);
		student3.addActionListener(this);
		student4=new JMenuItem("Pay fees",new ImageIcon("images/fees.png"));
		student.add(student4);
		student4.addActionListener(this);
		student5=new JMenuItem("Pay fees Record",new ImageIcon("images/feesrecord.png"));
		student.add(student5);
		student5.addActionListener(this);

		//course
		course1=new JMenuItem("Add Course",new ImageIcon("images/course.png"));
		course.add(course1);
		course1.addActionListener(this);
		course2=new JMenuItem("Edit Course",new ImageIcon("images/editcourse.png"));
		course.add(course2);
		course2.addActionListener(this);
		course3=new JMenuItem("Course Record",new ImageIcon("images/courserecord.png"));
		course.add(course3);
		course3.addActionListener(this);

		tbar= new JToolBar();
			AddStaff=new JButton(new ImageIcon("images/staff.png"));
			tbar.add(AddStaff);
			AddStaff.setToolTipText("Add Staff");
			tbar.addSeparator();
			AddStaff.addActionListener(this);
			EditStaff=new JButton(new ImageIcon("images/Editstaff.png"));
			tbar.add(EditStaff);
			EditStaff.setToolTipText("Edit staff details");
			EditStaff.addActionListener(this);
			Staffrecord=new JButton(new ImageIcon("images/staffrecord.png"));
			tbar.addSeparator();
			tbar.add(Staffrecord);
			Staffrecord.setToolTipText("Staff Record");
			Staffrecord.addActionListener(this);
			PaySalary=new JButton(new ImageIcon("images/pay.png"));
			tbar.addSeparator();
			tbar.add(PaySalary);
			PaySalary.setToolTipText("Pay Salary");
			PaySalary.addActionListener(this);
			
			Salaryrecord=new JButton(new ImageIcon("images/salary.png"));
			tbar.addSeparator();
			tbar.add(Salaryrecord);
			Salaryrecord.setToolTipText("Salary Record");
			Salaryrecord.addActionListener(this);

			Addimition=new JButton(new ImageIcon("images/admission.png"));
			tbar.addSeparator();
			tbar.add(Addimition);
			Addimition.setToolTipText("Admission");
			Addimition.addActionListener(this);

			
			EditStudent=new JButton(new ImageIcon("images/editstudent.png"));
			tbar.addSeparator();
			tbar.add(EditStudent);
			EditStudent.setToolTipText("Edit Student");
			EditStudent.addActionListener(this);
			
			
			Studentrecord=new JButton(new ImageIcon("images/studentrecord.png"));
			tbar.addSeparator();
			tbar.add(Studentrecord);
			Studentrecord.setToolTipText("Student Record");
			Studentrecord.addActionListener(this);
			
			fees=new JButton(new ImageIcon("images/fees.png"));
			tbar.addSeparator();
			tbar.add(fees);
			fees.setToolTipText("fees");
			fees.addActionListener(this);
		
			fessrecord=new JButton(new ImageIcon("images/feesrecord.png"));
			tbar.addSeparator();
			tbar.add(fessrecord);
			fessrecord.setToolTipText("Fees Record");
			fessrecord.addActionListener(this);		
			
			add(tbar,BorderLayout.SOUTH);	
			setJMenuBar(Menu);
			container.add(p);
			JLabel main = new JLabel(new ImageIcon("images/main.jpg"));
			add(main,BorderLayout.CENTER);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
	
		}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==staff1||e.getSource()==AddStaff)
		{  
			new Staff();  	
		}
		if(e.getSource()==staff2||e.getSource()==EditStaff)
		{  
			new UpdateStaff(); 	
		}
		if(e.getSource()==staff3||e.getSource()==Staffrecord)
		{  
			new StaffRecord();
		}
		if(e.getSource()==staff4||e.getSource()==PaySalary)
		{  
			new Salary();	
		}
		if(e.getSource()==staff5||e.getSource()==Salaryrecord)
		{  
			new SalaryRecord();	
		}
		if(e.getSource()==student1||e.getSource()==Addimition)
		{  
			new Admission();  	
		}
		if(e.getSource()==student2||e.getSource()==EditStudent)
		{  
			new UpdateStudent(); 	
		}
		if(e.getSource()==student3||e.getSource()==Studentrecord)
		{  
			new StudentRecord();
		}
		if(e.getSource()==student4||e.getSource()==fees)
		{  
			new StudentAccount();	
		}
		if(e.getSource()==student5||e.getSource()==fessrecord)
		{  
			new AccountRecord();	
		}

		if(e.getSource()==course1)
		{  
			new Course();	
		}
		if(e.getSource()==course2)
		{  
			new UpdateCourse();	
		}
		if(e.getSource()==course3)
		{  
			new CourseRecord();	
		}


		if(e.getSource()==file1)
		{  
			dispose();
			new Login();	
		}
		if(e.getSource()==file2)
		{  
			System.exit(0);	
                }
	}

	
}
