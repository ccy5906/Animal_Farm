package project.Hamster.src;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class hamster_stage1 extends JFrame {
	
	public hamster_stage1() {
		setTitle("동물농장");
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		getContentPane().add(contentPane);

		
		Font font=new Font("210 라임 Bold",Font.PLAIN, 40);

		JLabel title = new JLabel("햄스터가 온 첫날, 어떤 모습을 선택하시겠습니까?");
		title.setFont(font);
		title.setBounds(0, 0, res.width, 100);
		title.setBorder(new MatteBorder(7, 4, 7, 7, Color.BLACK));
		title.setVerticalAlignment(SwingConstants.CENTER);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(title);

		JPanel content = new JPanel();
		content.setBounds(0, 100, res.width, res.height);
		content.setBackground(Color.WHITE);
		content.setLayout(new GridLayout(1, 2));
		contentPane.add(content);

		JPanel correct = new JPanel();
		correct.setLayout(null);
		correct.setBorder(new MatteBorder(0, 4, 0, 6, Color.BLACK));
		correct.setBackground(new Color(54, 97, 165));
		content.addMouseListener(new stage1mouse(0));
		content.add(correct);

		
		ImageIcon b1 = resizeImg("img/ham/bedding.png", (res.width/2)-12, 400);
		JLabel bedding1 = new JLabel(b1);
		bedding1.setBounds(5, res.height-310, res.width/2-12, 400);
		
		ImageIcon hh = resizeImg("img/ham/house_hamster.png",370,370);
		JLabel house = new JLabel(hh);
		house.setBounds(30, res.height/3+70, 370, 370);
		
		correct.add(house);
		correct.add(bedding1);
		
		JPanel uncorrect = new JPanel();
		uncorrect.setLayout(null);
		uncorrect.setBorder(new MatteBorder(0, 4, 0, 6, Color.BLACK));
		uncorrect.setBackground(new Color(252, 244, 153));
		uncorrect.addMouseListener(new stage1mouse(1));
		content.add(uncorrect);

		ImageIcon b2 = resizeImg("img/ham/bedding.png", res.width/2-12, 400);
		JLabel bedding2 = new JLabel(b2);
		bedding2.setBounds(5, res.height-310, res.width/2-12, 400);
		
		ImageIcon h = resizeImg("img/ham/hamster.png",250,205);
		JLabel hamster = new JLabel(h);
		hamster.setBounds(30, res.height-530, 300, 300);
		
		ImageIcon hand = resizeImg("img/ham/hand.png",450,205);
		JLabel hand1 = new JLabel(hand);
		hand1.setBounds(res.width/2-453, res.height/2+50, 450, 300);
		
		uncorrect.add(hamster);
		uncorrect.add(hand1);
		uncorrect.add(bedding2);

		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public static void main(String[] args) {
		hamster_stage1 hamster1 = new hamster_stage1();
	}

	public ImageIcon resizeImg(String img, int width, int hight) {
		ImageIcon imagep = new ImageIcon(img);
		Image imagen = imagep.getImage();
		Image logo = imagen.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(logo);

		return image;
	}

	class stage1mouse implements MouseListener {
		int num = 0;

		public stage1mouse(int num) {
			this.num = num;
		}


		public void mouseClicked(MouseEvent e) {
			
			if(num == 0) {new stage1_correct();}
			else {new stage1_uncorrect();}
			dispose();
			
		}


		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	}
}
