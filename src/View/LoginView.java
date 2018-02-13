package View;
import javax.swing.*;

import services.LoginRequestService;
import services.LoginResponsService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LoginView extends JFrame implements ActionListener {
	JPanel jPanel1,jPanel2;
	JLabel jLabel2,jLabel1;
	JTextField email;
	JPasswordField password;
	JButton jButton1;
	private JLabel lblNewLabel;

	public LoginView(String message, String email) {
		response(message, email);
	}
	
	 public  LoginView() {

        jPanel1 = new  JPanel();
        jPanel2 = new  JPanel();
        jLabel2 = new  JLabel();
         email = new  JTextField();
        jLabel1 = new  JLabel();
        password = new  JPasswordField();
        jButton1 = new  JButton();

        
          JFrame frame=new JFrame();
          frame.setSize( 470,420);
       frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       frame.getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 204));
        jLabel2.setText("Email :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(50, 118, 80, 30);

         email.setText(" ");
        jPanel2.add(email);
         email.setBounds(168, 108, 270, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 204));
        jLabel1.setText(" password :");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(48, 192, 110, 30);
        jPanel2.add(password);
        password.setBounds(168, 190, 270, 40);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText(" Login");
        jPanel2.add(jButton1);
        jButton1.setBounds(188, 267, 110, 40);
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String mail=email.getText();
				String pw = password.getText();
				new LoginRequestService(mail, pw);
				
			}
		});

        frame.getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 460, 390);
        
        lblNewLabel = new JLabel("Create a new account.. ");
        lblNewLabel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		new RegisterationPage();
        		frame.dispose();
        	}
        });
        lblNewLabel.setForeground(Color.PINK);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(169, 330, 192, 30);
        jPanel2.add(lblNewLabel);
       frame.setVisible(true);
       frame.setResizable(false);
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
	public void response(String message, String email) {
		if(message=="success")
		{
			JOptionPane.showMessageDialog(this, "Login success" );	
			new HomePage(email);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Login failed: "+ message);
		}
	}
	
		 
	}

