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

public class stage_3_1OK extends JFrame{
	private JPanel panel;
	ImageIcon back;
	
	public stage_3_1OK() {
		super("강아지 Stage3OK");
     	
		 Dimension res = Toolkit.getDefaultToolkit().getScreenSize();	
		 back = rszImg("img/dog/dstage3_1OK.jpg", res.width, res.height);
		 
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
			
			String content = "<html><h1>Stage3 정답입니다</h1><br>"+
					"강아지와 함께 자지 않으면 주인영역과 강아지의 영역이<br><br>"+
					"나누어져 있어 누군가 집에 놀러오게 되더라도<br><br>"+
					"잘 짖지 않습니다.<br><br>"+
					"</html>";
	
	
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {			
				@Override
				public void run() {
					InfoDialog info = new InfoDialog(content,3);	
					
					Timer timer1 = new Timer();
					TimerTask task1 = new TimerTask() {			
						@Override
						public void run() {
							info.dispose();
							//new stage_3();
							dispose();
						}
					};
					timer1.schedule(task1, 5000);
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
