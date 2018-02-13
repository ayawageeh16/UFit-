 package View;
 import java.awt.*;
 import java.awt.event.*;
 import java.io.*;
 import java.sql.*;
 import javax.swing.*;
 import javax.swing.filechooser.FileNameExtensionFilter;

import dao.DataBaseConnection;

	  

public class ViewDoctor extends JFrame {
	 	    JButton select, browse;
	 	    JLabel label;
	 	    JComboBox<String> textSchedule;
	 	    JTextArea area;
	 	    String s, schedulechoice;
	 	    int schedulenum;
	 	    JScrollPane scrollPane;
	 	    DataBaseConnection con = new DataBaseConnection();
	 	  
 public ViewDoctor(){
	 super("Trainer Page");
	 initialize();
	 
      }
              //method for view  
	 	  public void initialize() {
	 	   
	 	    getContentPane().setBackground(new Color(0, 139, 139));
	 	    
	 	    
	 	    browse = new JButton(" Load Image");
	 	    browse.setFont(new Font("Tahoma", Font.BOLD, 14));
	 	    browse.setBounds(119, 353, 152, 40);
	 	    
	 	   JButton select = new JButton("Insert");
	 	    select.setFont(new Font("Tahoma", Font.BOLD, 14));
	 	    select.setBounds(317, 404, 100, 40);
	 	    
	 	    String[] schedule = {"2 Days", "3 Days", "Every Days"};
	 	    textSchedule = new JComboBox<>(schedule);
	 	    textSchedule.setBounds(523,265,122,31);
	 	    
	 	   scrollPane = new JScrollPane();
	 	    scrollPane.setBounds(429, 56, 238, 153);
	 	    getContentPane().add(scrollPane);
	 	    
	 	    area = new JTextArea("DESCRIPTION",100, 150);
	 	    scrollPane.setViewportView(area);
	 	    area.setFont(new Font("Courier New", Font.BOLD, 14));
	 	    
	 	    label = new JLabel();
	 	    label.setBackground(Color.LIGHT_GRAY);
	 	    label.setBounds(10,56,357,286);   
	 	    
	 	   getContentPane().add(label);
	 	    getContentPane().add(textSchedule);
	 	    getContentPane().add(browse);
	 	    getContentPane().setLayout(null);
	 	    getContentPane().add(select);
	 	    
	 	    JLabel lblNewLabel = new JLabel("Nutritionist Profile");
	 	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	 	    lblNewLabel.setForeground(Color.BLACK);
	 	    lblNewLabel.setBounds(267, 11, 173, 23);
	 	    getContentPane().add(lblNewLabel);
	 	    
	 	    JLabel lblNewLabel_1 = new JLabel("Notes");
	 	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	 	    lblNewLabel_1.setBounds(512, 31, 46, 14);
	 	    getContentPane().add(lblNewLabel_1);
	 	    
	 	    JLabel lblNewLabel_2 = new JLabel("Trophic System");
	 	    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
	 	    lblNewLabel_2.setBounds(83, 27, 116, 23);
	 	    getContentPane().add(lblNewLabel_2);
	 	    
	 	    JLabel lblNewLabel_3 = new JLabel("Schedule :");
	 	    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
	 	    lblNewLabel_3.setBounds(429, 265, 77, 31);
	 	    getContentPane().add(lblNewLabel_3);
	 	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	    setSize(709,494);
	 	    setVisible(true);
	 	  
	 	    //button to browse the image into jlabel
	 	    browse.addActionListener(new ActionListener(){
	 	        @Override
	 	     public void actionPerformed(ActionEvent e){
	 	         JFileChooser fileChooser = new JFileChooser();
	 	         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	 	         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
	 	         fileChooser.addChoosableFileFilter(filter);
	 	         int result = fileChooser.showSaveDialog(null);
	 	         if(result == JFileChooser.APPROVE_OPTION){
	 	             File selectedFile = fileChooser.getSelectedFile();
	 	             String path = selectedFile.getAbsolutePath();
	 	             label.setIcon(ResizeImage(path));
	 	             s = path;
	 	              }
	 	         else if(result == JFileChooser.CANCEL_OPTION){
	 	             System.out.println("No Data");
	 	         }
	 	     }
	 	    });
	 	 
         
	 	    //button to select data to know if contain data or no
	 	    select.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					schedulechoice = (String) textSchedule.getSelectedItem();
					if(schedulechoice == "2 Days") {
						schedulenum = 1;
					}else if(schedulechoice == "3 Days") {
						schedulenum = 2;
					}else {
						schedulenum = 3;
					}
					boolean b= select();
					if(b == true) {
						update();
					}else {
						insert();
					}
			 
				}
			});
          
	 	    
	 	  }
		 	    //Methode To Resize The ImageIcon 
	        public ImageIcon ResizeImage(String imgPath){
	             ImageIcon MyImage = new ImageIcon(imgPath); 
	             Image img = MyImage.getImage();
	             Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
	             ImageIcon image = new ImageIcon(newImage);
	              return image;
	        }
 
	        public boolean select() {
	        	
	        	// TODO Auto-generated method stub
				try {
					  String sql="select * from nutritionist where schedule="+schedulenum;
					  Statement st=con.con.createStatement();
					  ResultSet rs=st.executeQuery(sql);
					 if( rs.next()==false) {
					   
						  return false;
					  }
					  else {
						  return true;
						  
					  }
					
				}
				catch(Exception ex) {
					ex.printStackTrace();
					return false;
				}
	        }
	        
	        public void insert() {
	        	
	        	try{
	 	               String sql = "insert into nutritionist values (?,?,?)";
	 	                PreparedStatement ps=con.con.prepareStatement(sql);
	 	                InputStream is = new FileInputStream(new File(s));
	 	                ps.setInt(1,schedulenum);
	 	                ps.setString(2, area.getText());
	 	                ps.setBlob(3, is);
	 	               if( ps.executeUpdate()==1) {
	 	               JOptionPane.showMessageDialog(null, "Data Inserted");
	 	               }
	 	               else {
	 	            	  JOptionPane.showConfirmDialog(null,"error in inserting data");
	 	               }
	 	               
	 	               }
	 	           catch(Exception ex){
	 	               ex.printStackTrace( );
	 	           }
	        }
	        
	        public void update() {
	        	
	        	try {
	 				  String sql1="update nutritionist set `nutritionist notes`=? , `trophic system`=?  where schedule=? ";
					  PreparedStatement ps=con.con.prepareStatement(sql1);
					  InputStream is = new FileInputStream(new File(s));
					  ps.setInt(3,schedulenum );
					  ps.setString(1,area.getText());
					  ps.setBlob(2, is);
					  ps.executeUpdate();
					  JOptionPane.showMessageDialog(null, "updated data");
	 				}
	 				catch(Exception ex) {
	 					JOptionPane.showMessageDialog(null, "data not update");
	 					ex.printStackTrace();
	 				}
	        	
	        }
 }
