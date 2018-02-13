package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import model.HomePageAdsDTO;
import java.awt.GridLayout;

public class PostUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public PostUI(HomePageAdsDTO dto) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//image icon 
		 ImageIcon image = new ImageIcon (PostUI.class.getResource("/gym.png"));
		 Image tempimage = image.getImage();
		 Image newimg = tempimage.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH); 
		 image = new ImageIcon(newimg);
		 
		JLabel imagelabel = new JLabel();
		GridBagConstraints gbc_imagelabel = new GridBagConstraints();
		gbc_imagelabel.gridheight = 3;
		gbc_imagelabel.gridwidth = 3;
		gbc_imagelabel.insets = new Insets(0, 0, 5, 5);
		gbc_imagelabel.gridx = 1;
		gbc_imagelabel.gridy = 1;
		add(imagelabel, gbc_imagelabel);
		imagelabel.setIcon(image);
		
		JTextPane gymPane = new JTextPane();
		gymPane.setText("U-Fit Gym");
		GridBagConstraints gbc_gymPane = new GridBagConstraints();
		gbc_gymPane.gridwidth = 2;
		gbc_gymPane.insets = new Insets(0, 0, 5, 5);
		gbc_gymPane.fill = GridBagConstraints.BOTH;
		gbc_gymPane.gridx = 4;
		gbc_gymPane.gridy = 1;
		add(gymPane, gbc_gymPane);
		
		JTextPane postPane = new JTextPane();
		postPane.setText(dto.getpost());
		GridBagConstraints gbc_postPane = new GridBagConstraints();
		gbc_postPane.gridheight = 6;
		gbc_postPane.gridwidth = 10;
		gbc_postPane.fill = GridBagConstraints.BOTH;
		gbc_postPane.gridx = 0;
		gbc_postPane.gridy = 4;
		add(postPane, gbc_postPane);
		

	}

}
