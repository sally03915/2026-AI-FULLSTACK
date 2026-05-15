package cyj.tracker.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
	private Map<String, User> store = new HashMap<>();
	private final String FOLDER_PATH = "src/cyj/tracker/data/";
	private final String FILE_PATH = "users.txt";
	
	public UserRepository() {
		loadUsers();
	}
	
	private void saveUsers() {
		File folder = new File(FOLDER_PATH);
		File file = new File(FOLDER_PATH + FILE_PATH);
	
		try {
			if(!folder.exists()) folder.mkdirs();
			if(!file.exists()) file.createNewFile();
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));			
			StringBuffer sb = new StringBuffer();
			for(User user : store.values()) {
				sb.append(String.format("%s|%s|%s|%d|%.1f|%.1f|%d|%.1f\n", 
						user.getEmail(), user.getPassword(), user.getName(), 
						user.getAge(), 
						user.getHeight(), user.getWeight(), 
						user.getActivityLevel(), user.getTargetCalories()));
			}
			
			bw.write(sb.toString());
			bw.close();
		} catch(IOException e) { 
			System.out.println("파일 저장 중 오류 발생..."+ e.getMessage()); 
		}
	}
	
	private void loadUsers() {
		File file = new File(FOLDER_PATH + FILE_PATH);
		if(!file.exists()) return;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line;
			while((line = br.readLine()) != null) {
				String[] data = line.split("\n");
				for( String obj : data) {					
					String[] var = obj.split("\\|");
					User user = new User(
							var[0], var[1], var[2], // 이메일, 비밀번호, 이름
							Integer.parseInt(var[3]), // 나이
							Double.parseDouble(var[4]),Double.parseDouble(var[5]), // 키, 몸무게
							Integer.parseInt(var[6]), // 활동계수
							Double.parseDouble(var[7])
							);
					store.put(user.getEmail(), user);
				}
			}
			
			br.close();
		} catch (Exception e) {
			System.out.println("파일 로드 중 오류 발생..."+ e.getMessage()); 
		}
		
	}

	public User insertUser(User user) {
		User res = store.put(user.getEmail(), user);
		saveUsers();
		return res;
	}

	public User selectByUserId(String email) {
		User res = store.get(email);
		return res;
	}

	public User updateUser(User user) {
		User res = store.put(user.getEmail(), user);
		saveUsers();		
		return res;
	}

	public User deleteByUserId(String email) {
		User res = store.remove(email);
		saveUsers();
		return res;
	}
}
