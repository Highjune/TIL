//Student, person, employee �� ��� //~��ӱ��� ���� ����!


//public class Main2 {
//public static void main(String[] args) {
//	
//	
//	Student chulsu = new Student("��ö��", 24, "������ ���ﵿ", "2019-01", 90); //�θ�(Person) �� 3�� ���ϰ� �ڱⰡ 2�� ����
//	System.out.println("ö���� ����");
//	System.out.println(chulsu); //chulsu.toString()
//	
//	System.out.println("������ ����");
//	Employee jimin = new Employee("������", 34, "�λ�� �ؿ�뱸", "2018-05", 250); //�θ�(Person) �� 3�� ���ϰ� �ڱⰡ 2�� ����
//	System.out.println(jimin);
//	
//			
//}
//
//}

public class Main2 {
public static void main(String[] args) {
	
	Person person; //����
	person = new Student("��ö��", 24, "������ ���ﵿ", "2019-01", 90); // Person�� �߻��̶� �ڽ����� �����~
	//�ڽ��� student�� �θ�� ����ȯ ����
	System.out.println("ö���� ����");
	System.out.println(person); //chulsu.toString()
	
	System.out.println("������ ����");
	person = new Employee("������", 34, "�λ�� �ؿ�뱸", "2018-05", 250); // 	//�ڽ��� Employee�� �θ�� ����ȯ ����
	System.out.println(person);
	
	
}

}