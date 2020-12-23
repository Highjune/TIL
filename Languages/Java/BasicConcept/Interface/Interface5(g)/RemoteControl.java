package practice;

public interface RemoteControl {
	public int MAX_VOLUME = 5;
	public int MIN_VOLUME = 5;
	
	public void turnOn();
	public void turnOff();
	public void setVolume(int volume);
}
