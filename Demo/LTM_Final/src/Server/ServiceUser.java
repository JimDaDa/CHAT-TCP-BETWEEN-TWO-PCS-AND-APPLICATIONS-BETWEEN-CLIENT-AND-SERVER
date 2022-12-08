package Server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ServiceUser {
      
    private final String INSERT_USER = "insert into `users` (`username`, `password`) values (?,?)";
    private final String INSERT_ACCOUNT = "insert into `accounts` (`id`, `username`) values (?,?)";
    private final String CHECK_USER = "SELECT * FROM `users` WHERE `username` = ? limit 1";
    private final String SELECT_ACCOUNT = "select * from `accounts` where accounts.`status`='1' and id<>?";
    private final String LOGIN = "select id, accounts.username, gender, imageString from `users` join `accounts` using (id) where `users`.username=BINARY(?) and `users`.`password`=BINARY(?) and accounts.`Status`='1'";
    
    
    private final Connection con;
    
    public ServiceUser() {
        this.con = DatabaseConnection.getInstance().getConnection();
    }

    public ModelMessage register(ModelRegister data) {
        //  Check user exit
        ModelMessage message = new ModelMessage();
        try {
            PreparedStatement p = con.prepareStatement(CHECK_USER);
            p.setString(1, data.getUsername());
            ResultSet r = p.executeQuery();
            if (r.first()) {
                message.setAction(false);
                message.setMessage("Tên đăng nhập đã tồn tại!");
            } else {
                message.setAction(true);
            }
            r.close();
            p.close();
            if (message.isAction()) {
                //  insert user vào database khi user đăng ký tài khoản
                con.setAutoCommit(false);
                p = con.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
                p.setString(1, data.getUsername());
                p.setString(2, data.getPassword());
                p.execute();
                r = p.getGeneratedKeys();
                r.first();
                int userID = r.getInt(1);
                r.close();
                p.close();
                
                //Tạo tài khoản cho user
                p = con.prepareStatement(INSERT_ACCOUNT);
                p.setInt(1, userID);
                p.setString(2, data.getUsername());
                p.execute();
                p.close();
                con.commit();
                con.setAutoCommit(true);
                message.setAction(true);
                message.setMessage("Ok");
                message.setData(new UserAccount(userID, data.getUsername(), "", "", true));
            }
        } catch (SQLException e) {
            message.setAction(false);
            message.setMessage("Server Error");
            try {
                if (con.getAutoCommit() == false) {
                    con.rollback();
                    con.setAutoCommit(true);
                }
            } catch (SQLException e1) {
            }
        }
        return message;
    }
    
    public UserAccount login(ModelLogin login) throws SQLException {
        UserAccount data = null;
        PreparedStatement p = con.prepareStatement(LOGIN);
        p.setString(1, login.getUserName());
        p.setString(2, login.getPassword());
        ResultSet r = p.executeQuery();
        if (r.first()) {
            int userID = r.getInt(1);
            String userName = r.getString(2);
            String gender = r.getString(3);
            String image = r.getString(4);
            data = new UserAccount(userID, userName, gender, image, true);
        }
        r.close();
        p.close();
        return data;
    }
    
     public List<UserAccount> getUser(int exitUser) throws SQLException {
        List<UserAccount> list = new ArrayList<>();
        PreparedStatement p = con.prepareStatement(SELECT_ACCOUNT);
        p.setInt(1, exitUser);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int userID = r.getInt(1);
            String userName = r.getString(2);
            String gender = r.getString(3);
            String image = r.getString(4);
            list.add(new UserAccount(userID, userName, gender, image, true));
        }
        r.close();
        p.close();
        return list;
    }
     
    private boolean checkUserStatus(int userID) {
        List<ModelClient> clients = Service.getInstance(null).getListClient();
        for (ModelClient c : clients) {
            if (c.getUser().getID() == userID) {
                return true;
            }
        }
        return false;
    }

}
