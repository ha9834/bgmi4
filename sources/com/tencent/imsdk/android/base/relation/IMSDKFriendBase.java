package com.tencent.imsdk.android.base.relation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Patterns;
import androidx.annotation.Keep;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.common.IMSDKLaunchResult;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.api.relation.IMSDKFriend;
import com.tencent.imsdk.android.api.relation.IMSDKFriendListResult;
import com.tencent.imsdk.android.api.relation.IMSDKFriendReqInfo;
import com.tencent.imsdk.android.base.IMSDKDB4Login;
import com.tencent.imsdk.android.base.IMSDKDBLoginData;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.IMSDKManagerBase;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.imsdk.android.tools.net.IMSDKHttpClient;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;

@Keep
/* loaded from: classes.dex */
public abstract class IMSDKFriendBase extends IMSDKManagerBase {
    public abstract String getChannelId();

    public abstract void invite(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr);

    public abstract void sendMessage(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr);

    public abstract void share(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr);

    public IMSDKFriendBase(Context context) {
        super(context);
        if (this.mCurCtx == null) {
            this.mCurCtx = context.getApplicationContext();
            this.mSTBuilder = new InnerStat.Builder(this.mCurCtx, "2.10.1", IR.MODULE_FRIEND, "Init<IMSDKFriendBase>");
        }
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    public String getUrl(String str) {
        return "https://" + IMSDKConfig.getOrMetaData(IR.meta.IMSDK_SERVER_SDKAPI.toUpperCase(), IR.meta.IMSDK_SERVER_SDKAPI) + "/v" + IMSDKConfig.getOrDefault(IR.meta.IMSDK_SERVER_SDKAPI_VERSION, "1.0") + "/" + str + "?";
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    public IMSDKResult handleServerData(String str, byte[] bArr, Map<String, String> map) {
        String str2;
        IMSDKResult iMSDKResult;
        if (bArr != null) {
            try {
                str2 = new String(bArr, "UTF-8");
            } catch (JSONException e) {
                return new IMSDKResult(5, -1, e.getMessage());
            } catch (Exception e2) {
                return new IMSDKResult(3, -1, e2.getMessage());
            }
        } else {
            str2 = "";
        }
        IMLogger.json(str2);
        if (str.equals(IR.path.GET_FRIENDS_IN_GAME)) {
            iMSDKResult = new IMSDKFriendListResult(str2);
        } else {
            iMSDKResult = new IMSDKResult(str2);
        }
        if (iMSDKResult.thirdRetCode == 1) {
            iMSDKResult.imsdkRetCode = 1;
        } else {
            iMSDKResult.imsdkRetCode = 5;
        }
        iMSDKResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(iMSDKResult.imsdkRetCode);
        if (iMSDKResult.thirdRetCode == -905 && this.mSTBuilder != null) {
            this.mSTBuilder.setStage("handle iMSDK network finish").setMethod("handleServerData").setResult(iMSDKResult.thirdRetMsg).setExtraProp(map).setNewSeq(false).setCrypt(true).create().reportEvent();
        }
        return iMSDKResult;
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    public IMSDKResult convertResult(String str, IMSDKResult iMSDKResult) {
        return new IMSDKFriendListResult(iMSDKResult.imsdkRetCode, iMSDKResult.thirdRetCode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void returnByError(IMSDKResultListener iMSDKResultListener, int i, int i2, String str) {
        if (iMSDKResultListener != null) {
            iMSDKResultListener.onResult(new IMSDKResult(i, i2, str));
        } else {
            IMLogger.e(str, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleBitmapPath(String str, final IMSDKListener<Bitmap> iMSDKListener) {
        Bitmap bitmap = null;
        if (str == null) {
            iMSDKListener.onNotify(null);
            return;
        }
        if (new File(str).exists()) {
            iMSDKListener.onNotify(BitmapFactory.decodeFile(str));
            return;
        }
        if (Patterns.WEB_URL.matcher(str).matches()) {
            new IMSDKHttpClient(this.mCurCtx).get(str, new IMSDKListener<byte[]>() { // from class: com.tencent.imsdk.android.base.relation.IMSDKFriendBase.1
                @Override // com.tencent.imsdk.android.base.IMSDKListener
                public void onNotify(byte[] bArr) {
                    iMSDKListener.onNotify((bArr == null || bArr.length <= 0) ? null : BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                }

                @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                public void onResult(IMSDKResult iMSDKResult) {
                    iMSDKListener.onResult(new IMSDKResult(iMSDKResult.imsdkRetCode, iMSDKResult.thirdRetCode, iMSDKResult.thirdRetMsg));
                }
            });
            return;
        }
        try {
            bitmap = MediaStore.Images.Media.getBitmap(this.mCurCtx.getContentResolver(), Uri.parse(str));
        } catch (IOException e) {
            IMLogger.d(e.getMessage());
        }
        iMSDKListener.onNotify(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Uri convert2Uri(String str) {
        if (str != null) {
            try {
                return Uri.parse(str);
            } catch (Exception e) {
                IMLogger.e("cannot parse uri " + str + " : " + e.getMessage(), new Object[0]);
            }
        }
        return null;
    }

    public void getFriendList(String str, IMSDKResultListener<IMSDKFriendListResult> iMSDKResultListener) {
        if (iMSDKResultListener != null) {
            iMSDKResultListener.onResult(new IMSDKFriendListResult(7, -1));
        }
    }

    public void getFriendList(String str, int i, int i2, IMSDKResultListener<IMSDKFriendListResult> iMSDKResultListener) {
        if (iMSDKResultListener != null) {
            iMSDKResultListener.onResult(new IMSDKFriendListResult(7, -1));
        }
    }

    public void getInviteFriends(int i, int i2, String str, IMSDKResultListener<IMSDKFriendListResult> iMSDKResultListener) {
        if (iMSDKResultListener != null) {
            iMSDKResultListener.onResult(new IMSDKFriendListResult(7, -1));
        }
    }

    public void getFriends(int i, int i2, IMSDKResultListener<IMSDKFriendListResult> iMSDKResultListener) {
        String channel = IMSDKFriend.getChannel();
        if (channel == null || channel.length() <= 0) {
            iMSDKResultListener.onResult(new IMSDKFriendListResult(18, -1, "not initialized"));
            return;
        }
        IMSDKDBLoginData dBLoginData = IMSDKDB4Login.getDBLoginData(this.mCurCtx);
        if (dBLoginData != null) {
            Map<String, String> sortableMap = T.getSortableMap();
            sortableMap.put("sInnerToken", dBLoginData.innerToken);
            sortableMap.put("iOpenid", dBLoginData.openId);
            sortableMap.put("iPage", String.valueOf(i));
            sortableMap.put("iPageSize", String.valueOf(i2));
            sortableMap.put("iChannel", String.valueOf(dBLoginData.channelId));
            connectIMSDK(IR.path.GET_FRIENDS_IN_GAME, sortableMap, iMSDKResultListener);
            return;
        }
        iMSDKResultListener.onResult(new IMSDKFriendListResult(10, -1, "should call login first"));
    }

    public void getJsonParas(String str, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        if (iMSDKResultListener != null) {
            iMSDKResultListener.onResult(new IMSDKLaunchResult(7, -1));
        }
    }
}
