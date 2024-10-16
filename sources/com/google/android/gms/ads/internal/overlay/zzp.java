package com.google.android.gms.ads.internal.overlay;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzyt;
import javax.annotation.Nullable;

@zzard
/* loaded from: classes.dex */
public final class zzp extends FrameLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final ImageButton f1157a;
    private final zzx b;

    public zzp(Context context, g gVar, @Nullable zzx zzxVar) {
        super(context);
        this.b = zzxVar;
        setOnClickListener(this);
        this.f1157a = new ImageButton(context);
        this.f1157a.setImageResource(R.drawable.btn_dialog);
        this.f1157a.setBackgroundColor(0);
        this.f1157a.setOnClickListener(this);
        ImageButton imageButton = this.f1157a;
        zzyt.zzpa();
        int zza = zzazt.zza(context, gVar.f1154a);
        zzyt.zzpa();
        int zza2 = zzazt.zza(context, 0);
        zzyt.zzpa();
        int zza3 = zzazt.zza(context, gVar.b);
        zzyt.zzpa();
        imageButton.setPadding(zza, zza2, zza3, zzazt.zza(context, gVar.d));
        this.f1157a.setContentDescription("Interstitial close button");
        ImageButton imageButton2 = this.f1157a;
        zzyt.zzpa();
        int zza4 = zzazt.zza(context, gVar.e + gVar.f1154a + gVar.b);
        zzyt.zzpa();
        addView(imageButton2, new FrameLayout.LayoutParams(zza4, zzazt.zza(context, gVar.e + gVar.d), 17));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzx zzxVar = this.b;
        if (zzxVar != null) {
            zzxVar.zztf();
        }
    }

    public final void zzaf(boolean z) {
        if (z) {
            this.f1157a.setVisibility(8);
        } else {
            this.f1157a.setVisibility(0);
        }
    }
}
