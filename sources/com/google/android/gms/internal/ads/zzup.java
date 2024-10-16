package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.nearby.messages.BleSignal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzup {

    @VisibleForTesting
    private int b;

    /* renamed from: a, reason: collision with root package name */
    private final Object f3752a = new Object();
    private List<zzuo> c = new LinkedList();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzuo zzo(boolean z) {
        synchronized (this.f3752a) {
            zzuo zzuoVar = null;
            if (this.c.size() == 0) {
                zzawz.zzdp("Queue empty");
                return null;
            }
            int i = 0;
            if (this.c.size() >= 2) {
                int i2 = BleSignal.UNKNOWN_TX_POWER;
                int i3 = 0;
                for (zzuo zzuoVar2 : this.c) {
                    int score = zzuoVar2.getScore();
                    if (score > i2) {
                        i = i3;
                        zzuoVar = zzuoVar2;
                        i2 = score;
                    }
                    i3++;
                }
                this.c.remove(i);
                return zzuoVar;
            }
            zzuo zzuoVar3 = this.c.get(0);
            if (z) {
                this.c.remove(0);
            } else {
                zzuoVar3.zzmp();
            }
            return zzuoVar3;
        }
    }

    public final boolean zza(zzuo zzuoVar) {
        synchronized (this.f3752a) {
            return this.c.contains(zzuoVar);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzb(zzuo zzuoVar) {
        synchronized (this.f3752a) {
            Iterator<zzuo> it = this.c.iterator();
            while (it.hasNext()) {
                zzuo next = it.next();
                if (!zzk.zzlk().zzvc().zzvl()) {
                    if (zzuoVar != next && next.zzmm().equals(zzuoVar.zzmm())) {
                        it.remove();
                        return true;
                    }
                } else if (!zzk.zzlk().zzvc().zzvn() && zzuoVar != next && next.zzmo().equals(zzuoVar.zzmo())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void zzc(zzuo zzuoVar) {
        synchronized (this.f3752a) {
            if (this.c.size() >= 10) {
                int size = this.c.size();
                StringBuilder sb = new StringBuilder(41);
                sb.append("Queue is full, current size = ");
                sb.append(size);
                zzawz.zzdp(sb.toString());
                this.c.remove(0);
            }
            int i = this.b;
            this.b = i + 1;
            zzuoVar.zzbw(i);
            zzuoVar.zzms();
            this.c.add(zzuoVar);
        }
    }
}
