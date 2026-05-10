package service;

import model.Book;
import model.Member;
import repository.MembersRepository;

public class MemberService {
    
    private MembersRepository membersRepository;

    public MemberService() {
        membersRepository = MembersRepository.getInstance();
    }

    public Iterable<Member> listMembers(){
        return membersRepository.getAllUsers();
    }

    public void addBookToMember(Member member, Book book) {
        membersRepository.addBookToMember(member, book);
    }

    public boolean removeBookFromMember(Member member, Book book) {
        return membersRepository.removeBookFromMember(member, book);
    }

}
