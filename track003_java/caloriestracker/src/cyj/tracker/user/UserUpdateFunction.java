package cyj.tracker.user;

import cyj.tracker.basic.TrackerFunction;
import cyj.tracker.basic.InputHandler;

public class UserUpdateFunction implements TrackerFunction {
	private User user;
	private final InputHandler handler = new InputHandler();
	private final UserService service;
	
	public UserUpdateFunction(UserService service) {
		super();
		this.service = service;
	}

	@Override
	public void input() {
		String email; String password;
		email = handler.getString("👉 이메일을 입력하세요 > ");
		password = handler.getString("👉 비밀번호를 입력하세요 > ");
		
		this.user = new User(email, password);
	}

	@Override
	public void execute() {
		if(!service.isAdmin(user)) {
			if(service.isExists(user)) {
				System.out.println("\n== 새롭게 바뀔 회원 정보를 입력해주세요 ==");
				String name = handler.getString("👉 이름을 입력하세요 > ");
				int age = handler.getInt("👉 나이를 입력하세요 > ");
				double height = handler.getDouble("👉 키를 입력하세요 > ");
				double weight = handler.getDouble("👉 몸무게를 입력하세요 > ");
				int activityLevel = -1;
				int cnt = 10;
				while(activityLevel < 0 || activityLevel > 3) {			
					activityLevel = handler.getInt("👉 본인의 활동 정도를 입력하세요 0(거의안함) ~ 3(적극적) > ");
					cnt--;
					if(cnt == 0) {
						System.out.println("지나친 시도로 인해 활동정도를 기본으로 지정합니다.");
						activityLevel = 0;
					}
				}
				
				user.setName(name);
				user.setAge(age);
				user.setHeight(height);
				user.setWeight(weight);
				user.setActivityLevel(activityLevel);
				user.setTargetCalories(user.calculateTargetCalories());
				
				User updUser = service.updateUser(user);
				if(updUser != null) {
					System.out.println("⭕ 회원 정보 수정 성공");
				}else {
					System.out.println("❌ 회원 정보 수정 실패");
				}
			} else {System.out.println("입력하신 이메일과 비밀번호는 존재하지 않습니다.");}
		} else {System.out.println("관리자의 회원 정보는 수정할 수 없습니다.");}
	}
}
