package com.tencent.imsdk.android.friend.vk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.common.IMSDKLaunchResult;
import com.tencent.imsdk.android.api.relation.IMSDKFriendReqInfo;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.IMSDKProxyActivity;
import com.tencent.imsdk.android.base.interfaces.ILauncher;
import com.tencent.imsdk.android.base.relation.IMSDKFriendBase;
import com.tencent.imsdk.android.tools.DeviceUtils;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.imsdk.android.tools.net.IMSDKHttpClient;
import com.tencent.imsdk.android.vk.IMSDKFileProvider;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class VKIntentBase extends IMSDKFriendBase implements ILauncher {
    private static final String VK_PACKAGE_NAME = "com.vkontakte.android";
    private IMSDKHttpClient mHttpClient;

    public VKIntentBase(Context context) {
        super(context);
        if (context != null) {
            this.mHttpClient = new IMSDKHttpClient(context);
        }
    }

    protected boolean isAppInstalled() {
        return DeviceUtils.isAppInstalled(this.mCurCtx, "com.vkontakte.android");
    }

    private Intent getVKIntent(Context context, String str, IMSDKFriendReqInfo iMSDKFriendReqInfo) {
        Uri uriFromPath;
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(str);
        String str2 = (iMSDKFriendReqInfo.content == null || iMSDKFriendReqInfo.content.length() <= 0) ? null : iMSDKFriendReqInfo.content;
        if (iMSDKFriendReqInfo.link != null && iMSDKFriendReqInfo.link.length() > 0) {
            str2 = str2 + "" + iMSDKFriendReqInfo.link;
        }
        intent.putExtra("android.intent.extra.TEXT", str2);
        if (iMSDKFriendReqInfo.imagePath != null && (uriFromPath = IMSDKFileProvider.getUriFromPath(this.mCurCtx, iMSDKFriendReqInfo.imagePath)) != null) {
            IMLogger.d("imagePath is : " + iMSDKFriendReqInfo.imagePath + " and uri is : " + uriFromPath);
            intent.putExtra("android.intent.extra.STREAM", uriFromPath);
            intent.addFlags(1);
        }
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            if (resolveInfo.activityInfo.packageName.startsWith("com.vkontakte.android")) {
                intent.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            }
        }
        intent.putExtra("com.vkontakte.android.EXTRA_FROM_DIRECT_SHARE", true);
        return intent;
    }

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public void invite(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        retByIMSDK(7, 7, getChannelId() + " invite not support by default", iMSDKResultListener);
    }

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public void share(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        sendIntent(iMSDKFriendReqInfo, iMSDKResultListener, objArr);
    }

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public void sendMessage(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        sendIntent(iMSDKFriendReqInfo, iMSDKResultListener, objArr);
    }

    protected void sendTextIntent(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKListener<Intent> iMSDKListener, Object... objArr) {
        if (T.ckIsEmpty(iMSDKFriendReqInfo.content)) {
            retByIMSDK(11, 11, "content is empty", iMSDKListener);
        } else {
            iMSDKListener.onNotify(getVKIntent(this.mCurCtx, "text/plain", iMSDKFriendReqInfo));
        }
    }

    protected void sendLinkIntent(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKListener<Intent> iMSDKListener, Object... objArr) {
        if (T.ckIsEmpty(iMSDKFriendReqInfo.link)) {
            retByIMSDK(11, 11, "link is empty", iMSDKListener);
        } else {
            iMSDKListener.onNotify(getVKIntent(this.mCurCtx, "text/plain", iMSDKFriendReqInfo));
        }
    }

    protected void sendImageIntent(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKListener<Intent> iMSDKListener, Object... objArr) {
        if (T.ckIsEmpty(iMSDKFriendReqInfo.imagePath)) {
            retByIMSDK(11, 11, "image path is empty", iMSDKListener);
            return;
        }
        if (IMSDKFileProvider.getUriFromPath(this.mCurCtx, iMSDKFriendReqInfo.imagePath) == null) {
            retByIMSDK(11, 11, "image not exists " + iMSDKFriendReqInfo.imagePath, iMSDKListener);
            return;
        }
        iMSDKListener.onNotify(getVKIntent(this.mCurCtx, "image/*", iMSDKFriendReqInfo));
    }

    protected void sendNetImageIntent(final IMSDKFriendReqInfo iMSDKFriendReqInfo, final IMSDKListener<Intent> iMSDKListener, Object... objArr) {
        if (this.mHttpClient == null) {
            retByIMSDK(17, 17, "need init", iMSDKListener);
        } else if (T.ckIsEmpty(iMSDKFriendReqInfo.imagePath)) {
            retByIMSDK(11, 11, "image path is empty", iMSDKListener);
        } else {
            this.mHttpClient.get(iMSDKFriendReqInfo.imagePath, new IMSDKListener<byte[]>() { // from class: com.tencent.imsdk.android.friend.vk.VKIntentBase.1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.String] */
                /* JADX WARN: Type inference failed for: r0v18, types: [com.tencent.imsdk.android.api.relation.IMSDKFriendReqInfo] */
                /* JADX WARN: Type inference failed for: r5v17, types: [com.tencent.imsdk.android.friend.vk.VKIntentBase] */
                @Override // com.tencent.imsdk.android.base.IMSDKListener
                public void onNotify(byte[] bArr) {
                    ByteArrayInputStream byteArrayInputStream;
                    StringBuilder sb;
                    ByteArrayInputStream byteArrayInputStream2;
                    ByteArrayInputStream byteArrayInputStream3 = null;
                    ByteArrayInputStream byteArrayInputStream4 = null;
                    try {
                        try {
                            byteArrayInputStream = new ByteArrayInputStream(bArr);
                        } catch (Throwable th) {
                            th = th;
                            byteArrayInputStream = byteArrayInputStream3;
                        }
                    } catch (Exception e) {
                        e = e;
                    }
                    try {
                        String saveImage = VKIntentBase.this.saveImage(BitmapFactory.decodeStream(byteArrayInputStream));
                        IMLogger.d("sendNetImageIntent path = " + saveImage);
                        if (!T.ckIsEmpty(saveImage)) {
                            iMSDKFriendReqInfo.imagePath = saveImage;
                            ?? r5 = VKIntentBase.this;
                            ?? r0 = iMSDKFriendReqInfo;
                            r5.sendImageIntent(r0, iMSDKListener, new Object[0]);
                            byteArrayInputStream2 = r0;
                        } else {
                            VKIntentBase.this.retByIMSDK(8, 8, "save net image file failed", iMSDKListener);
                            byteArrayInputStream2 = "save net image file failed";
                        }
                        try {
                            byteArrayInputStream.close();
                            byteArrayInputStream3 = byteArrayInputStream2;
                        } catch (Exception e2) {
                            e = e2;
                            sb = new StringBuilder();
                            sb.append("sendNetImageIntent exception = ");
                            sb.append(e.getMessage());
                            IMLogger.d(sb.toString());
                        }
                    } catch (Exception e3) {
                        e = e3;
                        byteArrayInputStream4 = byteArrayInputStream;
                        IMLogger.d("sendNetImageIntent exception = " + e.getMessage());
                        byteArrayInputStream3 = byteArrayInputStream4;
                        if (byteArrayInputStream4 != null) {
                            try {
                                byteArrayInputStream4.close();
                                byteArrayInputStream3 = byteArrayInputStream4;
                            } catch (Exception e4) {
                                e = e4;
                                sb = new StringBuilder();
                                sb.append("sendNetImageIntent exception = ");
                                sb.append(e.getMessage());
                                IMLogger.d(sb.toString());
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception e5) {
                                IMLogger.d("sendNetImageIntent exception = " + e5.getMessage());
                            }
                        }
                        throw th;
                    }
                }

                @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                public void onResult(IMSDKResult iMSDKResult) {
                    iMSDKListener.onResult(iMSDKResult);
                }
            });
        }
    }

    protected void sendIntent(final IMSDKFriendReqInfo iMSDKFriendReqInfo, final IMSDKResultListener iMSDKResultListener, Object... objArr) {
        if (iMSDKFriendReqInfo == null) {
            retByIMSDK(11, 11, "info is null", iMSDKResultListener);
            return;
        }
        if (!isAppInstalled()) {
            retByIMSDK(15, 15, "need install app", iMSDKResultListener);
            return;
        }
        IMSDKListener<Intent> iMSDKListener = new IMSDKListener<Intent>() { // from class: com.tencent.imsdk.android.friend.vk.VKIntentBase.2
            @Override // com.tencent.imsdk.android.base.IMSDKListener
            public void onNotify(final Intent intent) {
                if (intent != null) {
                    if (VKIntentBase.this.mCurCtx != null) {
                        IMSDKProxyActivity.registerLifeCycle(VKIntentBase.this.mCurCtx, new IMSDKProxyActivity.LifeCycleCallback() { // from class: com.tencent.imsdk.android.friend.vk.VKIntentBase.2.1
                            static final int REQUEST_CODE = 36864;
                            boolean mCallbackFlag = false;

                            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                            protected void onActivityCreate(Bundle bundle, Activity activity) {
                                this.mCallbackFlag = false;
                                try {
                                    activity.startActivityForResult(intent, REQUEST_CODE);
                                } catch (Exception e) {
                                    IMLogger.w("catch exception : " + e.getMessage(), new Object[0]);
                                    activity.finish();
                                }
                            }

                            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                            protected boolean onActivityResult(int i, int i2, Intent intent2) {
                                if (i == REQUEST_CODE) {
                                    if (iMSDKResultListener == null) {
                                        this.mCallbackFlag = true;
                                    } else if (i2 == -1) {
                                        iMSDKResultListener.onResult(new IMSDKResult(1, 1));
                                        this.mCallbackFlag = true;
                                    } else if (i2 == 0) {
                                        iMSDKResultListener.onResult(new IMSDKResult(2, 2));
                                        this.mCallbackFlag = true;
                                    } else {
                                        iMSDKResultListener.onResult(new IMSDKResult(3, i2, "activity result : " + i2));
                                        this.mCallbackFlag = true;
                                    }
                                }
                                return true;
                            }

                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                            public void onActivityDestroy() {
                                super.onActivityDestroy();
                                if (this.mCallbackFlag) {
                                    return;
                                }
                                if (iMSDKResultListener != null) {
                                    iMSDKResultListener.onResult(new IMSDKResult(2, 2, "activity finished without callback !"));
                                }
                                this.mCallbackFlag = true;
                            }
                        });
                        return;
                    } else {
                        iMSDKResultListener.onResult(new IMSDKResult(17, 17));
                        return;
                    }
                }
                VKIntentBase.this.retByIMSDK(7, 7, "empty intent " + iMSDKFriendReqInfo.type, iMSDKResultListener);
            }

            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                IMSDKResultListener iMSDKResultListener2 = iMSDKResultListener;
                if (iMSDKResultListener2 != null) {
                    iMSDKResultListener2.onResult(iMSDKResult);
                }
            }
        };
        int i = iMSDKFriendReqInfo.type;
        if (i == 1) {
            sendTextIntent(iMSDKFriendReqInfo, iMSDKListener, new Object[0]);
            return;
        }
        if (i == 3) {
            sendLinkIntent(iMSDKFriendReqInfo, iMSDKListener, new Object[0]);
            return;
        }
        if (i == 5) {
            if (Patterns.WEB_URL.matcher(iMSDKFriendReqInfo.imagePath).matches()) {
                sendNetImageIntent(iMSDKFriendReqInfo, iMSDKListener, new Object[0]);
                return;
            } else {
                sendImageIntent(iMSDKFriendReqInfo, iMSDKListener, new Object[0]);
                return;
            }
        }
        retByIMSDK(7, 7, "no support type " + iMSDKFriendReqInfo.type, iMSDKResultListener);
    }

    protected void retByIMSDK(int i, int i2, String str, IMSDKResultListener iMSDKResultListener) {
        IMSDKResult iMSDKResult = new IMSDKResult(i, i2, str);
        if (iMSDKResultListener != null) {
            iMSDKResultListener.onResult(iMSDKResult);
        } else {
            IMLogger.w("callback listener is null", new Object[0]);
        }
    }

    public String saveImage(Bitmap bitmap) {
        File file;
        BufferedOutputStream bufferedOutputStream;
        if (this.mCurCtx == null) {
            IMLogger.d("need init");
            return "";
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                file = new File(this.mCurCtx.getExternalCacheDir().getPath(), "itop_tmp_" + System.currentTimeMillis() + ".png");
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            String absolutePath = file.getAbsolutePath();
            try {
                bufferedOutputStream.close();
            } catch (Exception e2) {
                IMLogger.d(" saveImage exception = " + e2.getMessage());
            }
            return absolutePath;
        } catch (Exception e3) {
            e = e3;
            bufferedOutputStream2 = bufferedOutputStream;
            IMLogger.d(" saveImage exception = " + e.getMessage());
            if (bufferedOutputStream2 == null) {
                return "";
            }
            try {
                bufferedOutputStream2.close();
                return "";
            } catch (Exception e4) {
                IMLogger.d(" saveImage exception = " + e4.getMessage());
                return "";
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (Exception e5) {
                    IMLogger.d(" saveImage exception = " + e5.getMessage());
                }
            }
            throw th;
        }
    }

    private String parseUri(Uri uri) {
        StringBuilder sb = new StringBuilder();
        sb.append("parseUri ");
        sb.append(uri == null ? "uri is null" : uri.toString());
        IMLogger.d(sb.toString());
        JSONObject jSONObject = new JSONObject();
        if (uri != null && uri.getQueryParameterNames() != null) {
            for (String str : uri.getQueryParameterNames()) {
                try {
                    jSONObject.put(str, uri.getQueryParameter(str));
                } catch (JSONException e) {
                    IMLogger.w("catch json exception : " + e.getMessage(), new Object[0]);
                }
            }
        }
        return jSONObject.toString();
    }

    @Override // com.tencent.imsdk.android.base.interfaces.ILauncher
    public void handleLaunchData(Intent intent, IMSDKResultListener<IMSDKLaunchResult> iMSDKResultListener) {
        IMLogger.d("Intent Friend: handleLaunchData");
        if (intent != null) {
            IMLogger.d(" handleLaunchData = " + intent.getData() + " intent = " + intent);
            Uri data = intent.getData();
            if (data != null) {
                IMSDKLaunchResult iMSDKLaunchResult = new IMSDKLaunchResult(1, 1);
                iMSDKLaunchResult.launchData = parseUri(data);
                iMSDKLaunchResult.launchUri = data.toString();
                iMSDKResultListener.onResult(iMSDKLaunchResult);
                return;
            }
            IMLogger.w("uri is null", new Object[0]);
            iMSDKResultListener.onResult(new IMSDKLaunchResult(11, 11, "uri is null"));
            return;
        }
        IMLogger.w("intent is null", new Object[0]);
        iMSDKResultListener.onResult(new IMSDKLaunchResult(11, 11, "intent is null"));
    }
}
