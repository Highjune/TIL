package com.example.vo;

//���� �����͸� ������ �ִ� ��ü
public class StudentVO {
	private String hakbun, name, grade;
	private int kor, eng, mat, edp, tot;
	private double avg;
	
	//�⺻������
	public StudentVO() {}
	
	//�Է��� ���� ������ (�⺻ ������ ���� �� �ʿ��� ��)
	public StudentVO(String hakbun, String name, int kor, int eng, int mat, int edp) {
		this.hakbun = hakbun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.edp = edp;
	}
	
	//��� ���� �� ���� �� �ִ� ������(arraylist�� vector�� ���� ������)
	public StudentVO(String hakbun, String name, int kor, int eng, int mat, int edp, int tot, double avg,
			String grade) {
		this.hakbun = hakbun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.edp = edp;
		this.tot = tot;
		this.avg = avg;
		this.grade = grade;
	}
	
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getEdp() {
		return edp;
	}
	public void setEdp(int edp) {
		this.edp = edp;
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
	
	//tostring�� ccode
	@Override
	public String toString() {
		return String.format("%s\t%20s%5d%5d%5d%5d%5d%10.2f%5s",
				hakbun, name, kor, eng, mat, edp, tot, avg, grade);
	}
}







