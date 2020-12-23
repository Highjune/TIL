package test;

public class Member {
	public String id;
	
	public Member(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		// Object타입의 매개 변수는 모든 객체가 매개값으로 제공될 수 있기 때문에 instanceof 연산자로 기준 객체와 동일한 타입인지 제일 먼저 확인해야 한다.
		if(obj instanceof Member) { //매개값이 Member타입인지 확인
			Member member = (Member)obj;
			if(id.equals(member.id)) {
				return true;
			}
		}
		// 매개값이 Member타입이 아니거나 id필드값이 다른 경우 false를 리턴
		return false;
	}

	//id 필드값이 같을 경우 같은 해시코드를 리턴하도록 하기 위해 String의 hashCode()메소드의 리턴값을 활용. 
	//String의 hashCode()는 같은 문자열일 경우 동일한 해시코드를 리턴한다. 
	@Override
	public int hashCode(){
		return id.hashCode(); // 그러면 같은 문자열(id 필드값)일 경우 같은 hashCode 값을 리턴하게 된다.
	}
}
