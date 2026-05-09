package repository;

import dto.LoginRequest;
import dto.RegisterRequest;
import java.util.HashMap;
import java.util.Map;
import model.Book;
import model.Member;

public class MembersRepository {
    
    private Map<String, Member> members;

    public MembersRepository() {
        this.members = new HashMap<>(); 

        addAdmin();
    }

    private void addAdmin(){
        Member admin = new Member("admin", "admin123");
        members.put( admin.getUsername(), admin );
    }

    public Iterable<Member> getAllUsers(){
        return members.values();
    }

    public boolean hasUser(String username){
        return members.containsKey(username);
    }

    public Member getUser( String username ){
        if( !hasUser(username) ) return null;
        return members.get(username);
    }

    public boolean authenticate( LoginRequest loginRequest ){
        Member member = members.get( loginRequest.getUsername() );
        if( member != null && member.getPassword().equals(loginRequest.getPassword()) ){
            return true;
        }
        return false;
    }

    public Member addMember( RegisterRequest registerRequest ){
        if( members.containsKey(registerRequest.getUsername()) ) {
            System.err.println("Member Already Exist!");
            return null;
        }

        Member newMember = new Member(registerRequest.getUsername(), registerRequest.getPassword());

        members.put( registerRequest.getUsername(), newMember );
        System.out.println(newMember.getUsername() + "is added Successfully!");
        return newMember;
    }

    public void addBookToMember(Member member, Book book) {
        members.get(member.getUsername()).borrowBook(book);
    }

    public void removeBookFromMember(Member member, Book book) {
        members.get(member.getUsername()).returnBook(book);
    }

    
     



    


}
