package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.services.s3.AmazonS3;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
class S3ClientReference {
    private static Map<String, AmazonS3> map = new ConcurrentHashMap();

    S3ClientReference() {
    }

    public static void put(String str, AmazonS3 amazonS3) {
        map.put(str, amazonS3);
    }

    public static AmazonS3 get(String str) {
        return map.remove(str);
    }

    public static void clear() {
        map.clear();
    }
}
