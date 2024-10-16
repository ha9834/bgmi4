package com.google.android.gms.internal.ads;

import android.graphics.Color;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.List;

@zzard
/* loaded from: classes2.dex */
public final class zzadt extends zzaeb {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2710a = Color.rgb(12, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4, TbsListener.ErrorCode.UNZIP_IO_ERROR);
    private static final int b;
    private static final int c;
    private static final int d;
    private final String e;
    private final List<zzadw> f = new ArrayList();
    private final List<zzaei> g = new ArrayList();
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final boolean m;

    public zzadt(String str, List<zzadw> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.e = str;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzadw zzadwVar = list.get(i3);
                this.f.add(zzadwVar);
                this.g.add(zzadwVar);
            }
        }
        this.h = num != null ? num.intValue() : c;
        this.i = num2 != null ? num2.intValue() : d;
        this.j = num3 != null ? num3.intValue() : 12;
        this.k = i;
        this.l = i2;
        this.m = z;
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final String getText() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final List<zzaei> zzra() {
        return this.g;
    }

    public final List<zzadw> zzrb() {
        return this.f;
    }

    public final int getBackgroundColor() {
        return this.h;
    }

    public final int getTextColor() {
        return this.i;
    }

    public final int getTextSize() {
        return this.j;
    }

    public final int zzrc() {
        return this.k;
    }

    public final int zzrd() {
        return this.l;
    }

    static {
        int rgb = Color.rgb(TbsListener.ErrorCode.APK_INVALID, TbsListener.ErrorCode.APK_INVALID, TbsListener.ErrorCode.APK_INVALID);
        b = rgb;
        c = rgb;
        d = f2710a;
    }
}
