package org.coolnimesh.a360.api.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.coolnimesh.a360.api.BucketService;
import org.coolnimesh.a360.pojo.BucketRequest;
import org.coolnimesh.a360.pojo.BucketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BucketServiceImpl implements BucketService {

    private static final Logger LOG = LogManager.getLogger(BucketServiceImpl.class);
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public BucketResponse create(BucketRequest bucketRequest, String accessToken) throws JsonProcessingException {
        LOG.debug("Inside BucketServiceImpl#create method. Request is: {}", bucketRequest);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", "Bearer " + accessToken);

        String params = new ObjectMapper().writeValueAsString(bucketRequest);
        HttpEntity<String> entity = new HttpEntity<String>(params, headers);
        ResponseEntity<BucketResponse> bucketResponse =
                this.restTemplate.exchange(bucketRequest.getBucketURL(), HttpMethod.POST, entity, BucketResponse.class);
        return bucketResponse.getBody();
    }
}
