
//x�� 1���� 3�� �����ϰ�, y�� 100���� 2�� �����Ѵ�. x�� y�� ������ ���� x, y�� ����?

class For6{
	public static void main(String[] args) {
		int x, y;
		for(x=1, y=100; y>0; x+=3, y-=2) {
			if(x>y) break;
		}
		System.out.printf("x=%d, y=%d\n", x, y);
	}
}	