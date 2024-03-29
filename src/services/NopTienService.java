package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.NopTienModel;

public class NopTienService {

    // checked
    public boolean add(NopTienModel nopTienModel) throws ClassNotFoundException, SQLException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO nop_tien(IDNopTien, MaKhoanThu, NgayThu, soTien)"
                + " values (?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, nopTienModel.getIdNopTien());
        preparedStatement.setInt(2, nopTienModel.getMaKhoanThu());
        preparedStatement.setDate(3, nopTienModel.getNgayThu());
        preparedStatement.setDouble(4, nopTienModel.getSoTien());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }

    // checked
    public boolean del(int idNopTien, int maKhoanThu) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM nop_tien WHERE IDNopTien = '" + idNopTien + "' AND MaKhoanThu = '" + maKhoanThu + "';";
        Connection connection = MysqlConnection.getMysqlConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        return true;
    }

    // checked
    public List<NopTienModel> getListNopTien() throws ClassNotFoundException, SQLException {
        List<NopTienModel> list = new ArrayList<>();
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT * FROM nop_tien";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            NopTienModel nopTienModel = new NopTienModel();
            nopTienModel.setIdNopTien(rs.getInt("IDNopTien"));
            nopTienModel.setMaKhoanThu(rs.getInt("MaKhoanThu"));
            nopTienModel.setNgayThu(rs.getDate("NgayThu"));
            nopTienModel.setSoTien(rs.getDouble("soTien"));
            list.add(nopTienModel);
        }
        preparedStatement.close();
        connection.close();
        return list;
    }

    public double gettongTien(int maKhoanThu) throws ClassNotFoundException, SQLException {
        double tong = 0;
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT MaKhoanThu,SUM(soTien) as soTien FROM nop_tien WHERE MaKhoanThu="+maKhoanThu+" GROUP by MaKhoanThu";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            tong=rs.getDouble("soTien");
        }
        preparedStatement.close();
        connection.close();
        return tong;
    }
}
