package com.tencent.grobot.lite.ui.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ComponentRef;
import com.tencent.grobot.lite.common.DataManager;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.common.ToastUtils;
import com.tencent.grobot.lite.common.thread.ThreadManager;
import com.tencent.grobot.lite.core.IMPresenterCallback;
import com.tencent.grobot.lite.core.LogicPresenterCallback;
import com.tencent.grobot.lite.core.MsgPresenterCallback;
import com.tencent.grobot.lite.core.TicketPresenterCallback;
import com.tencent.grobot.lite.model.data.LikeUnlikeSelectInfo;
import com.tencent.grobot.lite.model.local.AnswerInfo;
import com.tencent.grobot.lite.model.local.EvaluateInfo;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.grobot.lite.model.local.HotTopicInfo;
import com.tencent.grobot.lite.model.local.IMMsgInfo;
import com.tencent.grobot.lite.model.local.NavigationInfo;
import com.tencent.grobot.lite.model.local.RecommendsInfo;
import com.tencent.grobot.lite.model.local.TagInfo;
import com.tencent.grobot.lite.model.node.AnsOptionNode;
import com.tencent.grobot.lite.model.node.AnsTextNode;
import com.tencent.grobot.lite.model.node.BaseNode;
import com.tencent.grobot.lite.model.node.FeedbackNode;
import com.tencent.grobot.lite.model.node.IMNotifacationNode;
import com.tencent.grobot.lite.model.node.IMServerTextNode;
import com.tencent.grobot.lite.model.node.IMStarNode;
import com.tencent.grobot.lite.model.node.QuTextNode;
import com.tencent.grobot.lite.model.node.TextInfoNode;
import com.tencent.grobot.lite.model.req.CommonReportReqInfo;
import com.tencent.grobot.lite.model.req.EvaluateReqInfo;
import com.tencent.grobot.lite.model.req.EventReportInfo;
import com.tencent.grobot.lite.model.req.GetPackageReqInfo;
import com.tencent.grobot.lite.presenter.PresenterService;
import com.tencent.grobot.lite.presenter.business.DataProcessor;
import com.tencent.grobot.lite.presenter.business.engine.BaseEngine;
import com.tencent.grobot.lite.presenter.business.engine.LogicEngine;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.model.HotInfo;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MainViewPresenter implements ComponentRef {
    private static int IM_MSG_MINLENGTH = 20;
    public static final String KEY_SHAREPERF_IMSTATUS = "KEY_SHAREPREF_IMSTATUS";
    public static final String KEY_SHAREPERF_SESSIONID = "KEY_SHAREPREF_SESSIONID";
    public static final String KEY_SHAREPERF_SETTINGS = "KEY_SHAREPERF_SETTINGS";
    public static final String TAG = "MainViewPresenter";
    private static final int TIMER_PULL = 3000;
    private Context context;
    private IIMView imView;
    private IMsgView msgView;
    private int mRobotStatus = 0;
    private String mImStatus = "";
    private String mIMSessionId = "";
    private String mIMTagId = "";
    private String mCacheQuestion = "";
    private MsgPresenterCallback msgCallback = new AnonymousClass1();
    private TicketPresenterCallback ticketCallback = new TicketPresenterCallback() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.2
        @Override // com.tencent.grobot.lite.core.TicketPresenterCallback
        public void onQueryTicketListResult(int i, int i2, String str, JSONObject jSONObject) {
        }

        @Override // com.tencent.grobot.lite.core.IServiceCallback
        public void onResult(int i, String str, Object... objArr) {
        }

        @Override // com.tencent.grobot.lite.core.TicketPresenterCallback
        public void onQueryFormTemplateDetailResult(int i, final int i2, final String str, final JSONObject jSONObject, String str2) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MainViewPresenter.this.imView != null) {
                        MainViewPresenter.this.imView.setFormData(i2, jSONObject);
                    }
                    if (i2 == 300309) {
                        MainViewPresenter.this.addChatTextMsg(str);
                    }
                }
            });
        }

        @Override // com.tencent.grobot.lite.core.TicketPresenterCallback
        public void onNewTicketResult(int i, final int i2, String str, final String str2) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.2.2
                @Override // java.lang.Runnable
                public void run() {
                    if (i2 == 0) {
                        MainViewPresenter.this.addTextMsg(MainViewPresenter.this.context.getString(R.string.form_info_commit_succ));
                    } else {
                        MainViewPresenter.this.addTextMsg(MainViewPresenter.this.context.getResources().getString(R.string.form_info_commit_fail));
                    }
                    if (MainViewPresenter.this.imView != null) {
                        MainViewPresenter.this.imView.onFormCommitResult(i2, str2);
                    }
                }
            });
        }

        @Override // com.tencent.grobot.lite.core.TicketPresenterCallback
        public void onQueryTicketDetailResult(int i, final int i2, String str, final JSONObject jSONObject, final String str2) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.2.3
                @Override // java.lang.Runnable
                public void run() {
                    if (MainViewPresenter.this.imView != null) {
                        MainViewPresenter.this.imView.onGetTicketDetail(str2, i2, jSONObject);
                    }
                }
            });
        }
    };
    IMPresenterCallback imCallback = new IMPresenterCallback() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.3
        @Override // com.tencent.grobot.lite.core.IServiceCallback
        public void onResult(int i, String str, Object... objArr) {
        }

        @Override // com.tencent.grobot.lite.core.IMPresenterCallback
        public void onCreateIMResult(int i, final int i2, String str, final JSONObject jSONObject) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i2 != 0) {
                        MainViewPresenter.this.addTextMsg(MainViewPresenter.this.context.getResources().getString(R.string.im_info_create_manualfail));
                        new Report().eventType("1011").itemId("7068").report(false);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("result");
                    MainViewPresenter.this.startIM("1");
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("im_session_id");
                        optJSONObject.optString("im_status");
                        if (optString == null || TextUtils.isEmpty(optString)) {
                            return;
                        }
                        MainViewPresenter.this.mIMSessionId = optString;
                        GRobotApplication.getInstance().setSharedParam(MainViewPresenter.KEY_SHAREPERF_SESSIONID, MainViewPresenter.this.mIMSessionId);
                        MainViewPresenter.this.pushIMMsg(MainViewPresenter.this.mCacheQuestion, MainViewPresenter.this.msgView != null ? MainViewPresenter.this.msgView.getLastPosition() : 0);
                    }
                }
            });
        }

        @Override // com.tencent.grobot.lite.core.IMPresenterCallback
        public void onPushIMMsgResult(final int i, final ArrayList<BaseNode> arrayList, final int i2, final int i3) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.3.2
                @Override // java.lang.Runnable
                public void run() {
                    if (MainViewPresenter.this.msgView != null) {
                        MainViewPresenter.this.msgView.onLoadMsgFinish(false, false, i, arrayList, MainViewPresenter.this.mRobotStatus, null, i2, i3, false, false);
                    }
                }
            });
        }

        @Override // com.tencent.grobot.lite.core.IMPresenterCallback
        public void onCloseIMResult(int i, int i2, String str, JSONObject jSONObject) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.3.3
                @Override // java.lang.Runnable
                public void run() {
                    if (MainViewPresenter.this.mRobotStatus == 1) {
                        MainViewPresenter.this.updateRobotStatus(0, "3");
                        MainViewPresenter.this.onCloseIm();
                    }
                }
            });
        }

        @Override // com.tencent.grobot.lite.core.IMPresenterCallback
        public void onPullIMMsgResult(final int i, final ArrayList<IMMsgInfo> arrayList) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.3.4
                @Override // java.lang.Runnable
                public void run() {
                    if (i == 0) {
                        MainViewPresenter.this.onGetIMMsg(arrayList);
                    }
                }
            });
        }
    };
    private LogicPresenterCallback logicPresenterCallback = new AnonymousClass4();
    private Timer timer = new Timer();

    /* loaded from: classes2.dex */
    public interface RobotStatus {
        public static final int Im = 1;
        public static final int Robot = 0;
    }

    public MainViewPresenter(IIMView iIMView, IMsgView iMsgView) {
        this.imView = iIMView;
        this.msgView = iMsgView;
        this.context = iIMView.context();
    }

    public void initRobot(boolean z) {
        String sharedParam = GRobotApplication.getInstance().getSharedParam(KEY_SHAREPERF_IMSTATUS, "0");
        this.mIMSessionId = GRobotApplication.getInstance().getSharedParam(KEY_SHAREPERF_SESSIONID, "");
        if (TextUtils.isEmpty(sharedParam)) {
            this.mRobotStatus = 0;
        } else {
            try {
                this.mRobotStatus = Integer.parseInt(sharedParam);
            } catch (NumberFormatException e) {
                TLog.d(TAG, "initRobot throw exception, ex=" + e);
                this.mRobotStatus = 0;
            }
        }
        initMsg(this.mRobotStatus == 1, z);
    }

    public void initMsg(boolean z, boolean z2) {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.initMessage(false, z2, z, this.msgCallback);
        }
    }

    public void loadHistoryLog() {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.loadHistoryLog();
        }
    }

    public void sendMsg(String str, String str2, int i, int i2) {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            int i3 = this.mRobotStatus;
            if (i3 != 0) {
                if (i3 == 1) {
                    pushIMMsg(str2, i);
                }
            } else {
                IMsgView iMsgView = this.msgView;
                if (iMsgView != null) {
                    iMsgView.onSendRobotMsg();
                }
                presenterService.sendValidMessage(str, str2, i, i2);
            }
        }
    }

    public void getHot() {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.getHot();
        }
    }

    public void getFormDetail(String str) {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.queryFormDetail(str, this.ticketCallback);
        }
    }

    public void commitForm(JSONObject jSONObject, String str, String str2, String str3, String str4) {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.newTicket(jSONObject.toString(), str, str2, str3, str4);
        }
    }

    public void getTicketDetail(String str) {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.queryTicketDetail(str, this.ticketCallback);
        }
    }

    public void createIM() {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.createIM(this.mIMTagId, this.imCallback);
        }
    }

    public void pullIMMsg() {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.pullIMMsg(this.imCallback);
        }
    }

    public void pushIMMsg(String str, int i) {
        if (this.mImStatus.equals("0")) {
            if (str.length() < IM_MSG_MINLENGTH) {
                addIMTextMsg(str);
                addChatTextMsg(this.context.getString(R.string.im_ready_msg_notenough, String.valueOf(IM_MSG_MINLENGTH)));
                new Report().eventType("1001").itemId("7083").report(false);
                return;
            } else {
                this.mCacheQuestion = str;
                createIM();
                return;
            }
        }
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.pushIMMsg(1, str, this.mIMSessionId, i);
        }
    }

    public void closeIM() {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.closeIM(this.mIMSessionId, this.imCallback);
        }
    }

    public void evalueate(int i, EvaluateInfo evaluateInfo) {
        EvaluateItemInfo findFeedbackItemInfo = findFeedbackItemInfo(i, evaluateInfo);
        if (findFeedbackItemInfo != null) {
            addEvaluate(i, findFeedbackItemInfo, false);
            if (findFeedbackItemInfo.actionType.equals(EvaluateItemInfo.ACTIONTYPE_API)) {
                FeedbackNode feedbackNode = new FeedbackNode();
                feedbackNode.desc = findFeedbackItemInfo.commitText;
                addMsgToChatView(feedbackNode);
                return;
            }
            if (findFeedbackItemInfo.actionType.equals("ext")) {
                LikeUnlikeSelectInfo likeUnlideSelectInfo = DataManager.getInstance().getLikeUnlideSelectInfo(findFeedbackItemInfo.answerKey);
                if (likeUnlideSelectInfo == null) {
                    likeUnlideSelectInfo = new LikeUnlikeSelectInfo();
                }
                likeUnlideSelectInfo.firstText = findFeedbackItemInfo.optionText;
                DataManager.getInstance().setLikeUnlikeSelected(findFeedbackItemInfo.answerKey, likeUnlideSelectInfo);
                AnsOptionNode ansOptionNode = new AnsOptionNode();
                ansOptionNode.evaluateItemInfos = findFeedbackItemInfo.extInfos;
                ansOptionNode.answerKey = String.valueOf(System.currentTimeMillis());
                ansOptionNode.needReport = true;
                findFeedbackItemInfo.answerKey = ansOptionNode.answerKey;
                Iterator<EvaluateItemInfo> it = findFeedbackItemInfo.extInfos.iterator();
                while (it.hasNext()) {
                    EvaluateItemInfo next = it.next();
                    next.answerKey = findFeedbackItemInfo.answerKey;
                    next.commitText = findFeedbackItemInfo.commitText;
                }
                addOptionToChatView(ansOptionNode);
            }
        }
    }

    public void addEvaluate(int i, EvaluateItemInfo evaluateItemInfo, boolean z) {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.addEvaluate(i, evaluateItemInfo, z, this.logicPresenterCallback);
        }
    }

    private EvaluateItemInfo findFeedbackItemInfo(int i, EvaluateInfo evaluateInfo) {
        if (evaluateInfo == null || evaluateInfo.options == null) {
            return null;
        }
        Iterator<EvaluateItemInfo> it = evaluateInfo.options.iterator();
        while (it.hasNext()) {
            EvaluateItemInfo next = it.next();
            if (next.evaluateValue == i) {
                return next;
            }
        }
        return null;
    }

    public void getCosFederationToken() {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.getCosFederationToken();
        }
    }

    public void readyEnterIM(String str) {
        this.mIMTagId = str;
        onEnterImStatus();
        String str2 = this.mCacheQuestion;
        if (str2 == null || str2.length() < IM_MSG_MINLENGTH) {
            addChatTextMsg(this.context.getString(R.string.im_ready_enter_intro, String.valueOf(IM_MSG_MINLENGTH)));
        } else {
            createIM();
        }
        new Report().eventType("1011").itemId("7069").report(false);
    }

    public void getGiftPackage(String str, String str2, String str3, String str4) {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.getGiftPackage(str, str2, str3, str4, this.logicPresenterCallback);
        }
    }

    @Override // com.tencent.grobot.lite.common.ComponentRef
    public void onDestroy() {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.removeMsgCenterCall(this.msgCallback);
        }
        this.imView = null;
        this.msgView = null;
        this.msgCallback = null;
        this.ticketCallback = null;
        this.imCallback = null;
    }

    /* renamed from: com.tencent.grobot.lite.ui.presenter.MainViewPresenter$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements MsgPresenterCallback {
        @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
        public void onClearRedPointResult(int i, String str) {
        }

        @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
        public void onGetDetailRecommendResult(int i, String str, RecommendsInfo recommendsInfo) {
        }

        @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
        public void onGetNavigationIndexResult(int i, String str, List<TagInfo> list) {
        }

        @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
        public void onGetNavigationResult(int i, int i2, String str, NavigationInfo navigationInfo) {
        }

        @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
        public void onGetRecommendResult(int i, String str, List<RecommendsInfo> list) {
        }

        @Override // com.tencent.grobot.lite.core.IServiceCallback
        public void onResult(int i, String str, Object... objArr) {
        }

        AnonymousClass1() {
        }

        @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
        public void onGetHotResult(final int i, String str, final ArrayList<HotTopicInfo> arrayList) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i == 0) {
                        ArrayList<HotInfo> arrayList2 = new ArrayList<>();
                        arrayList2.clear();
                        ArrayList arrayList3 = arrayList;
                        if (arrayList3 == null) {
                            return;
                        }
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            HotTopicInfo hotTopicInfo = (HotTopicInfo) it.next();
                            HotInfo hotInfo = new HotInfo();
                            hotInfo.title = hotTopicInfo.name;
                            hotInfo.questionId = hotTopicInfo.questionId;
                            hotInfo.selected = false;
                            hotInfo.desc = hotTopicInfo.desc;
                            arrayList2.add(hotInfo);
                        }
                        if (MainViewPresenter.this.msgView != null) {
                            MainViewPresenter.this.msgView.onGetHostSucc(arrayList2);
                        }
                    }
                }
            });
        }

        @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
        public int onInitLoadedFinished(final int i, final ArrayList<BaseNode> arrayList, final AnsOptionNode ansOptionNode, final int i2, final int i3, final String str, final String str2, final JSONObject jSONObject, String str3, final boolean z) {
            TLog.d(MainViewPresenter.TAG, "onInitLoadedFinished, code=" + i + ", reinit=" + BaseEngine.sReInit);
            if (BaseEngine.sReInit) {
                return 0;
            }
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.1.2
                @Override // java.lang.Runnable
                public void run() {
                    if (MainViewPresenter.this.msgView != null) {
                        if (i == 0) {
                            MainViewPresenter.this.getHot();
                            MainViewPresenter.this.getCosFederationToken();
                            if (str.equals(EvaluateInfo.TYPE_IM)) {
                                MainViewPresenter.this.startIM(str2);
                                MainViewPresenter.this.msgView.onLoadMsgFinish(true, true, i, arrayList, MainViewPresenter.this.mRobotStatus, ansOptionNode, i2, i3, false, true);
                                return;
                            }
                            if (MainViewPresenter.this.mRobotStatus == 1 && !str.equals(EvaluateInfo.TYPE_IM)) {
                                MainViewPresenter.this.updateRobotStatus(0, str2);
                                MainViewPresenter.this.pullIMMsg();
                                ThreadManager.get().postDelayToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.1.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        MainViewPresenter.this.initMsg(false, false);
                                    }
                                }, 1000L);
                                return;
                            } else {
                                JSONObject jSONObject2 = jSONObject;
                                if (jSONObject2 != null) {
                                    int optInt = jSONObject2.optInt("imLimitNum");
                                    if (optInt > 0) {
                                        int unused = MainViewPresenter.IM_MSG_MINLENGTH = optInt;
                                    }
                                    GRobotApplication.getInstance().setSharedParam(MainViewPresenter.KEY_SHAREPERF_SETTINGS, jSONObject.toString());
                                }
                            }
                        }
                        if (z) {
                            MainViewPresenter.this.msgView.onPureInitFinish(i == 0);
                        } else {
                            MainViewPresenter.this.msgView.onLoadMsgFinish(true, true, i, arrayList, MainViewPresenter.this.mRobotStatus, ansOptionNode, i2, i3, false, true);
                        }
                    }
                }
            });
            if (MainViewPresenter.this.msgView == null) {
                return 0;
            }
            MainViewPresenter.this.msgView.onInitFinish(jSONObject != null ? jSONObject.optBoolean("isShowLoading") : false);
            return MainViewPresenter.this.msgView.getLastPosition();
        }

        @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
        public int onLoadedFinished(final int i, final ArrayList<BaseNode> arrayList, final AnsOptionNode ansOptionNode, final int i2, final int i3, String str, final boolean z) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (MainViewPresenter.this.msgView != null) {
                        MainViewPresenter.this.msgView.onLoadMsgFinish(false, false, i, arrayList, MainViewPresenter.this.mRobotStatus, ansOptionNode, i2, i3, z, true);
                    }
                }
            });
            if (MainViewPresenter.this.msgView != null) {
                return MainViewPresenter.this.msgView.getLastPosition();
            }
            return 0;
        }

        @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
        public int onLoadedCacheFinished(final ArrayList<BaseNode> arrayList, final AnsOptionNode ansOptionNode, final int i, final int i2, final boolean z, final boolean z2) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.1.4
                @Override // java.lang.Runnable
                public void run() {
                    if (MainViewPresenter.this.msgView != null) {
                        MainViewPresenter.this.msgView.onLoadCacheFinish(z, z2, arrayList, MainViewPresenter.this.mRobotStatus, ansOptionNode, i, i2, true);
                    }
                }
            });
            if (MainViewPresenter.this.msgView != null) {
                return MainViewPresenter.this.msgView.getLastPosition();
            }
            return 0;
        }
    }

    /* renamed from: com.tencent.grobot.lite.ui.presenter.MainViewPresenter$4, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass4 implements LogicPresenterCallback {
        @Override // com.tencent.grobot.lite.core.LogicPresenterCallback
        public void onCommonReportResult(int i, String str, CommonReportReqInfo commonReportReqInfo) {
        }

        @Override // com.tencent.grobot.lite.core.LogicPresenterCallback
        public void onReportEventResult(int i, String str, EventReportInfo eventReportInfo) {
        }

        @Override // com.tencent.grobot.lite.core.IServiceCallback
        public void onResult(int i, String str, Object... objArr) {
        }

        AnonymousClass4() {
        }

        @Override // com.tencent.grobot.lite.core.LogicPresenterCallback
        public void onEvaluateResult(final int i, String str, final EvaluateReqInfo evaluateReqInfo) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.4.1
                @Override // java.lang.Runnable
                public void run() {
                    if (evaluateReqInfo != null) {
                        if (MainViewPresenter.this.msgView != null) {
                            MainViewPresenter.this.msgView.onEvaluateResult(i == 0, evaluateReqInfo);
                            if (i == 0 && !TextUtils.isEmpty(evaluateReqInfo.commitText)) {
                                ThreadManager.get().postDelayToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.4.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        MainViewPresenter.this.addTextMsg(evaluateReqInfo.commitText);
                                    }
                                }, 100L);
                            }
                        }
                        if (TextUtils.isEmpty(evaluateReqInfo.selectContent)) {
                            return;
                        }
                        if (evaluateReqInfo.iconType.equals("helpful")) {
                            MainViewPresenter.this.addUserTextMsg("evaluate:helpfull");
                        } else {
                            MainViewPresenter.this.addUserTextMsg(evaluateReqInfo.selectContent);
                        }
                    }
                }
            });
        }

        @Override // com.tencent.grobot.lite.core.LogicPresenterCallback
        public void onGetPackageResult(final int i, String str, AnswerInfo answerInfo, GetPackageReqInfo getPackageReqInfo) {
            if (getPackageReqInfo != null) {
                String str2 = "0";
                if (MainViewPresenter.this.msgView != null) {
                    MainViewPresenter.this.msgView.onGetPackageResult(i, str, getPackageReqInfo.groupId, getPackageReqInfo.amsId);
                    if (answerInfo != null) {
                        final ArrayList<BaseNode> parseAnswer = DataProcessor.parseAnswer(answerInfo.answerId, answerInfo.questionId, "", (byte) 0, answerInfo.answerList, false);
                        final AnsOptionNode parseOptions = DataProcessor.parseOptions(answerInfo.optionList);
                        ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.4.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (MainViewPresenter.this.msgView != null) {
                                    int i2 = i;
                                    MainViewPresenter.this.msgView.onLoadMsgFinish(false, false, (i2 == LogicEngine.GIFT_FAIL || i == LogicEngine.GFIT_REGET) ? 0 : i2, parseAnswer, MainViewPresenter.this.mRobotStatus, parseOptions, -1, -1, false, true);
                                }
                            }
                        });
                    } else {
                        str2 = "3";
                        ToastUtils.getInstance().showErrorTips(GRobotApplication.self(), 0);
                    }
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ReportBridge.KEY_EVENT_TYPE, ReportBridge.VALUE_GIFT);
                    jSONObject.put(ReportBridge.KEY_ITEM_ID, "7156");
                    jSONObject.put(ReportBridge.KEY_SUB_ID, getPackageReqInfo.amsId + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + getPackageReqInfo.groupId);
                    jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, Constants.VIA_SHARE_TYPE_INFO);
                    if (i == 0) {
                        str2 = "0";
                    } else if (i == LogicEngine.GFIT_REGET) {
                        str2 = "1";
                    } else if (i == LogicEngine.GIFT_FAIL) {
                        str2 = "2";
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("giftfailedreason", str2);
                    jSONObject.put("ext", jSONObject2.toString());
                    ReportBridge.report(jSONObject, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetIMMsg(ArrayList<IMMsgInfo> arrayList) {
        ArrayList<BaseNode> arrayList2 = new ArrayList<>();
        if (arrayList == null) {
            return;
        }
        Iterator<IMMsgInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            IMMsgInfo next = it.next();
            if (next.msgType == 1) {
                IMServerTextNode iMServerTextNode = new IMServerTextNode();
                iMServerTextNode.agentName = next.agentName;
                iMServerTextNode.msg = next.content;
                if (iMServerTextNode.msg != null && !TextUtils.isEmpty(iMServerTextNode.msg)) {
                    arrayList2.add(iMServerTextNode);
                }
            } else if (next.msgType == 0) {
                IIMView iIMView = this.imView;
                if (iIMView != null) {
                    iIMView.updateBottomActionView(this.mRobotStatus, "1", next.sysMsg);
                }
                if (next.sysMsg != null && next.sysMsg.subType == 1) {
                    if (next.sysMsg.sessionStatus == 2) {
                        IMNotifacationNode iMNotifacationNode = new IMNotifacationNode();
                        iMNotifacationNode.msg = String.format(this.context.getString(R.string.im_info_queuing_succ), next.agentName);
                        arrayList2.add(iMNotifacationNode);
                        this.mCacheQuestion = "";
                    } else if (next.sysMsg.sessionStatus == 3 && this.mRobotStatus == 1) {
                        updateRobotStatus(0, "3");
                        onCloseIm();
                        new Report().eventType("1011").itemId("7070").report(false);
                    }
                }
            } else if (next.msgType == 6) {
                IMStarNode iMStarNode = new IMStarNode();
                iMStarNode.sessionId = next.sessionId;
                iMStarNode.evaluateInfo = next.evaluateInfo;
                if (iMStarNode.sessionId != null && !TextUtils.isEmpty(iMStarNode.sessionId)) {
                    arrayList2.add(iMStarNode);
                }
            }
        }
        if (arrayList2.size() > 0) {
            addMsgsToChatView(arrayList2);
        }
    }

    private void addIMTextMsg(String str) {
        QuTextNode quTextNode = new QuTextNode();
        quTextNode.text = str;
        quTextNode.quSendingState = 1;
        addMsgToChatView(quTextNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTextMsg(String str) {
        TextInfoNode textInfoNode = new TextInfoNode();
        textInfoNode.msg = str;
        addMsgToChatView(textInfoNode);
    }

    private void addMiddleNotificationMsg(String str) {
        IMNotifacationNode iMNotifacationNode = new IMNotifacationNode();
        iMNotifacationNode.msg = str;
        addMsgToChatView(iMNotifacationNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addChatTextMsg(String str) {
        AnsTextNode ansTextNode = new AnsTextNode();
        ansTextNode.rawText = str;
        addMsgToChatView(ansTextNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUserTextMsg(String str) {
        QuTextNode quTextNode = new QuTextNode();
        quTextNode.text = str;
        quTextNode.quSendingState = 1;
        addMsgToChatView(quTextNode);
    }

    private void addMsgToChatView(BaseNode baseNode) {
        if (this.msgView != null) {
            ArrayList<BaseNode> arrayList = new ArrayList<>();
            arrayList.add(baseNode);
            this.msgView.onLoadMsgFinish(false, false, 0, arrayList, this.mRobotStatus, null, -1, -1, false, false);
        }
    }

    private void addOptionToChatView(AnsOptionNode ansOptionNode) {
        IMsgView iMsgView = this.msgView;
        if (iMsgView != null) {
            iMsgView.onLoadMsgFinish(false, false, 0, null, this.mRobotStatus, ansOptionNode, -1, -1, false, true);
        }
    }

    private void addMsgsToChatView(ArrayList<BaseNode> arrayList) {
        IMsgView iMsgView = this.msgView;
        if (iMsgView != null) {
            iMsgView.onLoadMsgFinish(false, false, 0, arrayList, this.mRobotStatus, null, -1, -1, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRobotStatus(int i, String str) {
        this.mRobotStatus = i;
        this.mImStatus = str;
        GRobotApplication.getInstance().setSharedParam(KEY_SHAREPERF_IMSTATUS, String.valueOf(this.mRobotStatus));
        IIMView iIMView = this.imView;
        if (iIMView != null) {
            iIMView.updateBottomActionView(i, str, null);
        }
    }

    private void onEnterImStatus() {
        updateRobotStatus(1, "0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startIM(String str) {
        updateRobotStatus(1, str);
        if (this.timer == null) {
            this.timer = new Timer();
        }
        this.timer.schedule(new TimerTask() { // from class: com.tencent.grobot.lite.ui.presenter.MainViewPresenter.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MainViewPresenter.this.pullIMMsg();
            }
        }, 50L, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCloseIm() {
        this.mIMSessionId = "";
        GRobotApplication.getInstance().setSharedParam(KEY_SHAREPERF_SESSIONID, "");
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
        addMiddleNotificationMsg(this.context.getString(R.string.im_info_queuing_quit));
    }
}
