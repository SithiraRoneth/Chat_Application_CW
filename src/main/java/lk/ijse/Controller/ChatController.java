/* Created By Sithira Roneth
 * Date :1/16/24
 * Time :23:52
 * Project Name :Chat_Application
 * */
package lk.ijse.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


public class ChatController extends Thread{
    @FXML
    private AnchorPane emojiPane;

    @FXML
    private Label lblName;

    @FXML
    private VBox msgVbox;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TextField txtMsg;
    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    public void initialize(){
        String name = LoginController.user;
        lblName.setText(name);

        try {
            socket = new Socket("localhost",3000);
            System.out.println("Socket connected to server");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(),true);

            this.start();
            emojiPane.setVisible(false);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void hide_emoji_pane(MouseEvent event) {
        emojiPane.setVisible(false);
    }
    @FXML
    void emoji_on_action(MouseEvent event) {
        emojiPane.setVisible(true);
    }

    @FXML
    void image_on_action(MouseEvent event) {

    }

    @FXML
    void send_on_action(MouseEvent event) {
        String message = txtMsg.getText();
        printWriter.println(lblName.getText() + ":" + message);
        txtMsg.clear();

        if ((message.equalsIgnoreCase("exit")) || (message.equalsIgnoreCase("bye"))){
            System.exit(0);
        }
    }

    @FXML
    void emoji1(MouseEvent mouseEvent) {

    }
    @FXML
    void emoji10(MouseEvent event) {
    }
    @FXML
    void emoji11(MouseEvent event) {

    }

    @FXML
    void emoji12(MouseEvent event) {

    }

    @FXML
    void emoji2(MouseEvent event) {

    }

    @FXML
    void emoji3(MouseEvent event) {

    }

    @FXML
    void emoji4(MouseEvent event) {

    }

    @FXML
    void emoji5(MouseEvent event) {

    }

    @FXML
    void emoji6(MouseEvent event) {

    }

    @FXML
    void emoji7(MouseEvent event) {

    }

    @FXML
    void emoji8(MouseEvent event) {

    }

    @FXML
    void emoji9(MouseEvent event) {

    }
}
