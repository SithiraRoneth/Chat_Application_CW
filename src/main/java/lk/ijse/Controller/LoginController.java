/* Created By Sithira Roneth
 * Date :1/16/24
 * Time :21:58
 * Project Name :Chat_Application
 * */
package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.DTO.UserDto;
import lk.ijse.Model.UserModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoginController {
    @FXML
    private Label lbl_Pw;
    @FXML
    private Label lbl_username;
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtPw;

    @FXML
    private JFXTextField txtUser;
    static String user;
    UserModel userModel = new UserModel();

    public void btnLoginOnAction(ActionEvent actionEvent) throws SQLException, IOException {
        user = txtUser.getText();
        String pw = txtPw.getText();

        var dto = new UserDto(user,pw);
        List<UserDto>userDtoList = userModel.loginUser(dto);
        for (UserDto userDto:userDtoList) {
            if (userDto.getUser().equals(user)) {
                if (userDto.getPw().equals(pw)) {
                    Parent rootNode = FXMLLoader.load(getClass().getResource("/view/chatRoom.fxml"));
                    Scene scene = new Scene(rootNode);
                    Stage primaryStage = (Stage) root.getScene().getWindow();
                    primaryStage.setScene(scene);
                    primaryStage.centerOnScreen();
                    primaryStage.setTitle("Chat Room");
                } else {
                    lbl_Pw.setText("Invalid Password !");
                }
            } else {
                lbl_username.setText("Invalid username ! ");
            }
        }
    }
    public void btnSignupOnAction(ActionEvent actionEvent) throws IOException {
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/register.fxml")));
    }
}
