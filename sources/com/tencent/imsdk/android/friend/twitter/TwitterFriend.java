package com.tencent.imsdk.android.friend.twitter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Patterns;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.relation.IMSDKFriendReqInfo;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.relation.IMSDKFriendBase;
import com.tencent.imsdk.android.friend.IMSDKFileProvider;
import com.tencent.imsdk.android.friend.twitter.TweetComposer;
import com.tencent.imsdk.android.tools.DeviceUtils;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes.dex */
public class TwitterFriend extends IMSDKFriendBase {
    private static final String TWITTER_CHANNEL_ID = "35";

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public String getChannelId() {
        return TWITTER_CHANNEL_ID;
    }

    public TwitterFriend(Context context) {
        super(context);
        if (context != null) {
            this.mSTBuilder = new InnerStat.Builder(context.getApplicationContext(), "2.5.1", "2.5.1");
        }
    }

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public void invite(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        retByIMSDK(7, 7, "twitter invite not support!!", iMSDKResultListener);
    }

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public void sendMessage(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        retByIMSDK(7, 7, "twitter sendMessage not support!!", iMSDKResultListener);
    }

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public void share(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        IMLogger.d("twitterFriend share begin");
        if (iMSDKFriendReqInfo != null) {
            IMLogger.d("twitterFriend share info : " + iMSDKFriendReqInfo);
            int i = iMSDKFriendReqInfo.type;
            if (i == 0 || i == 2 || i == 4) {
                retByIMSDK(7, 7, "no support for share type : " + iMSDKFriendReqInfo.type, iMSDKResultListener);
                return;
            }
            if (DeviceUtils.isAppInstalled(this.mCurCtx, "com.twitter.android") && !T.ckIsEmpty(iMSDKFriendReqInfo.imagePath)) {
                IMLogger.d("twitter app is installed ! ");
                if (Patterns.WEB_URL.matcher(iMSDKFriendReqInfo.imagePath).matches()) {
                    downloadImage(iMSDKFriendReqInfo, iMSDKResultListener);
                    return;
                } else {
                    composeTwitter(iMSDKFriendReqInfo.content, iMSDKFriendReqInfo.link, IMSDKFileProvider.getUriFromPath(this.mCurCtx, iMSDKFriendReqInfo.imagePath), iMSDKResultListener);
                    return;
                }
            }
            IMLogger.d("twitter app is not installed or image path is empty, send without image !");
            composeTwitter(iMSDKFriendReqInfo.content, iMSDKFriendReqInfo.link, null, iMSDKResultListener);
            return;
        }
        IMLogger.w("twitter share req info is null", new Object[0]);
        retByIMSDK(11, 11, "twitter share req info is null!!", iMSDKResultListener);
    }

    private void downloadImage(final IMSDKFriendReqInfo iMSDKFriendReqInfo, final IMSDKResultListener iMSDKResultListener) {
        handleBitmapPath(iMSDKFriendReqInfo.imagePath, new IMSDKListener<Bitmap>() { // from class: com.tencent.imsdk.android.friend.twitter.TwitterFriend.1
            @Override // com.tencent.imsdk.android.base.IMSDKListener
            public void onNotify(Bitmap bitmap) {
                TwitterFriend.this.processNetworkImage(bitmap, iMSDKFriendReqInfo, iMSDKResultListener);
            }

            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                iMSDKResultListener.onResult(iMSDKResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.graphics.Bitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void processNetworkImage(android.graphics.Bitmap r7, com.tencent.imsdk.android.api.relation.IMSDKFriendReqInfo r8, com.tencent.imsdk.android.api.IMSDKResultListener r9) {
        /*
            r6 = this;
            android.content.Context r0 = r6.mCurCtx
            r1 = 0
            if (r0 == 0) goto Lbf
            android.content.Context r0 = r6.mCurCtx
            java.io.File r0 = r0.getExternalCacheDir()
            if (r0 == 0) goto Lbf
            java.lang.String r0 = r0.getPath()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            long r3 = java.lang.System.currentTimeMillis()
            r2.append(r3)
            java.lang.String r3 = ".jpg"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.io.File r3 = new java.io.File
            r3.<init>(r0, r2)
            r0 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L9c
            r5 = 90
            boolean r7 = r7.compress(r4, r5, r2)     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L9c
            if (r7 == 0) goto L46
            android.content.Context r7 = r6.mCurCtx     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L9c
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L9c
            android.net.Uri r1 = com.tencent.imsdk.android.friend.IMSDKFileProvider.getUriFromPath(r7, r3)     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L9c
            goto L4d
        L46:
            java.lang.String r7 = "bitmap compress save error, exec share without image!"
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L9c
            com.tencent.imsdk.android.tools.log.IMLogger.w(r7, r3)     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L9c
        L4d:
            r2.close()     // Catch: java.lang.Exception -> L52
            goto Lbf
        L52:
            r7 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
        L58:
            java.lang.String r3 = "bitmap compress FileOutputStream close exception, msg ="
            r2.append(r3)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.tencent.imsdk.android.tools.log.IMLogger.e(r7, r0)
            goto Lbf
        L6e:
            r7 = move-exception
            goto L75
        L70:
            r7 = move-exception
            r2 = r1
            goto L9d
        L73:
            r7 = move-exception
            r2 = r1
        L75:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c
            r3.<init>()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r4 = "bitmap compress io exception, msg ="
            r3.append(r4)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Throwable -> L9c
            r3.append(r7)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r7 = r3.toString()     // Catch: java.lang.Throwable -> L9c
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L9c
            com.tencent.imsdk.android.tools.log.IMLogger.e(r7, r3)     // Catch: java.lang.Throwable -> L9c
            if (r2 == 0) goto Lbf
            r2.close()     // Catch: java.lang.Exception -> L95
            goto Lbf
        L95:
            r7 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            goto L58
        L9c:
            r7 = move-exception
        L9d:
            if (r2 == 0) goto Lbe
            r2.close()     // Catch: java.lang.Exception -> La3
            goto Lbe
        La3:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "bitmap compress FileOutputStream close exception, msg ="
            r9.append(r1)
            java.lang.String r8 = r8.getMessage()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            java.lang.Object[] r9 = new java.lang.Object[r0]
            com.tencent.imsdk.android.tools.log.IMLogger.e(r8, r9)
        Lbe:
            throw r7
        Lbf:
            java.lang.String r7 = r8.content
            java.lang.String r8 = r8.link
            r6.composeTwitter(r7, r8, r1, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.friend.twitter.TwitterFriend.processNetworkImage(android.graphics.Bitmap, com.tencent.imsdk.android.api.relation.IMSDKFriendReqInfo, com.tencent.imsdk.android.api.IMSDKResultListener):void");
    }

    private void composeTwitter(String str, String str2, Uri uri, IMSDKResultListener iMSDKResultListener) {
        boolean z;
        if (T.mGlobalActivityUpToDate != null) {
            TweetComposer.Builder builder = new TweetComposer.Builder(T.mGlobalActivityUpToDate);
            builder.type(0);
            if (T.ckIsEmpty(str)) {
                z = false;
            } else {
                builder.text(str);
                z = true;
            }
            if (!T.ckIsEmpty(str2)) {
                try {
                    builder.url(new URL(str2));
                    z = true;
                } catch (MalformedURLException e) {
                    IMLogger.e("link to url error, msg = " + e.getMessage(), new Object[0]);
                }
            }
            if (uri != null) {
                builder.image(uri);
                z = true;
            }
            if (z) {
                builder.show();
                iMSDKResultListener.onResult(new IMSDKResult(1, 1));
                return;
            } else {
                retByIMSDK(11, 11, "twitter composeTwitter data not set!!", iMSDKResultListener);
                return;
            }
        }
        retByIMSDK(3, 3, "twitter composeTwitter context is null!!", iMSDKResultListener);
    }

    private void retByIMSDK(int i, int i2, String str, IMSDKResultListener iMSDKResultListener) {
        iMSDKResultListener.onResult(new IMSDKResult(i, i2, str));
    }
}
