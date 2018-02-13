package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import services.RegisterationServiceRequest;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class  RegisterationPage extends JFrame implements ActionListener {
	 private JFrame frame;
	 private JTextField firstname,lastname,email;
	 private JComboBox<String> schedul;
	 private JPasswordField password;
	 private JButton btn;
	 public RegisterationPage()  {
		initialize();
	}
	 
	 public RegisterationPage(String message, String email) {
		 response(message, email);
	 }
	 
		public void initialize() {
			frame = new JFrame();
			frame.getContentPane().setForeground(Color.PINK);
			frame.getContentPane().setBackground(Color.DARK_GRAY);
			frame.setBounds(100, 100, 750, 519);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel fn = new JLabel(" FirstName :");
			 fn.setForeground(Color.PINK);
			 fn.setFont(new Font("Tahoma", Font.BOLD, 14));
			 fn.setBounds(127, 65, 108, 30);
			frame.getContentPane().add( fn);
			
			 firstname = new JTextField();
			 firstname.setBounds(241, 56, 315, 39);
			frame.getContentPane().add( firstname);
			firstname.setColumns(10);
			
			JLabel  ln = new JLabel("LastName :");
			 ln.setForeground(Color.PINK);
			 ln.setFont(new Font("Tahoma", Font.BOLD, 14));
			 ln.setBounds(127, 138, 86, 23);
			frame.getContentPane().add( ln);
			
			 lastname = new JTextField();
			 lastname.setBounds(241, 132, 315, 39);
			frame.getContentPane().add( lastname);
			 lastname.setColumns(10);
			
			JLabel  em = new JLabel(" Email :");
			 em.setForeground(Color.PINK);
			 em.setFont(new Font("Tahoma", Font.BOLD, 14));
			 em.setBounds(127, 208, 86, 30);
			frame.getContentPane().add( em);
			
			 email = new JTextField();
			 email.setBounds(241, 206, 315, 39);
			 frame.getContentPane().add( email);
			 email.setColumns(10);
			
			JLabel  pass = new JLabel("Password :");
			 pass.setForeground(Color.PINK);
			 pass.setFont(new Font("Tahoma", Font.BOLD, 14));
			 pass.setBounds(127, 277, 86, 30);
			frame.getContentPane().add( pass);
			
			 password = new JPasswordField();
			 password.setBounds(241, 277, 315, 39);
			frame.getContentPane().add( password);
			
		  btn = new JButton("Register");
		  btn.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		
		  		String fname=firstname.getText();
				String lname=lastname.getText();
				String mail=email.getText();
				String pass=password.getText();
				int schedulee;
				// get the selected item:
				String selectedSchedule = (String) schedul.getSelectedItem();
				if(selectedSchedule == "2 Days") {
					schedulee = 1;
				}else if(selectedSchedule == "3 Days") {
					schedulee = 2;
				}else {
					schedulee = 3;
				}
				RegisterationServiceRequest rs=new RegisterationServiceRequest( fname,  lname,  mail,  pass, schedulee);
				
		  	}
		  });
			 btn.setFont(new Font("Tahoma", Font.BOLD, 14));
			 btn.setBackground(Color.LIGHT_GRAY);
			 btn.setForeground(Color.GRAY);
			 btn.setBounds(321, 424, 100, 39);
			frame.getContentPane().add(btn);
			
			JLabel lblNewLabel = new JLabel("Schedule :");
			lblNewLabel.setForeground(Color.PINK);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(127, 350, 86, 23);
			frame.getContentPane().add(lblNewLabel);
			
			String[] schedule = {"2 Days", "3 Days", "Every Days"};
			schedul = new JComboBox<>(schedule);
			schedul.setForeground(Color.PINK);
			schedul.setBounds(241, 350, 107, 22);
			frame.getContentPane().add(schedul);
			
			
			frame.setVisible( true);
			frame.setResizable( false);
	}
		
		public void response(String message,String email ) {
			if(message=="success")
			{
				JOptionPane.showMessageDialog(this, "Registeration success" );	
				new HomePage(email);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Registeration failed: "+ message);
			}
			
			
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}