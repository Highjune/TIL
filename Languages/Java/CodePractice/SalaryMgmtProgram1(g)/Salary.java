
public class Salary implements Comparable<Salary> {
	private String sabun, name, department;
	private int defSalary, nightHour, family, hoSalary, familyBonus, nightBonus, sum, salary;
	
	public Salary(String sabun, String name, int defSalary, int nightHour, int family) {
		this.sabun = sabun;
		this.name = name;
		this.defSalary = defSalary;
		this.nightHour = nightHour;
		this.family = family;
	}

	public String getSabun() {
		return sabun;
	}

	public void setSabun(String sabun) {
		this.sabun = sabun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getDefSalary() {
		return defSalary;
	}

	public void setDefSalary(int defSalary) {
		this.defSalary = defSalary;
	}

	public int getNightHour() {
		return nightHour;
	}

	public void setNightHour(int nightHour) {
		this.nightHour = nightHour;
	}

	public int getFamily() {
		return family;
	}

	public void setFamily(int family) {
		this.family = family;
	}

	public int getHoSalary() {
		return hoSalary;
	}

	public void setHoSalary(int hoSalary) {
		this.hoSalary = hoSalary;
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

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Salary [sabun=" + sabun + ", name=" + name + ", department=" + department + ", defSalary=" + defSalary
				+ ", nightHour=" + nightHour + ", family=" + family + ", hoSalary=" + hoSalary + ", familyBonus="
				+ familyBonus + ", nightBonus=" + nightBonus + ", sum=" + sum + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Salary other) {
		return this.sabun.compareTo(other.sabun);
	}
	
}
