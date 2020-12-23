
class Person{
	long id;	//this.id
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Person))
			return false;
		
		Person p = (Person)obj;
		return this.id == p.id;
		//���� 2���� �Ʒ� 1�ٷ� ����
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
			System.out.println("p1�� p2�� ���� ����Դϴ�.");
		else
			System.out.println("p1�� p2�� �ٸ� ����Դϴ�.");
		
	}		
}

