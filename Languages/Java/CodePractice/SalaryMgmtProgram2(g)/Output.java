class Output {
	private Employee [] array;
	private int count;
	
	public Output(Employee [] array, int count){
		this.array = array;
		this.count = count;
	}
	
	void display(){
		System.out.println("                        <<급여 관리 프로그램>>");
		printDash();
		System.out.println("사번       급수   호       수당        지급액      세금       차인지급액");
		printDash();
		write();
		printDash();
		System.out.println(); System.out.println();
	}
	
	private void write(){  //소팅된 데이터 출력
		for(int i = 0 ; i < this.count ; i++){
			Employee e = this.array[i];
			System.out.printf("%3d%7d%5d%,10d%,10d%,7.0f%,12.0f\n",
					e.getSabun(), e.getGrade(), e.getHo(),
					e.getSudang(), e.getJigup(), e.getTax(), e.getSalary());
		}
	}
	private void printDash(){
		for(int i = 0 ; i < 55 ; i++) System.out.print("-");
		System.out.println();
	}
}
