package com.google.android.gms.internal.firebase_remote_config;

import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class br implements dj {

    /* renamed from: a, reason: collision with root package name */
    private final zzgj f4047a;
    private int b;
    private int c;
    private int d = 0;

    public static br a(zzgj zzgjVar) {
        if (zzgjVar.d != null) {
            return zzgjVar.d;
        }
        return new br(zzgjVar);
    }

    private br(zzgj zzgjVar) {
        this.f4047a = (zzgj) zzhi.a(zzgjVar, EvaluateItemInfo.ACTIONTYPE_INPUT);
        this.f4047a.d = this;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final int a() throws IOException {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.f4047a.zzfb();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final boolean c() throws IOException {
        int i;
        if (this.f4047a.zzfr() || (i = this.b) == this.c) {
            return false;
        }
        return this.f4047a.zzz(i);
    }

    private final void a(int i) throws IOException {
        if ((this.b & 7) != i) {
            throw zzhm.f();
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final double d() throws IOException {
        a(1);
        return this.f4047a.readDouble();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final float e() throws IOException {
        a(5);
        return this.f4047a.readFloat();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final long f() throws IOException {
        a(0);
        return this.f4047a.zzfc();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final long g() throws IOException {
        a(0);
        return this.f4047a.zzfd();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final int h() throws IOException {
        a(0);
        return this.f4047a.zzfe();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final long i() throws IOException {
        a(1);
        return this.f4047a.zzff();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final int j() throws IOException {
        a(5);
        return this.f4047a.zzfg();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final boolean k() throws IOException {
        a(0);
        return this.f4047a.zzfh();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final String l() throws IOException {
        a(2);
        return this.f4047a.readString();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final String m() throws IOException {
        a(2);
        return this.f4047a.zzfi();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final <T> T a(dm<T> dmVar, zzgu zzguVar) throws IOException {
        a(2);
        return (T) c(dmVar, zzguVar);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final <T> T b(dm<T> dmVar, zzgu zzguVar) throws IOException {
        a(3);
        return (T) d(dmVar, zzguVar);
    }

    private final <T> T c(dm<T> dmVar, zzgu zzguVar) throws IOException {
        int zzfk = this.f4047a.zzfk();
        if (this.f4047a.f4175a >= this.f4047a.b) {
            throw new zzhm("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int zzaa = this.f4047a.zzaa(zzfk);
        T a2 = dmVar.a();
        this.f4047a.f4175a++;
        dmVar.a(a2, this, zzguVar);
        dmVar.c(a2);
        this.f4047a.zzy(0);
        zzgj zzgjVar = this.f4047a;
        zzgjVar.f4175a--;
        this.f4047a.zzab(zzaa);
        return a2;
    }

    private final <T> T d(dm<T> dmVar, zzgu zzguVar) throws IOException {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            T a2 = dmVar.a();
            dmVar.a(a2, this, zzguVar);
            dmVar.c(a2);
            if (this.b == this.c) {
                return a2;
            }
            throw zzhm.h();
        } finally {
            this.c = i;
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final zzfx n() throws IOException {
        a(2);
        return this.f4047a.zzfj();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final int o() throws IOException {
        a(0);
        return this.f4047a.zzfk();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final int p() throws IOException {
        a(0);
        return this.f4047a.zzfl();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final int q() throws IOException {
        a(5);
        return this.f4047a.zzfm();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final long r() throws IOException {
        a(1);
        return this.f4047a.zzfn();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final int s() throws IOException {
        a(0);
        return this.f4047a.zzfo();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final long t() throws IOException {
        a(0);
        return this.f4047a.zzfp();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final void a(List<Double> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof bw) {
            bw bwVar = (bw) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int zzfk = this.f4047a.zzfk();
                    b(zzfk);
                    int zzfs = this.f4047a.zzfs() + zzfk;
                    do {
                        bwVar.a(this.f4047a.readDouble());
                    } while (this.f4047a.zzfs() < zzfs);
                    return;
                default:
                    throw zzhm.f();
            }
            do {
                bwVar.a(this.f4047a.readDouble());
                if (this.f4047a.zzfr()) {
                    return;
                } else {
                    zzfb2 = this.f4047a.zzfb();
                }
            } while (zzfb2 == this.b);
            this.d = zzfb2;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int zzfk2 = this.f4047a.zzfk();
                b(zzfk2);
                int zzfs2 = this.f4047a.zzfs() + zzfk2;
                do {
                    list.add(Double.valueOf(this.f4047a.readDouble()));
                } while (this.f4047a.zzfs() < zzfs2);
                return;
            default:
                throw zzhm.f();
        }
        do {
            list.add(Double.valueOf(this.f4047a.readDouble()));
            if (this.f4047a.zzfr()) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == this.b);
        this.d = zzfb;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final void b(List<Float> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof cg) {
            cg cgVar = (cg) list;
            int i = this.b & 7;
            if (i == 2) {
                int zzfk = this.f4047a.zzfk();
                c(zzfk);
                int zzfs = this.f4047a.zzfs() + zzfk;
                do {
                    cgVar.a(this.f4047a.readFloat());
                } while (this.f4047a.zzfs() < zzfs);
                return;
            }
            if (i != 5) {
                throw zzhm.f();
            }
            do {
                cgVar.a(this.f4047a.readFloat());
                if (this.f4047a.zzfr()) {
                    return;
                } else {
                    zzfb2 = this.f4047a.zzfb();
                }
            } while (zzfb2 == this.b);
            this.d = zzfb2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 == 2) {
            int zzfk2 = this.f4047a.zzfk();
            c(zzfk2);
            int zzfs2 = this.f4047a.zzfs() + zzfk2;
            do {
                list.add(Float.valueOf(this.f4047a.readFloat()));
            } while (this.f4047a.zzfs() < zzfs2);
            return;
        }
        if (i2 != 5) {
            throw zzhm.f();
        }
        do {
            list.add(Float.valueOf(this.f4047a.readFloat()));
            if (this.f4047a.zzfr()) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == this.b);
        this.d = zzfb;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final void c(List<Long> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof co) {
            co coVar = (co) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzfs = this.f4047a.zzfs() + this.f4047a.zzfk();
                    do {
                        coVar.a(this.f4047a.zzfc());
                    } while (this.f4047a.zzfs() < zzfs);
                    d(zzfs);
                    return;
                }
                throw zzhm.f();
            }
            do {
                coVar.a(this.f4047a.zzfc());
                if (this.f4047a.zzfr()) {
                    return;
                } else {
                    zzfb2 = this.f4047a.zzfb();
                }
            } while (zzfb2 == this.b);
            this.d = zzfb2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzfs2 = this.f4047a.zzfs() + this.f4047a.zzfk();
                do {
                    list.add(Long.valueOf(this.f4047a.zzfc()));
                } while (this.f4047a.zzfs() < zzfs2);
                d(zzfs2);
                return;
            }
            throw zzhm.f();
        }
        do {
            list.add(Long.valueOf(this.f4047a.zzfc()));
            if (this.f4047a.zzfr()) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == this.b);
        this.d = zzfb;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final void d(List<Long> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof co) {
            co coVar = (co) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzfs = this.f4047a.zzfs() + this.f4047a.zzfk();
                    do {
                        coVar.a(this.f4047a.zzfd());
                    } while (this.f4047a.zzfs() < zzfs);
                    d(zzfs);
                    return;
                }
                throw zzhm.f();
            }
            do {
                coVar.a(this.f4047a.zzfd());
                if (this.f4047a.zzfr()) {
                    return;
                } else {
                    zzfb2 = this.f4047a.zzfb();
                }
            } while (zzfb2 == this.b);
            this.d = zzfb2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzfs2 = this.f4047a.zzfs() + this.f4047a.zzfk();
                do {
                    list.add(Long.valueOf(this.f4047a.zzfd()));
                } while (this.f4047a.zzfs() < zzfs2);
                d(zzfs2);
                return;
            }
            throw zzhm.f();
        }
        do {
            list.add(Long.valueOf(this.f4047a.zzfd()));
            if (this.f4047a.zzfr()) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == this.b);
        this.d = zzfb;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final void e(List<Integer> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof ch) {
            ch chVar = (ch) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzfs = this.f4047a.zzfs() + this.f4047a.zzfk();
                    do {
                        chVar.b(this.f4047a.zzfe());
                    } while (this.f4047a.zzfs() < zzfs);
                    d(zzfs);
                    return;
                }
                throw zzhm.f();
            }
            do {
                chVar.b(this.f4047a.zzfe());
                if (this.f4047a.zzfr()) {
                    return;
                } else {
                    zzfb2 = this.f4047a.zzfb();
                }
            } while (zzfb2 == this.b);
            this.d = zzfb2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzfs2 = this.f4047a.zzfs() + this.f4047a.zzfk();
                do {
                    list.add(Integer.valueOf(this.f4047a.zzfe()));
                } while (this.f4047a.zzfs() < zzfs2);
                d(zzfs2);
                return;
            }
            throw zzhm.f();
        }
        do {
            list.add(Integer.valueOf(this.f4047a.zzfe()));
            if (this.f4047a.zzfr()) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == this.b);
        this.d = zzfb;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final void f(List<Long> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof co) {
            co coVar = (co) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int zzfk = this.f4047a.zzfk();
                    b(zzfk);
                    int zzfs = this.f4047a.zzfs() + zzfk;
                    do {
                        coVar.a(this.f4047a.zzff());
                    } while (this.f4047a.zzfs() < zzfs);
                    return;
                default:
                    throw zzhm.f();
            }
            do {
                coVar.a(this.f4047a.zzff());
                if (this.f4047a.zzfr()) {
                    return;
                } else {
                    zzfb2 = this.f4047a.zzfb();
                }
            } while (zzfb2 == this.b);
            this.d = zzfb2;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int zzfk2 = this.f4047a.zzfk();
                b(zzfk2);
                int zzfs2 = this.f4047a.zzfs() + zzfk2;
                do {
                    list.add(Long.valueOf(this.f4047a.zzff()));
                } while (this.f4047a.zzfs() < zzfs2);
                return;
            default:
                throw zzhm.f();
        }
        do {
            list.add(Long.valueOf(this.f4047a.zzff()));
            if (this.f4047a.zzfr()) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == this.b);
        this.d = zzfb;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final void g(List<Integer> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof ch) {
            ch chVar = (ch) list;
            int i = this.b & 7;
            if (i == 2) {
                int zzfk = this.f4047a.zzfk();
                c(zzfk);
                int zzfs = this.f4047a.zzfs() + zzfk;
                do {
                    chVar.b(this.f4047a.zzfg());
                } while (this.f4047a.zzfs() < zzfs);
                return;
            }
            if (i != 5) {
                throw zzhm.f();
            }
            do {
                chVar.b(this.f4047a.zzfg());
                if (this.f4047a.zzfr()) {
                    return;
                } else {
                    zzfb2 = this.f4047a.zzfb();
                }
            } while (zzfb2 == this.b);
            this.d = zzfb2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 == 2) {
            int zzfk2 = this.f4047a.zzfk();
            c(zzfk2);
            int zzfs2 = this.f4047a.zzfs() + zzfk2;
            do {
                list.add(Integer.valueOf(this.f4047a.zzfg()));
            } while (this.f4047a.zzfs() < zzfs2);
            return;
        }
        if (i2 != 5) {
            throw zzhm.f();
        }
        do {
            list.add(Integer.valueOf(this.f4047a.zzfg()));
            if (this.f4047a.zzfr()) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == this.b);
        this.d = zzfb;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final void h(List<Boolean> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof bf) {
            bf bfVar = (bf) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzfs = this.f4047a.zzfs() + this.f4047a.zzfk();
                    do {
                        bfVar.a(this.f4047a.zzfh());
                    } while (this.f4047a.zzfs() < zzfs);
                    d(zzfs);
                    return;
                }
                throw zzhm.f();
            }
            do {
                bfVar.a(this.f4047a.zzfh());
                if (this.f4047a.zzfr()) {
                    return;
                } else {
                    zzfb2 = this.f4047a.zzfb();
                }
            } while (zzfb2 == this.b);
            this.d = zzfb2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzfs2 = this.f4047a.zzfs() + this.f4047a.zzfk();
                do {
                    list.add(Boolean.valueOf(this.f4047a.zzfh()));
                } while (this.f4047a.zzfs() < zzfs2);
                d(zzfs2);
                return;
            }
            throw zzhm.f();
        }
        do {
            list.add(Boolean.valueOf(this.f4047a.zzfh()));
            if (this.f4047a.zzfr()) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == this.b);
        this.d = zzfb;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final void i(List<String> list) throws IOException {
        a(list, false);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final void j(List<String> list) throws IOException {
        a(list, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void a(List<String> list, boolean z) throws IOException {
        int zzfb;
        int zzfb2;
        if ((this.b & 7) != 2) {
            throw zzhm.f();
        }
        if ((list instanceof zzhx) && !z) {
            zzhx zzhxVar = (zzhx) list;
            do {
                zzhxVar.zzd(n());
                if (this.f4047a.zzfr()) {
                    return;
                } else {
                    zzfb2 = this.f4047a.zzfb();
                }
            } while (zzfb2 == this.b);
            this.d = zzfb2;
            return;
        }
        do {
            list.add(z ? m() : l());
            if (this.f4047a.zzfr()) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == this.b);
        this.d = zzfb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final <T> void a(List<T> list, dm<T> dmVar, zzgu zzguVar) throws IOException {
        int zzfb;
        int i = this.b;
        if ((i & 7) != 2) {
            throw zzhm.f();
        }
        do {
            list.add(c(dmVar, zzguVar));
            if (this.f4047a.zzfr() || this.d != 0) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == i);
        this.d = zzfb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final <T> void b(List<T> list, dm<T> dmVar, zzgu zzguVar) throws IOException {
        int zzfb;
        int i = this.b;
        if ((i & 7) != 3) {
            throw zzhm.f();
        }
        do {
            list.add(d(dmVar, zzguVar));
            if (this.f4047a.zzfr() || this.d != 0) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == i);
        this.d = zzfb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final void k(List<zzfx> list) throws IOException {
        int zzfb;
        if ((this.b & 7) != 2) {
            throw zzhm.f();
        }
        do {
            list.add(n());
            if (this.f4047a.zzfr()) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == this.b);
        this.d = zzfb;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final void l(List<Integer> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof ch) {
            ch chVar = (ch) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzfs = this.f4047a.zzfs() + this.f4047a.zzfk();
                    do {
                        chVar.b(this.f4047a.zzfk());
                    } while (this.f4047a.zzfs() < zzfs);
                    d(zzfs);
                    return;
                }
                throw zzhm.f();
            }
            do {
                chVar.b(this.f4047a.zzfk());
                if (this.f4047a.zzfr()) {
                    return;
                } else {
                    zzfb2 = this.f4047a.zzfb();
                }
            } while (zzfb2 == this.b);
            this.d = zzfb2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzfs2 = this.f4047a.zzfs() + this.f4047a.zzfk();
                do {
                    list.add(Integer.valueOf(this.f4047a.zzfk()));
                } while (this.f4047a.zzfs() < zzfs2);
                d(zzfs2);
                return;
            }
            throw zzhm.f();
        }
        do {
            list.add(Integer.valueOf(this.f4047a.zzfk()));
            if (this.f4047a.zzfr()) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == this.b);
        this.d = zzfb;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final void m(List<Integer> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof ch) {
            ch chVar = (ch) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzfs = this.f4047a.zzfs() + this.f4047a.zzfk();
                    do {
                        chVar.b(this.f4047a.zzfl());
                    } while (this.f4047a.zzfs() < zzfs);
                    d(zzfs);
                    return;
                }
                throw zzhm.f();
            }
            do {
                chVar.b(this.f4047a.zzfl());
                if (this.f4047a.zzfr()) {
                    return;
                } else {
                    zzfb2 = this.f4047a.zzfb();
                }
            } while (zzfb2 == this.b);
            this.d = zzfb2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzfs2 = this.f4047a.zzfs() + this.f4047a.zzfk();
                do {
                    list.add(Integer.valueOf(this.f4047a.zzfl()));
                } while (this.f4047a.zzfs() < zzfs2);
                d(zzfs2);
                return;
            }
            throw zzhm.f();
        }
        do {
            list.add(Integer.valueOf(this.f4047a.zzfl()));
            if (this.f4047a.zzfr()) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == this.b);
        this.d = zzfb;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final void n(List<Integer> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof ch) {
            ch chVar = (ch) list;
            int i = this.b & 7;
            if (i == 2) {
                int zzfk = this.f4047a.zzfk();
                c(zzfk);
                int zzfs = this.f4047a.zzfs() + zzfk;
                do {
                    chVar.b(this.f4047a.zzfm());
                } while (this.f4047a.zzfs() < zzfs);
                return;
            }
            if (i != 5) {
                throw zzhm.f();
            }
            do {
                chVar.b(this.f4047a.zzfm());
                if (this.f4047a.zzfr()) {
                    return;
                } else {
                    zzfb2 = this.f4047a.zzfb();
                }
            } while (zzfb2 == this.b);
            this.d = zzfb2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 == 2) {
            int zzfk2 = this.f4047a.zzfk();
            c(zzfk2);
            int zzfs2 = this.f4047a.zzfs() + zzfk2;
            do {
                list.add(Integer.valueOf(this.f4047a.zzfm()));
            } while (this.f4047a.zzfs() < zzfs2);
            return;
        }
        if (i2 != 5) {
            throw zzhm.f();
        }
        do {
            list.add(Integer.valueOf(this.f4047a.zzfm()));
            if (this.f4047a.zzfr()) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == this.b);
        this.d = zzfb;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final void o(List<Long> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof co) {
            co coVar = (co) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int zzfk = this.f4047a.zzfk();
                    b(zzfk);
                    int zzfs = this.f4047a.zzfs() + zzfk;
                    do {
                        coVar.a(this.f4047a.zzfn());
                    } while (this.f4047a.zzfs() < zzfs);
                    return;
                default:
                    throw zzhm.f();
            }
            do {
                coVar.a(this.f4047a.zzfn());
                if (this.f4047a.zzfr()) {
                    return;
                } else {
                    zzfb2 = this.f4047a.zzfb();
                }
            } while (zzfb2 == this.b);
            this.d = zzfb2;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int zzfk2 = this.f4047a.zzfk();
                b(zzfk2);
                int zzfs2 = this.f4047a.zzfs() + zzfk2;
                do {
                    list.add(Long.valueOf(this.f4047a.zzfn()));
                } while (this.f4047a.zzfs() < zzfs2);
                return;
            default:
                throw zzhm.f();
        }
        do {
            list.add(Long.valueOf(this.f4047a.zzfn()));
            if (this.f4047a.zzfr()) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == this.b);
        this.d = zzfb;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final void p(List<Integer> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof ch) {
            ch chVar = (ch) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzfs = this.f4047a.zzfs() + this.f4047a.zzfk();
                    do {
                        chVar.b(this.f4047a.zzfo());
                    } while (this.f4047a.zzfs() < zzfs);
                    d(zzfs);
                    return;
                }
                throw zzhm.f();
            }
            do {
                chVar.b(this.f4047a.zzfo());
                if (this.f4047a.zzfr()) {
                    return;
                } else {
                    zzfb2 = this.f4047a.zzfb();
                }
            } while (zzfb2 == this.b);
            this.d = zzfb2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzfs2 = this.f4047a.zzfs() + this.f4047a.zzfk();
                do {
                    list.add(Integer.valueOf(this.f4047a.zzfo()));
                } while (this.f4047a.zzfs() < zzfs2);
                d(zzfs2);
                return;
            }
            throw zzhm.f();
        }
        do {
            list.add(Integer.valueOf(this.f4047a.zzfo()));
            if (this.f4047a.zzfr()) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == this.b);
        this.d = zzfb;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final void q(List<Long> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof co) {
            co coVar = (co) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzfs = this.f4047a.zzfs() + this.f4047a.zzfk();
                    do {
                        coVar.a(this.f4047a.zzfp());
                    } while (this.f4047a.zzfs() < zzfs);
                    d(zzfs);
                    return;
                }
                throw zzhm.f();
            }
            do {
                coVar.a(this.f4047a.zzfp());
                if (this.f4047a.zzfr()) {
                    return;
                } else {
                    zzfb2 = this.f4047a.zzfb();
                }
            } while (zzfb2 == this.b);
            this.d = zzfb2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzfs2 = this.f4047a.zzfs() + this.f4047a.zzfk();
                do {
                    list.add(Long.valueOf(this.f4047a.zzfp()));
                } while (this.f4047a.zzfs() < zzfs2);
                d(zzfs2);
                return;
            }
            throw zzhm.f();
        }
        do {
            list.add(Long.valueOf(this.f4047a.zzfp()));
            if (this.f4047a.zzfr()) {
                return;
            } else {
                zzfb = this.f4047a.zzfb();
            }
        } while (zzfb == this.b);
        this.d = zzfb;
    }

    private static void b(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzhm.h();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0025. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.firebase_remote_config.dj
    public final <K, V> void a(Map<K, V> map, ct<K, V> ctVar, zzgu zzguVar) throws IOException {
        a(2);
        int zzaa = this.f4047a.zzaa(this.f4047a.zzfk());
        Object obj = ctVar.b;
        Object obj2 = ctVar.d;
        while (true) {
            try {
                int a2 = a();
                if (a2 != Integer.MAX_VALUE && !this.f4047a.zzfr()) {
                    switch (a2) {
                        case 1:
                            obj = a(ctVar.f4068a, (Class<?>) null, (zzgu) null);
                        case 2:
                            obj2 = a(ctVar.c, ctVar.d.getClass(), zzguVar);
                        default:
                            try {
                            } catch (zzhp unused) {
                                if (!c()) {
                                    throw new zzhm("Unable to parse map entry.");
                                }
                            }
                            if (!c()) {
                                throw new zzhm("Unable to parse map entry.");
                                break;
                            }
                    }
                }
            } finally {
                this.f4047a.zzab(zzaa);
            }
        }
        map.put(obj, obj2);
    }

    private final Object a(zzkk zzkkVar, Class<?> cls, zzgu zzguVar) throws IOException {
        switch (bt.f4048a[zzkkVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(k());
            case 2:
                return n();
            case 3:
                return Double.valueOf(d());
            case 4:
                return Integer.valueOf(p());
            case 5:
                return Integer.valueOf(j());
            case 6:
                return Long.valueOf(i());
            case 7:
                return Float.valueOf(e());
            case 8:
                return Integer.valueOf(h());
            case 9:
                return Long.valueOf(g());
            case 10:
                a(2);
                return c(di.a().a((Class) cls), zzguVar);
            case 11:
                return Integer.valueOf(q());
            case 12:
                return Long.valueOf(r());
            case 13:
                return Integer.valueOf(s());
            case 14:
                return Long.valueOf(t());
            case 15:
                return m();
            case 16:
                return Integer.valueOf(o());
            case 17:
                return Long.valueOf(f());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void c(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzhm.h();
        }
    }

    private final void d(int i) throws IOException {
        if (this.f4047a.zzfs() != i) {
            throw zzhm.a();
        }
    }
}
