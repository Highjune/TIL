import java.util.TreeSet;

//자바의 정석 p643
//TreeSet의 headSet과 tailSet을 이용해서 TreeSet에 저장된 객체 중 지정된 기준 값보다 큰 값의 객체들과 작은 값의 객체들을 얻을 수 있다.
public class TreeSetEx2 {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		int[] score = {80, 95, 50, 35, 45, 65, 10, 100};
		
		for(int i = 0 ; i<score.length; i++)
			set.add(new Integer(score[i]));
	
		System.out.println("50보다 작은 값 :" + set.headSet(new Integer(50)));
		System.out.println("50보다 큰 값 :" + set.tailSet(new Integer(50)));
		

	}
}
