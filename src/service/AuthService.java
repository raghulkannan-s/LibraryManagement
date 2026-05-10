package service;

import dto.LoginRequest;
import dto.RegisterRequest;
import model.Member;
import repository.MembersRepository;

public class AuthService {

    MembersRepository members = MembersRepository.getInstance();

    public AuthService() {
        
    }

    public Member login( LoginRequest loginRequest ){
        
        if( !members.hasUser(loginRequest.getUsername()) ){
            System.err.println("No user Found");
            return null;
        }

        if(!members.authenticate(loginRequest)) {
            System.err.println("Invalid Password!");
            return null;
        }

        System.out.println("Successfully Logged In!");

        return members.getUser(loginRequest.getUsername());
    }

    public Member register( RegisterRequest registerRequest ){
        return members.addMember(registerRequest);
    }

}
