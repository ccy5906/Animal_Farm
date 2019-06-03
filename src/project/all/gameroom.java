package project.all;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;

public class gameroom extends JFrame {
	private JPanel contentPane;
	String name;
	int cnt = 0;
	int min = 0,max=100;
	static JProgressBar feelBar;
	int time = 60;

	public gameroom() {
		super("동물농장");

		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		ImageIcon back = rszImg("img/igloo.png", res.width, res.height);
		Font font = new Font("돋움",Font.PLAIN,20);
		Color color = new Color(113, 191, 226);
		Font font_time = new Font("돋움",Font.PLAIN,35);
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(back.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		contentPane.setLayout(null);
		getContentPane().add(contentPane);

/*		ImageIcon conversation = rszImg("img/speechbubble.png", 500, 700);
		JLabel conver = new JLabel(conversation);
		conver.setBounds(150, 200, 900, 600);
		contentPane.add(conver);*/
		
		String hungry = new String("놀고 싶다.");
		JLabel hun = new JLabel(hungry);
		hun.setBounds(150, 200, 300, 300);
        contentPane.add(hun);
		
		ImageIcon love = rszImg("img/peng.png", 500, 700);
		JLabel loveGage = new JLabel(love);
		loveGage.setBounds(150, 200, 800, 600);
		contentPane.add(loveGage);

		ImageIcon fish = rszImg("img/fish.png", 100,100);
		JButton feed = new JButton("먹이",fish);
		feed.setBounds(200, res.height - 250, 210, 115);
		feed.setFont(font);
		feed.setBorderPainted(false);
		feed.setContentAreaFilled(false);
		contentPane.add(feed);

		ImageIcon sle = rszImg("img/sleep.png", 100,100);
		JButton sleep = new JButton("잠",sle);
		sleep.setBounds(600, res.height - 250, 210, 115);
		sleep.setFont(font);
		sleep.setBorderPainted(false);
		sleep.setContentAreaFilled(false);
		contentPane.add(sleep);

		ImageIcon ice = rszImg("img/ice.png", 100,100);
		JButton icesliding = new JButton("<html>얼음<br>슬라이딩 하기</html>",ice);
		icesliding.setBounds(1000, res.height - 250, 310, 115);
		icesliding.setFont(font);
		icesliding.setBorderPainted(false);
		icesliding.setContentAreaFilled(false);
		contentPane.add(icesliding);
	
		
		ImageIcon penguin = rszImg("img/penguin.png", 100,100);
		JButton meet = new JButton("펭귄 친구 만나기",penguin);
		meet.setBounds(1400, res.height - 250, 310, 115);
		meet.setFont(font);
		meet.setBorderPainted(false);
		meet.setContentAreaFilled(false);
		contentPane.add(meet);

		JLabel count = new JLabel("남은 시간 : ");
		count.setBounds(1600, 100, 200, 50);
		count.setFont(font_time);
		contentPane.add(count);
		JLabel counttime = new JLabel();
		counttime.setBounds(1800, 100, 200, 50);
		counttime.setFont(font_time);
		contentPane.add(counttime);
		
		/*
		 * JLabel hungry = new JLabel("배고픔 지수"); hungry.setBounds(100, 20, 100, 100);
		 * contentPane.add(hungry);
		 */
		JLabel feel = new JLabel("기분 지수");
		feel.setBounds(100, 0, 250, 250);
		feel.setFont(font);
		contentPane.add(feel);

		/*
		 * JProgressBar hungryBar = new JProgressBar(JProgressBar.HORIZONTAL, min, max);
		 * hungryBar = new JProgressBar(JProgressBar.HORIZONTAL, min, max);
		 * hungryBar.setValue((max - min) / 2); hungryBar.setBounds(300, 50, res.width -
		 * 500, 40); contentPane.add(hungryBar);
		 */
		
		feelBar = new JProgressBar(JProgressBar.HORIZONTAL, min, max);
		feelBar.setValue(10);
		feelBar.setBounds(300, 100, res.width - 700, 55);
		feelBar.setForeground(color);
		feelBar.setBackground(Color.WHITE);
		feelBar.setBorderPainted(false);
		contentPane.add(feelBar);

		icesliding.addMouseListener(new feelbarchange(3,feelBar.getValue(), hungry));
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		
		//아이템 버튼 ActioListener
		
		//1. 먹이 버튼 클릭 시 선택 창 뜨게
		 //Dialog
		ChoiceDialog dialog = new ChoiceDialog();
		dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
		ActionListener feedAct = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("먹이 버튼 클릭");
				dialog.pack();
				dialog.setVisible(true);
			}
		};
		feed.addActionListener(feedAct);
		
		//2. 잠 버튼 클릭
		ActionListener sleepAct = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("잠 버튼 클릭");
			}
		};
		sleep.addActionListener(sleepAct);
		
		//3. 얼음 슬라이딩하기 버튼 클릭
		ActionListener slidingAct = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("얼음 슬라이딩 버튼 클릭");
			}
		};
		icesliding.addActionListener(slidingAct);
		
		//4. 펭귄친구 만나기 버튼 클릭
		ActionListener meetAct = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("펭귄 친구 버튼 클릭");
			}
		};
		meet.addActionListener(meetAct);

		
		class ThreadCount extends Thread{
	    	public void run(){    		
	    		while(true) {
	    		 try{
	    		        Thread.sleep(1000);
	    		        System.out.println(time);
	    		        counttime.setText(time+" 초");
	    		         time--;
	    		      }catch(Exception e) {
	    		        System.out.println(e.getMessage());
	    		      }

	    		}//while
	    	}//run
	    }//class
		//시간초 재기
		ThreadCount th = new ThreadCount();		
		th.start();

	}//생성자

	
	
	
	class ChoiceDialog extends JDialog{
		private ChoiceDialog dialog;
		private String feedname;
		Font font = new Font("210 슈크림빵 Bold",Font.PLAIN,20);
		
		public ChoiceDialog() {
			super();
			setLayout(new GridLayout(2, 3)); // Dialog의 레이아웃 설정
			setLocation(800,400);
			setPreferredSize(new Dimension(400, 200));
			dialog=this;
			
			
			JRadioButton rb1 = new JRadioButton("크릴 새우");
			JRadioButton rb2 = new JRadioButton("오징어");
			JRadioButton rb3 = new JRadioButton("작은 물고기");
			rb1.setSelected(true);
			rb1.setFont(font); rb2.setFont(font); rb3.setFont(font);
			ButtonGroup radioButtonGroup = new ButtonGroup();
			radioButtonGroup.add(rb1);
			radioButtonGroup.add(rb2);
			radioButtonGroup.add(rb3);
			add(rb1);	add(rb2);	add(rb3);
			
			Label lbl = new Label("", Label.CENTER); 
			JButton ok = new JButton("확인"); ok.setFont(font);
			add(lbl);  add(ok);
			
			ok.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {	
					if(rb1.isSelected()) {
						feedname=rb1.getText();
					}else if(rb2.isSelected()) {
						feedname=rb2.getText();
					}else{
						feedname=rb3.getText();
					}
					dialog.dispose();
				}
			});			
			
		}//생성자
		
		public String getFeedName() {
			return feedname;
		}
		
	}//Choice Dialog
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new gameroom();
	}//Main

	// 이미지 크기 바꾸기 함수
	public ImageIcon rszImg(String img, int width, int hight) {
		ImageIcon b_ic = new ImageIcon(img);
		Image icc = b_ic.getImage();
		Image logo = icc.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(logo);

		return ic;
	}//ImageIcon rszImg

}//class gameroom