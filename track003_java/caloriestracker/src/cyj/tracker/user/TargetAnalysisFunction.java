package cyj.tracker.user;

import java.util.List;

import cyj.tracker.auth.AuthService;
import cyj.tracker.basic.TrackerFunction;
import cyj.tracker.food.Food;
import cyj.tracker.food.FoodService;

public class TargetAnalysisFunction implements TrackerFunction {
	private User currentUser;
	private List<Food> foodList;
	private final FoodService service;
	private final AuthService authService;
	
	public TargetAnalysisFunction(FoodService service, AuthService authService) {
		super();
		this.service = service;
		this.authService = authService;
	}

	@Override
	public void input() {
		currentUser = authService.getCurrentUser();
		foodList = service.searchFood(currentUser);
	}

	@Override
	public void execute() {
		double totalCal = 0, totalCarbs = 0, totalProtein = 0, totalFat = 0;

	    for (Food f : foodList) {
	        totalCal += f.getCalories();
	        totalCarbs += f.getCarbs();
	        totalProtein += f.getProtein();
	        totalFat += f.getFat();
	    }
		
		System.out.println("\n=== 📊 오늘의 영양 분석 결과 ===");
		System.out.printf("목표 칼로리: %.1f kcal / 현재 섭취: %.1f kcal\n", currentUser.getTargetCalories(), totalCal);
		
		System.out.println("\n[영양소 섭취 현황]");
	    System.out.printf("탄수화물: %.1fg | 단백질: %.1fg | 지방: %.1fg\n", totalCarbs, totalProtein, totalFat);

	    if (totalCal > currentUser.getTargetCalories()) {
	        System.out.println("\n⚠️ 오늘 목표치를 초과했습니다. 가벼운 산책은 어떨까요?");
	    } else {
	        System.out.println("\n✅ 적절한 식단을 유지하고 계시네요!");
	    }
	}

}
