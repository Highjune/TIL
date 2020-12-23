
public class Output {
	
	void output(Student[] array) {
			System.out.println("----입력한 사람들의 성적은~~-----");
			for(int i=0; i<array.length; i++) {
				System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c\n", 
						array[i].getHakbun(), array[i].getName(), array[i].getKor(), array[i].getEng(), array[i].getMat(), array[i].getTot(), array[i].getAvg(), array[i].getGrade());				
			}
	}
}
