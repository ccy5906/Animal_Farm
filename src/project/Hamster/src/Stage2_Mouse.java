package project.Hamster.src;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class Stage2_Mouse extends MouseAdapter {
	static int check_hand = 2;
	int num = 0, holdcount = 0;
	ImageIcon change_hand1 = resizeImg("img/ham/change_hand1.png", 180, 100);
	ImageIcon change_hand1_feed1 = resizeImg("img/ham/change_hand1_feed1.png", 180, 120);
	ImageIcon change_hand1_feed2 = resizeImg("img/ham/change_hand1_feed2.png", 180, 120);
	ImageIcon change_hand2 = resizeImg("img/ham/change_hand2.png", 180, 100);
	ImageIcon change_hand2_feed1 = resizeImg("img/ham/change_hand2_feed1.png", 180, 120);
	ImageIcon change_hand2_feed2 = resizeImg("img/ham/change_hand2_feed2.png", 180, 120);
	ImageIcon change_hand3_feed1 = resizeImg("img/ham/change_hand3_feed1.png", 180, 120);
	ImageIcon change_hand3_feed2 = resizeImg("img/ham/change_hand3_feed2.png", 180, 120);

	public Stage2_Mouse(int num, int holdcount) {
		this.num = num;
		this.holdcount = holdcount;
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();

		switch (num) {
		case 1:
			if (holdcount > 400 && holdcount < 600) {
				hamster_stage2.hold.setIcon(change_hand1);
				check_hand = 0;
			}else {
				return;
			}
			break;
		case 2:
			if (holdcount > 650 && holdcount < 850) {
				hamster_stage2.hold.setIcon(change_hand2);
				check_hand = 1;
			}else {
				return;
			}
			break;
		case 3:
			if (holdcount > res.width-650 && holdcount < res.width-850) {
				if (check_hand == 0) {
					hamster_stage2.hold.setIcon(change_hand1_feed1);
				}else if(check_hand == 1){
					hamster_stage2.hold.setIcon(change_hand2_feed1);
				}else {
					hamster_stage2.hold.setIcon(change_hand3_feed1);
				}
			}else {
				return;
			}
			break;
		case 4:
			if (holdcount > res.width-400 && holdcount < res.width-600) {
				if (check_hand == 0) {
					hamster_stage2.hold.setIcon(change_hand1_feed2);
				} else if (check_hand == 1) {
					hamster_stage2.hold.setIcon(change_hand2_feed2);
				}else {
					hamster_stage2.hold.setIcon(change_hand3_feed2);
				}
			}else {
				return;
			}
			break;

		default:
			return;
		}

	}

	public ImageIcon resizeImg(String img, int width, int hight) {
		ImageIcon imagep = new ImageIcon(img);
		Image imagen = imagep.getImage();
		Image logo = imagen.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(logo);

		return image;
	}

}
