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
import javax.swing.SwingConstants;
<<<<<<< HEAD

import project.all.ShowInfo;
=======
>>>>>>> master

public class InfoDialog extends TimerTask{
	
	JPanel panel;
	JLabel text;
	int status=0; //1이면 버튼 클릭함
	String content = "<html><br><br>게임 방법<br><br>"
	+ "왼쪽에서부터 이동하는 손바닥을 해당 자세와 똑같이 만들어서 <br><br>햄스터와의 거리 0cm가 되는 게임이다.<br><br>" + 
<<<<<<< HEAD
	"①만들어야 할 핸들링 자세를 확인한다.<br><br> ②움직이는 손바닥이 제시하는 자세와 같은 손 모양,먹이에 도착했을 때 <br><br>그림을 클릭한다. <br><br>"
	+ "     - 맞는 그림의 구간에서 클릭하면 손바닥이 해당 그림에 맞게 <br><br>        변하고 햄스터와의 거리가 가까워진다.<br><br>" 
	+ "     - 틀리면 그다음으로 이동하는 손바닥으로 다시 시도해야 한다.<br><br><br>" +
=======
	"①만들어야 할 핸들링 자세를 확인한다.<br><br> ②움직이는 손바닥이 제시하는 자세와 같은 <br><br>손 모양, 먹이에 도착했을 때 그림을 클릭한다. <br><br>"
	+ "&nbsp;&nbsp;- 맞는 그림의 구간에서 클릭하면 손바닥이 <br><br>해당 그림에 맞게 변하고 햄스터와의 거리가 가까워진다.<br><br>" 
	+ "&nbsp;&nbsp;- 틀리면 그다음으로 이동하는 손바닥으로 다시 시도해야 한다.<br><br><br>" +
>>>>>>> master
	"※햄스터와 0cm가 될 때나 시간이 다 지났을 때 게임이 끝나며 <br><br>점수는 남은 시간은 100점으로 계산한다.※</html>";
	
	public InfoDialog() {}
	
	public InfoDialog(int count, String con) {
		
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		Font font = new Font("210 라임 Bold",Font.PLAIN,25);
		JFrame frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(null);
		
	    this.text = new JLabel(con);
	    text.setBounds(50, 0, 900, 600);
	    text.setHorizontalAlignment(JLabel.CENTER);
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