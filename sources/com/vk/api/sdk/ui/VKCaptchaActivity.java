package com.vk.api.sdk.ui;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.google.android.gms.drive.DriveFile;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.open.SocialConstants;
import com.tencent.smtt.sdk.TbsListener;
import com.vk.api.sdk.a;
import com.vk.api.sdk.q;
import com.vk.api.sdk.ui.VKCaptchaActivity;
import com.vk.api.sdk.utils.j;
import com.vk.api.sdk.utils.l;
import com.vk.api.sdk.utils.m;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class VKCaptchaActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6910a = new a(null);
    private static String e;
    private EditText b;
    private ImageView c;
    private ProgressBar d;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        VKCaptchaActivity vKCaptchaActivity = this;
        setContentView(new FrameLayout(vKCaptchaActivity));
        LinearLayout linearLayout = new LinearLayout(vKCaptchaActivity);
        int a2 = l.f6927a.a(12);
        int max = (int) (Math.max(1.0f, l.f6927a.a()) * 130.0f);
        int max2 = (int) (Math.max(1.0f, l.f6927a.a()) * 50.0f);
        linearLayout.setPadding(a2, a2, a2, a2);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        FrameLayout frameLayout = new FrameLayout(vKCaptchaActivity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(max, max2);
        layoutParams.bottomMargin = a2;
        frameLayout.setLayoutParams(layoutParams);
        this.d = new ProgressBar(vKCaptchaActivity);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        ProgressBar progressBar = this.d;
        if (progressBar == null) {
            h.b("progress");
            throw null;
        }
        progressBar.setLayoutParams(layoutParams2);
        ProgressBar progressBar2 = this.d;
        if (progressBar2 == null) {
            h.b("progress");
            throw null;
        }
        frameLayout.addView(progressBar2);
        this.c = new ImageView(vKCaptchaActivity);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        ImageView imageView = this.c;
        if (imageView == null) {
            h.b("image");
            throw null;
        }
        imageView.setLayoutParams(layoutParams3);
        ImageView imageView2 = this.c;
        if (imageView2 == null) {
            h.b("image");
            throw null;
        }
        frameLayout.addView(imageView2);
        linearLayout.addView(frameLayout);
        this.b = new EditText(vKCaptchaActivity);
        EditText editText = this.b;
        if (editText == null) {
            h.b(EvaluateItemInfo.ACTIONTYPE_INPUT);
            throw null;
        }
        editText.setInputType(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
        EditText editText2 = this.b;
        if (editText2 == null) {
            h.b(EvaluateItemInfo.ACTIONTYPE_INPUT);
            throw null;
        }
        editText2.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(max, -2);
        EditText editText3 = this.b;
        if (editText3 == null) {
            h.b(EvaluateItemInfo.ACTIONTYPE_INPUT);
            throw null;
        }
        editText3.setLayoutParams(layoutParams4);
        EditText editText4 = this.b;
        if (editText4 == null) {
            h.b(EvaluateItemInfo.ACTIONTYPE_INPUT);
            throw null;
        }
        linearLayout.addView(editText4);
        new AlertDialog.Builder(vKCaptchaActivity, 5).setView(linearLayout).setTitle(a.c.vk_captcha_hint).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.vk.api.sdk.ui.-$$Lambda$VKCaptchaActivity$jsgnszbHyTJH90cnmCadgcgclpc
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                VKCaptchaActivity.a(VKCaptchaActivity.this, dialogInterface, i);
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.vk.api.sdk.ui.-$$Lambda$VKCaptchaActivity$PcvAH2j7BvpOhZfG3Han-d28j68
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                VKCaptchaActivity.b(VKCaptchaActivity.this, dialogInterface, i);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.vk.api.sdk.ui.-$$Lambda$VKCaptchaActivity$Sg51ZT8NJNtrmW2X1aouQrcmllM
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                VKCaptchaActivity.a(VKCaptchaActivity.this, dialogInterface);
            }
        }).show();
        EditText editText5 = this.b;
        if (editText5 == null) {
            h.b(EvaluateItemInfo.ACTIONTYPE_INPUT);
            throw null;
        }
        editText5.requestFocus();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VKCaptchaActivity vKCaptchaActivity, DialogInterface dialogInterface, int i) {
        h.b(vKCaptchaActivity, "this$0");
        vKCaptchaActivity.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VKCaptchaActivity vKCaptchaActivity, DialogInterface dialogInterface, int i) {
        h.b(vKCaptchaActivity, "this$0");
        vKCaptchaActivity.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VKCaptchaActivity vKCaptchaActivity, DialogInterface dialogInterface) {
        h.b(vKCaptchaActivity, "this$0");
        vKCaptchaActivity.d();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    private final void b() {
        final String stringExtra = getIntent().getStringExtra("key_url");
        q.f6908a.a().submit(new Runnable() { // from class: com.vk.api.sdk.ui.-$$Lambda$VKCaptchaActivity$KI5zOdeCMkV1b2ul_nYDYlWLXaI
            @Override // java.lang.Runnable
            public final void run() {
                VKCaptchaActivity.a(stringExtra, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(String str, VKCaptchaActivity vKCaptchaActivity) {
        h.b(vKCaptchaActivity, "this$0");
        j jVar = j.f6925a;
        h.a((Object) str, "url");
        byte[] a2 = jVar.a(str);
        if (a2 == null) {
            return;
        }
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(a2, 0, a2.length);
        h.a((Object) decodeByteArray, "decodeByteArray(data, 0, data.size)");
        vKCaptchaActivity.a(decodeByteArray);
    }

    private final void a(final Bitmap bitmap) {
        q.a(new Runnable() { // from class: com.vk.api.sdk.ui.-$$Lambda$VKCaptchaActivity$8rFMbzYKM0vmeRzwCK_RevKOweY
            @Override // java.lang.Runnable
            public final void run() {
                VKCaptchaActivity.a(VKCaptchaActivity.this, bitmap);
            }
        }, 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VKCaptchaActivity vKCaptchaActivity, Bitmap bitmap) {
        h.b(vKCaptchaActivity, "this$0");
        h.b(bitmap, "$bitmap");
        ImageView imageView = vKCaptchaActivity.c;
        if (imageView == null) {
            h.b("image");
            throw null;
        }
        imageView.setImageBitmap(bitmap);
        ProgressBar progressBar = vKCaptchaActivity.d;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        } else {
            h.b("progress");
            throw null;
        }
    }

    private final void c() {
        a aVar = f6910a;
        EditText editText = this.b;
        if (editText == null) {
            h.b(EvaluateItemInfo.ACTIONTYPE_INPUT);
            throw null;
        }
        e = editText.getText().toString();
        m.f6932a.b();
        finish();
    }

    private final void d() {
        a aVar = f6910a;
        e = null;
        m.f6932a.b();
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        m.f6932a.b();
        super.onDestroy();
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
        }

        public final String a() {
            return VKCaptchaActivity.e;
        }

        public final void a(final Context context, final String str) {
            h.b(context, "context");
            h.b(str, SocialConstants.PARAM_IMG_URL);
            q.a(new Runnable() { // from class: com.vk.api.sdk.ui.-$$Lambda$VKCaptchaActivity$a$-h0LmNLissfNfSMQU5Yu2Xfxwj4
                @Override // java.lang.Runnable
                public final void run() {
                    VKCaptchaActivity.a.b(context, str);
                }
            }, 0L, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Context context, String str) {
            h.b(context, "$context");
            h.b(str, "$img");
            Intent putExtra = new Intent(context, (Class<?>) VKCaptchaActivity.class).addFlags(DriveFile.MODE_READ_ONLY).putExtra("key_url", str);
            h.a((Object) putExtra, "Intent(context, VKCaptchaActivity::class.java)\n                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)\n                    .putExtra(KEY_URL, img)");
            context.startActivity(putExtra);
        }
    }
}
