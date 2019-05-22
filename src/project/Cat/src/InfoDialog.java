package project.Cat.src;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;

public class InfoDialog extends JFrame{
	
	JPanel panel;
	JLabel text;
	
	public InfoDialog() {}
	
	public InfoDialog(String con) {
		
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		Font font = new Font("210 라임 B", Font.PLAIN, 25);
		
		panel = new JPanel();
		panel.setLayout(null);
		
	    this.text = new JLabel(con);
	    text.setBounds(50, 50, 900, 500);
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
					System.exit(0);
				}
			}
		};
		
		close.addActionListener(result);
	    
	    
	    setPreferredSize(new Dimension(1145, 840));
		setLocation(300, 100);	
	    add(panel);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void setContent(String text) {
		this.text.setText(text);
		panel.add(this.text);
	}
	
	public static void main(String args[]) {
		new InfoDialog();
	}
	
	public ImageIcon rszImg(String img, int width, int hight) {
		ImageIcon b_ic = new ImageIcon(img);
		Image icc = b_ic.getImage();
		Image logo = icc.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(logo);

		return ic;
	}
}