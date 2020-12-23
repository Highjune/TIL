
//		A
//		AB
//		ABC
//		..
//		ABC ..Z

class For7 {
	public static void main(String[] args) {
		for(int i=1; i<=26 ; i++) {
		for(int j = 1; j<= i; j++) {
			System.out.printf("%c\t",(j+64));
		}
		System.out.println();
	}		
}
}