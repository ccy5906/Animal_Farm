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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import project.Cat.src.stage1_cat;
import project.Dog.src.stage_1;
import project.Dog.src.stage_1_1;
import project.Dog.src.stage_2;
import project.Hamster.src.hamster_stage1;

public class Select_Ch extends JFrame {
	//상단에 동물이름 받는 박스 하나 만들기
	//캐릭터 선택 시 ActionListener에서 이름 박스에서 이름을 받았는지 확인하고 안 받았으면 이름 박스에 이름을 쓰라고 알려주기
	private JPanel panel;
	
	 public Select_Ch() {
		 super("동물농장");
		          	
		 Dimension res = Toolkit.getDefaultToolkit().getScreenSize();	
		 ImageIcon back = rszImg("img/back_select.png", res.width, res.height);
		 Font font =new Font("210 라임 B", Font.PLAIN, 25);				
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
					
					//캐릭터 이미지 버튼
					JButton select1 = new JButton(rszImg("img/dog/dog_select.png",230,250)); 
					select1.setBounds(250, 350, 400, 300);
					select1.setBorderPainted(false); select1.setContentAreaFilled(false);
					JButton select2 = new JButton(rszImg("img/cat/cat.png",250,250));
					select2.setBounds(750,350,400,300);
					select2.setBorderPainted(false); select2.setContentAreaFilled(false);
					JButton select3 = new JButton(rszImg("img/ham/hamster.png",250,200));
					select3.setBounds(1250,350,400,300);
					select3.setBorderPainted(false); select3.setContentAreaFilled(false);
					
					JLabel name=new JLabel("사용자 이름 : ");
					name.setBounds(700, 199, 200, 50);
					name.setFont(font);
					
					JTextField namefield = new JTextField(20);
					namefield.setText("이름입력");
					namefield.setBounds(850, 209,250,30);
					namefield.setFont(font);
					
					JButton insert = new JButton("입력");
					insert.setBounds(1120,210,100,30);
					ImageIcon img= rszImg("img/input.png",90,50);
					JButton input = new JButton(img);
					input.setBounds(1120,200,100,50);
				    input.setBorderPainted(false);
				    input.setOpaque(false);
				    input.setFocusPainted(false);
				    input.setContentAreaFilled(false);
					
					//캐릭터 선택시 발생하는 이벤트
					ActionListener ssAct = new ActionListener() {						
						@Override
						public void actionPerformed(ActionEvent e) {
							//선택한 캐릭터에 따라 게임 내용이 변경
							if(e.getSource() == select1) {
								System.out.println("1 선택");
								new stage_1();
								dispose();
							}else if(e.getSource() == select2) {
								System.out.println("2 선택");
								new stage1_cat();
								dispose();
							}else if(e.getSource() == select3) {
								System.out.println("3 선택");
								new hamster_stage1();
								dispose();
							}else {
								System.out.println("다시 선택해주시기 바랍니다.");
							}
							//new gameroom();
						}
					}; //ActionListener-캐릭터 선택
					
					//이름 입력 버튼을 눌렀을 때 실행되는 
					ActionListener insertAct = new ActionListener() {						
						@Override
						public void actionPerformed(ActionEvent e) {
							//1.이름을 final 변수로 선언해서 게임이 끝난 후 DB에 저장시킨다.
							//2.처음부터 이름만 DB에 저장한 후 update한다.
							
							System.out.println("캐릭터 이름 : "+namefield.getText());
							
						}
					}; //ActionListener-입력 버튼
					
					
					select1.addActionListener(ssAct);
					select2.addActionListener(ssAct);
					select3.addActionListener(ssAct);
					insert.addActionListener(insertAct);
					
					panel.add(select1);  panel.add(select2); panel.add(select3);
					panel.add(name);
					panel.add(namefield);
					//panel.add(insert);
					panel.add(input);
					
					add(panel);
					setExtendedState(JFrame.MAXIMIZED_BOTH);
					setVisible(true);      
	       
	       
	 }//Select_Ch(생성자)
	 public ImageIcon rszImg(String img, int width, int hight) {
			ImageIcon b_ic = new ImageIcon(img);
			Image icc = b_ic.getImage();
			Image logo = icc.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
			ImageIcon ic = new ImageIcon(logo);

			return ic;
		}//ImageIcon rszImg

}//class
