package androidx.core.f.a;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    private final int f520a;
    private final d b;
    private final int c;

    public a(int i, d dVar, int i2) {
        this.f520a = i;
        this.b = dVar;
        this.c = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f520a);
        this.b.a(this.c, bundle);
    }
}
