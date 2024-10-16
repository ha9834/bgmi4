package com.tencent.imsdk.android.friend.wechat;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.FileProvider;
import com.tencent.imsdk.android.WeChatHelper;
import com.tencent.imsdk.android.agent.wechat.WeChatAgentActivity;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.api.relation.IMSDKFriendReqInfo;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.relation.IMSDKFriendBase;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.MetaDataUtils;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.open.SocialConstants;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class WeChatFriend extends IMSDKFriendBase {
    private static final String IMSDK_WECHAT_FILE_PROVIDER = ".wechat.fileprovider";
    private static final String WECHAT_THUMB_SIZE = "IMSDK_WECHAT_THUMB_SIZE";
    private static final int WECHAT_THUMB_SIZE_DEFAULT = 100;
    private final String IMSDK_FILE_PROVIDER_FOLDER_NAME;
    private Context mCtx;
    private IWXAPI mWXApi;

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public String getChannelId() {
        return "4";
    }

    private void reportEvent(String str, String str2, String str3) {
        initWeChat(str, str2, str3);
    }

    private void initWeChat(String str, String str2, String str3) {
        if (this.mSTBuilder != null) {
            this.mSTBuilder.setMethod(str).setStage(str2).setResult(str3).create().reportEvent();
        }
    }

    public WeChatFriend(Context context) {
        super(context);
        this.IMSDK_FILE_PROVIDER_FOLDER_NAME = "wxShareData";
        this.mCtx = null;
        initWeChat(context);
    }

    private void initWeChat(Context context) {
        if (this.mCtx == null) {
            this.mCtx = context.getApplicationContext();
            this.mWXApi = WXAPIFactory.createWXAPI(context, MetaDataUtils.readFromApplication(this.mCtx, WeChatAgentActivity.WECHAT_APP_ID, ""));
            this.mSTBuilder = new InnerStat.Builder(context, "2.6.1");
        }
    }

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public void invite(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        if (iMSDKFriendReqInfo.type != 1 && iMSDKFriendReqInfo.type != 5 && iMSDKFriendReqInfo.type != 3) {
            iMSDKFriendReqInfo.type = 1;
        }
        handleWXMessage(true, iMSDKFriendReqInfo, iMSDKResultListener, objArr);
    }

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public void share(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        handleWXMessage(false, iMSDKFriendReqInfo, iMSDKResultListener, objArr);
    }

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public void sendMessage(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        handleWXMessage(true, iMSDKFriendReqInfo, iMSDKResultListener, objArr);
    }

    private String buildTransaction(String str) {
        if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        return str + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage2WX(boolean z, String str, WXMediaMessage wXMediaMessage, IMSDKResultListener iMSDKResultListener) {
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction(str);
        req.message = wXMediaMessage;
        req.scene = !z ? 1 : 0;
        if (this.mWXApi.sendReq(req)) {
            return;
        }
        if (iMSDKResultListener != null) {
            iMSDKResultListener.onResult(new IMSDKResult(9999, 0, "maybe picture more than 1920 * 1440"));
        }
        IMLogger.w("something wrong with wechat", new Object[0]);
        reportEvent("sendMessage2WX", "send message to wechat error", "error condition: isTimelineCb=" + z + ", transaction=" + str);
    }

    public static void setWeChatCallback(final IMSDKResultListener iMSDKResultListener) {
        WeChatAgentActivity.mWeChatMessagesQueue.put(2, new IWXAPIEventHandler() { // from class: com.tencent.imsdk.android.friend.wechat.WeChatFriend.1
            public void onReq(BaseReq baseReq) {
                WeChatAgentActivity.mWeChatMessagesQueue.delete(2);
            }

            public void onResp(BaseResp baseResp) {
                WeChatAgentActivity.mWeChatMessagesQueue.delete(2);
                int i = baseResp.errCode;
                if (i == -2) {
                    IMSDKResultListener.this.onResult(new IMSDKResult(2, IMSDKErrCode.getMessageByCode(2), baseResp.errCode, baseResp.errStr));
                } else if (i == 0) {
                    IMSDKResultListener.this.onResult(new IMSDKResult(1, IMSDKErrCode.getMessageByCode(1), baseResp.errCode, baseResp.errStr));
                } else {
                    IMSDKResultListener.this.onResult(new IMSDKResult(9999, IMSDKErrCode.getMessageByCode(9999), baseResp.errCode, baseResp.errStr));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WXMediaMessage setWXMediaMessageExtra(WXMediaMessage wXMediaMessage, IMSDKFriendReqInfo iMSDKFriendReqInfo) {
        try {
            JSONObject jSONObject = new JSONObject(iMSDKFriendReqInfo.extraJson);
            if (jSONObject.has("mediaTagName")) {
                wXMediaMessage.mediaTagName = jSONObject.getString("mediaTagName");
            }
            if (jSONObject.has("messageExt")) {
                wXMediaMessage.messageExt = jSONObject.getString("messageExt");
            }
            if (jSONObject.has("messageAction")) {
                wXMediaMessage.messageAction = jSONObject.getString("messageAction");
            }
        } catch (Exception e) {
            IMLogger.w(e.getMessage(), new Object[0]);
        }
        return wXMediaMessage;
    }

    public static File getStoragePath(Context context, String str) {
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            return context.getExternalFilesDir(str);
        }
        File file = new File(context.getFilesDir(), str);
        if (file.exists() || file.mkdir()) {
            return file;
        }
        IMLogger.d("make dir " + str + " failed.");
        return file;
    }

    public File saveBitmapToLocal(Bitmap bitmap, String str, String str2, int i) {
        File file = new File(getStoragePath(this.mCtx, str), str2 + System.currentTimeMillis() + ".jpeg");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (i < 1) {
                i = 1;
            }
            if (i > 100) {
                i = 100;
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            IMLogger.e("saveBitmapTo " + str + " : " + e.getMessage(), new Object[0]);
        } catch (IOException e2) {
            IMLogger.e("saveBitmapTo " + str + " : " + e2.getMessage(), new Object[0]);
        }
        return file;
    }

    private void handleWXMessage(final boolean z, final IMSDKFriendReqInfo iMSDKFriendReqInfo, final IMSDKResultListener iMSDKResultListener, Object... objArr) {
        if (!WeChatHelper.isApplicationInstalled(this.mWXApi)) {
            iMSDKResultListener.onResult(new IMSDKLoginResult(15, 15, IMSDKErrCode.getMessageByCode(15)));
            return;
        }
        try {
            setWeChatCallback(iMSDKResultListener);
            int i = iMSDKFriendReqInfo.type;
            if (i == 1) {
                WXTextObject wXTextObject = new WXTextObject();
                wXTextObject.text = iMSDKFriendReqInfo.content;
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.mediaObject = wXTextObject;
                wXMediaMessage.title = iMSDKFriendReqInfo.title;
                wXMediaMessage.description = iMSDKFriendReqInfo.content;
                sendMessage2WX(z, "text", setWXMediaMessageExtra(wXMediaMessage, iMSDKFriendReqInfo), iMSDKResultListener);
            } else if (i == 3) {
                handleBitmapPath(iMSDKFriendReqInfo.imagePath, new IMSDKListener<Bitmap>() { // from class: com.tencent.imsdk.android.friend.wechat.WeChatFriend.3
                    @Override // com.tencent.imsdk.android.base.IMSDKListener
                    public void onNotify(Bitmap bitmap) {
                        WXWebpageObject wXWebpageObject = new WXWebpageObject();
                        wXWebpageObject.webpageUrl = iMSDKFriendReqInfo.link;
                        WXMediaMessage wXMediaMessage2 = new WXMediaMessage(wXWebpageObject);
                        wXMediaMessage2.title = iMSDKFriendReqInfo.title;
                        wXMediaMessage2.description = iMSDKFriendReqInfo.content;
                        if (bitmap != null) {
                            wXMediaMessage2.setThumbImage(bitmap);
                        }
                        WeChatFriend weChatFriend = WeChatFriend.this;
                        weChatFriend.sendMessage2WX(z, "webPage", weChatFriend.setWXMediaMessageExtra(wXMediaMessage2, iMSDKFriendReqInfo), iMSDKResultListener);
                    }

                    @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                    public void onResult(IMSDKResult iMSDKResult) {
                        IMSDKResultListener iMSDKResultListener2 = iMSDKResultListener;
                        if (iMSDKResultListener2 != null) {
                            iMSDKResultListener2.onResult(iMSDKResult);
                        }
                    }
                });
            } else if (i == 5) {
                handleBitmapPath(iMSDKFriendReqInfo.imagePath, new IMSDKListener<Bitmap>() { // from class: com.tencent.imsdk.android.friend.wechat.WeChatFriend.2
                    @Override // com.tencent.imsdk.android.base.IMSDKListener
                    public void onNotify(Bitmap bitmap) {
                        WXImageObject wXImageObject;
                        if (bitmap != null) {
                            if (WeChatFriend.this.mWXApi.getWXAppSupportAPI() > 654314752 && Build.VERSION.SDK_INT >= 24) {
                                wXImageObject = new WXImageObject();
                                Uri uriForFile = FileProvider.getUriForFile(WeChatFriend.this.mCtx, WeChatFriend.this.mCtx.getPackageName() + WeChatFriend.IMSDK_WECHAT_FILE_PROVIDER, WeChatFriend.this.saveBitmapToLocal(bitmap, "wxShareData", "IMSDK_WECHAT_SHARE", 100));
                                WeChatFriend.this.mCtx.grantUriPermission(TbsConfig.APP_WX, uriForFile, 1);
                                wXImageObject.setImagePath(uriForFile.toString());
                            } else {
                                wXImageObject = new WXImageObject(bitmap);
                            }
                            WXMediaMessage wXMediaMessage2 = new WXMediaMessage();
                            wXMediaMessage2.mediaObject = wXImageObject;
                            int readFromApplication = T.Meta.readFromApplication(WeChatFriend.this.mCtx, WeChatFriend.WECHAT_THUMB_SIZE, 100);
                            wXMediaMessage2.setThumbImage(Bitmap.createScaledBitmap(bitmap, readFromApplication, readFromApplication, true));
                            bitmap.recycle();
                            WeChatFriend weChatFriend = WeChatFriend.this;
                            weChatFriend.sendMessage2WX(z, SocialConstants.PARAM_IMG_URL, weChatFriend.setWXMediaMessageExtra(wXMediaMessage2, iMSDKFriendReqInfo), iMSDKResultListener);
                        }
                    }

                    @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                    public void onResult(IMSDKResult iMSDKResult) {
                        IMSDKResultListener iMSDKResultListener2 = iMSDKResultListener;
                        if (iMSDKResultListener2 != null) {
                            iMSDKResultListener2.onResult(iMSDKResult);
                        }
                    }
                });
            } else {
                iMSDKResultListener.onResult(new IMSDKResult(7));
            }
        } catch (Exception e) {
            IMLogger.d("unknown exception : " + e.getMessage());
            reportEvent("handleWXMessage", "exception happen, isTimelineCb=" + z + ", info.type=" + iMSDKFriendReqInfo.type, e.getMessage());
        }
    }
}
