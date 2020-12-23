
public class Output {
	public Student[] array;
	
	Output(Student[] array){
		this.array = array;
	}
	
	void output(Student[] array) {
		System.out.println("니가 입력한 애들의 성적을 총점 순(버블 정렬)으로 정리하자면~~");
			for(int i =0 ; i < array.length ; i++) {
			System.out.println("<" + (i+1) + "번쨰 학생의 정보" + ">");
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c\n", 
					array[i].getHakbun(), array[i].getName(), array[i].getKor(), array[i].getEng(), array[i].getMat(), array[i].getTot(), array[i].getAvg(), array[i].getGrade());
		}
	}
}
