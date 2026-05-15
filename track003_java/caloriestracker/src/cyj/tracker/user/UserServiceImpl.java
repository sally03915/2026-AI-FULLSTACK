package cyj.tracker.user;

public class UserServiceImpl implements UserService {
	private final UserRepository userRepo;
	
	public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

	@Override
	public boolean isExists(User user) {
		User existUser = userRepo.selectByUserId(user.getEmail());
		return existUser != null && existUser.getPassword().equals(user.getPassword());
	}
	
	@Override
	public boolean isAdmin(User user) {
		return user.getEmail().equals("admin")? true: false;
	}
	
	@Override
	public User registerUser(User user) {
		return userRepo.insertUser(user);
	}

	@Override
	public User searchUser(User user) {
		return userRepo.selectByUserId(user.getEmail());
	}

	@Override
	public User updateUser(User user) {
		return userRepo.updateUser(user);
	}

	@Override
	public User deleteUser(User user) {
		return userRepo.deleteByUserId(user.getEmail());
	}

}
