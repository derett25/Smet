package com.linesb.smet.UI;


import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonUI extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 743272070848711300L;
	
	public ButtonUI(ActionListener listener, String iconName) {
		super();
		setFocusable(false);
		setBorder(BorderFactory.createEmptyBorder());
		loadIcon(iconName);
		addActionListener(listener);
	}
	
	private void loadIcon(String name) {
		final String ICON_FOLDER = "icons/";
		BufferedImage icon;
		try {
			icon = ImageIO.read(new File(ICON_FOLDER + name + ".png"));
			setIcon(new ImageIcon(icon));
		} catch (IOException e) {
			// Failed to load icon
		}
    }
}
