public class Output {
	private Patient [] array;
	private int count;

	public Output(Patient [] array, int count){
		this.array = array;
		this.count = count;
	}

	public void output(){
		this.printTitle();
		this.printDash();
		this.printLabel();
		this.printDash();
		for(int i = 0 ; i < this.count ; i++){
			System.out.printf("%2d\t%-10s\t%,8d\t%,10d\t%,10d\n",
					this.array[i].getBunho(), this.array[i].getDepartment(),
					this.array[i].getJinchalBi(), this.array[i].getIpwonBi(), 
					this.array[i].getJinryoBi());
		}
		this.printDash();
	}
	private void printDash(){
		for(int i = 0 ; i < 70 ; i++){
			System.out.print("-");
		}
		System.out.println();
	}
	private void printTitle(){
		System.out.println("            <<병원관리프로그램>>");
	}
	private void printLabel(){
		System.out.println("번호     진찰부서         진찰비         입원비         진료비");
	}
}
