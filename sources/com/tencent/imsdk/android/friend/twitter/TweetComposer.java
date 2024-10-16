package com.tencent.imsdk.android.friend.twitter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public class TweetComposer {
    private static final String MIME_TYPE_JPEG = "image/jpeg";
    private static final String MIME_TYPE_PLAIN_TEXT = "text/plain";
    private static final String TWITTER_PACKAGE_NAME = "com.twitter.android";
    private static final String TWITTER_SEND_ACTIVITY = "com.twitter.app.dm.DMActivity";
    private static final String TWITTER_SHARE_ACTIVITY = "com.twitter.composer.ComposerActivity";
    private static final String WEB_INTENT = "https://twitter.com/intent/tweet?text=%s&url=%s";

    @SuppressLint({"StaticFieldLeak"})
    static volatile TweetComposer instance;

    public String getVersion() {
        return "2.5.1.17";
    }

    public static TweetComposer getInstance() {
        if (instance == null) {
            synchronized (TweetComposer.class) {
                if (instance == null) {
                    instance = new TweetComposer();
                }
            }
        }
        return instance;
    }

    TweetComposer() {
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public static final int TYPE_SEND = 1;
        public static final int TYPE_SHARE = 0;
        private final Context context;
        private Uri imageUri;
        private String text;
        private int type = 0;
        private URL url;

        public Builder(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.context = context;
        }

        public Builder type(int i) {
            if (i == 0) {
                this.type = 0;
            } else {
                this.type = 1;
            }
            return this;
        }

        public Builder text(String str) {
            if (str == null) {
                throw new IllegalArgumentException("text must not be null.");
            }
            if (this.text != null) {
                throw new IllegalStateException("text already set.");
            }
            this.text = str;
            return this;
        }

        public Builder url(URL url) {
            if (url == null) {
                throw new IllegalArgumentException("url must not be null.");
            }
            if (this.url != null) {
                throw new IllegalStateException("url already set.");
            }
            this.url = url;
            return this;
        }

        public Builder image(Uri uri) {
            if (uri == null) {
                throw new IllegalArgumentException("imageUri must not be null.");
            }
            if (this.imageUri != null) {
                throw new IllegalStateException("imageUri already set.");
            }
            this.imageUri = uri;
            return this;
        }

        public Intent createIntent(int i) {
            Intent createTwitterIntent = createTwitterIntent(i);
            return createTwitterIntent == null ? createWebIntent() : createTwitterIntent;
        }

        Intent createTwitterIntent(int i) {
            Intent intent = new Intent("android.intent.action.SEND");
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.text)) {
                sb.append(this.text);
            }
            if (this.url != null) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(this.url.toString());
            }
            intent.putExtra("android.intent.extra.TEXT", sb.toString());
            intent.setType(TweetComposer.MIME_TYPE_PLAIN_TEXT);
            Uri uri = this.imageUri;
            if (uri != null) {
                intent.putExtra("android.intent.extra.STREAM", uri);
                intent.setType(TweetComposer.MIME_TYPE_JPEG);
            }
            for (ResolveInfo resolveInfo : this.context.getPackageManager().queryIntentActivities(intent, 65536)) {
                if (resolveInfo.activityInfo.packageName.startsWith(TweetComposer.TWITTER_PACKAGE_NAME)) {
                    String str = TweetComposer.TWITTER_SHARE_ACTIVITY;
                    if (i == 0) {
                        str = TweetComposer.TWITTER_SHARE_ACTIVITY;
                    } else if (i == 1) {
                        str = TweetComposer.TWITTER_SEND_ACTIVITY;
                    }
                    if (str.equals(resolveInfo.activityInfo.name)) {
                        intent.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                        return intent;
                    }
                }
            }
            return null;
        }

        Intent createWebIntent() {
            try {
                return new Intent("android.intent.action.VIEW", Uri.parse(String.format(TweetComposer.WEB_INTENT, URLEncoder.encode(this.text, "UTF-8"), URLEncoder.encode(this.url == null ? "" : this.url.toString(), "UTF-8"))));
            } catch (Exception unused) {
                return null;
            }
        }

        public void show() {
            this.context.startActivity(createIntent(this.type));
        }
    }
}
