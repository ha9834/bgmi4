package com.google.android.gms.internal.games;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzek {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f4287a = {"requestId", "outcome"};
    private final int b;
    private final HashMap<String, Integer> c;

    private zzek(int i, HashMap<String, Integer> hashMap) {
        this.b = i;
        this.c = hashMap;
    }

    @VisibleForTesting
    public final int getRequestOutcome(String str) {
        boolean containsKey = this.c.containsKey(str);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46);
        sb.append("Request ");
        sb.append(str);
        sb.append(" was not part of the update operation!");
        Preconditions.checkArgument(containsKey, sb.toString());
        return this.c.get(str).intValue();
    }

    @VisibleForTesting
    public final Set<String> getRequestIds() {
        return this.c.keySet();
    }

    @VisibleForTesting
    public static zzek zzbb(DataHolder dataHolder) {
        zzem zzemVar = new zzem();
        zzemVar.zzo(dataHolder.getStatusCode());
        int count = dataHolder.getCount();
        for (int i = 0; i < count; i++) {
            int windowIndex = dataHolder.getWindowIndex(i);
            zzemVar.zzh(dataHolder.getString("requestId", i, windowIndex), dataHolder.getInteger("outcome", i, windowIndex));
        }
        return zzemVar.zzdh();
    }
}
