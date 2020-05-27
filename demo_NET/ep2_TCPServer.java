package demo_NET;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//实现浏览器访问服务器
public class ep2_TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8080);
        while(true){
            Socket s1 = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        InputStream is = s1.getInputStream();
                        //把网络输入流转换成字符缓冲输入流
                        BufferedReader br=new BufferedReader(new InputStreamReader(is));
                        /*获取到的字符信息为 GET /demo/src/demo_NET/web/111.html HTTP/1.1
                        用split方法把/demo/src/demo_NET/web/111.html提取出来
                         */
                        String []arr=br.readLine().split(" ");
                        //去掉前面的‘/’
                        String htmlpath=arr[1].substring(1);
                        FileInputStream fis=new FileInputStream(htmlpath);
                        OutputStream os = s1.getOutputStream();

                        //写入HTTP协议响应头，固定写法
                        os.write("http/1.1 200 ok\r\n".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());
                        //必须要写入空行，否则浏览器不解析
                        os.write("\r\n".getBytes());

                        int len=0;
                        byte[] bytes=new byte[1024];
                        while((len=fis.read(bytes))!=-1){
                            os.write(bytes,0,len);
                        }
                        fis.close();
                        s1.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        //server.close();
    }
}
