package lessons.lesson3;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private String isbn;
    private String name;
    private String author;
    private int year;
    private BookStatus status;

    public Book(String isbn, String name, String author, int year) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.year = year;
        this.status = BookStatus.AVAILABLE;
    }
    private static ArrayList<Book> books = new ArrayList<>();


    public void getBookInfo() {
        System.out.println("Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", status=" + status +
                '}');
    }

    public static void getBooks(){
        for(Book book: books){
            book.getBookInfo();
        }
    }
    public static void addNewBook(String isbn, String name, String author, int year){
        Book nb = new Book(isbn, name, author, year);
        books.add(nb);
        System.out.println("book added "+ name);
    }
    public void reserveBook(){
        if(status == BookStatus.AVAILABLE){
            status = BookStatus.RESERVED;
            System.out.println("Book "+name+" successfully reserved");
        }else{
            System.out.println("Book "+name+ " is already reseved (status: "+ status+ ").");
        }
    }
    public static  Book findById(String isbn){
        for(Book b: books){
            if(b.isbn.equals(isbn)){
                return b;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("choose an option: 1) add book 2) show book list 3) reserve a book 4) exit" );
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("enter isbn: ");
                    String isbn = scanner.nextLine();
                    System.out.println("enter book name: ");
                    String name= scanner.nextLine();
                    System.out.println("enter the author: ");
                    String author= scanner.nextLine();
                    System.out.println("enter the year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    Book.addNewBook(isbn, name, author, year);
                    break;

                case 2:
                    Book.getBooks();
                    break;

                case 3:
                    System.out.println("enter isbn of the book to reserve: ");
                    String findIsbn = scanner.nextLine();
                    Book book = Book.findById(findIsbn);
                    if(book!=null){
                        book.reserveBook();

                    }
                    else{
                        System.out.println("no book with this isbn");

                    }
                    break;
                case 4:
                    System.out.println("exiting...");

                    return;

                default:
                    System.out.println("invalid option! ");
            }
        }
    }


}
