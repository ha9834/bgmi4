package com.tencent.grobot.lite.search;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.DataManager;
import com.tencent.grobot.lite.common.ToolUtils;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.search.adapter.TextAdapter;
import com.tencent.grobot.lite.search.model.ClickObj;
import com.tencent.grobot.lite.search.model.TextItem;
import com.tencent.grobot.lite.ui.view.component.HorizontalView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class SearchNoAnswerView extends FrameLayout {
    private Context mContext;
    private TextAdapter mHistoryAdapter;
    private View mHistoryLayout;
    private HorizontalView mHistoryView;
    private TextAdapter mHotAdapter;
    private View mHotLayout;
    private HorizontalView mHotView;
    private OnItemClickListener mItemClickListener;
    private String mKeyword;
    private View mRootView;
    private TextView moreText;

    public SearchNoAnswerView(Context context, OnItemClickListener onItemClickListener) {
        this(context, null, 0, onItemClickListener);
    }

    public SearchNoAnswerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, null);
    }

    public SearchNoAnswerView(Context context, AttributeSet attributeSet, int i, OnItemClickListener onItemClickListener) {
        super(context, attributeSet, i);
        this.mKeyword = "";
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.search_noanswer, this);
        this.mItemClickListener = onItemClickListener;
        initView();
        initData();
    }

    private void initView() {
        this.mHistoryLayout = this.mRootView.findViewById(R.id.history);
        this.mHistoryView = (HorizontalView) this.mRootView.findViewById(R.id.history_scroll);
        this.mHistoryAdapter = new TextAdapter(this.mContext, this.mItemClickListener);
        this.mHistoryView.setAdapter(this.mHistoryAdapter);
        this.mHotLayout = this.mRootView.findViewById(R.id.hot);
        this.mHotView = (HorizontalView) this.mRootView.findViewById(R.id.hot_scroll);
        this.mHotAdapter = new TextAdapter(this.mContext, this.mItemClickListener);
        this.mHotView.setAdapter(this.mHotAdapter);
        this.moreText = (TextView) this.mRootView.findViewById(R.id.text_link);
        this.moreText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.grobot.lite.search.SearchNoAnswerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchNoAnswerView.this.mItemClickListener == null || TextUtils.isEmpty(SearchNoAnswerView.this.mKeyword)) {
                    return;
                }
                ClickObj clickObj = new ClickObj();
                clickObj.type = 2;
                clickObj.msg = SearchNoAnswerView.this.mKeyword;
                SearchNoAnswerView.this.mItemClickListener.onItemClick(clickObj);
                new Report().eventType("1002").itemId("7162").ext(SearchNoAnswerView.this.mKeyword).report(false);
            }
        });
        ViewUtils.setBoldTypeface(this.mContext, this.moreText);
    }

    public void showFindMore(String str) {
        this.mKeyword = str;
        if (!TextUtils.isEmpty(str)) {
            this.moreText.setVisibility(0);
            this.moreText.setText(ToolUtils.getSearchString(getContext(), str));
            new Report().eventType("1001").itemId("7162").ext(str).report(false);
            return;
        }
        this.moreText.setVisibility(8);
    }

    public void refresh() {
        showHistroryView();
    }

    private void initData() {
        showHistroryView();
        updateHotView(null);
    }

    private void showHistroryView() {
        ArrayList<String> searchHistory = DataManager.getInstance().getSearchHistory();
        if (searchHistory == null || searchHistory.size() == 0) {
            this.mHistoryLayout.setVisibility(8);
            return;
        }
        this.mHistoryLayout.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = searchHistory.iterator();
        while (it.hasNext()) {
            String next = it.next();
            TextItem textItem = new TextItem();
            textItem.type = 1;
            textItem.desc = next;
            arrayList.add(textItem);
        }
        this.mHistoryAdapter.setDatas(arrayList);
    }

    public void updateHotView(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            this.mHotLayout.setVisibility(8);
            return;
        }
        this.mHotLayout.setVisibility(0);
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            TextItem textItem = new TextItem();
            textItem.type = 2;
            textItem.desc = next;
            arrayList2.add(textItem);
        }
        this.mHotAdapter.setDatas(arrayList2);
    }
}
