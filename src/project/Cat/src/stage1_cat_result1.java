package project.Cat.src;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import project.Cat.src.InfoDialog;

public class stage1_cat_result1 extends JFrame{
	
	private JPanel contentPane;
	
	public stage1_cat_result1() {
		
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		getContentPane().add(contentPane);		
		
		int width = (int)(res.getWidth());
		int height = (int)(res.getHeight())-79;
		
		ImageIcon ic  = rszImg("screen/stage1_suc.jpg", width, height);
	    JLabel lbImage1  = new JLabel(ic);
	    lbImage1.setBounds(0, 0, width, height);
	    contentPane.add(lbImage1);
	    
	    pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
					try {
						Thread.sleep(2000);
						InfoDialog info = new InfoDialog("<html><h1>Stage1</h1><br>간혹 베란다에는 방범창이 설치되어 있지 않은 곳이 있어서 <br><br>만약 베란다에 설치를 했는데 혹여나 창문이 열려 있으면 탈출의 위험이 있다.</html>",1);
						
						dispose();								
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					
				}
		}).start();
	}
	
	public ImageIcon rszImg(String img, int width, int hight) {
		ImageIcon b_ic = new ImageIcon(img);
		Image icc = b_ic.getImage();
		Image logo = icc.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(logo);

		return ic;
	}

}