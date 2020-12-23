

public class Output {
	private Student[] array;
	
	public Output(Student[] array) {
		this.array = array;		
	}
	
	public void output() {
		printlabel();
		
		for(int i =0 ; i<array.length ; i++) {
			System.out.println("니가 입력한" + (i+1) + "번쨰 학생의 정보");
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c\t\n",
					array[i].getHakbun(), array[i].getName(), array[i].getKor(), array[i].getEng(), array[i].getMat(), array[i].getTot(), array[i].getAvg(), array[i].getGarde());	
		}
		
	}	
	private void printlabel() {
		System.out.println("----------------------------------------------------");
		System.out.println("-----------------성적관리프로젝트4-------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("stucode	name	kor	eng	mat	tot	avg	grade");	
		
	}
	
	
}
