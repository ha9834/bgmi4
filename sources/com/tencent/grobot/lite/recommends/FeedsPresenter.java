package com.tencent.grobot.lite.recommends;

import android.text.TextUtils;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.common.ComponentRef;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.core.MsgPresenterCallback;
import com.tencent.grobot.lite.model.local.DetailInfo;
import com.tencent.grobot.lite.model.local.HotTopicInfo;
import com.tencent.grobot.lite.model.local.NavigationInfo;
import com.tencent.grobot.lite.model.local.RecommendsInfo;
import com.tencent.grobot.lite.model.local.TagInfo;
import com.tencent.grobot.lite.model.node.AnsOptionNode;
import com.tencent.grobot.lite.model.node.BaseNode;
import com.tencent.grobot.lite.model.req.ClearRedPointReqInfo;
import com.tencent.grobot.lite.model.req.DetailRecomendReqInfo;
import com.tencent.grobot.lite.model.req.GetHotKeywordReqInfo;
import com.tencent.grobot.lite.model.req.LikeRecommendItemReqInfo;
import com.tencent.grobot.lite.model.req.NavigationIndexReqInfo;
import com.tencent.grobot.lite.model.req.NavigationReqInfo;
import com.tencent.grobot.lite.model.req.RecommendDetailReqInfo;
import com.tencent.grobot.lite.model.req.RecommendNavigationSearchReqInfo;
import com.tencent.grobot.lite.model.req.RecommendsReqInfo;
import com.tencent.grobot.lite.presenter.PresenterCode;
import com.tencent.grobot.lite.presenter.PresenterService;
import com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback;
import com.tencent.grobot.lite.presenter.business.engine.BaseEngine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class FeedsPresenter implements ComponentRef, MsgPresenterCallback, RecommendsCallback {
    private static final String TAG = "FeedsPresenter";
    private final Feeds view;
    private String reqNavigationTag = null;
    private String reqNavigationSubTag = null;
    private int reqNavigationOrder = 1;
    private List<TagInfo> navigationTags = new ArrayList();

    @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
    public void onGetDetailRecommendResult(int i, int i2, String str, RecommendsInfo recommendsInfo, DetailRecomendReqInfo detailRecomendReqInfo) {
    }

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public void onGetDetailRecommendResult(int i, String str, RecommendsInfo recommendsInfo) {
    }

    @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
    public void onGetHotKeyword(int i, int i2, String str, String str2, List<String> list, GetHotKeywordReqInfo getHotKeywordReqInfo) {
    }

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public void onGetHotResult(int i, String str, ArrayList<HotTopicInfo> arrayList) {
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

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public int onLoadedCacheFinished(ArrayList<BaseNode> arrayList, AnsOptionNode ansOptionNode, int i, int i2, boolean z, boolean z2) {
        return 0;
    }

    @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
    public void onRecommendSearchResult(int i, int i2, String str, RecommendsInfo recommendsInfo, RecommendNavigationSearchReqInfo recommendNavigationSearchReqInfo) {
    }

    @Override // com.tencent.grobot.lite.core.IServiceCallback
    public void onResult(int i, String str, Object... objArr) {
    }

    @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
    public void onSetLikeRecommend(int i, int i2, String str, LikeRecommendItemReqInfo likeRecommendItemReqInfo) {
    }

    public FeedsPresenter(Feeds feeds) {
        this.view = feeds;
    }

    public void init() {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.initMessage(false, false, false, this);
        }
    }

    void getRecommends() {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.getRecommends();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNavigation(String str, String str2, int i, int i2) {
        TLog.d(TAG, "getNavigation, tag" + str + ", subTag=" + str2 + ",order=" + i + ", page=" + i2);
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            if (presenterService != null) {
                return presenterService.getNavigationIndex();
            }
            return -1;
        }
        this.reqNavigationTag = str;
        this.reqNavigationSubTag = str2;
        this.reqNavigationOrder = i;
        if (presenterService != null) {
            return presenterService.getNavigation(str, str2, i, i2);
        }
        return -1;
    }

    public void clearRedPoint() {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.clearRedPoint(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onResume() {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.addMsgCenterCall(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPause() {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.removeMsgCenterCall(this);
        }
    }

    @Override // com.tencent.grobot.lite.common.ComponentRef
    public void onDestroy() {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.removeMsgCenterCall(this);
        }
    }

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public int onInitLoadedFinished(int i, ArrayList<BaseNode> arrayList, AnsOptionNode ansOptionNode, int i2, int i3, String str, String str2, JSONObject jSONObject, String str3, boolean z) {
        boolean z2;
        FeedsPresenter feedsPresenter;
        TLog.d(TAG, "onInitLoadedFinished, code=" + i + ", reinit=" + BaseEngine.sReInit);
        if (BaseEngine.sReInit) {
            return 0;
        }
        if (i == 0) {
            getRecommends();
        }
        if (jSONObject != null) {
            feedsPresenter = this;
            z2 = jSONObject.optBoolean("isShowLoading", true);
        } else {
            z2 = true;
            feedsPresenter = this;
        }
        feedsPresenter.view.onInitLoadedFinish(i, z2, jSONObject, arrayList, str3);
        return 0;
    }

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public int onLoadedFinished(int i, ArrayList<BaseNode> arrayList, AnsOptionNode ansOptionNode, int i2, int i3, String str, boolean z) {
        TLog.d(TAG, "onLoadedFinished, code=" + i);
        return 0;
    }

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public void onGetRecommendResult(int i, String str, List<RecommendsInfo> list) {
        this.view.onGetRecommendResult(i, str, list);
    }

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public void onGetNavigationResult(int i, int i2, String str, NavigationInfo navigationInfo) {
        if (i2 == 0) {
            navigationInfo.tags.clear();
            navigationInfo.tags.addAll(this.navigationTags);
        }
        this.view.onGetNavigationResult(i, i2, str, navigationInfo);
    }

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public void onClearRedPointResult(int i, String str) {
        this.view.onClearRedPointResult(i, str);
    }

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public void onGetNavigationIndexResult(int i, String str, List<TagInfo> list) {
        if (i == 0) {
            this.navigationTags.clear();
            this.navigationTags.addAll(list);
            if (TextUtils.isEmpty(this.reqNavigationTag) && TextUtils.isEmpty(this.reqNavigationSubTag)) {
                if (list.isEmpty()) {
                    this.view.onGetNavigationResult(-1, PresenterCode.Code_Engine_Navigation_Index_Tag_Empty, "", null);
                    return;
                }
                TagInfo tagInfo = list.get(0);
                if (tagInfo.subs.isEmpty()) {
                    this.view.onGetNavigationResult(-1, PresenterCode.Code_Engine_Navigation_Index_Tag_Empty, "", null);
                    return;
                }
                this.reqNavigationSubTag = tagInfo.id;
                this.reqNavigationSubTag = tagInfo.subs.get(0).id;
                getNavigation(this.reqNavigationTag, this.reqNavigationSubTag, this.reqNavigationOrder, 1);
                return;
            }
            getNavigation(this.reqNavigationTag, this.reqNavigationSubTag, this.reqNavigationOrder, 1);
            return;
        }
        this.view.onGetNavigationResult(-1, i, str, null);
    }

    @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
    public void onClearRedPointResult(int i, int i2, String str, ClearRedPointReqInfo clearRedPointReqInfo) {
        this.view.onClearRedPointResult(i2, str);
    }
}
