package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectStreamExample {
	public static void main(String[] args) throws Exception {
		// save List file
		writeList();
		// read List stored in file
		List<Board> list = readList();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// print List content to Monitor
		for(Board board : list) {
			System.out.println(
				board.getBno() + "\t" + board.getTitle() + "\t" +
				board.getContent() + "\t" + board.getWriter() + "\t" +
				sdf.format(board.getDate())					
			);
		}
	}
	
	public static void writeList() throws Exception {
		List<Board> list = new ArrayList<>();
		//list에 Board 저장
		list.add(new Board(1, "제목1", "내용1", "글쓴이1", new Date()));
		list.add(new Board(2, "제목2", "내용2", "글쓴이2", new Date()));
		list.add(new Board(3, "제목3", "내용3", "글쓴이3", new Date()));
		
		// print list By using ObjectPrintStream
		FileOutputStream fos = new FileOutputStream("D:/temp/board.db");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.flush();
		oos.close();
	}
	
	// read list by using ObjectInputStream
	public static List<Board> readList() throws Exception {
		FileInputStream fis = new FileInputStream("D:/temp/board.db");
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<Board> list = (List<Board>) ois.readObject();
		return list;
	}
}







