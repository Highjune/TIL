import java.text.SimpleDateFormat;
import java.util.Date;

//��¥�� ǥ���ϴ� ���4
//SimpleDateFormat
//���ϴ� ���Ŀ� �°� ǥ���ϰ� ���� ��
public class Date5 {
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(new Date()));
	}
}
