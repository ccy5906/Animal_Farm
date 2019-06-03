package project.all;
public class detail implements Runnable {
	int start = gameroom.feelBar.getValue();
	int change;
	int i;
	boolean check;
	
	public detail() {
	    
	}
	public detail(int change, boolean check) {
		this.change = change;
		this.check = check;
		System.out.println(change);
		System.out.println(start);
	}
	
	
		int result=0;
		@Override
		public void run() {
			gameroom.feelBar.setValue(start);
			if(check == true) {
				while(i <= change) {
					gameroom.feelBar.setValue(start+i);
					gameroom.feelBar.repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} // catch
					i++;
				} // while
				}
				else {
						while(i <= change) {
							gameroom.feelBar.setValue(start-i);
							gameroom.feelBar.repaint();
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							} // catch
							i++;
						} // while
				}

		}// run
		

}// class detail