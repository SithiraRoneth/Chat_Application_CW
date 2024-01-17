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
import java.util.ArrayList;
import java.util.List;

public class UserModel {

    public boolean registerUser(UserDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO user VALUES(?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,dto.getUser());
        pstm.setString(2,dto.getPw());

        return pstm.executeUpdate()>0;
    }

    public List<UserDto> loginUser(UserDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<UserDto> userDtoList = new ArrayList<>();
        while (resultSet.next()) {
            userDtoList.add(
                    new UserDto(
                            resultSet.getString(1),
                            resultSet.getString(2)
                    )
            );
        }

        return userDtoList;
    }
}
