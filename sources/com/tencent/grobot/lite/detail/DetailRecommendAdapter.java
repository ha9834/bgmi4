package com.tencent.grobot.lite.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.LangUtils;
import com.tencent.grobot.lite.common.ToolUtils;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.image.ImageBridge;
import com.tencent.grobot.lite.model.local.RecommendsInfo;
import com.tencent.grobot.lite.recommends.TimeOutIcon;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DetailRecommendAdapter extends BaseAdapter {
    Context context;
    private final LayoutInflater inflater;
    private ArrayList<RecommendsInfo.Item> mRecommendInfos = new ArrayList<>();
    private int mSelectedPos = -1;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public DetailRecommendAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public void setData(List<RecommendsInfo.Item> list) {
        this.mRecommendInfos.clear();
        if (list != null) {
            this.mRecommendInfos.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void setSelectedPos(int i) {
        if (this.mRecommendInfos == null) {
            return;
        }
        if (i != -1) {
            this.mSelectedPos = i;
        }
        for (int i2 = 0; i2 < this.mRecommendInfos.size() && i < this.mRecommendInfos.size(); i2++) {
            if (i2 == i) {
                this.mRecommendInfos.get(i2).selected = true;
            } else {
                this.mRecommendInfos.get(i2).selected = false;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mRecommendInfos.size();
    }

    @Override // android.widget.Adapter
    public RecommendsInfo.Item getItem(int i) {
        return this.mRecommendInfos.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.inflater.inflate(R.layout.dialog_detail_recmomend, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.itemView = view;
            viewHolder.cutline = (TextView) view.findViewById(R.id.cutlineTop);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.image);
            viewHolder.iconTimeOut = (TimeOutIcon) view.findViewById(R.id.icon_timeout);
            viewHolder.descView = (TextView) view.findViewById(R.id.desc);
            viewHolder.views_timeView = (TextView) view.findViewById(R.id.views_time);
            ViewUtils.setBoldTypeface(this.context, viewHolder.descView);
            ViewUtils.setBoldTypeface(this.context, viewHolder.views_timeView);
            if (LangUtils.getLayoutDirectionFromLocale(this.context.getResources().getConfiguration().locale) == 1) {
                viewHolder.views_timeView.setTextDirection(4);
            }
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        buildView(i, getItem(i), viewHolder);
        return view;
    }

    private void buildView(int i, RecommendsInfo.Item item, ViewHolder viewHolder) {
        if (item == null || viewHolder == null) {
            return;
        }
        ImageBridge.loadImage(this.context, item.image, R.drawable.bg_defualt_image, -1, 0, viewHolder.imageView);
        if (item.type == 10) {
            viewHolder.iconTimeOut.setVisibility(0);
            viewHolder.iconTimeOut.setTime(item.vt);
        } else if (item.type == 11) {
            viewHolder.iconTimeOut.setVisibility(8);
        }
        viewHolder.descView.setText(item.name);
        viewHolder.views_timeView.setText(ToolUtils.getViewsAndTimeString(this.context, item.views, item.updateTime * 1000));
        if (i != 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewHolder.cutline.getLayoutParams();
            layoutParams.leftMargin = ViewUtils.dip2px(this.context, 10.0f);
            layoutParams.rightMargin = ViewUtils.dip2px(this.context, 10.0f);
        }
        int i2 = this.mSelectedPos;
        if (i2 >= 0 && (i2 + 1 == i || i2 == i)) {
            viewHolder.cutline.setVisibility(8);
        } else {
            viewHolder.cutline.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ViewHolder {
        TextView cutline;
        TextView descView;
        TimeOutIcon iconTimeOut;
        ImageView imageView;
        View itemView;
        TextView views_timeView;

        ViewHolder() {
        }
    }
}
