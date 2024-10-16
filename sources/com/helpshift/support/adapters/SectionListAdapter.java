package com.helpshift.support.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.R;
import com.helpshift.support.Section;
import java.util.List;

/* loaded from: classes2.dex */
public class SectionListAdapter extends RecyclerView.a<ViewHolder> {
    private View.OnClickListener onClickListener;
    private List<Section> sections;

    public SectionListAdapter(List<Section> list, View.OnClickListener onClickListener) {
        this.sections = list;
        this.onClickListener = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hs_simple_recycler_view_item, viewGroup, false);
        textView.setOnClickListener(this.onClickListener);
        return new ViewHolder(textView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Section section = this.sections.get(i);
        viewHolder.textView.setText(section.getTitle());
        viewHolder.textView.setTag(section.getPublishId());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return this.sections.size();
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
