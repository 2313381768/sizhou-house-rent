package com.young.sizhou.houserent.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * @title: OssFileUtils
 * @projectName: youngblog
 * @description: TODO
 * @author: SiZhou
 * @date: 2021/5/30 15:38
 */
public class OssFileUtils {

    private static String endpoint = "oss-cn-beijing.aliyuncs.com";

    private static String accessKeyId ="LTAI5tKGXkQ9snHjMQXj93UN";

    private static String accessKeySecret = "FjQpPa1Y7TVPradv3RKqF4JTu0EWWz";

    private static String bucketName = "youngblogupload";

    /**
     * 功能描述:
     *
     * @param:[objectKey, multipartFile 文件的新名称]
     * @return:java.lang.String
     * @date:2018/10/14 15:46
     **/
    public static String uploadFile(String objectKey, MultipartFile multipartFile)
            throws OSSException, ClientException, FileNotFoundException {

        // 创建OSSClient的实例
        OSSClient ossClient  = new OSSClient(endpoint,accessKeyId,accessKeySecret);

        StringBuffer sb = new StringBuffer();
        // 上传的文件不是空，并且文件的名字不是空字符串
        if (multipartFile.getSize() != 0 && !"".equals(multipartFile.getName())) {
            ObjectMetadata om = new ObjectMetadata();
            om.setContentLength(multipartFile.getSize());
            // 设置文件上传到服务器的名称
            om.addUserMetadata("filename", objectKey);
            try {
                ossClient.putObject(bucketName, objectKey, new ByteArrayInputStream(multipartFile.getBytes()), om);
            } catch (IOException e) {

            }
        }
        // 设置这个文件地址的有效时间
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        String url = ossClient.generatePresignedUrl(bucketName, objectKey, expiration).toString();
        return url;
    }
}

