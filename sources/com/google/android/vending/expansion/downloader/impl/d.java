package com.google.android.vending.expansion.downloader.impl;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.h;
import com.pubg.imobile.R;

/* loaded from: classes2.dex */
public class d extends h.e {
    int S;
    int T;
    int U;
    CharSequence V;

    public d(Context context) {
        super(context);
        this.S = -1;
        this.T = -1;
        this.V = "";
    }

    @Override // androidx.core.app.h.e
    public h.e a(int i, int i2, boolean z) {
        this.S = i;
        this.T = i2;
        return super.a(i, i2, z);
    }

    @Override // androidx.core.app.h.e
    public h.e c(CharSequence charSequence) {
        this.V = charSequence;
        return super.c(charSequence);
    }

    @Override // androidx.core.app.h.e
    public Notification b() {
        if (Build.VERSION.SDK_INT > 10) {
            b(true);
        }
        RemoteViews remoteViews = new RemoteViews(this.f473a.getPackageName(), R.layout.status_bar_ongoing_event_progress_bar);
        remoteViews.setViewVisibility(R.id.description, 0);
        remoteViews.setTextViewText(R.id.description, com.google.android.vending.expansion.downloader.d.a(this.T, this.S));
        remoteViews.setViewVisibility(R.id.progress_bar_frame, 0);
        int i = this.S;
        remoteViews.setProgressBar(R.id.progress_bar, i >> 8, this.T >> 8, i <= 0);
        remoteViews.setViewVisibility(R.id.time_remaining, 0);
        remoteViews.setTextViewText(R.id.time_remaining, this.V);
        remoteViews.setTextViewText(R.id.progress_text, com.google.android.vending.expansion.downloader.d.b(this.T, this.S));
        remoteViews.setImageViewResource(R.id.appIcon, this.U);
        Notification b = super.b();
        b.contentView = remoteViews;
        return b;
    }
}
