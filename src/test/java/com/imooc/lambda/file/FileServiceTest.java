package com.imooc.lambda.file;

import org.junit.Test;

import java.io.IOException;

public class FileServiceTest {
    @Test
    public void fileHandle() throws IOException {
        FileService fileService = new FileService();
        fileService.fileHandle("C:\\Users\\lizha\\Desktop\\study\\996\\src\\test\\java\\com\\imooc\\lambda\\file\\FileServiceTest.java",
                fileContent -> {
                    System.out.println(fileContent);
                });
    }
}
