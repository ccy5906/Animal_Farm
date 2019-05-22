package project.Dog.src;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class stage_2_1 extends JFrame {
	private JPanel panel;
	ImageIcon back,hd1, hd2;
	JLabel hand1, hand2;
	
	public stage_2_1() {
		super("강아지 Stage2-1");
     	
		 Dimension res = Toolkit.getDefaultToolkit().getScreenSize();	
		 back = rszImg("img/dog/stage_2-1.jpg", res.width, res.height);
		 
		   panel = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(back.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponent(g);
				}
			};
			panel.setLayout(null);
			panel.setBounds(0, 0, res.width, res.height);
			getContentPane().add(panel);
			
			hd1 = rszImg("img/dog/dog_hand_1.png",350,350);
			hand1 = new JLabel(hd1);
			hand1.setBounds(150, res.height-450, 350, 350);
			panel.add(hand1);
			
			hd2 = rszImg("img/dog/dog_hand_2.png",350,350);
			hand2 = new JLabel(hd2);
			hand2.setBounds(res.width-550, res.height-450, 350, 350);
			panel.add(hand2);
			
			
			
			
			add(panel);
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setVisible(true); 
			

	}
	
	public ImageIcon rszImg(String img, int width, int hight) {
		ImageIcon b_ic = new ImageIcon(img);
		Image icc = b_ic.getImage();
		Image logo = icc.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(logo);

		return ic;
	}//ImageIcon rszImg
	
}
