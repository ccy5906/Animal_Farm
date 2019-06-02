package project.Hamster.src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class stage3_correct extends JFrame{
	public stage3_correct() {
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(252, 244, 153));
		getContentPane().add(contentPane);

		ImageIcon h = resizeImg("img/ham/hamster_2.png", 300, 285);
		JLabel hamster = new JLabel(h);
		hamster.setBounds(res.width / 2 - 150, res.height- 420, 300, 300);
		contentPane.add(hamster);

		ImageIcon ho = resizeImg("img/ham/house.png", 400, 400);
		JLabel house = new JLabel(ho);
		house.setBounds(hamster.getX() - 500, res.height- 620, 400, 400);
		contentPane.add(house);

		ImageIcon p = resizeImg("img/ham/stage3_correct.png", 450, 155);
		JLabel spot = new JLabel(p);
		spot.setBounds(res.width - 500, res.height /5- 150, 450, 300);
		contentPane.add(spot);

		ImageIcon w = resizeImg("img/ham/hamster_wheel.png", 300, 300);
		JLabel wheel = new JLabel(w);
		wheel.setBounds(hamster.getX() + 500, res.height - 520, 300, 300);
		contentPane.add(wheel);

		ImageIcon b = resizeImg("img/ham/bedding.png", res.width, 300);
		JLabel bedding = new JLabel(b);
		bedding.setBounds(0, res.height - 250, res.width, 300);
		contentPane.add(bedding);
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {			
			@Override
			public void run() {
				InfoDialog info = new InfoDialog(4,"<html>정답!<br><br>" + "햄스터의 병은 기생충성 장염이다.<br><br>"
						+" 비위생적인 생활 환경 기생충으로부터 감염되어 생기는 병이다.<br><br>" + 
						"증상으로 설사, 탈수증상, 체중의 감소, 체력의 저하를 보인다.<br><br>" + 
						"치료 방법은 지사제나 기생충 구제제의 투여, 소독이 필요하며 예방 방법은 청결한 환경이다.<br><br>" + 
						"햄스터는 강아지, 고양이와 달리 아픈 것을 주인이 알아채지 못한다면 알 수 없다.<br><br>" + 
						"그 때문에 주인은 유심히 햄스터를 돌볼 필요가 있다.</html>");
			}
		};
		timer.schedule(task, 3000);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public static void main(String[] args) {
		new stage3_correct();
	}
	
	public ImageIcon resizeImg(String img, int width, int hight) {
		ImageIcon imagep = new ImageIcon(img);
		Image imagen = imagep.getImage();
		Image logo = imagen.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(logo);

		return image;
	}

}
