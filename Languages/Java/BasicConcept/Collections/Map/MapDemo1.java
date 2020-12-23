import java.util.Enumeration;
import java.util.Properties;

//자바의 정석 p658
//properties

//자바는 운영체제에 대해서 모르니 getproperties로 물어본다. 그러면 자바와 관련된 운영체제에 대한 정보를 얻어올 수 있는 편하면서도 매우 중요한 메서드
//나중에 환경설정 할 때 properties로 다 한다~

public class MapDemo1 {
	public static void main(String[] args) {
		//자바와 Os사이의 통신역할 :system
		
//		System.out.println(System.getProperty("os.name" )); //Windows 10 //자바는 OS을 모르니까 시스템(system.)을 통해서 물어본다.
//		System.out.println(System.getProperty("user.name" )); //자바는 시스템의 계정을 모르니까 시스템(system.)을 통해서 물어본다.
//		System.out.println(System.getProperties()); //그냥 다 갖고오기 (System에 가서 다 읽어옴)
		
		Properties info = System.getProperties(); // ()안에 들어갈 key를 알아야 value를 뽑는다
		Enumeration<Object> enums = info.keys();  // Enumeration에는 메소드 2개 있음. hasmorelements, nextelement
		while(enums.hasMoreElements()) {
			String key = (String) enums.nextElement(); //nextelements하면 object가 나온다(들어갈 떄 object 나올때 obejct니까 ), 그리고 string으로 형변환
			System.out.println(key + "-->" + System.getProperty(key));  //찍어서 나오는 것들 우리가 못 외움
		}
	}
}










