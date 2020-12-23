

///데이터베이스에 불연속적인 범위에 있는 값을 임의로 얻어와서 넣어야 하는 경우	
	
class InsertTable {
	final static int RECORD_NUM = 10; //생성할 레코드의 수 정함
	final static String TABLE_NAME = "TEST_TABLE";
	final static String[] CODE1 = {"010", "011", "017", "018", "019"};
	final static String[] CODE2 = {"남자", "여자"};
	final static String[] CODE3 = {"10대", "20대", "30대", "40대", "50대"};
	
	public static void main(String[] args) {
		for(int i=0; i<RECORD_NUM; i++) {
			System.out.println(" INSERT INTO "+TABLE_NAME
				+ " VALUES ("
				+ " '" + getRandArr(CODE1) + "'"
				+ ", '" + getRandArr(CODE2) + "'"
				+ ", '" + getRandArr(CODE3) + "'"
				+ ",  " + getRand(100, 200) // 100~200사이의 값
				+ "); ") ;
	
	}
	}
	
	public static String getRandArr(String[] arr) {
		return arr[getRand(arr.length-1)];
	}
	

	public static int getRand(int n) {	return getRand(0, n); }
	public static int getRand(int from, int to) {
		return (int)(Math.random() * (Math.abs(from-to)+1)) + Math.min(from, to);
	}
}
	
	
//INSERT INTO TEST_TABLE VALUES (~~~~~~~랜덤~~)" 으로 나옴.




