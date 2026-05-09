package model;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String username;
    private String password;
    private List<Integer> booksBorrowed;

    
    public Member(String username, String password) {
        this.username = username;
        this.password = password;
        this.booksBorrowed = new ArrayList<>();
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }



}
