package project.Cat.src;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class stage3_cat extends JFrame{
	private JPanel contentPane;
	
	public stage3_cat(){
			
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		getContentPane().add(contentPane);		
		
		int width = (int)(res.getWidth());
		int height = (int)(res.getHeight())-79;
		
	    ImageIcon ic  = rszImg("screen/stage3.jpg", width, height);
	    JLabel lbImage1  = new JLabel(ic);
	    lbImage1.setBounds(0, 0, width, height);
	    contentPane.add(lbImage1);
	    
	    JButton hand = new JButton(new ImageIcon("img/cat/byhand.png"));
	    hand.setBounds(290, 835, 380, 90);
	    
	    JButton toy = new JButton(new ImageIcon("img/cat/bytoy.png"));
	    toy.setBounds(1260, 835, 380, 90);
	    
	    ActionListener result = new ActionListener() {						
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == hand) {
					new stage3_cat_result1();
				}else if(e.getSource() == toy) {
					new stage3_cat_result2();
				}
			}
		};
		
		hand.setOpaque(false);
		toy.setOpaque(false);
		
		hand.setFocusPainted(false);
		toy.setFocusPainted(false);
		
		hand.setBorderPainted(false);
		toy.setBorderPainted(false);
		
		hand.addActionListener(result);
		toy.addActionListener(result);
	    
	    contentPane.add(hand);
	    contentPane.add(toy);

		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}
	
	public static void main(String args[]) {
		new stage3_cat();
	}
	
	public ImageIcon rszImg(String img, int width, int hight) {
		ImageIcon b_ic = new ImageIcon(img);
		Image icc = b_ic.getImage();
		Image logo = icc.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(logo);

		return ic;
	}
}
