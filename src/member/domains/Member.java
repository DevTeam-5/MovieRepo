package member.domains;

import member.dtos.AddMemberDTO;

public class Member {
    private int u_id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private String phone_num;

    public int getU_id() {
        return u_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public Member() {}
    public Member(AddMemberDTO memberDto) {

    }
}
