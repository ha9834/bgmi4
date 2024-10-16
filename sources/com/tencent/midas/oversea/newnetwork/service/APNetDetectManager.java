package com.tencent.midas.oversea.newnetwork.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.connect.common.Constants;
import com.tencent.midas.oversea.comm.GDPR;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.newapi.params.InitParams;
import com.tencent.open.SocialOperation;

/* loaded from: classes.dex */
public class APNetDetectManager {
    public static void startService(Context context, InitParams initParams) {
        Intent intent = new Intent(context, (Class<?>) APNetDetectService.class);
        Bundle bundle = new Bundle();
        bundle.putString("offerid", initParams.getOfferID());
        bundle.putString("openid", initParams.getOpenID());
        bundle.putString("idcInfo", initParams.getExtra().getIDCInfo());
        bundle.putString("goodsZoneid", initParams.getExtra().getGoodsZoneID());
        bundle.putString("openKey", initParams.getExtra().getOpenKey());
        bundle.putString(Constants.PARAM_PLATFORM_ID, initParams.getExtra().getPf());
        bundle.putString("pfKey", initParams.getExtra().getPfKey());
        bundle.putString("sessionId", initParams.getExtra().getSessionID());
        bundle.putString("sessionType", initParams.getExtra().getSessionType());
        bundle.putString("env", initParams.getEnv());
        bundle.putString("idc", initParams.getIDC());
        bundle.putString(SocialOperation.GAME_ZONE_ID, initParams.getZoneID());
        bundle.putLong("heartbeat", GlobalData.singleton().heartBeat);
        bundle.putBoolean("gdprSwitch", GDPR.ifCollect);
        intent.putExtras(bundle);
        context.startService(intent);
    }
}
