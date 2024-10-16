package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.local.MixTipInfo;
import com.tencent.grobot.lite.model.node.RecommendsNode;
import com.tencent.grobot.lite.model.node.VideoItem;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import com.tencent.grobot.lite.ui.dialog.TipDialog;
import com.tencent.grobot.lite.ui.view.component.VideoItemView;
import com.tencent.grobot.lite.youtube.YoutubeParams;
import com.tencent.grobot.lite.youtube.YoutubePlayerDelegate;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class RecommendViewHolder extends BaseViewHolder<RecommendsNode> implements View.OnClickListener {
    private static final int GROUP_SIZE = 4;
    private ImageView changeBtn;
    private FrameActivity context;
    private TextView descText;
    private boolean firstBind;
    private int groupOrder;
    private final ImageView ivIcon1;
    private final ImageView ivIcon2;
    private final ImageView ivIcon3;
    private RecommendsNode node;
    private RelativeLayout videoLayout1;
    private RelativeLayout videoLayout2;
    private RelativeLayout videoLayout3;
    private TextView videoText1;
    private TextView videoText2;
    private TextView videoText3;
    private VideoItemView videoView;

    public RecommendViewHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_item_recommend, i, onItemClickListener);
        this.firstBind = true;
        this.node = null;
        this.groupOrder = 0;
        this.context = (FrameActivity) context;
        this.descText = (TextView) this.itemView.findViewById(R.id.recommend_desc);
        this.videoView = (VideoItemView) this.itemView.findViewById(R.id.videoitem);
        this.videoView.setOnClickListener(this);
        ViewUtils.setBoldTypeface(this.context, this.descText);
        this.videoLayout1 = (RelativeLayout) this.itemView.findViewById(R.id.layout_1);
        this.videoText1 = (TextView) this.itemView.findViewById(R.id.text_1);
        this.ivIcon1 = (ImageView) this.itemView.findViewById(R.id.icon_1);
        this.videoLayout1.setOnClickListener(this);
        ViewUtils.setBoldTypeface(this.context, this.videoText1);
        this.videoLayout2 = (RelativeLayout) this.itemView.findViewById(R.id.layout_2);
        this.videoText2 = (TextView) this.itemView.findViewById(R.id.text_2);
        this.ivIcon2 = (ImageView) this.itemView.findViewById(R.id.icon_2);
        this.videoLayout2.setOnClickListener(this);
        ViewUtils.setBoldTypeface(this.context, this.videoText2);
        this.videoLayout3 = (RelativeLayout) this.itemView.findViewById(R.id.layout_3);
        this.videoText3 = (TextView) this.itemView.findViewById(R.id.text_3);
        this.ivIcon3 = (ImageView) this.itemView.findViewById(R.id.icon_3);
        this.videoLayout3.setOnClickListener(this);
        ViewUtils.setBoldTypeface(this.context, this.videoText3);
        this.changeBtn = (ImageView) this.itemView.findViewById(R.id.btn_change);
        this.changeBtn.setOnClickListener(this);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
            jSONObject.put(ReportBridge.KEY_ITEM_ID, "7137");
            ReportBridge.report(jSONObject, false);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ReportBridge.KEY_EVENT_TYPE, "1001");
            jSONObject2.put(ReportBridge.KEY_ITEM_ID, "7127");
            ReportBridge.report(jSONObject2, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(RecommendsNode recommendsNode) {
        if (recommendsNode != null) {
            this.node = recommendsNode;
            changeView(getCurList());
            if (this.firstBind) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                    jSONObject.put(ReportBridge.KEY_ITEM_ID, "7137");
                    ReportBridge.report(jSONObject, false);
                    this.firstBind = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.videoitem || view.getId() == R.id.layout_1 || view.getId() == R.id.layout_2 || view.getId() == R.id.layout_3) {
            Object tag = view.getTag();
            if (tag instanceof VideoItem) {
                playVideo((VideoItem) tag);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                    jSONObject.put(ReportBridge.KEY_ITEM_ID, "7151");
                    if (view.getId() == R.id.videoitem) {
                        jSONObject.put(ReportBridge.KEY_INDEX_ID, "7001");
                    }
                    if (view.getId() == R.id.layout_1) {
                        jSONObject.put(ReportBridge.KEY_INDEX_ID, "7002");
                    }
                    if (view.getId() == R.id.layout_2) {
                        jSONObject.put(ReportBridge.KEY_INDEX_ID, "7003");
                    }
                    if (view.getId() == R.id.layout_3) {
                        jSONObject.put(ReportBridge.KEY_INDEX_ID, "7004");
                    }
                    jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "3");
                    jSONObject.put(ReportBridge.KEY_SUB_ID, ((VideoItem) tag).resourceId);
                    ReportBridge.report(jSONObject, true);
                    ReportBridge.reportViewsClick(0, ((VideoItem) tag).resourceId);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (tag instanceof MixTipInfo) {
                MixTipInfo mixTipInfo = (MixTipInfo) view.getTag();
                TipDialog tipDialog = (TipDialog) this.context.getDialog(TipDialog.class);
                tipDialog.setData(mixTipInfo.title, mixTipInfo);
                tipDialog.showCustomDialog();
                ReportBridge.reportViewsClick(2, mixTipInfo.resourceId);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                    jSONObject2.put(ReportBridge.KEY_ITEM_ID, "7130");
                    jSONObject2.put(ReportBridge.KEY_ITEM_SUB_1, "1");
                    jSONObject2.put(ReportBridge.KEY_SUB_ID, mixTipInfo.resourceId);
                    ReportBridge.report(jSONObject2, true);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (view.getId() == R.id.btn_change) {
            changeView(getVideoList());
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                jSONObject3.put(ReportBridge.KEY_ITEM_ID, "7127");
                ReportBridge.report(jSONObject3, true);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private ArrayList<Object> getCurList() {
        RecommendsNode recommendsNode = this.node;
        if (recommendsNode == null || recommendsNode.items == null || this.node.items.size() <= 0) {
            return null;
        }
        if (this.node.items.size() <= 4) {
            return this.node.items;
        }
        ArrayList<Object> arrayList = this.node.items;
        int i = this.groupOrder;
        return new ArrayList<>(arrayList.subList(i * 4, (i + 1) * 4));
    }

    private ArrayList<Object> getVideoList() {
        RecommendsNode recommendsNode = this.node;
        if (recommendsNode == null || recommendsNode.items == null || this.node.items.size() <= 0) {
            return null;
        }
        if (this.node.items.size() <= 4) {
            return this.node.items;
        }
        int size = this.node.items.size() / 4;
        int i = this.groupOrder;
        if (size > i + 1) {
            this.groupOrder = i + 1;
        } else {
            this.groupOrder = 0;
        }
        ArrayList<Object> arrayList = this.node.items;
        int i2 = this.groupOrder;
        return new ArrayList<>(arrayList.subList(i2 * 4, (i2 + 1) * 4));
    }

    private void changeView(ArrayList<Object> arrayList) {
        if (arrayList == null || arrayList.size() < 2) {
            return;
        }
        Object obj = arrayList.get(0);
        Report report = new Report();
        report.eventType("1001").itemId("7151").indexId("7001").itemSub1("3");
        this.videoView.setData(obj);
        if (obj instanceof VideoItem) {
            VideoItem videoItem = (VideoItem) obj;
            this.descText.setText(videoItem.name);
            report.subId(videoItem.resourceId);
        } else if (obj instanceof MixTipInfo) {
            MixTipInfo mixTipInfo = (MixTipInfo) obj;
            this.descText.setText(mixTipInfo.title);
            report.subId(mixTipInfo.resourceId);
        }
        report.report(false);
        if (arrayList.size() >= 2) {
            Object obj2 = arrayList.get(1);
            this.videoLayout1.setTag(obj2);
            Report report2 = new Report();
            report2.eventType("1001").itemId("7151").indexId("7002").itemSub1("3");
            if (obj2 instanceof VideoItem) {
                VideoItem videoItem2 = (VideoItem) obj2;
                this.videoText1.setText(videoItem2.name);
                this.ivIcon1.setBackgroundResource(R.drawable.icon_video);
                report2.subId(videoItem2.resourceId);
            } else if (obj2 instanceof MixTipInfo) {
                MixTipInfo mixTipInfo2 = (MixTipInfo) obj2;
                this.videoText1.setText(mixTipInfo2.title);
                this.ivIcon1.setBackgroundResource(R.drawable.icon_mix_tips);
                report2.subId(mixTipInfo2.resourceId);
            }
            report2.report(false);
        }
        if (arrayList.size() >= 3) {
            Object obj3 = arrayList.get(2);
            this.videoLayout2.setTag(obj3);
            Report report3 = new Report();
            report3.eventType("1001").itemId("7151").indexId("7003").itemSub1("3");
            if (obj3 instanceof VideoItem) {
                VideoItem videoItem3 = (VideoItem) obj3;
                this.videoText2.setText(videoItem3.name);
                this.ivIcon2.setBackgroundResource(R.drawable.icon_video);
                report3.subId(videoItem3.resourceId);
            } else if (obj3 instanceof MixTipInfo) {
                MixTipInfo mixTipInfo3 = (MixTipInfo) obj3;
                this.videoText2.setText(mixTipInfo3.title);
                this.ivIcon2.setBackgroundResource(R.drawable.icon_mix_tips);
                report3.subId(mixTipInfo3.resourceId);
            }
            report3.report(false);
        } else {
            this.videoLayout2.setVisibility(8);
        }
        if (arrayList.size() >= 4) {
            Object obj4 = arrayList.get(3);
            this.videoLayout3.setTag(obj4);
            Report report4 = new Report();
            report4.eventType("1001").itemId("7151").indexId("7004").itemSub1("3");
            if (obj4 instanceof VideoItem) {
                VideoItem videoItem4 = (VideoItem) obj4;
                this.videoText3.setText(videoItem4.name);
                this.ivIcon3.setBackgroundResource(R.drawable.icon_video);
                report4.subId(videoItem4.resourceId);
            } else if (obj4 instanceof MixTipInfo) {
                MixTipInfo mixTipInfo4 = (MixTipInfo) obj4;
                this.videoText3.setText(mixTipInfo4.title);
                this.ivIcon3.setBackgroundResource(R.drawable.icon_mix_tips);
                report4.subId(mixTipInfo4.resourceId);
            }
            report4.report(false);
            this.changeBtn.setVisibility(0);
            return;
        }
        this.videoLayout3.setVisibility(8);
        this.changeBtn.setVisibility(8);
    }

    private void playVideo(VideoItem videoItem) {
        YoutubePlayerDelegate.play(this.context, new YoutubeParams(videoItem.videoId, videoItem.name));
    }
}
