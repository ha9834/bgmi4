package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ViewUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.plus.internal.zzm;

@Deprecated
/* loaded from: classes2.dex */
public final class PlusOneButton extends FrameLayout {

    @Deprecated
    public static final int ANNOTATION_BUBBLE = 1;

    @Deprecated
    public static final int ANNOTATION_INLINE = 2;

    @Deprecated
    public static final int ANNOTATION_NONE = 0;

    @Deprecated
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;

    @Deprecated
    public static final int SIZE_MEDIUM = 1;

    @Deprecated
    public static final int SIZE_SMALL = 0;

    @Deprecated
    public static final int SIZE_STANDARD = 3;

    @Deprecated
    public static final int SIZE_TALL = 2;

    /* renamed from: a, reason: collision with root package name */
    private View f5039a;
    private int b;
    private int c;
    private String d;
    private int e;
    private OnPlusOneClickListener f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    /* loaded from: classes2.dex */
    public class DefaultOnPlusOneClickListener implements View.OnClickListener, OnPlusOneClickListener {

        /* renamed from: a, reason: collision with root package name */
        private final OnPlusOneClickListener f5040a;

        @Deprecated
        public DefaultOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
            this.f5040a = onPlusOneClickListener;
        }

        @Override // android.view.View.OnClickListener
        @Deprecated
        public void onClick(View view) {
            Intent intent = (Intent) PlusOneButton.this.f5039a.getTag();
            OnPlusOneClickListener onPlusOneClickListener = this.f5040a;
            if (onPlusOneClickListener != null) {
                onPlusOneClickListener.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        @Override // com.google.android.gms.plus.PlusOneButton.OnPlusOneClickListener
        @Deprecated
        public void onPlusOneClick(Intent intent) {
            Context context = PlusOneButton.this.getContext();
            if (!(context instanceof Activity) || intent == null) {
                return;
            }
            ((Activity) context).startActivityForResult(intent, PlusOneButton.this.e);
        }
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface OnPlusOneClickListener {
        @Deprecated
        void onPlusOneClick(Intent intent);
    }

    @Deprecated
    public PlusOneButton(Context context) {
        this(context, null);
    }

    @Deprecated
    public PlusOneButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = a(context, attributeSet);
        this.c = b(context, attributeSet);
        this.e = -1;
        a(getContext());
        if (isInEditMode()) {
        }
    }

    @Deprecated
    protected static int a(Context context, AttributeSet attributeSet) {
        String xmlAttributeString = ViewUtils.getXmlAttributeString("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attributeSet, true, false, "PlusOneButton");
        if ("SMALL".equalsIgnoreCase(xmlAttributeString)) {
            return 0;
        }
        if ("MEDIUM".equalsIgnoreCase(xmlAttributeString)) {
            return 1;
        }
        return "TALL".equalsIgnoreCase(xmlAttributeString) ? 2 : 3;
    }

    private final void a(Context context) {
        View view = this.f5039a;
        if (view != null) {
            removeView(view);
        }
        this.f5039a = zzm.zza(context, this.b, this.c, this.d, this.e);
        setOnPlusOneClickListener(this.f);
        addView(this.f5039a);
    }

    @Deprecated
    protected static int b(Context context, AttributeSet attributeSet) {
        String xmlAttributeString = ViewUtils.getXmlAttributeString("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attributeSet, true, false, "PlusOneButton");
        if ("INLINE".equalsIgnoreCase(xmlAttributeString)) {
            return 2;
        }
        return "NONE".equalsIgnoreCase(xmlAttributeString) ? 0 : 1;
    }

    @Deprecated
    public final void initialize(String str, int i) {
        Preconditions.checkState(getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.d = str;
        this.e = i;
        a(getContext());
    }

    @Deprecated
    public final void initialize(String str, OnPlusOneClickListener onPlusOneClickListener) {
        this.d = str;
        this.e = 0;
        a(getContext());
        setOnPlusOneClickListener(onPlusOneClickListener);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f5039a.layout(0, 0, i3 - i, i4 - i2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        View view = this.f5039a;
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @VisibleForTesting
    @Deprecated
    public final void plusOneClick() {
        this.f5039a.performClick();
    }

    @Deprecated
    public final void setAnnotation(int i) {
        this.c = i;
        a(getContext());
    }

    @VisibleForTesting
    @Deprecated
    public final void setIntent(Intent intent) {
        this.f5039a.setTag(intent);
    }

    @Deprecated
    public final void setOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
        this.f = onPlusOneClickListener;
        this.f5039a.setOnClickListener(new DefaultOnPlusOneClickListener(onPlusOneClickListener));
    }

    @Deprecated
    public final void setSize(int i) {
        this.b = i;
        a(getContext());
    }
}
