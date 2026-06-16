import java.util.ArrayList;

public class Member
{
    private String name;		
    private int ID;		
    private int balance;		
    private ArrayList<Book> borrowedBooks;
    private ArrayList<Magazine> borrowedMagazines;		

    
    
    
    public Member(String name, int ID)
    {
        this.ID = ID ;
        this.name = name ;
    }    
    
    
    public  void setBalance(int amount) {
            this.balance += amount;
    }
    
    
    public  int getBalance()
    {
        return balance;
    }    
    
    
    public  String getName()
    {
        return name ;
    }    
    
    
    public  int getID()
    {
        return ID ;
    }    
    
    
    public  void borrowBook(Book book)
    {
        borrowedBooks.add(book);
        this.setBalance(-1 * book.getPrice());
    }    
    
    
    public  void borrowMagazine(Magazine magazine)
    {
        borrowedMagazines.add(magazine);
        this.setBalance(-1*magazine.getPrice());
        
    }    
    
    
    public  Book getBookFromBorrowedBooks(int ISBN)
    {
        for(int i = 0 ; i<borrowedBooks.size() ;i++){
            if(borrowedBooks.get(i).getISBN()==ISBN){
                return borrowedBooks.get(i);
            }
        }
        return null ;
        
    }    
    
    
    public  Magazine getMagazineFromBorrowedMagazines(int ISSN, int number)
    {
        for(int i = 0 ; i<borrowedMagazines.size() ;i++){
            if(borrowedMagazines.get(i).getISSN()==ISSN){
                if(borrowedMagazines.get(i).getNumber()==number){
                    return borrowedMagazines.get(i);
                }
            }
        }
        return null ;
        
    }    
    
    
    public  void returnBook(Book book)
    {
        for(int i = 0 ; i<borrowedBooks.size() ;i++){
            if(borrowedBooks.get(i).getISBN()==book.getISBN()){
                this.setBalance(9*book.getPrice()/10);
                borrowedBooks.remove(i);
            }
        }
        
    }    
    
    
    public  void returnMagazine(Magazine magazine)
    {
        for(int i = 0 ; i<borrowedMagazines.size() ;i++){
            if(borrowedMagazines.get(i).getISSN()==magazine.getISSN()){
                if(borrowedMagazines.get(i).getNumber()==magazine.getNumber()){
                    this.setBalance(8*magazine.getPrice());
                    borrowedMagazines.remove(i);
                }
            }
        }
    }    
}
