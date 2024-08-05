package member.repository;

import member.domains.Member;
import member.dtos.AddMemberDTO;
import utility.Utility;

public class MemberRepository {

    public Member findByEmail(String email) {
        String query = "select u_id, name, email, password, role, phone_num from member " +
                "where email = " + email;
        Member member = Utility.readData(query, new Member());
        return member;
    }

    public void addMember(AddMemberDTO addForm) {
        String query = " INSERT INTO " +
                "member(name,email,password,role,phone_num) VALUES(?,?,?,?,?) ";
        Utility.writeData(query, addForm);
    }
}
