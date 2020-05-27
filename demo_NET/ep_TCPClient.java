package demo_NET;

import java.io.*;
import java.net.Socket;

/*实例：
    客户端上传文件到服务器，服务器接收后保存到服务器硬盘上
 */
public class ep_TCPClient {
    public static void main(String[] args) throws IOException {
        //创建客户端本地字节输入流，这里我用字节输入缓冲流
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("D:\\clientpic\\1.jpg"));
        //创建客户端连接服务器的套接字
        Socket socket=new Socket("127.0.0.1",8888);
        //用套接字获取字节输出流和字节输入流
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        //本地字节输入流获取信息，并写入网络字节输出流给服务器
        int len=0;
        byte []bytes=new byte[1024];
        while((len=bis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        System.out.println("客户端：上传成功！");
        //给服务器写一个结束标记
        socket.shutdownOutput();
        //网络字节输入流开启，等待服务器回传信息
        len=0;
        bytes=new byte[1024];
        while((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        os.close();
        is.close();
        bis.close();
        socket.close();
    }
}
