import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

//��¥�� ǥ���ϴ� ���3
//DateFormat
//������� Ʋ������ locale base�� ���� ���
public class Date4 {
	public static void main(String[] args) {
		
		DateFormat df = DateFormat.getDateInstance(); //��, ��, �� 
		DateFormat df1 = DateFormat.getTimeInstance();  // �ð�
		DateFormat df2 = DateFormat.getInstance();  // ��, ��, �ϰ� �ð� �� ��
		
		DateFormat df3 = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);  // ��, ��, �ϰ� �ð� �� �� (���� �ڼ��ϰ�, ������ ���� �� Ȯ��). �Ķ����1 - ��¥, �Ķ����2 - �ð�
		System.out.println(df3.format(new Date()));
		
		DateFormat df4 = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.US);  // �Ķ����3 - Locale(����, ������, ��ġ������ ����, �ѱ��� ���ԵǾ� �ִ�), FULL-�ڼ���
//		DateFormat df4 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.US);  // SHORT-����
		System.out.println(df4.format(new Date()));
	}
}
