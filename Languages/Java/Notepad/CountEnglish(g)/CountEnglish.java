package practice;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *   1)입력데이터 : usatoday.txt
     2)출력형식
   A = 9     B = 5   C = 0   D = 2    E = 0
   F = 9     G = 5   H = 0   I = 2     J = 0
   K = 9     L = 5   M = 0   N = 2    O = 0
   P = 9     Q = 5   R = 0   S = 2    T = 0
   U = 9     V = 5   W = 0  X = 2    Y = 0
   Z = 9
   a = 9     b = 5   c = 0    d = 2    e = 0
   ...
   z = 9
   총 글자갯수 : 289개
 * 
 * usatoday.txt 내용
 * As the Senate moves toward pivotal votes on witnesses and the articles of impeachment, Republican senators who decide that Donald Trump's shakedown of Ukraine was sleazy, but not worth removing him from office, still have a problem. They risk angering a president who insists his actions were "perfect" and beyond reproach.

In the face of a such a dilemma, senators were offered an escape hatch this week by Trump lawyer Alan Dershowitz: Don't worry about what Trump did, Dershowitz assured the senators. You can tell your constituents that if the president didn't commit a crime, he can't be impeached and removed from office. 

In other words, it doesn't matter if the president withheld nearly $400 million in congressionally approved military aid from Ukraine for the selfish purpose of acquiring political dirt on former Vice President Joe Biden. Or that Trump stonewalled Congress' investigation.
 *
 */
public class CountEnglish {

	private BufferedInputStream bis;
	
	private CountEnglish() throws IOException {
		String filePath = "C:\\Users\\Ventureport\\Desktop\\usatoday.txt";
		File file = new File(filePath);
		this.bis = new BufferedInputStream(new FileInputStream(file));
	}
	
	@Override
	protected void finalize() {
		if(this.bis != null) {
			try {
				this.bis.close();
			} catch (IOException e) {
				
			}
		}
	}
	
	private void print(int[] array) {
		int count = 0;
		for(int i = 0 ; i < 26 ; i++) {
			System.out.printf("%c = %d\t", (char)(i+65), array[i]);
			count++;
			if(count % 5 ==0 ) {
				System.out.println();
			}
		}
		
		count = 0 ;
		for(int i = 26 ; i<=array.length ; i++) {
			System.out.printf("%c=%d\t", (char)(i+71), array[i]);
			count++;
			if(count%5 ==0) System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		CountEnglish ce = new CountEnglish();
		int[] array = new int[52];
		int number = 0, count = 0;
		while((number=ce.bis.read()) >=0) { // ce.bis.read() 가 알파벳 하나씩 빨아들이는데, number는 A일 경우 65, a일 경우 97
			if(number >=65 && number <=90) { //대문자일 경우
				array[number-65]++;
				count++;
			} else if (number >= 97 && number <= 122) {
				array[number-71]++;
				count++;
			}
		}

		ce.print(array);
		System.out.println("Total point = " + count);
		
		
	}
	
	
}


















