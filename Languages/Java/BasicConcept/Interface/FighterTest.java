abstract class unit{
	int x, y;
	abstract void move(int x, int y);
	void stop () {System.out.println("멈춥니다.");}
}

interface Fightable {//인터페이스의 모든 메서드는 public abstract. 예외없이 
	void move(int x, int y); //public abstract가 생략됨
	void attack(Fightable f); //public abstract가 생략됨
}

class Fighter extends unit implements Fightable {
	//밑의 메서드에 public붙이지 않으면 에러. 오버라이딩 규칙 : 조상(public)보다 접근제어자가 범위가 좁으면 안된다.
	public void move(int x, int y) {
		System.out.println("[" + x + "," + y + "]로 이동");
	} 
	public void attack(Fightable f) {
		System.out.println(f + "를 공격");
	}	
	
	Fightable getFightable() {
		Fighter f = new Fighter();
		return f; //(Fighter)f; 임. (Fighter)가 생략
	}
	
//	Fightable getFightable() {  //위에서 Fighter f 로 만들어서 return을 (Fighter)f; 로 한 것과 동일하게 애초에 Fightable f 로 만들어서 return f;로 하는 것과 똑같다.
//		Fightable f = new Fighter(); //Fightable f = (Fightable)new Fighter(); 와 동일. 자동 형변환 된 것임.
//		return f; 
//	}
	
}

public class FighterTest {
	public static void main(String[] args) {
		Fighter f = new Fighter(); 
		f.move(100, 200); 		
		Fighter f2 = new Fighter();
		f.attack(f2);
//		f.attack(new Fighter()); //위의 2줄과 같은 의미
		
		//Fightable에 있는 move, attack만 호출가능하다. 그래서 ft.stop()은 안됨.
		Fightable ft = new Fighter();
		ft.move(100, 200);
		ft.attack(ft);  //Q)어떻게 가능?
//		ft.stop();		//에러
		
		//Unit에 있는 move. stop만 호출가능. 그래서 u.attack()은 불가능
		unit u = new Fighter();
		u.move(100, 200);
//		u.attack(new Fighter()); //에러
		u.stop();
	}
}

