package com.discord.connect.jni;

import com.discord.connect.schema.Activity;
import lombok.NonNull;

/* loaded from: classes.dex */
public final class ActivitiesManager {

    /* renamed from: a, reason: collision with root package name */
    private long f1071a;

    private native void clear(long j);

    private native Activity get(long j);

    private native void update(long j, String str);

    public ActivitiesManager(@NonNull Core core) {
        if (core == null) {
            throw new NullPointerException("core is marked non-null but is null");
        }
        this.f1071a = core.f1072a;
    }

    public void a() {
        clear(this.f1071a);
    }

    public Activity b() {
        return get(this.f1071a);
    }

    public void a(String str) {
        update(this.f1071a, str);
    }
}
