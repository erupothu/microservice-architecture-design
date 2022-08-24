package com.example.aws.controller;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S3Controller {

    @Autowired
	private AmazonS3 s3Client;

    private String bucket;
    private String key;
    
    // public S3Controller(AmazonS3 s3ClientReq) {
    //     s3Client = s3ClientReq;
    //   }

    @GetMapping("get-bucket-objects")
    public ResponseEntity<?> getBucketObjects() {
        List<String> response = s3Client.listObjectsV2("vaya-nbfc-finflux").getObjectSummaries().stream()
        .map(S3ObjectSummary::getKey)
        .map(key -> key) // custom mapping function
        .collect(Collectors.toList());
        // ObjectListing obj = s3Client.listObjects("s3://aspire-data/testing/cb_enquiry_data.csv");
        return ResponseEntity.ok("bucked list" + response);

    }

    @GetMapping("create-bucket")
    public ResponseEntity<?> createBucket() {
        s3Client.createBucket("my-vaya-bucket");
        return ResponseEntity.ok("bucket creation successful");

    }

    @GetMapping("copy-object-to-bucket")
    public ResponseEntity<?> copyToBucket() {

        // String-based
        String content = "";
        // File-based
        File file = new File("pathname");
        // InputStream-based
        InputStream input = null;
        

        S3Object obj = s3Client.getObject("vaya-nbfc-finflux", "mergeddoc/fatwah/1001497_NB2_merged_doc.pdf");
        Map<String, String> metadata = new HashMap<>();
        // s3Client.putObject("my-vaya-bucket", "1001497_NB2_merged_doc.pdf", obj);
        s3Client.putObject("my-vaya-bucket", "1001497_NB2_merged_doc.pdf", obj.getObjectContent().getDelegateStream(), obj.getObjectMetadata());
        return ResponseEntity.ok("bucket copy successful");

    }

    @GetMapping("delete-bucket")
    public ResponseEntity<?> deleteBucket() {
        s3Client.deleteObject("my-vaya-bucket", "1001497_NB2_merged_doc.pdf");
        return ResponseEntity.ok("bucket key deletion successful");

    }


}
