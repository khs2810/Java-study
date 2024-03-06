package Movie;

public class Movie {
	private String title; // 영화 제목
	private String genre; // 영화 장르
	private int accessAge; // 연령 제한
	private int ticket; // 남은 영화표
	private boolean available; // 예매 가능 여부
	
	public Movie() {
		super();
	}
	
	public Movie(int serial, String title, String genre, int accessAge, int ticket, boolean available) {
		super();
		this.title = title;
		this.genre = genre;
		this.accessAge = accessAge;
		this.ticket = ticket;
		this.available = available;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getAccessAge() {
		return accessAge;
	}

	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}
	
	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		if (available = true) {
			return "제목 : " + title + "/ 장르 : " + genre + "/ 연령 제한 : " 
					+ accessAge + "/ 남은 영화표 : " + ticket + "/ 예매 가능";
		} else {
			return "제목 : " + title + "/ 장르 : " + genre + "/ 연령 제한 : " 
					+ accessAge + "/ 남은 영화표 : " + ticket + "/ 매진";
		}
		
	}
	
	
}
