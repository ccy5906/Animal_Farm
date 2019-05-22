package project.Dog.src;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Food {
	JLabel fall;
	int x, y, food_num=0;
	int food[] = {1,2,3,4};  //포도(1), 고구마(2), 계란(3), 초콜릿(4)
	ImageIcon grape, sweet, egg, choco;
	ImageIcon basic,happy, shock;
	
	Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Food(){			
		grape = rszImg("img/dog/grapes.png",150,150);
		sweet = rszImg("img/dog/sweet.png",150,150);
		egg = rszImg("img/dog/egg.png",150,150);
		choco = rszImg("img/dog/chocolate.png",150,150);
		fall = new JLabel(grape);
		
		basic = rszImg("img/dog/dog_basic.png",200,250);
		happy = rszImg("img/dog/dog_happy.png",200,250);
		shock = rszImg("img/dog/dog_shock.png",200,250);
		
		choice();		
	}
	
	private void choice() {
		
		Random ran = new Random();
		this.x = ran.nextInt(res.width-150);
		this.y=0;
		food_num = ran.nextInt(food.length)+1;		
		System.out.println("음식 번호 :"+food_num);
		
		//랜덤으로 음식 지정
		switch(food_num) {
			case 1:  //포도
				fall.setIcon(grape);
				break;
			case 2:  //고구마
				fall.setIcon(sweet);
				break;
			case 3:  //계란
				fall.setIcon(egg);
				break;
			case 4:  //초콜릿
				fall.setIcon(choco);
				break;
			default:
				break;						
		}					
		System.out.println("food "+food_num);
		fall.setVisible(true);
		fall.setBounds(x, y,150,150);			
		
	}//choice
	
	public void move() {
		Random ran = new Random();
		int speed;	
		if(stage_1_1.end==1) { fall.setVisible(false); return;}
		while(y<res.height-150) {
			try {
				speed= ran.nextInt(50)+20;
				y = y+speed;
				fall.setLocation(x, y);
				Thread.sleep(300);
				
				if(stage_1_1.dog.getX()<=this.x && this.x<=stage_1_1.dog.getX()+200 && stage_1_1.dog.getY()<=y+150) {		
					switch(food_num) {
					case 1:  //포도
						stage_1_1.score_num -= 5;
						stage_1_1.dog.setIcon(shock);
						break;
					case 2:  //고구마
						stage_1_1.score_num += 10;
						stage_1_1.dog.setIcon(happy);
						break;
					case 3:  //계란
						stage_1_1.score_num += 10;
						stage_1_1.dog.setIcon(happy);
						break;
					case 4:  //초콜릿
						stage_1_1.score_num -= 5;
						stage_1_1.dog.setIcon(shock);
						break;
					default:
						break;				
					
					}
					if(stage_1_1.score_num <=0) stage_1_1.score_num = 0;  //마이너스 점수는 없으니까 0점으로 표시
					stage_1_1.score.setText("점수 : "+stage_1_1.score_num);
					fall.setVisible(false);
					Thread.sleep(2000);
					
					break;
				}//음식과 강아지가 닿았을 때				
				
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}//while-음식이 떨어지는 중
		fall.setVisible(false);	
		stage_1_1.dog.setIcon(basic);
		choice();
		move();
	
	}//move
	
	public void check() {
		
	}//check
	
	
	
	public ImageIcon rszImg(String img, int width, int hight) {
		ImageIcon b_ic = new ImageIcon(img);
		Image icc = b_ic.getImage();
		Image logo = icc.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(logo);

		return ic;
	}//ImageIcon rszImg
	

}
