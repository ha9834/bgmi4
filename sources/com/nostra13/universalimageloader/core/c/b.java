package com.nostra13.universalimageloader.core.c;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class b extends c {
    public b(ImageView imageView) {
        super(imageView);
    }

    @Override // com.nostra13.universalimageloader.core.c.c, com.nostra13.universalimageloader.core.c.a
    public int a() {
        ImageView imageView;
        int a2 = super.a();
        return (a2 > 0 || (imageView = (ImageView) this.f5743a.get()) == null) ? a2 : a(imageView, "mMaxWidth");
    }

    @Override // com.nostra13.universalimageloader.core.c.c, com.nostra13.universalimageloader.core.c.a
    public int b() {
        ImageView imageView;
        int b = super.b();
        return (b > 0 || (imageView = (ImageView) this.f5743a.get()) == null) ? b : a(imageView, "mMaxHeight");
    }

    @Override // com.nostra13.universalimageloader.core.c.c, com.nostra13.universalimageloader.core.c.a
    public ViewScaleType c() {
        ImageView imageView = (ImageView) this.f5743a.get();
        if (imageView != null) {
            return ViewScaleType.a(imageView);
        }
        return super.c();
    }

    @Override // com.nostra13.universalimageloader.core.c.c, com.nostra13.universalimageloader.core.c.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public ImageView d() {
        return (ImageView) super.d();
    }

    @Override // com.nostra13.universalimageloader.core.c.c
    protected void a(Drawable drawable, View view) {
        ((ImageView) view).setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    @Override // com.nostra13.universalimageloader.core.c.c
    protected void a(Bitmap bitmap, View view) {
        ((ImageView) view).setImageBitmap(bitmap);
    }

    private static int a(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(obj)).intValue();
            if (intValue <= 0 || intValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return intValue;
        } catch (Exception e) {
            com.nostra13.universalimageloader.b.c.a(e);
            return 0;
        }
    }
}
