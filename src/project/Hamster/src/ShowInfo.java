package project.Hamster.src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class ShowInfo extends JFrame {
	JLabel info, infotitle, left, right;
	JPanel down;
	ImageIcon infoimage;
	int i = 1;
	String url = "";
	Dimension res = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

	public ShowInfo() {
		setTitle("동물농장");

		setPreferredSize(new Dimension(res.width - 400, res.height - 100));
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		getContentPane().add(contentPane);

		Font font = new Font("210 라임 Bold", Font.PLAIN, 22);

		// 동물 선택
		JPanel up = new JPanel();
		up.setBounds(0, 0, res.width - 400, res.height / 8);
		up.setLayout(new GridLayout(1, 3));
		contentPane.add(up);

		ImageIcon d = resizeImg("img/dog_basic.png", 100, 100);
		ImageIcon ca = resizeImg("img/cat.png", 100, 100);
		ImageIcon ham = resizeImg("img/ham/hamster.png", 110, 100);

		JButton dog = new JButton("강아지", d);
		JButton cat = new JButton("고양이", ca);
		JButton hamster = new JButton("햄스터", ham);

		dog.setBorder(new MatteBorder(5, 3, 5, 3, Color.BLACK));
		dog.setBackground(Color.WHITE);
		dog.setFocusPainted(false);

		cat.setBorder(new MatteBorder(5, 3, 5, 3, Color.BLACK));
		cat.setBackground(Color.WHITE);
		cat.setFocusPainted(false);

		hamster.setBorder(new MatteBorder(5, 3, 5, 3, Color.BLACK));
		hamster.setBackground(Color.WHITE);
		hamster.setFocusPainted(false);

		dog.setFont(font);
		cat.setFont(font);
		hamster.setFont(font);

		dog.addMouseListener(new change(1));
		cat.addMouseListener(new change(2));
		hamster.addMouseListener(new change(3));

		up.add(dog);
		up.add(cat);
		up.add(hamster);

		down = new JPanel();
		down.setBounds(0, res.height / 8, res.width - 400, res.height - 100);
		down.setLayout(null);
		down.setBackground(new Color(222,235,247));
		contentPane.add(down);

		infotitle = new JLabel("강아지");
		down.add(infotitle);

		ImageIcon l = resizeImg("img/left.png", 100, 100);
		left = new JLabel(l);
		left.setBounds(50, res.height / 4, 100, 100);
		down.add(left);
		left.addMouseListener(new change(4));

		ImageIcon r = resizeImg("img/right.png", 100, 100);
		right = new JLabel(r);
		right.setBounds(down.getWidth()-150, res.height / 4, 100, 100);
		right.addMouseListener(new change(5));
		down.add(right);

		JButton send = new JButton("메일 전송");
		send.setBounds(down.getWidth()/2-200, res.height - 400, 300, 50);
		send.setFont(font);
		send.setBackground(Color.WHITE);
		hamster.setFocusPainted(false);
		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SendInfo(infotitle.getText());
			}
		});
		down.add(send);

		url = new String("동물정보/슬라이드" + i + ".jpg");
		infoimage = resizeImg(url, down.getWidth()/2+300, down.getHeight()/2+100);
		info = new JLabel(infoimage);
		info.setBackground(Color.WHITE);
		info.setFont(font);
		info.setBounds(200, 50, down.getWidth()/2+300, down.getHeight()/2+100);
		down.add(info);

		pack();
		setVisible(true);
		setLocation((res.width - getWidth()) / 2, (res.height - getHeight()) / 2);

	}

	public ImageIcon resizeImg(String img, int width, int hight) {
		ImageIcon imagep = new ImageIcon(img);
		Image imagen = imagep.getImage();
		Image logo = imagen.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(logo);

		return image;
	}

	// 내용 바꿔주는 클래스
	class change extends MouseAdapter {
		int screennum = 0;
		String kind = "";

		public change(int screennum) {
			this.screennum = screennum;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			String kind = infotitle.getText();
			switch (screennum) {
			case 1:
				infotitle.setText("강아지");
				i = 1;
				break;
			case 2:
				infotitle.setText("고양이");
				i = 5;
				break;
			case 3:
				infotitle.setText("햄스터");
				i = 8;
				break;
			case 4:
				i = i-1;
				System.out.println(infotitle);
				if(infotitle.getText().equals("강아지")) {
                	if(i < 1) i = 4;
                	if(i > 4) i = 1;
                }else if(infotitle.getText().equals("고양이")) {
                	if(i < 5) i = 7;
                	if(i > 7) i = 5;
                }else if(infotitle.getText().equals("햄스터")) {
                	if(i < 8) i = 10;
                	if(i > 10) i = 8;
                } 
				break;
			case 5:
				i = i+1;
				  if(infotitle.getText().equals("강아지")) {
	                	if(i < 1) i = 4;
	                	if(i > 4) i = 1;
	                }else if(infotitle.getText().equals("고양이")) {
	                	if(i < 5) i = 7;
	                	if(i > 7) i = 5;
	                }else if(infotitle.getText().equals("햄스터")) {
	                	if(i < 8) i = 10;
	                	if(i > 10) i = 8;
	                }
				break;
			default:
				break;
			}
			url = new String("동물정보/슬라이드" + i + ".jpg");
			infoimage = resizeImg(url, down.getWidth()/2+300, down.getHeight()/2+100);
			info.setIcon(infoimage);
		}

	}

	public static void main(String[] args) {
		new ShowInfo();
	}

}
