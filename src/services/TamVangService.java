package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.NhanKhauModel;
import models.TamVangModel;

public class TamVangService {

    public boolean add(TamVangModel tamVangModel) throws ClassNotFoundException, SQLException {

        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO tam_vang(idNhanKhau, maGiayTamVang, tuNgay, denNgay, lydo)" + " values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, tamVangModel.getIdNhanKhau());
        preparedStatement.setString(2, tamVangModel.getMaGiayTamVang());
        preparedStatement.setDate(3, tamVangModel.getTuNgay());
        preparedStatement.setDate(4, tamVangModel.getDenNgay());
        preparedStatement.setString(5, tamVangModel.getLydo());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }

    public List<TamVangModel> getListTamVang() throws ClassNotFoundException, SQLException {
        List<TamVangModel> list = new ArrayList<>();

        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT * FROM tam_vang";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            TamVangModel tamVangModel = new TamVangModel(rs.getInt("id_tam_vang"), rs.getInt("idNhanKhau"),rs.getString("maGiayTamVang"), rs.getDate("tuNgay"),
                    rs.getDate("denNgay"), rs.getString("lydo"));
            list.add(tamVangModel);
        }
        preparedStatement.close();
        connection.close();
        return list;
    }
}
