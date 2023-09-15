package huuphuoc.com.www_week1_lab1.respository;

import huuphuoc.com.www_week1_lab1.database.ConnectionDB;
import huuphuoc.com.www_week1_lab1.models.Account;
import huuphuoc.com.www_week1_lab1.models.GrantAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GrantAccessResposotory {
    private Connection con;

    public GrantAccessResposotory() {
        con = ConnectionDB.getConnection();
    }

    public boolean insertGrant(GrantAccess grantAccess) throws Exception{
        String query = "insert into grant_access values (?, ?, ?,?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, grantAccess.getRole_id());
        ps.setString(2, grantAccess.getAccount_id());
        ps.setInt(3, Integer.parseInt(grantAccess.getIs_grant().toString()));
        ps.setString(4, grantAccess.getNote());

        return ps.executeUpdate()>0;
    }
    public String getRoleID(String account_id) throws SQLException {
        String query = "select * from grant_access where account_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, account_id);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            return rs.getString(1);
        }
        return null;
    }
}
