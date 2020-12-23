

public class Employee extends Person implements IPerson{
	private String empno; //��������� ������ private!!!
	private double salary;
		
//	Employee(){};
	
	Employee(String name, int age, String address, String empno, double salary){
//		super(name, age, address);
		this.empno = empno;
		this.salary = salary;

	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {		
		this.salary = salary;
	}
//	@Override
//	public String toString() {
//		return super.toString() + "\nEmployee [empno=" + empno + ", salary=" + salary + "]";  //�θ� abstract�Ǽ� �� ��.
//	};

	public void printInfo() {
		System.out.println("��� = " + empno + ",���� = " + salary);
		
	}
	@Override
	public String toString() {
		return String.format("%s, %d, %s, %s, %.1f\n", getName(), getAge(), getAddress(), empno, salary);  //empno, salary�� ���� �ı��ϱ� ������� ��! 
	}//getname getage getaddress���� �θ� ��� ���� ������~�ٷ� �� �� �ִ�.
	
	
}