package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

@zzard
@TargetApi(14)
/* loaded from: classes.dex */
public abstract class zzbco extends TextureView implements ip {

    /* renamed from: a, reason: collision with root package name */
    protected final zzbcy f2854a;
    protected final zzbdi b;

    public zzbco(Context context) {
        super(context);
        this.f2854a = new zzbcy();
        this.b = new zzbdi(context, this);
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void seekTo(int i);

    public abstract void setVideoPath(String str);

    public abstract void stop();

    public abstract void zza(float f, float f2);

    public abstract void zza(zzbcn zzbcnVar);

    public void zzcy(int i) {
    }

    public void zzcz(int i) {
    }

    public void zzda(int i) {
    }

    public void zzdb(int i) {
    }

    public void zzdc(int i) {
    }

    public abstract String zzxg();

    public abstract void zzxk();

    public void zzb(String str, String[] strArr) {
        setVideoPath(str);
    }
}
