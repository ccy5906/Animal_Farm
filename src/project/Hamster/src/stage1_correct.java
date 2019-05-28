package project.Hamster.src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import project.Hamster.src.InfoDialog;

public class stage1_correct extends JFrame {

	public stage1_correct() {
		setTitle("동물농장");
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(252, 221, 98));
		getContentPane().add(contentPane);

		ImageIcon ho = resizeImg("img/ham/house.png", 400, 400);
		JLabel house = new JLabel(ho);
		house.setBounds(50, res.height / 2 - 80, 400, 400);

		ImageIcon b = resizeImg("img/ham/bedding.png", res.width, 250);
		JLabel bedding = new JLabel(b);
		bedding.setBounds(0, res.height - 300, res.width, 250);

		ImageIcon h = resizeImg("img/ham/correct_hamster.png", 300,255);
		JLabel hamster = new JLabel(h);
		hamster.setBounds(res.width / 4, res.height / 2 + 150, 300, 300);

		ImageIcon t = resizeImg("img/ham/correct_talk.png", 450, 205);
		JLabel talk = new JLabel(t);
		talk.setBounds(res.width - 500, res.height / 8, 450, 300);

		contentPane.add(talk);
		contentPane.add(hamster);
		contentPane.add(house);
		contentPane.add(bedding);

		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {			
			@Override
			public void run() {
				InfoDialog info = new InfoDialog("<html>정답!<br><br>" + "햄스터는 집에 익숙해질 수 있도록 최소 일주일 정도의 적응 기간이 필요하다.<br><br>"
						+ "적응 기간은 햄스터의 집을 어둡게 해주고 혼자 있도록 해준다.<br><br>" + "햄스터가 배를 보이면서 잔다면 집이 편해졌다는 신호일 가능성이 높다.</html>");
			}
		};
		timer.schedule(task, 3000);

	}

	public ImageIcon resizeImg(String img, int width, int hight) {
		ImageIcon imagep = new ImageIcon(img);
		Image imagen = imagep.getImage();
		Image logo = imagen.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(logo);

		return image;
	}

	public static void main(String[] args) {
		new stage1_correct();
	}
}
