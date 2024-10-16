package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzadu extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private static final float[] f2711a = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private AnimationDrawable b;

    public zzadu(Context context, zzadt zzadtVar, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        Preconditions.checkNotNull(zzadtVar);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(f2711a, null, null));
        shapeDrawable.getPaint().setColor(zzadtVar.getBackgroundColor());
        setLayoutParams(layoutParams);
        zzk.zzli().setBackground(this, shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzadtVar.getText())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzadtVar.getText());
            textView.setTextColor(zzadtVar.getTextColor());
            textView.setTextSize(zzadtVar.getTextSize());
            zzyt.zzpa();
            int zza = zzazt.zza(context, 4);
            zzyt.zzpa();
            textView.setPadding(zza, 0, zzazt.zza(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<zzadw> zzrb = zzadtVar.zzrb();
        if (zzrb != null && zzrb.size() > 1) {
            this.b = new AnimationDrawable();
            Iterator<zzadw> it = zzrb.iterator();
            while (it.hasNext()) {
                try {
                    this.b.addFrame((Drawable) ObjectWrapper.unwrap(it.next().zzrf()), zzadtVar.zzrc());
                } catch (Exception e) {
                    zzawz.zzc("Error while getting drawable.", e);
                }
            }
            zzk.zzli().setBackground(imageView, this.b);
        } else if (zzrb.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) ObjectWrapper.unwrap(zzrb.get(0).zzrf()));
            } catch (Exception e2) {
                zzawz.zzc("Error while getting drawable.", e2);
            }
        }
        addView(imageView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        AnimationDrawable animationDrawable = this.b;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        super.onAttachedToWindow();
    }
}
