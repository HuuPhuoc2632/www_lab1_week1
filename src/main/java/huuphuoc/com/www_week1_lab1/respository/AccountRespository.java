package huuphuoc.com.www_week1_lab1.respository;

import huuphuoc.com.www_week1_lab1.database.ConnectionDB;
import huuphuoc.com.www_week1_lab1.models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountRespository {

    private Connection con;

    public AccountRespository() {
        con = ConnectionDB.getConnection();
    }
    public Account login(String user, String password) throws Exception{
        String sql = "select * from account where full_name = ? and password = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        Account account;
        while(rs.next()){
            account = new Account(rs.getString(1),rs.getString(2),rs.getString(3)
                    ,rs.getString(4),rs.getString(5),rs.getInt(6));
            return account;
        }
        return null;
    }
    public boolean insertAccount(Account account) throws Exception {
        String sql = "insert into account values(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, account.getAccount_id());
        ps.setString(2, account.getFull_name());
        ps.setString(3, account.getPassword());
        ps.setString(4, account.getEmail());
        ps.setString(5, account.getPhone());
        ps.setInt(6, account.getStatus());
        return ps.executeUpdate()>0;
    }
    public boolean updatetAccount(Account account) throws Exception{
        String sql = "update account set full_name = ?, password= ?,email = ?, phone = ?, status = ? where account_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, account.getFull_name());
        ps.setString(2, account.getPassword());
        ps.setString(3, account.getEmail());
        ps.setString(4, account.getPhone());
        ps.setInt(5, account.getStatus());
        ps.setString(6, account.getAccount_id());
        return ps.executeUpdate()>0;
    }

    public boolean deleteAccount(String id) throws Exception{
        String sql = "delete from account where account_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        return ps.executeUpdate()>0;
    }


    public Account getById(String id) throws Exception{
        String sql = "select * from account where account_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        Account account;
        if(rs.next()){
            account = new Account(rs.getString(1),rs.getString(2),rs.getString(3)
                    ,rs.getString(4),rs.getString(5),rs.getInt(6));
            return account;
        }
        return null;
    }

    public List<Account> getAll() throws Exception{
        List<Account> list = new ArrayList<>();
        String sql = "select * from account";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Account account;
        while (rs.next()){
            account = new Account(rs.getString(1),rs.getString(2),rs.getString(3)
                    ,rs.getString(4),rs.getString(5),rs.getInt(6));
            list.add(account);
        }
        return list;
    }

}
