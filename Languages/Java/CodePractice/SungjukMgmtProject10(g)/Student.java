public class Student{
	//멤버변수의 이름들은 DB의 
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
	@Override
	public String toString() {
		return "Student [hakbun=" + hakbun + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat
				+ ", tot=" + tot + ", avg=" + avg + ", grade=" + grade + "]";
	}
}
