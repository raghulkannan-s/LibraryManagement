package view;

import java.util.Scanner;
import model.Member;
import service.MemberService;

public class MemberView {

    Scanner sc;
    MemberService memberService;
    
    public MemberView(Scanner sc, MemberService memberService) {
        this.sc = sc;
        this.memberService = memberService;
    }

    public void listMembers(){

        System.out.println("List of Members :");
        int idx = 0;
        for( Member member : memberService.listMembers() ){
            System.out.println( ++idx + ". " + member.getUsername());
        }
        System.out.println("Total Members : " + idx);
        System.out.println("=====================");
    }


}
