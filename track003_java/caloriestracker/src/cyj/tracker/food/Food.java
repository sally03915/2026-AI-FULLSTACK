package cyj.tracker.food;

import java.util.Objects;

public class Food {
	private String name; // 음식이름
	private double calories;
	private double carbs; // 탄수화물
	private double protein; // 단백질
	private double fat; // 지방
	
	public Food() { super(); }
	
	public Food(String name) {
		super();
		this.name = name;
	}
	
	public Food(String name, double calories, double carbs, double protein, double fat) {
		super();
		this.name = name;
		this.calories = calories;
		this.carbs = carbs;
		this.protein = protein;
		this.fat = fat;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		return Objects.equals(name, other.name);
	}

	public String getSummmary(){ //음식의 영양 성분을 한 줄로 요약해 반환
		String result = String.format("%s의 영양 성분(%.2fkcal): \n탄수화물(%.2fg), 단백질(%.2fg), 지방(%.2fg)", name, calories, carbs, protein, fat);
		return result;
	}
	
	@Override
	public String toString() {
		return "Food [name=" + name + ", calories=" + calories + ", carbs=" + carbs + ", protein=" + protein + ", fat="
				+ fat + "]";
	}

	//getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getCarbs() {
		return carbs;
	}

	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}
}
