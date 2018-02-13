package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.DataBaseConnection;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

		public class Admin extends javax.swing.JFrame {

			 JFrame frame;
		     JTextField txtDdmmyyy;
		     String s;
		     JLabel label;
			 ResultSet rs;
			 Connection con =null;
			 SimpleDateFormat format;
			 Date date;
			public Admin() {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							initialize();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				
			    
			}
			
			/**
			 * Initialize the contents of the frame.
			 */
			private void initialize() {
				frame = new JFrame();
				frame.setBounds(100, 100, 487, 441);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				JPanel panel = new JPanel();
				panel.setBackground(SystemColor.activeCaption);
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				panel.setLayout(null);
				
				JTextArea txtrWriteHereYour = new JTextArea();
				txtrWriteHereYour.setText("Write Here Your Advetisment");
				txtrWriteHereYour.setToolTipText("");
				txtrWriteHereYour.setBounds(10, 36, 451, 90);
				panel.add(txtrWriteHereYour);
				
				JLabel lblAddAdvertisement = new JLabel("Add Advertisement");
				lblAddAdvertisement.setBounds(168, 11, 129, 14);
				lblAddAdvertisement.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblAddAdvertisement.setForeground(Color.BLACK);
				lblAddAdvertisement.setBackground(Color.LIGHT_GRAY);
				panel.add(lblAddAdvertisement);
				
				JButton btnPost = new JButton("Post");
				btnPost.setBounds(161, 369, 136, 23);
				btnPost.setForeground(SystemColor.activeCaption);
				btnPost.setFont(new Font("Tahoma", Font.BOLD, 13));
				btnPost.setBackground(Color.GRAY);
				panel.add(btnPost);
				
			    label = new JLabel("");
				label.setBounds(10, 190, 451, 134);
				panel.add(label);
				
				JButton btnUploadImage = new JButton("Upload Image");
				btnUploadImage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
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
				btnUploadImage.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) {
					}
				});
				
				
				
				btnUploadImage.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnUploadImage.setForeground(Color.BLACK);
				
				btnUploadImage.setBackground(SystemColor.inactiveCaption);
				btnUploadImage.setBounds(147, 148, 150, 23);
				panel.add(btnUploadImage);
				
				txtDdmmyyy = new JTextField();
	            format = new SimpleDateFormat("dd/MM/yyy");
	            date = new Date();
				txtDdmmyyy.setText(format.format(date));
				txtDdmmyyy.setBounds(98, 335, 150, 20);
				panel.add(txtDdmmyyy);
				txtDdmmyyy.setColumns(10);
				
				JLabel lblDate = new JLabel("Date");
				lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblDate.setBounds(30, 336, 58, 14);
				panel.add(lblDate);
				
				
				btnPost.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						 try{
							 DataBaseConnection ad = new DataBaseConnection ();
				                PreparedStatement ps=  ad.con.prepareStatement("insert into ads ( date , data , image  ) values ( ? ,? ,? )");
				               InputStream is = new FileInputStream(new File(s));
				               date = (Date) format.parse(txtDdmmyyy.getText().toString());
				               java.sql.Date sql = new java.sql.Date(date.getTime());
				               ps.setDate(1, sql);
				                ps.setString(2, txtrWriteHereYour.getText());
				                ps.setBlob(3, is);
				                ps.executeUpdate();
				               JOptionPane.showMessageDialog(null, "Data Inserted");
				               }catch(Exception ex){
				              // System.out.println("error");
				               JOptionPane.showMessageDialog(Admin.this,ex.getMessage());
				               ex.printStackTrace( );
				               
				           }
						
						
					}
				});
				
				frame.setVisible(true);
				
			}
			 //Methode To Resize The ImageIcon
		    public ImageIcon ResizeImage(String imgPath){
		        ImageIcon MyImage = new ImageIcon(imgPath);
		        Image img = MyImage.getImage();
		        Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
		        ImageIcon image = new ImageIcon(newImage);
		        return image;
		    }
		}
