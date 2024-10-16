package com.tencent.grobot.lite.presenter.business.callback;

import com.tencent.grobot.lite.model.local.DetailInfo;
import com.tencent.grobot.lite.model.local.NavigationInfo;
import com.tencent.grobot.lite.model.local.RecommendsInfo;
import com.tencent.grobot.lite.model.local.TagInfo;
import com.tencent.grobot.lite.model.req.ClearRedPointReqInfo;
import com.tencent.grobot.lite.model.req.DetailRecomendReqInfo;
import com.tencent.grobot.lite.model.req.GetHotKeywordReqInfo;
import com.tencent.grobot.lite.model.req.LikeRecommendItemReqInfo;
import com.tencent.grobot.lite.model.req.NavigationIndexReqInfo;
import com.tencent.grobot.lite.model.req.NavigationReqInfo;
import com.tencent.grobot.lite.model.req.RecommendDetailReqInfo;
import com.tencent.grobot.lite.model.req.RecommendNavigationSearchReqInfo;
import com.tencent.grobot.lite.model.req.RecommendsReqInfo;
import java.util.List;

/* loaded from: classes2.dex */
public interface RecommendsCallback extends ActionCallback {
    void onClearRedPointResult(int i, int i2, String str, ClearRedPointReqInfo clearRedPointReqInfo);

    void onGetDetailRecommendResult(int i, int i2, String str, RecommendsInfo recommendsInfo, DetailRecomendReqInfo detailRecomendReqInfo);

    void onGetHotKeyword(int i, int i2, String str, String str2, List<String> list, GetHotKeywordReqInfo getHotKeywordReqInfo);

    void onGetNavigationIndexResult(int i, int i2, String str, List<TagInfo> list, NavigationIndexReqInfo navigationIndexReqInfo);

    void onGetNavigationResult(int i, int i2, String str, NavigationInfo navigationInfo, NavigationReqInfo navigationReqInfo);

    void onGetRecommendDetailResult(int i, int i2, String str, DetailInfo detailInfo, RecommendDetailReqInfo recommendDetailReqInfo);

    void onGetRecommendsResult(int i, int i2, String str, List<RecommendsInfo> list, RecommendsReqInfo recommendsReqInfo);

    void onRecommendSearchResult(int i, int i2, String str, RecommendsInfo recommendsInfo, RecommendNavigationSearchReqInfo recommendNavigationSearchReqInfo);

    void onSetLikeRecommend(int i, int i2, String str, LikeRecommendItemReqInfo likeRecommendItemReqInfo);
}
