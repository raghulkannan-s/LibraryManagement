package view;

import dto.LoginRequest;
import dto.RegisterRequest;
import java.util.Scanner;
import model.Member;
import service.AuthService;
import utils.validateAuth;

public class AuthView {

    Scanner sc;
    AuthService authService;

    public AuthView(Scanner sc, AuthService authService) {
        this.sc = sc;
        this.authService = authService;
    }

    public Member login(){
        
        System.out.println("=====================");
        System.out.println("       Login");
        System.out.print("Enter Username : ");
        String username = sc.next().trim();
        System.out.println("");
        System.out.print("Enter Password : ");
        String password = sc.next().trim();
        System.out.println("=====================");

        LoginRequest loginRequest = new LoginRequest(username, password);

        if(!validateAuth.login(loginRequest)){
            System.err.println("Please Re-Login!");
            return null;
        }

        return authService.login( loginRequest );
        
    }

    public Member register() {
        System.out.println("=====================");
        System.out.println("      Register");
        System.out.print("Enter Username : ");
        String username = sc.next().trim();
        System.out.println("");
        System.out.print("Enter Password : ");
        String password = sc.next().trim();
        System.out.println("");
        System.out.print("Re-Enter Password : ");
        String re_password = sc.next().trim();
        System.out.println("=====================");
        
        RegisterRequest registerRequest = new RegisterRequest(username, password, re_password);
        
        if(!validateAuth.register(registerRequest)) {
            System.err.println("Please Re-Register!");
            return null;
        }
        return authService.register( registerRequest );
    }

}
