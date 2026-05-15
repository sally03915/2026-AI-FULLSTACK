package cyj.tracker.auth;

import cyj.tracker.user.User;

public interface AuthService {
	public boolean isLoggedIn();
	
	public void login(String email, String password);
	public void logout();
	
	public User getCurrentUser();
	public void setCurrentUser(User currentUser);
}
