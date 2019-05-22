package project.Hamster.src;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class hamster__stage2 extends JFrame  {
	Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel contentPane;
	int i;
	
	public hamster__stage2() {
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		getContentPane().add(contentPane);
		
		Font font = new Font("������������� ExtraBold", Font.PLAIN, 40);

		JLabel title = new JLabel("핸들링으로 햄스터와 거리 0cm를 만드세요!");
		title.setFont(font);
		title.setBounds(0, 0, res.width, 100);
		title.setVerticalAlignment(SwingConstants.CENTER);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(title);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public static void main(String[] args) {
		new hamster__stage2();
	}

	   class change implements Runnable{
		    private int x = 0;
			private int y = 0;
			
		public void run() {
		//	gameroom.feelBar.setValue(start);
			while(i <= res.width) {
				x -= 10;
				setLocation(x, y);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} // catch
				i++;
			} // while
		}// run
		
	   }//change

}
