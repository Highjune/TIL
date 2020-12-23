import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//https://youtu.be/HPZj7gd434E 
//request or response packet에 대해 대단히 중요한 내용(웹 서버의 원리)

public class Apache {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(80); //80번은 http가 사용
		
//		while(true) { //유저로부터 들어온 데이터 보여준 것임. 무한루프 돌고 있는 서브. 여러명을 처리하기 위한 반복이다. 1명만 처리한다고 하면 반복문 필요없다.
//			Socket client = server.accept(); // 클라이언트가 접속하는 순간임. 이 때 클라이언트용 socket을 만들어서 socket이 user가 접속함으로써 보내는 데이터(ip, 포트번호) 저장
//			BufferedReader br = new BufferedReader(
//					new InputStreamReader(client.getInputStream()));
//			String line = null;
//			while((line = br.readLine()) != null) { //user가 서버에 접속할 때 몇 줄의 데이터가 있는지 모르니까 while반복문. 
//				System.out.println(line); 
//			}
//		}  
	
		//여기까지 하고 실행한 후, 브라우저로 localhost:80(내 서버에 요청) 많은 정보들이 들어온다. requestpacket의 header의 첫 줄에 GET / HTTTP/1.1 이 나온다. 기본은 다 GET. 메소드로 POST라고 해야 POST.
		//이것으로 인해, 우리는 naver, daum등에 접속할 때마다 naver, daum같은 서버에 이런 내용들(requestpacket)을 보낸다는 것을 알 수 있다.(제일 중요한 user-agent 포함)
		//requestpacket에는 accept라는 것이 있는데 이것은 브라우저가 받아들일 수 있는(실행할 수 있는) MIME 타입을 말한다. 이것 이외에는 다 다운받겠다는 말.
		//chrome과 firefox 각각 localhost:80 들어올 때는 다 다르다.
		//만약 localhost:80 말고 브라우저에서 localhost/abc/test/index.html 이라고 한다면 header의 첫 줄에 경로(/localhost/abc/test/index.html)가 이렇게 찍힐 것.
		//웹 서버는 이렇게 user가 요청한 경로에 맞는 파일을 내보내줘야 된다. (웹 서버의 원리)
		//라우터 안에 회사의 데이터들이 있으면 파일 서버  / 라우터 밖에 있으면 URL로 연결해야 한다.(웹 서버)
		//header에서 한줄 띄우고부터 body.  
		
		
		while(true) { //내보내기
			Socket client = server.accept();
			
//			BufferedReader br = new BufferedReader(
//					new InputStreamReader(client.getInputStream()));
//			String line = null;
//			while((line = br.readLine()) != null) {
//				System.out.println(line);
//			}
			
			File file = new File("index.html"); //서버입장에서 하드디스크에 있는 index.html을 보여주는 것. 그래서 apache서버 입장에서는 입력은 파일(index.html) 출력은 네트워크
			BufferedReader br = new BufferedReader(new FileReader(file)); //파일로 입력 끝
			PrintWriter pw = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(client.getOutputStream())));
			String line = null;
			while((line = br.readLine()) != null) {
				pw.println(line); // index.html의 내용들을 한줄씩 읽어서 발송.
				pw.flush();
			}
		}
//		server.close();
		
 
	}
}
//여기서 실행한 후 브라우저에서 localhost:80 이라고 치면 index.html의 내용이 나온다.





