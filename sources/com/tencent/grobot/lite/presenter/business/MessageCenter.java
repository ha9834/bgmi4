package com.tencent.grobot.lite.presenter.business;

import android.text.TextUtils;
import com.tencent.grobot.lite.common.SystemUtils;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.common.thread.ThreadManager;
import com.tencent.grobot.lite.core.MsgPresenterCallback;
import com.tencent.grobot.lite.image.upload.cos.BizService;
import com.tencent.grobot.lite.model.LogAnwserModelConverter;
import com.tencent.grobot.lite.model.local.AnswerInfo;
import com.tencent.grobot.lite.model.local.DetailInfo;
import com.tencent.grobot.lite.model.local.EvaluateInfo;
import com.tencent.grobot.lite.model.local.HotTopicInfo;
import com.tencent.grobot.lite.model.local.NavigationInfo;
import com.tencent.grobot.lite.model.local.RecommendsInfo;
import com.tencent.grobot.lite.model.local.TagInfo;
import com.tencent.grobot.lite.model.node.AnsOptionNode;
import com.tencent.grobot.lite.model.node.BaseNode;
import com.tencent.grobot.lite.model.node.QuTextNode;
import com.tencent.grobot.lite.model.req.ClearRedPointReqInfo;
import com.tencent.grobot.lite.model.req.DetailRecomendReqInfo;
import com.tencent.grobot.lite.model.req.FilterReqInfo;
import com.tencent.grobot.lite.model.req.GetCosFederationTokenReqInfo;
import com.tencent.grobot.lite.model.req.GetHotKeywordReqInfo;
import com.tencent.grobot.lite.model.req.HotReqInfo;
import com.tencent.grobot.lite.model.req.InitReqInfo;
import com.tencent.grobot.lite.model.req.LikeRecommendItemReqInfo;
import com.tencent.grobot.lite.model.req.NavigationIndexReqInfo;
import com.tencent.grobot.lite.model.req.NavigationReqInfo;
import com.tencent.grobot.lite.model.req.QueryGBotLogReqInfo;
import com.tencent.grobot.lite.model.req.RecommendDetailReqInfo;
import com.tencent.grobot.lite.model.req.RecommendNavigationSearchReqInfo;
import com.tencent.grobot.lite.model.req.RecommendsReqInfo;
import com.tencent.grobot.lite.model.req.ReqInfo;
import com.tencent.grobot.lite.presenter.business.callback.CosCallback;
import com.tencent.grobot.lite.presenter.business.callback.EngineCallback;
import com.tencent.grobot.lite.presenter.business.callback.HistroyLogCallback;
import com.tencent.grobot.lite.presenter.business.callback.HotCallback;
import com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback;
import com.tencent.grobot.lite.presenter.business.engine.AskEngine;
import com.tencent.grobot.lite.presenter.business.engine.FilterEngine;
import com.tencent.grobot.lite.presenter.business.engine.GetCosFederationTokenEngine;
import com.tencent.grobot.lite.presenter.business.engine.HistoryLogEngine;
import com.tencent.grobot.lite.presenter.business.engine.HotEngine;
import com.tencent.grobot.lite.presenter.business.engine.InitEngine;
import com.tencent.grobot.lite.presenter.business.engine.RecommendsEngine;
import com.tencent.grobot.lite.presenter.transport.json.JsonReqSender;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MessageCenter {
    public static final int INVALID_POSTION = -1;
    protected static final String TAG = "MessageCenter";
    private AskEngine askEngine;
    public String certificate;
    private GetCosFederationTokenEngine cosEngine;
    private FilterEngine filterEngine;
    private HistoryLogEngine historyLogEngine;
    private HotEngine hotEngine;
    private long logStartTime;
    private final RecommendsEngine recommendsEngine;
    private int lastPosition = 0;
    private long initTime = 0;
    private long latestTime = 0;
    private Map<Integer, BaseNode> quNodeMap = new ConcurrentHashMap();
    public List<MsgPresenterCallback> callbacks = new ArrayList(3);
    public int historylog_page = 1;
    private boolean lastLoadHistorySucc = true;
    private FilterEngine.FilterActionCallback filterCallback = new FilterEngine.FilterActionCallback() { // from class: com.tencent.grobot.lite.presenter.business.MessageCenter.4
        @Override // com.tencent.grobot.lite.presenter.business.engine.FilterEngine.FilterActionCallback
        public void onLoadFinish(int i, int i2, String str, FilterReqInfo filterReqInfo, int i3) {
            TLog.d(MessageCenter.TAG, "FilterActionCallback seq:" + i + ",errorCode:" + i2);
            if (i2 == -310) {
                MessageCenter.this.onLoadFinished(i2, null, null, -1, -1, str, false);
            } else {
                MessageCenter.this.sendValidMessage("", filterReqInfo != null ? filterReqInfo.text : "", -1, i3);
            }
        }
    };
    public long INVLID_TIME = -1000;
    private EngineCallback qaCallback = new EngineCallback() { // from class: com.tencent.grobot.lite.presenter.business.MessageCenter.5
        @Override // com.tencent.grobot.lite.presenter.business.callback.EngineCallback
        public void onInitLoadSucceed(int i, AnswerInfo answerInfo, boolean z, String str, String str2, JSONObject jSONObject, String str3, ReqInfo reqInfo) {
            String str4;
            int i2;
            int i3;
            SystemUtils.doGC();
            if (answerInfo == null) {
                return;
            }
            TLog.d(MessageCenter.TAG, "EngineCallback.succees init seq:" + i + ",loadCache:" + z + ",timestamp:" + answerInfo.timestamp);
            BaseNode baseNode = (BaseNode) MessageCenter.this.quNodeMap.remove(Integer.valueOf(i));
            if (baseNode != null) {
                QuTextNode quTextNode = (QuTextNode) baseNode;
                quTextNode.quSendingState = 1;
                int i4 = quTextNode.position;
                int i5 = quTextNode.questionOrderId;
                str4 = quTextNode.text;
                i3 = i5;
                i2 = i4;
            } else {
                str4 = "";
                i2 = -1;
                i3 = -1;
            }
            InitReqInfo initReqInfo = (InitReqInfo) reqInfo;
            if (initReqInfo.isIMStatus) {
                MessageCenter.this.onInitLoadFinished(0, null, null, i2, i3, str, str2, jSONObject, str3, initReqInfo.pureInit);
                return;
            }
            if (MessageCenter.this.latestTime > 0) {
                long unused = MessageCenter.this.latestTime;
            } else {
                long j = MessageCenter.this.INVLID_TIME;
            }
            MessageCenter.this.onInitLoadFinished(0, DataProcessor.parseAnswer(answerInfo.answerId, answerInfo.questionId, str4, (byte) 0, answerInfo.answerList, false), DataProcessor.parseOptions(answerInfo.optionList), i2, i3, str, str2, jSONObject, str3, initReqInfo.pureInit);
            MessageCenter.this.latestTime = answerInfo.timestamp * 1000;
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.EngineCallback
        public void onLoadSucceed(int i, AnswerInfo answerInfo, boolean z, ReqInfo reqInfo) {
            String str;
            int i2;
            int i3;
            SystemUtils.doGC();
            if (answerInfo == null) {
                return;
            }
            BaseNode baseNode = (BaseNode) MessageCenter.this.quNodeMap.remove(Integer.valueOf(i));
            if (baseNode != null) {
                QuTextNode quTextNode = (QuTextNode) baseNode;
                quTextNode.quSendingState = 1;
                int i4 = quTextNode.position;
                int i5 = quTextNode.questionOrderId;
                str = quTextNode.text;
                i3 = i5;
                i2 = i4;
            } else {
                str = "";
                i2 = -1;
                i3 = -1;
            }
            MessageCenter.this.onLoadFinished(0, DataProcessor.parseAnswer(answerInfo.answerId, answerInfo.questionId, str, (byte) 0, answerInfo.answerList, false), DataProcessor.parseOptions(answerInfo.optionList), i2, i3, "", true);
            MessageCenter.this.latestTime = answerInfo.timestamp * 1000;
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.EngineCallback
        public void onLoadFail(int i, int i2, String str, ReqInfo reqInfo) {
            int i3;
            int i4;
            TLog.d(MessageCenter.TAG, "EngineCallback.fail seq:" + i + ",errorCode:" + i2);
            BaseNode baseNode = (BaseNode) MessageCenter.this.quNodeMap.remove(Integer.valueOf(i));
            if (baseNode != null) {
                QuTextNode quTextNode = (QuTextNode) baseNode;
                quTextNode.quSendingState = 2;
                int i5 = quTextNode.position;
                i4 = quTextNode.questionOrderId;
                i3 = i5;
            } else {
                i3 = -1;
                i4 = -1;
            }
            if (reqInfo instanceof InitReqInfo) {
                MessageCenter.this.onInitLoadFinished(i2, null, null, i3, i4, EvaluateInfo.TYPE_ROBOT, "0", null, "", false);
            } else {
                MessageCenter.this.onLoadFinished(i2, null, null, i3, i4, "", true);
            }
        }
    };
    private HotCallback hotCallback = new HotCallback() { // from class: com.tencent.grobot.lite.presenter.business.MessageCenter.6
        @Override // com.tencent.grobot.lite.presenter.business.callback.HotCallback
        public void onGetHotResult(int i, final int i2, final String str, final ArrayList<HotTopicInfo> arrayList, HotReqInfo hotReqInfo) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.presenter.business.MessageCenter.6.1
                @Override // java.lang.Runnable
                public void run() {
                    for (MsgPresenterCallback msgPresenterCallback : MessageCenter.this.callbacks) {
                        if (msgPresenterCallback != null) {
                            msgPresenterCallback.onGetHotResult(i2, str, arrayList);
                        }
                    }
                }
            });
        }
    };
    private CosCallback cosCallback = new CosCallback() { // from class: com.tencent.grobot.lite.presenter.business.MessageCenter.7
        @Override // com.tencent.grobot.lite.presenter.business.callback.CosCallback
        public void onGetCosFederatinTokenResult(int i, int i2, String str, JSONObject jSONObject, GetCosFederationTokenReqInfo getCosFederationTokenReqInfo) {
            JSONObject optJSONObject;
            if (i2 != 0 || (optJSONObject = jSONObject.optJSONObject("result")) == null) {
                return;
            }
            BizService.getInstance().setCosTicket(optJSONObject.optString("token"), optJSONObject.optString("tmp_secret_id"), optJSONObject.optString("tmp_secret_key"), optJSONObject.optInt("expired_time"));
        }
    };
    private HistroyLogCallback histroyLogCallback = new HistroyLogCallback() { // from class: com.tencent.grobot.lite.presenter.business.MessageCenter.8
        @Override // com.tencent.grobot.lite.presenter.business.callback.HistroyLogCallback
        public void onGetHistoryLogResult(int i, int i2, String str, JSONObject jSONObject, QueryGBotLogReqInfo queryGBotLogReqInfo) {
            if (i2 == 0 && jSONObject != null && queryGBotLogReqInfo.page == MessageCenter.this.historylog_page) {
                boolean z = jSONObject.optInt("count") >= 10;
                if (z) {
                    MessageCenter.this.historylog_page++;
                }
                MessageCenter.this.onLoadCacheFinished(LogAnwserModelConverter.buildNodes(jSONObject), 0, 0, false, z);
                MessageCenter.this.lastLoadHistorySucc = true;
            }
        }
    };
    private RecommendsCallback recommendsCallback = new RecommendsCallback() { // from class: com.tencent.grobot.lite.presenter.business.MessageCenter.9
        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetHotKeyword(int i, int i2, String str, String str2, List<String> list, GetHotKeywordReqInfo getHotKeywordReqInfo) {
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetRecommendDetailResult(int i, int i2, String str, DetailInfo detailInfo, RecommendDetailReqInfo recommendDetailReqInfo) {
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onRecommendSearchResult(int i, int i2, String str, RecommendsInfo recommendsInfo, RecommendNavigationSearchReqInfo recommendNavigationSearchReqInfo) {
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onSetLikeRecommend(int i, int i2, String str, LikeRecommendItemReqInfo likeRecommendItemReqInfo) {
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetRecommendsResult(int i, final int i2, final String str, final List<RecommendsInfo> list, RecommendsReqInfo recommendsReqInfo) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.presenter.business.MessageCenter.9.1
                @Override // java.lang.Runnable
                public void run() {
                    for (MsgPresenterCallback msgPresenterCallback : MessageCenter.this.callbacks) {
                        if (msgPresenterCallback != null) {
                            msgPresenterCallback.onGetRecommendResult(i2, str, list);
                        }
                    }
                }
            });
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetNavigationResult(final int i, final int i2, final String str, final NavigationInfo navigationInfo, NavigationReqInfo navigationReqInfo) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.presenter.business.MessageCenter.9.2
                @Override // java.lang.Runnable
                public void run() {
                    for (MsgPresenterCallback msgPresenterCallback : MessageCenter.this.callbacks) {
                        if (msgPresenterCallback != null) {
                            msgPresenterCallback.onGetNavigationResult(i, i2, str, navigationInfo);
                        }
                    }
                }
            });
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetNavigationIndexResult(int i, final int i2, final String str, final List<TagInfo> list, NavigationIndexReqInfo navigationIndexReqInfo) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.presenter.business.MessageCenter.9.3
                @Override // java.lang.Runnable
                public void run() {
                    for (MsgPresenterCallback msgPresenterCallback : MessageCenter.this.callbacks) {
                        if (msgPresenterCallback != null) {
                            msgPresenterCallback.onGetNavigationIndexResult(i2, str, list);
                        }
                    }
                }
            });
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onGetDetailRecommendResult(int i, final int i2, final String str, final RecommendsInfo recommendsInfo, DetailRecomendReqInfo detailRecomendReqInfo) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.presenter.business.MessageCenter.9.4
                @Override // java.lang.Runnable
                public void run() {
                    for (MsgPresenterCallback msgPresenterCallback : MessageCenter.this.callbacks) {
                        if (msgPresenterCallback != null) {
                            msgPresenterCallback.onGetDetailRecommendResult(i2, str, recommendsInfo);
                        }
                    }
                }
            });
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback
        public void onClearRedPointResult(int i, final int i2, final String str, ClearRedPointReqInfo clearRedPointReqInfo) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.presenter.business.MessageCenter.9.5
                @Override // java.lang.Runnable
                public void run() {
                    for (MsgPresenterCallback msgPresenterCallback : MessageCenter.this.callbacks) {
                        if (msgPresenterCallback != null) {
                            msgPresenterCallback.onClearRedPointResult(i2, str);
                        }
                    }
                }
            });
        }
    };
    private InitEngine initEngine = new InitEngine();

    public MessageCenter(JsonReqSender jsonReqSender) {
        this.logStartTime = 0L;
        this.initEngine.register(this.qaCallback, jsonReqSender);
        this.filterEngine = new FilterEngine();
        this.filterEngine.register(this.filterCallback, jsonReqSender);
        this.askEngine = new AskEngine();
        this.askEngine.register(this.qaCallback, jsonReqSender);
        this.hotEngine = new HotEngine();
        this.hotEngine.register(this.hotCallback, jsonReqSender);
        this.cosEngine = new GetCosFederationTokenEngine();
        this.cosEngine.register(this.cosCallback, jsonReqSender);
        this.logStartTime = (System.currentTimeMillis() / 1000) - 604800;
        this.historyLogEngine = new HistoryLogEngine();
        this.historyLogEngine.register(this.histroyLogCallback, jsonReqSender);
        this.recommendsEngine = new RecommendsEngine();
        this.recommendsEngine.register(this.recommendsCallback, jsonReqSender);
    }

    public void onDestroy() {
        this.initEngine.unregister(this.qaCallback);
        this.askEngine.unregister(this.qaCallback);
        this.filterEngine.unregister(this.filterCallback);
        this.hotEngine.unregister(this.hotCallback);
        this.historyLogEngine.unregister(this.histroyLogCallback);
        this.qaCallback = null;
        this.filterCallback = null;
        this.hotCallback = null;
        this.initEngine = null;
        this.askEngine = null;
        this.filterEngine = null;
        this.hotEngine = null;
        this.quNodeMap = null;
        this.callbacks.clear();
    }

    public String getCertificate() {
        AskEngine askEngine = this.askEngine;
        String certificate = askEngine != null ? askEngine.getCertificate() : "";
        if (certificate != null && !TextUtils.isEmpty(certificate)) {
            return certificate;
        }
        InitEngine initEngine = this.initEngine;
        return initEngine != null ? initEngine.getCertificate() : "";
    }

    public int initMessage(boolean z, boolean z2, boolean z3, MsgPresenterCallback msgPresenterCallback) {
        if (!z && msgPresenterCallback != null && !this.callbacks.contains(msgPresenterCallback)) {
            this.callbacks.add(msgPresenterCallback);
        }
        int initJsonRequest = this.initEngine.initJsonRequest(z3, z2);
        TLog.d(TAG, "initMessage seq:" + initJsonRequest + ",isRetry:" + z + ",question:");
        this.initTime = System.currentTimeMillis() / 1000;
        return initJsonRequest;
    }

    public void sendUnfilteredMessage(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TLog.d(TAG, "sendUnfilteredMessage message:" + str);
        this.filterEngine.sendJsonRequest(str, i);
    }

    public int sendValidMessage(String str, String str2, int i, int i2) {
        if (i >= 0) {
            this.lastPosition = i;
        }
        QuTextNode buildQuestionNode = buildQuestionNode(str, str2, i2);
        int sendAskJsonReq = this.askEngine.sendAskJsonReq(str, str2, this.initEngine.getCertificate(), i2);
        this.quNodeMap.put(Integer.valueOf(sendAskJsonReq), buildQuestionNode);
        TLog.d(TAG, "sendValidMessage seq:" + sendAskJsonReq + ",questionId:" + str + ",message:" + str2 + ",robotType:" + i2);
        return sendAskJsonReq;
    }

    public int getHot() {
        return this.hotEngine.sendHotReq();
    }

    public int getRecommends() {
        return this.recommendsEngine.getRecommends();
    }

    public int getNavigation(String str, String str2, String str3, int i, int i2) {
        return this.recommendsEngine.getNavigation(getCertificate(), str, str2, str3, i, i2);
    }

    public int getNavigationIndex() {
        return this.recommendsEngine.getNavigationIndex(getCertificate());
    }

    public int getDetailRecommends(String str, String str2, String str3, int i, int i2, String str4, String str5, RecommendsCallback recommendsCallback) {
        this.recommendsEngine.addCallback(recommendsCallback);
        return this.recommendsEngine.getDetailRecommends(getCertificate(), str, str2, str3, i, i2, str4, str5);
    }

    public int getRecommendDetail(String str, String str2, String str3, int i, int i2, String str4, String str5, RecommendsCallback recommendsCallback) {
        this.recommendsEngine.addCallback(recommendsCallback);
        return this.recommendsEngine.getRecommendDetail(getCertificate(), str, str2, str3, i, i2, str4, str5);
    }

    public int setLikeRecommend(String str, String str2, boolean z, RecommendsCallback recommendsCallback) {
        this.recommendsEngine.addCallback(recommendsCallback);
        return this.recommendsEngine.setRecommendLike(getCertificate(), str, str2, z);
    }

    public int clearRedPoint(RecommendsCallback recommendsCallback) {
        this.recommendsEngine.addCallback(recommendsCallback);
        return this.recommendsEngine.clearRedPoint(getCertificate());
    }

    public void removeDetailRecommendCallback(RecommendsCallback recommendsCallback) {
        this.recommendsEngine.removeCallback(recommendsCallback);
    }

    public void loadHistoryLog() {
        if (this.lastLoadHistorySucc) {
            this.lastLoadHistorySucc = false;
            this.historyLogEngine.getHistoryLog(getCertificate(), this.logStartTime, this.initTime, this.historylog_page);
            TLog.e("init", "initTime = " + this.initTime);
        }
    }

    public int getCosFederationToken(String str) {
        return this.cosEngine.sendGetCosFederationTokenReq(str);
    }

    public int recommendSearch(String str, RecommendsCallback recommendsCallback) {
        this.recommendsEngine.addCallback(recommendsCallback);
        return this.recommendsEngine.recommendSearch(getCertificate(), str);
    }

    public int getHotKeywords(RecommendsCallback recommendsCallback) {
        this.recommendsEngine.addCallback(recommendsCallback);
        return this.recommendsEngine.getHotKeywords(getCertificate());
    }

    public void removeRecommendCallback(RecommendsCallback recommendsCallback) {
        this.recommendsEngine.removeCallback(recommendsCallback);
    }

    private QuTextNode buildQuestionNode(String str, String str2, int i) {
        ArrayList<BaseNode> arrayList = new ArrayList<>();
        QuTextNode parseQuestion = DataProcessor.parseQuestion(str, str2, this.lastPosition, i);
        arrayList.add(parseQuestion);
        onLoadFinished(0, arrayList, null, -1, -1, "", false);
        return parseQuestion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInitLoadFinished(final int i, final ArrayList<BaseNode> arrayList, final AnsOptionNode ansOptionNode, final int i2, final int i3, final String str, final String str2, final JSONObject jSONObject, final String str3, final boolean z) {
        ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.presenter.business.MessageCenter.1
            @Override // java.lang.Runnable
            public void run() {
                for (MsgPresenterCallback msgPresenterCallback : MessageCenter.this.callbacks) {
                    if (msgPresenterCallback != null) {
                        MessageCenter.this.lastPosition = msgPresenterCallback.onInitLoadedFinished(i, arrayList, ansOptionNode, i2, i3, str, str2, jSONObject, str3, z);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadFinished(final int i, final ArrayList<BaseNode> arrayList, final AnsOptionNode ansOptionNode, final int i2, final int i3, final String str, final boolean z) {
        ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.presenter.business.MessageCenter.2
            @Override // java.lang.Runnable
            public void run() {
                for (MsgPresenterCallback msgPresenterCallback : MessageCenter.this.callbacks) {
                    if (msgPresenterCallback != null) {
                        MessageCenter.this.lastPosition = msgPresenterCallback.onLoadedFinished(i, arrayList, ansOptionNode, i2, i3, str, z);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadCacheFinished(final ArrayList<BaseNode> arrayList, final int i, final int i2, final boolean z, final boolean z2) {
        ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.presenter.business.MessageCenter.3
            @Override // java.lang.Runnable
            public void run() {
                for (MsgPresenterCallback msgPresenterCallback : MessageCenter.this.callbacks) {
                    if (msgPresenterCallback != null) {
                        MessageCenter.this.lastPosition = msgPresenterCallback.onLoadedCacheFinished(arrayList, null, i, i2, z, z2);
                    }
                }
            }
        });
    }
}
