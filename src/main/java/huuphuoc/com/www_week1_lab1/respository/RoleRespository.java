package huuphuoc.com.www_week1_lab1.respository;

import huuphuoc.com.www_week1_lab1.database.ConnectionDB;
import huuphuoc.com.www_week1_lab1.models.Account;
import huuphuoc.com.www_week1_lab1.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleRespository {
    private Connection con;

    public RoleRespository() {
        con = ConnectionDB.getConnection();
    }
    public boolean insertRole(Role role) throws SQLException {
        String query = "insert into role values (?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, role.getRole_id());
        ps.setString(2, role.getRole_name());
        ps.setString(3, role.getDescription());
        ps.setInt(4, role.getStatus());

        return ps.executeUpdate()>0;
    }
    public Role getById(String id) throws Exception{
        String sql = "select * from role where role_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        Role role;
        if(rs.next()){
            role = new Role(rs.getString(1),rs.getString(2),rs.getString(3)
                    ,rs.getInt(4));
            return role;
        }
        return null;
    }
    public List<Role> getByAccountId(String id) throws Exception{
        String sql = "select * from role where account_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        List<Role> roles = new ArrayList<>();
        while (rs.next()){
           Role role = new Role(rs.getString(1),rs.getString(2),rs.getString(3)
                    ,rs.getInt(4));
            roles.add(role);
        }
        return roles;
    }
    public List<Role> getAll() throws Exception{
        String sql = "select * from role";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Role> roles = new ArrayList<>();
        while (rs.next()){
            Role role = new Role(rs.getString(1),rs.getString(2),rs.getString(3)
                    ,rs.getInt(4));
            roles.add(role);
        }
        return roles;
    }

}
