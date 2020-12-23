import java.net.InetAddress;
import java.net.UnknownHostException;

//�ڵ�� ���鿡 �� �ִ�.(/swacademy)
//p949


public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		//static�̶� new�� ��(by api)
		//DNS�����ϴ� ����.(host name�� ip�� �ٲ��ִ� ��)
		/*
		InetAddress ia1 = InetAddress.getByName("naver.com"); //host�̸�(naver.com)�� ��������ν� InetAddress���� ����.
		System.out.println(ia1.getHostAddress()); //naver.com�� IP�� ���� �� �ִ�.
		
		InetAddress ia2 = InetAddress.getByName("localhost"); 
		System.out.println(ia2.getHostAddress()); //localhost�� �׻� 127.0.0.1 // hosts������ ����� 127.0.0.1 localhost�� ��������.
		
		InetAddress ia3 = InetAddress.getByName("JunePC"); //cmd���� hostname�ϸ� �� ��ǻ�� �̸�
		System.out.println(ia3.getHostAddress());
		*/
		
//		cf) ipconfig�غ��� �츮�� ip�� 2����. virtual�� ip 1��, ��¥ ip 1��. �ϳ��� �� ī�忡 ip�� 2���� 
//		naver�� google�� �������� ���񽺸� �� ����ϴ� �翬�� ip�� 1���� ���� �ʴ´�.
//		�׷��� getbyName()���� 1���� ���� �ʰ� getAllbyName()�� ����Ѵ�. �ϳ��� �̸��� �������� ip�� ����� ���� �����ϱ�.
		
		InetAddress [] array1 = InetAddress.getAllByName("google.com"); //ex) IP�� 1���� �ƴ� ��쿡�� getallbyname���� �о�� �ǰ� �������ϱ� �迭��
		InetAddress [] array2 = InetAddress.getAllByName("samsung.com"); //
		InetAddress [] array3 = InetAddress.getAllByName("JunePC"); // �� �� �������� �ִ�.
		for(InetAddress ia : array3) { //array1, array2�� Ȯ���غ���.
			System.out.println(ia.getHostAddress()); 
		}
	
	}
}
