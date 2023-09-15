package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.KhaiTuModel;
import models.TamTruModel;

public class KhaiTuService {

    public boolean add(KhaiTuModel khaiTuModel) throws ClassNotFoundException, SQLException {

        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO khai_tu(soGiayKhaiTu,idNguoiKhai, idNguoiChet, ngayKhai, ngayChet, lyDoChet)" + " values (?, ?, ?, ?, ?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, khaiTuModel.getSoGIayKhaiTu());
        preparedStatement.setInt(2, khaiTuModel.getIdNguoiKhai());
        preparedStatement.setInt(3, khaiTuModel.getIdNguoiChet());
        preparedStatement.setDate(4, khaiTuModel.getNgayKhai());
        preparedStatement.setDate(5, khaiTuModel.getNgayChet());
        preparedStatement.setString(6, khaiTuModel.getLyDoChet());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }

    public List<KhaiTuModel> getListKhaiTu() throws ClassNotFoundException, SQLException {
        List<KhaiTuModel> list = new ArrayList<>();

        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT * FROM khai_tu";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            KhaiTuModel khaiTuModel = new KhaiTuModel(rs.getInt("id"), rs.getInt("soGiayKhaiTu"), rs.getInt("idNguoiKhai"), rs.getInt("idNguoiChet"), rs.getDate("ngayKhai"), rs.getDate("ngayChet"), rs.getString("lyDoChet"));
            list.add(khaiTuModel);
        }
        preparedStatement.close();
        connection.close();
        return list;
    }

    public void updateGhiChu(int id) throws ClassNotFoundException, SQLException {
        Connection connection = MysqlConnection.getMysqlConnection();
        PreparedStatement preparedStatement;

        String query = "UPDATE nhan_khau " + "set ghiChu='Đã mất' where ID = " + id;
        preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }
}
