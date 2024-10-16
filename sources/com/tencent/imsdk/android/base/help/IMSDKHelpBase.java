package com.tencent.imsdk.android.base.help;

import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.tools.log.IMLogger;

/* loaded from: classes.dex */
public abstract class IMSDKHelpBase {
    public void setLanguage(String str) {
        IMLogger.d("not support setLanguage");
    }

    public void setZone(String str) {
        IMLogger.d("not support setZone");
    }

    public void setCharacter(String str) {
        IMLogger.d("not support setCharacter");
    }

    public void setLevel(String str) {
        IMLogger.d("not support setLevel");
    }

    public void setServerName(String str) {
        IMLogger.d("not support setServerName");
    }

    public void setServerId(String str) {
        IMLogger.d("not support setServerId");
    }

    public void setRoleName(String str) {
        IMLogger.d("not support setRoleName");
    }

    public void setRoleId(String str) {
        IMLogger.d("not support setRoleId");
    }

    public String getLanguage() {
        IMLogger.d("not support getLanguage");
        return "";
    }

    public String getZone() {
        IMLogger.d("not support getZone");
        return "";
    }

    public String getCharacter() {
        IMLogger.d("not support getLanguage");
        return "";
    }

    public String getLevel() {
        IMLogger.d("not support getRoleId");
        return "";
    }

    public String getServerName() {
        IMLogger.d("not support getServerName");
        return "";
    }

    public String getServerId() {
        IMLogger.d("not support getServerId");
        return "";
    }

    public String getRoleName() {
        IMLogger.d("not support getRoleName");
        return "";
    }

    public String getRoleId() {
        IMLogger.d("not support getRoleId");
        return "";
    }

    public void showHelpCenter(IMSDKResultListener iMSDKResultListener, String str) {
        IMLogger.d("not support showHelpCenter");
    }

    public void showFAQ(IMSDKResultListener iMSDKResultListener, String str) {
        IMLogger.d("not support showFAQ");
    }

    public void showCustomerService(IMSDKResultListener iMSDKResultListener, String str) {
        IMLogger.d("not support showCustomerService");
    }

    public void getNewMessages(IMSDKResultListener iMSDKResultListener, String str) {
        IMLogger.d("not support getNewMessages");
    }

    public void sendFeedback(IMSDKResultListener iMSDKResultListener, String str) {
        IMLogger.d("not support sendFeedback");
    }
}
