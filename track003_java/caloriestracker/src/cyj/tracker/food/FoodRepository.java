package cyj.tracker.food;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import cyj.tracker.user.User;

public class FoodRepository {
	private List<Food> foodList;
	private final String FOLDER_PATH = "src/cyj/tracker/data/";
	private final String FILE_PATH = "_food.txt";
	private String currentEmail;
	
	// 로그인한 유저에 따라 불러올 파일이 다르다.
	public void loadFoodData(String email) {
		this.currentEmail = email;
		
		File folder = new File(FOLDER_PATH);
		File file = new File(FOLDER_PATH + email + FILE_PATH);
		
		try {
			if(!folder.exists()) folder.mkdirs();
			if(!file.exists()) file.createNewFile();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line;
			foodList = new ArrayList<>();
			while((line = br.readLine()) != null) {
				String[] data = line.split("\n");
				for(String obj : data) {
					String[] var = obj.split("\\|");
					Food food = new Food(var[0],Double.parseDouble(var[1]),
							Double.parseDouble(var[2]),Double.parseDouble(var[3]),Double.parseDouble(var[4]));
					foodList.add(food);
				}
			}
			br.close();
		} catch (IOException  e) {
            System.out.println("음식 기록 로드 실패: " + e.getMessage());
        }
	}
	
	public void saveFoodData() {
		File folder = new File(FOLDER_PATH);
		File file = new File(FOLDER_PATH + currentEmail + FILE_PATH);
		
		try {
			if(!folder.exists()) folder.mkdirs();
			if(!file.exists()) file.createNewFile();
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			StringBuffer sb = new StringBuffer();
			for(Food food : foodList) {
				sb.append(String.format("%s|%.1f|%.1f|%.1f|%.1f\n",
						food.getName(), food.getCalories(),
						food.getCarbs(), food.getProtein(), food.getFat()));
			}
			bw.write(sb.toString());
			bw.close();
		} catch(IOException e) {
            System.out.println("음식 기록 저장 실패: " + e.getMessage());
		}
		
	}
	
	public void insertFood(Food food) {
		foodList.add(food);
		saveFoodData();
	}
	
	public List<Food> selectAll(User currentUser) {
		return foodList;
	}
	
	public void deleteFood(Food food) {
        foodList.remove(food);
        saveFoodData();
	}

	public Food selectOneByName(String name) {
		Food newFood = new Food(name);
		Food res = null;
		if(foodList.contains(newFood)) {
			res = foodList.get(foodList.indexOf(newFood));
		}
		return res;
	}
}
