package com.tencent.grobot.lite.network.access;

import android.util.Pair;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class AccessRequest {
    byte[] body;
    ArrayList<Pair<String, String>> headers = new ArrayList<>();
    String method;
    int requestId;
    Object tag;

    public int getRequestId() {
        return this.requestId;
    }

    public String getMethod() {
        return this.method;
    }

    public ArrayList<Pair<String, String>> getHeaders() {
        return this.headers;
    }

    public byte[] getBody() {
        return this.body;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        AccessRequest accessRequest = new AccessRequest();

        public Builder() {
            this.accessRequest.method = "POST";
        }

        public Builder requestId(int i) {
            this.accessRequest.requestId = i;
            return this;
        }

        public Builder post(byte[] bArr) {
            return method("POST", bArr);
        }

        public Builder method(String str, byte[] bArr) {
            if (str == null) {
                throw new NullPointerException("method is required.");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            AccessRequest accessRequest = this.accessRequest;
            accessRequest.method = str;
            accessRequest.body = bArr;
            return this;
        }

        public Builder addHeader(String str, String str2) {
            this.accessRequest.headers.add(new Pair<>(str, str2));
            return this;
        }

        public Builder tag(Object obj) {
            this.accessRequest.tag = obj;
            return this;
        }

        public AccessRequest build() {
            return this.accessRequest;
        }
    }
}
