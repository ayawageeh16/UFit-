package View;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import model.Images;
import services.HomePageRequestService;
import net.coobird.thumbnailator.Thumbnails;

import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class HomePage {

	private JFrame frame;
	private BufferedImage buff, buff2;
	private static int postcounter = 0;
	private Images imageObject ;
	static String email;

	public HomePage(String email) {
		this.email = email;
		new HomePageRequestService();
	}
	
	public HomePage(ArrayList<String> posts, ArrayList<Images> image) {
		response(posts, image);
	}
	
	public void response(ArrayList<String> posts, ArrayList<Images> image) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize(posts, image);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize(ArrayList<String> posts, ArrayList<Images> image) throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPane = new JPanel();
		frame.setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{424, 0};
		gbl_contentPane.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JToolBar toolbar = new JToolBar ();
		GridBagConstraints gbc_toolbar = new GridBagConstraints();
		gbc_toolbar.insets = new Insets(0, 0, 5, 0);
		gbc_toolbar.anchor = GridBagConstraints.NORTH;
		gbc_toolbar.fill = GridBagConstraints.HORIZONTAL;
		gbc_toolbar.gridx = 0;
		gbc_toolbar.gridy = 0;
		frame.getContentPane().add(toolbar, gbc_toolbar);
		toolbar.setFloatable(false);
		
		//profile button
		JButton profileButton = new JButton ("My Profile");
		toolbar.add(profileButton);
		profileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {			
				new UserProfile(email); 
			}
		});
		
		//post
		JTextPane textPane = new JTextPane();
		textPane.setText(posts.get(postcounter));
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridheight = 2;
		gbc_textPane.insets = new Insets(0, 0, 5, 0);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 0;
		gbc_textPane.gridy = 1;
		contentPane.add(textPane, gbc_textPane);
		textPane.setVisible(true);
		
		//post image
		JLabel lblNewLabel = new JLabel();
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 3;
		gbc_lblNewLabel.gridwidth=10;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		
		try {
			imageObject = image.get(0);
			byte [] im = imageObject.getQuestion();
			ImageIcon ic = new ImageIcon(im);
			Image postim = ic.getImage();
			Image editedim = postim.getScaledInstance(500,400, Image.SCALE_SMOOTH);
			ImageIcon postimage = new ImageIcon (editedim);
			lblNewLabel.setIcon(postimage);
		}catch(Exception e) {
			e.printStackTrace();
		}
	

		
		//next post button
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(postcounter<(posts.size()-1)) {
					postcounter++;
					textPane.setText(posts.get(postcounter));
					try {
						imageObject = image.get(postcounter);
						byte [] im = imageObject.getQuestion();
						ImageIcon ic = new ImageIcon(im);
						Image postim = ic.getImage();
						Image editedim = postim.getScaledInstance(500,400, Image.SCALE_SMOOTH);
						ImageIcon postimage = new ImageIcon (editedim);
						lblNewLabel.setIcon(postimage);
						}catch(Exception e1) {
							e1.printStackTrace();
						}
								
				}
			}		
		});
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 0, 5, 0);
		gbc_btnNext.gridx = 0;
		gbc_btnNext.gridy = 6;
		contentPane.add(btnNext, gbc_btnNext);
		btnNext.setVisible(true);
		
		//previous post button
		JButton btnNewButton = new JButton("previous");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(postcounter>0) {
					postcounter--;
					textPane.setText(posts.get(postcounter));	
					try {
						imageObject = image.get(postcounter);
						byte [] im = imageObject.getQuestion();
						ImageIcon ic = new ImageIcon(im);
						Image postim = ic.getImage();
						Image editedim = postim.getScaledInstance(500,400, Image.SCALE_SMOOTH);
						ImageIcon postimage = new ImageIcon (editedim);
						lblNewLabel.setIcon(postimage);
						}catch(Exception e1) {
							e1.printStackTrace();
						}
				}
			}		
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 7;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		
	}
	

}
