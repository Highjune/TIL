import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//자바의 정석 p915
public class FileDemo {
	public static void main(String[] args) throws IOException{
		//경로(path)에서 사용하는 구분자(separator), windows에서는 \, 리눅스나 맥은 /
//		System.out.println(File.separator);  //  \가 나옴
		//%PATH% or %CLASSPATH%에서 사용하는 구분자(pathSepator)
//		System.out.println(File.pathSeparator); //  ;가 나옴
		System.out.print("읽고 싶은 파일의 경로 : ");
		Scanner scan = new Scanner(System.in);
		String path = scan.nextLine();  //윈도우는 공백이 있을수도 있으니 nextLine으로
		File file = new File(path);
		if(file.exists())	{//user가 입력한 경로(path)에 파일이 있으면 true. 없으면 false
			System.out.println("getPath() = " + file.getPath());
			System.out.println("getName() = " + file.getName());
			System.out.println("getAbsolutePath() = " + file.getAbsolutePath()); // exception이 없지만 진짜 절대경로는 아니다.
			System.out.println("getCanonicalPath() = " + file.getCanonicalPath()); //진짜 절대경로(exception을 던짐)
		}else {
			System.out.println("Not Found");
		}
	}	
}

//실행했을 때 FileDemo.java만 입력하면 안된다. 왜냐하면 현재 있는 폴더위치(ex. 0131) 에 없기 때문에. 그래서 src/FileDemo.java로 들어가야 된다
//absolutepath와 canonicalpath를 다르게 나오게 하려면
//실행 후 경로 : src/../../0131/src/FileDemo.java라고 하면 된다. Canonicalpath는 내가 왔다갔다 한 것은 찍지 않고 말 그대로 절대경로를 찍는다.