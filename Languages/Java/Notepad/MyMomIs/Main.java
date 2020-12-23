
public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		Family fff = m.input();
		m.calc(fff);
		m.output(fff);		
	}
	 
	Family input() {
		Family m = new Family();
		m.position = "mother";
		m.name = "김땡땡";
		m.age = 63;
		m.cleaning = 99;
		m.raising = 99;
		m.love = 99;
		m.effort = 99;
		return m;
	}
	
	void calc(Family f) {
		f.tot = f.cleaning + f.raising + f.love + f.effort;
		f.avg = (f.tot) / f.age ;
		f.grade = (f.avg >= 90) ? "사랑하는 우리엄마" : 
						(f.avg >= 80) ? "완벽한 우리엄마" :
							(f.avg >= 70) ? "다음생에도 우리엄마" :
								(f.avg >= 60) ? "행복하게해줄게요" : "사랑하는우리엄마";			
//		System.out.println(f.grade);
	}
	
	void output(Family f) {
		System.out.println("우리 엄마는요~~");
		System.out.printf("위치	이름	나이 	청소실력	양육실력	사랑	노력	총점	등급");
		System.out.println("-----------------------------------------------------------");
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%d\t%d\t%s", 
			f.position, f.name, f.age, f.cleaning, f.raising, f.love, f.effort, f.tot, f.grade);
	}		
}
