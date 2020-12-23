class Calc {
	private Employee [] array;
	private int count;
	
	public Calc(Employee [] array, int count){
		this.array = array;
		this.count = count;
	}
	
	void calc(){
		for(int i = 0 ; i < this.count ; i++){
			Employee e = this.array[i];
			int money = Util.getMoney(e.getHo(), e.getGrade());
			int jigup = calcJigup(money, e.getSudang());
			double rate = Util.getRate(jigup);
			int jojung = Util.getJojung(jigup);
			double tax = calcTax(jigup, rate, jojung);
			double salary = calcSalary(jigup, tax);
			e.setJigup(jigup);
			e.setTax(tax);
			e.setSalary(salary);
		}
	}
	
	private int calcJigup(int money, int sudang){
		return money + sudang;
	}
	private double calcTax(int jigup, double rate, int jojung){
		return (jigup * rate) - jojung;
	}
	private double calcSalary(int jigup, double tax){
		return jigup - tax;
	}
}
