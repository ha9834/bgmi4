package com.tencent.grobot.lite.ui;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.core.content.a;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.FileUtils;
import com.tencent.grobot.lite.common.LangUtils;
import com.tencent.grobot.lite.common.SystemUtils;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.common.thread.ThreadManager;
import com.tencent.grobot.lite.core.IServiceCallback;
import com.tencent.grobot.lite.image.ImageBridge;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.container.Frame;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class Pic extends Frame implements View.OnClickListener, IServiceCallback {
    private static final int REQUEST_PERMISSION = 1001;
    private static final String TAG = "Pic";
    private Bitmap image;
    private ImageView ivBrand;
    private String resourceId;
    private String url;
    private View vClose;

    public Pic(FrameActivity frameActivity, Bundle bundle) {
        super(frameActivity, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public View view() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.pic, (ViewGroup) null, false);
        this.ivBrand = (ImageView) inflate.findViewById(R.id.iv_brand);
        inflate.findViewById(R.id.btn_save).setOnClickListener(this);
        this.vClose = inflate.findViewById(R.id.iv_close);
        this.vClose.setOnClickListener(this);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public void onCreate() {
        this.url = this.args.getString("img_url");
        this.resourceId = this.args.getString("resource_id");
        TLog.d(TAG, "onCreate, url=" + this.url);
        if (TextUtils.isEmpty(this.url)) {
            this.context.finish();
        }
        ImageBridge.loadImage(this.context, this.url, -1, -1, 0, this.ivBrand, this);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
            jSONObject.put(ReportBridge.KEY_ITEM_ID, "7044");
            jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "2");
            jSONObject.put(ReportBridge.KEY_SUB_ID, this.resourceId);
            ReportBridge.report(jSONObject, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1001) {
            if (iArr.length > 0 && iArr[0] == 0) {
                saveToGallery();
                reportSaveImg();
            } else {
                Toast.makeText(this.context, R.string.pic_save_failed, 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public void onAttachedToWindow() {
        fixNotchScreen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public void onScreenOrientChange(int i) {
        fixNotchScreen();
    }

    @Override // com.tencent.grobot.lite.core.IServiceCallback
    public void onResult(int i, String str, Object... objArr) {
        TLog.d(TAG, "onResult, result=" + i);
        if (i == 1) {
            this.image = (Bitmap) objArr[0];
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_save) {
            if (this.image != null) {
                if (isPermissionGranted()) {
                    saveToGallery();
                    reportSaveImg();
                    return;
                } else {
                    Toast.makeText(this.context, R.string.pic_save_failed, 1).show();
                    return;
                }
            }
            return;
        }
        if (id == R.id.iv_close) {
            this.context.finish();
        }
    }

    private void reportSaveImg() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
            jSONObject.put(ReportBridge.KEY_ITEM_ID, "7044");
            jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "2");
            jSONObject.put(ReportBridge.KEY_SUB_ID, this.resourceId);
            ReportBridge.report(jSONObject, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT < 23 || a.b(this.context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.Pic.1
            @Override // java.lang.Runnable
            public void run() {
                Pic.this.context.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1001);
            }
        });
        return false;
    }

    private void saveToGallery() {
        if (TextUtils.isEmpty(this.url) || this.image == null) {
            return;
        }
        String[] split = this.url.split("/");
        if (FileUtils.saveBitmapToCamera(this.context, this.image, split[split.length - 2] + split[split.length - 1], Bitmap.CompressFormat.JPEG)) {
            Toast.makeText(this.context, R.string.pic_save_done, 1).show();
        } else {
            Toast.makeText(this.context, R.string.pic_save_failed, 1).show();
        }
    }

    private void fixNotchScreen() {
        int statusBarHeight;
        int statusBarHeight2;
        if (SystemUtils.hasNotch(this.context)) {
            int rotation = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getRotation();
            boolean z = LangUtils.getLayoutDirectionFromLocale(this.context.getResources().getConfiguration().locale) == 1;
            TLog.d(TAG, "fixNotchScreen, padding=" + SystemUtils.getStatusBarHeight(this.context) + ", rotation=" + rotation + ", rtl=" + z);
            if (rotation == 1) {
                if (Build.VERSION.SDK_INT >= 28) {
                    statusBarHeight2 = SystemUtils.getSafeInsetLeft(this.context);
                } else {
                    statusBarHeight2 = SystemUtils.getStatusBarHeight(this.context) + ViewUtils.dip2px(this.context, 20.0f);
                }
                TLog.d(NetworkManager.CMD_INFO, "safeInsetLeft: " + statusBarHeight2);
                if (z) {
                    fixCloseBtn(statusBarHeight2 + SystemUtils.getStatusBarHeight(this.context) + ViewUtils.dip2px(this.context, 10.0f), z);
                    return;
                } else {
                    fixCloseBtn(statusBarHeight2, z);
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 28) {
                statusBarHeight = SystemUtils.getSafeInsetRight(this.context);
            } else {
                statusBarHeight = SystemUtils.getStatusBarHeight(this.context) + ViewUtils.dip2px(this.context, 20.0f);
            }
            TLog.d(NetworkManager.CMD_INFO, "safeInsetRight: " + statusBarHeight);
            if (z) {
                fixCloseBtn(statusBarHeight, z);
            } else {
                fixCloseBtn(statusBarHeight + SystemUtils.getStatusBarHeight(this.context) + ViewUtils.dip2px(this.context, 10.0f), z);
            }
        }
    }

    private void fixCloseBtn(int i, boolean z) {
        ViewGroup.LayoutParams layoutParams = this.vClose.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (Build.VERSION.SDK_INT >= 17) {
                marginLayoutParams.setMarginEnd(i);
            } else if (z) {
                marginLayoutParams.leftMargin = i;
                marginLayoutParams.rightMargin = 0;
            } else {
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.rightMargin = i;
            }
            this.vClose.setLayoutParams(marginLayoutParams);
        }
    }
}
