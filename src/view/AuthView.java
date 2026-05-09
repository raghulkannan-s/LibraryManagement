package view;

import java.util.Scanner;
import service.AuthService;
import utils.validateAuth;
import model.Member;

public class AuthView {

    Scanner sc;

    AuthService authService = new AuthService();

    public AuthView(Scanner sc) {
        this.sc = sc;
    }

    public void login(){
        
        System.out.println("Login : ");
        System.out.println("Enter Username : ");
        String username = sc.next().trim();
        System.out.println("Enter Password : ");
        String password = sc.next().trim();

        if(!validateAuth.login(username, password)){
            System.err.println("Please Re-Login!");
            return;
        }

        authService.login( username, password );
        
    }

    public void register() {
        System.out.println("Register : ");
        System.out.println("Enter Username : ");
        String username = sc.next().trim();
        System.out.println("Enter Password : ");
        String password = sc.next().trim();
        System.out.println("Re-Enter Password : ");
        String re_password = sc.next().trim();
        
        
        if(!validateAuth.register(username, password, re_password)) {
            System.err.println("Please Re-Register!");
            return;
        }
        Member newMember = new Member(username, password);

        authService.register( newMember );
    }

}
