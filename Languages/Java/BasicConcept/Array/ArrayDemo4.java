
//��������
public class ArrayDemo4 {
	public static void main(String[] args) {
		student [] array; //����
		//array = new int[] {4, 5};
		array = new student[] {new student(), new student()};  //�л��� �� �迭�� ����� ��
		array[0].name = "������";
		array[1].name = "������";
		
		array[0].address = "����� ������ ���ﵿ";
		array[1].address = "�λ�� �ؿ�뱸 �ؿ�뵿";
		for(student s : array) {    
		System.out.println(s.name);
		System.out.println(s.address);
		System.out.println("---------------");
		
		}
}
}

class Car{
	String name; 
	int price;   
	//string(��������) �� 4����Ʈ�� �ּ�, int�� 4����Ʈ�� ���̴� : 1���� Car�� ������� ������ 8����Ʈ ���� 
}


class student{
	String name, address;  //�� �л��� 8����Ʈ (���� 4����Ʈ, �ֳ��ϸ� ���� �� �����̹Ƿ� �ּҸ�)
//	double weight // -> �ϰ� �Ǹ� weight�ϳ��� 8����Ʈ
}
