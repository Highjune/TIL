
class Person{
	long id;	//this.id
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Person))
			return false;
		
		Person p = (Person)obj;
		return this.id == p.id;
		//위의 2줄을 아래 1줄로 가능
		//return this.id ==((Person)obj).id;		
	}
	
	Person(long id){
		this.id = id;
	}		

}

class Ex9_2 {
	public static void main(String[] args) {
		Person p1 = new Person(8011071112222L);
		Person p2 = new Person(8011071112222L);
		
		if(p1.equals(p2))
			System.out.println("p1과 p2는 같은 사람입니다.");
		else
			System.out.println("p1과 p2는 다른 사람입니다.");
		
	}		
}

