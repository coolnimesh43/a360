package org.coolnimesh.a360.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BucketRequest {

    @JsonProperty("bucketKey")
    private String bucketKey;

    @JsonProperty("policy")
    private String policy;

    @JsonIgnore
    private String bucketURL;

    public BucketRequest() {
        super();
    }

    public BucketRequest(String bucketKey, String policy, String bucketURL) {
        super();
        this.bucketKey = bucketKey;
        this.policy = policy;
        this.bucketURL = bucketURL;
    }

    public String getBucketKey() {
        return bucketKey;
    }

    public void setBucketKey(String bucketKey) {
        this.bucketKey = bucketKey;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getBucketURL() {
        return bucketURL;
    }

    public void setBucketURL(String bucketURL) {
        this.bucketURL = bucketURL;
    }

    @Override
    public String toString() {
        return "BucketRequest [bucketKey=" + bucketKey + ", policy=" + policy + "]";
    }

}
