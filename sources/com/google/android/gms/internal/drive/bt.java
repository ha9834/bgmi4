package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.OnChangeListener;

/* loaded from: classes2.dex */
final /* synthetic */ class bt implements ChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final OnChangeListener f3911a;

    private bt(OnChangeListener onChangeListener) {
        this.f3911a = onChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ChangeListener a(OnChangeListener onChangeListener) {
        return new bt(onChangeListener);
    }

    @Override // com.google.android.gms.drive.events.ChangeListener
    public final void onChange(ChangeEvent changeEvent) {
        this.f3911a.onChange(changeEvent);
    }
}
