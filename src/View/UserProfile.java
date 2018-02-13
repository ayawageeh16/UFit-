package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import net.proteanit.sql.DbUtils;
import services.UserProfileRequestService;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UserProfile extends JFrame {

	private JFrame frame;
	private String email;
	private JLabel firstname, lastname;
	private JTable userSchedule;
	private ImageIcon image;
	public UserProfile(String email) {
		new UserProfileRequestService(email);
	}
	
	public UserProfile() {
	}

	public void response(String firstname, String lastName, ResultSet rs, String notes, InputStream trophic) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize(firstname, lastName, rs, notes, trophic);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}

	protected void initialize(String firstname, String lastName, ResultSet rs, String notes, InputStream trophic) throws SQLException, IOException {

		frame = new JFrame();
		frame.setBounds(100, 100, 780, 563);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(0, 41, 384, 483);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Nutritionist notes");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		panel.add(lblNewLabel);
		
		TextArea textArea = new TextArea();
		textArea.setFont(new Font("Courier New", Font.PLAIN, 15));
		textArea.setEditable(false);
		textArea.setText(notes);
		textArea.setRows(7);
		textArea.setColumns(40);
		panel.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Trophic System");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		panel.add(lblNewLabel_1);
		
		try {
		BufferedImage buff_image = ImageIO.read(trophic);
		BufferedImage thumbnail = Thumbnails.of(buff_image).size(400, 400).asBufferedImage();
		image = new ImageIcon(thumbnail);
		System.out.println("test");
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setIcon(image);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblNewLabel_2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(390, 41, 374, 483);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Schedule");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		panel_1.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		userSchedule = new JTable();
		userSchedule.setRowHeight(40);
		userSchedule.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		userSchedule.setModel(DbUtils.resultSetToTableModel(rs));
		userSchedule.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollPane.setViewportView(userSchedule);
		
		JLabel lbFirstName = new JLabel(firstname+" "+lastName);
		lbFirstName.setFont(new Font("Script MT Bold", Font.PLAIN, 21));
		lbFirstName.setBounds(352, 11, 150, 24);
		frame.getContentPane().add(lbFirstName);
	}

	
}
