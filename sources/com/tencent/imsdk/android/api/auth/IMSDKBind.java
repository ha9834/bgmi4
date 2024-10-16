package com.tencent.imsdk.android.api.auth;

import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.base.IMSDKModules;
import com.tencent.imsdk.android.base.interfaces.IBindAvailable;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.json.JsonSerializable;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Locale;

/* loaded from: classes.dex */
public class IMSDKBind {
    private InnerStat.Builder mAPIStatBuilder;
    private String mCurChannel = null;
    protected Context mCurCtx;
    private IBindAvailable mThirdBindImpl;

    public IMSDKBind(Context context) {
        this.mAPIStatBuilder = null;
        this.mCurCtx = null;
        if (this.mCurCtx != context) {
            this.mCurCtx = context;
            IMLogger.d("initialize set ctx =  " + this.mCurCtx);
            this.mAPIStatBuilder = new InnerStat.Builder(this.mCurCtx, "2.10.1", IR.MODULE_AUTH, "Init<IMSDKBind>");
        }
    }

    private boolean isSetChannel(int i, IMSDKResultListener iMSDKResultListener) {
        JsonSerializable iMSDKAuthResult;
        if (this.mThirdBindImpl == null) {
            T.HelperLog.channelInstanceIsNull();
            if (iMSDKResultListener != null) {
                if (i == 1) {
                    iMSDKAuthResult = new IMSDKAuthResult(18, -1);
                } else {
                    iMSDKAuthResult = new IMSDKResult(18, -1);
                }
                iMSDKResultListener.onResult(iMSDKAuthResult);
            }
        }
        return this.mThirdBindImpl != null;
    }

    public boolean setChannel(String str) {
        if (this.mCurCtx == null) {
            T.HelperLog.contextIsNull();
            return false;
        }
        if (str.length() <= 0) {
            T.HelperLog.channelIsNullOrEmpty();
            return false;
        }
        if (str.length() > 0 && (!str.equals(this.mCurChannel) || this.mThirdBindImpl == null)) {
            String format = String.format(IR.def.DEFAULT_PACKAGE_NAME_AUTH_FORMAT, str.toLowerCase(Locale.US), str);
            this.mThirdBindImpl = (IBindAvailable) IMSDKModules.getInstance(this.mCurCtx).getChannelInstance(IBindAvailable.class, format);
            if (this.mThirdBindImpl == null) {
                T.HelperLog.channelSetFailed(str, format);
            } else {
                this.mCurChannel = str;
                InnerStat.Builder builder = this.mAPIStatBuilder;
                if (builder != null) {
                    builder.setChannel(this.mCurChannel);
                }
            }
        }
        if (this.mThirdBindImpl != null) {
            IMLogger.d("get channel instance of " + str + " success when setChannel()");
        } else {
            IMLogger.e("get channel instance of " + str + " fail when setChannel()", new Object[0]);
        }
        return this.mThirdBindImpl != null;
    }

    public void sendCode(String str, int i, IMSDKResultListener<IMSDKResult> iMSDKResultListener, Object... objArr) {
        InnerStat.Builder builder = this.mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(this.mCurChannel, iMSDKResultListener);
        }
        if (IMSDKAuth.isInit(0, iMSDKResultListener) && isSetChannel(0, iMSDKResultListener)) {
            this.mThirdBindImpl.sendCode(str, i, iMSDKResultListener, objArr);
        }
    }

    public void connect(String str, String str2, IMSDKResultListener<IMSDKAuthResult> iMSDKResultListener, Object... objArr) {
        InnerStat.Builder builder = this.mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(this.mCurChannel, iMSDKResultListener);
        }
        if (IMSDKAuth.isInit(1, iMSDKResultListener) && isSetChannel(1, iMSDKResultListener)) {
            this.mThirdBindImpl.connect(str, str2, iMSDKResultListener, objArr);
        }
    }

    public void recover(String str, String str2, IMSDKResultListener<IMSDKAuthResult> iMSDKResultListener, Object... objArr) {
        InnerStat.Builder builder = this.mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(this.mCurChannel, iMSDKResultListener);
        }
        if (IMSDKAuth.isInit(1, iMSDKResultListener) && isSetChannel(1, iMSDKResultListener)) {
            this.mThirdBindImpl.recover(str, str2, iMSDKResultListener, objArr);
        }
    }
}
