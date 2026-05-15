package cyj.tracker.user;

public interface UserService {
	public boolean isExists(User user);
	public boolean isAdmin(User user);
	
	public User registerUser(User user);
	public User searchUser(User user);
	public User updateUser(User user);
	public User deleteUser(User user);
}
