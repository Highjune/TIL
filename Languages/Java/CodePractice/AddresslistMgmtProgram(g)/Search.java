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
		if(this.list.size() > 0) {//최소한 1명이라도 명단이 있어야 그 안에서 조건에 맞는 사람을 찾을 수 있으므로 루프 돌면서~ 
			for(int i = 0 ; i < this.list.size() ; i++) {
				if(this.list.get(i).getName().equals(name)) {
					person = this.list.get(i); ///동명이인이 없다는 가정하에.. 이름이 같은 사람을 찾아서 person에 넣고 밑에서 그것을 리턴.
				}
			}
		}
		return person; //못 찾았으면 null이거나 찾은 person
	}
}
