package com.shy.web.Controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;

@Controller
public class ImageController {

    @RequestMapping("/qr")
    public String qr(String content, String ip, Model model){
        int width = 300;
        int height = 300;
        String format = "png";
//        定义二维码的参数
        HashMap hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");//定义字符集
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);//纠错等级
        hints.put(EncodeHintType.MARGIN,2);

//        生成二维码
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);
            Path file1 = new File("E:/Image/shy.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix,format,file1);



            String filePath;    // 发送文件路径
            File file;  // 文件对象
            FileInputStream fis = null; // 文件输入流
            long fileLength = 0;    // 文件长度
            String fileName;    // 文件名

            InetAddress inetAddress;    // ip封装对象
            Socket socket = null;   // 套接字
            OutputStream os = null; // socket输出流对象
            DataOutputStream dos = null;    // 封装socket输出流

            System.out.println("开始传输时间 ： " + new Date());

//        filePath = "E:\\yy\\yy.zip";  // 需要发送的文件
            filePath = file1.toString();  // 需要发         送的文件

            file = new File(filePath);//获取文件
            fis = new FileInputStream(file);

//            inetAddress = InetAddress.getLocalHost();   // 本机ip
//            ip = "172.20.36.122";   // 外网地址，两台不同主机
            inetAddress = InetAddress.getByName(ip);
            socket = new Socket(inetAddress, 9000); // 连接服务器
            System.out.println("连接服务器成功，准备传输！");
            os = socket.getOutputStream();  // 获得输出流对象
            dos = new DataOutputStream(os);

            // 发送文件名、文件长度
            fileName = file.getName();  // 获取文件名称
            dos.writeUTF(fileName); // 发送文件名
            System.out.println("文件名为 ： " + fileName);
            fileLength = fis.available();   // 获取文件大小
            dos.writeLong(fileLength);  // 发送文件长度
            System.out.println("文件长度为 ： " + fileLength);

            int packLength = 0; // 数据包的长度

            while(fileLength>0) {

                if (fileLength > 1024) {
                    packLength = 1024;
                    fileLength -= 1024; // #
                } else {
                    packLength = (int)fileLength;
                    fileLength = 0;
                }

                byte[] bytes = new byte[packLength];
                fis.read(bytes, 0, packLength); // 读取数据
                dos.write(bytes);   // 填充数据
                dos.flush();

            }

            System.out.println("剩余文件长度 : " + fileLength);
            System.out.println("文件传输完毕！");

            dos.close();// 输出流封装对象关闭
            os.close(); // 输出流关闭
            fis.close();    // 输入流关闭
            socket.close(); // 与服务器连接关闭
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "qr";
    }


    @RequestMapping("/fwq")
    public void fwq() throws IOException{
        while (true) {
            ServerSocket server;    // 服务器套接字
            Socket socket;  // 套接字
            InputStream is; // 输入流
            DataInputStream dis;    // 封装输入流,具有方法 writeUTF、writeLong 可以方便传递文件名、文件长度

            String filePath = null;    // 文件输出位置
            String fileName;    // 文件名
            long fileLength;    // 文件长度
            File file;  // 文件对象
            FileOutputStream fos;   // 文件输出流

            // 创建服务器,并等待客户端连接
            server = new ServerSocket(9000);    // 创建服务器套接字
            System.out.println("服务器启动！");
            socket = server.accept();   // 等待客户端连接

            System.out.println("客户端连接成功！"); // 获取客户端连接
            is = socket.getInputStream();   // 获取输入流
            dis = new DataInputStream(is);  // 封装输入流

            // 获取文件名以及生成存放文件路径
            filePath = "E:\\SpringBoot\\dubbo-ssm-consumer\\src\\main\\resources\\static\\images\\";  // 文件存放路径
            fileName = dis.readUTF();//当前路径
            filePath += fileName;
            System.out.println("接受到的文件名 ： " + fileName);

            file = new File(filePath);  // 文件对象
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);   // 获取文件输出流

            // 获取文件大小
            fileLength = dis.readLong();
            System.out.println("接受到的文件大小 ： " + fileLength);

            // 接收文件
            receiveFile(fileLength, dis, fos);
            //      receiveFile2(dis, fos);

            System.out.println("文件接收完毕！");

            fos.close();    // 关闭输出流
            is.close(); // 关闭输入流
            socket.close(); // 关闭套接字
            server.close(); // 关闭服务器

            System.out.println("结束传输时间 ： " + new Date());
        }
    }

    private static void receiveFile(long fileLength,
                                    InputStream is, FileOutputStream fos) throws IOException {

        int bufferSize = 1024;  // 缓冲区大小以及每次请求读入大小
        int packLength = 0; // 单次获取的长度

        /*
         * 存在空循环的问题，即读取到为0字节，fileLength长度>1024
         * 虽然没有读取到文件长度，却将文件长度缩减
         */
        while(fileLength>0) {
            // 期望获取长度
            if (fileLength > 1024) {
                packLength = 1024;
                //fileLength -= 1024;   // #1 空循环代码
                /*
                 * 此时并不知道所读取本次读取的文件长度，
                 * 由于网络的问题,所读取的长度可能并没有bufferSize大小，
                 *
                 * 导致存在文件长度的损失.
                 */
            } else {
                packLength = (int)fileLength;
                fileLength = 0;
            }

            byte[] bytes = new byte[bufferSize];
            // 实际获取长度
            packLength = is.read(bytes, 0, packLength); // 读取数据

            System.out.println("packLength :　" + packLength);

            if (packLength>0) { // #2
                fileLength -= packLength;   // 当读取数据不为0时，文件长度减少对应大小
            }

//          fos.write(bytes);   // 填充数据
            /*
             * 由上可知存在bytes数组并不全满的情况,所以根据实际情况写入数据长度
             *
             * 不然会出现虽然文件没有接收,但却出现文件大小并没有缺少的情况
             */
            fos.write(bytes, 0, packLength);

        }
    }
}
