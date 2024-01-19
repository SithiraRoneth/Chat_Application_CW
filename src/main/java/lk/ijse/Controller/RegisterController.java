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
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.DTO.UserDto;
import lk.ijse.Model.UserModel;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterController {
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtPw;

    @FXML
    private JFXTextField txtUser;
    UserModel userModel = new UserModel();

    public void initialize(){
        root.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    btnSignupOnAction(new ActionEvent());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public void btnSignupOnAction(ActionEvent actionEvent) throws IOException, SQLException {
        String user = txtUser.getText();
        String pw = txtPw.getText();

        var dto = new UserDto(user,pw);
        try {
            boolean isReg = userModel.registerUser(dto);

            if (isReg) {
                new Alert(Alert.AlertType.CONFIRMATION, "You are Registered").show();
                root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/login.fxml")));
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
    public void HyperLoginOnAction(ActionEvent actionEvent) throws IOException {
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/login.fxml")));
    }
}
