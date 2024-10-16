package com.tencent.grobot.lite.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.model.HotInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class HotAdapter extends BaseAdapter {
    private final Context context;
    private final LayoutInflater inflater;
    private List<HotInfo> mHotInfos = new ArrayList();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public HotAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public void updateHelpInfos(List<HotInfo> list) {
        this.mHotInfos.clear();
        this.mHotInfos.addAll(list);
        notifyDataSetChanged();
    }

    public void setSelectedPos(int i) {
        if (this.mHotInfos == null) {
            return;
        }
        for (int i2 = 0; i2 < this.mHotInfos.size() && i < this.mHotInfos.size(); i2++) {
            if (i2 == i) {
                this.mHotInfos.get(i2).selected = true;
            } else {
                this.mHotInfos.get(i2).selected = false;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mHotInfos.size();
    }

    @Override // android.widget.Adapter
    public HotInfo getItem(int i) {
        return this.mHotInfos.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.inflater.inflate(R.layout.help_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.rootView = view.findViewById(R.id.root);
            viewHolder.titleView = (TextView) view.findViewById(R.id.title);
            viewHolder.descView = (TextView) view.findViewById(R.id.desc);
            view.setTag(viewHolder);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7056");
                jSONObject.put(ReportBridge.KEY_INDEX_ID, String.valueOf(i + 7001));
                ReportBridge.report(jSONObject, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        drawView(getItem(i), viewHolder, i);
        return view;
    }

    private void drawView(HotInfo hotInfo, ViewHolder viewHolder, int i) {
        if (hotInfo == null || viewHolder == null) {
            return;
        }
        if (!TextUtils.isEmpty(!TextUtils.isEmpty(hotInfo.desc) ? hotInfo.desc.trim() : null)) {
            viewHolder.descView.setVisibility(0);
            viewHolder.descView.setText(hotInfo.desc);
            ViewUtils.setBoldTypeface(this.context, viewHolder.descView);
        } else {
            viewHolder.descView.setVisibility(8);
        }
        if (TextUtils.isEmpty(hotInfo.title)) {
            return;
        }
        viewHolder.titleView.setText(hotInfo.title);
        ViewUtils.setBoldTypeface(this.context, viewHolder.titleView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ViewHolder {
        TextView descView;
        View rootView;
        TextView titleView;

        private ViewHolder() {
        }
    }
}
