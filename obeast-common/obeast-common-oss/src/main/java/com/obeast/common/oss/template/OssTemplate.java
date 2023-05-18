package com.obeast.common.oss.template;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import java.io.InputStream;
import java.time.Duration;
import java.util.List;

/**
 * @author wxl
 * Date 2023/4/9 9:51
 * @version 1.0
 * Description: oss 模板方法
 * url: <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CreateBucket.html">aws s3 API 规范</a>
 */
public interface OssTemplate {

    /**
     * Description: <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CreateBucket.html">创建bucket</a>
     * @author wxl
     * Date: 2023/4/9 9:55
     * @param bucketName bucket名称
     */
    void createBucket(String bucketName);

    /**
     * Description: <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_ListBuckets.html">获取所有的bucket</a>
     * @author wxl
     * Date: 2023/4/9 9:56
     * @return java.util.List<com.amazonaws.services.s3.model.Bucket>
     */
    List<Bucket> getAllBuckets();

    /**
     * Description: <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_DeleteBucket.html">通过bucket名称删除bucket</a>
     * @author wxl
     * Date: 2023/4/9 9:56
     * @param bucketName  bucket名称
     */
    void removeBucket(String bucketName);

    /**
     * Description: <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_PutObject.html">上传文件</a>
     * @author wxl
     * Date: 2023/4/9 9:56
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @param stream 文件流
     * @param contextType 文件类型
     * @throws Exception Exception
     */
    void putObject(String bucketName, String objectName, InputStream stream, String contextType) throws Exception;

    /**
     * Description: <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_PutObject.html">上传文件</a>
     * @author wxl
     * Date: 2023/4/9 9:57
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @param stream 文件流
     * @throws Exception Exception
     */
    void putObject(String bucketName, String objectName, InputStream stream) throws Exception;

    /**
     * Description: <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_GetObject.html">获取文件</a>
     * @author wxl
     * Date: 2023/4/9 9:57
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @return com.amazonaws.services.s3.model.S3Object
     */
    S3Object getObject(String bucketName, String objectName);

    /**
     * Description: 文件路径 没有过期时间
     * @author wxl
     * Date: 2023/5/15 23:08
     * @param bucketName  bucketName
     * @param objectName  objectName
     * @return java.lang.String
     */
    String getObjectURL(String bucketName, String objectName);

    /**
     * Description: <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_GeneratePresignedUrl.html">获取对象的url</a>
     * @author wxl
     * Date: 2023/5/15 11:55
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @param expires 过期时间
     * @return java.lang.String
     */
    String getObjectURL(String bucketName, String objectName, Duration expires);

    /**
     * Description: <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_GeneratePresignedUrl.html">获取对象的url</a>
     * @author wxl
     * Date: 2023/4/9 9:57
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @param expires 过期时间
     * @return java.lang.String
     */
    String getObjectURL(String bucketName, String objectName, Integer expires);


    /**
     * Description: <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_GeneratePresignedUrl.html">获取对象的url</a>
     * @author wxl
     * Date: 2023/5/15 11:56
     * @param bucketName bucketName
     * @param objectName objectName
     * @param expires expires
     * @param method  method
     * @return java.lang.String
     */
    String getObjectURL(String bucketName, String objectName, Duration expires, HttpMethod method);

    /**
     * Description: <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_DeleteObject.html">通过bucketName和objectName删除对象</a>
     * @author wxl
     * Date: 2023/4/9 9:57
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @throws Exception Exception
     */
    void removeObject(String bucketName, String objectName) throws Exception;


    /**
     * Description: <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_ListObjects.html">根据文件前置查询文件</a>
     * @author wxl
     * Date: 2023/4/9 9:59
     * @param bucketName bucket名称
     * @param prefix 前缀
     * @param recursive 是否递归查询
     * @return java.util.List<com.amazonaws.services.s3.model.S3ObjectSummary>
     */
    List<S3ObjectSummary> getAllObjectsByPrefix(String bucketName, String prefix, boolean recursive);
}
