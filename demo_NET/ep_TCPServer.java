package demo_NET;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/*实例：
    客户端上传文件到服务器，服务器接收后保存到服务器硬盘上
 */
public class ep_TCPServer {
    public static void main(String[] args) throws IOException {
        //创建服务器对象
        ServerSocket server=new ServerSocket(8888);
        //让服务器一直工作
        while(true){
            Socket s1 = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        //获得客户端的套接字，并定义网络字节输出流和网络字节输入流
                        InputStream is = s1.getInputStream();
                        OutputStream os = s1.getOutputStream();
                        //判断该文件夹是否存在，不存在就创建
                        File file=new File("D://serverpic");
                        if(!file.exists()){
                            file.mkdirs();
                        }
                        //自定义文件的命名规则：防止同名文件覆盖。规则：毫秒值+随机数
                        String filename=System.currentTimeMillis()+new Random().nextInt(999999)+".jpg";
                        //创建本地字节输出流，这里使用字节输出缓冲流
                        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(file+"\\"+filename));
                        //利用网络字节输入流获得客户端传过来的文件，写入到服务器的硬盘中去
                        int len=0;
                        byte[] bytes=new byte[1024];
                        while((len=is.read(bytes))!=-1){
                            bos.write(bytes,0,len);
                        }
                        System.out.println("服务器：写入服务器硬盘成功！");
                        //给客户端回传信息
                        os.write("服务器：客户端，我收到你发来的文件了".getBytes());
                        //关闭资源
                        s1.close();
                        bos.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();

        }
//        server.close();
    }
}
