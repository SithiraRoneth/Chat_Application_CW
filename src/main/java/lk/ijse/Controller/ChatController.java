/* Created By Sithira Roneth
 * Date :1/16/24
 * Time :23:52
 * Project Name :Chat_Application
 * */
package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Optional;

public class ChatController {
    @FXML
    private JFXTextField txtFiled;
    @FXML
    private Label lblName;
    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane MsgPane;
    @FXML
    private ScrollPane scrollPane;
    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    public void initialize(){
        lblName.setText(LoginController.user);

        try {
            socket = new Socket("localhost",3000);
            System.out.println("Socket connected to server");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(),true);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit ?", yes, no);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == yes) {
            Platform.exit();
        }
    }

    public void btnSendOnAction(MouseEvent mouseEvent) {
    }


    public void btnCameraOnAction(MouseEvent mouseEvent) {
    }
}
