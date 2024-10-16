package com.tencent.imsdk.android.lbs.ip;

import android.content.Context;
import com.tencent.imsdk.android.api.lbs.IMSDKLbsBase;
import java.util.Map;

/* loaded from: classes.dex */
public class IPLbs extends IMSDKLbsBase {
    public static final String ICHANNEL = "iChannel";
    public static final String INNER_TOKEN = "sInnerToken";
    public static final String IOPENID = "iOpenid";
    public static final String IP_MODE = "1";
    public static final String LanTag = "iLanTag";
    public static final String TYPE_TAG = "iTypeTag";

    public IPLbs(Context context) {
        super(context);
    }

    @Override // com.tencent.imsdk.android.api.lbs.IMSDKLbsBase
    protected void fillLbsParams(Map<String, String> map) {
        map.put(TYPE_TAG, "1");
        map.put(LanTag, getLanTag());
        map.put("sInnerToken", "");
        map.put("iChannel", "");
        map.put("iOpenid", "");
    }
}
