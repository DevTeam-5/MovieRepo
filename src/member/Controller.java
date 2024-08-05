package member;

import member.domains.Member;
import member.repository.MemberRepository;
import member.services.LoginService;

public class Controller {

    private static final MemberRepository memberRepository = new MemberRepository();
    private static final LoginService loginService = new LoginService();
    private static Member member;

    //로그인 상황
    public void login(String email, String password) {
        member = loginService.login(email, password);
    }

    /**
     * home 에서 member != null 인지 판단하면서 진행하면 될듯??
     */
}
