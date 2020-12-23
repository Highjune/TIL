//모든 변수는 private. 정보를 갖고 있으니까. 그럼항상 get set을 만들어야 됨.


public class Dept {
	private int deptno;
	private String dName;
	private String loc;
	public Dept(int deptNo, String dName, String loc) {
		this.deptno = deptNo;
		this.dName = dName;
		this.loc=loc;
		
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dName=" + dName + ", loc=" + loc + "]";
	}

}











