//EXCEPTION �ǵ��� �߻���Ű�� �ڹ��� ����p424


public class ExceptionDemo5 {
	public static void main(String[] args) {
		try {  //try���� ������ catch�� �޴´�. �� Ÿ���� ���� ��츸.
			Student chulsu = new Student(101);	
			System.out.println(chulsu);
		}catch(RuntimeException e ) { //������ �����ڰ� ��������� ���ÿ� runtimeexception�� �������� ���⼭ runtimexception���� �޾���.
			System.out.println(e.getMessage());  
		}
	}
}



class Student{
	private int kor;
	public Student(int kor) {
		if(kor>=0 && kor <= 100)	this.kor = kor;
		else throw new RuntimeException("���������� 0���� 100������ �Դϴ�.");// �ּҸ� ���� ������ �ǹǷ� new~ 

	}
	@Override
	public String toString() {
		return "Student [kor=" + kor + "]";
	}
	
}