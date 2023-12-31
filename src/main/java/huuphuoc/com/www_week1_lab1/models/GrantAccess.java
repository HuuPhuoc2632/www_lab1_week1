package huuphuoc.com.www_week1_lab1.models;

public class GrantAccess {
    private Role role_id;
    private String account_id;
    private IsGrant is_grant;
    private String note;

    public Role getRole_id() {
        return role_id;
    }

    public void setRole_id(Role role_id) {
        this.role_id = role_id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public IsGrant getIs_grant() {
        return is_grant;
    }

    public void setIs_grant(IsGrant is_grant) {
        this.is_grant = is_grant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public GrantAccess() {
    }

    public GrantAccess(Role role_id, String account_id, IsGrant is_grant, String note) {
        this.role_id = role_id;
        this.account_id = account_id;
        this.is_grant = is_grant;
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "role_id='" + role_id + '\'' +
                ", account_id='" + account_id + '\'' +
                ", is_grant=" + is_grant +
                ", note='" + note + '\'' +
                '}';
    }
}
