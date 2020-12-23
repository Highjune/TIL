/*
 * public, static, final이 생략된 상수들의 집합
 */
public enum Weekday {
//	private int SUN; //enum은 데이터 타입 쓰면 안 된다.
//	private SUN;  //private 안 써도 된다.
//	SUN, MON, TUE, WED, THU, FRI, SAT;
    JUNE, SAT, SUN, MON, TUE, WED, THU, FRI;  // 이렇게 하면 wd.ordinal 하면 번호 순서 다름.
//이렇게 값을 따로 주지 않으면 0 1 2 3~
}