package com.tencent.grobot.lite.presenter.business;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.grobot.lite.common.DataManager;
import com.tencent.grobot.lite.model.local.AnswerComponentInfo;
import com.tencent.grobot.lite.model.local.AnswerItemInfo;
import com.tencent.grobot.lite.model.local.EvaluateInfo;
import com.tencent.grobot.lite.model.local.OptionItemInfo;
import com.tencent.grobot.lite.model.node.AnsOptionNode;
import com.tencent.grobot.lite.model.node.AnsTextNode;
import com.tencent.grobot.lite.model.node.BaseNode;
import com.tencent.grobot.lite.model.node.ContainerNode;
import com.tencent.grobot.lite.model.node.FormNode;
import com.tencent.grobot.lite.model.node.GiftNode;
import com.tencent.grobot.lite.model.node.IMStarNode;
import com.tencent.grobot.lite.model.node.LikeUnlikeNode;
import com.tencent.grobot.lite.model.node.MixTipNode;
import com.tencent.grobot.lite.model.node.PicNode;
import com.tencent.grobot.lite.model.node.QuTextNode;
import com.tencent.grobot.lite.model.node.QuesListNode;
import com.tencent.grobot.lite.model.node.RecommendsNode;
import com.tencent.grobot.lite.model.node.TicketNode;
import com.tencent.grobot.lite.model.node.TicketStarNode;
import com.tencent.grobot.lite.model.node.VideoItem;
import com.tencent.grobot.lite.model.node.VideoNode;
import com.tencent.mtt.engine.http.HttpUtils;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class DataProcessor {
    public static final int ANSWER_ITEM_CONTAINER = 6;
    public static final int ANSWER_ITEM_FORM = 10;
    public static final int ANSWER_ITEM_GIFTPACK = 8;
    public static final int ANSWER_ITEM_HOTQUES = 7;
    public static final int ANSWER_ITEM_PIC = 2;
    public static final int ANSWER_ITEM_RECOMMENDS = 13;
    public static final int ANSWER_ITEM_ROLESWITCH = 9;
    public static final int ANSWER_ITEM_STAR = 12;
    public static final int ANSWER_ITEM_TEXT = 1;
    public static final int ANSWER_ITEM_TICKET = 11;
    public static final int ANSWER_ITEM_TIP = 4;
    public static final int ANSWER_ITEM_TOOL = 5;
    public static final int ANSWER_ITEM_VIDEO = 3;
    public static final int CHAT_ITEM_TIMESTAMP = 31;
    public static final int CHAT_ITEM_TOOL = 30;
    public static final int INVLID_TIME = -1000;
    public static final int MAX_TIME_INTERVAL = 300000;

    public static QuTextNode parseQuestion(String str, String str2, int i, int i2) {
        QuTextNode quTextNode = new QuTextNode();
        quTextNode.questionId = str;
        quTextNode.text = str2;
        quTextNode.position = i;
        quTextNode.robotType = i2;
        quTextNode.quSendingState = 0;
        quTextNode.questionOrderId = QueGenerator.get();
        Log.d("voken", "ques pos = " + i);
        return quTextNode;
    }

    public static ArrayList<BaseNode> parseAnswer(String str, String str2, String str3, byte b, ArrayList<AnswerItemInfo> arrayList, boolean z) {
        ArrayList<BaseNode> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<AnswerItemInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                parseAnswers(str, str2, str3, b, it.next(), arrayList2, z);
            }
        }
        LikeUnlikeNode likeUnlikeNode = null;
        int i = -1;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            BaseNode baseNode = arrayList2.get(i2);
            if (baseNode instanceof AnsTextNode) {
                i = i2;
            }
            if (baseNode instanceof LikeUnlikeNode) {
                likeUnlikeNode = (LikeUnlikeNode) baseNode;
            }
        }
        if (likeUnlikeNode != null) {
            if (i != -1) {
                ((AnsTextNode) arrayList2.get(i)).evaluateInfo = likeUnlikeNode.evaluateInfo;
            }
            arrayList2.remove(likeUnlikeNode);
        }
        return arrayList2;
    }

    public static AnsOptionNode parseOptions(ArrayList<OptionItemInfo> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        AnsOptionNode ansOptionNode = new AnsOptionNode();
        ansOptionNode.optionItems = arrayList;
        return ansOptionNode;
    }

    private static void parseAnswers(String str, String str2, String str3, byte b, AnswerItemInfo answerItemInfo, ArrayList<BaseNode> arrayList, boolean z) {
        BaseNode buildRecommendsNode;
        BaseNode buildFormNode;
        if (answerItemInfo == null || arrayList == null || answerItemInfo.contentList == null || answerItemInfo.contentList.size() <= 0) {
            return;
        }
        if (answerItemInfo.tplType == 1) {
            Iterator<AnswerComponentInfo> it = answerItemInfo.contentList.iterator();
            while (it.hasNext()) {
                arrayList.add(buildAnsTextNode(str, str2, str3, b, it.next()));
            }
            return;
        }
        if (answerItemInfo.tplType == 7) {
            BaseNode buildHotQuNode = buildHotQuNode(answerItemInfo);
            if (buildHotQuNode != null) {
                arrayList.add(buildHotQuNode);
                return;
            }
            return;
        }
        if (answerItemInfo.tplType == 10) {
            if (z || (buildFormNode = buildFormNode(answerItemInfo)) == null) {
                return;
            }
            arrayList.add(buildFormNode);
            return;
        }
        if (answerItemInfo.tplType == 11) {
            BaseNode buildTicketNode = buildTicketNode(answerItemInfo);
            if (buildTicketNode != null) {
                arrayList.add(buildTicketNode);
                return;
            }
            return;
        }
        if (answerItemInfo.tplType == 12) {
            if (z) {
                return;
            }
            Iterator<AnswerComponentInfo> it2 = answerItemInfo.contentList.iterator();
            while (it2.hasNext()) {
                BaseNode buildStarNode = buildStarNode(it2.next());
                if (buildStarNode != null) {
                    arrayList.add(buildStarNode);
                }
            }
            return;
        }
        if (answerItemInfo.tplType == 2) {
            BaseNode buildPicNode = buildPicNode(answerItemInfo);
            if (buildPicNode != null) {
                arrayList.add(buildPicNode);
                return;
            }
            return;
        }
        if (answerItemInfo.tplType == 3) {
            VideoNode buildVideoNode = buildVideoNode(answerItemInfo);
            if (buildVideoNode != null) {
                buildVideoNode.setNodeType(3);
                arrayList.add(buildVideoNode);
                return;
            }
            return;
        }
        if (answerItemInfo.tplType == 6) {
            BaseNode buildContainerNode = buildContainerNode(answerItemInfo);
            if (buildContainerNode != null) {
                arrayList.add(buildContainerNode);
                return;
            }
            return;
        }
        if (answerItemInfo.tplType == 4) {
            BaseNode buildMixTipNode = buildMixTipNode(answerItemInfo);
            if (buildMixTipNode != null) {
                arrayList.add(buildMixTipNode);
                return;
            }
            return;
        }
        if (answerItemInfo.tplType == 5) {
            return;
        }
        if (answerItemInfo.tplType == 8) {
            BaseNode buildGiftNode = buildGiftNode(answerItemInfo);
            if (buildGiftNode != null) {
                arrayList.add(buildGiftNode);
                return;
            }
            return;
        }
        if (answerItemInfo.tplType == 9 || answerItemInfo.tplType != 13 || (buildRecommendsNode = buildRecommendsNode(answerItemInfo)) == null) {
            return;
        }
        arrayList.add(buildRecommendsNode);
    }

    private static AnsTextNode buildAnsTextNode(String str, String str2, String str3, byte b, AnswerComponentInfo answerComponentInfo) {
        AnsTextNode ansTextNode = new AnsTextNode();
        if (answerComponentInfo != null) {
            ansTextNode.quesText = str3;
            ansTextNode.questionId = str2;
            ansTextNode.answerId = str;
            ansTextNode.status = b;
            ansTextNode.linkWord = answerComponentInfo.linkWord;
            ansTextNode.parseRichText(answerComponentInfo.text, null, answerComponentInfo.linkWord);
        }
        ansTextNode.initTime();
        return ansTextNode;
    }

    private static QuesListNode buildHotQuNode(AnswerItemInfo answerItemInfo) {
        QuesListNode quesListNode = new QuesListNode();
        Iterator<AnswerComponentInfo> it = answerItemInfo.contentList.iterator();
        while (it.hasNext()) {
            AnswerComponentInfo next = it.next();
            if (next != null && next.questionList != null && next.questionList.size() > 0) {
                quesListNode.hotQuesItems.addAll(next.questionList);
            }
        }
        if (quesListNode.hotQuesItems.size() == 0) {
            return null;
        }
        return quesListNode;
    }

    private static FormNode buildFormNode(AnswerItemInfo answerItemInfo) {
        FormNode formNode = new FormNode();
        formNode.formId = answerItemInfo.contentList.get(0).form_template_id;
        return formNode;
    }

    private static TicketNode buildTicketNode(AnswerItemInfo answerItemInfo) {
        TicketNode ticketNode = new TicketNode();
        ticketNode.ticketId = answerItemInfo.contentList.get(0).ticket_id;
        return ticketNode;
    }

    private static BaseNode buildStarNode(AnswerComponentInfo answerComponentInfo) {
        if (answerComponentInfo == null || answerComponentInfo.feedInfo == null) {
            return null;
        }
        if (answerComponentInfo.feedInfo.evaluateType.equals(EvaluateInfo.TYPE_ROBOT)) {
            LikeUnlikeNode likeUnlikeNode = new LikeUnlikeNode();
            likeUnlikeNode.evaluateInfo = answerComponentInfo.feedInfo;
            return likeUnlikeNode;
        }
        if (answerComponentInfo.feedInfo.evaluateType.equals(EvaluateInfo.TYPE_TICKET)) {
            TicketStarNode ticketStarNode = new TicketStarNode();
            ticketStarNode.title = answerComponentInfo.feedInfo.evaluateDesc;
            ticketStarNode.ticketId = answerComponentInfo.feedInfo.evaluateId;
            ticketStarNode.evaluateInfo = answerComponentInfo.feedInfo;
            return ticketStarNode;
        }
        if (!answerComponentInfo.feedInfo.evaluateType.equals(EvaluateInfo.TYPE_IM)) {
            return null;
        }
        IMStarNode iMStarNode = new IMStarNode();
        iMStarNode.title = answerComponentInfo.feedInfo.evaluateDesc;
        iMStarNode.sessionId = answerComponentInfo.feedInfo.evaluateId;
        iMStarNode.evaluateInfo = answerComponentInfo.feedInfo;
        return iMStarNode;
    }

    private static String buildUrl(String str, int i, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.contains("?")) {
            str4 = str + "?";
        } else {
            str4 = str + "&";
        }
        String str5 = "";
        if (!TextUtils.isEmpty(str2)) {
            try {
                str5 = URLEncoder.encode(URLEncoder.encode(str2, HttpUtils.DEFAULT_ENCODE_NAME), HttpUtils.DEFAULT_ENCODE_NAME);
            } catch (Throwable unused) {
            }
        }
        return str4 + "apiIndex=" + str3 + "&timePeriod=" + i + "&title=" + str5;
    }

    private static PicNode buildPicNode(AnswerItemInfo answerItemInfo) {
        if (answerItemInfo == null) {
            return null;
        }
        Iterator<AnswerComponentInfo> it = answerItemInfo.contentList.iterator();
        while (it.hasNext()) {
            AnswerComponentInfo next = it.next();
            if (next.picInfo != null) {
                PicNode picNode = new PicNode();
                picNode.resourceId = next.picInfo.resourceId;
                picNode.url = next.picInfo.url;
                picNode.name = next.picInfo.name;
                picNode.thumbImageUrl = next.picInfo.thumbImageUrl;
                return picNode;
            }
        }
        return null;
    }

    private static VideoNode buildVideoNode(AnswerItemInfo answerItemInfo) {
        if (answerItemInfo == null) {
            return null;
        }
        VideoNode videoNode = new VideoNode();
        Iterator<AnswerComponentInfo> it = answerItemInfo.contentList.iterator();
        while (it.hasNext()) {
            AnswerComponentInfo next = it.next();
            if (next.videoInfo != null) {
                VideoItem videoItem = new VideoItem();
                videoItem.resourceId = next.videoInfo.resourceId;
                videoItem.url = next.videoInfo.url;
                videoItem.name = next.videoInfo.name;
                videoItem.thumbImageUrl = next.videoInfo.thumbImageUrl;
                videoItem.videoId = next.videoInfo.videoId;
                videoItem.videoTime = next.videoInfo.videoTime;
                videoItem.videoTimes = next.videoInfo.videoViews;
                videoItem.videoSize = next.videoInfo.videoSize;
                videoNode.videoItemList.add(videoItem);
            }
        }
        return videoNode;
    }

    private static RecommendsNode buildRecommendsNode(AnswerItemInfo answerItemInfo) {
        if (answerItemInfo == null) {
            return null;
        }
        RecommendsNode recommendsNode = new RecommendsNode();
        Iterator<AnswerComponentInfo> it = answerItemInfo.contentList.iterator();
        while (it.hasNext()) {
            AnswerComponentInfo next = it.next();
            if (next.videoInfo != null) {
                VideoItem videoItem = new VideoItem();
                videoItem.resourceId = next.videoInfo.resourceId;
                videoItem.url = next.videoInfo.url;
                videoItem.name = next.videoInfo.name;
                videoItem.thumbImageUrl = next.videoInfo.thumbImageUrl;
                videoItem.videoId = next.videoInfo.videoId;
                videoItem.videoTime = next.videoInfo.videoTime;
                videoItem.videoTimes = next.videoInfo.videoViews;
                videoItem.videoSize = next.videoInfo.videoSize;
                recommendsNode.items.add(videoItem);
            }
            if (next.mixTip != null) {
                recommendsNode.items.add(next.mixTip);
            }
        }
        return recommendsNode;
    }

    private static MixTipNode buildMixTipNode(AnswerItemInfo answerItemInfo) {
        if (answerItemInfo == null) {
            return null;
        }
        Iterator<AnswerComponentInfo> it = answerItemInfo.contentList.iterator();
        while (it.hasNext()) {
            AnswerComponentInfo next = it.next();
            if (next.mixTip != null) {
                MixTipNode mixTipNode = new MixTipNode();
                mixTipNode.info = next.mixTip;
                return mixTipNode;
            }
        }
        return null;
    }

    private static ContainerNode buildContainerNode(AnswerItemInfo answerItemInfo) {
        if (answerItemInfo == null) {
            return null;
        }
        ContainerNode containerNode = new ContainerNode();
        Iterator<AnswerComponentInfo> it = answerItemInfo.contentList.iterator();
        while (it.hasNext()) {
            AnswerComponentInfo next = it.next();
            if (next.containerInfo != null) {
                containerNode.nodeList.add(next.containerInfo);
            }
        }
        return containerNode;
    }

    private static GiftNode buildGiftNode(AnswerItemInfo answerItemInfo) {
        if (answerItemInfo == null) {
            return null;
        }
        GiftNode giftNode = new GiftNode();
        Iterator<AnswerComponentInfo> it = answerItemInfo.contentList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AnswerComponentInfo next = it.next();
            if (next.giftInfo != null) {
                giftNode.isReceived = next.giftInfo.isReceived || DataManager.getInstance().getGiftGet(next.giftInfo.groupId, next.giftInfo.amsId);
                giftNode.name = next.giftInfo.packageName;
                giftNode.desc = next.giftInfo.packageDesc;
                giftNode.imageUrl = next.giftInfo.image;
                giftNode.groupId = next.giftInfo.groupId;
                giftNode.amsId = next.giftInfo.amsId;
                giftNode.answerId = next.giftInfo.answerId;
            }
        }
        return giftNode;
    }

    /* loaded from: classes2.dex */
    public static class QueGenerator {
        private static AtomicInteger SEQ = new AtomicInteger(1);

        public static int get() {
            return SEQ.getAndIncrement();
        }
    }
}
