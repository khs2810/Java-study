package com.kh.view;

import java.util.Scanner;

import com.kh.controller.MovieController;

public class MovieMenu {
	private Scanner sc = new Scanner(System.in);
	private MovieController mc = new MovieController();
	
	public void MovieMain() {
		while(true) {
			System.out.println("============ 영화예매 ================");
			System.out.println("1. 영화목록");
			System.out.println("2. 영화예매");
			System.out.println("3. 예약취소");
			System.out.println("");
			System.out.println("============ 회원 설정 ============");
			System.out.println("4. 회원정보 수정");
			System.out.println("5. 회원탈퇴");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				System.out.println("+====== 상영작품 ======+");
				/**
				 * 영화 목록 호출
				 */
				
				break;
			case 2:
				
				/**
				 * 예매
				 */
				break;
			case 3:
				/**
				 * 예약취소.
				 * delete
				 */
				break;
			case 4:
				
			case 5:
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요~ ");
			}
		}
			
	}
	
}
