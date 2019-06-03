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
import project.all.ShowInfo;

public class stage3_cat_result2 extends JFrame{
	
	private JPanel contentPane;
	
	public stage3_cat_result2() {
		
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		getContentPane().add(contentPane);		
		
		int width = (int)(res.getWidth());
		int height = (int)(res.getHeight())-79;
		
		ImageIcon ic  = rszImg("screen/stage3_suc.jpg", width, height);
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
						InfoDialog info = new InfoDialog("<html><h1>Stage3</h1><br>손으로 놀아주다보면 고양이는 손을 먹이나 장난감으로 생각할 수 있다.<br><br> 그렇게 되면 손을 할퀴거나 물게 되는데 주인의 손뿐만이 아니라 수의사같은 다른 사람의 손도 물게 된다는 것이다.</html>",3);
					
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