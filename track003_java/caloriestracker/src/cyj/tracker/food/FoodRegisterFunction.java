package cyj.tracker.food;

import cyj.tracker.auth.AuthService;
import cyj.tracker.basic.InputHandler;
import cyj.tracker.basic.TrackerFunction;
import cyj.tracker.user.UserService;

public class FoodRegisterFunction implements TrackerFunction {
	private Food food;
	private final InputHandler handler = new InputHandler();
	private final FoodService service;
	private final AuthService authService;
	
	public FoodRegisterFunction(FoodService service, AuthService authService) {
		super();
		this.service = service;
		this.authService = authService;
	}

	@Override
	public void input() {
		String name;
		double calories;
		double carbs; double protein; double fat;
		
		name = handler.getString("👉 음식의 이름을 입력하세요 > ");
		calories = handler.getDouble("👉 칼로리를 입력하세요 > ");
		carbs = handler.getDouble("👉 탄수화물 함량을 입력하세요 > ");
		protein = handler.getDouble("👉 단백질 함량을 입력하세요 > ");
		fat = handler.getDouble("👉 지방 함량을 입력하세요 > ");
		
		this.food = new Food(name, calories, carbs, protein, fat);
	}

	@Override
	public void execute() {
		service.registerFood(food, authService.getCurrentUser());

	}

}
