package com.example.web;

import com.example.util.FileUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description TODO
 * @Author ex_langqf
 * @Date 2020/7/13 17:33
 */
@RestController(value="/upload")
public class FileUploadController {

    @PostMapping(value="fileUpload", headers="content-type=multipart/form-data")
    @ApiOperation(value="testUploadFile",notes="testUploadFile",response = String.class, httpMethod = "POST")
    public String uploadFile(@RequestParam @ApiParam(value="file",required = true) MultipartFile file ){
        String fileType = null;
        try (InputStream inputStream = file.getInputStream()){
            fileType = FileUtil.getFileType(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileType;
    }
}
