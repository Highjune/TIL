import java.util.ArrayList;

public class Output {
	private ArrayList<Member> list;

	public Output(ArrayList<Member> list) {
		this.list = list;
	}
	
	public void output() {
		//printLabel();
		for(Member member : this.list) {
			System.out.println(member);  //sal.toString()
		}
	}
	private void printLabel() {}
}
