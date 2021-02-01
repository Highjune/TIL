package test;

// fibonacci
// sum until 50
public class test {
	public static void main(String[] args) {
		int n = 0;
		int a = 0;
		int b = 1;
		while(a<=50) {
			System.out.println(a);
			a += b;
			b = a;			
		}
	}
}
