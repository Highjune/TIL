//기본적으로 일단 변수선정, 생성자 생성, getset생성, tostring까지


public class Friend {
	private String name;
	private String tel;
	private String relation;
	public Friend(String name, String tel, String relation) {
		this.name = name;
		this.tel = tel;
		this.relation = relation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	@Override
	public String toString() {
		return "Friend [name=" + name + ", tel=" + tel + ", relation=" + relation + "]";
	}
}