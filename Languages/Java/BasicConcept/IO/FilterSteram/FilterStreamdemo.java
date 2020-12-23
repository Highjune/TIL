import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
//자바의 정석 886
//https://youtu.be/4oquHeKqdlk 9분부터 
//DataInputStream, DataOutputStream
//8가지 기본 자료형의 단위로 읽고 쓸 수 있다는 장점!
//즉 숫자는 숫자 그대로 넣고 빼올 수 있다.
//프로젝트 폴더에 new file로 data.dat 생성하고 시작(src폴더에 말고)
//byte기반만 된다. char기반은 안된다. 

public class FilterStreamdemo {
	public static void main(String[] args) throws IOException {
		//data.dat파일로 내보내기
//		DataOutputStream dos = 
//				new DataOutputStream(new FileOutputStream("data.dat")); //이렇게 하면 close()한번만 써도 된다.	
//		dos.writeInt(90);
//		dos.writeDouble(89.5);
//		dos.writeBoolean(true);
//		dos.writeChar(65);
//		dos.writeUTF("Hello");
//		dos.writeUTF("안녕하세요");
//		System.out.println("Save Success");
//		dos.close();

		DataInputStream dis =
				new DataInputStream(new FileInputStream("data.dat"));
//		System.out.printf("%b", dis.readBoolean()); //제일 위에 정수부터 저장했기 때문에 Boolean으로 읽으면 안된다. 

		System.out.printf("%d\n", dis.readInt()); //제일 처음에 90을 저장했기 때문에
		System.out.printf("%.1f\n", dis.readDouble()); //제일 처음에 90을 저장했기 때문에
		System.out.printf("%b\n", dis.readBoolean()); //제일 처음에 90을 저장했기 때문에
		System.out.printf("%c\n", dis.readChar()); //제일 처음에 90을 저장했기 때문에
		System.out.printf("%s\n", dis.readUTF()); //제일 처음에 90을 저장했기 때문에
		System.out.printf("%s\n", dis.readUTF()); //제일 처음에 90을 저장했기 때문에
		
		dis.close();
		
	}
}
