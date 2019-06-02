package project.Hamster.src;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class InfoDialog extends TimerTask{
	
	JPanel panel;
	JLabel text;
	int status=0; //1이면 버튼 클릭함
	String content = "<html>Stage2, 핸들링 게임 방법<br><br>"
	+ "첫날 햄스터에게 강제로 핸들링을 시도하는 경우<br> <br>햄스터가 핸들링에 대해 트라우마가 생길 수 있다.<br><br>"+
	"햄스터는 집에 익숙해질 수 있도록 최소 일주일 정도의 적응 기간이 필요하다.<br><br>"+
	"적응 기간은 햄스터의 집을 어둡게 해주고 혼자 있도록 해준다.</html>";
	public InfoDialog() {}
	
	public InfoDialog(int count, String con) {
		
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		Font font = new Font("210 라임 Bold",Font.PLAIN,25);
		JFrame frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(null);
		
	    this.text = new JLabel(con);
	    text.setBounds(50, 40, 900, 500);
	    text.setFont(font);
	    panel.add(text);
		
		JButton close = new JButton(new ImageIcon("img/close.png"));
	    close.setBounds(450, res.height-420, 230, 120);
	    close.setBorderPainted(false);
	    close.setOpaque(false);
	    close.setFocusPainted(false);
	    close.setContentAreaFilled(false);
	    panel.add(close);
	    
		ImageIcon icon  = rszImg("img/popup.png", 1129, 799);
	    JLabel popup  = new JLabel(icon);
	    popup.setBounds(0, 0, 1129, 799);
	    panel.add(popup);
	    
	    
	    ActionListener result = new ActionListener() {						
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == close) {
					switch (count) {
					case 1:
						InfoDialog info = new InfoDialog(2, content);
						break;
					case 2:
						new hamster_stage2();
						break;	
					case 3:
						new hamster_stage3();
						break;	
					case 4:
						new ShowInfo();
						break;		

					default:
						break;
					}
					frame.dispose();
					
				}
			}
		};
		
		close.addActionListener(result);
	    
	    
		frame.setPreferredSize(new Dimension(1145, 840));
		frame.setLocation(300, 100);	
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
/*	public static void main(String args[]) {
		new InfoDialog();
	}*/
	
	public ImageIcon rszImg(String img, int width, int hight) {
		ImageIcon b_ic = new ImageIcon(img);
		Image icc = b_ic.getImage();
		Image logo = icc.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(logo);

		return ic;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}