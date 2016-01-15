import java.io.Serializable;


public class TextBook implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String author;
	private String publisher;
	private Double price;
	private Integer ISBN;
	private Integer year;
	public TextBook(String title, String author, String publisher,
			Double price, Integer iSBN, Integer year) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		ISBN = iSBN;
		this.year = year;
	}
	public TextBook(String title) {this.title = title;}
	
	//	Getters and setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getISBN() {
		return ISBN;
	}
	public void setISBN(Integer iSBN) {
		ISBN = iSBN;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "TextBook [title=" + title + ", author=" + author
				+ ", publisher=" + publisher + ", price=" + price + ", ISBN="
				+ ISBN + ", year=" + year + "]";
	}

}
