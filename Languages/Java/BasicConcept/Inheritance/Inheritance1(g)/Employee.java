
public class Employee extends Person {
	private String empno;

	public Employee(String empno, String name, int age) {
		super(name, age);
		this.empno = empno;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}
	
}

