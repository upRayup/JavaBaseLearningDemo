package demo_NET;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务器
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建一个服务器的对象
        ServerSocket server=new ServerSocket(8888);
        //获取客户端套接字
        Socket s1 = server.accept();
        //用客户端的套接字获取输入流
        InputStream is = s1.getInputStream();
        //查看客户端发来的信息
        int len=0;
        byte []bytes=new byte[1024];
        while((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        //用客户端的套接字获取输出流
        OutputStream os = s1.getOutputStream();
        //给客户端回复信息
        os.write("你好，客户端".getBytes());
        //关闭客户端套接字
        s1.close();
        //关闭服务器
        server.close();
    }
}
