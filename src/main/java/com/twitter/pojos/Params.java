
package com.twitter.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Params {

    @SerializedName("documentURL")
    @Expose
    private String documentURL;
    @SerializedName("frameId")
    @Expose
    private String frameId;
    @SerializedName("hasUserGesture")
    @Expose
    private Boolean hasUserGesture;
    @SerializedName("initiator")
    @Expose
    private Initiator initiator;
    @SerializedName("loaderId")
    @Expose
    private String loaderId;
    @SerializedName("request")
    @Expose
    private Request request;
    @SerializedName("requestId")
    @Expose
    private String requestId;
    @SerializedName("timestamp")
    @Expose
    private Double timestamp;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("wallTime")
    @Expose
    private Double wallTime;

    public String getDocumentURL() {
        return documentURL;
    }

    public void setDocumentURL(String documentURL) {
        this.documentURL = documentURL;
    }

    public String getFrameId() {
        return frameId;
    }

    public void setFrameId(String frameId) {
        this.frameId = frameId;
    }

    public Boolean getHasUserGesture() {
        return hasUserGesture;
    }

    public void setHasUserGesture(Boolean hasUserGesture) {
        this.hasUserGesture = hasUserGesture;
    }

    public Initiator getInitiator() {
        return initiator;
    }

    public void setInitiator(Initiator initiator) {
        this.initiator = initiator;
    }

    public String getLoaderId() {
        return loaderId;
    }

    public void setLoaderId(String loaderId) {
        this.loaderId = loaderId;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getWallTime() {
        return wallTime;
    }

    public void setWallTime(Double wallTime) {
        this.wallTime = wallTime;
    }

}
