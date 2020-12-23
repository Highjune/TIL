public class Student extends Person implements IPerson{
	private String hakbun;
	private int score;
	
//	Student(){};
	
	public Student(String name, int age, String address, String hakbun, int score){
		super(name, age, address); //부모님한테 3개 보냄.
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

	//인터페이스 IPerson을 구현했으므로 반드시 재정의 해야됨
	public void printInfo() {  
		System.out.print("학번 = " + hakbun + ",점수 = " + score);
	}
	
	
//	@Override
//	public String toString() {
//		return super.toString() +  "\nStudent [hakbun=" + hakbun + ", score=" + score + "]";  //부모의 메서드가 추상이라서 호출이 안된다.
//	}
	
	
//	public String toString() {		//부모의 toString을 재정의 한 것임. cf) toString은 Object가 부모임.
//		return "Student [name=" + getName() + ", age=" + getAge() + 
//				",address=" + getAddress() + ",hakbun = "+ hakbun + ", score=" + score + "]";
//	}
//	//getname은 사실 this.getname()이다. 그런데 this.getname()에서 부모꺼를 갖다쓰는데왜 this? . 상속이니까! this로 해도 된다.
//	
	@Override
	public String toString() {
		return String.format("%s, %d, %d, %d, %d\n",
				getName(), getAge(), getAddress(), hakbun, score);
	}
	//return "Student [name=" + getName() + ", age=" + getAge() + 
//	",address=" + getAddress() + ",hakbun = "+ hakbun + ", score=" + score + "]"; 원래 이렇게 해야 하지만 위처럼 편하게 쓰자!!
	
	
}