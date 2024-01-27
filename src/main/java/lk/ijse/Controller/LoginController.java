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
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.DTO.UserDto;
import lk.ijse.Model.UserModel;
import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private Label lbl_Pw;
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
        if (userModel.loginUser(dto)) {
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/chatRoom.fxml"))));
            stage.centerOnScreen();
            stage.setTitle(user+" Room");
            stage.show();
        }else {
            lbl_Pw.setText("Invalid Username or Password \uD83D\uDEC8");
        }
        clearFields();
    }

    private void clearFields() {
        txtUser.setText("");
        txtPw.setText("");
    }

    public void btnSignupOnAction(ActionEvent actionEvent) throws IOException {
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/register.fxml")));
    }
}
