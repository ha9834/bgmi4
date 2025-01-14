package com.facebook.bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class AppLink {
    private Uri sourceUrl;
    private List<Target> targets;
    private Uri webUrl;

    /* loaded from: classes.dex */
    public static class Target {
        private final String appName;
        private final String className;
        private final String packageName;
        private final Uri url;

        public Target(String str, String str2, Uri uri, String str3) {
            this.packageName = str;
            this.className = str2;
            this.url = uri;
            this.appName = str3;
        }

        public Uri getUrl() {
            return this.url;
        }

        public String getAppName() {
            return this.appName;
        }

        public String getClassName() {
            return this.className;
        }

        public String getPackageName() {
            return this.packageName;
        }
    }

    public AppLink(Uri uri, List<Target> list, Uri uri2) {
        this.sourceUrl = uri;
        this.targets = list == null ? Collections.emptyList() : list;
        this.webUrl = uri2;
    }
}
