import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//Product클래스와 함께
//직렬화와 역직렬화
public class SerializationDemo{
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		ArrayList<Product> list = new ArrayList<Product> (); 
		//제품들을 배열에 담지 않고 connection에 담는 이유는 몇갠지 모르니까~
		//connection 뺐다가 넣고 다 할 수 잇으니까. 배열은 정해진 것만 가능.
		Product ballpen = new Product("모나미볼펜", 300); 	list.add(ballpen);
		Product keyboard = new Product("키보드", 15000);	list.add(keyboard);
		//이렇게 담은 arraylist를 직렬화!
		
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("C:/temp/list.ser"));  //직렬화한 것을 DB에 보내도 되지만 아직 안 배웟으니 File로 내보내는 것!
		oos.writeObject(list); //직렬화. Product의 멤버들은 다 되는데, Product도 하게 하려면 product가 implementS serializable
		//그리고 그 product를 담고 있는 ArrayList도 직렬화 가능한가? Arraylist API보면 serializable구현했다고 되어잇음.
		System.out.println("Save Success.");
		oos.close(); //이것만 담으면FileOutputStream도 닫힌다. 이렇게 겹쳐서 쓰면 하나만 닫아도 됨.
//==>이렇게 하면 list.ser들어가보면 (알아볼수없는 글씨이긴 하지만) Arraylist안에 ballpen, keyboard가 들어있는 채로 ~
		//이렇게 직렬화를 쓰지 않게 되면, 학생 12명 저장하려고 하면 12개의 레코드를 다 만들고, 학번, 이름, 국어, 영어 , 수학 등의 컬럼 다 있어야 되는데
		//직렬화를 쓰게 되면 1개의 컬럼이면 된다.
			
		//역직렬화(위에서 직렬화 한 것)
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("C:/temp/list.ser")); 
		Object obj = ois.readObject();  //readObject가 ClassNotFoundException 발생
		ArrayList<Product> list1 = (ArrayList<Product>)obj; //obj를 강제형변환해서 꺼냄.
		for(Product p : list1) {
			System.out.println(p);
		}
		ois.close();
	}
}



