package com.google.firebase.events;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes2.dex */
public interface Publisher {
    @KeepForSdk
    void publish(Event<?> event);
}
