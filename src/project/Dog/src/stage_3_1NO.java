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

public class stage_3_1NO extends JFrame{
	private JPanel panel;
	ImageIcon back;
	
	public stage_3_1NO() {
		super("강아지 Stage3NO");
     	
		 Dimension res = Toolkit.getDefaultToolkit().getScreenSize();	
		 back = rszImg("img/dog/dstage3_1NO.jpg", res.width, res.height);
		 
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
			
			
			String content = "<html><h1>Stage3 오답입니다</h1><br>"+
					"강아지와 함께 자게 되면 친밀감은 높아지겠지만<br><br>"+
					"주인 영역과 강아지의 영역이 구분되지 않아 주인 보호본능이 더 강해지고<br><br>"+
					"누군가 자신의 영역에 들어오게 되면 많이 짖는 버릇이 생겨납니다.<br><br>"+
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
