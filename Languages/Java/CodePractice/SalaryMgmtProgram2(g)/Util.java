public class Util {
	static int getMoney(int ho, int grade){
		int money = 0;
		switch(ho){
			case 1 : money = (grade == 1) ? 95000 : 80000; break;
			case 2 : money = (grade == 1) ? 92000 : 75000; break;
			case 3 : money = (grade == 1) ? 89000 : 70000; break;
			case 4 : money = (grade == 1) ? 86000 : 65000; break;
			case 5 : money = (grade == 1) ? 83000 : 60000; break;
		}
		return money;
	}
	static double getRate(int jigup){
		double rate = 0.0;
		if(jigup < 70000) rate = 0.0;
		else if(jigup >= 70000 && jigup < 80000) rate = 0.005;
		else if(jigup >= 80000 && jigup < 90000) rate = 0.007;
		else rate = 0.012;
		return rate;
	}
	static int getJojung(int jigup){
		int jojung = 0;
		if(jigup < 70000) jojung = 0;
		else if(jigup >= 70000 && jigup < 80000) jojung = 300;
		else if(jigup >= 80000 && jigup < 90000) jojung = 500;
		else jojung = 1000;
		return jojung;
	}
}
