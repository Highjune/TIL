public class Patient {
	private int bunho;
	private String code;  //�����ڵ�
	private int day;  //�Կ��ϼ�
	private int age;    //����
	private String department;   //�����μ�
	private int jinchalBi;     //������
	private int ipwonBi;     //�Կ���
	private int jinryoBi;    //�����

	public Patient(int bunho, String code, int day, int age) {
		this.bunho = bunho;  this.code = code;
		this.day = day;    this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getJinchalBi() {
		return jinchalBi;
	}
	public void setJinchalBi(int jinchalBi) {
		this.jinchalBi = jinchalBi;
	}
	public int getIpwonBi() {
		return ipwonBi;
	}
	public void setIpwonBi(int ipwonBi) {
		this.ipwonBi = ipwonBi;
	}
	public int getJinryoBi() {
		return jinryoBi;
	}
	public void setJinryoBi(int jinryoBi) {
		this.jinryoBi = jinryoBi;
	}
	public int getBunho() {
		return bunho;
	}
	public String getCode() {
		return code;
	}
	public int getDay() {
		return day;
	}
	public int getAge() {
		return age;
	}
}
