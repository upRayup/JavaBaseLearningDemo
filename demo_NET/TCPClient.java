package demo_NET;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
//客户端
public class TCPClient{
    public static void main(String[] args) throws IOException {
        //创建连接服务器的套接字socket(包含IP地址、端口号)
        Socket socket=new Socket("127.0.0.1",8888);
        //创建输出流
        OutputStream os=socket.getOutputStream();
        //给服务器传话，这里创建的是字节流所以要转成byte
        os.write("服务器你好阿！".getBytes());
        //创建输入流
        InputStream is=socket.getInputStream();
        //接收服务器回传的信息
        int len=0;
        byte []bytes=new byte[1024];
        while((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        //关闭套接字
        socket.close();
    }
}
