/* Created By Sithira Roneth
 * Date :1/16/24
 * Time :23:24
 * Project Name :Chat_Application
 * */
package lk.ijse.Model;

import lk.ijse.DB.DbConnection;
import lk.ijse.DTO.UserDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserModel {

    public boolean registerUser(UserDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO user VALUES(?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,dto.getUser());
        pstm.setString(2,dto.getPw());

        return pstm.executeUpdate()>0;
    }

    public boolean loginUser(UserDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user WHERE user_name = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,dto.getUser());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String pw = resultSet.getString(2);
            if (pw.equals(dto.getPw())){
                return true;
            }
        }

        return false;
    }
}
