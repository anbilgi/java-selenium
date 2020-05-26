
package com.twitter.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stack {

    @SerializedName("callFrames")
    @Expose
    private List<CallFrame> callFrames = null;

    public List<CallFrame> getCallFrames() {
        return callFrames;
    }

    public void setCallFrames(List<CallFrame> callFrames) {
        this.callFrames = callFrames;
    }

}
