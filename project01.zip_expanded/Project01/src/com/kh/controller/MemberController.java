package com.kh.controller;

import java.util.ArrayList;

import com.kh.movie.dao.MemberDao;
import com.kh.movie.vo.Member;
import com.kh.view.MemberMenu;

public class MemberController {
	
	public int insertMember(String id, String pwd, String name, String hp) {
		
		Member m = new Member(id, pwd, name, hp);
		
		int result = new MemberDao().insertMember(m);
		
		if (result > 0) { 
			new MemberMenu().displaySuccess("성공적으로 회원이 추가되었습니다.");
		} else { 
			new MemberMenu().displayFail("회원추가를 실패하였습니다.");
		}
		return result;
		
	}
	
	public void selectList() {
		ArrayList<Member> list = new MemberDao().selectList();
		
		if(list.isEmpty()) { 
			new MemberMenu().displayNoData("조회 결과가 없습니다.");
		} else { 
			new MemberMenu().displayMemberList(list);
		}
	}
	
	public void updateMember(String id, String pwd,
			String name, String hp) {
		Member m = new Member();
		m.setId(id);
		m.setPwd(pwd);
		m.setName(name);
		m.setHp(hp);
		
		int result = new MemberDao().updateMember(m);
		
		if (result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원 정보 변경되었습니다.");
		} else {
			new MemberMenu().displayFail("회원정보 변경에 실패하였습니다.");
		}
	}
	
	public void deleteMember(String id) {
		int result = new MemberDao().deleteMember(id);
		
		if (result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원 정보 삭제되었습니다.");
		} else {
			new MemberMenu().displayFail("회원정보 삭제에 실패하였습니다.");
		}
	}
	
	
}
