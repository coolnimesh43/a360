package org.coolnimesh.a360.controller;

import javax.ws.rs.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.coolnimesh.a360.api.BucketService;
import org.coolnimesh.a360.pojo.BucketRequest;
import org.coolnimesh.a360.pojo.BucketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
@RequestMapping("/bucket")
public class BucketController {

    private static final Logger LOG = LogManager.getLogger(BucketController.class);

    @Autowired
    private BucketService bucketService;

    @Value("${bucket-url}")
    private String bucketUrl;

    @RequestMapping(value = "/create/{accessToken}", method = RequestMethod.GET)
    public ResponseEntity<BucketResponse> createNewBucket(@PathParam("accessToken") String accessToken) {
        LOG.debug("Inside BucketController#createNewBucket method.");
        BucketResponse bucketResponse = null;
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        try {
            bucketResponse = this.bucketService.create(new BucketRequest("nimesh1", "temporary", this.bucketUrl), accessToken);
            LOG.debug("Bucket response is: {}", bucketResponse);
        } catch (JsonProcessingException e) {
            LOG.error("While processing object to json . Exception is: {}", e);
        }
        return new ResponseEntity<BucketResponse>(bucketResponse, httpStatus);
    }
}
