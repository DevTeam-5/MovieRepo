package member.dtos;

import member.domains.Role;

public class AddMemberDTO {
    private String name;
    private String email;
    private String password;
    private Role role;
    private String phone_num;


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
}
