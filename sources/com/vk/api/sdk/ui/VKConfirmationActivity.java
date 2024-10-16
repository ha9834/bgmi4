package com.vk.api.sdk.ui;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.google.android.gms.drive.DriveFile;
import com.vk.api.sdk.a;
import com.vk.api.sdk.q;
import com.vk.api.sdk.ui.VKConfirmationActivity;
import com.vk.api.sdk.utils.m;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class VKConfirmationActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6911a = new a(null);
    private static boolean b;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        VKConfirmationActivity vKConfirmationActivity = this;
        setContentView(new FrameLayout(vKConfirmationActivity));
        new AlertDialog.Builder(vKConfirmationActivity, 5).setTitle(a.c.vk_confirm).setMessage(getIntent().getStringExtra("key_message")).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.vk.api.sdk.ui.-$$Lambda$VKConfirmationActivity$HEQFNsefXmDq3lZ_oOD9MYVQnPo
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                VKConfirmationActivity.a(VKConfirmationActivity.this, dialogInterface, i);
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.vk.api.sdk.ui.-$$Lambda$VKConfirmationActivity$dfCLGTyL3gmMR0P_1Edy9fhw1Ug
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                VKConfirmationActivity.b(VKConfirmationActivity.this, dialogInterface, i);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.vk.api.sdk.ui.-$$Lambda$VKConfirmationActivity$YTTEC3LHACocgpt9zFnEuC4Vj8g
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                VKConfirmationActivity.a(VKConfirmationActivity.this, dialogInterface);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VKConfirmationActivity vKConfirmationActivity, DialogInterface dialogInterface, int i) {
        h.b(vKConfirmationActivity, "this$0");
        a aVar = f6911a;
        b = true;
        vKConfirmationActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VKConfirmationActivity vKConfirmationActivity, DialogInterface dialogInterface, int i) {
        h.b(vKConfirmationActivity, "this$0");
        a aVar = f6911a;
        b = false;
        vKConfirmationActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VKConfirmationActivity vKConfirmationActivity, DialogInterface dialogInterface) {
        h.b(vKConfirmationActivity, "this$0");
        a aVar = f6911a;
        b = false;
        vKConfirmationActivity.finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        m.f6932a.b();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        m.f6932a.b();
        overridePendingTransition(0, 0);
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
        }

        public final void a(boolean z) {
            VKConfirmationActivity.b = z;
        }

        public final boolean a() {
            return VKConfirmationActivity.b;
        }

        public final void a(final Context context, final String str) {
            h.b(context, "context");
            h.b(str, "message");
            q.a(new Runnable() { // from class: com.vk.api.sdk.ui.-$$Lambda$VKConfirmationActivity$a$4lyEXOS2ilwtl22rjzTQ1shdFuA
                @Override // java.lang.Runnable
                public final void run() {
                    VKConfirmationActivity.a.b(context, str);
                }
            }, 0L, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Context context, String str) {
            h.b(context, "$context");
            h.b(str, "$message");
            Intent putExtra = new Intent(context, (Class<?>) VKConfirmationActivity.class).addFlags(DriveFile.MODE_READ_ONLY).putExtra("key_message", str);
            h.a((Object) putExtra, "Intent(context, VKConfirmationActivity::class.java)\n                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)\n                    .putExtra(KEY_MESSAGE, message)");
            context.startActivity(putExtra);
        }
    }
}
