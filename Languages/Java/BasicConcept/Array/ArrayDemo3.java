//��������
public class ArrayDemo3 {
	public static void main(String[] args) {
		Car sonata = new Car();
		sonata.name = "Sonata"; 
		sonata.price = 25_000_000;
		
		Car carnival = new Car();
		carnival.name = "Carnival"; 
		carnival.price=30_000_000;  // name�� �������
	
 		
//		Car�� ����� ���� �ƴ϶�, Car��� �ڵ����� ���ߵ� array�� �����
		Car[] array;  //���� 
		array = new Car[2];  //����
		
		array[0] = new Car(); 
		array[0].name = "Sonata"; 
		array[0].price = 25_000_000;
				
		array[1] = new Car();
		array[1].name = "Carnival";
		array[1].price = 30_000_000;
		
		for(int i = 0 ; i<array.length ; i++) {
			System.out.printf("�̸� = %s, ����=%d\n", array[i].name, array[i].price);
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



