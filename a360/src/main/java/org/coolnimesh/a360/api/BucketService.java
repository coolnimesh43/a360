package org.coolnimesh.a360.api;

import org.coolnimesh.a360.pojo.BucketRequest;
import org.coolnimesh.a360.pojo.BucketResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface BucketService {

    public BucketResponse create(BucketRequest bucketRequest, String accessToken) throws JsonProcessingException;
}
