package project.Dog.src;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class stage_2_1NO extends JFrame{
	private JPanel panel;
	ImageIcon back;
	
	public stage_2_1NO() {
		super("강아지 Stage2NO");
     	
		 Dimension res = Toolkit.getDefaultToolkit().getScreenSize();	
		 back = rszImg("img/dog/dstage2NO.png", res.width, res.height);
		 
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
			
			String content = "<html><h1>Stage2 오답입니다</h1><br>"+
					"강아지에게 간식을 줄 때 손가락으로 집어서 주게 되면 <br><br>"+
					"몇몇 강아지는 잘 먹기도 하지만 잘못하다가는 손가락을 물릴 수 있습니다.<br><br>"+
					"그래서 강아지한테 간식을 줄 때는 손바닥에 올려서 줘야 합니다.<br><br>"+
					"</html>";
	
	
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {			
				@Override
				public void run() {
					InfoDialog info = new InfoDialog(content,2);	
					dispose();
				}
			};
			timer.schedule(task, 3000);

			
			
			
			
			
			
			
			
			add(panel);
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
