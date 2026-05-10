import java.util.Scanner;
import model.Book;
import model.Member;
import service.AuthService;
import service.BookService;
import service.MemberService;
import view.AuthView;
import view.BookView;
import view.MemberView;

public class Main {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Welcome to Library Management");
        
        Scanner sc = new Scanner(System.in);

        AuthService authService = new AuthService();
        BookService bookService = new BookService();
        MemberService memberService = new MemberService();

        AuthView authView = new AuthView(sc, authService);
        BookView bookView = new BookView(sc, bookService);
        MemberView memberView = new MemberView(sc, memberService);

        Member currentMember = null;

        outer : while( true ){
            if( currentMember == null ){
                System.out.println("=====================");
                System.out.println("Enter your Choice :");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Exit");
                System.out.println("=====================");
    
                int choice = sc.nextInt();
    
                switch (choice) {
                    case 1:
                        currentMember = authView.login();
                        break;
                    case 2:
                        currentMember = authView.register();
                        break;
                    case 3 :
                        System.out.println("Bye!");
                        sc.close();
                        break outer;
                    default:
                        throw new AssertionError();
                }
            }
            else if( currentMember.getUsername().equals("admin") ){
                System.out.println("=====================");
                System.out.println("Admin Panel :");
                System.out.println("1. List Members");
                System.out.println("2. List Books");
                System.out.println("3. Add Book");
                System.out.println("4. Increase Book Quantity");
                System.out.println("5. Logout");
                System.out.println("6. Exit");
                System.out.println("=====================");
    
                int choice = sc.nextInt();
    
                switch (choice) {
                    case 1:
                        memberView.listMembers();
                        break;
                    case 2:
                        bookView.listBooks();
                        break;
                    case 3:
                        bookView.addBook();
                        break;
                    case 4:
                        bookView.increaseBookQuantity();
                        break;
                    case 5:
                        currentMember = null;
                        break;
                    case 6:
                        System.out.println("Bye!");
                        sc.close();
                        break outer;
                    default:
                        throw new AssertionError();
                }
            }
            else{
                System.out.println("=====================");
                System.out.println("Menu :");
                System.out.println("1. List Books");
                System.out.println("2. Borrow Book");
                System.out.println("3. Return Book");
                System.out.println("4. Logout");
                System.out.println("5. Exit");
                System.out.println("=====================");
    
                int choice = sc.nextInt();
    
                switch (choice) {
                    case 1:
                        bookView.listBooks();
                        break;
                    case 2:
                        Book borrowedBook = bookView.borrowBook();
                        if (borrowedBook != null) {
                            System.out.println("You have borrowed: " + borrowedBook.getName());
                            memberService.addBookToMember(currentMember, borrowedBook);
                        }
                        break;
                    case 3:
                        Book returnedBook = bookView.returnBook();
                        if (returnedBook != null) {
                            boolean removed = memberService.removeBookFromMember(currentMember, returnedBook);
                            if( removed ){
                                System.out.println("You have returned: " + returnedBook.getName());
                                bookService.increaseQuantity(returnedBook.getId(), 1);
                            }
                        }
                        break;
                    case 4:
                        currentMember = null;
                        break;
                    case 5:
                        System.out.println("Bye!");
                        sc.close();
                        break outer;
                    default:
                        throw new AssertionError();
                }
            }
        }


    }
}
