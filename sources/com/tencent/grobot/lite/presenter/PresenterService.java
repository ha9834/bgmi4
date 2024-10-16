package com.tencent.grobot.lite.presenter;

import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.core.IMPresenterCallback;
import com.tencent.grobot.lite.core.IService;
import com.tencent.grobot.lite.core.LogicPresenterCallback;
import com.tencent.grobot.lite.core.MsgPresenterCallback;
import com.tencent.grobot.lite.core.TicketPresenterCallback;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.grobot.lite.presenter.business.IMCenter;
import com.tencent.grobot.lite.presenter.business.LogicCenter;
import com.tencent.grobot.lite.presenter.business.MessageCenter;
import com.tencent.grobot.lite.presenter.business.TicketCenter;
import com.tencent.grobot.lite.presenter.business.callback.RecommendsCallback;
import com.tencent.grobot.lite.presenter.transport.json.JsonReqSender;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PresenterService implements IService {
    private static final int DEFAULT_PAGE_SIZE = 12;
    public static final int NAVIGATION_TYPE_HOT = 0;
    public static final int NAVIGATION_TYPE_NEW = 1;
    private final GRobotApplication app;
    private JsonReqSender jsonReqSender = new JsonReqSender();
    private MessageCenter msgCenter = new MessageCenter(this.jsonReqSender);
    private TicketCenter ticketCenter = new TicketCenter(this.jsonReqSender);
    private IMCenter imCenter = new IMCenter(this.jsonReqSender);
    private LogicCenter logicCenter = new LogicCenter(this.jsonReqSender);

    /* loaded from: classes2.dex */
    public static class RobotType {
        public static final int ANS_RESULT = 8;
        public static final int ASK_EXTRA = 5;
        public static final int CONTAINER = 3;
        public static final int DEFAULT = 0;
        public static final int FIRST_QUES = 1;
        public static final int INPUT_PLUS = 4;
        public static final int INPUT_RECOMMAND = 6;
        public static final int LEFT_HOT = 10;
        public static final int OPTION = 2;
        public static final int TEXT_CLICK = 7;
        public static final int VOICE = 9;
    }

    public PresenterService(GRobotApplication gRobotApplication) {
        this.app = gRobotApplication;
    }

    public int initMessage(boolean z, boolean z2, boolean z3, MsgPresenterCallback msgPresenterCallback) {
        return this.msgCenter.initMessage(z, z2, z3, msgPresenterCallback);
    }

    public void sendUnfilteredMessage(String str, int i) {
        this.msgCenter.sendUnfilteredMessage(str, i);
    }

    public int sendValidMessage(String str, String str2, int i, int i2) {
        return this.msgCenter.sendValidMessage(str, str2, i, i2);
    }

    public int getHot() {
        return this.msgCenter.getHot();
    }

    public int getRecommends() {
        return this.msgCenter.getRecommends();
    }

    public int getNavigation(String str, String str2, int i, int i2) {
        return this.msgCenter.getNavigation(str, str2, i == 0 ? "hot" : "new", i2, 12);
    }

    public int getNavigationIndex() {
        return this.msgCenter.getNavigationIndex();
    }

    public int getDetailRecommends(String str, String str2, String str3, int i, int i2, String str4, String str5, RecommendsCallback recommendsCallback) {
        return this.msgCenter.getDetailRecommends(str, str2, str3, i, i2, str4, str5, recommendsCallback);
    }

    public int getRecommendDetail(String str, String str2, String str3, int i, int i2, String str4, String str5, RecommendsCallback recommendsCallback) {
        return this.msgCenter.getRecommendDetail(str, str2, str3, i, i2, str4, str5, recommendsCallback);
    }

    public int setLikeRecommend(String str, String str2, boolean z, RecommendsCallback recommendsCallback) {
        return this.msgCenter.setLikeRecommend(str, str2, z, recommendsCallback);
    }

    public int clearRedPoint(RecommendsCallback recommendsCallback) {
        return this.msgCenter.clearRedPoint(recommendsCallback);
    }

    public void removeDetailRecommendCallback(RecommendsCallback recommendsCallback) {
        this.msgCenter.removeDetailRecommendCallback(recommendsCallback);
    }

    public int queryFormDetail(String str, TicketPresenterCallback ticketPresenterCallback) {
        return this.ticketCenter.queryFormDetail(this.msgCenter.getCertificate(), str, ticketPresenterCallback);
    }

    public int newTicket(String str, String str2, String str3, String str4, String str5) {
        return this.ticketCenter.newTicket(this.msgCenter.getCertificate(), str, str2, str3, str4, str5);
    }

    public int queryTicketList(TicketPresenterCallback ticketPresenterCallback) {
        return this.ticketCenter.queryTicketList(this.msgCenter.getCertificate(), ticketPresenterCallback);
    }

    public int queryTicketDetail(String str, TicketPresenterCallback ticketPresenterCallback) {
        return this.ticketCenter.queryTicketDetail(this.msgCenter.getCertificate(), str, ticketPresenterCallback);
    }

    public int createIM(String str, IMPresenterCallback iMPresenterCallback) {
        return this.imCenter.createIM(this.msgCenter.getCertificate(), str, iMPresenterCallback);
    }

    public int pushIMMsg(int i, String str, String str2, int i2) {
        return this.imCenter.pushIMMsg(this.msgCenter.getCertificate(), i, str, str2, i2);
    }

    public int pullIMMsg(IMPresenterCallback iMPresenterCallback) {
        return this.imCenter.pullIMMsg(this.msgCenter.getCertificate(), iMPresenterCallback);
    }

    public int closeIM(String str, IMPresenterCallback iMPresenterCallback) {
        return this.imCenter.closeIM(this.msgCenter.getCertificate(), str, iMPresenterCallback);
    }

    public int addEvaluate(int i, EvaluateItemInfo evaluateItemInfo, boolean z, LogicPresenterCallback logicPresenterCallback) {
        return this.logicCenter.addEvaluate(this.msgCenter.getCertificate(), i, evaluateItemInfo, z, logicPresenterCallback);
    }

    public int reportEvent(String str, String str2, String str3, LogicPresenterCallback logicPresenterCallback) {
        return this.logicCenter.reportEvent(this.msgCenter.getCertificate(), str, str2, str3, logicPresenterCallback);
    }

    public int reportCommon(ArrayList<String> arrayList, LogicPresenterCallback logicPresenterCallback) {
        return this.logicCenter.reportCommon(this.msgCenter.getCertificate(), arrayList, logicPresenterCallback);
    }

    public void loadHistoryLog() {
        this.msgCenter.loadHistoryLog();
    }

    public int getCosFederationToken() {
        MessageCenter messageCenter = this.msgCenter;
        return messageCenter.getCosFederationToken(messageCenter.getCertificate());
    }

    public int getGiftPackage(String str, String str2, String str3, String str4, LogicPresenterCallback logicPresenterCallback) {
        return this.logicCenter.getGiftPackage(this.msgCenter.getCertificate(), str, str2, str3, str4, logicPresenterCallback);
    }

    public int recommendSearch(String str, RecommendsCallback recommendsCallback) {
        return this.msgCenter.recommendSearch(str, recommendsCallback);
    }

    public int getHotKeywords(RecommendsCallback recommendsCallback) {
        return this.msgCenter.getHotKeywords(recommendsCallback);
    }

    public void addMsgCenterCall(MsgPresenterCallback msgPresenterCallback) {
        if (this.msgCenter.callbacks.contains(msgPresenterCallback)) {
            return;
        }
        this.msgCenter.callbacks.add(msgPresenterCallback);
    }

    public void removeMsgCenterCall(MsgPresenterCallback msgPresenterCallback) {
        this.msgCenter.callbacks.remove(msgPresenterCallback);
    }

    public void removeRecommendCallback(RecommendsCallback recommendsCallback) {
        this.msgCenter.removeRecommendCallback(recommendsCallback);
    }

    public List<MsgPresenterCallback> getMsgCenterCalls() {
        return this.msgCenter.callbacks;
    }

    @Override // com.tencent.grobot.lite.core.IService
    public void onDestroy() {
        MessageCenter messageCenter = this.msgCenter;
        if (messageCenter != null) {
            messageCenter.onDestroy();
            this.jsonReqSender.onDestroy();
        }
    }

    public String getCertificate() {
        MessageCenter messageCenter = this.msgCenter;
        return messageCenter != null ? messageCenter.getCertificate() : "";
    }
}
