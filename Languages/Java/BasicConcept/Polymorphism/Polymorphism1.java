import java.util.Scanner;

public class PolymorphismDemo {
	public static void main(String[] args) {
	
		Parent p = new Child(); 
		p.display(); // �θ��� �ּ�(p)�ε� �̰� �ڽ��� �޼ҵ带 ȣ����!!! => ������
		
		Object obj = new String("Hello"); //String�� obj�� �Ǳ⵵ �ϰ�~
		obj = new Integer("5"); // Integer�� obj�� �Ǳ⵵ �ϰ�~
		obj = new Scanner(System.in); //Scanner�� obj�� �Ǳ⵵ �ϰ�~
	
		
	}
}


class Parent{
	public void display() {System.out.println("���� �θ� �޼ҵ�");}
	}
class Child extends Parent{
	@Override // �Ȱ��� �޼ҵ� �̸�
	public void display() {System.out.println("���� �ڽ� �޼ҵ�");}
	}

//Override�޼ҵ�� ��ӵ��� �ʴ´�. cf) ����� �ȵǱ� ������ �θ� �޼ҵ��� body�� �ٲٴ� ��. ex) ���� �ߴ� ��ó�� �θ� ������ �ִ� toString�� equals�� ������