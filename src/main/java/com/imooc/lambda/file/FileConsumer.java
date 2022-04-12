package com.imooc.lambda.file;

/**
 * 文件处理函函数式接口
 */
public interface FileConsumer {
    /**
     * 函数式接口抽象方法
     * @param fileContent 文件内容字符串
     */
    void fileHandle(String fileContent);
}
