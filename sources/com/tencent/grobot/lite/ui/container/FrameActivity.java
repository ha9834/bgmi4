package com.tencent.grobot.lite.ui.container;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.GRobotEnterManager;
import com.tencent.grobot.lite.GameParameters;
import com.tencent.grobot.lite.common.Const;
import com.tencent.grobot.lite.common.LangUtils;
import com.tencent.grobot.lite.common.SystemUtils;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.detail.DetailDialog;
import com.tencent.grobot.lite.ui.dialog.BadChoiceDialog;
import com.tencent.grobot.lite.ui.dialog.FormDialog;
import com.tencent.grobot.lite.ui.dialog.ReconnectDialog;
import com.tencent.grobot.lite.ui.dialog.TextDialog;
import com.tencent.grobot.lite.ui.dialog.TicketDialog;
import com.tencent.grobot.lite.ui.dialog.TipDialog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class FrameActivity extends AppCompatActivity implements View.OnSystemUiVisibilityChangeListener {
    private static final int STATE_PAUSE = 0;
    private static final int STATE_RESUME = 1;
    private static final String TAG = "FrameActivity";
    GRobotApplication app;
    private int orient;
    private RotationBroadcastReceiver rotationBroadcastReceiver;
    private TerminalBroadcastReceiver terminalBroadcastReceiver;
    private Frame delegate = null;
    private Map<String, FrameDialog> dialogs = new HashMap(3);
    private int state = 0;
    private boolean isFormDialogShow = false;

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SourceLockedOrientationActivity"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent.getBooleanExtra("frame_screen_orient", false)) {
            setRequestedOrientation(1);
        }
        hideStatusBarAndNavigation();
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(this);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        }
        if (intent.getBooleanExtra("frame_other_process", false)) {
            GameParameters gameParameters = (GameParameters) intent.getParcelableExtra("frame_game_params");
            String stringExtra = intent.getStringExtra("frame_game_params_str");
            this.app.initFromOtherProcess(this, gameParameters, stringExtra);
            TLog.d(TAG, "init， params=" + gameParameters + "paramstring=" + stringExtra);
        }
        this.delegate = Router.parseIntToFrame(this, intent.getIntExtra("frame_type", -1), intent.getBundleExtra("frame_args"));
        if (this.delegate == null) {
            TLog.e(TAG, "onCreate, args illegal.");
        }
        Frame frame = this.delegate;
        frame.rootView = frame.view();
        setContentView(this.delegate.rootView);
        this.delegate.onCreate();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Const.BROADCAST_ACTION_CLOSE);
        this.terminalBroadcastReceiver = new TerminalBroadcastReceiver(this);
        registerReceiver(this.terminalBroadcastReceiver, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(Const.BROADCAST_ACTION_CONFIGURATION_CHANGE);
        this.rotationBroadcastReceiver = new RotationBroadcastReceiver(this);
        registerReceiver(this.rotationBroadcastReceiver, intentFilter2);
        this.orient = ((WindowManager) getSystemService("window")).getDefaultDisplay().getRotation();
        TLog.d(TAG, "onCreate, delegate=" + this.delegate + ", act=" + toString());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        TLog.d(TAG, "onPostCreate");
        SystemUtils.doGC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.state = 1;
        this.delegate.onResume();
        TLog.d(TAG, "onResume");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        changeLanguageLocal(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        SystemUtils.doGC();
        TLog.d(TAG, "onPostResume");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.delegate.onAttachedToWindow();
        TLog.d(TAG, "onAttachedToWindow");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.state = 0;
        this.delegate.onPause();
        TLog.d(TAG, "onPause");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.delegate.onStop();
        TLog.d(TAG, "onStop");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        TLog.d(TAG, "onDestroy, delegate=" + this.delegate);
        unregisterReceiver(this.terminalBroadcastReceiver);
        unregisterReceiver(this.rotationBroadcastReceiver);
        Iterator<Map.Entry<String, FrameDialog>> it = this.dialogs.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onDestroy();
        }
        this.dialogs.clear();
        this.delegate.onDestroy();
        SystemUtils.doGC();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.delegate.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.delegate.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.delegate.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(changeLanguageLocal(context));
        this.app = GRobotApplication.getInstance();
    }

    private Context changeLanguageLocal(Context context) {
        Locale locale;
        if (TextUtils.isEmpty(GRobotEnterManager.lang)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Const.PREFERENCE_NAME, 0);
            String string = sharedPreferences.getString(Const.GAME_LOCALE_KEY, "");
            if (TextUtils.isEmpty(string)) {
                if (TLog.isColor()) {
                    TLog.d(TAG, "attachBaseContext, locale=" + context.getResources().getConfiguration().locale);
                }
                return context;
            }
            return LangUtils.getAttachBaseContext(context, new Locale(string, sharedPreferences.getString(Const.GAME_AREA_KEY, "")));
        }
        if (TextUtils.isEmpty(GRobotEnterManager.area)) {
            locale = new Locale(GRobotEnterManager.lang, "");
        } else {
            locale = new Locale(GRobotEnterManager.lang, GRobotEnterManager.area);
        }
        return LangUtils.getAttachBaseContext(context, locale);
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public void onSystemUiVisibilityChange(int i) {
        TLog.d(TAG, "onSystemUiVisibilityChange, v=" + i);
        if (this.isFormDialogShow) {
            return;
        }
        hideStatusBarAndNavigation();
    }

    public Frame getFrame() {
        return this.delegate;
    }

    public boolean hasDialog(Class<? extends FrameDialog> cls) {
        return this.dialogs.containsKey(cls.getName());
    }

    public <T extends FrameDialog> T getDialog(Class<? extends FrameDialog> cls) {
        if (FormDialog.class.equals(cls)) {
            T t = (T) this.dialogs.get(FormDialog.class.getName());
            if (t != null) {
                return t;
            }
            FormDialog formDialog = new FormDialog(this);
            this.dialogs.put(FormDialog.class.getName(), formDialog);
            return formDialog;
        }
        if (TextDialog.class.equals(cls)) {
            T t2 = (T) this.dialogs.get(TextDialog.class.getName());
            if (t2 != null) {
                return t2;
            }
            TextDialog textDialog = new TextDialog(this);
            this.dialogs.put(TextDialog.class.getName(), textDialog);
            return textDialog;
        }
        if (TicketDialog.class.equals(cls)) {
            T t3 = (T) this.dialogs.get(TicketDialog.class.getName());
            if (t3 != null) {
                return t3;
            }
            TicketDialog ticketDialog = new TicketDialog(this);
            this.dialogs.put(TicketDialog.class.getName(), ticketDialog);
            return ticketDialog;
        }
        if (TipDialog.class.equals(cls)) {
            T t4 = (T) this.dialogs.get(TipDialog.class.getName());
            if (t4 != null) {
                return t4;
            }
            TipDialog tipDialog = new TipDialog(this);
            this.dialogs.put(TipDialog.class.getName(), tipDialog);
            return tipDialog;
        }
        if (DetailDialog.class.equals(cls)) {
            T t5 = (T) this.dialogs.get(DetailDialog.class.getName());
            if (t5 != null) {
                return t5;
            }
            DetailDialog detailDialog = new DetailDialog(this);
            this.dialogs.put(DetailDialog.class.getName(), detailDialog);
            return detailDialog;
        }
        if (BadChoiceDialog.class.equals(cls)) {
            BadChoiceDialog badChoiceDialog = new BadChoiceDialog(this);
            this.dialogs.put(BadChoiceDialog.class.getName(), badChoiceDialog);
            return badChoiceDialog;
        }
        if (ReconnectDialog.class.equals(cls)) {
            T t6 = (T) this.dialogs.get(ReconnectDialog.class.getName());
            if (t6 != null) {
                return t6;
            }
            ReconnectDialog reconnectDialog = new ReconnectDialog(this);
            this.dialogs.put(ReconnectDialog.class.getName(), reconnectDialog);
            return reconnectDialog;
        }
        throw new IllegalArgumentException("The clazz=" + cls + " is illegal.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openDialog(FrameDialog frameDialog) {
        if (this.dialogs.containsValue(frameDialog)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            ((ViewGroup) getWindow().getDecorView()).addView(frameDialog, layoutParams);
            if (FormDialog.class.equals(frameDialog.getClass())) {
                this.isFormDialogShow = true;
                showNavigation();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The dialog is not in the activity");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openDialog(FrameDialog frameDialog, boolean z, int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.dialogs.containsValue(frameDialog)) {
            if (z) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            layoutParams.leftMargin = i;
            layoutParams.topMargin = i2;
            layoutParams.gravity = 51;
            ((ViewGroup) getWindow().getDecorView()).addView(frameDialog, layoutParams);
            if (FormDialog.class.equals(frameDialog.getClass())) {
                this.isFormDialogShow = true;
                showNavigation();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The dialog is not in the activity");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void closeDialog(FrameDialog frameDialog) {
        if (this.dialogs.containsValue(frameDialog)) {
            ((ViewGroup) getWindow().getDecorView()).removeView(frameDialog);
            if (FormDialog.class.equals(frameDialog.getClass())) {
                this.isFormDialogShow = false;
                hideStatusBarAndNavigation();
            }
            if (frameDialog instanceof BadChoiceDialog) {
                this.dialogs.remove(frameDialog);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The dialog is not in the activity");
    }

    private void hideStatusBarAndNavigation() {
        TLog.d(TAG, "hideStatusBarAndNavigation.");
        if (Build.VERSION.SDK_INT < 19) {
            getWindow().getDecorView().setSystemUiVisibility(8);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(5378);
        }
    }

    private void showNavigation() {
        TLog.d(TAG, "showNavigation.");
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(4352);
        }
    }

    /* loaded from: classes2.dex */
    private static final class RotationBroadcastReceiver extends BroadcastReceiver {
        final WeakReference<FrameActivity> actPtr;

        public RotationBroadcastReceiver(FrameActivity frameActivity) {
            this.actPtr = new WeakReference<>(frameActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int rotation;
            FrameActivity frameActivity = this.actPtr.get();
            if (frameActivity == null || !Const.BROADCAST_ACTION_CONFIGURATION_CHANGE.equals(intent.getAction()) || frameActivity.state != 1 || (rotation = ((WindowManager) frameActivity.getSystemService("window")).getDefaultDisplay().getRotation()) == frameActivity.orient) {
                return;
            }
            frameActivity.orient = rotation;
            frameActivity.delegate.onScreenOrientChange(frameActivity.orient);
        }
    }

    /* loaded from: classes2.dex */
    private static final class TerminalBroadcastReceiver extends BroadcastReceiver {
        final WeakReference<FrameActivity> actPtr;

        public TerminalBroadcastReceiver(FrameActivity frameActivity) {
            this.actPtr = new WeakReference<>(frameActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            FrameActivity frameActivity = this.actPtr.get();
            if (frameActivity == null || !Const.BROADCAST_ACTION_CLOSE.equals(intent.getAction())) {
                return;
            }
            TLog.d(FrameActivity.TAG, "receive terminal broadcast.");
            frameActivity.finish();
        }
    }
}
