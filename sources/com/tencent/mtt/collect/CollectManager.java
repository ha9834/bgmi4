package com.tencent.mtt.collect;

import MTT.AddFrvInfo;
import MTT.AddFrvReq;
import MTT.EFvrFvrType;
import MTT.FrvUserBase;
import com.qq.taf.jce.PacketUtil;
import com.tencent.mtt.engine.http.HttpUtils;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CollectManager {
    private static final String SERVICE_NAME = "favorite";
    private static CollectManager mInstance = new CollectManager();
    private int mId = 0;

    public static CollectManager getInstane() {
        return mInstance;
    }

    private byte[] getPostData(int i, String str, String str2, String str3, Object obj) {
        try {
            PacketUtil packetUtil = new PacketUtil();
            packetUtil.setRequestId(i);
            packetUtil.setServantName(str);
            packetUtil.setFuncName(str2);
            packetUtil.put(str3, obj);
            return packetUtil.encode();
        } catch (Exception unused) {
            return null;
        }
    }

    public void addFavoriteUrl(String str, String str2, String str3, String str4, int i) {
        FrvUserBase frvUserBase = new FrvUserBase();
        frvUserBase.sUin = str3;
        frvUserBase.sSID = str4;
        frvUserBase.eChannel = i;
        AddFrvInfo addFrvInfo = new AddFrvInfo();
        addFrvInfo.sTitle = str;
        addFrvInfo.sURL = str2;
        ArrayList<AddFrvInfo> arrayList = new ArrayList<>();
        arrayList.add(addFrvInfo);
        AddFrvReq addFrvReq = new AddFrvReq();
        addFrvReq.fub = frvUserBase;
        addFrvReq.eFvrType = EFvrFvrType.h.a();
        addFrvReq.vURLInfo = arrayList;
        int i2 = this.mId;
        this.mId = i2 + 1;
        HttpUtils.post(getPostData(i2, SERVICE_NAME, "addFavorite", "req", addFrvReq));
    }
}
