//�빮�� A���� Z���� ����ϱ�2
class For4 {
	public static void main(String[] args) {
		int count = 0;
		for(int i=65 ; i<=90 ; i++) {    
				System.out.printf("%c\t" ,i); 
				count++;
				if(count%5 ==0) System.out.println();
		}
	}
}