package cyj.tracker.auth;

import cyj.tracker.user.User;
import cyj.tracker.user.UserRepository;
import cyj.tracker.user.UserService;
import cyj.tracker.user.UserServiceImpl;

public class AuthServiceImpl implements AuthService {
	private UserRepository userRepo = new UserRepository();
	private UserService service = new UserServiceImpl(userRepo);
	private User currentUser; // 현재 로그인된 사용자 객체
	
	@Override
	public boolean isLoggedIn() {
		return this.currentUser != null;
	}
	
	@Override
	public void login(String email, String password) {
		User tryUser = new User(email, password);
		if(service.isExists(tryUser)) {
			this.currentUser = service.searchUser(tryUser);
		}
	}

	@Override
	public void logout() {
		this.currentUser = null;
	}

	@Override
	public User getCurrentUser() {
		return currentUser;
	}

	@Override
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	
}
