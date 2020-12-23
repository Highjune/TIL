import java.net.InetAddress;
import java.net.UnknownHostException;

//코드는 깃헙에 다 있다.(/swacademy)
//p949


public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		//static이라 new못 씀(by api)
		//DNS역할하는 것임.(host name을 ip로 바꿔주는 것)
		/*
		InetAddress ia1 = InetAddress.getByName("naver.com"); //host이름(naver.com)을 사용함으로써 InetAddress형을 얻음.
		System.out.println(ia1.getHostAddress()); //naver.com의 IP를 얻을 수 있다.
		
		InetAddress ia2 = InetAddress.getByName("localhost"); 
		System.out.println(ia2.getHostAddress()); //localhost는 항상 127.0.0.1 // hosts파일을 열어보면 127.0.0.1 localhost로 잡혀있음.
		
		InetAddress ia3 = InetAddress.getByName("JunePC"); //cmd에서 hostname하면 내 컴퓨터 이름
		System.out.println(ia3.getHostAddress());
		*/
		
//		cf) ipconfig해보면 우리의 ip는 2개다. virtual용 ip 1개, 진짜 ip 1개. 하나의 랜 카드에 ip가 2개임 
//		naver나 google은 여러가지 서비스를 다 사용하니 당연히 ip를 1개만 쓰지 않는다.
//		그래서 getbyName()으로 1개만 잡지 않고 getAllbyName()을 사용한다. 하나의 이름이 여러개의 ip를 사용할 수도 있으니깐.
		
		InetAddress [] array1 = InetAddress.getAllByName("google.com"); //ex) IP가 1개가 아닌 경우에는 getallbyname으로 읽어야 되고 여러개니까 배열로
		InetAddress [] array2 = InetAddress.getAllByName("samsung.com"); //
		InetAddress [] array3 = InetAddress.getAllByName("JunePC"); // 내 것 여러개가 있다.
		for(InetAddress ia : array3) { //array1, array2도 확인해보기.
			System.out.println(ia.getHostAddress()); 
		}
	
	}
}
