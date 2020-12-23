package practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//1~50 사이의 랜덤 숫자 중 25개 골라서 5x5 크기의 빙고판 만드는 것. 
//중복되면 안되니까 set으로


public class Bingo5by5 {
	public static void main(String[] args) {
		Set set = new HashSet();
		
		int[][] bingoBoard = new int[5][5];
		
		for(int i = 0 ; set.size() < 25 ; i++) {  // 조건문을 i < 50 으로 하면 set에 25개가 들어가지 않는다. set은 중복값을 받지 않으므로.
			set.add((int)(Math.random()*50) + 1);
//			set.add((int)(Math.random()*50) + 1 + "");
		}
		
		Iterator it = set.iterator();
		
		for(int i =0 ; i<bingoBoard.length; i++) {
			for(int j=0 ; j<bingoBoard[i].length; j++) {
				bingoBoard[i][j] = (int)it.next();
//				bingoBoard[i][j] = Integer.parseInt((String)it.next());
				System.out.print((bingoBoard[i][j] < 10 ? "  " : " ") + bingoBoard[i][j]);
			}
			System.out.println();
		}
	}
}


