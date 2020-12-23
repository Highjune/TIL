
public class Output {
	
	void output(Student s) {
		System.out.println("니가 입력한 " + s.getName() + "의 정보는");
		System.out.println("-----------------------------------");
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c\n",
				s.getHakbun(), s.getName(), s.getKor(), s.getEng(), s.getMat(), s.getTot(), s.getAvg(), s.getGrade());
	}
}
