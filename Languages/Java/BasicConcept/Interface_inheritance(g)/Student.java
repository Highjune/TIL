public class Student extends Person implements IPerson{
	private String hakbun;
	private int score;
	
//	Student(){};
	
	public Student(String name, int age, String address, String hakbun, int score){
		super(name, age, address); //�θ������ 3�� ����.
		this.hakbun = hakbun;
		this.score = score;	
	}

	public String getHakbun() {
		return hakbun;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	//�������̽� IPerson�� ���������Ƿ� �ݵ�� ������ �ؾߵ�
	public void printInfo() {  
		System.out.print("�й� = " + hakbun + ",���� = " + score);
	}
	
	
//	@Override
//	public String toString() {
//		return super.toString() +  "\nStudent [hakbun=" + hakbun + ", score=" + score + "]";  //�θ��� �޼��尡 �߻��̶� ȣ���� �ȵȴ�.
//	}
	
	
//	public String toString() {		//�θ��� toString�� ������ �� ����. cf) toString�� Object�� �θ���.
//		return "Student [name=" + getName() + ", age=" + getAge() + 
//				",address=" + getAddress() + ",hakbun = "+ hakbun + ", score=" + score + "]";
//	}
//	//getname�� ��� this.getname()�̴�. �׷��� this.getname()���� �θ𲨸� ���پ��µ��� this? . ����̴ϱ�! this�� �ص� �ȴ�.
//	
	@Override
	public String toString() {
		return String.format("%s, %d, %d, %d, %d\n",
				getName(), getAge(), getAddress(), hakbun, score);
	}
	//return "Student [name=" + getName() + ", age=" + getAge() + 
//	",address=" + getAddress() + ",hakbun = "+ hakbun + ", score=" + score + "]"; ���� �̷��� �ؾ� ������ ��ó�� ���ϰ� ����!!
	
	
}