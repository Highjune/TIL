import java.util.*;

//1~50������ ���� �߿��� 25���� ��� 5X5ũ���� ������ ����� ��
//�ڹ��� ���� P633

public class Bingo {
	public static void main(String[] args) {	
		Set set = new HashSet();
		int[][] board = new int[5][5];
		
		for(int i = 0 ; set.size() <25; i++) {
			set.add((int)(Math.random()*50)+1+""); //���ڷ� ���� ����
		}
		
		Iterator it = set.iterator();
		
		for(int i = 0 ; i<board.length; i++) {		//������ �迭�� �ʱ�ȭ. �ڹ��� ���� p216 ����
			for(int j=0 ; j<board[i].length; j++) {
				board[i][j] = Integer.parseInt((String)it.next());
				System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
			}
			System.out.println();
		}
		
		
	}
}
