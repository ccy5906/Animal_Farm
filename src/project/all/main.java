package project.all;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import project.all.ShowInfo;

public class main {
	

	public main() {
		
				//게임을 하지 않더라도 정보(텍스트파일)를 얻을 수 있게
				//팝업창 글씨크기,사이즈 키우기 ->우리껄로 만들기
				//stage1 먹이양, 속도 등
				JFrame frame = new JFrame();
				frame.setTitle("동물 농장"); 
				frame.setLocation(0, 0);	
				frame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize())); 
				
				Dimension res = Toolkit.getDefaultToolkit().getScreenSize();	
				ImageIcon back = rszImg("img/main_back.png", res.width, res.height);

				JPanel panel1= new JPanel() {
					public void paintComponent(Graphics g) {
						g.drawImage(back.getImage(), 0, 0, null);
						setOpaque(false);
						super.paintComponent(g);
					}
				};
				panel1.setLayout(null);
				panel1.setBounds(0, 0, res.width, res.height);
				frame.getContentPane().add(panel1);
				
				Font font = new Font("210 라임 Bold",Font.PLAIN,30);
				
				JButton butstart = new JButton("게임시작");
				JButton butway = new JButton("게임방법");
				JButton butmail = new JButton("정보전송");
				
				butstart.setBounds(1400,650,300,100);
				butway.setBounds(1400,800,300,100);
				butmail.setBounds(1400,500,300,100);
				butstart.setBackground(new Color(237,228,192));
				butway.setBackground(new Color(237,228,192));
				butmail.setBackground(new Color(237,228,192));
				butstart.setFont(font);
				butway.setFont(font); butmail.setFont(font);
				
				butstart.addActionListener(new ActionListener() { //게임시작 버튼 눌렀을 때
					@Override
					public void actionPerformed(ActionEvent e) {
						//System.out.println("게임시작 버튼 클릭");
						new Select_Ch();
						frame.dispose();
					}
   					
   				});
				butway.addActionListener(new ActionListener() {	//게임방법 버튼 눌렀을 때		
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("게임방법 버튼 클릭");
						Way way = new Way();
						
					}
				});
				butmail.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("정보전송 버튼 클릭");
						new ShowInfo();
						Timer timer1 = new Timer();
						TimerTask task1 = new TimerTask() {			
							@Override
							public void run() {
								frame.dispose();
							}
						};
						timer1.schedule(task1, 5000);
						
					}					
				});
				
				//추가
				panel1.add(butstart);
				panel1.add(butway);
				panel1.add(butmail);
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				

				
	
	}
	
	
	public static ImageIcon rszImg(String img, int width, int hight) {
		ImageIcon b_ic = new ImageIcon(img);
		Image icc = b_ic.getImage();
		Image logo = icc.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(logo);

		return ic;
	}//ImageIcon rszImg
	

}//class 

