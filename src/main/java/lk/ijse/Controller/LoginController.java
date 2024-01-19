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
import javafx.stage.Window;
import lk.ijse.DTO.UserDto;
import lk.ijse.Model.UserModel;
import lk.ijse.Server.Server;

import java.awt.*;
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


    public void initialize(){
        root.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    btnLoginOnAction(new ActionEvent());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws SQLException, IOException {
        user = txtUser.getText();
        String pw = txtPw.getText();

        var dto = new UserDto(user,pw);
        List<UserDto>userDtoList = userModel.loginUser(dto);
        for (UserDto userDto:userDtoList) {
            if (!userDto.getUser().equals(user)) {
                lbl_username.setText("Invalid username \uD83D\uDEC8");
            }
            else if (!userDto.getPw().equals(pw)) {
                    lbl_Pw.setText("Invalid Password \uD83D\uDEC8");
            }
            else {
                    Parent rootNode = FXMLLoader.load(getClass().getResource("/view/chatRoom.fxml"));
                    Scene scene = new Scene(rootNode);
                    Stage stage = (Stage) root.getScene().getWindow();
                    stage.setScene(scene);
                    stage.centerOnScreen();
                    stage.setTitle("Chat Room");
            }
        }
    }
    public void btnSignupOnAction(ActionEvent actionEvent) throws IOException {
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/register.fxml")));
    }
}
