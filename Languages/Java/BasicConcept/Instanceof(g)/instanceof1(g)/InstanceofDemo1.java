
//public class InstanceofDemo1 {
//	public static void main(String[] args) {
//		Sonata sonata = new Sonata("���� �ҳ�Ÿ");
//		remake(sonata);
//		Carnival carnival = new Carnival("��� ī�Ϲ�");
//		remake(carnival); 
//		//������ ������ ���. Ÿ���� �ٸ��ϱ�. �׷��� �ؿ� �Ķ���Ͱ� �ٸ� �����ε� 	static void remake(Carnival carnival) {carnival.repair();}���ش�
//		Matiz matiz = new Matiz("������ ��Ƽ��"); 
//		remake(matiz); //������ ���. Ÿ���� �ٸ��ϱ�. �׷��� �ؿ� �Ķ���Ͱ� �ٸ� �����ε�	static void remake(Matiz matiz) {matiz.repair();} ������ָ� ���� �� ���.
//			
//	}
//	static void remake(Sonata sonata) {sonata.repair();}
//	static void remake(Carnival carnival) {carnival.repair();}
//	static void remake(Matiz matiz) {matiz.repair();}
//}

//==> �̷��� �Ź� �޼��帶�� remake�� ���� �� ����� ����ϱ� �Ű������� ������ �̿�(p367)

public class InstanceofDemo1 {
	public static void main(String[] args) {
		Sonata sonata = new Sonata("���� �ҳ�Ÿ");
		remake(sonata);
		Carnival carnival = new Carnival("��� ī�Ϲ�");
		remake(carnival); //������ ���. Ÿ���� �ٸ��ϱ�. �׷��� �ؿ� �Ķ���Ͱ� �ٸ� �����ε� 	static void remake(Carnival carnival) {carnival.repair();}���ش�
		Matiz matiz = new Matiz("������ ��Ƽ��"); 
		remake(matiz); //������ ���. Ÿ���� �ٸ��ϱ�. �׷��� �ؿ� �Ķ���Ͱ� �ٸ� �����ε�	static void remake(Matiz matiz) {matiz.repair();} ������ָ� ���� �� ���.
			
	}
	static void remake(Car car) {car.repair();} //�޼ҵ尡 �ϳ��� ��. �����ε��ϸ鼭 �޼ҵ带 ������ŭ �� �ʿ� ����. Polymorphic Parameter��� �Ѵ�.
	}

//�׷��� �̷��� �������� �� ���� ������ �ȴ�. ������ �Ǵ��� �ȵǴ����� ������ �ƴϴ�. ������ ������ ���������� �𸣴� ����. �װͿ� �°�(����) ��ǰ(Ÿ�̾� ��)�� ���Ƴ��� �� �����ϱ�
//�׷���!! instanceof�� 2���� ��� ����


//public class InstanceofDemo1 {
//	public static void main(String[] args) {
//		Sonata sonata = new Sonata("���� �ҳ�Ÿ");
//		remake(sonata);
//		Carnival carnival = new Carnival("��� ī�Ϲ�");
//		remake(carnival); //������ ���. Ÿ���� �ٸ��ϱ�. �׷��� �ؿ� �Ķ���Ͱ� �ٸ� �����ε� 	static void remake(Carnival carnival) {carnival.repair();}���ش�
//		Matiz matiz = new Matiz("������ ��Ƽ��"); 
//		remake(matiz); //������ ���. Ÿ���� �ٸ��ϱ�. �׷��� �ؿ� �Ķ���Ͱ� �ٸ� �����ε�	static void remake(Matiz matiz) {matiz.repair();} ������ָ� ���� �� ���.
//			
//	}
//	static void remake(Car car) {	//Polymorphic Parameter
//		if(car instanceof Sonata) {
//			System.out.println("�ҳ�Ÿ�� �����ƽ��ϴ�.");
//		}else if(car instanceof Carnival) {
//			System.out.println("ī�Ϲ��� �����ƽ��ϴ�.");
//		}else if(car instanceof Matiz) {
//			System.out.println("��Ƽ� �����ƽ��ϴ�.");
//		}
//	}
//
//}
//�׷��� �� ���ο� ������ �����. ��� �͵��� �� instatnceof�� Ȯ���غ��ߵǳ�?
// ==> �׷��� ���� ���� ���׸�




