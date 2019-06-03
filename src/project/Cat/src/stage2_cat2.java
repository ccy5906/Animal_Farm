
package project.Cat.src;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static project.Cat.src.stage2_cat1.score;

public class stage2_cat2 extends JFrame{
	
private JPanel contentPane;
private JLabel timer;
static int end=0;
int time=10;
int score;
	
	public stage2_cat2(){
			
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		getContentPane().add(contentPane);		
		
		int width = (int)(res.getWidth());
		int height = (int)(res.getHeight())-79;
		
		timer = new JLabel("TIME : "+time);
		timer.setBounds(1700,10,200,50);
		timer.setFont(new Font("210라임L", Font.BOLD, 25));
		contentPane.add(timer);
	    
	    ImageIcon yarn = rszImg("img/cat/yarn.png", 200, 200);
	    JLabel item1 = new JLabel(yarn);
	    item1.setBounds(180, 125, 200, 200);
	    ImageIcon pet_toy = rszImg("img/cat/pet-toy.png", 200, 200);
	    JLabel item2 = new JLabel(pet_toy);
	    item2.setBounds(600, 125, 200, 200);
	    ImageIcon mouse = rszImg("img/cat/mouse.png", 200, 200);
	    JLabel item3 = new JLabel(mouse);
	    item3.setBounds(180, 400, 200, 200);
	    ImageIcon ball = rszImg("img/cat/fitness-ball.png", 200, 200);
	    JLabel item4 = new JLabel(ball);
	    item4.setBounds(600, 400, 200, 200);
	    ImageIcon fish = rszImg("img/cat/fish.png", 200, 200);
	    JLabel item5 = new JLabel(fish);
	    item5.setBounds(180, 680, 200, 200);
	    ImageIcon milk = rszImg("img/cat/milk.png", 200, 200);
	    JLabel item6 = new JLabel(milk);
	    item6.setBounds(600, 670, 200, 200);
	    ImageIcon doll = rszImg("img/cat/teddy-bear.png", 250, 250);
	    JLabel item7 = new JLabel(doll);
	    item7.setBounds(1120, 700, 250, 250);
	    ImageIcon cat_tower = rszImg("img/cat/scratcher.png", 250, 250);
	    JLabel item8 = new JLabel(cat_tower);
	    item8.setBounds(1520, 700, 250, 250);
	    
	    contentPane.add(item1);
	    contentPane.add(item2);
	    contentPane.add(item3);
	    contentPane.add(item4);
	    contentPane.add(item5);
	    contentPane.add(item6);
	    contentPane.add(item7);
	    contentPane.add(item8);
	    
	    ImageIcon ic  = rszImg("screen/stage2_sec.jpg", width, height);
	    JLabel lbImage1  = new JLabel(ic);
	    lbImage1.setBounds(0, 0, width, height);
	    contentPane.add(lbImage1);
	    
	    MouseListener select = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getX() >= 130 && e.getX() <= 380) {
					if(e.getY() >= 130 && e.getY() <= 380) {
						item1.setBounds(1300, 150, 200, 200);
						score -= 10;
					}
				}
				if(e.getX() >= 550 && e.getX() <= 800) {
					if(e.getY() >= 130 && e.getY() <= 380) {
						item2.setBounds(1400, 150, 200, 200);
						score += 15;
					}
				}
				if(e.getX() >= 130 && e.getX() <= 380) {
					if(e.getY() >= 350 && e.getY() <= 600) {
						item3.setBounds(1200, 160, 200, 200);
						score += 15;
					}
				}
				if(e.getX() >= 550 && e.getX() <= 800) {
					if(e.getY() >= 350 && e.getY() <= 600) {
						item4.setBounds(1500, 150, 200, 200);
						score += 15;
					}
				}
				if(e.getX() >= 130 && e.getX() <= 380) {
					if(e.getY() >= 630 && e.getY() <= 880) {
						item5.setBounds(1550, 250, 200, 200);
						score -= 10;
					}
				}
				if(e.getX() >= 550 && e.getX() <= 800) {
					if(e.getY() >= 630 && e.getY() <= 880) {
						item6.setBounds(1150, 200, 200, 200);
						score -= 10;
					}
				}
				else if(e.getX() >= 1070 && e.getX() <= 1320) {
					if(e.getY() >= 700 && e.getY() <= 950) {
						item7.setBounds(1400, 150, 250, 250);
						score += 15;
					}
				}
				else if(e.getX() >= 1470 && e.getX() <= 1720) {
					if(e.getY() >= 700 && e.getY() <= 950) {
						item8.setBounds(1300, 150, 250, 250);
						score += 15;
					}
				}
				
				
			}
		};
		
		addMouseListener(select);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
						time--;
						timer.setText("TIME : "+time);
						if(time <=0) {
							end=1; 
							break;
						}
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(end ==1) {
					try {
						Thread.sleep(1000);
						InfoDialog info = new InfoDialog("<html><h1>Stage2</h1><br>"
								+ "고양이가 털실을 가지고 노는 이미지가 강렬하지만 사실 고양이에게 털실은"
								+ "<br> <br>위험한 물건이 될 수 있다."
								+ " 가지고 놀다가 삼킬 수 있고 몸에 감겨서 부상 당하기가 쉽다.<br> <br>"
								+ "또 만화를 보면 고양이가 우유와 생선을 좋아하는 듯한 장면들이 많이 등장하곤한다."
								+ " 하지만<br><br>사람이 먹는 우유나 생선은 고양이에게 해로운 음식들이다.<br><br>"
								+ "고양이 전용 우유를 주거나 가끔 신선한 회 한조각을<br><br>"
								+ "주는 것은 괜찮으나 생선을 주식으로 해선 안된다.<br><br>"
								+ "총점 : " + (score + stage2_cat1.score) + "</html>",2);
						
						dispose();								
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		
	}
	
	public static void main(String args[]) {
		new stage2_cat2();
	}

	public ImageIcon rszImg(String img, int width, int height) {
		ImageIcon b_ic = new ImageIcon(img);
		Image icc = b_ic.getImage();
		Image logo = icc.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(logo);

		return ic;
	}

}
