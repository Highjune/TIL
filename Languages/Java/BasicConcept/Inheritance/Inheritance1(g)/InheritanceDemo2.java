//Person , Student, Employee �� �Բ� ���� ��. �� inheritancedemo2 �� ����~

public class InheritanceDemo2 {
	public static void main(String[] args) {
		Student chulsu = new Student("2019-01", "������", 29);
		Employee jimin = new Employee("Handok-2017", "������", 30);
		System.out.println("���� = " + chulsu.getAge());
		System.out.println("���� = " + chulsu.getAge());
	}
}
