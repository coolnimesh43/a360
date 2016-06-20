package org.coolnimesh.a360.pojo;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessTokenRequest {

    @JsonProperty("client_id")
    @NotNull
    private String clientId;

    @JsonProperty("client_secret")
    @NotNull
    private String clientSecret;

    @JsonProperty("grant_type")
    @NotNull
    private String grantType;

    @JsonIgnore
    @NotNull
    private String authURL;

    public AccessTokenRequest() {
        super();
    }

    public AccessTokenRequest(String clientId, String clientSecret, String grantType, String authURL) {
        super();
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.grantType = grantType;
        this.authURL = authURL;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getAuthURL() {
        return authURL;
    }

    public void setAuthURL(String authURL) {
        this.authURL = authURL;
    }

    @Override
    public String toString() {
        return "AccessTokenRequest [clientId=" + clientId + ", clientSecret=" + clientSecret + ", grantType=" + grantType + "]";
    }

}
