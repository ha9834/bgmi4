package com.nostra13.universalimageloader.core.download;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* loaded from: classes2.dex */
public interface ImageDownloader {
    InputStream a(String str, Object obj) throws IOException;

    /* loaded from: classes2.dex */
    public enum Scheme {
        HTTP("http"),
        HTTPS("https"),
        FILE(TransferTable.COLUMN_FILE),
        CONTENT(FirebaseAnalytics.Param.CONTENT),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN("");

        private String scheme;
        private String uriPrefix;

        Scheme(String str) {
            this.scheme = str;
            this.uriPrefix = str + "://";
        }

        public static Scheme a(String str) {
            if (str != null) {
                for (Scheme scheme : values()) {
                    if (scheme.d(str)) {
                        return scheme;
                    }
                }
            }
            return UNKNOWN;
        }

        private boolean d(String str) {
            return str.toLowerCase(Locale.US).startsWith(this.uriPrefix);
        }

        public String b(String str) {
            return this.uriPrefix + str;
        }

        public String c(String str) {
            if (!d(str)) {
                throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.scheme));
            }
            return str.substring(this.uriPrefix.length());
        }
    }
}
