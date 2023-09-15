package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.TamTruModel;
import models.TamVangModel;

public class TamTruService {
    public boolean add(TamTruModel tamTruModel) throws ClassNotFoundException, SQLException {

        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO tam_tru(idNhanKhau,maGiayTamTru,noiTamTru, tuNgay, denNgay, lydo)" + " values (?, ?, ?, ?, ?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, tamTruModel.getIdNhanKhau());
        preparedStatement.setString(2, tamTruModel.getMaGiayTamTru());
        preparedStatement.setString(3, tamTruModel.getNoiTamTru());
        preparedStatement.setDate(4, tamTruModel.getTuNgay());
        preparedStatement.setDate(5, tamTruModel.getDenNgay());
        preparedStatement.setString(6, tamTruModel.getLyDo());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }

    public List<TamTruModel> getListTamTru() throws ClassNotFoundException, SQLException {
        List<TamTruModel> list = new ArrayList<>();

        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT * FROM tam_tru";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            TamTruModel tamTruModel = new TamTruModel(rs.getInt("id"), rs.getInt("idNhanKhau"), rs.getString("maGiayTamTru"), rs.getString("noiTamTru"), rs.getDate("tuNgay"), rs.getDate("denNgay"), rs.getString("lydo"));
            list.add(tamTruModel);
        }
        preparedStatement.close();
        connection.close();
        return list;
    }
}
