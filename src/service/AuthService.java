package service;

import model.Member;

public class AuthService {

    public void login( Member user ){
        
        if(!members.get(user.getUsername()).equals(user.getPassword())) {
            System.err.println("Invalid Password!");
            return;
        }
        System.out.println("Successfully Logged In!");

    }

    public void register( Member user ){



    }

}
