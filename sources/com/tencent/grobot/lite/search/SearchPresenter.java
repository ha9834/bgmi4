package com.tencent.grobot.lite.search;

import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.common.ComponentRef;
import com.tencent.grobot.lite.common.DataManager;
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
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class SearchPresenter implements ComponentRef {
    private ISearchView mSearchView;
    private ArrayList<String> mHostKeywords = new ArrayList<>();
    private RecommendsCallback recommendsCallback = new RecommendsCallback() { // from class: com.tencent.grobot.lite.search.SearchPresenter.1
        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onClearRedPointResult(int i, int i2, String str, ClearRedPointReqInfo clearRedPointReqInfo) {
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetDetailRecommendResult(int i, int i2, String str, RecommendsInfo recommendsInfo, DetailRecomendReqInfo detailRecomendReqInfo) {
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetNavigationIndexResult(int i, int i2, String str, List<TagInfo> list, NavigationIndexReqInfo navigationIndexReqInfo) {
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetNavigationResult(int i, int i2, String str, NavigationInfo navigationInfo, NavigationReqInfo navigationReqInfo) {
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetRecommendDetailResult(int i, int i2, String str, DetailInfo detailInfo, RecommendDetailReqInfo recommendDetailReqInfo) {
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetRecommendsResult(int i, int i2, String str, List<RecommendsInfo> list, RecommendsReqInfo recommendsReqInfo) {
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onSetLikeRecommend(int i, int i2, String str, LikeRecommendItemReqInfo likeRecommendItemReqInfo) {
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onRecommendSearchResult(int i, int i2, String str, RecommendsInfo recommendsInfo, RecommendNavigationSearchReqInfo recommendNavigationSearchReqInfo) {
            if (recommendNavigationSearchReqInfo == null || recommendsInfo == null || SearchPresenter.this.mSearchView == null) {
                return;
            }
            SearchPresenter.this.mSearchView.onSearchResult(recommendNavigationSearchReqInfo.keyword, recommendsInfo);
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetHotKeyword(int i, int i2, String str, String str2, List<String> list, GetHotKeywordReqInfo getHotKeywordReqInfo) {
            if (list == null || list.size() <= 0) {
                return;
            }
            SearchPresenter.this.mHostKeywords.clear();
            SearchPresenter.this.mHostKeywords.addAll(list);
            if (SearchPresenter.this.mSearchView != null) {
                SearchPresenter.this.mSearchView.onGetHotKeyword(str2, SearchPresenter.this.mHostKeywords);
            }
        }
    };

    public SearchPresenter(ISearchView iSearchView) {
        this.mSearchView = iSearchView;
    }

    public void search(String str) {
        storeKeyword(str);
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.recommendSearch(str, this.recommendsCallback);
        }
    }

    public void getHotKeywords() {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.getHotKeywords(this.recommendsCallback);
        }
    }

    public ArrayList<String> getmHostKeywords() {
        return this.mHostKeywords;
    }

    private void storeKeyword(String str) {
        DataManager.getInstance().saveSearchHistory(str);
    }

    @Override // com.tencent.grobot.lite.common.ComponentRef
    public void onDestroy() {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.removeRecommendCallback(this.recommendsCallback);
        }
    }
}
