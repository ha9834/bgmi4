package com.tencent.grobot.lite.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.grobot.lite.common.DataManager;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.common.thread.ThreadManager;
import com.tencent.grobot.lite.model.data.LikeUnlikeSelectInfo;
import com.tencent.grobot.lite.model.node.AnsTextNode;
import com.tencent.grobot.lite.model.node.BaseNode;
import com.tencent.grobot.lite.model.node.FeedbackNode;
import com.tencent.grobot.lite.model.node.FormNode;
import com.tencent.grobot.lite.model.node.GiftNode;
import com.tencent.grobot.lite.model.node.IMStarNode;
import com.tencent.grobot.lite.model.node.QuTextNode;
import com.tencent.grobot.lite.model.node.TicketStarNode;
import com.tencent.grobot.lite.presenter.business.engine.LogicEngine;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.ChatFeedbackItemViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.ChatQuItemViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.ChatTextInfoViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.ChatTextItemViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.ContainerHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.FormViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.GiftViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.IMMiddleNotificationViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.IMServerTextViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.IMUserScoreViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.MixTipHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.PicViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.QuesListViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.RecommendViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.TicketStarViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.TicketViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.VideoViewHolder;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ChatAdapter extends BaseViewAdapter<BaseNode> {
    private static final String TAG = "ChatAdapter";

    public ChatAdapter(Context context) {
        super(context);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
    protected BaseViewHolder buildViewHolder(ViewGroup viewGroup, int i) {
        TLog.d(TAG, "buildViewHolder, vt=" + i);
        if (i == 13) {
            return new RecommendViewHolder(this.context, viewGroup, i, this.clickListener);
        }
        if (i == 21) {
            return new ChatQuItemViewHolder(this.context, viewGroup, i, this.clickListener);
        }
        if (i == 24) {
            return new ChatFeedbackItemViewHolder(this.context, viewGroup, i, this.clickListener);
        }
        if (i != 51) {
            switch (i) {
                case 1:
                    return new ChatTextItemViewHolder(this.context, viewGroup, i, this.clickListener);
                case 2:
                    return new PicViewHolder(this.context, viewGroup, i, this.clickListener);
                case 3:
                    return new VideoViewHolder(this.context, viewGroup, i, this.clickListener);
                case 4:
                    return new MixTipHolder(this.context, viewGroup, i, this.clickListener);
                default:
                    switch (i) {
                        case 6:
                            return new ContainerHolder(this.context, viewGroup, i, this.clickListener);
                        case 7:
                            return new QuesListViewHolder(this.context, viewGroup, i, this.clickListener);
                        case 8:
                            return new ChatTextInfoViewHolder(this.context, viewGroup, i, null);
                        default:
                            switch (i) {
                                case 31:
                                    return new FormViewHolder(this.context, viewGroup, i, this.clickListener);
                                case 32:
                                    return new TicketViewHolder(this.context, viewGroup, i, this.clickListener);
                                case 33:
                                    return new TicketStarViewHolder(this.context, viewGroup, i, this.clickListener);
                                default:
                                    switch (i) {
                                        case 41:
                                            return new IMServerTextViewHolder(this.context, i, null);
                                        case 42:
                                            return new IMMiddleNotificationViewHolder(this.context, i, null);
                                        case 43:
                                            return new IMUserScoreViewHolder(this.context, viewGroup, i, this.clickListener);
                                        default:
                                            return null;
                                    }
                            }
                    }
            }
        }
        return new GiftViewHolder(this.context, viewGroup, i, this.clickListener);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
    protected int getItemViewTypeByPosition(int i) {
        BaseNode baseNode;
        if (this.datas == null || i >= this.datas.size() || (baseNode = (BaseNode) this.datas.get(i)) == null) {
            return 0;
        }
        return baseNode.getType();
    }

    @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
    public void refreshItem(int i, int i2, int i3) {
        QuTextNode findQuTextNode;
        if (this.datas == null || i < 0 || i >= this.datas.size() || (findQuTextNode = findQuTextNode(i, i2)) == null) {
            return;
        }
        findQuTextNode.quSendingState = i3;
        notifyItemChanged(findQuTextNode.position);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
    protected boolean isLastTextItem(int i) {
        if (this.datas == null || i < 0 || i >= this.datas.size()) {
            return false;
        }
        for (int i2 = i + 1; i2 < this.datas.size(); i2++) {
            if (this.datas.get(i2) instanceof AnsTextNode) {
                return false;
            }
        }
        return true;
    }

    public void refreshAnsTextItemLikeUnlike(String str, String str2, String str3) {
        BaseNode findAnsTextNode = findAnsTextNode(str);
        if (findAnsTextNode != null) {
            LikeUnlikeSelectInfo likeUnlideSelectInfo = DataManager.getInstance().getLikeUnlideSelectInfo(str);
            if (likeUnlideSelectInfo == null) {
                likeUnlideSelectInfo = new LikeUnlikeSelectInfo();
            }
            likeUnlideSelectInfo.firstText = str2;
            likeUnlideSelectInfo.secondText = str3;
            if (!TextUtils.isEmpty(str)) {
                DataManager.getInstance().setLikeUnlikeSelected(str, likeUnlideSelectInfo);
            }
            if (findAnsTextNode instanceof AnsTextNode) {
                notifyItemChanged(((AnsTextNode) findAnsTextNode).position);
            } else if (findAnsTextNode instanceof FeedbackNode) {
                notifyItemChanged(((FeedbackNode) findAnsTextNode).position);
            }
        }
    }

    private BaseNode findAnsTextNode(String str) {
        if (this.datas == null) {
            return null;
        }
        for (int size = this.datas.size() - 1; size >= 0; size--) {
            BaseNode baseNode = (BaseNode) this.datas.get(size);
            if (baseNode != null) {
                if (baseNode instanceof AnsTextNode) {
                    AnsTextNode ansTextNode = (AnsTextNode) baseNode;
                    if (str.equals(ansTextNode.answerKey) && ansTextNode.evaluateInfo != null) {
                        ansTextNode.position = size;
                        return baseNode;
                    }
                } else if (baseNode instanceof FeedbackNode) {
                    FeedbackNode feedbackNode = (FeedbackNode) baseNode;
                    if (str.equals(feedbackNode.answerKey) && feedbackNode.itemInfo != null) {
                        feedbackNode.position = size;
                        return baseNode;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    private QuTextNode findQuTextNode(int i, int i2) {
        if (this.datas != null && i >= 0 && i < this.datas.size() && i2 >= 0) {
            while (i < this.datas.size()) {
                BaseNode baseNode = (BaseNode) this.datas.get(i);
                if (baseNode != null && (baseNode instanceof QuTextNode)) {
                    QuTextNode quTextNode = (QuTextNode) baseNode;
                    if (quTextNode.questionOrderId == i2) {
                        quTextNode.position = i;
                        return quTextNode;
                    }
                }
                i++;
            }
        }
        return null;
    }

    public void removeTicketStarNode(String str) {
        TicketStarNode findTicketStarNode = findTicketStarNode(str);
        if (findTicketStarNode != null) {
            deleteItem(findTicketStarNode.position);
        }
    }

    public void removeIMStarNode(String str) {
        IMStarNode findIMStarNode = findIMStarNode(str);
        if (findIMStarNode != null) {
            deleteItem(findIMStarNode.position);
        }
    }

    public void removeFormNode(String str) {
        FormNode findFormNode = findFormNode(str);
        if (findFormNode != null) {
            deleteItem(findFormNode.position);
        }
    }

    public void removeAllFromNode() {
        if (this.datas != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.datas.size(); i++) {
                BaseNode baseNode = (BaseNode) this.datas.get(i);
                if (baseNode != null && (baseNode instanceof FormNode)) {
                    arrayList.add(baseNode);
                }
            }
            if (arrayList.size() > 0) {
                deleteItems(arrayList);
            }
        }
    }

    private TicketStarNode findTicketStarNode(String str) {
        if (this.datas != null && this.datas.size() > 0 && str != null && !TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.datas.size(); i++) {
                BaseNode baseNode = (BaseNode) this.datas.get(i);
                if (baseNode != null && (baseNode instanceof TicketStarNode)) {
                    TicketStarNode ticketStarNode = (TicketStarNode) baseNode;
                    if (ticketStarNode.ticketId.equals(str)) {
                        ticketStarNode.position = i;
                        return ticketStarNode;
                    }
                }
            }
        }
        return null;
    }

    private FormNode findFormNode(String str) {
        if (this.datas != null && this.datas.size() > 0 && str != null && !TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.datas.size(); i++) {
                BaseNode baseNode = (BaseNode) this.datas.get(i);
                if (baseNode != null && (baseNode instanceof FormNode)) {
                    FormNode formNode = (FormNode) baseNode;
                    if (formNode.formId.equals(str)) {
                        formNode.position = i;
                        return formNode;
                    }
                }
            }
        }
        return null;
    }

    private IMStarNode findIMStarNode(String str) {
        if (this.datas != null && this.datas.size() > 0 && str != null && !TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.datas.size(); i++) {
                BaseNode baseNode = (BaseNode) this.datas.get(i);
                if (baseNode != null && (baseNode instanceof IMStarNode) && ((TicketStarNode) baseNode).ticketId.equals(str)) {
                    IMStarNode iMStarNode = (IMStarNode) baseNode;
                    iMStarNode.position = i;
                    return iMStarNode;
                }
            }
        }
        return null;
    }

    public void updateGiftReceiveState(int i, String str, String str2) {
        if (i == 0 || i == LogicEngine.GFIT_REGET) {
            DataManager.getInstance().setGiftGetted(str, str2);
            if (this.datas == null || this.datas.size() <= 0 || str == null || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2)) {
                return;
            }
            for (int i2 = 0; i2 < this.datas.size(); i2++) {
                BaseNode baseNode = (BaseNode) this.datas.get(i2);
                if (baseNode != null && (baseNode instanceof GiftNode)) {
                    GiftNode giftNode = (GiftNode) baseNode;
                    if (giftNode.groupId.equals(str) && giftNode.amsId.equals(str2)) {
                        giftNode.isReceived = true;
                        ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.adapter.ChatAdapter.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ChatAdapter.this.notifyDataSetChanged();
                            }
                        });
                    }
                }
            }
        }
    }

    public void hideGoodBadView(String str) {
        AnsTextNode ansTextNode;
        if (this.datas != null && this.datas.size() > 0 && str != null && !TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.datas.size(); i++) {
                BaseNode baseNode = (BaseNode) this.datas.get(i);
                if (baseNode != null && (baseNode instanceof AnsTextNode)) {
                    ansTextNode = (AnsTextNode) baseNode;
                    if (ansTextNode.answerKey.equals(str)) {
                        ansTextNode.position = i;
                        break;
                    }
                }
            }
        }
        ansTextNode = null;
        if (ansTextNode != null) {
            ansTextNode.showGoodBad = false;
            notifyItemChanged(ansTextNode.position);
        }
    }

    public void onDestroy() {
        setDatas(null);
    }
}
