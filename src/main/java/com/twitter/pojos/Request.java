
package com.twitter.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("hasPostData")
    @Expose
    private Boolean hasPostData;
    @SerializedName("headers")
    @Expose
    private Headers headers;
    @SerializedName("initialPriority")
    @Expose
    private String initialPriority;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("mixedContentType")
    @Expose
    private String mixedContentType;
    @SerializedName("postData")
    @Expose
    private String postData;
    @SerializedName("referrerPolicy")
    @Expose
    private String referrerPolicy;
    @SerializedName("url")
    @Expose
    private String url;

    public Boolean getHasPostData() {
        return hasPostData;
    }

    public void setHasPostData(Boolean hasPostData) {
        this.hasPostData = hasPostData;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public String getInitialPriority() {
        return initialPriority;
    }

    public void setInitialPriority(String initialPriority) {
        this.initialPriority = initialPriority;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMixedContentType() {
        return mixedContentType;
    }

    public void setMixedContentType(String mixedContentType) {
        this.mixedContentType = mixedContentType;
    }

    public String getPostData() {
        return postData;
    }

    public void setPostData(String postData) {
        this.postData = postData;
    }

    public String getReferrerPolicy() {
        return referrerPolicy;
    }

    public void setReferrerPolicy(String referrerPolicy) {
        this.referrerPolicy = referrerPolicy;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
