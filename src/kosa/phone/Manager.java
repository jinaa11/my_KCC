package kosa.phone;

import java.util.Scanner;

// 전화번호 관리 전반적인 기능
public class Manager {
//	private PhoneInfo arr[] = new PhoneInfo[10];
	private PhoneInfo arr[];
//	private Scanner sc;
	private int count;

	public Manager() {
		arr = new PhoneInfo[10];
//		sc = new Scanner(System.in);
	}

	public void addPhoneInfo() {
		// 키보드로부터 이름, 전화번호, 생년월일을 입력 받아
		// PhoneInfo 객체를 생성해서 배열에 추가하는 것
		System.out.print("이름: ");
		String name = DataInput.sc.nextLine();
		System.out.print("전화번호: ");
		String phoneNo = DataInput.sc.nextLine();
		System.out.print("생년월일: ");
		String birth = DataInput.sc.nextLine();

		arr[count++] = new PhoneInfo(name, phoneNo, birth);
	};

	public void listPhoneInfo() {
		for (int i = 0; i < count; i++) {
			arr[i].show();
		}
	}

	public void searchPhoneInfo() {
		// 검색하고자 하는 이름으로 1개의 PhoneInfo 객체의 내용 출력
		System.out.print("검색할 이름: ");
		String name = DataInput.sc.nextLine();
		int idx = -1;

		for (int i = 0; i < count; i++) {
			if (name.equals(arr[i].getName())) {
				System.out.println("검색한 이름: " + name);
				arr[i].show();
				idx = i;
			}
		}

		// 검색된 내용이 없는 경우
		if (idx == -1) {
			System.out.println("존재하지 않는 이름입니다.");
		}

	}

	public void updatePhoneInfo() {
		// 이름을 입력 => 해당 phoneInfo 추출 => 수정 전화번호 입력 => 전화번호 수정이 완료
		System.out.print("수정할 이름: ");
		String name = DataInput.sc.nextLine();
		int idx = -1;

		for (int i = 0; i < count; i++) {
			if (name.equals(arr[i].getName())) {
				System.out.print("수정할 번호: ");
				String newPhone = DataInput.sc.nextLine();
				// 데이터를 수정할 때는 setter 사용
				arr[i].setPhoneNo(newPhone);
				idx = i;
			}
		}
		System.out.println("수정 완료");

		if (idx == -1) {
			System.out.println("존재하지 않습니다.");
		}
	}

	public void deletePhoneInfo() {
		// 이름을 입력 => 대상 객체 위치 검색 => 인덱스 찾기 => 해당 객체 삭제 (뒤에 부터 앞으로 1칸씩 옮기고 마지막 것을 삭제 -
		// 인덱스 하나 감소)
//		System.out.print("삭제할 이름 입력: ");
//		String name = sc.nextLine();
//		int idx = -1;
//		
//		for(int i = 0; i < count; i++) {
//			if(name.equals(arr[i].getName())) {
//				for(int j = i; j < count - 1; j++) {
//					arr[j] = arr[j+1];
//				}
//				count--;
//			}
//		}
//		System.out.println("삭제 완료");
//		
//		if(idx == -1) {
//			System.out.println("존재하지 않습니다.");
//		}

		System.out.print("삭제할 이름 입력: ");
		String name = DataInput.sc.nextLine();
		int idx = -1;

		for (int i = 0; i < count; i++) {
			if (name.equals(arr[i].getName())) {
				idx = i;
			}
		}

		if (idx == -1) {
			System.out.println("존재하지 않습니다.");
		} else {
			for (int i = idx; i < count; i++) {
				if (i == arr.length - 1) {
					arr[i] = null;
				} else {
					arr[i] = arr[i + 1];
				}
			}
			count--;
		}
	}
}
