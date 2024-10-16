package com.tencent.grobot.lite.detail;

import android.os.Handler;
import android.os.Looper;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.common.ComponentRef;
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
import com.tencent.grobot.lite.presenter.PresenterService;
import com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback;
import java.util.List;

/* loaded from: classes2.dex */
public class DetailRecommendPresenter implements ComponentRef {
    private IDetailDialog detailDialog;
    private RecommendsCallback recommendsCallback = new RecommendsCallback() { // from class: com.tencent.grobot.lite.detail.DetailRecommendPresenter.1
        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onClearRedPointResult(int i, int i2, String str, ClearRedPointReqInfo clearRedPointReqInfo) {
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetHotKeyword(int i, int i2, String str, String str2, List<String> list, GetHotKeywordReqInfo getHotKeywordReqInfo) {
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetNavigationIndexResult(int i, int i2, String str, List<TagInfo> list, NavigationIndexReqInfo navigationIndexReqInfo) {
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetNavigationResult(int i, int i2, String str, NavigationInfo navigationInfo, NavigationReqInfo navigationReqInfo) {
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetRecommendsResult(int i, int i2, String str, List<RecommendsInfo> list, RecommendsReqInfo recommendsReqInfo) {
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onRecommendSearchResult(int i, int i2, String str, RecommendsInfo recommendsInfo, RecommendNavigationSearchReqInfo recommendNavigationSearchReqInfo) {
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetDetailRecommendResult(int i, final int i2, String str, final RecommendsInfo recommendsInfo, DetailRecomendReqInfo detailRecomendReqInfo) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.grobot.lite.detail.DetailRecommendPresenter.1.1
                @Override // java.lang.Runnable
                public void run() {
                    DetailRecommendPresenter.this.detailDialog.onGetRecommendInfo(i2, recommendsInfo);
                }
            });
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetRecommendDetailResult(int i, final int i2, String str, final DetailInfo detailInfo, RecommendDetailReqInfo recommendDetailReqInfo) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.grobot.lite.detail.DetailRecommendPresenter.1.2
                @Override // java.lang.Runnable
                public void run() {
                    DetailRecommendPresenter.this.detailDialog.onGetRecommendDetailInfo(i2, detailInfo);
                }
            });
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onSetLikeRecommend(int i, final int i2, String str, LikeRecommendItemReqInfo likeRecommendItemReqInfo) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.grobot.lite.detail.DetailRecommendPresenter.1.3
                @Override // java.lang.Runnable
                public void run() {
                    DetailRecommendPresenter.this.detailDialog.onSetLikeRecommend(i2);
                }
            });
        }
    };

    public DetailRecommendPresenter(IDetailDialog iDetailDialog) {
        this.detailDialog = iDetailDialog;
    }

    public void getRecommendInfo(RecommendsInfo.Item item, String str, String str2) {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.getDetailRecommends(item.type == 10 ? "video" : "tip", item.resourceId, "random", 1, 4, str, str2, this.recommendsCallback);
        }
    }

    public void getRecommendDetail(RecommendsInfo.Item item, String str, String str2) {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.getRecommendDetail(item.type == 10 ? "video" : "tip", item.resourceId, "random", 1, 4, str, str2, this.recommendsCallback);
        }
    }

    public void setLikeRecommend(RecommendsInfo.Item item, boolean z) {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.setLikeRecommend(item.type == 10 ? "video" : "tip", item.resourceId, z, this.recommendsCallback);
        }
    }

    @Override // com.tencent.grobot.lite.common.ComponentRef
    public void onDestroy() {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.removeDetailRecommendCallback(this.recommendsCallback);
        }
    }
}
