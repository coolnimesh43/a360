package org.coolnimesh.a360.controller;

import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.coolnimesh.a360.api.AuthService;
import org.coolnimesh.a360.pojo.AccessTokenRequest;
import org.coolnimesh.a360.pojo.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonProcessingException;

@Controller("/auth")
public class AuthController {

    private static final Logger LOG = LogManager.getLogger(AuthController.class);

    @Autowired
    @Qualifier(value = "authServiceImpl")
    private AuthService authService;

    @Value("${client-id}")
    private String clientId;

    @Value("${client-secret}")
    private String clientSecret;

    @Value("${auth-url}")
    private String authURL;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<AccessTokenResponse> getAccessToken() {
        LOG.debug("Inside AuthController #getAccessToken method.");
        AccessTokenRequest accessTokenRequest =
                new AccessTokenRequest(this.clientId, this.clientSecret, "client_credentials", this.authURL);
        AccessTokenResponse accessTokenResponse = null;
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        try {
            accessTokenResponse = this.authService.getAccessToken(accessTokenRequest);
            httpStatus = HttpStatus.OK;
            LOG.debug("Access token response is: {}", accessTokenResponse);
        } catch (RestClientException e) {
            LOG.error("Exception while getting access token. Exception is: {}", e);
        } catch (URISyntaxException e) {
            LOG.error("Exceptin while creating uri for access token url. Exception is: {}", e);
        } catch (JsonProcessingException e) {
            LOG.error("Exceptin while processing json. Exception is: {}", e);
        }

        return new ResponseEntity<AccessTokenResponse>(accessTokenResponse, httpStatus);
    }
}
