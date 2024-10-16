package com.tencent.grobot.lite.ui.view;

import android.content.Context;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.Const;
import com.tencent.grobot.lite.common.SystemUtils;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.view.component.XYEditText;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class InputView extends RelativeLayout implements View.OnClickListener, TextView.OnEditorActionListener {
    private Context context;
    private Handler handler;
    private XYEditText inputText;
    private KeyboardListener keyboardListener;
    private Button sendBtn;

    /* loaded from: classes2.dex */
    public interface KeyboardListener {
        void onKeyBoardHide();

        void onKeyBoardShow();
    }

    /* loaded from: classes2.dex */
    public static class QueryParam {
        public String questionId = "";
        public String question = "";
        public int robotType = 0;
    }

    public InputView(Context context) {
        this(context, null, 0);
    }

    public InputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        buildSubview();
    }

    private void buildSubview() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.inputview_layout, (ViewGroup) this, true);
        InputViewCompat.setBackground(this);
        this.inputText = (XYEditText) inflate.findViewById(R.id.input_inputtext);
        this.inputText.setOnEditorActionListener(this);
        this.inputText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200)});
        ViewUtils.setBoldTypeface(this.context, this.inputText);
        this.sendBtn = (Button) inflate.findViewById(R.id.input_send);
        this.sendBtn.setOnClickListener(this);
        this.inputText.setKeyEventListener(new XYEditText.OnKeyEventListener() { // from class: com.tencent.grobot.lite.ui.view.InputView.1
            @Override // com.tencent.grobot.lite.ui.view.component.XYEditText.OnKeyEventListener
            public void onDeleteClick() {
                String obj = InputView.this.inputText.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    InputView.this.inputText.setText("");
                } else {
                    InputView.this.inputText.setText(obj.substring(0, obj.length() - 1));
                }
                InputView.this.inputText.setSelection(InputView.this.inputText.getText().length());
            }

            @Override // com.tencent.grobot.lite.ui.view.component.XYEditText.OnKeyEventListener
            public void onKeyboardHide() {
                if (InputView.this.keyboardListener != null) {
                    InputView.this.keyboardListener.onKeyBoardHide();
                }
            }
        });
    }

    public void setMainHandler(Handler handler) {
        this.handler = handler;
    }

    void sendMessage() {
        String trim = this.inputText.getText().toString().trim();
        this.inputText.setText("");
        if (checkDebug(trim)) {
            return;
        }
        if (this.handler != null) {
            QueryParam queryParam = new QueryParam();
            queryParam.questionId = "";
            queryParam.question = trim;
            queryParam.robotType = 0;
            Handler handler = this.handler;
            handler.sendMessage(handler.obtainMessage(1001, queryParam));
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
            jSONObject.put(ReportBridge.KEY_ITEM_ID, "7012");
            ReportBridge.report(jSONObject, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ReportBridge.KEY_EVENT_TYPE, "1002");
            jSONObject2.put(ReportBridge.KEY_ITEM_ID, "7013");
            ReportBridge.report(jSONObject2, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        SystemUtils.doGC();
    }

    void hideSoftKeyboard(View view) {
        ((InputMethodManager) this.context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void showSoftKeyboard() {
        this.inputText.requestFocus();
        ((InputMethodManager) this.context.getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.sendBtn) {
            sendMessage();
            hideSoftKeyboard(this.inputText);
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 4 && i != 6) {
            return false;
        }
        sendMessage();
        hideSoftKeyboard(this.inputText);
        return false;
    }

    public void setKeyboardListener(KeyboardListener keyboardListener) {
        this.keyboardListener = keyboardListener;
    }

    public void onDestory() {
        this.inputText.setOnEditorActionListener(null);
        this.inputText = null;
        this.sendBtn.setOnClickListener(null);
        this.sendBtn = null;
        setMainHandler(null);
    }

    private boolean checkDebug(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("vlink_debug_log:open")) {
                TLog.setDebugSwitch(true);
                return true;
            }
            if (str.equals("vlink_debug_log:close")) {
                TLog.setDebugSwitch(false);
                return true;
            }
            if (str.equals("vlink_debug_server:open")) {
                TLog.setServerDebug(true);
                return true;
            }
            if (str.equals("vlink_debug_server:close")) {
                TLog.setServerDebug(false);
                return true;
            }
            if (str.equals("vlink_debug_show:ver")) {
                Log.e("SDKINFO", Const.getSDKVersion());
                return true;
            }
        }
        return false;
    }
}
