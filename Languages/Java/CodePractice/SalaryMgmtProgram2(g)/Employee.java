class Employee {
	private int sabun;    //사원번호
	private int grade;    //급
	private int ho;         //호
	private int sudang;  //수당
	private int jigup;     //지급액
	private double tax;  //세금
	private double salary;        //차인지급액
	Employee(int sabun, int grade, int ho, int sudang) {
		this.sabun = sabun;
		this.grade = grade;
		this.ho = ho;
		this.sudang = sudang;
	}
	int getJigup() {
		return jigup;
	}
	void setJigup(int jigup) {
		this.jigup = jigup;
	}
	double getTax() {
		return tax;
	}
	void setTax(double tax) {
		this.tax = tax;
	}
	double getSalary() {
		return salary;
	}
	void setSalary(double salary) {
		this.salary = salary;
	}
	int getSabun() {
		return sabun;
	}
	int getGrade() {
		return grade;
	}
	int getHo() {
		return ho;
	}
	int getSudang() {
		return sudang;
	}
}
