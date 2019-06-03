package project.Cat.src;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class stage2_cat1 extends JFrame{
	
private JPanel contentPane;
private JLabel timer;
static int end=0;
int time=18;
int x,y;

static int score = 0;
	
	public stage2_cat1(){
			
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		ImageIcon ic  = rszImg("screen/stage2_fir.jpg", res.width, res.height);
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(ic.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
		}			
		};
		contentPane.setLayout(null);
		getContentPane().add(contentPane);		
		
		int width = (int)(res.getWidth());
		int height = (int)(res.getHeight())-79;

	    ImageIcon own = rszImg("img/cat/walk.png", 100, 100);
	    JLabel per = new JLabel(own);
	    per.setBounds(80, 220, 200, 200);
	    contentPane.add(per);
	    
	    timer = new JLabel("TIME : "+time);
		timer.setBounds(1700,10,200,50);
		timer.setFont(new Font("210라임L", Font.BOLD, 25));
		contentPane.add(timer);
		
	    KeyListener move = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				x = per.getX();
				y = per.getY();	
				System.out.println("x : " + x + "y : " + y);
				int keyCode = e.getKeyCode();
                if(keyCode == KeyEvent.VK_UP) { // 위쪽 방향 키
                    per.setLocation(x, y-10);
                } else if(keyCode == KeyEvent.VK_DOWN) { // 아래쪽 방향 키
                    per.setLocation(x, y+10);
                } else if(keyCode == KeyEvent.VK_LEFT) { // 왼쪽 방향 키
                    per.setLocation(x-10, y);
                } else if(keyCode == KeyEvent.VK_RIGHT) { // 오른쪽 방향 키
                    per.setLocation(x+10, y);
                }
                if(x == 1670 || x == 1660 || x == 1650 || x == 1640 || x == 1630 || x == 1620 || x == 1610 || x == 1600) {
                	if(y == 800 ||y == 810 ||y == 820 ||y == 790 ||y == 780 ||y == 770) {
                		/*new Thread(new Runnable() {
                			@Override
                			public void run() {
                				try {
                					Thread.sleep(1000);
                					
                					new stage2_cat2();
                					dispose();								
                				}catch(InterruptedException e) {
                					e.printStackTrace();
                				}
                			}
                		}).start();*/
                		new stage2_cat2();
    					dispose();	
                		score += 25;
                	}
                }
			}
		};
		
		contentPane.add(per);
		addKeyListener(move);

		add(contentPane);
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
						new stage2_cat2();
						dispose();				
						
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			
			}
		}).start();

	//	ImageIcon ic  = rszImg("screen/stage2_fir.jpg", width, height);
	//	JLabel lbImage1  = new JLabel(ic);
	  //  lbImage1.setBounds(0, 0, width, height);
	    //contentPane.add(lbImage1);
		
		
	}
	/*
	public static void main(String args[]) {
		new stage2_cat1();
	}*/

	public ImageIcon rszImg(String img, int width, int hight) {
		ImageIcon b_ic = new ImageIcon(img);
		Image icc = b_ic.getImage();
		Image logo = icc.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(logo);

		return ic;
	}

}
