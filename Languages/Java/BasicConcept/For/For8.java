


////1부터 값을 계속 더해서 4000이 나올 떄의 바로 그 값은? (언제 끝날지 모를 때 쓴다)
import java.util.Scanner;
public class For8{
	public static void main(String[] args) {
	int start =1, sum = 0;
	for( ; ; ) {
		sum += start;
		if(sum>4000)break;
		start++;
		}
	}
}
	







