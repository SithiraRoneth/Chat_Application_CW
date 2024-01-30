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
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Client.Client;
import lk.ijse.DTO.UserDto;
import lk.ijse.Model.UserModel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class LoginController implements Initializable {
    @FXML
    private Label lbl_Pw;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtPw;
    @FXML
    private JFXTextField txtUser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void btnLoginOnAction(ActionEvent actionEvent) throws SQLException, IOException {
        try {
            if (Pattern.matches("^[a-zA-Z\\s]+", txtUser.getText())) {
                Client client = new Client(txtUser.getText());

                Thread thread = new Thread(client);
                thread.start();

            }
            clearFields();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void clearFields(){
        txtUser.setText("");
    }
    public void btnSignupOnAction(ActionEvent actionEvent) throws IOException {
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/register.fxml")));
    }
}
