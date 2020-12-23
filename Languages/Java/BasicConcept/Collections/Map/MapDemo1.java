import java.util.Enumeration;
import java.util.Properties;

//�ڹ��� ���� p658
//properties

//�ڹٴ� �ü���� ���ؼ� �𸣴� getproperties�� �����. �׷��� �ڹٿ� ���õ� �ü���� ���� ������ ���� �� �ִ� ���ϸ鼭�� �ſ� �߿��� �޼���
//���߿� ȯ�漳�� �� �� properties�� �� �Ѵ�~

public class MapDemo1 {
	public static void main(String[] args) {
		//�ڹٿ� Os������ ��ſ��� :system
		
//		System.out.println(System.getProperty("os.name" )); //Windows 10 //�ڹٴ� OS�� �𸣴ϱ� �ý���(system.)�� ���ؼ� �����.
//		System.out.println(System.getProperty("user.name" )); //�ڹٴ� �ý����� ������ �𸣴ϱ� �ý���(system.)�� ���ؼ� �����.
//		System.out.println(System.getProperties()); //�׳� �� ������� (System�� ���� �� �о��)
		
		Properties info = System.getProperties(); // ()�ȿ� �� key�� �˾ƾ� value�� �̴´�
		Enumeration<Object> enums = info.keys();  // Enumeration���� �޼ҵ� 2�� ����. hasmorelements, nextelement
		while(enums.hasMoreElements()) {
			String key = (String) enums.nextElement(); //nextelements�ϸ� object�� ���´�(�� �� object ���ö� obejct�ϱ� ), �׸��� string���� ����ȯ
			System.out.println(key + "-->" + System.getProperty(key));  //�� ������ �͵� �츮�� �� �ܿ�
		}
	}
}










