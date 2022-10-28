package assignment8;

public class InformationBook {

    private String bookId;
    private String bookName;
    private String author;
    private String publisher;
    private String kindOfBook;
    private int price;
    private int quantity;

    // CONSTRUCTOR
    public InformationBook(String bookId, String bookName, String author, String publisher, String kindOfBook, int price, int quantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.kindOfBook = kindOfBook;
        this.price = price;
        this.quantity = quantity;
    }

    // GETTER AND SETTER

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public String getKindOfBook() {
        return kindOfBook;
    }

    public void setKindOfBook(String kindOfBook) {
        this.kindOfBook = kindOfBook;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // toString method
    public String toString(){
        return "\t" + this.bookId + "\n" + "\t" + this.bookName + "\n" + "\t" + this.author + "\n" + "\t" + this.publisher + "\n" + "\t" + this.kindOfBook + "\n" + "\t" + "$" + this.price + "\n" + "\t" + this.quantity + "books";
    }
}
