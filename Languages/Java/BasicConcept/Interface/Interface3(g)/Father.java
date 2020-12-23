//interface는 다중상속이 되므로 Grandfather, Grandmother 둘 다 넣어도 된다.
//6. interface끼리의 상속은 다중상속이 가능하며, extends로 상속받는다.

public interface Father extends GrandFather, GrandMother { //interface인데도 불구하고 동종상속은 extends를 쓴다.
	
	int MONEY = 100_000_00; //앞에 public static final 이 생략되어 있으니 MONEY대문자
	void father();
}




