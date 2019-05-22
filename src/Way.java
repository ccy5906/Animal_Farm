
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Way extends JFrame{

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Way();			
			}			
		});
		
	}//main
	
	public Way() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {	
				JPanel panel;
					setLocation(500,300);
				 ImageIcon back = rszImg("img/gameway.jpg",800, 500);
				 panel = new JPanel() {
						public void paintComponent(Graphics g) {
							g.drawImage(back.getImage(),0,0, null);
							setOpaque(false);
							super.paintComponent(g);
						}
					};
					panel.setLayout(null);
					panel.setSize(800,500);
					setPreferredSize(new Dimension(800,500));
					
					setSize(800,500);
					
					add(panel);
					setVisible(true);  
				
			}//run
			
		});
	}
	
	public ImageIcon rszImg(String img, int width, int hight) {
		ImageIcon b_ic = new ImageIcon(img);
		Image icc = b_ic.getImage();
		Image logo = icc.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(logo);

		return ic;
	}//ImageIcon rszImg

}//class
