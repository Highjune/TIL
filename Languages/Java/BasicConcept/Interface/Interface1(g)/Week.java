//weekable�� �ڽ���, InterfaceDemo���� ����

//WeekŬ���� ���� �� interface�����-interface �κ�- add- weekable �ؼ� �߰�
//3. Interface�� ��ӹ޴� class�� implements�� ��ӹ޴´�.
//4. Interface�� ��ӹ޴� class�� �ݵ��!! interface�� ��� �߻�޼��带 public���� �������ؾ� �Ѵ�.

//public class extends Object Week implements Weekable  //�̷��� extends Obeject�� �����Ǿ� �ִ�.  Week�� Object�� �ڽ��̸鼭�� weekable�� �ڽ��̴�.


public class Week implements Weekable {
	private int date;
	@Override
	public void set(int date) {
		this.date = date; //date�� �� ���� date��
	}
	

	@Override
	public int get() {
		return this.date;
	}
}





