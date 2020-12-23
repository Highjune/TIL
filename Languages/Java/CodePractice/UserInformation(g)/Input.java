import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Input {
	private ArrayList<Member> list;
	private Scanner scan;
	
	public Input(ArrayList<Member> list) {
		this.list = list;
		this.scan = new Scanner(System.in);
	}
	
	public void input() { 
		System.out.print("Name : ");    String name = this.scan.nextLine();
		System.out.print("Address : ");    String address = this.scan.nextLine();
		System.out.print("Birthday(yyyy-mm-dd) : ");      String birthday = this.scan.nextLine();
		Scanner scan1 = new Scanner(birthday).useDelimiter("-");
		int year = scan1.nextInt();  //1995
		int month = scan1.nextInt();  //6
		int date = scan1.nextInt();  //12
		Calendar birthDay = Calendar.getInstance();
		birthDay.set(year, month, date);
		System.out.print("Age : ");    int age = this.scan.nextInt();
		System.out.print("Gender (³²/¿©) : ");       String gender = this.scan.next();
		Member member = new Member(name, address, birthDay, age, gender);
		this.list.add(member);
	}
}
