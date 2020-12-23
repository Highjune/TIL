//OverrideDemo1 과 관련

public class Point {
	
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x; this.y = y;	
	}
	
	@Override
	public String toString() {
		return "(x, y) = (" + this.x + "," + this.y + ")";
	}
	@Override // sun microsoft 가 만든 객체를 재정의 하는 것임. 원래것과 이름, 리턴타입, 파라미터만 같으면 바꿀 수 있음
	
	public boolean equals(Object obj) {
		Point child = (Point)obj;
		if(this.x == child.x && this.y == child.y)
			return true;
		else return false;
	}
	
}
