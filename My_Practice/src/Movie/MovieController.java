package Movie;

import java.util.ArrayList;

public class MovieController {
	private Member mem = null;
	private ArrayList<Movie> mList = new ArrayList<>();
	
	public MovieController() {
		mList.add(new Movie(0, null, null, 0, 0, false));
	}
	
	public ArrayList<Movie> MovieList() { //영화 목록
		return this.mList;
	}
	
	public ArrayList<Movie> searchTitle(String title) { //영화 제목 검색결과
		ArrayList<Movie> titles = new ArrayList<Movie>();
		for (Movie m : mList) {
			if (m.getTitle().contains(title)) {
				titles.add(m);
			}
		}
		return titles;
	}
	
	public ArrayList<Movie> searchGenre(String genre) { //영화 장르 검색결과
		ArrayList<Movie> genrelist = new ArrayList<Movie>();
		for (Movie m : mList) {
			if (m.getGenre().equals(genre)) {
				genrelist.add(m);
			}
		}
		return genrelist;
	}
	
	public ArrayList<Movie> searchAge(int age) { //영화 연령제한 검색결과
		ArrayList<Movie> ages = new ArrayList<Movie>();
		for (Movie m : mList) {
			if (m.getAccessAge() <= age) {
				ages.add(m);
			}
		}
		return ages;
	}
	
	public boolean checkAge(int movieNum) { //연령대 확인
		boolean check = false;
		if (mem.getAge() < mList.get(movieNum).getAccessAge()) {
			check = true;
		}
		return check;
	}
	
	public boolean checkAvailable(int movieNum) { //매진 여부 확인
		boolean check = false;
		if (mList.get(movieNum).isAvailable()){
				check = true;
		}
		return check;
	}
}
