package com.gamesafe.ano;

import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextView f1096a;
    final /* synthetic */ d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, TextView textView) {
        this.b = dVar;
        this.f1096a = textView;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        String str;
        TextView textView = this.f1096a;
        Locale locale = Locale.ENGLISH;
        str = this.b.e;
        textView.setText(String.format(locale, "%s%d", str, Integer.valueOf(i)));
        this.b.h = i;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        int i;
        Locale locale = Locale.ENGLISH;
        String a2 = a.a("VyyVijOjpxcZqzio:xvko_kmjx=%y");
        i = this.b.h;
        AnoSdk.ioctl(String.format(locale, a2, Integer.valueOf(i)));
        seekBar.setProgress(0);
    }
}
