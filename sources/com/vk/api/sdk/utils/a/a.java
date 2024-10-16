package com.vk.api.sdk.utils.a;

import android.os.SystemClock;
import java.util.ArrayDeque;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6916a = new a();
    private static final ArrayDeque<Long> b = new ArrayDeque<>();

    private a() {
    }

    @Override // com.vk.api.sdk.utils.a.b
    public synchronized void a(int i, long j) {
        a(i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        b.addLast(Long.valueOf(elapsedRealtime));
        Long removeFirst = b.removeFirst();
        h.a((Object) removeFirst, "firstTimestamp");
        long longValue = j - (elapsedRealtime - removeFirst.longValue());
        if (longValue > 0) {
            Thread.sleep(longValue);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final synchronized void a(int i) {
        if (i == b.size()) {
            return;
        }
        int i2 = 0;
        if (i > b.size()) {
            int size = i - b.size();
            while (i2 < size) {
                b.addFirst(0L);
                i2++;
            }
        } else {
            int size2 = b.size() - i;
            while (i2 < size2) {
                b.removeFirst();
                i2++;
            }
        }
    }
}
