import java.io.Serializable;



public class Student implements Serializable{ 
	private String hakbun, name;
	private int kor, eng, mat, tot;
	private double avg;
	private char grade;
	//public Student() {}  //default constructor
	public Student(String hakbun, String name, int kor, int eng, int mat) {
		this.hakbun = hakbun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public String getHakbun() {
		return hakbun;
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMat() {
		return mat;
	}

	//아래는 overriding 쓴 것. 자신의 부모인 Object의 toString() 을 재정의 한 것. 그래서 자바의 모든 클래스는 이렇게 쓸 수 있다. 
	@Override
	public String toString() {
		return String.format("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c", 
										hakbun, name, kor, eng, mat, tot, avg, grade); 
}
}





