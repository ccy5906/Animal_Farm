package project.Hamster.src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class hamster_stage2 extends JFrame {
	static JLabel hold;
	int holdcount=-200, chance = 12, x = 0, num, value = 20, end = 0,win = 0, time = 80;
	//holdcount = 이미지의 x좌표, chance = cm값, x = 성공/실패창 한 번만, num = 이미지 변경 변수, value = 시간값, end = 시간타이머, win = 성공횟수
	ImageIcon h1, h2, f1, f2, r;
	JLabel hand1, hand2 ,feed1, feed2, title, handling, random;
	JProgressBar TimeBar;
	 ImageIcon imgs[] = {Stage2_Mouse.change_hand1_feed1, Stage2_Mouse.change_hand1_feed2, Stage2_Mouse.change_hand2_feed1, Stage2_Mouse.change_hand2_feed2};
	 ImageIcon hand1_mouse =  resizeImg("img/ham/hand1_mouse.png", 200,150);
		ImageIcon hand2_mouse =  resizeImg("img/ham/hand2_mouse.png", 200,150);
		ImageIcon feed1_mouse =  resizeImg("img/ham/feed1_mouse.png", 200,150);
		ImageIcon feed2_mouse =  resizeImg("img/ham/feed2_mouse.png", 200,150);
	 Timer timer = new Timer();
	TimerTask task;
	Thread t;
   	
   public hamster_stage2() {
	    Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		JPanel contentPane;
	    Font titlefont = new Font("210 라임 B", Font.PLAIN, 35);
	   	
	   	contentPane = new JPanel();
	   	contentPane.setLayout(null);
	   	contentPane.setBackground(Color.WHITE);
	   	add(contentPane);
	   	
	   	JLabel StageExplain = new JLabel("핸들링으로 햄스터와 거리 0cm를 만드세요!");
	   	StageExplain.setBounds(100, 80, res.width/2,50);
	   	StageExplain.setFont(titlefont);
	   	contentPane.add(StageExplain);
	   	
	   	TimeBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, value);
	   	TimeBar.setValue(120);
	   	TimeBar.setBounds(res.width/2-100, 80, res.width/2, 50);
	   	TimeBar.setForeground(new Color(244,167,66));
	   	TimeBar.setBackground(new Color(252,234,212));
	   	TimeBar.setBorderPainted(false);
	   	TimeBar.setStringPainted(true);	
	   	contentPane.add(TimeBar);
		
		title = new JLabel("첫 번째 핸들링 시도 자세");
		title.setFont(titlefont);
		title.setBounds(res.width/3+100, 0, 1000, 500);
		contentPane.add(title);

		handling = new JLabel(chance+"cm");
		handling.setFont(titlefont);
		handling.setBounds(res.width/2-100, 240, res.width- 200, 500);
		contentPane.add(handling);
		
		ImageIcon h = resizeImg("img/ham/hamster.png", 340, 265);
		JLabel hamster = new JLabel(h);
		hamster.setBounds(200, 240, 340, 300);
		contentPane.add(hamster);
		
		ImageIcon c = resizeImg("img/ham/cm.png", 500, 50);
		JLabel cm = new JLabel(c);
		cm.setBounds(res.width/3, 430, 500, 50);
		contentPane.add(cm);
		
		r = imgs[0];
		random= new JLabel(r);
		random.setBounds(res.width-700, 240, 400, 365);
		contentPane.add(random);
		
		h1 = resizeImg("img/ham/hand1.png", 200,150);
		hand1 = new JLabel(h1);
		hand1.setBounds(400, res.height- 460, 200, 200);
		contentPane.add(hand1);
		h2 = resizeImg("img/ham/hand2.png", 200,150);
		hand2 = new JLabel(h2);
		hand2.setBounds(650, res.height- 460, 200, 200);
		contentPane.add(hand2);
		
		f1 = resizeImg("img/ham/feed1.png", 200,150);
		feed1 = new JLabel(f1);
		feed1.setBounds(1050, res.height- 460, 200, 200);
		contentPane.add(feed1);
		
		f2 = resizeImg("img/ham/feed2.png", 200,150);
		feed2 = new JLabel(f2);
		feed2.setBounds(1300, res.height- 460, 200, 200);
		contentPane.add(feed2);
		
		hand1.addMouseListener(new mouse(1));
		hand2.addMouseListener(new mouse(2));
		feed1.addMouseListener(new mouse(3));
		feed2.addMouseListener(new mouse(4));
		
		ImageIcon hol = resizeImg("img/ham/hold.png",180,160);
		hold = new JLabel(hol);
		hold.setBounds(holdcount, res.height- 280, 200, 180);
		contentPane.add(hold);
		
		ImageIcon b = resizeImg("img/ham/stage2background.png", res.width- 200, 400);
		JLabel bedding = new JLabel(b);
		bedding.setBounds(100, 150, res.width- 200, 500);
		contentPane.add(bedding);
		
		ImageIcon p = resizeImg("img/ham/pan.png", res.width,180);
		JLabel pan = new JLabel(p);
		pan.setBounds(0, res.height- 280, res.width, 180);
		contentPane.add(pan);
		

	   	class threadnew implements Runnable {
	   		public void run() { 	// run() 메서드 오버라이딩
	   			Timer timer = new Timer();
	   			TimerTask task = new TimerTask() {			
	   				@Override
	   				public void run() {			
	   					    for(int i = 0 ; i < res.width ; i++){ 
	   					    	holdcount+=i;
	   					    	System.out.println(holdcount);
	   					    	if(chance <= 0) {
	   								timer.cancel();
	   								t.interrupt();
	   								new next();	
	   								break;
	   							}
	   					    	if(end ==1) {
	   								timer.cancel();
	   								t.interrupt();
	   								new next();
	   								break;
	   							}
	   					    	 if(holdcount <= res.width && holdcount >= res.width-200) {
	   					    		 if(x == 0) {
	   					    			 new Stage2_Check(random());
	   					    		 }
	   					    		 x = 1;
	   						    		
	   						     }
	   						if(holdcount >= res.width+200) { 
	   							try {Thread.sleep(2000);
	   							} catch (InterruptedException e) {e.printStackTrace();}	
	   						holdcount=-200; i = 0; x = 0;hold.setIcon(hol);
	   						}	
	   						hold.setBounds(holdcount, res.height-280, 200, 180);
	   						try {Thread.sleep(time);} 
	   						catch (InterruptedException e) {e.printStackTrace();}
	   		            }//for
	   				}//run
	   			};//task
	   			  	timer.schedule(task, 1000);
	   		}
	   	}

		t = new Thread(new threadnew());
		t.start(); 
		
	  	new Thread(new Runnable() {
				@Override
				public void run() {
					while(true) {
						try {						
							Thread.sleep(1000);
							value--;
							TimeBar.setValue(value);
							if(value <=0) {
								end=1; 
								break;
							}
						}catch(InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();  //timer
	  	
	  	setVisible(true);
	   	setExtendedState(JFrame.MAXIMIZED_BOTH);

		addWindowListener(new WindowAdapter() {	
			@Override
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});//WindowLister    
   }
   public boolean random() {
     if(hold.getIcon().toString().equals(r.toString())) {
    	 win++;
    	 System.out.println(hold.getIcon());
    	 System.out.println(win);
    	 System.out.println("true");
    	 return true;
     }else {
    	 System.out.println("false");
    	 System.out.println(hold.getIcon());
    	 System.out.println(r);
    	 return false;
     }
   }
	
	public static void main(String[] args) {
		 new hamster_stage2();
	}
	
	public ImageIcon resizeImg(String img, int width, int hight) {
		ImageIcon imagep = new ImageIcon(img);
		Image imagen = imagep.getImage();
		Image logo = imagen.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(logo);

		return image;
	}
	
	class mouse extends MouseAdapter{
		int num = 0;
		public mouse(int num) { this.num = num;}

		@Override
		public void mouseClicked(MouseEvent e) {
			 new Stage2_Mouse(num, holdcount);
		}

		@Override
		public void mousePressed(MouseEvent e) {
           if(num == 1)hand1.setIcon(hand1_mouse);
           else if(num == 2) hand2.setIcon(hand2_mouse);
           else if(num == 3) feed1.setIcon(feed1_mouse);
           else if(num == 4) feed2.setIcon(feed2_mouse);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(num == 1) hand1.setIcon(h1);
	        else if(num == 2) hand2.setIcon(h2);
	        else if(num == 3) feed1.setIcon(f1);
	        else if(num == 4) feed2.setIcon(f2);	
		}	
	}
	
	class Stage2_Check{
		Thread ttt = new Thread();
		ImageIcon yes = resizeImg("img/ham/stage2_yes.png", 600, 300);
		ImageIcon no = resizeImg("img/ham/stage2_no.png", 600, 300);
			
		public Stage2_Check(boolean randomcheck) {
			ttt.start();
			 Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
			 JFrame frame = new JFrame();
			 
			JPanel panel = new JPanel();
			panel.setBackground(Color.white);
			panel.setLayout(null);
			
			JLabel checkpan = new JLabel();
			checkpan.setBounds(res.width/3, res.height/3, 650, 300);

			if(randomcheck == true) {		
				checkpan.setIcon(yes);
				chance-=2;
				switch (chance) {
				case 10:
					title.setText("두번째 핸들링 자세");
					time = 60;
					break;
				case 8:
					title.setText("세번째 핸들링 자세");
					time = 50;
					break;	
				case 6:
					title.setText("네번째 핸들링 자세");
					time = 45;
					break;	
				case 4:
					title.setText("다섯번째 핸들링 자세");
					time = 40;
					break;	
				case 2:
					title.setText("여섯번째 핸들링 자세");
					time = 35;
					break;
				default:
					break;
				}	
					handling.setText(chance+"cm");
					if(chance == 10) {r = imgs[1];}
					else if(chance ==8 ) {r = imgs[0];}
					else if(chance == 6 || chance == 2) {r = imgs[2];}
					else if(chance == 4) {r = imgs[3];}		
				random.setIcon(r);
			}else {
				checkpan.setIcon(no);
			}
			panel.add(checkpan);
			
			frame.add(panel);
			frame.pack();
			frame.setVisible(true);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   try {
			   ttt.sleep(1000);
			frame.dispose();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		   
		}
	}//Stage2_Check class
	
	class next{
		public next() {
			Timer gametimer = new Timer();
			TimerTask gametask = new TimerTask() {			
				@Override
				public void run() {
					
					String content = "<html>햄스터 핸들링에서 가장 중요한 것은 천천히! 꾸준히! 다가가는 것이 매우 중요하다.<br><br>" + 
							"핸들링을 시작할 때는 간식을 손끝으로 잡고 준다.<br><br>햄스터가 손에 익숙해지는 시간이 필요하기 때문이다.<br><br>" + 
							"햄스터에게 거절당해도 꾸준히 다가가는 것이 중요하다.<br><br>" + 
							"햄스터가 손끝으로 주는 간식을 익숙해한다<br><br>먹이의 위치를 손바닥 안으로 천천히 옮긴다.<br><br>" + 
							"햄스터가 손바닥에 올라온다면 핸들링을 성공한 것이다.</html>";
							InfoDialog info =  new InfoDialog(3,content);
							dispose();
				}
			};
			gametimer.schedule(gametask, 2000);
		}
	}

}