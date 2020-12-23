import java.text.SimpleDateFormat;
import java.util.Date;

//날짜를 표헌하는 방법4
//SimpleDateFormat
//원하는 형식에 맞게 표현하고 싶을 때
public class Date5 {
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(new Date()));
	}
}
