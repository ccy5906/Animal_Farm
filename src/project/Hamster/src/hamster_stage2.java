package project.Hamster.src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class hamster_stage2 extends JFrame{
   public hamster_stage2() {
	   	Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
	    Font titlefont = new Font("210 라임 B", Font.PLAIN, 35);
	   	
	   	JPanel contentPane = new JPanel();
	   	contentPane.setLayout(null);
	   	contentPane.setBackground(Color.WHITE);
	   	add(contentPane);
	   	
	   	JLabel StageExplain = new JLabel("핸들링으로 햄스터와 거리 0cm를 만드세요!");
	   	StageExplain.setBounds(50, 80, res.width/2,50);
	   	StageExplain.setFont(titlefont);
	   	contentPane.add(StageExplain);
	   	
	   	JProgressBar TimeBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 120);
	   	TimeBar.setValue(100);
	   	TimeBar.setBounds(res.width/2-50, 80, res.width/2, 50);
	   	TimeBar.setForeground(new Color(244,167,66));
	   	TimeBar.setBackground(new Color(252,234,212));
	   	TimeBar.setBorderPainted(false);
		contentPane.add(TimeBar);
		
		ImageIcon b = resizeImg("img/ham/stage2background.png", res.width- 200, 500);
		JLabel bedding = new JLabel(b);
		bedding.setBounds(100, 200, res.width- 200, 500);
		contentPane.add(bedding);
		
		ImageIcon h = resizeImg("img/ham/hamster.png", 340, 265);
		JLabel hamster = new JLabel(h);
		hamster.setBounds(200, 330, 340, 300);
		contentPane.add(hamster);
		
	   	setVisible(true);
	   	setExtendedState(JFrame.MAXIMIZED_BOTH);
	   	
	   	addWindowListener(new WindowAdapter() {	
			@Override
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});//WindowLister        
   }
   
	public ImageIcon resizeImg(String img, int width, int hight) {
		ImageIcon imagep = new ImageIcon(img);
		Image imagen = imagep.getImage();
		Image logo = imagen.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(logo);

		return image;
	}
	public static void main(String[] args) {
		 new hamster_stage2();
	}

}