package cyj.tracker.user;

import cyj.tracker.basic.TrackerFunction;
import cyj.tracker.basic.InputHandler;

public class UserDeleteFunction implements TrackerFunction {
	private User user;
	private final InputHandler handler = new InputHandler();
	private final UserService service;
	
	public UserDeleteFunction(UserService service) {
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
				String yn = handler.getString("정말로 회원 정보를 삭제하시겠습니까? (y/n) ");
				if(yn.toLowerCase().equals("y")) {
					User res = service.deleteUser(user);
					System.out.println(res.getName()+"님에 대한 회원정보가 삭제되었습니다.");
				} else {
					System.out.println("삭제가 취소되었습니다.");
				}
			}else {System.out.println("입력하신 이메일과 비밀번호는 존재하지 않습니다.");}
		}else {System.out.println("관리자는 삭제가 불가능 합니다.");}
	}

}
