/* Created By Sithira Roneth
 * Date :1/17/24
 * Time :22:09
 * Project Name :Chat_Application
 * */
package lk.ijse.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);

        Socket socket;

        while (true){
            System.out.println("server waiting");
            socket = serverSocket.accept();
            System.out.println("Client connected");
        }

    }
}
