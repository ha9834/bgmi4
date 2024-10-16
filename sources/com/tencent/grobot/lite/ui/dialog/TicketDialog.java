package com.tencent.grobot.lite.ui.dialog;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import com.tencent.grobot.lite.ui.container.FrameDialog;
import com.tencent.grobot.lite.ui.presenter.MainViewPresenter;
import com.tencent.grobot.lite.ui.view.ticket.TicketReplyView;
import com.tencent.grobot.lite.ui.view.ticket.TicketSelectionView;
import com.tencent.grobot.lite.ui.view.ticket.TicketTextView;
import com.tencent.grobot.lite.ui.view.ticket.TicketUploadView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TicketDialog extends FrameDialog {
    private ImageView closeBtn;
    private MainViewPresenter mPresenter;
    private TicketReplyView replyView;
    private LinearLayout rootContent;
    private List<View> tableViews;
    private TextView titleView;
    private boolean toggled;

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog
    protected void initData() {
    }

    public TicketDialog(FrameActivity frameActivity) {
        super(frameActivity);
        this.tableViews = new ArrayList();
        this.toggled = false;
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog
    protected View initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_ticket, (ViewGroup) this, false);
        setBackgroundResource(android.R.color.transparent);
        this.titleView = (TextView) inflate.findViewById(R.id.title);
        ViewUtils.setBoldTypeface(getContext(), this.titleView);
        this.rootContent = (LinearLayout) inflate.findViewById(R.id.content);
        this.closeBtn = (ImageView) inflate.findViewById(R.id.closeBtn);
        this.closeBtn.setOnClickListener(this);
        return inflate;
    }

    public void setPresenter(MainViewPresenter mainViewPresenter) {
        this.mPresenter = mainViewPresenter;
    }

    public void setTicketId(String str) {
        this.mPresenter.getTicketDetail(str);
    }

    public void onGetTicketDetail(String str, int i, JSONObject jSONObject) {
        if (jSONObject == null || i != 0) {
            dismissCustomDialog();
        } else {
            buildContentView(jSONObject);
        }
    }

    private void buildContentView(JSONObject jSONObject) {
        if (jSONObject == null) {
            dismissCustomDialog();
            return;
        }
        String optString = jSONObject.optString("title");
        if (!TextUtils.isEmpty(optString)) {
            this.titleView.setText(optString);
            ViewUtils.setBoldTypeface(getContext(), this.titleView);
        }
        if (this.rootContent.getChildCount() > 0) {
            this.rootContent.removeAllViews();
        }
        buildItemView(jSONObject);
    }

    private void buildItemView(JSONObject jSONObject) {
        JSONArray optJSONArray;
        View view;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null) {
                return;
            }
            String optString = optJSONObject.optString("ticket_reply_info");
            if (optString != null && !TextUtils.isEmpty(optString)) {
                this.replyView = new TicketReplyView(getContext());
                this.replyView.setReplyText(optString);
                this.replyView.setSubmitClickListener(this);
                this.rootContent.addView(this.replyView);
            }
            String optString2 = optJSONObject.optString("ticket_info");
            if (optString2 == null || TextUtils.isEmpty(optString2) || (optJSONArray = new JSONObject(optString2).optJSONArray("question")) == null) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                String optString3 = optJSONObject2.optString("type");
                if (!TextUtils.isEmpty(optString3)) {
                    if (optString3.equals("dropMenu")) {
                        view = new TicketSelectionView(getContext());
                        ((TicketSelectionView) view).setData(optJSONObject2, false);
                    } else if (optString3.equals("text")) {
                        view = new TicketTextView(getContext());
                        ((TicketTextView) view).setData(optJSONObject2);
                    } else if (optString3.equals("textarea")) {
                        view = new TicketTextView(getContext());
                        ((TicketTextView) view).setData(optJSONObject2);
                    } else if (optString3.equals("time")) {
                        view = new TicketSelectionView(getContext());
                        ((TicketSelectionView) view).setData(optJSONObject2, true);
                    } else if (optString3.equals("upload")) {
                        view = new TicketUploadView(getContext());
                        ((TicketUploadView) view).setData(optJSONObject2);
                    } else {
                        view = null;
                    }
                    if (view != null) {
                        view.setVisibility(8);
                        this.rootContent.addView(view);
                        this.tableViews.add(view);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.closeBtn) {
            dismissCustomDialog();
        } else if (view.getId() == R.id.tv_submit) {
            toggleFormInfo();
        }
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog
    public void dismissCustomDialog() {
        this.toggled = false;
        super.dismissCustomDialog();
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog
    protected void destoryView() {
        this.titleView = null;
        this.closeBtn.setOnClickListener(null);
        TicketReplyView ticketReplyView = this.replyView;
        if (ticketReplyView != null) {
            ticketReplyView.onDestroy();
        }
        for (View view : this.tableViews) {
            if (view instanceof TicketUploadView) {
                ((TicketUploadView) view).onDestory();
            }
        }
        this.tableViews.clear();
        this.closeBtn = null;
        this.rootContent = null;
        this.mPresenter = null;
    }

    private void toggleFormInfo() {
        this.toggled = !this.toggled;
        int i = this.toggled ? 0 : 8;
        Iterator<View> it = this.tableViews.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(i);
        }
    }
}
