package practice;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class GetLineStringFromKeyBoard {
	public static void main(String[] args) throws Exception {
		//Actually, this process under should be replaced by "Scanner". beacuse it is convenient way better than this. 
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);
		
		while(true) {
			System.out.println("입력하세요.: ");
			String lineStr = br.readLine();
			if(lineStr.equals("q") || lineStr.equals("quit")) { // or
				break;
			}
			System.out.println("입력된 내용 : " + lineStr);
			System.out.println();
		}
		br.close();
		
	}
}


