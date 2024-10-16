package com.tencent.midas.oversea.business.pay;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.business.APBaseIntroInfo;
import com.tencent.midas.oversea.business.APBaseRestore;
import com.tencent.midas.oversea.business.IGetProduct;
import com.tencent.midas.oversea.comm.GlobalData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ChannelHelper {
    private static final String CHANNEL_NAME_PREFIXE = "com.tencent.midas.oversea.business.payhub.";
    private static final int FLAG_H5 = 4;
    private static final int FLAG_NEED_RESTORE = 1;
    private static final int FLAG_PROMO_CODE = 2;
    private static final String GOOGLE_PLAY = "gwallet";
    private static final String TAG = "ChannelHelper";
    private static final HashMap<String, Integer> mChannels = new HashMap<>();

    public ChannelHelper() {
        mChannels.put("gwallet", 3);
        mChannels.put("h5_mall", 4);
        mChannels.put("os_tstore", 1);
        mChannels.put("os_amazon", 1);
    }

    public ArrayList<String> restoreChannelList() {
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, Integer> hashMap = mChannels;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, Integer> entry : mChannels.entrySet()) {
                if ((entry.getValue().intValue() & 1) != 0) {
                    arrayList.add(entry.getKey());
                }
            }
        }
        return arrayList;
    }

    public boolean isH5Channel(String str) {
        return mChannels.containsKey(str) && (mChannels.get(str).intValue() & 4) != 0;
    }

    public boolean isPromoCodeChannel(String str) {
        return mChannels.containsKey(str) && (mChannels.get(str).intValue() & 2) != 0;
    }

    public APBaseRestore createRestoreChannel(String str) {
        if (TextUtils.isEmpty(str)) {
            APLog.e(TAG, "createRestoreChannel(): channelId is empty.");
            return null;
        }
        Object createReflectObject = createReflectObject(getChannelFullName(str, ".APRestore"));
        if (createReflectObject == null) {
            return null;
        }
        return (APBaseRestore) createReflectObject;
    }

    public APPayBaseChannel createPayChannel(String str) {
        if (TextUtils.isEmpty(str)) {
            APLog.e(TAG, "createPayChannel(): channelId is empty.");
            return null;
        }
        Object createReflectObject = createReflectObject(getChannelFullName(str, ".APPay"));
        if (createReflectObject == null) {
            return null;
        }
        return (APPayBaseChannel) createReflectObject;
    }

    public IGetProduct createProductInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            APLog.e(TAG, "createProductInfo(): channelId is empty.");
            return null;
        }
        Object createReflectObject = createReflectObject(getChannelFullName(str, ".APProductInfo"));
        if (createReflectObject == null) {
            return null;
        }
        return (IGetProduct) createReflectObject;
    }

    public APBaseIntroInfo createIntroInfoChannel(String str) {
        if (TextUtils.isEmpty(str)) {
            APLog.e(TAG, "createProductInfo(): channelId is empty.");
            return null;
        }
        Object createReflectObject = createReflectObject(getChannelFullName(str, ".APIntroInfo"));
        if (createReflectObject == null) {
            return null;
        }
        return (APBaseIntroInfo) createReflectObject;
    }

    private Object createReflectObject(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Exception unused) {
            APLog.e(TAG, "createReflectObject(): reflect exception.");
            return null;
        }
    }

    private static String getChannelFullName(String str, String str2) {
        StringBuilder sb = new StringBuilder(CHANNEL_NAME_PREFIXE);
        if ("gwallet".equals(str)) {
            sb.append(str);
            if (GlobalData.isGoogleNew) {
                APLog.d("createChannel", "google new");
                sb.append(".New");
            } else {
                APLog.d("createChannel", "google old");
            }
        } else {
            sb.append(str.replace('_', '.').replace("os.", ""));
        }
        sb.append(str2);
        return sb.toString();
    }
}
