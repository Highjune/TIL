class Employee {
	private int sabun;    //�����ȣ
	private int grade;    //��
	private int ho;         //ȣ
	private int sudang;  //����
	private int jigup;     //���޾�
	private double tax;  //����
	private double salary;        //�������޾�
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
