//�ڹ��� ���� p370


//public class Polymorphism {
//	public static void main(String[] args) {
////		Dog[] array = new Dog[3]
//		Mammal [] array =new Mammal[4]; //�� �ȿ� �������� �� ���� �� �ִ�.
//		//==> Heterogeneous Collection
//		array[0] = new Dog();
//		array[1] = new Cat();
//		array[2] = new Korean();
//		array[3] = new American();
//		for(Mammal m : array) 
//			m.saySomething();
//		//������ �ٸ� saySomething�� �ϴµ� �˰��� �θ� �� ����.
//		//�迭�� ���� �� ���� Ÿ���� �� ���� �ƴϴ�.
//		//���� �濡 �ٸ� �������� ����.
//		//��ſ� �� �迭�� �θ�� �����ؾ� �ȴ�.****
//		//������ �濡�� �� �ڽĵ��� ����.
//	}
//}

///////////////////////////////

//public class PolymorphismDemo3 {
//	public static void main(String[] args) {
//		Object[] array = {  
//				90, 89.5, false, 'A', new Sonata("���� �ҳ�Ÿ"), new Dog(),				
//				"Hello, World"
//				//�̷��� �� ���� �� �ִ� ������ ��δ� Object�� �ڽ��̶�!!**
//		};
//		print(array);		
//	}
//	
//	static void print(Object[] array) {
//		for(Object obj : array) 
//			System.out.println(obj); //�̷��� ������ �� �� �����µ�, �ҳ�Ÿ�� ���� �̻��ϰ� ����. ����� ������ �Ϸ��� toString�� ������ �ؾ� �ȴ�.	
//	}
//}

/////////////////////

public class PolymorphismDemo3 {
	public static void main(String[] args) {
		Object[] array =   
				{90, 89.5, false, 'A', new Sonata("���� �ҳ�Ÿ"), new Dog(), "Hello, World"};
				//�̷��� �� ���� �� �ִ� ������ ��δ� Object�� �ڽ��̶�!	
		print(array);		
	}
	
	
	static void print(Object[] array) {
		for(Object obj : array) { //�̷��� Object���� �迭�� ����� ��� ���� �� ���� �� �ִ�. cf) Object�迭�� Vector��� �Ѵ�.
			if(obj instanceof Sonata) {
//				Sonata sonata = (Sonata)obj;
//				System.out.println(sonata.getName()); 
				System.out.println(((Sonata)obj).getName());   //���⼭ sonata�� null�� �����µ� �̸��� �� ���� ����. �׷��� �⺻�� null
				//obj�� sonata�� ��������ȯ ���� getName()  // ((Sonata)obj) ���� ū ()�� ���� ������ . ���� ���� �����ϰ� �Ϸ���! ���ϸ� .�� ���� ����ȴ�.
			}
			else if(obj instanceof Dog) {
				((Dog)obj).saySomething(); //�̷��� ��������ȯ �ؾ� ����� ���´�.				
			}
			else System.out.println(obj);	
		}
	}
}

//��ó�� �� �ִ°��� �������. �׷��� ���� ���� �װ��� ���� ���¸� �˾ƾ� �ȴ�. �׷��� instanceof �� �� ����.
