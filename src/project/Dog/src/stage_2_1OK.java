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

public class stage_2_1OK extends JFrame{
	private JPanel panel;
	ImageIcon back;
	
	public  stage_2_1OK() {
		super("강아지 Stage2OK");
     	
		 Dimension res = Toolkit.getDefaultToolkit().getScreenSize();	
		 back = rszImg("img/dog/dstage2OK.png", res.width, res.height);
		 
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
			
			String content = "<html><h1>Stage2 정답입니다</h1><br>"+
							"강아지가 손바닥 위에 있는 간식은 혀로 받아먹기 때문에 <br><br>"+
							"손가락이 물릴 일이 없습니다.<br><br>"+
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
