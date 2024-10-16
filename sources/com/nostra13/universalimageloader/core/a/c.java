package com.nostra13.universalimageloader.core.a;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f5727a;
    private final String b;
    private final String c;
    private final com.nostra13.universalimageloader.core.assist.c d;
    private final ImageScaleType e;
    private final ViewScaleType f;
    private final ImageDownloader g;
    private final Object h;
    private final boolean i;
    private final BitmapFactory.Options j = new BitmapFactory.Options();

    public c(String str, String str2, String str3, com.nostra13.universalimageloader.core.assist.c cVar, ViewScaleType viewScaleType, ImageDownloader imageDownloader, com.nostra13.universalimageloader.core.c cVar2) {
        this.f5727a = str;
        this.b = str2;
        this.c = str3;
        this.d = cVar;
        this.e = cVar2.j();
        this.f = viewScaleType;
        this.g = imageDownloader;
        this.h = cVar2.n();
        this.i = cVar2.m();
        a(cVar2.k(), this.j);
    }

    private void a(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inDensity = options.inDensity;
        options2.inDither = options.inDither;
        options2.inInputShareable = options.inInputShareable;
        options2.inJustDecodeBounds = options.inJustDecodeBounds;
        options2.inPreferredConfig = options.inPreferredConfig;
        options2.inPurgeable = options.inPurgeable;
        options2.inSampleSize = options.inSampleSize;
        options2.inScaled = options.inScaled;
        options2.inScreenDensity = options.inScreenDensity;
        options2.inTargetDensity = options.inTargetDensity;
        options2.inTempStorage = options.inTempStorage;
        if (Build.VERSION.SDK_INT >= 10) {
            b(options, options2);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            c(options, options2);
        }
    }

    @TargetApi(10)
    private void b(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    @TargetApi(11)
    private void c(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inBitmap = options.inBitmap;
        options2.inMutable = options.inMutable;
    }

    public String a() {
        return this.f5727a;
    }

    public String b() {
        return this.b;
    }

    public com.nostra13.universalimageloader.core.assist.c c() {
        return this.d;
    }

    public ImageScaleType d() {
        return this.e;
    }

    public ViewScaleType e() {
        return this.f;
    }

    public ImageDownloader f() {
        return this.g;
    }

    public Object g() {
        return this.h;
    }

    public boolean h() {
        return this.i;
    }

    public BitmapFactory.Options i() {
        return this.j;
    }
}
