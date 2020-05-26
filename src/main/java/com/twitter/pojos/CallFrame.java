
package com.twitter.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CallFrame {

    @SerializedName("columnNumber")
    @Expose
    private Integer columnNumber;
    @SerializedName("functionName")
    @Expose
    private String functionName;
    @SerializedName("lineNumber")
    @Expose
    private Integer lineNumber;
    @SerializedName("scriptId")
    @Expose
    private String scriptId;
    @SerializedName("url")
    @Expose
    private String url;

    public Integer getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(Integer columnNumber) {
        this.columnNumber = columnNumber;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getScriptId() {
        return scriptId;
    }

    public void setScriptId(String scriptId) {
        this.scriptId = scriptId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
