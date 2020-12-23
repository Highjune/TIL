//이름을 준 반복문. break할 때 명명된 반복문을 벗어날 수 있다.
public class NamedForPractice {
	public static void main(String[] args) {
		Loop1 : for(int i=2 ; i<=9 ; i++) {
			for(int j=1 ; j<=9 ; j++) {
				if(j==5)
					break Loop1;
				System.out.println(i + "*" + j + "=" + i*j);
			}
			System.out.println();
		}
	}
}
