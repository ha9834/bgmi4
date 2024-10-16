package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zzard
/* loaded from: classes2.dex */
public final class zzvb {
    private final int b;
    private final zzva d = new zzvf();

    /* renamed from: a, reason: collision with root package name */
    private final int f3758a = 6;
    private final int c = 0;

    public zzvb(int i) {
        this.b = i;
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            String str = arrayList2.get(i);
            i++;
            sb.append(str.toLowerCase(Locale.US));
            sb.append('\n');
        }
        return a(sb.toString());
    }

    @VisibleForTesting
    private final String a(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        apa apaVar = new apa();
        PriorityQueue priorityQueue = new PriorityQueue(this.b, new aoz(this));
        for (String str2 : split) {
            String[] zzg = zzve.zzg(str2, false);
            if (zzg.length != 0) {
                zzvh.zza(zzg, this.b, this.f3758a, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                apaVar.a(this.d.zzbl(((zzvi) it.next()).b));
            } catch (IOException e) {
                zzawz.zzc("Error while writing hash to byteStream", e);
            }
        }
        return apaVar.toString();
    }
}
