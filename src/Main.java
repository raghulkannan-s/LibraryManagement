import java.util.Scanner;

import view.AuthView;

public class Main {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Welcome to Library Management");
        
        Scanner sc = new Scanner(System.in);

        AuthView authView = new AuthView(sc);

        while( true ){
            System.out.println("Enter your Choice :");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    authView.login();
                    break;
                case 2:
                    authView.register();
                default:
                    throw new AssertionError();
            }


        }


    }
}
