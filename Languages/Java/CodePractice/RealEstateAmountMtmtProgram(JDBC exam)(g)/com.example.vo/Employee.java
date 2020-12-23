package com.example.vo;

public class Employee {
	private String empno, name, code, dname;
	private int num, grade, nightcode, family, familyBonus, bonus, nightBonus, defaultSalary;
	private int total, money;
	
	public Employee() {}
	public Employee(String empno, String name, String code, int num, int grade, int nightcode, 
			int family) {
		this.empno = empno;
		this.name = name;
		this.code = code;
		this.num = num;
		this.grade = grade;
		this.nightcode = nightcode;
		this.family = family;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getNightcode() {
		return nightcode;
	}
	public void setNightcode(int nightcode) {
		this.nightcode = nightcode;
	}
	public int getFamily() {
		return family;
	}
	public void setFamily(int family) {
		this.family = family;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getFamilyBonus() {
		return familyBonus;
	}
	public void setFamilyBonus(int familyBonus) {
		this.familyBonus = familyBonus;
	}
	public int getNightBonus() {
		return nightBonus;
	}
	public void setNightBonus(int nightBonus) {
		this.nightBonus = nightBonus;
	}
	public int getDefaultSalary() {
		return defaultSalary;
	}
	public void setDefaultSalary(int defaultSalary) {
		this.defaultSalary = defaultSalary;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t%5d%,10d%,8d%,7d%,10d%,10d",
				empno, name, dname, num, bonus, familyBonus, nightBonus, total, money);
	}
}
