package cyj.tracker.food;

import java.util.List;

import cyj.tracker.user.User;

public class FoodServiceImpl implements FoodService {
	private final FoodRepository foodRepo;

	public FoodServiceImpl(FoodRepository foodRepo) {
		this.foodRepo = foodRepo;
	}
	
	@Override
	public void registerFood(Food food, User user) {
		foodRepo.loadFoodData(user.getEmail());
		foodRepo.insertFood(food);
	}

	@Override
	public List<Food> searchFood(User currentUser) {
		foodRepo.loadFoodData(currentUser.getEmail());
		return foodRepo.selectAll(currentUser);
	}

	@Override
	public boolean isExists(Food food, User user) {
		Food existFood = foodRepo.selectOneByName(food.getName());
		return existFood != null;
	}

	@Override
	public void deleteFood(Food food) {
		foodRepo.deleteFood(food);
	}
	
	
	
}
