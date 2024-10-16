package com.tencent.midas.oversea.business.h5.url;

/* loaded from: classes.dex */
public class UrlFactory {
    public static IH5 create(String str) {
        if (((str.hashCode() == -580474298 && str.equals("h5_mall")) ? (char) 0 : (char) 65535) != 0) {
            return null;
        }
        return new H5Mall();
    }
}
