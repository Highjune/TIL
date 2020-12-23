import java.util.ArrayList;
import java.util.Scanner;

public class Search {
	private ArrayList<Person> list;
	private Scanner scan;
	
	public Search(ArrayList<Person> list, Scanner scan) {
		this.list = list;
		this.scan = scan;
	}
	public Person search() {
		Person person = null;
		System.out.print("찾으려는 회원의 이름 : ");
		String name = this.scan.nextLine();
		if(this.list.size() > 0) {
			for(int i = 0 ; i < this.list.size() ; i++) {
				if(this.list.get(i).getName().equals(name)) {
					person = this.list.get(i);
				}
			}
		}
		return person;
	}
}
