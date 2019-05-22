import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class feelbarchange implements MouseListener {
	int num;
	int bar;
	String text;
	int start = 50;
	static int change;
	boolean check = false;

	public feelbarchange(int num, int bar, String text) {
		this.num = num;
		this.bar = bar;
		this.text = text;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
		switch(text) {
		case "놀고 싶다.":
			if(num == 3 || num == 4) {
				if(0 <= bar && bar <= 20) {
					change = 10;
					check = true;
				}
			}else {
				if(0 <= bar && bar <= 20) {
					change = 3;
					check = false;
				}
			}
		}
		
		System.out.println(change);
		System.out.println("feelbar"+check);
		new Thread(new detail(change, check)).start();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}