package com.gym.vo;


import java.sql.Date;


public class GymVO {
	private int num, age, chul, tchul,serial;
	private double height, cweight,weight, goal, bmi, chulrate,reduce,cha, rankchul;
	public double getRankchul() {
		return rankchul;
	}
	public void setRankchul(double rankchul) {
		this.rankchul = rankchul;
	}

	private String name, gender, phone, rate, chul2,checkday,period,gigan,startd2,endd2,gap; //chul2?? user_ranktchul_sp ?????? alias
	//checkday,period,gigan =>      //startd2,endd2=>관리자 성별 조회시             //gap 유저출석률순위조회시 등록기간
	private Date startd, endd;
	
	public String getGap() {
		return gap;
	}
	public void setGap(String gap) {
		this.gap = gap;
	}
	public GymVO(){};
	public GymVO(int num,String name, String gender, int age, String phone, double height, double weight, Date startd, Date endd, double goal) {
		this.num=num;
		this.name = name;
		this.gender = gender;
		this.age=age;
		this.phone=phone;
		this.height=height; 
		this.weight=weight;
		this.startd=startd;
		this.endd=endd; 
		this.goal=goal;
		
	}
	
	public GymVO(int num, int age, int chul, int tchul, double height, double cweight, double weight, double goal,
			double bmi, double chulrate, double reduce, double cha, String name, String gender, String phone,
			String rate, String chul2, String checkday, String period, String gigan, String startd2, String endd2,
			Date startd, Date endd,String gap) {
		this.num = num;
		this.age = age;
		this.chul = chul;
		this.tchul = tchul;
		this.height = height;
		this.cweight = cweight;
		this.weight = weight;
		this.goal = goal;
		this.bmi = bmi;
		this.chulrate = chulrate;
		this.reduce = reduce;
		this.cha = cha;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.rate = rate;
		this.chul2 = chul2;
		this.checkday = checkday;
		this.period = period;
		this.gigan = gigan;
		this.startd2 = startd2;
		this.endd2 = endd2;
		this.startd = startd;
		this.endd = endd;
		this.gap=gap;
	}

	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getChul() {
		return chul;
	}

	public void setChul(int chul) {
		this.chul = chul;
	}

	public int getTchul() {
		return tchul;
	}

	public void setTchul(int tchul) {
		this.tchul = tchul;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getCweight() {
		return cweight;
	}

	public void setCweight(double cweight) {
		this.cweight = cweight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getGoal() {
		return goal;
	}

	public void setGoal(double goal) {
		this.goal = goal;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public double getChulrate() {
		return chulrate;
	}

	public void setChulrate(double chulrate) {
		this.chulrate = chulrate;
	}

	public double getReduce() {
		return reduce;
	}

	public void setReduce(double reduce) {
		this.reduce = reduce;
	}

	public double getCha() {
		return cha;
	}

	public void setCha(double cha) {
		this.cha = cha;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getChul2() {
		return chul2;
	}

	public void setChul2(String chul2) {
		this.chul2 = chul2;
	}

	public String getCheckday() {
		return checkday;
	}

	public void setCheckday(String checkday) {
		this.checkday = checkday;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getGigan() {
		return gigan;
	}

	public void setGigan(String gigan) {
		this.gigan = gigan;
	}

	public String getStartd2() {
		return startd2;
	}

	public void setStartd2(String startd2) {
		this.startd2 = startd2;
	}

	public String getEndd2() {
		return endd2;
	}

	public void setEndd2(String endd2) {
		this.endd2 = endd2;
	}

	public Date getStartd() {
		return startd;
	}

	public void setStartd(Date startd) {
		this.startd = startd;
	}

	public Date getEndd() {
		return endd;
	}

	public void setEndd(Date endd) {
		this.endd = endd;
	}

	@Override
	public String toString() {
		return "GymVO [num=" + num + ", age=" + age + ", chul=" + chul + ", tchul=" + tchul + ", height=" + height
				+ ", cweight=" + cweight + ", weight=" + weight + ", goal=" + goal + ", bmi=" + bmi + ", chulrate="
				+ chulrate + ", reduce=" + reduce + ", cha=" + cha + ", name=" + name + ", gender=" + gender
				+ ", phone=" + phone + ", rate=" + rate + ", chul2=" + chul2 + ", checkday=" + checkday + ", period="
				+ period + ", gigan=" + gigan + ", startd2=" + startd2 + ", endd2=" + endd2 + ", startd=" + startd
				+ ", endd=" + endd + "]";
	}
	
	
	
	
	
}


