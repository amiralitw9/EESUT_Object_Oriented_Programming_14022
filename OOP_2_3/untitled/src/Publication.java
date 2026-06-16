
public class Publication {
    private String name;		
    private String author;		
    private int price;		
    private String language;
    private int amount ;

    
    
    
    public Publication(String name, String author, String language, int price )
    {
        this.name = name;
        this.author = author ;
        this.language = language ;
        this.price = price;
    }
    
    
    public  String getName()
    {
        return name;
    }    
    
    
    public  String getAuthor()
    {
        return author ;
    }    
    
    
    public  int getPrice()
    {
        return price ;
    }    
    
    
    public  String getLanguage()
    {
        return language;
    }
}
