package project.Dog.src;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class stage_1{
	InfoDialog info;
	public stage_1() {	
		/*Timer timer = new Timer();
		TimerTask task = new TimerTask() {			
			@Override
			public void run() {
				System.out.println("스케줄 진입");
				new stage_1_1();
				System.out.println("stage1_1실행");
				info.dispose();
			}
		};
		timer.schedule(task, 3000);*/
		
	    String content = "<html>"+
						"<h1>Stage1 게임 방법</h1><br>"+
						"키보드 좌우키를 이용하여 음식을 먹으세요!<br><br>"+"강아지가 먹어도 되는 음식과 그렇지 않은 음식을 생각하며 먹어주세요<br><br>"+
						"제한시간은 1분입니다.<br><br>"+
						"</html>";
				
		info = new InfoDialog(content,0);
				
		
				
				
				
				/*add(panel);
				setExtendedState(JFrame.MAXIMIZED_BOTH);
				setVisible(true); */
				
	}//stage_1
	 
}



