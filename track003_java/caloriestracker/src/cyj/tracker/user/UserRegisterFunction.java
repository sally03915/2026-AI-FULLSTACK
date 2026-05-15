package cyj.tracker.user;

import cyj.tracker.basic.TrackerFunction;
import cyj.tracker.basic.InputHandler;

public class UserRegisterFunction implements TrackerFunction{
	private User user;
	private final InputHandler handler = new InputHandler();
	private final UserService service;
	
	
	public UserRegisterFunction(UserService service) {
		super();
		this.service = service;
	}

	@Override
	public void input() {
		String email; String password;
		String name; int age;
		double height; double weight; int activityLevel;
		double targetCalories = 0.0;
		int cnt = 10;
		
		email = handler.getString("👉 이메일을 입력하세요 > ");
		password = handler.getString("👉 비밀번호를 입력하세요 > ");
		name = handler.getString("👉 이름을 입력하세요 > ");
		age = handler.getInt("👉 나이를 입력하세요 > ");
		height = handler.getDouble("👉 키를 입력하세요 > ");
		weight = handler.getDouble("👉 몸무게를 입력하세요 > ");
		activityLevel = -1;
		while(activityLevel < 0 || activityLevel > 3) {			
			activityLevel = handler.getInt("👉 본인의 활동 정도를 입력하세요 0(거의안함) ~ 3(적극적) > ");
			cnt--;
			if(cnt == 0) {
				System.out.println("지나친 시도로 인해 활동정도를 기본으로 지정합니다.");
				activityLevel = 0;
			}
		}
		
		this.user = new User(email, password, name, age, height, weight, activityLevel, targetCalories);
		targetCalories = this.user.calculateTargetCalories();
	}

	@Override 
	public void execute() {
		User res = service.registerUser(user);
	}

}
