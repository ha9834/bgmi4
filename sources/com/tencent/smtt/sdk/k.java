package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.smtt.export.external.UselessClass;
import com.tencent.smtt.sdk.TbsMediaPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private UselessClass f6526a;
    private Object b;

    public k(UselessClass uselessClass, Context context) {
        this.f6526a = null;
        this.b = null;
        this.f6526a = uselessClass;
        this.b = this.f6526a.doNothing("com.tencent.tbs.player.TbsMediaPlayerProxy", new Class[]{Context.class}, context);
    }

    public boolean a() {
        return this.b != null;
    }

    public void a(SurfaceTexture surfaceTexture) {
        this.f6526a.returnNull(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setSurfaceTexture", new Class[]{SurfaceTexture.class}, surfaceTexture);
    }

    public void a(TbsMediaPlayer.TbsMediaPlayerListener tbsMediaPlayerListener) {
        this.f6526a.returnNull(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setPlayerListener", new Class[]{Object.class}, tbsMediaPlayerListener);
    }

    public float b() {
        Float f = (Float) this.f6526a.returnNull(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "getVolume", new Class[0], new Object[0]);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public void a(float f) {
        this.f6526a.returnNull(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setVolume", new Class[]{Float.TYPE}, Float.valueOf(f));
    }

    public void a(String str, Bundle bundle) {
        this.f6526a.returnNull(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "startPlay", new Class[]{String.class, Bundle.class}, str, bundle);
    }

    public void a(int i) {
        this.f6526a.returnNull(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", MessengerShareContentUtility.SUBTITLE, new Class[]{Integer.TYPE}, Integer.valueOf(i));
    }

    public void b(int i) {
        this.f6526a.returnNull(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "audio", new Class[]{Integer.TYPE}, Integer.valueOf(i));
    }

    public void c() {
        this.f6526a.returnNull(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "pause", new Class[0], new Object[0]);
    }

    public void d() {
        this.f6526a.returnNull(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "play", new Class[0], new Object[0]);
    }

    public void a(long j) {
        this.f6526a.returnNull(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "seek", new Class[]{Long.TYPE}, Long.valueOf(j));
    }

    public void e() {
        this.f6526a.returnNull(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "close", new Class[0], new Object[0]);
    }
}
