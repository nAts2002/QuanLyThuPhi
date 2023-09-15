package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.NhanKhauModel;

public class LoginService {
    private String sql_login = "select*from users where username=? and passwd=?";
    public boolean checkLogin(String username, String passwd) throws ClassNotFoundException {
        
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement pstm = connection.prepareCall(sql_login);
            pstm.setString(1, username);
            pstm.setString(2, passwd);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) { //nếu có thì return true
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("lỗi signIn");
            ex.printStackTrace();
        }
        return false;
    }
}
