package project.Dog.src;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class stage_3_1 extends JFrame{
	private JPanel panel;
	ImageIcon back,ch1, ch2;
	JButton choice1, choice2;
	
	public stage_3_1() {
		super("강아지 Stage3_1");
     	
		 Dimension res = Toolkit.getDefaultToolkit().getScreenSize();	
		 back = rszImg("img/dog/dstage3_1.jpg", res.width, res.height);
		 
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
			
			ch1 = rszImg("img/dog/choice1.png",450,250);
			choice1 = new JButton(ch1);
			choice1.setBounds(150, res.height-350, 450, 200);
			choice1.setBorderPainted(false); choice1.setContentAreaFilled(false);
			
			
			ch2 = rszImg("img/dog/choice2.png",450,250);
			choice2 = new JButton(ch2);
			choice2.setBounds(res.width-580, res.height-350, 450, 200);
			choice2.setBorderPainted(false); choice2.setContentAreaFilled(false);
			
			choice1.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					new stage_3_1NO();
					dispose();
				}
			});
			
			choice2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new stage_3_1OK();
					dispose();					
				}
			});
			panel.add(choice1);
			panel.add(choice2);
		
			add(panel);
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setVisible(true); 
		 
	}
	

	public static void main(String args[]) {
		new stage_3_1();
	}
	
	
	public ImageIcon rszImg(String img, int width, int hight) {
		ImageIcon b_ic = new ImageIcon(img);
		Image icc = b_ic.getImage();
		Image logo = icc.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(logo);

		return ic;
	}//ImageIcon rszImg
}
