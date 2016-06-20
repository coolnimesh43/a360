package org.coolnimesh.a360.api.impl;

import java.net.URISyntaxException;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.coolnimesh.a360.api.AuthService;
import org.coolnimesh.a360.pojo.AccessTokenRequest;
import org.coolnimesh.a360.pojo.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class AuthServiceImpl implements AuthService {

    private static final Logger LOG = LogManager.getLogger(AuthServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public AccessTokenResponse getAccessToken(@Valid AccessTokenRequest accessTokenRequest) throws RestClientException, URISyntaxException,
            JsonProcessingException {
        LOG.debug("Inside AuthServiceImpl#getAccessToken method. Access token is: {}", accessTokenRequest);
        MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
        header.add("Content-Type", "application/x-www-form-urlencoded");
        String params =
                new StringBuilder("client_id=").append(accessTokenRequest.getClientId()).append("&client_secret=")
                        .append(accessTokenRequest.getClientSecret()).append("&grant_type=").append("client_credentials").toString();
        HttpEntity<String> entity = new HttpEntity<String>(params, header);
        ResponseEntity<AccessTokenResponse> response =
                this.restTemplate.exchange(accessTokenRequest.getAuthURL(), HttpMethod.POST, entity, AccessTokenResponse.class);
        return response.getBody();
    }
}
