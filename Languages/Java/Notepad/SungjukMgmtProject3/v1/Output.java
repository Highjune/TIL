
public class Output {
	
	public Student output(Student s) {
		System.out.println("입력한 사람의 성적~~");
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%c",
				s.hakbun, s.name, s.kor, s.eng, s.mat, s.tot, s.avg, s.grade);
		return s;
	}
}
