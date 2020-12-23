
//x는 1부터 3씩 증가하고, y는 100부터 2씩 감소한다. x와 y가 교차될 때의 x, y의 값은?

class For6{
	public static void main(String[] args) {
		int x, y;
		for(x=1, y=100; y>0; x+=3, y-=2) {
			if(x>y) break;
		}
		System.out.printf("x=%d, y=%d\n", x, y);
	}
}	