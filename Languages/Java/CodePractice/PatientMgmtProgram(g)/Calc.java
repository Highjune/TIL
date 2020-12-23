public class Calc {
	private Patient [] array;
	private int count;

	public Calc(Patient [] array, int count){
		this.array = array;
		this.count = count;
	}

	public void calc(){
		for(int i = 0 ; i < this.count ; i++){
			//진찰부서
			String department = this.getDepartment(this.array[i].getCode());
			this.array[i].setDepartment(department);
			//진찰비
			int fee = this.getJinchalBi(this.array[i].getAge());
			this.array[i].setJinchalBi(fee);
			//입원비
			int day = this.array[i].getDay();  //입원일수
			int chongIpwonBi = this.getIpwonBiPerDay(day) * day; //총입원비
			double rate = this.getRate(day);   //입원일수대비 할인비율
			int ipwonBi = (int)(chongIpwonBi * rate);  //입원비
			this.array[i].setIpwonBi(ipwonBi);
			//진료비
			int jinryoBi = fee + ipwonBi;  //진료비
			this.array[i].setJinryoBi(jinryoBi);
		}
	}
	private int getIpwonBiPerDay(int day){ //하루입원비
		if(day > 3) return 25000;
		else return 30000;
	}
	private String getDepartment(String code){ //진찰부서 알아오기
		String department = null;
		switch(code){
			case "MI": department = "외과"; break;
			case "NI": department = "내과"; break;
			case "SI": department = "피부과"; break;
			case "TI": department = "소아과"; break;
			case "VI": department = "산부인과"; break;
			case "WI": department = "비뇨기과"; break;
		}
		return department;
	} 
	private int getJinchalBi(int age){  //진찰비 알아오기
		int fee = 0;
		switch(age / 10){
			case 0 : fee = 7000; break;
			case 1 : fee = 5000; break;
			case 2 : fee = 8000; break;
			case 3 : fee = 7000; break;
			case 4 : fee = 4500; break;
			default : fee = 2300; 
		}
		return fee;
	}  
	private double getRate(int day){   //입원일수대비 할인비율 알아오기
		double rate = 0.0;
		if(day < 10) rate = 1.0;
		else if(day >= 10 && day < 15) rate = 0.85;
		else if(day >= 15 && day < 20) rate = 0.80;
		else if(day >= 20 && day < 30) rate = 0.77;
		else if(day >= 30 && day < 100) rate = 0.72;
		else if(day >= 100) rate = 0.68;
		return rate;
	}
}
