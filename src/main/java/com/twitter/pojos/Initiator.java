
package com.twitter.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Initiator {

    @SerializedName("stack")
    @Expose
    private Stack stack;
    @SerializedName("type")
    @Expose
    private String type;

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
