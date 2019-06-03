package project.Dog.src;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class stage_2_1 extends JFrame {
	private JPanel panel;
	ImageIcon back,hd1, hd2;
	JButton hand1, hand2;
	
	public stage_2_1() {
		super("강아지 Stage2-1");
     	
		 Dimension res = Toolkit.getDefaultToolkit().getScreenSize();	
		 back = rszImg("img/dog/dstage2.png", res.width, res.height);
		 
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
			hand1 = new JButton(hd1);
			hand1.setBounds(150, res.height-450, 350, 350);
			hand1.setBorderPainted(false); hand1.setContentAreaFilled(false);
			
			
			hd2 = rszImg("img/dog/dog_hand_2.png",350,350);
			hand2 = new JButton(hd2);
			hand2.setBounds(res.width-550, res.height-450, 350, 350);
			hand2.setBorderPainted(false); hand2.setContentAreaFilled(false);
			
			hand1.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					new stage_2_1OK();
					dispose();
				}
			});
			
			hand2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new stage_2_1NO();
					dispose();					
				}
			});
			
			
			JLabel message = new JLabel("강아지에게 간식을 주려고 합니다. 어떻게 줘야 할까요??");
			message.setFont(new Font("굴림",Font.BOLD,30));
			message.setBounds(res.width/2-400, 250, 1000, 50);
			panel.add(message);
			
			
			
			panel.add(hand1);
			panel.add(hand2);
			add(panel);
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true); 
			

	}
/*	public static void main(String args[]) {
		new stage_2_1();
	}
	*/
	public ImageIcon rszImg(String img, int width, int hight) {
		ImageIcon b_ic = new ImageIcon(img);
		Image icc = b_ic.getImage();
		Image logo = icc.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(logo);

		return ic;
	}//ImageIcon rszImg
	
}
