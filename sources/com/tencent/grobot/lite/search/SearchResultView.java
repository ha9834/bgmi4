package com.tencent.grobot.lite.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.model.local.RecommendsInfo;
import com.tencent.grobot.lite.search.adapter.SearchBottomAdapter;
import java.util.List;

/* loaded from: classes2.dex */
public class SearchResultView extends FrameLayout {
    private SearchBottomAdapter mAdapter;
    private Context mContext;
    private OnItemClickListener mItemClickListener;
    private RecyclerView mRecycleView;
    private View mRootView;

    public SearchResultView(Context context, OnItemClickListener onItemClickListener) {
        this(context, null, 0, onItemClickListener);
    }

    public SearchResultView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, null);
    }

    public SearchResultView(Context context, AttributeSet attributeSet, int i, OnItemClickListener onItemClickListener) {
        super(context, attributeSet, i);
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.search_result, this);
        this.mRecycleView = (RecyclerView) this.mRootView.findViewById(R.id.view_recycler);
        this.mItemClickListener = onItemClickListener;
        initView();
    }

    private void initView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.mContext, 2);
        gridLayoutManager.a(new GridLayoutManager.c() { // from class: com.tencent.grobot.lite.search.SearchResultView.1
            @Override // androidx.recyclerview.widget.GridLayoutManager.c
            public int getSpanSize(int i) {
                return SearchResultView.this.mAdapter.getItemViewType(i) == 1 ? 1 : 2;
            }
        });
        this.mRecycleView.setLayoutManager(gridLayoutManager);
        this.mAdapter = new SearchBottomAdapter(this.mContext, this.mItemClickListener);
        this.mRecycleView.setAdapter(this.mAdapter);
    }

    public void refreshData(String str, List<RecommendsInfo.Item> list) {
        this.mAdapter.setData(str, list);
        this.mAdapter.notifyDataSetChanged();
    }
}
