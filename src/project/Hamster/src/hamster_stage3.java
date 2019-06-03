<<<<<<< HEAD
package project.Hamster.src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import project.Hamster.src.hamster_stage1.stage1mouse;

public class hamster_stage3 extends JFrame {

	public hamster_stage3() {
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		getContentPane().add(contentPane);

		Font font = new Font("210 라임 Bold", Font.PLAIN, 30);
		Font smallfont = new Font("210 라임 Bold", Font.PLAIN, 20);

		JPanel hamsterview = new JPanel();
		hamsterview.setLayout(null);
		hamsterview.setBounds(0, 0, res.width, res.height / 2);
		hamsterview.setBackground(new Color(249, 247, 162));
		contentPane.add(hamsterview);

		ImageIcon h = resizeImg("img/ham/sick_hamster.png", 300, 285);
		JLabel hamster = new JLabel(h);
		hamster.setBounds(res.width / 2 - 150, res.height / 2 - 320, 300, 300);
		hamsterview.add(hamster);

		ImageIcon ho = resizeImg("img/ham/house.png", 320, 320);
		JLabel house = new JLabel(ho);
		house.setBounds(hamster.getX() - 400, res.height / 2 - 420, 320, 320);
		hamsterview.add(house);

		ImageIcon p = resizeImg("img/ham/spot.png", 120, 120);
		JLabel spot = new JLabel(p);
		spot.setBounds(hamster.getX() + 250, res.height / 2 - 130, 120, 120);
		hamsterview.add(spot);

		ImageIcon w = resizeImg("img/ham/hamster_wheel.png", 300, 300);
		JLabel wheel = new JLabel(w);
		wheel.setBounds(hamster.getX() + 500, res.height / 2 - 380, 300, 300);
		hamsterview.add(wheel);

		ImageIcon b = resizeImg("img/ham/bedding.png", res.width, 150);
		JLabel bedding = new JLabel(b);
		bedding.setBounds(0, res.height / 2 - 150, res.width, 150);
		hamsterview.add(bedding);

		JPanel hamsterquiz = new JPanel();
		hamsterquiz.setBounds(0, res.height / 2, res.width, res.height / 2);
		hamsterquiz.setBackground(Color.white);
		hamsterquiz.setLayout(null);
		contentPane.add(hamsterquiz);

		JLabel title = new JLabel("햄스터는 설사를 하고 탈수증상과 체중이 감소된 상태입니다. 어떻게 대처해야 할까요?");
		title.setFont(font);
		title.setBounds(0, 0, res.width, 100);
		title.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		title.setVerticalAlignment(SwingConstants.CENTER);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		hamsterquiz.add(title);

		ImageIcon s = resizeImg("img/ham/smile.png", 100, 100);
		String s_txt = "<html><center>스트레스를 <br>" + "주지 않는다.</center><html>";
		JButton smile = new JButton(s_txt, s);
		smile.setFont(smallfont);
		smile.setBounds(res.width / 2 - 150, 200, 300, 200);
		smile.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
		smile.setOpaque(false);
		smile.setFocusPainted(false);
		smile.setContentAreaFilled(false);
		hamsterquiz.add(smile);
		smile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new stage3_uncorrect();

			}
		});

		ImageIcon fr = resizeImg("img/ham/bubbles.png", 100, 100);
		String fr_txt = "<html><center>청결한<br>" + "환경을 만든다.</center><html>";
		JButton fresh = new JButton(fr_txt, fr);
		fresh.setFont(smallfont);
		fresh.setBounds(smile.getX() - 500, 200, 300, 200);
		fresh.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
		fresh.setOpaque(false);
		fresh.setContentAreaFilled(false);
		fresh.setFocusPainted(false);
		hamsterquiz.add(fresh);
		fresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new stage3_correct();

			}
		});

		ImageIcon c = resizeImg("img/ham/cage.png", 100, 100);
		String c_txt = "<html><center>케이지를  <br>" + "바꾼다.</center><html>";
		JButton cage = new JButton(c_txt, c);
		cage.setFont(smallfont);
		cage.setBounds(smile.getX() + 500, 200, 300, 200);
		cage.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
		cage.setOpaque(false);
		cage.setFocusPainted(false);
		cage.setContentAreaFilled(false);
		cage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new stage3_uncorrect();

			}
		});
		hamsterquiz.add(cage);

		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public static void main(String[] args) {
		new hamster_stage3();
	}

	public ImageIcon resizeImg(String img, int width, int hight) {
		ImageIcon imagep = new ImageIcon(img);
		Image imagen = imagep.getImage();
		Image logo = imagen.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(logo);

		return image;
	}

=======
package project.Hamster.src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import project.Hamster.src.hamster_stage1.stage1mouse;

public class hamster_stage3 extends JFrame {

	public hamster_stage3() {
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		getContentPane().add(contentPane);

		Font font = new Font("210 라임 Bold", Font.PLAIN, 30);
		Font smallfont = new Font("210 라임 Bold", Font.PLAIN, 20);

		JPanel hamsterview = new JPanel();
		hamsterview.setLayout(null);
		hamsterview.setBounds(0, 0, res.width, res.height / 2);
		hamsterview.setBackground(new Color(249, 247, 162));
		contentPane.add(hamsterview);

		ImageIcon h = resizeImg("img/ham/sick_hamster.png", 300, 285);
		JLabel hamster = new JLabel(h);
		hamster.setBounds(res.width / 2 - 150, res.height / 2 - 320, 300, 300);
		hamsterview.add(hamster);

		ImageIcon ho = resizeImg("img/ham/house.png", 320, 320);
		JLabel house = new JLabel(ho);
		house.setBounds(hamster.getX() - 400, res.height / 2 - 420, 320, 320);
		hamsterview.add(house);

		ImageIcon p = resizeImg("img/ham/spot.png", 120, 120);
		JLabel spot = new JLabel(p);
		spot.setBounds(hamster.getX() + 250, res.height / 2 - 130, 120, 120);
		hamsterview.add(spot);

		ImageIcon w = resizeImg("img/ham/hamster_wheel.png", 300, 300);
		JLabel wheel = new JLabel(w);
		wheel.setBounds(hamster.getX() + 500, res.height / 2 - 380, 300, 300);
		hamsterview.add(wheel);

		ImageIcon b = resizeImg("img/ham/bedding.png", res.width, 150);
		JLabel bedding = new JLabel(b);
		bedding.setBounds(0, res.height / 2 - 150, res.width, 150);
		hamsterview.add(bedding);

		JPanel hamsterquiz = new JPanel();
		hamsterquiz.setBounds(0, res.height / 2, res.width, res.height / 2);
		hamsterquiz.setBackground(Color.white);
		hamsterquiz.setLayout(null);
		contentPane.add(hamsterquiz);

		JLabel title = new JLabel("햄스터는 설사를 하고 탈수증상과 체중이 감소된 상태입니다. 어떻게 대처해야 할까요?");
		title.setFont(font);
		title.setBounds(0, 0, res.width, 100);
		title.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		title.setVerticalAlignment(SwingConstants.CENTER);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		hamsterquiz.add(title);

		ImageIcon s = resizeImg("img/ham/smile.png", 100, 100);
		String s_txt = "<html><center>스트레스를 <br>" + "주지 않는다.</center><html>";
		JButton smile = new JButton(s_txt, s);
		smile.setFont(smallfont);
		smile.setBounds(res.width / 2 - 150, 200, 300, 200);
		smile.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
		smile.setOpaque(false);
		smile.setFocusPainted(false);
		smile.setContentAreaFilled(false);
		hamsterquiz.add(smile);
		smile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new stage3_uncorrect();

			}
		});

		ImageIcon fr = resizeImg("img/ham/bubbles.png", 100, 100);
		String fr_txt = "<html><center>청결한<br>" + "환경을 만든다.</center><html>";
		JButton fresh = new JButton(fr_txt, fr);
		fresh.setFont(smallfont);
		fresh.setBounds(smile.getX() - 500, 200, 300, 200);
		fresh.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
		fresh.setOpaque(false);
		fresh.setContentAreaFilled(false);
		fresh.setFocusPainted(false);
		hamsterquiz.add(fresh);
		fresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new stage3_correct();

			}
		});

		ImageIcon c = resizeImg("img/ham/cage.png", 100, 100);
		String c_txt = "<html><center>케이지를  <br>" + "바꾼다.</center><html>";
		JButton cage = new JButton(c_txt, c);
		cage.setFont(smallfont);
		cage.setBounds(smile.getX() + 500, 200, 300, 200);
		cage.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
		cage.setOpaque(false);
		cage.setFocusPainted(false);
		cage.setContentAreaFilled(false);
		cage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new stage3_uncorrect();

			}
		});
		hamsterquiz.add(cage);

		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public static void main(String[] args) {
		new hamster_stage3();
	}

	public ImageIcon resizeImg(String img, int width, int hight) {
		ImageIcon imagep = new ImageIcon(img);
		Image imagen = imagep.getImage();
		Image logo = imagen.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(logo);

		return image;
	}

>>>>>>> master
}