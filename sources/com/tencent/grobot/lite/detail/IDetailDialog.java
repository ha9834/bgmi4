package com.tencent.grobot.lite.detail;

import com.tencent.grobot.lite.model.local.DetailInfo;
import com.tencent.grobot.lite.model.local.RecommendsInfo;

/* loaded from: classes2.dex */
public interface IDetailDialog {
    void onGetRecommendDetailInfo(int i, DetailInfo detailInfo);

    void onGetRecommendInfo(int i, RecommendsInfo recommendsInfo);

    void onSetLikeRecommend(int i);
}
