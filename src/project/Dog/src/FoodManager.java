package project.Dog.src;


import java.util.ArrayList;
import java.util.List;

public class FoodManager {
	
	public static final int FOOD_MAKE_INTERVAL=20;
	
	public List<Food> food_list = new ArrayList<Food>();
	
	int food_make_interval = FOOD_MAKE_INTERVAL;
	
	public void make_food() {
		if(food_make_interval == FOOD_MAKE_INTERVAL) {
			Food food = new Food();
			
			food_list.add(food);
			
		}
		
		
	}

}
