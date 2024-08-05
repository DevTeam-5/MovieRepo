package member.services;

import member.domains.Member;
import member.repository.MemberRepository;

public class LoginService {

    MemberRepository memberRepository;

    public Member login(String email, String password) {
        Member member = memberRepository.findByEmail(email);

        if (member.getPassword().equals(password)) {
            System.out.println("로그인 성공!");
            return member;
        }
        System.out.println("로그인 실패!");
        return null;
    }
}
