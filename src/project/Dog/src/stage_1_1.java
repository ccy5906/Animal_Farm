package project.Dog.src;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class stage_1_1 extends JFrame{
	public JPanel panel;
	private JLabel timer;
	static JLabel score,dog;
	static int score_num = 0,end=0;
	int width,height,time=20;
	int food[] = {1,2,3,4};  //포도(1), 고구마(2), 계란(3), 초콜릿(4)
	
	ImageIcon basic,happy, shock;
	
	 public List<Thread> food_list = new ArrayList<Thread>();

	public stage_1_1() {
		super("강아지 Stage 1");
		
		/*try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}*/
     	
		 Dimension res = Toolkit.getDefaultToolkit().getScreenSize();	
		 ImageIcon back = rszImg("img/dog/dog_back.jpg", res.width, res.height);
		 width=res.width; height=res.height;
								
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
				
				basic = rszImg("img/dog/dog_basic.png",200,250);
				happy = rszImg("img/dog/dog_happy.png",200,250);
				shock = rszImg("img/dog/dog_shock.png",200,250);
				dog = new JLabel(basic);
				dog.setBounds(960, 720 , 200, 250);				
				
				score = new JLabel("점수 : "+score_num);
				score.setBounds(res.width-300, 30, 200,50);
				score.setFont(new Font("210 라임 Bold", Font.BOLD, 25));
				panel.add(score);
				
				timer = new JLabel("남은 시간 : "+time);
				timer.setBounds(10,10,200,50);
				timer.setFont(new Font("210 라임 Bold", Font.BOLD, 25));
				panel.add(timer);
				
				String content = "<html><h1>Stage1</h1><br>"+
						"순대 간, 계란 노른자, 고구마, 당근과 같은 음식은 먹어도 되지만 <br><br>" + 
						"포도, 고등어, 초콜릿, 모든 과일씨, 아몬드 등은 먹으면 안 된다. <br><br>" + 
						"소량이라도 강아지에게는 큰 영향을 끼칠 수 있으니 조심해야 한다.<br><br>"+
						"</html>";
				
				new Thread(new Runnable() {
					@Override
					public void run() {
						while(true) {
							try {
								Thread.sleep(1000);
								time--;
								timer.setText("남은 시간 : "+time);
								if(time <=0) {
									end=1; 
									
									break;
								}
							}catch(InterruptedException e) {
								e.printStackTrace();
							}
						}
						if(end ==1) {
							InfoDialog info = new InfoDialog(content,1);
						/*	Timer timer = new Timer();
							TimerTask task = new TimerTask() {			
								@Override
								public void run() {
									System.out.println("스케줄 진입");
									new stage_2();
									System.out.println("stage2실행");
									info.dispose();
									dispose();
								}
							};
							timer.schedule(task, 5000);*/
							
						}
					}
				}).start();  //timer
				
				
				Food f1 = new Food();	Food f2 = new Food();
				Food f3 = new Food();	Food f4 = new Food();
				Food f5 = new Food();   Food f6 = new Food();
				
				Thread fall1 = new Thread(new Runnable() {
					@Override
					public void run() {
						panel.add(f1.fall); 
						f1.move();
					}
				});
				fall1.start();
				
				Thread fall2 = new Thread(new Runnable() {
					@Override
					public void run() {
						panel.add(f2.fall); 
						f2.move();
					}
				});
				fall2.start();
				
				Thread fall3 = new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(1000);
							panel.add(f3.fall); 
							f3.move();
						} catch (InterruptedException e) {							
							e.printStackTrace();
						}						
					}
				});
				fall3.start();
				
				Thread fall4 = new Thread(new Runnable() {
					@Override
					public void run() {
						panel.add(f4.fall); 
						f4.move();
					}
				});
				fall4.start();
				
				Thread fall5 = new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(2000);
							panel.add(f5.fall); 
							f5.move();
						} catch (InterruptedException e) {							
							e.printStackTrace();
						}						
					}
				});
				fall5.start();
				
				Thread fall6 = new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(3000);
							panel.add(f6.fall); 
							f6.move();
						} catch (InterruptedException e) {							
							e.printStackTrace();
						}						
					}
				});
				fall6.start();
				
				
				
				KeyListener move = new KeyListener() {					
					@Override
					public void keyTyped(KeyEvent e) { }
					
					@Override
					public void keyReleased(KeyEvent e) { }
					
					@Override
					public void keyPressed(KeyEvent e) {
						int x = dog.getX();
						int y = dog.getY();				
						switch (e.getKeyCode()) {
						
						case KeyEvent.VK_RIGHT:
							if(x == res.width - 200) {
								dog.setLocation(x, y);
							}else {
								dog.setLocation(x+10, y);
							}
							break;
						case KeyEvent.VK_LEFT:
							if(x == 0) {
								dog.setLocation(x, y);
							}else {
								dog.setLocation(x-10, y);
							}
							break;				
						default:
							break;
						}//switch
						
					}
				};

				panel.add(dog);
				addKeyListener(move);				
				
				
				add(panel);
				setExtendedState(JFrame.MAXIMIZED_BOTH);
				setVisible(true); 
				

			
				
				
	}//stage_1
	
	 public ImageIcon rszImg(String img, int width, int hight) {
			ImageIcon b_ic = new ImageIcon(img);
			Image icc = b_ic.getImage();
			Image logo = icc.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
			ImageIcon ic = new ImageIcon(logo);

			return ic;
	}//ImageIcon rszImg
	
}




