package com.tencent.grobot.lite.search.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.detail.DetailDialog;
import com.tencent.grobot.lite.image.ImageBridge;
import com.tencent.grobot.lite.model.local.RecommendsInfo;
import com.tencent.grobot.lite.recommends.TimeOutIcon;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.search.OnItemClickListener;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import java.text.DateFormat;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ResultViewHolder extends RecyclerView.w {
    DateFormat dateFormat;
    private FrameLayout flPic;
    private TimeOutIcon iconTimeout;
    private OnItemClickListener itemClickListener;
    private ImageView ivPic;
    private Context mContext;
    private TextView tvSubTitle;
    private TextView tvTitle;

    public ResultViewHolder(Context context, ViewGroup viewGroup, OnItemClickListener onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.search_item_content, viewGroup, false));
        this.itemClickListener = onItemClickListener;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.flPic = (FrameLayout) this.itemView.findViewById(R.id.fl_pic);
        this.ivPic = (ImageView) this.itemView.findViewById(R.id.iv_pic);
        this.iconTimeout = (TimeOutIcon) this.itemView.findViewById(R.id.icon_timeout);
        this.tvTitle = (TextView) this.itemView.findViewById(R.id.tv_title);
        this.tvSubTitle = (TextView) this.itemView.findViewById(R.id.tv_subtitles);
        ViewUtils.setBoldTypeface(this.mContext, this.tvTitle);
        this.dateFormat = android.text.format.DateFormat.getDateFormat(this.mContext);
    }

    public void bindData(final RecommendsInfo.Item item) {
        this.iconTimeout.setVisibility(item.type == 10 ? 0 : 8);
        ImageBridge.loadImage(this.ivPic.getContext(), item.image, R.drawable.bg_defualt_image, -1, 0, this.ivPic);
        this.iconTimeout.setTime(item.vt);
        if (!item.subtitle.isEmpty()) {
            this.tvSubTitle.setVisibility(0);
            this.tvSubTitle.setText("#" + item.subtitle.get(0));
        } else {
            this.tvSubTitle.setVisibility(8);
        }
        this.tvTitle.setText(item.name);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.grobot.lite.search.holder.ResultViewHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DetailDialog detailDialog = (DetailDialog) ((FrameActivity) ResultViewHolder.this.mContext).getDialog(DetailDialog.class);
                detailDialog.setData(item, "", "", "4", 0);
                detailDialog.showCustomDialog();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                    jSONObject.put(ReportBridge.KEY_ITEM_ID, "7145");
                    if (item.type == 10) {
                        jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "3");
                    } else if (item.type == 11) {
                        jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "1");
                    }
                    jSONObject.put(ReportBridge.KEY_SUB_ID, item.resourceId);
                    jSONObject.put(ReportBridge.KEY_INDEX_ID, String.valueOf(ResultViewHolder.this.getAdapterPosition() + 7001));
                    ReportBridge.report(jSONObject, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
