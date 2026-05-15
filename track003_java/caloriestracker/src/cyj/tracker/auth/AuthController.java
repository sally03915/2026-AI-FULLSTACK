package cyj.tracker.auth;

import cyj.tracker.basic.AppStatus;
import cyj.tracker.basic.InputHandler;
import cyj.tracker.basic.TrackerFunction;
import cyj.tracker.user.UserRegisterFunction;
import cyj.tracker.user.UserService;

public class AuthController {
	private final AppStatus status;
	private final AuthService service;
	private final UserService userService;
	private final InputHandler handler;

	public AuthController(AppStatus status, AuthService service, UserService userService, InputHandler handler) {
		this.status = status;
		this.service = service;
		this.userService = userService;
		this.handler = handler;
	}

	public void run() {
		int num;
		if (!service.isLoggedIn()) {
			System.out.println("=== 🏃‍♀️ 영양소 / 칼로리 트래커 ‍‍🏃‍♂️ ===");
			System.out.println("[1] 회원 가입");
			System.out.println("[2] 로그인");
			System.out.println("[9] 종료");
			num = handler.getInt("👉 번호를 선택하세요: ");

			if (num == 1) {
				TrackerFunction urFunc = new UserRegisterFunction(userService);
				urFunc.input();
				urFunc.execute();
			} else if (num == 2) {
				TrackerFunction login = new AuthLoginFunction(service);
				login.input();
				login.execute();
				if(service.isLoggedIn()) return;
			} else if (num == 9) {
				status.stop();
				System.out.println("종료합니다.");
			}
		}
	}
}
