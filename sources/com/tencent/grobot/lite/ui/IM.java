package com.tencent.grobot.lite.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.GRobotEnterManager;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.DataManager;
import com.tencent.grobot.lite.common.LangUtils;
import com.tencent.grobot.lite.common.SystemUtils;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.common.thread.ThreadManager;
import com.tencent.grobot.lite.jni.JNIManager;
import com.tencent.grobot.lite.model.AnswerModelConverter;
import com.tencent.grobot.lite.model.local.AnswerInfo;
import com.tencent.grobot.lite.model.local.ContainerInfo;
import com.tencent.grobot.lite.model.local.EvaluateInfo;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.grobot.lite.model.local.HotTextItemInfo;
import com.tencent.grobot.lite.model.local.IMMsgInfo;
import com.tencent.grobot.lite.model.local.MixTipInfo;
import com.tencent.grobot.lite.model.local.OptionItemInfo;
import com.tencent.grobot.lite.model.local.VideoItemInfo;
import com.tencent.grobot.lite.model.node.AnsOptionNode;
import com.tencent.grobot.lite.model.node.AnsTextNode;
import com.tencent.grobot.lite.model.node.BaseNode;
import com.tencent.grobot.lite.model.node.FormNode;
import com.tencent.grobot.lite.model.node.GiftNode;
import com.tencent.grobot.lite.model.node.IMStarNode;
import com.tencent.grobot.lite.model.node.QuTextNode;
import com.tencent.grobot.lite.model.node.TicketNode;
import com.tencent.grobot.lite.model.node.TicketStarNode;
import com.tencent.grobot.lite.model.req.EvaluateReqInfo;
import com.tencent.grobot.lite.presenter.business.DataProcessor;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.adapter.ChatAdapter;
import com.tencent.grobot.lite.ui.adapter.ChatDividerDecoration;
import com.tencent.grobot.lite.ui.adapter.EvaluateOptionAdapter;
import com.tencent.grobot.lite.ui.adapter.HotAdapter;
import com.tencent.grobot.lite.ui.adapter.OptionAdapter;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.container.Frame;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import com.tencent.grobot.lite.ui.container.Router;
import com.tencent.grobot.lite.ui.dialog.FormDialog;
import com.tencent.grobot.lite.ui.dialog.ReconnectDialog;
import com.tencent.grobot.lite.ui.dialog.TextDialog;
import com.tencent.grobot.lite.ui.dialog.TicketDialog;
import com.tencent.grobot.lite.ui.dialog.TipDialog;
import com.tencent.grobot.lite.ui.model.HotInfo;
import com.tencent.grobot.lite.ui.presenter.IIMView;
import com.tencent.grobot.lite.ui.presenter.IMsgView;
import com.tencent.grobot.lite.ui.presenter.MainViewPresenter;
import com.tencent.grobot.lite.ui.view.ChatRecyclerView;
import com.tencent.grobot.lite.ui.view.InputView;
import com.tencent.grobot.lite.ui.view.component.HorizontalView;
import com.tencent.grobot.lite.ui.view.helper.ClickFrequencyHelper;
import com.tencent.grobot.lite.ui.view.im.IMActionView;
import com.tencent.grobot.lite.youtube.YoutubeParams;
import com.tencent.grobot.lite.youtube.YoutubePlayerDelegate;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class IM extends Frame implements Handler.Callback, View.OnClickListener, IIMView, IMsgView {
    public static final int MSG_CALLBACK_EVENT = 1004;
    public static final int MSG_CALLBACK_FORM = 1006;
    public static final int MSG_CALLBACK_IM = 1009;
    public static final int MSG_CALLBACK_OPTION = 1005;
    public static final int MSG_CALLBACK_TICKET = 1007;
    public static final int MSG_CALLBACK_TICKETSTAR = 1008;
    public static final int MSG_DESTORY_VIEW = 1999;
    public static final int MSG_TEXT_EVENT = 1001;
    private static final String TAG = "IM";
    private final ClickFrequencyHelper chatClickHelper;
    private ChatRecyclerView chatView;
    private ChatAdapter chatViewAdapter;
    private final RecyclerView.n chatViewScrollListener;
    private ImageView closeBtn;
    private EvaluateOptionAdapter evaluateOptionAdapter;
    private Handler handler;
    private boolean hasCacheNext;
    private boolean hasFixNotch;
    boolean hasInitRobot;
    private final ClickFrequencyHelper hotListClickHelper;
    private IMActionView imActionView;
    private String initQuestion;
    private String initString;
    private InputView inputView;
    private InputView.KeyboardListener keyboardListener;
    private int lastIndex;
    private EvaluateItemInfo mCacheEvaluateItemInfo;
    private HotAdapter mHotAdapter;
    private ListView mHotList;
    private MainViewPresenter mPresenter;
    private OptionAdapter optinViewAdapter;
    private HorizontalView optionView;
    private final ClickFrequencyHelper optionsClickHelper;
    private final ReconnectActionDelegate reconnectAction;
    boolean showNetworkLoding;
    private long startSendTime;
    private long startTime;
    private View vBgOptions;
    private View vGoTop;

    @Override // com.tencent.grobot.lite.ui.presenter.IIMView
    public void onUserScored(String str, int i) {
    }

    public IM(FrameActivity frameActivity, Bundle bundle) {
        super(frameActivity, bundle);
        this.hasInitRobot = false;
        this.showNetworkLoding = false;
        this.mCacheEvaluateItemInfo = null;
        this.hasFixNotch = false;
        this.hotListClickHelper = new ClickFrequencyHelper();
        this.optionsClickHelper = new ClickFrequencyHelper();
        this.chatClickHelper = new ClickFrequencyHelper();
        this.reconnectAction = new ReconnectActionDelegate(this);
        this.startTime = 0L;
        this.mPresenter = new MainViewPresenter(this, this);
        this.chatViewScrollListener = new RecyclerView.n() { // from class: com.tencent.grobot.lite.ui.IM.1
            int screenHeight = -1;
            int state = 0;
            int offset = 0;

            @Override // androidx.recyclerview.widget.RecyclerView.n
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                this.state = i;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.n
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                int i3;
                if (IM.this.chatViewAdapter == null || IM.this.chatViewAdapter.getItemCount() <= 0) {
                    return;
                }
                List<BaseNode> datas = IM.this.chatViewAdapter.getDatas();
                if (datas != null && !datas.isEmpty()) {
                    i3 = 0;
                    while (i3 < datas.size()) {
                        if (datas.get(i3).isListTop) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                i3 = -1;
                if (i3 != -1) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) IM.this.chatView.getLayoutManager();
                    int headerCount = IM.this.chatView.getHeaderCount();
                    int n = linearLayoutManager.n();
                    if (headerCount + i3 < n) {
                        this.offset += i2;
                        if (this.screenHeight == -1) {
                            this.screenHeight = ViewUtils.getScreenHeightPixels(IM.this.chatView.getContext()) - ViewUtils.dip2px(IM.this.chatView.getContext(), 90.0f);
                        }
                        if (this.offset > this.screenHeight * 2 || (n - headerCount) - i3 > 9) {
                            showTopIcon(true);
                            return;
                        } else {
                            showTopIcon(false);
                            return;
                        }
                    }
                    this.offset = 0;
                    showTopIcon(false);
                }
            }

            void showTopIcon(boolean z) {
                ViewGroup.LayoutParams layoutParams = IM.this.optionView.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                if (z) {
                    if (layoutParams2 != null) {
                        layoutParams2.setMarginEnd(ViewUtils.dip2px(IM.this.context, 55.0f));
                        IM.this.optionView.setLayoutParams(layoutParams2);
                    }
                    IM.this.vGoTop.setVisibility(0);
                    return;
                }
                if (layoutParams2 != null) {
                    layoutParams2.setMarginEnd(0);
                    IM.this.optionView.setLayoutParams(layoutParams2);
                }
                IM.this.vGoTop.setVisibility(8);
            }
        };
        this.lastIndex = 0;
        this.hasCacheNext = false;
        this.keyboardListener = new InputView.KeyboardListener() { // from class: com.tencent.grobot.lite.ui.IM.9
            @Override // com.tencent.grobot.lite.ui.view.InputView.KeyboardListener
            public void onKeyBoardShow() {
            }

            @Override // com.tencent.grobot.lite.ui.view.InputView.KeyboardListener
            public void onKeyBoardHide() {
                IM.this.mCacheEvaluateItemInfo = null;
            }
        };
        if (bundle.containsKey(Router.ARGS_INIT_DATA)) {
            this.initString = bundle.getString(Router.ARGS_INIT_DATA);
        }
        if (bundle.containsKey(Router.ARGS_INIT_QUES)) {
            this.initQuestion = bundle.getString(Router.ARGS_INIT_QUES);
        }
        this.handler = new Handler(this);
    }

    @Override // com.tencent.grobot.lite.ui.container.Frame
    protected View view() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.im, (ViewGroup) null, false);
        this.chatView = (ChatRecyclerView) inflate.findViewById(R.id.chatView);
        buildChatView();
        this.inputView = (InputView) inflate.findViewById(R.id.inputView);
        this.inputView.setMainHandler(this.handler);
        this.inputView.setKeyboardListener(this.keyboardListener);
        this.closeBtn = (ImageView) inflate.findViewById(R.id.closeBtn);
        this.closeBtn.setOnClickListener(this);
        if (GRobotApplication.getInstance().isHighPerformace()) {
            this.closeBtn.setImageResource(R.drawable.icon_close_high_performace);
        } else {
            this.closeBtn.setImageResource(R.drawable.icon_close);
        }
        this.mHotList = (ListView) inflate.findViewById(R.id.list_help);
        buildHotView();
        this.optionView = (HorizontalView) inflate.findViewById(R.id.optionView);
        buildOptionView();
        this.imActionView = (IMActionView) inflate.findViewById(R.id.im_action);
        this.imActionView.setHandler(this.handler);
        this.vGoTop = inflate.findViewById(R.id.v_go_to_top);
        View view = this.vGoTop;
        if (view != null) {
            view.setOnClickListener(this);
            this.chatView.addOnScrollListener(this.chatViewScrollListener);
        }
        this.vBgOptions = inflate.findViewById(R.id.v_options_bg);
        return inflate;
    }

    @Override // com.tencent.grobot.lite.ui.container.Frame
    protected void onCreate() {
        initRobot();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
            jSONObject.put(ReportBridge.KEY_MODULE_ID, "30014");
            ReportBridge.report(jSONObject, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.grobot.lite.ui.container.Frame
    protected void onAttachedToWindow() {
        fixNotchScreen();
    }

    @Override // com.tencent.grobot.lite.ui.container.Frame
    protected void onResume() {
        super.onResume();
        this.startTime = System.currentTimeMillis();
    }

    @Override // com.tencent.grobot.lite.ui.container.Frame
    protected void onDestroy() {
        if (this.startTime != 0) {
            long currentTimeMillis = (System.currentTimeMillis() - this.startTime) / 1000;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", currentTimeMillis);
                new Report().eventType("1002").itemId("7168").ext(jSONObject.toString()).report(false);
            } catch (JSONException e) {
                TLog.d(TAG, "report duration failed," + e);
            }
        }
        onCloseView(true);
    }

    @Override // com.tencent.grobot.lite.ui.container.Frame
    protected boolean onBackPressed() {
        if (GRobotApplication.getInstance().isHighPerformace()) {
            SystemUtils.closeKeybord(this.context);
            this.context.finish();
            return true;
        }
        SystemUtils.closeKeybord(this.context);
        GRobotEnterManager.closeGRobtoView(this.context);
        return true;
    }

    @Override // com.tencent.grobot.lite.ui.container.Frame
    protected void onActivityResult(int i, int i2, Intent intent) {
        ((FormDialog) this.context.getDialog(FormDialog.class)).handleCallBackOnActivityForResult(i, i2, intent);
    }

    @Override // com.tencent.grobot.lite.ui.container.Frame
    protected void onScreenOrientChange(int i) {
        fixNotchScreen();
    }

    private void initRobot() {
        TLog.d(TAG, "initRobot: initString:" + this.initString);
        if (!TextUtils.isEmpty(this.initString)) {
            showOldData();
        }
        if (this.hasInitRobot) {
            return;
        }
        ThreadManager.get().postDelayToUiThread(new InitRotoRunnable(this, !TextUtils.isEmpty(this.initString)), 200L);
    }

    private void buildChatView() {
        this.chatViewAdapter = new ChatAdapter(this.context);
        this.chatViewAdapter.setClickListener(new BaseViewHolder.OnItemClickListener() { // from class: com.tencent.grobot.lite.ui.IM.2
            @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder.OnItemClickListener
            public void onItemClick(View view, int i, int i2, Object obj) {
                TLog.d(IM.TAG, "onItemClick: position:" + i + ",type:" + i2);
                if (IM.this.chatClickHelper.clickable()) {
                    IM.this.chatClickHelper.clicked();
                    if (obj != null) {
                        Message obtainMessage = IM.this.handler.obtainMessage(1004);
                        obtainMessage.arg1 = i;
                        obtainMessage.arg2 = i2;
                        obtainMessage.obj = obj;
                        IM.this.handler.sendMessage(obtainMessage);
                    }
                }
            }
        });
        this.chatView.setAdapter(this.chatViewAdapter);
        this.chatView.addItemDecoration(new ChatDividerDecoration(this.context));
        this.chatView.setOnRefreshListener(new ChatRecyclerView.OnRefreshListener() { // from class: com.tencent.grobot.lite.ui.IM.3
            @Override // com.tencent.grobot.lite.ui.view.ChatRecyclerView.OnRefreshListener
            public void onRefresh() {
                if (IM.this.hasCacheNext) {
                    IM.this.mPresenter.loadHistoryLog();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(ReportBridge.KEY_ITEM_ID, "7018");
                        jSONObject.put(ReportBridge.KEY_EVENT_TYPE, NativeContentAd.ASSET_LOGO);
                        ReportBridge.report(jSONObject, false);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                IM.this.chatView.stopRefresh(IM.this.hasCacheNext);
            }
        });
    }

    private void buildOptionView() {
        this.optinViewAdapter = new OptionAdapter(this.context);
        this.optinViewAdapter.setClickListener(new BaseViewHolder.OnItemClickListener() { // from class: com.tencent.grobot.lite.ui.IM.4
            @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder.OnItemClickListener
            public void onItemClick(View view, int i, int i2, Object obj) {
                TLog.d(IM.TAG, "onItemClick: position:" + i + ",type:" + i2);
                if (IM.this.optionsClickHelper.clickable()) {
                    IM.this.optionsClickHelper.clicked();
                    if (obj != null) {
                        Message obtainMessage = IM.this.handler.obtainMessage(1005);
                        obtainMessage.arg1 = i;
                        obtainMessage.arg2 = i2;
                        obtainMessage.obj = obj;
                        IM.this.handler.sendMessage(obtainMessage);
                    }
                }
            }
        });
        this.optionView.setAdapter(this.optinViewAdapter);
        this.optionView.setLayoutManager(new LinearLayoutManager(this.context, 0, false));
    }

    private void buildHotView() {
        this.mHotAdapter = new HotAdapter(this.context);
        this.mHotList.setAdapter((ListAdapter) this.mHotAdapter);
        this.mHotList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.grobot.lite.ui.IM.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TLog.d(IM.TAG, "hot list click");
                if (IM.this.hotListClickHelper.clickable()) {
                    IM.this.hotListClickHelper.clicked();
                    IM.this.mHotAdapter.setSelectedPos(i);
                    HotInfo item = IM.this.mHotAdapter.getItem(i);
                    if (item != null) {
                        IM.this.sendQuestion(item.questionId, item.title, false, true, 10);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                            jSONObject.put(ReportBridge.KEY_ITEM_ID, "7056");
                            jSONObject.put(ReportBridge.KEY_INDEX_ID, String.valueOf(i + 7001));
                            ReportBridge.report(jSONObject, false);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    private void onCloseView(boolean z) {
        this.rootView.setBackgroundResource(0);
        ViewParent parent = this.rootView.getParent();
        if (parent instanceof ViewGroup) {
            if (z) {
                GRobotApplication.getInstance().setBackground(true);
            }
            ViewUtils.clearViews(this.rootView);
            ((ViewGroup) parent).removeView(this.rootView);
        }
        Message obtain = Message.obtain();
        obtain.what = MSG_DESTORY_VIEW;
        obtain.arg1 = z ? 1 : 0;
        this.handler.sendMessage(obtain);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i != 1001) {
            if (i == 1009) {
                handleIM(message.obj);
            } else if (i != 1999) {
                switch (i) {
                    case 1004:
                        handleAction(message.arg1, message.arg2, message.obj);
                        break;
                    case 1005:
                        handleOption(message.arg1, message.arg2, message.obj);
                        break;
                }
            } else {
                this.handler.removeCallbacksAndMessages(null);
                this.handler = null;
                this.chatViewAdapter.onDestroy();
                this.chatViewAdapter = null;
                this.optinViewAdapter.onDestroy();
                this.optinViewAdapter = null;
                this.chatView.setAdapter(null);
                this.chatView.getRecycledViewPool().a();
                this.chatView.setOnRefreshListener(null);
                this.chatView.onDestory();
                this.chatView = null;
                this.optionView.setAdapter(null);
                this.optionView.getRecycledViewPool().a();
                this.optionView.onDestroy();
                this.optionView = null;
                this.mHotList.setAdapter((ListAdapter) null);
                this.mHotList = null;
                this.mHotAdapter = null;
                this.inputView.onDestory();
                this.inputView = null;
                this.closeBtn.setOnClickListener(null);
                this.closeBtn = null;
                this.imActionView.onDestory();
                this.imActionView = null;
                this.mPresenter.onDestroy();
                this.mPresenter = null;
                if (message.arg1 == 1) {
                    GRobotEnterManager.onClose();
                }
                SystemUtils.doGC();
            }
        } else if (message.obj instanceof InputView.QueryParam) {
            sendQuestion(((InputView.QueryParam) message.obj).questionId, ((InputView.QueryParam) message.obj).question, false, false, ((InputView.QueryParam) message.obj).robotType);
        }
        return true;
    }

    private void handleOption(int i, int i2, Object obj) {
        if (obj instanceof OptionItemInfo) {
            OptionItemInfo optionItemInfo = (OptionItemInfo) obj;
            sendQuestion(optionItemInfo.optionId, optionItemInfo.optionText, false, true, 2);
        }
        if (obj instanceof EvaluateItemInfo) {
            handleFeedbackItemInfoClick((EvaluateItemInfo) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendQuestion(String str, String str2, boolean z, boolean z2, int i) {
        ChatAdapter chatAdapter;
        if (TextUtils.isEmpty(str2)) {
            if (this.mCacheEvaluateItemInfo != null) {
                this.mCacheEvaluateItemInfo = null;
                return;
            }
            return;
        }
        int itemCount = (!z || (chatAdapter = this.chatViewAdapter) == null) ? -1 : chatAdapter.getItemCount();
        if (i != 0) {
            this.mCacheEvaluateItemInfo = null;
        }
        EvaluateItemInfo evaluateItemInfo = this.mCacheEvaluateItemInfo;
        if (evaluateItemInfo != null) {
            evaluateItemInfo.reqText = this.mCacheEvaluateItemInfo.optionText + "|" + str2;
            EvaluateItemInfo evaluateItemInfo2 = this.mCacheEvaluateItemInfo;
            evaluateItemInfo2.selectText = str2;
            this.mPresenter.addEvaluate(0, evaluateItemInfo2, true);
            return;
        }
        this.mPresenter.sendMsg(str, str2, itemCount, i);
    }

    private void handleAction(int i, int i2, Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof HotTextItemInfo) {
            HotTextItemInfo hotTextItemInfo = (HotTextItemInfo) obj;
            sendQuestion(hotTextItemInfo.questionId, hotTextItemInfo.questionText, false, true, 3);
            return;
        }
        if (obj instanceof FormNode) {
            FormDialog formDialog = (FormDialog) this.context.getDialog(FormDialog.class);
            formDialog.clearContent();
            formDialog.setPresenter(this.mPresenter);
            formDialog.setFormId(((FormNode) obj).formId);
            formDialog.showCustomDialog();
            return;
        }
        if (obj instanceof TicketNode) {
            TicketDialog ticketDialog = (TicketDialog) this.context.getDialog(TicketDialog.class);
            ticketDialog.setPresenter(this.mPresenter);
            ticketDialog.setTicketId(((TicketNode) obj).ticketId);
            ticketDialog.showCustomDialog();
            return;
        }
        if (obj instanceof TicketStarNode) {
            TicketStarNode ticketStarNode = (TicketStarNode) obj;
            this.mPresenter.evalueate(ticketStarNode.rating, ticketStarNode.evaluateInfo);
            return;
        }
        if (obj instanceof IMStarNode) {
            IMStarNode iMStarNode = (IMStarNode) obj;
            this.mPresenter.evalueate(iMStarNode.rating, iMStarNode.evaluateInfo);
            return;
        }
        if (obj instanceof EvaluateItemInfo) {
            handleFeedbackItemInfoClick((EvaluateItemInfo) obj);
            return;
        }
        if (obj instanceof AnsTextNode.LinkInfo) {
            AnsTextNode.LinkInfo linkInfo = (AnsTextNode.LinkInfo) obj;
            if (linkInfo.type == 0) {
                sendQuestion(linkInfo.questionId, linkInfo.word, false, true, 7);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                    jSONObject.put(ReportBridge.KEY_SUB_ID, linkInfo.questionId);
                    jSONObject.put(ReportBridge.KEY_ITEM_ID, "7047");
                    jSONObject.put(ReportBridge.KEY_INDEX_ID, String.valueOf(i + 7001));
                    ReportBridge.report(jSONObject, false);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (linkInfo.type == 1) {
                if (TextUtils.isEmpty(linkInfo.url)) {
                    return;
                }
                try {
                    if (!linkInfo.url.startsWith("http")) {
                        linkInfo.url = "http://" + linkInfo.url;
                    }
                    this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(linkInfo.url)));
                    return;
                } catch (Exception e2) {
                    TLog.e(TAG, "goto web link failed, " + e2.getMessage());
                    return;
                }
            }
            if (linkInfo.type == 2) {
                JNIManager.onUrlCallBack(linkInfo.url == null ? "" : linkInfo.url);
                return;
            }
            return;
        }
        if (obj instanceof QuTextNode) {
            this.chatViewAdapter.deleteItem(i - this.chatView.getHeaderCount());
            QuTextNode quTextNode = (QuTextNode) obj;
            sendQuestion(quTextNode.questionId, quTextNode.text, true, true, quTextNode.robotType);
            return;
        }
        if (obj instanceof GiftNode) {
            GiftNode giftNode = (GiftNode) obj;
            this.mPresenter.getGiftPackage(giftNode.groupId, giftNode.amsId, giftNode.name, giftNode.answerId);
            return;
        }
        if (obj instanceof ContainerInfo) {
            ContainerInfo containerInfo = (ContainerInfo) obj;
            if (containerInfo.itemType == 4) {
                sendQuestion(containerInfo.questionInfo.resourceId, containerInfo.questionInfo.name, false, true, 3);
                return;
            }
            if (containerInfo.itemType == 1) {
                Bundle bundle = new Bundle();
                bundle.putString("img_url", containerInfo.picInfo.url);
                Router.jump(this.context, Pic.class, bundle, false, true);
                ReportBridge.reportViewsClick(1, containerInfo.picInfo.resourceId);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                    jSONObject2.put(ReportBridge.KEY_ITEM_ID, "7138");
                    jSONObject2.put(ReportBridge.KEY_SUB_ID, containerInfo.picInfo.resourceId);
                    jSONObject2.put(ReportBridge.KEY_ITEM_SUB_1, "2");
                    jSONObject2.put(ReportBridge.KEY_INDEX_ID, String.valueOf(i + 8001));
                    ReportBridge.report(jSONObject2, false);
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            if (containerInfo.itemType == 2) {
                VideoItemInfo videoItemInfo = containerInfo.videoInfo;
                YoutubePlayerDelegate.play(this.context, new YoutubeParams(videoItemInfo.videoId, videoItemInfo.name));
                ReportBridge.reportViewsClick(0, videoItemInfo.resourceId);
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                    jSONObject3.put(ReportBridge.KEY_ITEM_ID, "7138");
                    jSONObject3.put(ReportBridge.KEY_SUB_ID, containerInfo.videoInfo.resourceId);
                    jSONObject3.put(ReportBridge.KEY_ITEM_SUB_1, "3");
                    jSONObject3.put(ReportBridge.KEY_INDEX_ID, String.valueOf(i + 8001));
                    ReportBridge.report(jSONObject3, false);
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            if (containerInfo.itemType == 3) {
                MixTipInfo mixTipInfo = containerInfo.tipInfo;
                TipDialog tipDialog = (TipDialog) this.context.getDialog(TipDialog.class);
                tipDialog.setData(mixTipInfo.title, mixTipInfo);
                tipDialog.showCustomDialog();
                ReportBridge.reportViewsClick(2, mixTipInfo.resourceId);
                try {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                    jSONObject4.put(ReportBridge.KEY_ITEM_ID, "7138");
                    jSONObject4.put(ReportBridge.KEY_SUB_ID, containerInfo.tipInfo.resourceId);
                    jSONObject4.put(ReportBridge.KEY_ITEM_SUB_1, "1");
                    jSONObject4.put(ReportBridge.KEY_INDEX_ID, String.valueOf(i + 8001));
                    ReportBridge.report(jSONObject4, false);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    private void handleFeedbackItemInfoClick(EvaluateItemInfo evaluateItemInfo) {
        if (evaluateItemInfo != null) {
            if (evaluateItemInfo.actionType.equals(EvaluateItemInfo.ACTIONTYPE_API)) {
                this.mPresenter.addEvaluate(0, evaluateItemInfo, true);
            } else if (evaluateItemInfo.actionType.equals(EvaluateItemInfo.ACTIONTYPE_INPUT)) {
                this.mCacheEvaluateItemInfo = evaluateItemInfo;
                this.inputView.showSoftKeyboard();
            }
        }
    }

    private void handleIM(Object obj) {
        if (obj instanceof IMActionView.IMClickObj) {
            IMActionView.IMClickObj iMClickObj = (IMActionView.IMClickObj) obj;
            switch (iMClickObj.state) {
                case 0:
                case 2:
                case 3:
                    this.mPresenter.closeIM();
                    return;
                case 1:
                    this.mPresenter.readyEnterIM(iMClickObj.extra);
                    new Report().eventType("1002").itemId("7065").report(false);
                    return;
                default:
                    this.mPresenter.closeIM();
                    return;
            }
        }
    }

    private void smoothScrollToTop() {
        int i;
        ChatAdapter chatAdapter = this.chatViewAdapter;
        if (chatAdapter == null || chatAdapter.getItemCount() <= 0) {
            return;
        }
        List<BaseNode> datas = this.chatViewAdapter.getDatas();
        if (datas != null && !datas.isEmpty()) {
            i = 0;
            while (i < datas.size()) {
                if (datas.get(i).isListTop) {
                    break;
                } else {
                    i++;
                }
            }
        }
        i = -1;
        if (i != -1) {
            this.chatView.smoothScrollToPosition(i + this.chatView.getHeaderCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToEnd(int i) {
        ChatAdapter chatAdapter = this.chatViewAdapter;
        if (chatAdapter == null || chatAdapter.getItemCount() <= 0) {
            return;
        }
        if (i > 0) {
            ((LinearLayoutManager) this.chatView.getLayoutManager()).b(i + 1, 0);
            return;
        }
        int itemCount = this.chatViewAdapter.getItemCount() - 1;
        List<BaseNode> datas = this.chatViewAdapter.getDatas();
        if (datas != null) {
            datas.get(itemCount);
            int headerCount = this.chatView.getHeaderCount();
            ChatRecyclerView chatRecyclerView = this.chatView;
            chatRecyclerView.scrollToPosition(itemCount + headerCount + (this.showNetworkLoding ? chatRecyclerView.getFooterCount() : 0));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.closeBtn) {
            if (GRobotApplication.getInstance().isHighPerformace()) {
                SystemUtils.closeKeybord(this.context);
                this.context.finish();
                return;
            } else {
                SystemUtils.closeKeybord(this.context);
                GRobotEnterManager.closeGRobtoView(this.context);
                return;
            }
        }
        if (id == R.id.v_go_to_top) {
            smoothScrollToTop();
        }
    }

    @Override // com.tencent.grobot.lite.ui.presenter.IMsgView
    public void onInitFinish(boolean z) {
        this.showNetworkLoding = z;
    }

    @Override // com.tencent.grobot.lite.ui.presenter.IMsgView
    public void onLoadMsgFinish(final boolean z, final boolean z2, int i, final ArrayList<BaseNode> arrayList, final int i2, final AnsOptionNode ansOptionNode, int i3, int i4, final boolean z3, final boolean z4) {
        if (i == 0) {
            if (this.context.hasDialog(ReconnectDialog.class)) {
                ReconnectDialog reconnectDialog = (ReconnectDialog) this.context.getDialog(ReconnectDialog.class);
                if (reconnectDialog.getState() == 1) {
                    reconnectDialog.setState(2);
                }
            }
            if (i3 >= 0) {
                this.chatViewAdapter.refreshItem(i3, i4, 1);
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.startSendTime);
            int i5 = (currentTimeMillis >= 1000 || !z3) ? 0 : 1000 - currentTimeMillis;
            Log.d("msg", "delayTime = " + i5 + " isNetMsg = " + z3);
            ThreadManager.get().postDelayToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.IM.6
                @Override // java.lang.Runnable
                public void run() {
                    if (z3 && IM.this.showNetworkLoding) {
                        IM.this.chatView.showFooter(false);
                    }
                    int itemCount = IM.this.chatViewAdapter.getItemCount();
                    IM.this.chatViewAdapter.addItems(arrayList);
                    IM.this.scrollToEnd(itemCount);
                    IM.this.parseOptionNode(i2, ansOptionNode, z4);
                    if (z) {
                        IM.this.hasCacheNext = z2;
                        IM im = IM.this;
                        im.sendQuestion("", im.initQuestion, false, false, 0);
                        IM.this.initQuestion = "";
                        ArrayList arrayList2 = arrayList;
                        if (arrayList2 == null || arrayList2.isEmpty()) {
                            return;
                        }
                        ((BaseNode) arrayList.get(0)).isListTop = true;
                    }
                }
            }, (long) i5);
            return;
        }
        if (z3 && this.showNetworkLoding) {
            this.chatView.showFooter(false);
        }
        if (!z) {
            if (i3 >= 0) {
                this.chatViewAdapter.refreshItem(i3, i4, 2);
            }
        } else {
            if (this.context.hasDialog(ReconnectDialog.class)) {
                ((ReconnectDialog) this.context.getDialog(ReconnectDialog.class)).setState(3);
                return;
            }
            ReconnectDialog reconnectDialog2 = (ReconnectDialog) this.context.getDialog(ReconnectDialog.class);
            reconnectDialog2.setAction(this.reconnectAction);
            reconnectDialog2.setState(0);
            reconnectDialog2.showCustomDialog();
        }
    }

    @Override // com.tencent.grobot.lite.ui.presenter.IMsgView
    public void onLoadCacheFinish(boolean z, boolean z2, ArrayList<BaseNode> arrayList, int i, AnsOptionNode ansOptionNode, int i2, int i3, boolean z3) {
        this.hasCacheNext = z2;
        this.chatView.stopRefresh(this.hasCacheNext);
        if (z) {
            this.lastIndex = arrayList != null ? arrayList.size() : 0;
            if (i2 < 0) {
                this.chatViewAdapter.addItems(arrayList);
            } else {
                this.chatViewAdapter.insertItems(arrayList);
            }
            scrollToEnd(-1);
            return;
        }
        int size = arrayList != null ? arrayList.size() : 0;
        this.lastIndex += size;
        this.chatViewAdapter.insertItems(arrayList);
        parseOptionNode(i, ansOptionNode, z3);
        ((LinearLayoutManager) this.chatView.getLayoutManager()).b(size + 1, 0);
    }

    @Override // com.tencent.grobot.lite.ui.presenter.IMsgView
    public int getLastPosition() {
        ChatAdapter chatAdapter = this.chatViewAdapter;
        if (chatAdapter != null) {
            return chatAdapter.getItemCount();
        }
        return 0;
    }

    @Override // com.tencent.grobot.lite.ui.presenter.IMsgView
    public void onEvaluateResult(boolean z, EvaluateReqInfo evaluateReqInfo) {
        this.mCacheEvaluateItemInfo = null;
        if (!z || evaluateReqInfo == null) {
            return;
        }
        TextDialog textDialog = (TextDialog) this.context.getDialog(TextDialog.class);
        if (textDialog.isShowing()) {
            textDialog.refreshLikeUnlikeView(evaluateReqInfo.answerKey, evaluateReqInfo.firstClickText, evaluateReqInfo.secondClickText);
        } else {
            this.chatViewAdapter.refreshAnsTextItemLikeUnlike(evaluateReqInfo.answerKey, evaluateReqInfo.firstClickText, evaluateReqInfo.secondClickText);
            hideBadGoodView(evaluateReqInfo.answerKey);
            if (evaluateReqInfo.evaluateType.equals(EvaluateInfo.TYPE_TICKET)) {
                DataManager.getInstance().setTicketStared(evaluateReqInfo.evaluateId, evaluateReqInfo.rating);
            } else if (evaluateReqInfo.evaluateType.equals(EvaluateInfo.TYPE_IM)) {
                DataManager.getInstance().setSessionStared(evaluateReqInfo.evaluateId, evaluateReqInfo.rating);
            }
        }
        if (this.evaluateOptionAdapter == null || TextUtils.isEmpty(evaluateReqInfo.evaluateContent)) {
            return;
        }
        this.evaluateOptionAdapter.setOptionNode(null);
    }

    @Override // com.tencent.grobot.lite.ui.presenter.IMsgView
    public void onGetHostSucc(ArrayList<HotInfo> arrayList) {
        this.mHotAdapter.updateHelpInfos(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseOptionNode(int i, AnsOptionNode ansOptionNode, boolean z) {
        if (ansOptionNode != null && z) {
            if (ansOptionNode.optionItems != null) {
                ArrayList arrayList = new ArrayList();
                for (OptionItemInfo optionItemInfo : ansOptionNode.optionItems) {
                    if (optionItemInfo.optionType == 2) {
                        this.imActionView.setOptionItem(optionItemInfo);
                        ((RelativeLayout.LayoutParams) this.optionView.getLayoutParams()).leftMargin = ViewUtils.dip2px(this.context, 0.0f);
                    } else {
                        arrayList.add(optionItemInfo);
                    }
                }
                this.optionView.setAdapter(this.optinViewAdapter);
                this.optinViewAdapter.setOptionNode(arrayList);
                if (this.vBgOptions != null) {
                    this.vBgOptions.setVisibility(arrayList.isEmpty() ? 8 : 0);
                    return;
                }
                return;
            }
            if (ansOptionNode.evaluateItemInfos != null) {
                if (this.evaluateOptionAdapter == null) {
                    final boolean z2 = ansOptionNode.needReport;
                    this.evaluateOptionAdapter = new EvaluateOptionAdapter(this.context);
                    this.evaluateOptionAdapter.setClickListener(new BaseViewHolder.OnItemClickListener() { // from class: com.tencent.grobot.lite.ui.IM.7
                        @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder.OnItemClickListener
                        public void onItemClick(View view, int i2, int i3, Object obj) {
                            TLog.d(IM.TAG, "onItemClick: position:" + i2 + ",type:" + i3);
                            if (obj != null) {
                                Message obtainMessage = IM.this.handler.obtainMessage(1005);
                                obtainMessage.arg1 = i2;
                                obtainMessage.arg2 = i3;
                                obtainMessage.obj = obj;
                                IM.this.handler.sendMessage(obtainMessage);
                                if (z2 && (obj instanceof EvaluateItemInfo)) {
                                    new Report().eventType("1002").itemId("7057").ext(((EvaluateItemInfo) obj).extDesc).report(false);
                                }
                            }
                        }
                    });
                }
                this.optionView.setAdapter(this.evaluateOptionAdapter);
                this.evaluateOptionAdapter.setOptionNode(ansOptionNode.evaluateItemInfos);
            }
        }
        if (z) {
            if (i == 0) {
                this.imActionView.setOptionItem(null);
                ((RelativeLayout.LayoutParams) this.optionView.getLayoutParams()).leftMargin = ViewUtils.dip2px(this.context, 5.0f);
            }
            this.optinViewAdapter.setOptionNode(null);
            View view = this.vBgOptions;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.grobot.lite.ui.presenter.IIMView
    public void updateBottomActionView(int i, String str, IMMsgInfo.SysMsg sysMsg) {
        IMActionView iMActionView = this.imActionView;
        if (iMActionView != null) {
            iMActionView.updateRobotStatus(i, str, sysMsg);
        }
    }

    @Override // com.tencent.grobot.lite.ui.presenter.IIMView
    public void setFormData(int i, JSONObject jSONObject) {
        ((FormDialog) this.context.getDialog(FormDialog.class)).setFormData(i, jSONObject);
        if (i == 300309) {
            removeFormEntrance();
        }
    }

    @Override // com.tencent.grobot.lite.ui.presenter.IIMView
    public void onFormCommitResult(int i, String str) {
        ((FormDialog) this.context.getDialog(FormDialog.class)).onFormCommitResult(i, str);
        if (i == 0) {
            removeFormEntrance();
        }
    }

    @Override // com.tencent.grobot.lite.ui.presenter.IMsgView
    public void onSendRobotMsg() {
        this.startSendTime = System.currentTimeMillis();
        if (this.showNetworkLoding) {
            ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.IM.8
                @Override // java.lang.Runnable
                public void run() {
                    IM.this.chatView.showFooter(true);
                }
            });
        }
    }

    @Override // com.tencent.grobot.lite.ui.presenter.IIMView
    public void onGetTicketDetail(String str, int i, JSONObject jSONObject) {
        ((TicketDialog) this.context.getDialog(TicketDialog.class)).onGetTicketDetail(str, i, jSONObject);
    }

    @Override // com.tencent.grobot.lite.ui.presenter.IMsgView
    public void onGetPackageResult(int i, String str, String str2, String str3) {
        this.chatViewAdapter.updateGiftReceiveState(i, str2, str3);
    }

    private void removeTicketStarEntrance(String str) {
        this.chatViewAdapter.removeTicketStarNode(str);
    }

    private void removeIMUserScoreEntrance(String str) {
        this.chatViewAdapter.removeIMStarNode(str);
    }

    private void removeFormEntrance() {
        this.chatViewAdapter.removeAllFromNode();
    }

    private void hideBadGoodView(String str) {
        this.chatViewAdapter.hideGoodBadView(str);
    }

    private void addPaddingView(int i, int i2, int i3, int i4, int i5) {
        View findViewById = this.rootView.findViewById(i);
        if (findViewById != null) {
            findViewById.setPadding(i2, i3, i4, i5);
        }
    }

    private void fixNotchScreen() {
        int statusBarHeight;
        int statusBarHeight2;
        if (SystemUtils.hasNotch(this.context)) {
            int rotation = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getRotation();
            boolean z = LangUtils.getLayoutDirectionFromLocale(this.context.getResources().getConfiguration().locale) == 1;
            int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.dimen.im_chat_padding_bottom);
            if (rotation == 1) {
                if (Build.VERSION.SDK_INT >= 28) {
                    statusBarHeight2 = SystemUtils.getSafeInsetLeft(this.context);
                } else {
                    statusBarHeight2 = SystemUtils.getStatusBarHeight(this.context) + ViewUtils.dip2px(this.context, 20.0f);
                }
                TLog.d(NetworkManager.CMD_INFO, "safeInsetLeft: " + statusBarHeight2);
                if (z) {
                    addStartPaddingView(R.id.hot_container, 0, ViewUtils.dip2px(this.context, 126.0f), z);
                    addPaddingView(R.id.chatView, statusBarHeight2, 0, 0, dimensionPixelSize);
                    changeViewStartMargin(R.id.im_container, ViewUtils.dip2px(this.context, 126.0f), z);
                    changeViewStartMargin(R.id.bottom_cutline, ViewUtils.dip2px(this.context, 126.0f), z);
                    changeViewStartMargin(R.id.input_container, ViewUtils.dip2px(this.context, 126.0f), z);
                    changeViewStartMargin(R.id.v_divider, ViewUtils.dip2px(this.context, 126.0f), z);
                } else {
                    addStartPaddingView(R.id.hot_container, statusBarHeight2, ViewUtils.dip2px(this.context, 126.0f), z);
                    addPaddingView(R.id.chatView, 0, 0, 0, dimensionPixelSize);
                    changeViewStartMargin(R.id.im_container, ViewUtils.dip2px(this.context, 126.0f) + statusBarHeight2, z);
                    changeViewStartMargin(R.id.bottom_cutline, ViewUtils.dip2px(this.context, 126.0f) + statusBarHeight2, z);
                    changeViewStartMargin(R.id.input_container, ViewUtils.dip2px(this.context, 126.0f) + statusBarHeight2, z);
                    changeViewStartMargin(R.id.v_divider, ViewUtils.dip2px(this.context, 126.0f) + statusBarHeight2, z);
                }
            } else {
                if (Build.VERSION.SDK_INT >= 28) {
                    statusBarHeight = SystemUtils.getSafeInsetRight(this.context);
                } else {
                    statusBarHeight = SystemUtils.getStatusBarHeight(this.context) + ViewUtils.dip2px(this.context, 20.0f);
                }
                TLog.d(NetworkManager.CMD_INFO, "safeInsetRight: " + statusBarHeight);
                if (z) {
                    addStartPaddingView(R.id.hot_container, statusBarHeight, ViewUtils.dip2px(this.context, 126.0f), z);
                    addPaddingView(R.id.chatView, 0, 0, 0, dimensionPixelSize);
                    changeViewStartMargin(R.id.im_container, ViewUtils.dip2px(this.context, 126.0f) + statusBarHeight, z);
                    changeViewStartMargin(R.id.bottom_cutline, ViewUtils.dip2px(this.context, 126.0f) + statusBarHeight, z);
                    changeViewStartMargin(R.id.input_container, ViewUtils.dip2px(this.context, 126.0f) + statusBarHeight, z);
                    changeViewStartMargin(R.id.v_divider, ViewUtils.dip2px(this.context, 126.0f) + statusBarHeight, z);
                } else {
                    addStartPaddingView(R.id.hot_container, 0, ViewUtils.dip2px(this.context, 126.0f), z);
                    addPaddingView(R.id.chatView, 0, 0, statusBarHeight, dimensionPixelSize);
                    changeViewStartMargin(R.id.im_container, ViewUtils.dip2px(this.context, 126.0f), z);
                    changeViewStartMargin(R.id.bottom_cutline, ViewUtils.dip2px(this.context, 126.0f), z);
                    changeViewStartMargin(R.id.input_container, ViewUtils.dip2px(this.context, 126.0f), z);
                    changeViewStartMargin(R.id.v_divider, ViewUtils.dip2px(this.context, 126.0f), z);
                }
            }
            this.hasFixNotch = true;
        }
    }

    private void addStartPaddingView(int i, int i2, int i3, boolean z) {
        View findViewById = this.rootView.findViewById(i);
        if (findViewById != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
            marginLayoutParams.width = i3 + i2;
            findViewById.setLayoutParams(marginLayoutParams);
            if (Build.VERSION.SDK_INT >= 17) {
                findViewById.setPaddingRelative(i2, 0, 0, 0);
            } else if (z) {
                findViewById.setPadding(0, 0, i2, 0);
            } else {
                findViewById.setPadding(i2, 0, 0, 0);
            }
        }
    }

    private void changeViewStartMargin(int i, int i2, boolean z) {
        View findViewById = this.rootView.findViewById(i);
        if (findViewById != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(i2);
            } else if (z) {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = i2;
            } else {
                layoutParams.leftMargin = i2;
                layoutParams.rightMargin = 0;
            }
            findViewById.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class InitRotoRunnable implements Runnable {
        private final boolean pureInit;
        private final WeakReference<IM> target;

        public InitRotoRunnable(IM im, boolean z) {
            this.target = new WeakReference<>(im);
            this.pureInit = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            IM im = this.target.get();
            if (im == null || im.hasInitRobot) {
                return;
            }
            im.hasInitRobot = true;
            im.mPresenter.initRobot(this.pureInit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ReconnectActionDelegate implements ReconnectDialog.ActionDelegate {
        public boolean hasRetry = false;
        private final WeakReference<IM> target;

        public ReconnectActionDelegate(IM im) {
            this.target = new WeakReference<>(im);
        }

        @Override // com.tencent.grobot.lite.ui.dialog.ReconnectDialog.ActionDelegate
        public void reconnect() {
            IM im = this.target.get();
            if (im != null) {
                im.mPresenter.initRobot(!TextUtils.isEmpty(im.initString));
            }
        }
    }

    private void showOldData() {
        Log.d("IM_", "showOldData");
        if (TextUtils.isEmpty(this.initString)) {
            return;
        }
        try {
            AnswerInfo convertAnswer = AnswerModelConverter.convertAnswer(new JSONObject(this.initString));
            if (convertAnswer == null) {
                return;
            }
            onLoadMsgFinish(false, true, 0, DataProcessor.parseAnswer(convertAnswer.answerId, "", "", (byte) 0, convertAnswer.answerList, false), 0, DataProcessor.parseOptions(convertAnswer.optionList), -1, 0, false, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.grobot.lite.ui.presenter.IMsgView
    public void onPureInitFinish(boolean z) {
        if (z) {
            sendQuestion("", this.initQuestion, false, false, 0);
            this.initQuestion = "";
        }
    }
}
