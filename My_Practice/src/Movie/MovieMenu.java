package Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieMenu {
	Scanner sc = new Scanner(System.in);
	MovieController mc = new MovieController();
	
	public void mainMenu() { //메인 메뉴
		
		System.out.println("====회원 정보 입력====");

		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		
		Member mem = new Member(name, age, gender);
		
		System.out.println("회원 정보 <" + mem.toString() + ">");
		
		int select = 0;
		
		System.out.println("====== 영화 ======");
		System.out.println("1. 영화 목록");
		System.out.println("2. 영화 검색");
		System.out.println("3. 영화 예매");
		System.out.println("9. 프로그램 종료");
		
		System.out.print("메뉴 선택 : ");
		select = sc.nextInt();
		
		switch(select) {
		case 1:
			MovieList();
			break;
		case 2:
			searchMovie();
			break;
		case 3:
			buyTicket();
			break;
		case 9:
			System.out.println("프로그램을 종료합니다.");
			return;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 시도하세요.");	
		}
	}
	
	public void MovieList() { //영화 목록
		System.out.println("====== 영화 목록 ======");
		ArrayList<Movie> mList = mc.MovieList();
		for (Movie m : mList) {
			System.out.println(mList.indexOf(m) + "번 영화" + m.toString());
		}
		
	}
	
	public void searchMovie() { //영화 검색
		System.out.println("===== 영화 검색 =====");
		System.out.println("1. 제목으로 검색");
		System.out.println("2. 장르로 검색");
		System.out.println("3. 연령 제한으로 검색");
		
		System.out.print("메뉴 선택 : ");
		int standard = sc.nextInt();
		switch(standard) {
		case 1:
			System.out.println("===== 제목으로 검색 =====");
			System.out.print("검색할 키워드를 입력하여 주세요. : ");
			String sct = sc.next();
			mc.searchTitle(sct);
			
			break;
		case 2:
			System.out.println("===== 장르로 검색 =====");
			System.out.print("검색할 키워드를 입력하여 주세요. : ");
			String scg = sc.next();
			mc.searchGenre(scg);
			
			break;
		case 3:
			System.out.println("===== 연령 제한으로 검색 =====");
			System.out.print("검색할 키워드를 입력하여 주세요. : ");
			int sca = sc.nextInt();
			System.out.println();
			mc.searchAge(sca);
			
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 메인 메뉴부터 다시 시도하세요.");
		}
	}
	
	public void buyTicket() { //영화 예매
		System.out.println("===== 영화 예매 =====");
		MovieList();
		System.out.print("예매하실 영화의 번호를 입력하세요. : ");
		int reserve = sc.nextInt();
		System.out.println();
		if (mc.checkAge(reserve)) {
			System.out.println("관람불가 영화입니다.");
			return;
		} else if (mc.checkAvailable(reserve)) {
			System.out.println("영화표가 매진되었습니다.");
			return;
		}
		System.out.print("예매하실 티켓의 수를 입력하세요. : ");
		
		
		
	}
}
