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

public class stage1_cat extends JFrame{
	private JPanel contentPane;
	
	public stage1_cat(){
			
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		getContentPane().add(contentPane);		
		
		int width = (int)(res.getWidth());
		int height = (int)(res.getHeight())-79;
		
	    ImageIcon ic  = rszImg("screen/stage1.jpg", width, height);
	    JLabel lbImage1  = new JLabel(ic);
	    lbImage1.setBounds(0, 0, width, height);
	    contentPane.add(lbImage1);
	    
	    JButton liv_room = new JButton(new ImageIcon("img/cat/livingroom.png"));
	    liv_room.setBounds(290, 835, 380, 90);
	    
	    JButton veranda = new JButton(new ImageIcon("img/cat/veranda.png"));
	    veranda.setBounds(1260, 835, 380, 90);
	    
	    ActionListener result = new ActionListener() {						
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == liv_room) {
					new stage1_cat_result1();
				}else if(e.getSource() == veranda) {
					new stage1_cat_result2();
				}
			}
		};
		
		liv_room.setOpaque(false);
		veranda.setOpaque(false);
		
		liv_room.setFocusPainted(false);
		veranda.setFocusPainted(false);
		
		liv_room.setBorderPainted(false);
		veranda.setBorderPainted(false);
		
		liv_room.addActionListener(result);
		veranda.addActionListener(result);
	    
	    contentPane.add(liv_room);
	    contentPane.add(veranda);

		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}
	
	public static void main(String args[]) {
		new stage1_cat();
	}
	
	public ImageIcon rszImg(String img, int width, int hight) {
		ImageIcon b_ic = new ImageIcon(img);
		Image icc = b_ic.getImage();
		Image logo = icc.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(logo);

		return ic;
	}
}
