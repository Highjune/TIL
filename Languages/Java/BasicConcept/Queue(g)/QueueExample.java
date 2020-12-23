package practice;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		//LinkedList�� Queue �ڷ� ������ ������ ��ǥ Ŭ����. 
		//�� List�� �����߱� ������ List �÷����̱⵵ �ϴ�.
		Queue<Message> messageQueue = new LinkedList<Message>();
		
		messageQueue.offer(new Message("sendMail", "ȫ�浿"));
		messageQueue.offer(new Message("sendSMS", "�ſ��"));
		messageQueue.offer(new Message("sendKakaotalk", "ȫ�β�"));
		
		while(!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch(message.command) {
			case "sendMail" :
				System.out.println(message.to + "�Կ��� ������ �����ϴ�.");
				break;
			case "sendSMS" :
				System.out.println(message.to + "�Կ��� SMS�� �����ϴ�.");
				break;
			case "sendKaKaoTalk" :
				System.out.println(message.to + "�Կ��� īī������ �����ϴ�.");
				break;
			}
		}
	}
}
