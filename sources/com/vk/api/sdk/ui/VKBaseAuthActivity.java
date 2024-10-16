package com.vk.api.sdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public abstract class VKBaseAuthActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6909a = new a(null);
    private boolean b;
    private boolean c;

    protected abstract boolean a(Intent intent);

    protected abstract boolean a(Uri uri);

    protected abstract Intent b(Uri uri);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        overridePendingTransition(0, 0);
        super.onCreate(bundle);
        this.c = bundle == null ? false : bundle.getBoolean("VK_waitingForAuthResult", false);
        a(getIntent(), false);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent, true);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.c || this.b) {
            return;
        }
        setResult(0);
        finish();
    }

    private final void a(Intent intent, boolean z) {
        Uri data = intent == null ? null : intent.getData();
        if (this.c || !a(intent) || data == null) {
            if (z) {
                setResult(-1, b(data));
                finish();
                this.c = false;
                return;
            }
            return;
        }
        if (a(data)) {
            this.c = true;
            this.b = true;
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.b = false;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        h.b(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("VK_waitingForAuthResult", this.c);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
        }
    }
}
