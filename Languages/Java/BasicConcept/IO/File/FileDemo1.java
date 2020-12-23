import java.io.File;
import java.text.SimpleDateFormat; //printf가 나오기 전에는 다 여기서 처리.
import java.util.Date;

//탐색기 만들기(cmd창에서 dir 명령어 입력시 출력되는 형태를 반환하기 위해)
public class FileDemo1 {
	public static void main(String[] args) {
//		String path = "src/FileDemo.java";
//		File file = new File(path);
//		long last = file.lastModified(); //마지막으로 file이 수정된 시간. long형태로 나온다.(epoch타임) 자바는 쓰는 시간은 다 long형이다. (unix만든 시간) 1970년 1월 1일 0시 0분 0초 기준으로. miliseconds단위로. 
//		System.out.println(new Date(last)); // 황당한 long 타입 시간을 이 생성자에 넣으면 우리가 원하는 시간 나온다.
		
//		String pattern = "지금은 yyyy년 MM월 dd일 aa hh시 mm분 ss초입니다."; //원하는 형식 적으면 된다.
//		SimpleDateFormat sdf = new SimpleDateFormat();
//		System.out.println(sdf.format(new Date()));
		
		//C드라이브의 목록 들고오기(cmd창에서 dir 쳤을 때 나오는 형식, 목록과 같이)
		String path = "C:/"; //c드라이브에 있는 것들(파일, 디렉토리)을 cmd의 dir쳤을 때 나오는 형식으로.
		File fileObj = new File(path); 
		File [] array = fileObj.listFiles(); //string으로 list를 들고오면 중간에 <DIR>을 파일인지 디렉토리인지 함수로 확인따로 못하니 File 배열로 들고옴
		for(File f : array) {
			long last = f.lastModified(); //마지막 수정시간.
			String pattern = "yyyy-MM-dd\taa hh:mm"; //2020-03-06  오전 03:56 형식
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			System.out.print(sdf.format(new Date(last)));
			if(f.isDirectory()) System.out.print("<DIR>\t\t");  //디렉토리면 DIR을 찍고, 
			else if(f.isFile())	System.out.printf("%,d\t", f.length()); //디렉토리 아니고 파일이면 파일의 사이즈를 찍는다.
			System.out.println(f.getName());
		}
	} 
} 

