package model;

public class Usuario {
	private String Author;
	private String Title;
	private int Year;
	private int Code;
	
	public Usuario() {
		this.Author = "";
		this.Title = "";
		this.Year = -1;
		this.Code = -1;
	}
	
	public Usuario(String Author, String Title, int Year, int Code) {
		this.Author = Author;
		this.Title = Title;
		this.Year = Year;
		this.Code = Code;
	}

	

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public int getCode() {
		return Code;
	}

	public void setCode(int code) {
		Code = code;
	}

	@Override
	public String toString() {
		return "Usuario [Author=" + Author + ", Title=" + Title + ", Year=" + Year + ", Code=" + Code + "]";
	}	
}