
public class Output {
	
	public void output(Student s) {
		this.printlabel();
		
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c\n", 
				s.getHakbun(), s.getName(), s.getKor(), s.getEng(), s.getMat(), s.getTot(), s.getAvg(), s.getGrade());
	}
	
	private void printlabel() {
		System.out.println("----------------------------�㰭�ش��� ����---------------------------------");
		System.out.println("�й�		�̸�		����		����		����		����		���		���");
	}	
}



