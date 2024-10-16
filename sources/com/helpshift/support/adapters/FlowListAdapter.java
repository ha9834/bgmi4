package com.helpshift.support.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.R;
import com.helpshift.support.flows.Flow;
import java.util.List;

/* loaded from: classes2.dex */
public class FlowListAdapter extends RecyclerView.a<ViewHolder> {
    private List<Flow> flows;
    private View.OnClickListener onClickListener;

    public FlowListAdapter(List<Flow> list, View.OnClickListener onClickListener) {
        this.flows = list;
        this.onClickListener = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hs__simple_list_item_1, viewGroup, false);
        textView.setOnClickListener(this.onClickListener);
        return new ViewHolder(textView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String label;
        Flow flow = this.flows.get(i);
        if (flow.getLabelResId() != 0) {
            label = viewHolder.textView.getResources().getString(flow.getLabelResId());
        } else {
            label = flow.getLabel();
        }
        viewHolder.textView.setText(label);
        viewHolder.textView.setTag(Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return this.flows.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class ViewHolder extends RecyclerView.w {
        TextView textView;

        public ViewHolder(TextView textView) {
            super(textView);
            this.textView = textView;
        }
    }
}
