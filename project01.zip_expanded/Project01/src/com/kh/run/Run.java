package com.kh.run;

import java.util.Scanner;

import com.kh.view.MemberMenu;
import com.kh.view.MovieMenu;

public class Run {

	public static void main(String[] args) {
		new MemberMenu().loginMenu();
		new MovieMenu().MovieMain();
		
		
		// 2. 영화예매 메인화면 출력(영화목록, 영화예매, 예약취소, 회원정보 수정, 회원탈퇴 )
		
		
		// 2-1 영화목록 (select seqM, title, genre from movie;)
		
		/**
		 *  2-2 영화예매 
		 *       가. 2-1
		 *       나. (insert into booking (id, seqM) values(?, ?))
		 *       다. 2
		 */
		
		
		/**
		 *  2-3 예약취소
		 *       가. select m.seqM, m.title, m.genre from booking b join movie m on b.seqM = m.seqM where b.id = ?
		 *       나. seqM 입력
		 *       다. delete from booking b where b.seqM = ? and b.id = ?
		 *       라. 2
		 *       
		 */
		
		
		
		
		
		
	}
}
	