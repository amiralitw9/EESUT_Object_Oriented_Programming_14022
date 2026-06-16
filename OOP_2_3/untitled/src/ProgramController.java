import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgramController {
    private Library library;

    public  void run()
    {
        Scanner scanner = new Scanner(System.in);
        String[] patterns = new String [15] ;
        patterns[0]="^Create\\s+Library\\s+$";
        patterns[1]="^Add account Account-Name ([a-zA-Z\\s]+) Account-Number (\\d{5})";
        patterns[2]="^Increase balance Account-Number (\\d{5}) Amount (\\d+)";
        patterns[3]="Cashout Account-Number (\\d{5})";
        patterns[4]="Add book Book-Name ([A-Za-z0-p\\s]+) ISBN (\\d+) Author ([A-Za-z\\s]+) Language ([A-Za-z]+) Price (\\d+) Amount (\\d+)";
        patterns[5]="Add magazine Magazine-Name ([A-Za-z0-p\\s]+) ISSN (\\d+) Author ([A-Za-z\\s]+) Language ([A-Za-z]+) Price (\\d+) Amount (\\d+) Number (\\d+)";
        patterns[6]="Borrow book ISBN (\\d+) Account-Number (\\d{5})";
        patterns[7]="Borrow magazine ISSN (\\d+) Account-Number (\\d{5}) Number (\\d+)";
        patterns[8]="Return book ISBN (\\d+) Account-Number (\\d{5})";
        patterns[9]="Return magazine ISSN (\\d+) Account-Number (\\d{5}) Number (\\d+)";
        patterns[10]="Donate book Account-Number (\\d{5}) Book-Name ([A-Za-z0-p\\s]+) ISBN (\\d+) Author ([A-Za-z\\s]+) Language ([A-Za-z]+) Price (\\d+) Amount (\\d+)";
        patterns[11]="Return magazine and borrow next ISSN (\\d+) Account-Number (\\d{5}) Number (\\d+)";
        patterns[12]="Print books";
        patterns[13]="Print magazines";
        patterns[14]="end";
        boolean countinue_loop = true ;
        while (countinue_loop) {
            String input = scanner.nextLine();
            if(library==null){
                System.out.println("You have to create the library first");
            }
            else{
                for(int i = 0 ; i<14 ; i++){
                    if(getCommandMatcher(input,patterns[i]).find()){
                        Matcher matcher = getCommandMatcher(input,patterns[i]);
                        switch (i){
                            case 0:
                                library = new Library();
                                System.out.println("Library created successfully");
                                break;
                            case 1:
                                addAccount(matcher);
                                break;
                            case 2:
                                increaseBalance(matcher);
                                break;
                            case 3:
                                cashout(matcher);
                                break;
                            case 4:
                                addBook(matcher);
                                break;
                            case 5:
                                addMagazine(matcher);
                                break;
                            case 6:
                                borrowBook(matcher);
                                break;
                            case 7:
                                borrowMagazine(matcher);
                                break;
                            case 8:
                                returnBook(matcher);
                                break;
                            case 9:
                                returnMagazine(matcher);
                                break;
                            case 10:
                                donateBook(matcher);
                                break;
                            case 11:
                                returnMagazineAndBorrowNext(matcher);
                                break;
                            case 12:
                                printBooks(matcher);
                                break;
                            case 13:
                                printMagazines(matcher);
                                break;
                            case 14:
                                countinue_loop = false ;
                                break;
                            default:
                                System.out.println("invalid command");
                                break;
                        }
                    }
                }

            }
        }
    }


    private Matcher getCommandMatcher(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }

    private void addAccount(Matcher matcher) {
        int tempID;
        tempID = Integer.valueOf(matcher.group(1));
        if (library.getMemberByID(tempID) != null) {
            System.out.println("A member with this ID already exists");
            return;
        }
        library.addMember(new Member(matcher.group(1), Integer.valueOf(matcher.group(2))));
        System.out.println("Account created successfully");
    }


    private  void increaseBalance(Matcher matcher)
    {
        int tempID ;
        tempID = Integer.valueOf(matcher.group(1));
        if(library.getMemberByID(tempID)==null){
            System.out.println("No member with this ID exists");
            return;
        }
        library.getMemberByID(tempID).setBalance(Integer.valueOf(matcher.group(2)));
        System.out.println("Balance increased successfully");
    }

    private  void cashout(Matcher matcher)
    {
        int tempID ;
        tempID = Integer.valueOf(matcher.group(1)) ;
        if(library.getMemberByID(tempID)==null){
            System.out.println("No member with this ID exists");
            return;
        }
        System.out.println(library.getMemberByID(tempID).getName() + " cashed out successfully. Amount: " + library.getMemberByID(tempID).getBalance());
        library.getMemberByID(tempID).setBalance(-1*library.getMemberByID(tempID).getBalance());

    }


    private  void addBook(Matcher matcher) {
        Book book = new Book(matcher.group(1),Integer.valueOf(matcher.group(2)),matcher.group(3),matcher.group(4),Integer.valueOf(matcher.group(5)));
        for(int i = 0 ; i< Integer.valueOf(matcher.group(6)) ; i++){
            library.addBook(book);
        }
        System.out.println(Integer.valueOf(matcher.group(6)) + " books were added to the library successfully");
    }


    private  void addMagazine(Matcher matcher)
    {
        Magazine magazine = new Magazine(matcher.group(1),Integer.valueOf(matcher.group(2)),matcher.group(3), matcher.group(4),Integer.valueOf(matcher.group(5)),Integer.valueOf(matcher.group(7)) );
        for(int i = 0 ; i<Integer.valueOf(matcher.group(6));i++){
            library.addMagazine(magazine);
        }
        System.out.println(Integer.valueOf(matcher.group(6)) + " magazines were added to the library successfully");

    }

    private  void borrowBook(Matcher matcher)
    {
        int tempID ;
        tempID = Integer.valueOf(matcher.group(2)) ;
        if(library.getMemberByID(tempID)==null){
            System.out.println("No member with this ID exists");
            return;
        }
        int tempISBN ;
        tempISBN = Integer.valueOf(matcher.group(1)) ;
        if(library.getBook(tempISBN)==null){
            System.out.println("No book with this ISBN was found in the library");
            return;
        }
        if(library.getMemberByID(tempID).getBalance()<library.getBook(tempISBN).getPrice()){
            System.out.println("The member's balance is not enough");
            return;
        }
        System.out.println(library.getBook(tempISBN).getName() + " was borrowed by " + library.getMemberByID(tempID).getName()+" successfully");
        library.getMemberByID(tempID).borrowBook(library.getBook(tempISBN));
        library.removeBook(library.getBook(tempISBN));
    }


    private  void borrowMagazine(Matcher matcher) {
        int tempID ;
        tempID = Integer.valueOf(matcher.group(2)) ;
        if(library.getMemberByID(tempID)==null){
            System.out.println("No member with this ID exists");
            return;
        }
        int tempISSN , tempNumber ;
        tempISSN = Integer.valueOf(matcher.group(1)) ;
        tempNumber = Integer.valueOf(3);
        if(library.getMagazine(tempISSN,tempID)==null){
            System.out.println("No magazine with this ISSN and number was found in the library");
            return;
        }
        if(library.getMemberByID(tempID).getBalance()<library.getMagazine(tempISSN,tempNumber).getPrice()){
            System.out.println("The member's balance is not enough");
            return;
        }
        System.out.println(library.getMagazine(tempISSN,tempNumber).getName() + " was borrowed by " + library.getMemberByID(tempID).getName()+" successfully");
        library.getMemberByID(tempID).borrowMagazine(library.getMagazine(tempISSN,tempNumber));
        library.removeMagazine(library.getMagazine(tempISSN,tempNumber));

    }


    private  void returnBook(Matcher matcher)
    {
        int tempID ;
        tempID = Integer.valueOf(matcher.group(2)) ;
        if(library.getMemberByID(tempID)==null){
            System.out.println("No member with this ID exists");
            return;
        }
        int tempISBN ;
        tempISBN = Integer.valueOf(matcher.group(1)) ;
        if(library.getMemberByID(tempID).getBookFromBorrowedBooks(tempISBN)==null){
            System.out.println("This member has never borrowed this book or has returned it");
            return;
        }
        System.out.println(library.getMemberByID(tempID).getName()+ " returned " +library.getMemberByID(tempID).getBookFromBorrowedBooks(tempISBN).getName() +" successfully");
        library.addBook(library.getMemberByID(tempID).getBookFromBorrowedBooks(tempISBN));
        library.getMemberByID(tempID).returnBook(library.getBook(tempISBN));

    }


    private  void returnMagazine(Matcher matcher)
    {
        int tempID ;
        tempID = Integer.valueOf(matcher.group(2)) ;
        if(library.getMemberByID(tempID)==null){
            System.out.println("No member with this ID exists");
            return;
        }
        int tempISSN , tempNumber ;
        tempISSN = Integer.valueOf(matcher.group(1)) ;
        tempNumber = Integer.valueOf(3);
        if(library.getMemberByID(tempID).getMagazineFromBorrowedMagazines(tempISSN,tempNumber)==null){
            System.out.println("This member has never borrowed this magazine or has returned it");
            return;
        }
        System.out.println(library.getMemberByID(tempID).getName()+ " returned " + library.getMemberByID(tempID).getMagazineFromBorrowedMagazines(tempISSN,tempNumber).getName() + " successfully");
        library.addMagazine(library.getMemberByID(tempID).getMagazineFromBorrowedMagazines(tempISSN,tempNumber));
        library.getMemberByID(tempID).returnMagazine(library.getMagazine(tempISSN,tempNumber));
    }


    private  void donateBook(Matcher matcher)
    {
        int tempID ;
        tempID = Integer.valueOf(matcher.group(1)) ;
        if(library.getMemberByID(tempID)==null){
            System.out.println("No member with this ID exists");
            return;
        }
        Book book = new Book(matcher.group(2),Integer.valueOf(matcher.group(3)),matcher.group(4),matcher.group(5),Integer.valueOf(matcher.group(6)));
        for(int i = 0 ; i< Integer.valueOf(matcher.group(7)) ; i++){
            library.addBook(book);
            library.getMemberByID(tempID).setBalance(4*Integer.valueOf(matcher.group(6))/10);
        }
        System.out.println(library.getMemberByID(tempID).getName() + " donated " + matcher.group(7)+" books successfully");

    }


    private  void returnMagazineAndBorrowNext(Matcher matcher)
    {
        int tempID ;
        tempID = Integer.valueOf(matcher.group(2)) ;
        if(library.getMemberByID(tempID)==null){
            System.out.println("No member with this ID exists");
            return;
        }
        int tempISSN , tempNumber ;
        tempISSN = Integer.valueOf(matcher.group(1)) ;
        tempNumber = Integer.valueOf(3);
        if(library.getMemberByID(tempID).getMagazineFromBorrowedMagazines(tempISSN,tempNumber)==null){
            System.out.println("This member has never borrowed this magazine or has returned it");
            return;
        }
        if(library.getMagazine(tempISSN,tempNumber+1)==null){
            System.out.println("The library does not have the next issue of this magazine");
            return;
        }
        System.out.println(library.getMemberByID(tempID).getName()+ " returned " + library.getMemberByID(tempID).getMagazineFromBorrowedMagazines(tempISSN,tempNumber).getName() + " and borrowed the next issue");
        library.addMagazine(library.getMemberByID(tempID).getMagazineFromBorrowedMagazines(tempISSN,tempNumber));
        library.removeMagazine(library.getMagazine(tempISSN,tempNumber+1));
        library.getMemberByID(tempID).returnMagazine(library.getMagazine(tempISSN,tempNumber));
        library.getMemberByID(tempID).borrowMagazine(library.getMagazine(tempISSN,tempNumber+1));
        library.getMemberByID(tempID).setBalance(library.getMagazine(tempISSN,tempNumber).getPrice()*2/10);

    }


    private  void printBooks(Matcher matcher)
    {
        System.out.println("List of all books:");
        for(int i = 0 ;i< library.getBooks().size() ; i++){
            System.out.println(library.getBooks().get(i).getISBN()+": "+library.getBooks().get(i).getName());
        }

    }


    private  void printMagazines(Matcher matcher)
    {
        System.out.println("List of all magazines:");
        for(int i = 0 ; i<library.getMagazines().size();i++){
            System.out.println(library.getMagazines().get(i).getISSN()+": "+ library.getMagazines().get(i).getName()+" "+library.getMagazines().get(i).getNumber());
        }
    }
}
