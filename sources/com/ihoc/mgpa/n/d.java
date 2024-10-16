package com.ihoc.mgpa.n;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes2.dex */
public class d {

    /* loaded from: classes2.dex */
    public enum a {
        PATTERN1("yyyy_MM_dd_HH_mm_ss"),
        PATTERN2("yyyy-MM-dd HH:mm:ss"),
        PATTERN3("yyyy-MM-dd HH:mm:ss.SSS");

        private String e;

        a(String str) {
            this.e = str;
        }

        public String getFormat() {
            return this.e;
        }
    }

    public static String a() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String a(long j, String str) {
        return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j));
    }

    public static String a(String str) {
        return new SimpleDateFormat(str, Locale.CHINA).format(new Date());
    }

    public static String b() {
        return String.valueOf(System.currentTimeMillis());
    }
}
