package com.imooc.lambda.file;

import java.io.*;

/**
 * 文件服务类
 */
public class FileService {
    /**
     * 实现通过url获取本地文件内容，调用函数式接口处理
     *
     * @param url
     * @param fileConsumer
     */
    public void fileHandle(String url, FileConsumer fileConsumer)
            throws IOException {
        // 创建文件读取流
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(url)));

        //行变量
        String line;
        // 内容
        StringBuilder stringBuilder = new StringBuilder();

        // 循环读取内容
        while ((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line).append("\n");
        }

        // 调用函数式接口，将内容传递给lambda表达式，实现业务逻辑
        fileConsumer.fileHandle(stringBuilder.toString());
    }
}
