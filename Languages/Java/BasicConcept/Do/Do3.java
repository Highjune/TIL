//do ~ while을 이용한 구구단
public class Do4 {
	public static void main(String[] args) {
		int i = 1;
		
		do {
			int j=2;
				do {
					System.out.printf("%dx%d = %d\t", j, i, j*i);
					j++;
				}while(j<10);
				System.out.println();
				i++;
		}while(i<10);
	}	
}