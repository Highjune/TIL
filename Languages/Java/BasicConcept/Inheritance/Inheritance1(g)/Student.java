
public class Student extends Person {

	private String hakbun;
	
	public Student(String hakbun, String name, int age) {
		super(name, age); // �ݵ�� ���� ���ٿ� �;� ��
		this.hakbun = hakbun;
	}
		
	public String getHakbun() {
		return hakbun;
	}

	
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	
	
	
	
	
	
	
	


	
	
	
}
