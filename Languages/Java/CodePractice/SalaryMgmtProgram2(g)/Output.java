class Output {
	private Employee [] array;
	private int count;
	
	public Output(Employee [] array, int count){
		this.array = array;
		this.count = count;
	}
	
	void display(){
		System.out.println("                        <<�޿� ���� ���α׷�>>");
		printDash();
		System.out.println("���       �޼�   ȣ       ����        ���޾�      ����       �������޾�");
		printDash();
		write();
		printDash();
		System.out.println(); System.out.println();
	}
	
	private void write(){  //���õ� ������ ���
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
