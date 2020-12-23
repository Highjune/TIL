public class Calc {
	private Patient [] array;
	private int count;

	public Calc(Patient [] array, int count){
		this.array = array;
		this.count = count;
	}

	public void calc(){
		for(int i = 0 ; i < this.count ; i++){
			//�����μ�
			String department = this.getDepartment(this.array[i].getCode());
			this.array[i].setDepartment(department);
			//������
			int fee = this.getJinchalBi(this.array[i].getAge());
			this.array[i].setJinchalBi(fee);
			//�Կ���
			int day = this.array[i].getDay();  //�Կ��ϼ�
			int chongIpwonBi = this.getIpwonBiPerDay(day) * day; //���Կ���
			double rate = this.getRate(day);   //�Կ��ϼ���� ���κ���
			int ipwonBi = (int)(chongIpwonBi * rate);  //�Կ���
			this.array[i].setIpwonBi(ipwonBi);
			//�����
			int jinryoBi = fee + ipwonBi;  //�����
			this.array[i].setJinryoBi(jinryoBi);
		}
	}
	private int getIpwonBiPerDay(int day){ //�Ϸ��Կ���
		if(day > 3) return 25000;
		else return 30000;
	}
	private String getDepartment(String code){ //�����μ� �˾ƿ���
		String department = null;
		switch(code){
			case "MI": department = "�ܰ�"; break;
			case "NI": department = "����"; break;
			case "SI": department = "�Ǻΰ�"; break;
			case "TI": department = "�Ҿư�"; break;
			case "VI": department = "����ΰ�"; break;
			case "WI": department = "�񴢱��"; break;
		}
		return department;
	} 
	private int getJinchalBi(int age){  //������ �˾ƿ���
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
	private double getRate(int day){   //�Կ��ϼ���� ���κ��� �˾ƿ���
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
