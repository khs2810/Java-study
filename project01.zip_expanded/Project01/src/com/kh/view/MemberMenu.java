package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.movie.vo.Member;

public class MemberMenu {
	
	private Scanner sc = new Scanner(System.in);

	private MemberController mc = new MemberController();
	private MovieMenu mv = new MovieMenu();
	
	// 1. 회원가입, 로그인 선택화면 출력
	public void loginMenu() {
		
		while(true) {
			System.out.println("======== 메가톤박스 예약서비스 ========");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				this.insertMember();
				break;
			case 2:
				this.loginPage();
				mv.MovieMain();
				break;
			default:
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요~ ");
			}
		}
		
	}
			
			
			/**
			 *  1-1. 회원가입 
			 *  		가. Scanner id, pwd, name, hp
			 *  		나. insert into member (id, pwd, name, hp, regDt, udtDt, useYn) values(?, ?, ?, ?, sysdate, sysdate, 'Y')
			 *  		다. 1-2
			 */
			public void insertMember() {
				System.out.println("==============회원가입===============");
				
				System.out.print("아이디 : ");
				String id = sc.next();
				
				System.out.print("비밀번호 : ");
				String pwd = sc.next();
				
				System.out.print("이름 : ");
				String name = sc.next();
				
				System.out.print("전화번호 : ");
				String hp = sc.next();
				
				mc.insertMember(id, pwd, name, hp);
				
			}

			/**
			 * 	1-2. 로그인
			 * 		가. Scanner id, pwd
			 * 		나. select count(*) as cnt from member where id = ? and pwd = ?;
			 *      1-2-1-1. cnt == 0 : '일치하는 회원이 없습니다.'
			 *      1-2-1-2. 1-2
			 *      1-2-2-1. cnt > 0 : 2
			 */
			
			public void loginPage() {
				System.out.println("============= 로그인 ==============");
				System.out.print("아이디 : ");
				String id = sc.nextLine();
				
				System.out.print("비밀번호 : ");
				String pwd = sc.nextLine();
				
			}


			public void displaySuccess(String message) {
				System.out.println("\n서비스 요청 성공 : " + message);
			}


			public void displayFail(String message) {
				System.out.println("\n서비스 요청 실패 : " + message);
			}
			
			public void displayNoData(String message) {
				System.out.println("\n" + message);
			}
			
			public void displayMemberList(ArrayList<Member> list) {
				for(Member m : list) {
					System.out.println(m);
				}
			}

			
}
