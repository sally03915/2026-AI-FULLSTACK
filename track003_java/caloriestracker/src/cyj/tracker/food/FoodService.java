package cyj.tracker.food;

import java.util.List;

import cyj.tracker.user.User;

public interface FoodService {
	public void registerFood(Food food, User currentUser);
	public List<Food> searchFood(User currentUser);
	
	public boolean isExists(Food food, User currUser);
	public void deleteFood(Food food);
}
