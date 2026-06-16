import java.util.ArrayList;

public class Library
{
    private ArrayList<Book> books;
    private ArrayList<Magazine> magazines;		
    private ArrayList<Member> members;		

    
    
    
    public  void addBook(Book book)
    {
        books.add(book);
    }
    
    
    public  void addMagazine(Magazine magazine)
    {
     magazines.add(magazine);
    }    
    
    
    public  void addMember(Member member)
    {
        members.add(member);
    }    
    
    
    public  Member getMemberByID(int ID)
    {
        for(int i = 0 ;i<members.size() ; i++ ){
            if(members.get(i).getID()==ID){
                return members.get(i);
            }
        }
        return null ;
    }    
    
    
    public  Book getBook(int ISBN)
    {
        for(int i = 0 ; i< books.size() ; i++){
            if(books.get(i).getISBN()==ISBN){
                return books.get(i);
            }
        }
        return null ;
        
    }    
    
    
    public  Magazine getMagazine(int ISSN, int number)
    {
        for(int i = 0 ; i<magazines.size() ; i++){
            if(magazines.get(i).getISSN()==ISSN){
                if(magazines.get(i).getNumber()==number){
                    return magazines.get(i);
                }
            }
        }
        return null ;
        
    }    
    
    
    public  void removeBook(Book book)
    {
        for(int i = 0 ; i<books.size() ; i++){
            if(books.get(i).getISBN()==book.getISBN()){
                books.remove(i);
                return;
            }
        }
    }    
    
    
    public  void removeMagazine(Magazine magazine)
    {
        for(int i = 0 ; i<magazines.size();i++){
            if(magazines.get(i).getISSN()==magazine.getISSN()){
                if(magazines.get(i).getNumber()==magazine.getNumber()){
                    magazines.remove(i);
                }
            }
        }
        
    }    
    
    
    public  ArrayList<Book> getBooks()
    {
        return books ;
    }    
    
    
    public  ArrayList<Magazine> getMagazines()
    {
        return magazines ;
    }    
}
