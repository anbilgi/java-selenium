
package com.twitter.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Headers {

    @SerializedName("Referer")
    @Expose
    private String referer;
    @SerializedName("User-Agent")
    @Expose
    private String userAgent;
    @SerializedName("authorization")
    @Expose
    private String authorization;
    @SerializedName("content-type")
    @Expose
    private String contentType;
    @SerializedName("x-csrf-token")
    @Expose
    private String xCsrfToken;
    @SerializedName("x-twitter-active-user")
    @Expose
    private String xTwitterActiveUser;
    @SerializedName("x-twitter-auth-type")
    @Expose
    private String xTwitterAuthType;
    @SerializedName("x-twitter-client-language")
    @Expose
    private String xTwitterClientLanguage;

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getXCsrfToken() {
        return xCsrfToken;
    }

    public void setXCsrfToken(String xCsrfToken) {
        this.xCsrfToken = xCsrfToken;
    }

    public String getXTwitterActiveUser() {
        return xTwitterActiveUser;
    }

    public void setXTwitterActiveUser(String xTwitterActiveUser) {
        this.xTwitterActiveUser = xTwitterActiveUser;
    }

    public String getXTwitterAuthType() {
        return xTwitterAuthType;
    }

    public void setXTwitterAuthType(String xTwitterAuthType) {
        this.xTwitterAuthType = xTwitterAuthType;
    }

    public String getXTwitterClientLanguage() {
        return xTwitterClientLanguage;
    }

    public void setXTwitterClientLanguage(String xTwitterClientLanguage) {
        this.xTwitterClientLanguage = xTwitterClientLanguage;
    }

}
