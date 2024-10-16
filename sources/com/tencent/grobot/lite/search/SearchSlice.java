package com.tencent.grobot.lite.search;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.common.thread.ThreadManager;
import com.tencent.grobot.lite.model.local.RecommendsInfo;
import com.tencent.grobot.lite.recommends.Feeds;
import com.tencent.grobot.lite.recommends.ISliceListener;
import com.tencent.grobot.lite.recommends.Slice;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.search.model.ClickObj;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class SearchSlice extends Slice implements View.OnClickListener, ISearchView {
    private final int horizonPadding;
    private View mBackBtn;
    private RelativeLayout mContentView;
    private Context mContext;
    private ImageView mDeleteBtn;
    private String mHintWord;
    private ISliceListener mISliceListener;
    private EditText mInputText;
    private OnItemClickListener mItemClickListener;
    private SearchPresenter mPrensenter;
    private View mRootView;
    private TextView mSearchBtn;
    private SearchNoAnswerView noAnswerView;
    private SearchResultView resultView;

    @Override // com.tencent.grobot.lite.recommends.Slice
    public void fixNotchScreen() {
    }

    @Override // com.tencent.grobot.lite.common.ComponentRef
    public void onDestroy() {
    }

    @Override // com.tencent.grobot.lite.recommends.Slice
    public void stop(Object... objArr) {
    }

    public SearchSlice(Feeds feeds) {
        super(feeds);
        this.mPrensenter = new SearchPresenter(this);
        this.mISliceListener = null;
        this.mHintWord = "";
        this.mItemClickListener = new OnItemClickListener() { // from class: com.tencent.grobot.lite.search.SearchSlice.2
            @Override // com.tencent.grobot.lite.search.OnItemClickListener
            public void onItemClick(Object obj) {
                if (!ViewUtils.isFastClick() && (obj instanceof ClickObj)) {
                    ClickObj clickObj = (ClickObj) obj;
                    if (clickObj.type == 1) {
                        SearchSlice.this.search(clickObj.msg);
                    } else if (SearchSlice.this.mISliceListener != null) {
                        SearchSlice.this.mISliceListener.jumpToIm(clickObj.msg);
                    }
                }
            }
        };
        this.mContext = feeds.context();
        this.horizonPadding = ViewUtils.dip2px(this.context, 6.0f);
    }

    @Override // com.tencent.grobot.lite.recommends.Slice
    public View view() {
        this.mRootView = LayoutInflater.from(this.context).inflate(R.layout.search, (ViewGroup) null, false);
        this.mBackBtn = this.mRootView.findViewById(R.id.btn_back);
        this.mBackBtn.setOnClickListener(this);
        this.mInputText = (EditText) this.mRootView.findViewById(R.id.input_view);
        this.mInputText.addTextChangedListener(new TextWatcher() { // from class: com.tencent.grobot.lite.search.SearchSlice.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (SearchSlice.this.mInputText.getText().length() > 0) {
                    SearchSlice.this.mSearchBtn.setEnabled(true);
                    SearchSlice.this.mSearchBtn.setBackgroundResource(R.drawable.bg_search_btn);
                    SearchSlice.this.mDeleteBtn.setVisibility(0);
                } else if (SearchSlice.this.mInputText.getText().length() != 0 || SearchSlice.this.mHintWord.length() <= 0) {
                    SearchSlice.this.mSearchBtn.setEnabled(false);
                    SearchSlice.this.mSearchBtn.setBackgroundColor(Color.parseColor("#808080"));
                    SearchSlice.this.mDeleteBtn.setVisibility(8);
                } else {
                    SearchSlice.this.mSearchBtn.setEnabled(true);
                    SearchSlice.this.mSearchBtn.setBackgroundResource(R.drawable.bg_search_btn);
                    SearchSlice.this.mDeleteBtn.setVisibility(8);
                }
            }
        });
        ViewUtils.setBoldTypeface(this.context, this.mInputText);
        this.mDeleteBtn = (ImageView) this.mRootView.findViewById(R.id.btn_delete);
        this.mDeleteBtn.setOnClickListener(this);
        this.mSearchBtn = (TextView) this.mRootView.findViewById(R.id.btn_search);
        ViewUtils.setBoldTypeface(this.context, this.mSearchBtn);
        this.mSearchBtn.setOnClickListener(this);
        this.mContentView = (RelativeLayout) this.mRootView.findViewById(R.id.view_content);
        return this.mRootView;
    }

    public void setISliceListener(ISliceListener iSliceListener) {
        this.mISliceListener = iSliceListener;
    }

    @Override // com.tencent.grobot.lite.recommends.Slice
    public void start(Object... objArr) {
        initData();
    }

    private void initData() {
        updateNoAnswerView("");
    }

    public void updateResultView(String str, List<RecommendsInfo.Item> list) {
        this.mContentView.removeAllViews();
        if (this.resultView == null) {
            this.resultView = new SearchResultView(this.mContext, this.mItemClickListener);
        }
        this.mContentView.addView(this.resultView);
        this.resultView.refreshData(str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void search(String str) {
        this.mPrensenter.search(str);
        this.mInputText.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateContent(String str, RecommendsInfo recommendsInfo) {
        if (recommendsInfo != null && recommendsInfo.items != null && recommendsInfo.items.size() > 0) {
            updateResultView(str, recommendsInfo.items);
        } else {
            updateNoAnswerView(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHotKeywords(ArrayList<String> arrayList) {
        SearchNoAnswerView searchNoAnswerView = this.noAnswerView;
        if (searchNoAnswerView != null) {
            searchNoAnswerView.updateHotView(arrayList);
        }
    }

    private void updateNoAnswerView(String str) {
        this.mContentView.removeAllViews();
        if (this.noAnswerView == null) {
            this.noAnswerView = new SearchNoAnswerView(this.mContext, this.mItemClickListener);
        }
        this.mContentView.addView(this.noAnswerView, new RelativeLayout.LayoutParams(-1, -1));
        this.noAnswerView.showFindMore(str);
        this.noAnswerView.refresh();
        this.mPrensenter.getHotKeywords();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getId() == R.id.btn_back) {
            ISliceListener iSliceListener = this.mISliceListener;
            if (iSliceListener != null) {
                iSliceListener.changeTab(1);
            }
            updateNoAnswerView("");
            return;
        }
        if (view.getId() == R.id.btn_delete) {
            this.mInputText.setText("");
            if (this.mHintWord.length() == 0) {
                this.mSearchBtn.setEnabled(false);
                this.mSearchBtn.setBackgroundColor(Color.parseColor("#808080"));
            }
            this.mDeleteBtn.setVisibility(8);
            return;
        }
        if (view.getId() == R.id.btn_search) {
            if (!TextUtils.isEmpty(this.mInputText.getText().toString().trim())) {
                str = this.mInputText.getText().toString().trim();
                new Report().eventType("1002").itemId("7160").ext(str).report(false);
            } else {
                str = this.mHintWord;
                new Report().eventType("1002").itemId("7163").ext(this.mHintWord).report(false);
            }
            search(str);
            if (this.mHintWord.length() == 0) {
                this.mSearchBtn.setEnabled(false);
                this.mSearchBtn.setBackgroundColor(Color.parseColor("#808080"));
            }
            this.mDeleteBtn.setVisibility(8);
        }
    }

    @Override // com.tencent.grobot.lite.search.ISearchView
    public void onSearchResult(final String str, final RecommendsInfo recommendsInfo) {
        ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.search.SearchSlice.3
            @Override // java.lang.Runnable
            public void run() {
                SearchSlice.this.updateContent(str, recommendsInfo);
            }
        });
    }

    @Override // com.tencent.grobot.lite.search.ISearchView
    public void onGetHotKeyword(final String str, final ArrayList<String> arrayList) {
        ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.search.SearchSlice.4
            @Override // java.lang.Runnable
            public void run() {
                SearchSlice.this.mHintWord = str;
                SearchSlice.this.mInputText.setText("");
                SearchSlice.this.mInputText.setHint(SearchSlice.this.mHintWord);
                SearchSlice.this.updateHotKeywords(arrayList);
                new Report().eventType("1001").itemId("7160").ext(SearchSlice.this.mHintWord).report(false);
            }
        });
    }
}
