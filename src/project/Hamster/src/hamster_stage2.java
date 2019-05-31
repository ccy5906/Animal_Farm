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
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import project.Dog.src.InfoDialog;

public class hamster_stage2 extends JFrame {
	Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
	JPanel contentPane;
	static JLabel hold;
	int holdcount=-200;
	ImageIcon h1, h2, f1, f2;
	JLabel hand1, hand2 ,feed1, feed2,checkpan;

   public hamster_stage2() {
	   
	    Font titlefont = new Font("210 라임 B", Font.PLAIN, 35);
	   	
	   	contentPane = new JPanel();
	   	contentPane.setLayout(null);
	   	contentPane.setBackground(Color.WHITE);
	   	add(contentPane);
	   	
	   	JLabel StageExplain = new JLabel("핸들링으로 햄스터와 거리 0cm를 만드세요!");
	   	StageExplain.setBounds(100, 80, res.width/2,50);
	   	StageExplain.setFont(titlefont);
	   	contentPane.add(StageExplain);
	   	
	   	JProgressBar TimeBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 120);
	   	TimeBar.setValue(100);
	   	TimeBar.setBounds(res.width/2-100, 80, res.width/2, 50);
	   	TimeBar.setForeground(new Color(244,167,66));
	   	TimeBar.setBackground(new Color(252,234,212));
	   	TimeBar.setBorderPainted(false);
		contentPane.add(TimeBar);
		
		JLabel tille = new JLabel("첫 번째 핸들링 시도 자세");
		tille.setFont(titlefont);
		tille.setBounds(res.width/3+100, 0, 1000, 500);
		contentPane.add(tille);

		JLabel handling = new JLabel("10cm");
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
		
		ImageIcon r = resizeImg("img/ham/ramdom1.png", 400, 365);
		JLabel ramdom= new JLabel(r);
		ramdom.setBounds(res.width-700, 240, 400, 365);
		contentPane.add(ramdom);
		
		
	
		
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
		
	
	   	setVisible(true);
	   	setExtendedState(JFrame.MAXIMIZED_BOTH);
	   	
	   	addWindowListener(new WindowAdapter() {	
			@Override
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});//WindowLister    
	   	
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {			
			@Override
			public void run() {			
				    for(int i = 0 ; i < res.width ; i++){ 
				    	holdcount+=i;
				    	System.out.println(holdcount);
				    if(holdcount <= res.width && holdcount >= 1700) {
				    		new Stage2_Check();
				    		System.out.println("yes~~~");
				    	}
				    
					if(holdcount >= res.width+200) { 
						try {Thread.sleep(2000);
						} catch (InterruptedException e) {e.printStackTrace();}	
					holdcount=-200; i = 0; hold.setIcon(hol);
					}	
					hold.setBounds(holdcount, res.height-280, 200, 180);
					try {Thread.sleep(10);} 
					catch (InterruptedException e) {e.printStackTrace();}
	            }//for
			}//run
		};//task
		timer.schedule(task, 1000);
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
		ImageIcon hand1_mouse =  resizeImg("img/ham/hand1_mouse.png", 200,150);
		ImageIcon hand2_mouse =  resizeImg("img/ham/hand2_mouse.png", 200,150);
		ImageIcon feed1_mouse =  resizeImg("img/ham/feed1_mouse.png", 200,150);
		ImageIcon feed2_mouse =  resizeImg("img/ham/feed2_mouse.png", 200,150);
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
		ImageIcon yes = resizeImg("img/ham/stage2_yes.png", 400, 100);
		ImageIcon no = resizeImg("img/ham/stage2_no.png", 400, 100);
		public Stage2_Check() {
			Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
			Font font = new Font("210 라임 Bold",Font.PLAIN,25);
			JFrame frame = new JFrame();
			JPanel panel = new JPanel();
			panel.setLayout(null);
			
			checkpan = new JLabel(yes);
			checkpan.setBounds(res.width/3, res.height/2, 400, 100);
			panel.add(checkpan);
		
		    
			frame.setPreferredSize(new Dimension(1145, 840));
			frame.setLocation(300, 100);	
			frame.add(panel);
			frame.pack();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		    System.out.println("yse!~~");
		   try {
			Thread.sleep(90);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		   contentPane.remove(checkpan);
		}
	}


}