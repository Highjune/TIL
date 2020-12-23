//7. interface는 다중상속이 가능하며, 각 interface는 comma로 구별한다.
//8. interface형 참조변수는 해당 interface의 메소드에만 접근할 수 있다.
//9. interface의 상수는 static이기 때문에 interface이름으로 접근해서 이름 충돌이 발생하지 않는다.(이름으로 접근하면 각각 아버지의 MONEY인지 어머니의 MONEY인지 구분이 되기 때문에)
//10. interface형으로 배열을 만들 수 있는데, 이는 interface형의 자식객체를 저장하기 위한 배열이다.

//다중상속의 단점은, 제일 밑에서 위의 모든 (할배, 할매, 엄, 빠) 들의 method를 다 재정의 해줘야 된다.

public class InterfaceDemo1 implements Father, Mother{
//	public void father() {}
//	public void mother() {}
//	public void grandFather() {}
//	public void grandMother() {}	  이렇게 4개를 다 재정의해줘야 에러 안 뜬다.
//밑에서부터 다시 하나하나씩 살 붙여서 재정의 해주자
	public void father() {System.out.println("called by father()");}
	public void mother() {System.out.println("called by mother()");}
	public void grandFather() {System.out.println("called by grandFather()");}
	public void grandMother() {System.out.println("called by grandMother()");}
	public static void main(String[] args) {
	
		GrandFather grandFather = new InterfaceDemo1();
		grandFather.grandFather();   //grandFather. 로서는 grandFather()에만 접근할 수 있다. 왜냐하면 interfaceDemo1에서만 자신(grandFather)를 재정의 했기 때문에
		GrandMother grandMother = new InterfaceDemo1();
		grandMother.grandMother(); //grandMother. 로서는 grandMother()에만 접근할 수 있다. 왜냐하면 interfaceDemo1에서만 자신(grandMother)를 재정의 했기 때문에
		Father father = new InterfaceDemo1();
		father.father(); father.grandFather(); father.grandMother(); //아빠는 자신것도(자식이 재정의 해줬으니까), 할아버지, 할머니도 접근가능하다(왜냐하면 상속이니까)
		Mother mother = new InterfaceDemo1();
		mother.mother(); //엄마는 자신것(적어도 자신은 자식이 재정의해줬으니까) 밖에 안됨. 할아버지 할머니것은 접근 못한다. 왜냐하면 상속이 아니기 때문에.

		System.out.println("아버지의 돈 = " + Father.MONEY); //money는 static이므로 꼭 주소로 접속할 필요없다. 이름(Father)로 접근
		System.out.println("어머니의 돈 = " + Mother.MONEY); //money는 static이므로 꼭 주소로 접속할 필요없다. 이름(Mother)로 접근
		
		Mother[] array = new Mother[3]; //Mother는 new 못 쓰는데?? 하지만 Mother을 만든 것이 아니라 mother의 자식들이 들어올 배열! 을 만든 것이므로 만들 수 있다.
		array[0] = new InterfaceDemo1(); //여기에는 아빠, 할아버지, 할머니 못 넣는다. mother의 자녀인 interfacedemo만 넣을 수 있다.
		array[0].mother();  
	}
	
	}






		


