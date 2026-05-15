package cyj.tracker.auth;

import cyj.tracker.basic.InputHandler;
import cyj.tracker.basic.TrackerFunction;
import cyj.tracker.user.User;

public class AuthLoginFunction implements TrackerFunction {
	private final InputHandler handler = new InputHandler();
	private final AuthService service;
	private User user;
	
	public AuthLoginFunction(AuthService service) {
		super();
		this.service = service;
	}

	@Override
	public void input() {
		String email = handler.getString("👉 이메일을 입력하세요 > ");
		String password = handler.getString("👉 비밀번호를 입력하세요 > ");
		
		this.user = new User(email, password);
	}

	@Override
	public void execute() {
		service.login(this.user.getEmail(), this.user.getPassword());
		
		if(!service.isLoggedIn()) {
			System.out.println("❌ 이메일 또는 비밀번호가 틀립니다.");
		}
	}

}
