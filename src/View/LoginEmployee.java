package View;

import java.awt.EventQueue;

import javax.swing.*;

import services.LoginEmpReqService;
import services.LoginEmpResService;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



	public class LoginEmployee extends JFrame{
	    
		   JComboBox LogInAs;
		   JLabel mail;
		    JTextField mailTextField1;
		    JPanel p1,p2;
		    JLabel pw;
		    JPasswordField pwField1;
		    String email, password, job;
		    // End of variables declaration    
		    
		    
		   public LoginEmployee(String message, String job) {
			   response(message, job);
		   }

			public LoginEmployee() {
		        
		        JFrame LoginEmployee =new JFrame();
		         p1 = new JPanel();
		         p2 = new JPanel();
		         mail = new JLabel();
		         pw = new JLabel();
		         mailTextField1 = new JTextField();
		         pwField1 = new JPasswordField();
		         LogInAs = new JComboBox();
		         
		         LoginEmployee.setSize(470,420);
		         LoginEmployee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		         LoginEmployee.getContentPane().setLayout(null);
		         LoginEmployee.getContentPane().add(p2);
		        
		     
		        p2.setBackground(new java.awt.Color(51, 0, 51));
		        p2.setBounds(10,0, 400,300);
		        p2.setLayout(null);
		        
		        p1.setBackground(new java.awt.Color(102, 102, 102));
		        p1.setBounds(0,0, 400,300);
		        p1.setLayout(null);
		      
		        
		        
		        mail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		        mail.setForeground(new java.awt.Color(255, 255, 255));
		        mail.setText("E-mail :");
		        mail.setBackground(new java.awt.Color(240,240,240));
		        p2.add(mail);
		        mail.setBounds(40, 82, 80, 30);

		        
		        
		        
		        pw.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		        pw.setForeground(new java.awt.Color(255, 255, 255));
		        pw.setText("Password :");
		        p2.add(pw);
		        pw.setBounds(40, 156, 110, 30);
		        pw.setBackground(new java.awt.Color(240,240,240));
		        
		        
		        
		        mailTextField1.setText(" ");
		        p2.add(mailTextField1);
		        mailTextField1.setBounds(130, 79, 270, 40);

		        
		        
		        
		       
		        pwField1.setText("");
		        p2.add(pwField1);
		        pwField1.setBounds(130, 153, 270, 40);
		        
		        
		        LogInAs.setBounds(130, 215, 110, 40);
		        LogInAs.setFont(new Font("Tahoma", Font.BOLD, 14)); // NOI18N
		        LogInAs.setForeground(new Color(0, 0, 0));
		        LogInAs.setBackground(new java.awt.Color(255, 255, 255));
		        LogInAs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Trainer", "Nutritionist " }));
		        
		        p2.add(LogInAs);
		        
		        
		        LoginEmployee.getContentPane().add(p2);
		        p2.setBounds(0, 0, 460, 390);
		        
		        JLabel lblNewLabel = new JLabel("Job :");
		        lblNewLabel.setForeground(Color.WHITE);
		        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		        lblNewLabel.setBounds(40, 229, 46, 14);
		        p2.add(lblNewLabel);
		        
		        JButton btnNewButton = new JButton("Login");
		        btnNewButton.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		email = mailTextField1.getText().toString();
		        		password = pwField1.getText().toString();
		        		job =(String) LogInAs.getSelectedItem();
		        		new LoginEmpReqService(email, password, job);
		        		
		        	}
		        });
		        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		        btnNewButton.setBounds(183, 298, 110, 30);
		        p2.add(btnNewButton);
		        LoginEmployee.setResizable(false);
		        LoginEmployee.setVisible(true);

		    }
			
		    
		    private void response(String message, String job) {
			
		    	if(message=="success")
				{
					JOptionPane.showMessageDialog(this, "Login success" );
					System.out.println(job);
					if(job == "Admin") {
						System.out.println(job);
						new Admin();
					}else if(job == "Trainer") {
						new TrainerPage();
					}else if(job == "Nutritionist ") {
						System.out.println(job);
						new ViewDoctor();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Login failed: "+ message);
				}
		    }
	 	}