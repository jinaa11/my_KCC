package kosa.oop5;

public class Main {

	public static void main(String[] args) {
		Object obj[] = { new Reader("�Ѹ�"), new Work("�浿"), new Student("������") };
		
		for(int i = 0; i < obj.length; i++) {
			if(obj[i] instanceof Speakable) {
				Speakable speaker = (Speakable)obj[i];
				System.out.println(speaker.speak());
			}
		}
		
	}

}