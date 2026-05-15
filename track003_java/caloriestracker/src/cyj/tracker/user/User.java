package cyj.tracker.user;

import java.util.Objects;

public class User {
	private String email;
	private String password;
	private String name;
	private int age;
	private double height;
	private double weight;
	// 기초대사량(BMR)에 곱하여 하루 총 에너지 소비량(TDEE)을 계산하는 수치
	private int activityLevel; // 활동량 계수
	private double targetCalories; // 계산된 하루 권장 칼로리
	
	
	public User() { super(); }
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public User(String email, String password, String name, int age, double height, double weight, int activityLevel, double targetCalories) {
		this(email, password);
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.activityLevel = activityLevel;
		this.targetCalories = targetCalories;
	}
	
	double calculateBMR() { // 기초대사량 계산 로직
		return 10 * this.weight + 6.25 * this.height-5 * age + 5;
	} 
	double calculateTargetCalories() {// 활동량을 고려한 목표 칼로리 설정
		double bmr = calculateBMR();
		double multiplier = 0.0; 
		switch(this.activityLevel) {
	        case 0: multiplier = 1.2; break; 
	        case 1: multiplier = 1.375; break; 
	        case 2: multiplier = 1.55; break; 
	        case 3: multiplier = 1.725; break; 
	        default: multiplier = 1.2; break; 
		};
		return bmr * multiplier;
	} 
	
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email);
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", name=" + name + ", age=" + age + ", height="
				+ height + ", weight=" + weight + ", activityLevel=" + activityLevel + ", targetCalories="
				+ targetCalories + "]";
	}
	
	// getter, setter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(int activityLevel) {
		this.activityLevel = activityLevel;
	}
	public double getTargetCalories() {
		return targetCalories;
	}
	public void setTargetCalories(double targetCalories) {
		this.targetCalories = targetCalories;
	}
}
