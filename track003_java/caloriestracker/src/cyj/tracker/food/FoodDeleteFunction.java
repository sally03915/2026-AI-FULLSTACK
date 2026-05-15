package cyj.tracker.food;

import cyj.tracker.auth.AuthService;
import cyj.tracker.basic.InputHandler;
import cyj.tracker.basic.TrackerFunction;
import cyj.tracker.user.User;

public class FoodDeleteFunction implements TrackerFunction {
	private Food food;
	private final InputHandler handler = new InputHandler();
	private final FoodService service;
	private final AuthService authService;
	
	public FoodDeleteFunction(FoodService service, AuthService authService) {
		super();
		this.service = service;
		this.authService = authService;
	}

	@Override
	public void input() {
		String name = handler.getString("👉 삭제할 음식의 이름을 입력하세요 > ");
		
		food = new Food(name);
	}

	@Override
	public void execute() {
		User currentUser = authService.getCurrentUser();
		if(service.isExists(food, currentUser)) {
			String yn = handler.getString("정말로 음식 기록을 삭제하시겠습니까? (y/n) ");
			if(yn.toLowerCase().equals("y")) {
				service.deleteFood(food);
				System.out.println("음식기록이 삭제되었습니다.");
			} else {
				System.out.println("삭제가 취소되었습니다.");
			}
		} else {System.out.println("입력하신 음식은 존재하지 않습니다.");}

	}

}
