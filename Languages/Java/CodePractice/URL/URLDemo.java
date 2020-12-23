//0200204 실습과제
//과제 : 유저에게 URL입력을 받으면 파일의 이름을 추출해서 파일.html 을 만들어서 저장하는 것. 파일의 이름이 host이름이 된다.


//https://youtu.be/R87R5A2qtN0 22분부터
//https://youtu.be/rax0GrAWpBU
//https://youtu.be/r3UdAWt7hkA

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

//네트워크로부터 read(입력), 파일로 write(출력)
//들어오는 것의 끝판왕 : BufferedReader(한줄씩 읽을 수 있어서 편함) / 나가는 것의 끝판왕 : PrintWriter(servlet&jsp에서 printwriter를 쓴다)
//DNS가 네이버의 IP를 알려줄 것임, IP주소에 있는 웹서버 머신의 index.html을 웹서버가 찾아줄 것임. index.html의 빨대로부터 한줄씩 ~

public class URLDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("URL : ");
		String urlStr = scan.next(); // URL은 어차피 공백이 없으니까 next써도 됨, //https://www.naver.com
		URL url = null; 		
//		네트워크로부터 읽어야 됨(READ) - 빨대의 시작. //빨대의 시작이 URL. write는 파일로.
		BufferedReader br = null; //BufferedReader / PrintWriter =>각각 읽고 내보내는 것의 끝판왕
		PrintWriter pw = null;
		String line, path = null; //네이버에서 한줄 읽어받아서 넣는 변수
		int endIndex = urlStr.lastIndexOf("."); //17번째에 있다 https://www.naver.com 의 두번째 .
		String lastDomain = urlStr.substring(endIndex + 1); // com만 나온다, com, edu, gov, org, kr, jp, de, uk, io, cn, ca 중의 하나// 도메인에서 젤 뒤는 국가.
		if(lastDomain.length() == 2 && !lastDomain.equals("io") && !lastDomain.equals("ai") && !lastDomain.equals("me")) {
			// 국가 도메인 kr, jp, de, uk, cn, ca, tv
			// https://www.sist.co.kr 에서 sist부터 뽑아내기.
			int startIndex = urlStr.indexOf("."); //11 (0부터 헤아리기)
			int last = urlStr.indexOf(".", startIndex); //16(두번째 0), .을 찾는데 첫번째 . 이후로 찾아라 => 2번째 .
			path = urlStr.substring(startIndex + 1, last); //sist
		}else {
//			// com, edu, gov, org
			path = urlStr.substring(urlStr.indexOf(".") + 1, endIndex);// naver  처음의 .부터 마지막 .까지 (마지막은 포함x)
		}
		path += ".html";
		try {
			url = new URL(urlStr);
			br = new BufferedReader( //url의 openstream()을 통해서 inputstream을 만들고 bridgeclass(stream을 reader로 변환)인 InputstreamReader에 넣어서 Reader로 만들어서 BufferdReader에 넣음
					new InputStreamReader(url.openStream(), "UTF-8"));  // naver가 utf-8이니까 utf-8로 읽어내기 위해서 charset을 두번째 파라미터로 넣었음.
			pw = new PrintWriter(new BufferedWriter(new FileWriter(path))); //내보내는 것도 버퍼링으로 내보내면 좋으니까 bufferdWriter로 내보냄.
			while((line = br.readLine()) != null) { // 다 읽어올 떄까지! null이면 다 읽은 것이니까 끝.
//				System.out.println(line);
				pw.println(line);
			} 
			System.out.println("Save Success.");
		}catch(MalformedURLException e) {
			System.out.println("URL is invalid."); //프로토콜 빼먹고 naver.com 쓰면 안된다. aaa://naver.com 하면 존재하지 않는 프로토콜이라 또 예외. http://www.naver.com 처럼 제대로 써야 된다.
		}catch(IOException e) {
			System.out.println(e);
		}finally {
			try {
				br.close();
			} catch (IOException e) {}
		}
	}
}
