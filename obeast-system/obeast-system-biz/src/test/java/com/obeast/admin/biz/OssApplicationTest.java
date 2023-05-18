package com.obeast.admin.biz;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.obeast.common.oss.template.OssTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author wxl
 * Date 2023/5/15 23:34
 * @version 1.0
 * Description:
 */
@SpringBootTest
public class OssApplicationTest {

    @Autowired
    OssTemplate ossTemplate;

    @Autowired
    AmazonS3 amazonS3;

    @Test
    void test1() {
        String bucket = "obeast-admin";
        String fileName = "472c9994b9d34f5c8ebd98ee631105e5.jpg";
        System.err.println(amazonS3.listBuckets());
        List<S3ObjectSummary> list = amazonS3.listObjects(bucket).getObjectSummaries();
        list.forEach(System.err::println);

    }
}
