package cyj.tracker.user;

import cyj.tracker.basic.TrackerFunction;
import cyj.tracker.basic.InputHandler;

public class UserSearchFunction implements TrackerFunction {
	private User user;
	private final InputHandler handler = new InputHandler();
	private final UserService service;
	
	public UserSearchFunction(UserService service) {
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
		if(service.isExists(user)) {
			User res = service.searchUser(user);
			// 출력
			System.out.println("\n--------------------");
			System.out.println("⚜ 사용자 정보 조회");
			System.out.println("■ 이메일: " + res.getEmail());
			//System.out.println("👉 비밀번호: " + "*".repeat(user.getPassword().length()));
			System.out.println("■ 이름: " + res.getName());
			System.out.println("■ 나이: " + res.getAge());
			System.out.println("■ 키: " + res.getHeight());
			System.out.println("■ 몸무게: " + res.getWeight());
			
			String str = "";
			
			switch(res.getActivityLevel()) {
				case 0: str = "거의 운동 안 함"; break; 
				case 1: str = "가벼운 운동 (주 1-3회)"; break; 
				case 2: str = "보통 (주 3-5회)"; break; 
				case 3: str = "적극적 운동 (주 6-7회)"; break; 
				default: str = "거의 운동 안 함"; break; 
			};
			System.out.println("■ 활동지표: " +str+"("+res.getActivityLevel()+")");
			System.out.println("■ 하루 권장 칼로리: "+ res.getTargetCalories()+"kcal");
			
			System.out.println("--------------------\n");
		}else {System.out.println("입력하신 이메일과 비밀번호는 존재하지 않습니다.");}
	}
	
}
