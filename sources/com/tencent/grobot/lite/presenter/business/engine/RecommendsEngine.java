package com.tencent.grobot.lite.presenter.business.engine;

import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.GameParameters;
import com.tencent.grobot.lite.common.Const;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.model.AnswerModelConverter;
import com.tencent.grobot.lite.model.req.ClearRedPointReqInfo;
import com.tencent.grobot.lite.model.req.DetailRecomendReqInfo;
import com.tencent.grobot.lite.model.req.GetHotKeywordReqInfo;
import com.tencent.grobot.lite.model.req.LikeRecommendItemReqInfo;
import com.tencent.grobot.lite.model.req.NavigationIndexReqInfo;
import com.tencent.grobot.lite.model.req.NavigationReqInfo;
import com.tencent.grobot.lite.model.req.RecommendDetailReqInfo;
import com.tencent.grobot.lite.model.req.RecommendNavigationSearchReqInfo;
import com.tencent.grobot.lite.model.req.RecommendsReqInfo;
import com.tencent.grobot.lite.model.req.ReqInfo;
import com.tencent.grobot.lite.presenter.PresenterCode;
import com.tencent.grobot.lite.presenter.business.callback.CallbackHelper;
import com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback;
import com.tencent.imsdk.android.login.migrate.MigrateWebConsts;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class RecommendsEngine extends BaseEngine<RecommendsCallback> {
    public int getRecommends() {
        GameParameters gameParam = GRobotApplication.getInstance().getGameParam();
        RecommendsReqInfo recommendsReqInfo = new RecommendsReqInfo();
        recommendsReqInfo.appid = gameParam != null ? gameParam.appid : "";
        recommendsReqInfo.openid = gameParam != null ? gameParam.openid : "";
        recommendsReqInfo.gameid = gameParam != null ? gameParam.gameId : "";
        recommendsReqInfo.source = gameParam != null ? gameParam.source : "";
        recommendsReqInfo.gameVersion = gameParam != null ? gameParam.gameVersion : "";
        recommendsReqInfo.version = Const.getSDKVersion();
        recommendsReqInfo.country = gameParam != null ? gameParam.country : "";
        recommendsReqInfo.language = gameParam != null ? gameParam.language : "en";
        recommendsReqInfo.timeZone = gameParam != null ? gameParam.timeZone : "";
        return sendJsonRequest(recommendsReqInfo, recommendsReqInfo.getJsonObject());
    }

    public int getNavigation(String str, String str2, String str3, String str4, int i, int i2) {
        NavigationReqInfo navigationReqInfo = new NavigationReqInfo();
        navigationReqInfo.certificate = str;
        navigationReqInfo.tagId = str2;
        navigationReqInfo.subTagId = str3;
        navigationReqInfo.orderBy = str4;
        navigationReqInfo.page = i;
        navigationReqInfo.size = i2;
        return sendJsonRequest(navigationReqInfo, navigationReqInfo.getJsonObject());
    }

    public int getNavigationIndex(String str) {
        NavigationIndexReqInfo navigationIndexReqInfo = new NavigationIndexReqInfo();
        navigationIndexReqInfo.certificate = str;
        sendJsonRequest(navigationIndexReqInfo, navigationIndexReqInfo.getJsonObject());
        return -1;
    }

    public int getDetailRecommends(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6) {
        DetailRecomendReqInfo detailRecomendReqInfo = new DetailRecomendReqInfo();
        detailRecomendReqInfo.certificate = str;
        detailRecomendReqInfo.type = str2;
        detailRecomendReqInfo.resource_id = str3;
        detailRecomendReqInfo.order_by = str4;
        detailRecomendReqInfo.page = i;
        detailRecomendReqInfo.size = i2;
        detailRecomendReqInfo.tag_id = str5;
        detailRecomendReqInfo.sub_tag_id = str6;
        return sendJsonRequest(detailRecomendReqInfo, detailRecomendReqInfo.getJsonObject());
    }

    public int getRecommendDetail(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6) {
        RecommendDetailReqInfo recommendDetailReqInfo = new RecommendDetailReqInfo();
        recommendDetailReqInfo.certificate = str;
        recommendDetailReqInfo.type = str2;
        recommendDetailReqInfo.resource_id = str3;
        recommendDetailReqInfo.order_by = str4;
        recommendDetailReqInfo.page = i;
        recommendDetailReqInfo.size = i2;
        recommendDetailReqInfo.tag_id = str5;
        recommendDetailReqInfo.sub_tag_id = str6;
        return sendJsonRequest(recommendDetailReqInfo, recommendDetailReqInfo.getJsonObject());
    }

    public int setRecommendLike(String str, String str2, String str3, boolean z) {
        LikeRecommendItemReqInfo likeRecommendItemReqInfo = new LikeRecommendItemReqInfo();
        likeRecommendItemReqInfo.certificate = str;
        likeRecommendItemReqInfo.type = str2;
        likeRecommendItemReqInfo.resourceId = str3;
        likeRecommendItemReqInfo.flag = z;
        return sendJsonRequest(likeRecommendItemReqInfo, likeRecommendItemReqInfo.getJsonObject());
    }

    public int clearRedPoint(String str) {
        ClearRedPointReqInfo clearRedPointReqInfo = new ClearRedPointReqInfo();
        clearRedPointReqInfo.certificate = str;
        return sendJsonRequest(clearRedPointReqInfo, clearRedPointReqInfo.getJsonObject());
    }

    public int recommendSearch(String str, String str2) {
        RecommendNavigationSearchReqInfo recommendNavigationSearchReqInfo = new RecommendNavigationSearchReqInfo();
        recommendNavigationSearchReqInfo.certificate = str;
        recommendNavigationSearchReqInfo.keyword = str2;
        return sendJsonRequest(recommendNavigationSearchReqInfo, recommendNavigationSearchReqInfo.getJsonObject());
    }

    public int getHotKeywords(String str) {
        try {
            GetHotKeywordReqInfo getHotKeywordReqInfo = new GetHotKeywordReqInfo();
            GameParameters gameParam = GRobotApplication.getInstance().getGameParam();
            getHotKeywordReqInfo.gameid = gameParam != null ? gameParam.gameId : "";
            getHotKeywordReqInfo.source = gameParam != null ? gameParam.source : "";
            getHotKeywordReqInfo.language = gameParam != null ? gameParam.language : "en";
            getHotKeywordReqInfo.business_id = "";
            getHotKeywordReqInfo.certificate = str;
            JSONObject jsonObject = getHotKeywordReqInfo.getJsonObject();
            jsonObject.put(MigrateWebConsts.MIGRATE_WEB_PROTOCOL_GAME_ID, getHotKeywordReqInfo.gameid);
            jsonObject.put("source", getHotKeywordReqInfo.source);
            jsonObject.put("language", getHotKeywordReqInfo.language);
            jsonObject.put("business_id", getHotKeywordReqInfo.business_id);
            return sendJsonRequest(getHotKeywordReqInfo, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    protected void handleJsonSuccess(final int i, final JSONObject jSONObject, final ReqInfo reqInfo) {
        StringBuilder sb = new StringBuilder("handleJsonSuccess");
        sb.append(", seq=");
        sb.append(i);
        sb.append(",json=");
        sb.append(jSONObject);
        sb.append(",req=");
        sb.append(reqInfo);
        if (jSONObject != null) {
            try {
                notifyDataChanged(new CallbackHelper.Caller<RecommendsCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.RecommendsEngine.1
                    @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
                    public void call(RecommendsCallback recommendsCallback) {
                        ReqInfo reqInfo2 = reqInfo;
                        if (reqInfo2 instanceof RecommendsReqInfo) {
                            recommendsCallback.onGetRecommendsResult(i, 0, "", AnswerModelConverter.convertRecommends(jSONObject), (RecommendsReqInfo) reqInfo2);
                            return;
                        }
                        if (reqInfo2 instanceof NavigationReqInfo) {
                            recommendsCallback.onGetNavigationResult(i, 0, "", AnswerModelConverter.convertNavigation(jSONObject), (NavigationReqInfo) reqInfo2);
                            return;
                        }
                        if (reqInfo2 instanceof NavigationIndexReqInfo) {
                            recommendsCallback.onGetNavigationIndexResult(i, 0, "", AnswerModelConverter.convertNavigationIndex(jSONObject), (NavigationIndexReqInfo) reqInfo2);
                            return;
                        }
                        if (reqInfo2 instanceof DetailRecomendReqInfo) {
                            recommendsCallback.onGetDetailRecommendResult(i, 0, "", AnswerModelConverter.convertDetailRecommends(jSONObject), (DetailRecomendReqInfo) reqInfo2);
                            return;
                        }
                        if (reqInfo2 instanceof ClearRedPointReqInfo) {
                            recommendsCallback.onClearRedPointResult(i, 0, "", (ClearRedPointReqInfo) reqInfo2);
                            return;
                        }
                        if (reqInfo2 instanceof RecommendDetailReqInfo) {
                            recommendsCallback.onGetRecommendDetailResult(i, 0, "", AnswerModelConverter.convertRecommendDetail(jSONObject), (RecommendDetailReqInfo) reqInfo2);
                            return;
                        }
                        if (reqInfo2 instanceof LikeRecommendItemReqInfo) {
                            recommendsCallback.onSetLikeRecommend(i, 0, "", (LikeRecommendItemReqInfo) reqInfo2);
                            return;
                        }
                        if (reqInfo2 instanceof RecommendNavigationSearchReqInfo) {
                            recommendsCallback.onRecommendSearchResult(i, 0, "", AnswerModelConverter.convertDetailRecommends(jSONObject), (RecommendNavigationSearchReqInfo) reqInfo2);
                        } else if (reqInfo2 instanceof GetHotKeywordReqInfo) {
                            GetHotKeywordReqInfo getHotKeywordReqInfo = (GetHotKeywordReqInfo) reqInfo2;
                            JSONObject optJSONObject = jSONObject.optJSONObject("result");
                            if (optJSONObject == null) {
                                recommendsCallback.onGetHotKeyword(i, PresenterCode.Code_Decoder_Body_Error, "", "", null, getHotKeywordReqInfo);
                            } else {
                                recommendsCallback.onGetHotKeyword(i, 0, "", optJSONObject.optString("text"), AnswerModelConverter.convertKeywordsList(optJSONObject), getHotKeywordReqInfo);
                            }
                        }
                    }
                });
            } catch (Exception e) {
                sb.append(", failed, ex=");
                sb.append(e);
                handleJsonFail(i, PresenterCode.Code_Engine_Recommend_Error, "response is empty", null, reqInfo);
            }
        }
        TLog.d("Presenter.Engine", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    public void handleJsonFail(final int i, final int i2, final String str, JSONObject jSONObject, final ReqInfo reqInfo) {
        TLog.d("Presenter.Engine", "handleJsonFail, seq=" + i + ", code=" + i2 + ", msg=" + str + ", req=" + reqInfo);
        notifyDataChanged(new CallbackHelper.Caller<RecommendsCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.RecommendsEngine.2
            @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
            public void call(RecommendsCallback recommendsCallback) {
                ReqInfo reqInfo2 = reqInfo;
                if (reqInfo2 instanceof RecommendsReqInfo) {
                    recommendsCallback.onGetRecommendsResult(i, i2, str, null, (RecommendsReqInfo) reqInfo2);
                    return;
                }
                if (reqInfo2 instanceof NavigationReqInfo) {
                    recommendsCallback.onGetNavigationResult(i, i2, str, null, (NavigationReqInfo) reqInfo2);
                    return;
                }
                if (reqInfo2 instanceof NavigationIndexReqInfo) {
                    recommendsCallback.onGetNavigationIndexResult(i, i2, str, null, (NavigationIndexReqInfo) reqInfo2);
                    return;
                }
                if (reqInfo2 instanceof DetailRecomendReqInfo) {
                    recommendsCallback.onGetDetailRecommendResult(i, i2, str, null, (DetailRecomendReqInfo) reqInfo2);
                    return;
                }
                if (reqInfo2 instanceof ClearRedPointReqInfo) {
                    recommendsCallback.onClearRedPointResult(i, i2, str, (ClearRedPointReqInfo) reqInfo2);
                    return;
                }
                if (reqInfo2 instanceof RecommendDetailReqInfo) {
                    recommendsCallback.onGetRecommendDetailResult(i, i2, str, null, (RecommendDetailReqInfo) reqInfo2);
                    return;
                }
                if (reqInfo2 instanceof LikeRecommendItemReqInfo) {
                    recommendsCallback.onSetLikeRecommend(i, i2, str, (LikeRecommendItemReqInfo) reqInfo2);
                    return;
                }
                if (reqInfo2 instanceof RecommendNavigationSearchReqInfo) {
                    recommendsCallback.onRecommendSearchResult(i, i2, str, null, (RecommendNavigationSearchReqInfo) reqInfo2);
                    return;
                }
                if (reqInfo2 instanceof GetHotKeywordReqInfo) {
                    recommendsCallback.onGetHotKeyword(i, i2, str, "", null, (GetHotKeywordReqInfo) reqInfo2);
                }
            }
        });
    }
}
