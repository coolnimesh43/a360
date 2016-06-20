package org.coolnimesh.a360.api;

import java.net.URISyntaxException;

import org.coolnimesh.a360.pojo.AccessTokenRequest;
import org.coolnimesh.a360.pojo.AccessTokenResponse;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface AuthService {

    public AccessTokenResponse getAccessToken(AccessTokenRequest accessTokenRequest) throws RestClientException, URISyntaxException,
            JsonProcessingException;
}
