package com.google.android.gms.internal.ads;

import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class afb implements agw {

    /* renamed from: a, reason: collision with root package name */
    private final zzdnd f1840a;
    private int b;
    private int c;
    private int d = 0;

    public static afb a(zzdnd zzdndVar) {
        if (zzdndVar.c != null) {
            return zzdndVar.c;
        }
        return new afb(zzdndVar);
    }

    private afb(zzdnd zzdndVar) {
        this.f1840a = (zzdnd) zzdod.a(zzdndVar, EvaluateItemInfo.ACTIONTYPE_INPUT);
        this.f1840a.c = this;
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final int a() throws IOException {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.f1840a.zzavu();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final boolean c() throws IOException {
        int i;
        if (this.f1840a.zzawk() || (i = this.b) == this.c) {
            return false;
        }
        return this.f1840a.zzfq(i);
    }

    private final void a(int i) throws IOException {
        if ((this.b & 7) != i) {
            throw zzdok.f();
        }
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final double d() throws IOException {
        a(1);
        return this.f1840a.readDouble();
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final float e() throws IOException {
        a(5);
        return this.f1840a.readFloat();
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final long f() throws IOException {
        a(0);
        return this.f1840a.zzavv();
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final long g() throws IOException {
        a(0);
        return this.f1840a.zzavw();
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final int h() throws IOException {
        a(0);
        return this.f1840a.zzavx();
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final long i() throws IOException {
        a(1);
        return this.f1840a.zzavy();
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final int j() throws IOException {
        a(5);
        return this.f1840a.zzavz();
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final boolean k() throws IOException {
        a(0);
        return this.f1840a.zzawa();
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final String l() throws IOException {
        a(2);
        return this.f1840a.readString();
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final String m() throws IOException {
        a(2);
        return this.f1840a.zzawb();
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final <T> T a(agx<T> agxVar, zzdno zzdnoVar) throws IOException {
        a(2);
        return (T) c(agxVar, zzdnoVar);
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final <T> T b(agx<T> agxVar, zzdno zzdnoVar) throws IOException {
        a(3);
        return (T) d(agxVar, zzdnoVar);
    }

    private final <T> T c(agx<T> agxVar, zzdno zzdnoVar) throws IOException {
        int zzawd = this.f1840a.zzawd();
        if (this.f1840a.f3584a >= this.f1840a.b) {
            throw new zzdok("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int zzfr = this.f1840a.zzfr(zzawd);
        T a2 = agxVar.a();
        this.f1840a.f3584a++;
        agxVar.a(a2, this, zzdnoVar);
        agxVar.c(a2);
        this.f1840a.zzfp(0);
        zzdnd zzdndVar = this.f1840a;
        zzdndVar.f3584a--;
        this.f1840a.zzfs(zzfr);
        return a2;
    }

    private final <T> T d(agx<T> agxVar, zzdno zzdnoVar) throws IOException {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            T a2 = agxVar.a();
            agxVar.a(a2, this, zzdnoVar);
            agxVar.c(a2);
            if (this.b == this.c) {
                return a2;
            }
            throw zzdok.g();
        } finally {
            this.c = i;
        }
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final zzdmr n() throws IOException {
        a(2);
        return this.f1840a.zzawc();
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final int o() throws IOException {
        a(0);
        return this.f1840a.zzawd();
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final int p() throws IOException {
        a(0);
        return this.f1840a.zzawe();
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final int q() throws IOException {
        a(5);
        return this.f1840a.zzawf();
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final long r() throws IOException {
        a(1);
        return this.f1840a.zzawg();
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final int s() throws IOException {
        a(0);
        return this.f1840a.zzawh();
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final long t() throws IOException {
        a(0);
        return this.f1840a.zzawi();
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final void a(List<Double> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof aff) {
            aff affVar = (aff) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int zzawd = this.f1840a.zzawd();
                    b(zzawd);
                    int zzawl = this.f1840a.zzawl() + zzawd;
                    do {
                        affVar.a(this.f1840a.readDouble());
                    } while (this.f1840a.zzawl() < zzawl);
                    return;
                default:
                    throw zzdok.f();
            }
            do {
                affVar.a(this.f1840a.readDouble());
                if (this.f1840a.zzawk()) {
                    return;
                } else {
                    zzavu2 = this.f1840a.zzavu();
                }
            } while (zzavu2 == this.b);
            this.d = zzavu2;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int zzawd2 = this.f1840a.zzawd();
                b(zzawd2);
                int zzawl2 = this.f1840a.zzawl() + zzawd2;
                do {
                    list.add(Double.valueOf(this.f1840a.readDouble()));
                } while (this.f1840a.zzawl() < zzawl2);
                return;
            default:
                throw zzdok.f();
        }
        do {
            list.add(Double.valueOf(this.f1840a.readDouble()));
            if (this.f1840a.zzawk()) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == this.b);
        this.d = zzavu;
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final void b(List<Float> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof afn) {
            afn afnVar = (afn) list;
            int i = this.b & 7;
            if (i == 2) {
                int zzawd = this.f1840a.zzawd();
                c(zzawd);
                int zzawl = this.f1840a.zzawl() + zzawd;
                do {
                    afnVar.a(this.f1840a.readFloat());
                } while (this.f1840a.zzawl() < zzawl);
                return;
            }
            if (i != 5) {
                throw zzdok.f();
            }
            do {
                afnVar.a(this.f1840a.readFloat());
                if (this.f1840a.zzawk()) {
                    return;
                } else {
                    zzavu2 = this.f1840a.zzavu();
                }
            } while (zzavu2 == this.b);
            this.d = zzavu2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 == 2) {
            int zzawd2 = this.f1840a.zzawd();
            c(zzawd2);
            int zzawl2 = this.f1840a.zzawl() + zzawd2;
            do {
                list.add(Float.valueOf(this.f1840a.readFloat()));
            } while (this.f1840a.zzawl() < zzawl2);
            return;
        }
        if (i2 != 5) {
            throw zzdok.f();
        }
        do {
            list.add(Float.valueOf(this.f1840a.readFloat()));
            if (this.f1840a.zzawk()) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == this.b);
        this.d = zzavu;
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final void c(List<Long> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof afz) {
            afz afzVar = (afz) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzawl = this.f1840a.zzawl() + this.f1840a.zzawd();
                    do {
                        afzVar.a(this.f1840a.zzavv());
                    } while (this.f1840a.zzawl() < zzawl);
                    d(zzawl);
                    return;
                }
                throw zzdok.f();
            }
            do {
                afzVar.a(this.f1840a.zzavv());
                if (this.f1840a.zzawk()) {
                    return;
                } else {
                    zzavu2 = this.f1840a.zzavu();
                }
            } while (zzavu2 == this.b);
            this.d = zzavu2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzawl2 = this.f1840a.zzawl() + this.f1840a.zzawd();
                do {
                    list.add(Long.valueOf(this.f1840a.zzavv()));
                } while (this.f1840a.zzawl() < zzawl2);
                d(zzawl2);
                return;
            }
            throw zzdok.f();
        }
        do {
            list.add(Long.valueOf(this.f1840a.zzavv()));
            if (this.f1840a.zzawk()) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == this.b);
        this.d = zzavu;
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final void d(List<Long> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof afz) {
            afz afzVar = (afz) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzawl = this.f1840a.zzawl() + this.f1840a.zzawd();
                    do {
                        afzVar.a(this.f1840a.zzavw());
                    } while (this.f1840a.zzawl() < zzawl);
                    d(zzawl);
                    return;
                }
                throw zzdok.f();
            }
            do {
                afzVar.a(this.f1840a.zzavw());
                if (this.f1840a.zzawk()) {
                    return;
                } else {
                    zzavu2 = this.f1840a.zzavu();
                }
            } while (zzavu2 == this.b);
            this.d = zzavu2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzawl2 = this.f1840a.zzawl() + this.f1840a.zzawd();
                do {
                    list.add(Long.valueOf(this.f1840a.zzavw()));
                } while (this.f1840a.zzawl() < zzawl2);
                d(zzawl2);
                return;
            }
            throw zzdok.f();
        }
        do {
            list.add(Long.valueOf(this.f1840a.zzavw()));
            if (this.f1840a.zzawk()) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == this.b);
        this.d = zzavu;
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final void e(List<Integer> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof afr) {
            afr afrVar = (afr) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzawl = this.f1840a.zzawl() + this.f1840a.zzawd();
                    do {
                        afrVar.zzgp(this.f1840a.zzavx());
                    } while (this.f1840a.zzawl() < zzawl);
                    d(zzawl);
                    return;
                }
                throw zzdok.f();
            }
            do {
                afrVar.zzgp(this.f1840a.zzavx());
                if (this.f1840a.zzawk()) {
                    return;
                } else {
                    zzavu2 = this.f1840a.zzavu();
                }
            } while (zzavu2 == this.b);
            this.d = zzavu2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzawl2 = this.f1840a.zzawl() + this.f1840a.zzawd();
                do {
                    list.add(Integer.valueOf(this.f1840a.zzavx()));
                } while (this.f1840a.zzawl() < zzawl2);
                d(zzawl2);
                return;
            }
            throw zzdok.f();
        }
        do {
            list.add(Integer.valueOf(this.f1840a.zzavx()));
            if (this.f1840a.zzawk()) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == this.b);
        this.d = zzavu;
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final void f(List<Long> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof afz) {
            afz afzVar = (afz) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int zzawd = this.f1840a.zzawd();
                    b(zzawd);
                    int zzawl = this.f1840a.zzawl() + zzawd;
                    do {
                        afzVar.a(this.f1840a.zzavy());
                    } while (this.f1840a.zzawl() < zzawl);
                    return;
                default:
                    throw zzdok.f();
            }
            do {
                afzVar.a(this.f1840a.zzavy());
                if (this.f1840a.zzawk()) {
                    return;
                } else {
                    zzavu2 = this.f1840a.zzavu();
                }
            } while (zzavu2 == this.b);
            this.d = zzavu2;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int zzawd2 = this.f1840a.zzawd();
                b(zzawd2);
                int zzawl2 = this.f1840a.zzawl() + zzawd2;
                do {
                    list.add(Long.valueOf(this.f1840a.zzavy()));
                } while (this.f1840a.zzawl() < zzawl2);
                return;
            default:
                throw zzdok.f();
        }
        do {
            list.add(Long.valueOf(this.f1840a.zzavy()));
            if (this.f1840a.zzawk()) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == this.b);
        this.d = zzavu;
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final void g(List<Integer> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof afr) {
            afr afrVar = (afr) list;
            int i = this.b & 7;
            if (i == 2) {
                int zzawd = this.f1840a.zzawd();
                c(zzawd);
                int zzawl = this.f1840a.zzawl() + zzawd;
                do {
                    afrVar.zzgp(this.f1840a.zzavz());
                } while (this.f1840a.zzawl() < zzawl);
                return;
            }
            if (i != 5) {
                throw zzdok.f();
            }
            do {
                afrVar.zzgp(this.f1840a.zzavz());
                if (this.f1840a.zzawk()) {
                    return;
                } else {
                    zzavu2 = this.f1840a.zzavu();
                }
            } while (zzavu2 == this.b);
            this.d = zzavu2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 == 2) {
            int zzawd2 = this.f1840a.zzawd();
            c(zzawd2);
            int zzawl2 = this.f1840a.zzawl() + zzawd2;
            do {
                list.add(Integer.valueOf(this.f1840a.zzavz()));
            } while (this.f1840a.zzawl() < zzawl2);
            return;
        }
        if (i2 != 5) {
            throw zzdok.f();
        }
        do {
            list.add(Integer.valueOf(this.f1840a.zzavz()));
            if (this.f1840a.zzawk()) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == this.b);
        this.d = zzavu;
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final void h(List<Boolean> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof aeq) {
            aeq aeqVar = (aeq) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzawl = this.f1840a.zzawl() + this.f1840a.zzawd();
                    do {
                        aeqVar.a(this.f1840a.zzawa());
                    } while (this.f1840a.zzawl() < zzawl);
                    d(zzawl);
                    return;
                }
                throw zzdok.f();
            }
            do {
                aeqVar.a(this.f1840a.zzawa());
                if (this.f1840a.zzawk()) {
                    return;
                } else {
                    zzavu2 = this.f1840a.zzavu();
                }
            } while (zzavu2 == this.b);
            this.d = zzavu2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzawl2 = this.f1840a.zzawl() + this.f1840a.zzawd();
                do {
                    list.add(Boolean.valueOf(this.f1840a.zzawa()));
                } while (this.f1840a.zzawl() < zzawl2);
                d(zzawl2);
                return;
            }
            throw zzdok.f();
        }
        do {
            list.add(Boolean.valueOf(this.f1840a.zzawa()));
            if (this.f1840a.zzawk()) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == this.b);
        this.d = zzavu;
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final void i(List<String> list) throws IOException {
        a(list, false);
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final void j(List<String> list) throws IOException {
        a(list, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void a(List<String> list, boolean z) throws IOException {
        int zzavu;
        int zzavu2;
        if ((this.b & 7) != 2) {
            throw zzdok.f();
        }
        if ((list instanceof zzdot) && !z) {
            zzdot zzdotVar = (zzdot) list;
            do {
                zzdotVar.zzdb(n());
                if (this.f1840a.zzawk()) {
                    return;
                } else {
                    zzavu2 = this.f1840a.zzavu();
                }
            } while (zzavu2 == this.b);
            this.d = zzavu2;
            return;
        }
        do {
            list.add(z ? m() : l());
            if (this.f1840a.zzawk()) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == this.b);
        this.d = zzavu;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.agw
    public final <T> void a(List<T> list, agx<T> agxVar, zzdno zzdnoVar) throws IOException {
        int zzavu;
        int i = this.b;
        if ((i & 7) != 2) {
            throw zzdok.f();
        }
        do {
            list.add(c(agxVar, zzdnoVar));
            if (this.f1840a.zzawk() || this.d != 0) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == i);
        this.d = zzavu;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.agw
    public final <T> void b(List<T> list, agx<T> agxVar, zzdno zzdnoVar) throws IOException {
        int zzavu;
        int i = this.b;
        if ((i & 7) != 3) {
            throw zzdok.f();
        }
        do {
            list.add(d(agxVar, zzdnoVar));
            if (this.f1840a.zzawk() || this.d != 0) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == i);
        this.d = zzavu;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.agw
    public final void k(List<zzdmr> list) throws IOException {
        int zzavu;
        if ((this.b & 7) != 2) {
            throw zzdok.f();
        }
        do {
            list.add(n());
            if (this.f1840a.zzawk()) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == this.b);
        this.d = zzavu;
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final void l(List<Integer> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof afr) {
            afr afrVar = (afr) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzawl = this.f1840a.zzawl() + this.f1840a.zzawd();
                    do {
                        afrVar.zzgp(this.f1840a.zzawd());
                    } while (this.f1840a.zzawl() < zzawl);
                    d(zzawl);
                    return;
                }
                throw zzdok.f();
            }
            do {
                afrVar.zzgp(this.f1840a.zzawd());
                if (this.f1840a.zzawk()) {
                    return;
                } else {
                    zzavu2 = this.f1840a.zzavu();
                }
            } while (zzavu2 == this.b);
            this.d = zzavu2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzawl2 = this.f1840a.zzawl() + this.f1840a.zzawd();
                do {
                    list.add(Integer.valueOf(this.f1840a.zzawd()));
                } while (this.f1840a.zzawl() < zzawl2);
                d(zzawl2);
                return;
            }
            throw zzdok.f();
        }
        do {
            list.add(Integer.valueOf(this.f1840a.zzawd()));
            if (this.f1840a.zzawk()) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == this.b);
        this.d = zzavu;
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final void m(List<Integer> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof afr) {
            afr afrVar = (afr) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzawl = this.f1840a.zzawl() + this.f1840a.zzawd();
                    do {
                        afrVar.zzgp(this.f1840a.zzawe());
                    } while (this.f1840a.zzawl() < zzawl);
                    d(zzawl);
                    return;
                }
                throw zzdok.f();
            }
            do {
                afrVar.zzgp(this.f1840a.zzawe());
                if (this.f1840a.zzawk()) {
                    return;
                } else {
                    zzavu2 = this.f1840a.zzavu();
                }
            } while (zzavu2 == this.b);
            this.d = zzavu2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzawl2 = this.f1840a.zzawl() + this.f1840a.zzawd();
                do {
                    list.add(Integer.valueOf(this.f1840a.zzawe()));
                } while (this.f1840a.zzawl() < zzawl2);
                d(zzawl2);
                return;
            }
            throw zzdok.f();
        }
        do {
            list.add(Integer.valueOf(this.f1840a.zzawe()));
            if (this.f1840a.zzawk()) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == this.b);
        this.d = zzavu;
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final void n(List<Integer> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof afr) {
            afr afrVar = (afr) list;
            int i = this.b & 7;
            if (i == 2) {
                int zzawd = this.f1840a.zzawd();
                c(zzawd);
                int zzawl = this.f1840a.zzawl() + zzawd;
                do {
                    afrVar.zzgp(this.f1840a.zzawf());
                } while (this.f1840a.zzawl() < zzawl);
                return;
            }
            if (i != 5) {
                throw zzdok.f();
            }
            do {
                afrVar.zzgp(this.f1840a.zzawf());
                if (this.f1840a.zzawk()) {
                    return;
                } else {
                    zzavu2 = this.f1840a.zzavu();
                }
            } while (zzavu2 == this.b);
            this.d = zzavu2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 == 2) {
            int zzawd2 = this.f1840a.zzawd();
            c(zzawd2);
            int zzawl2 = this.f1840a.zzawl() + zzawd2;
            do {
                list.add(Integer.valueOf(this.f1840a.zzawf()));
            } while (this.f1840a.zzawl() < zzawl2);
            return;
        }
        if (i2 != 5) {
            throw zzdok.f();
        }
        do {
            list.add(Integer.valueOf(this.f1840a.zzawf()));
            if (this.f1840a.zzawk()) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == this.b);
        this.d = zzavu;
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final void o(List<Long> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof afz) {
            afz afzVar = (afz) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int zzawd = this.f1840a.zzawd();
                    b(zzawd);
                    int zzawl = this.f1840a.zzawl() + zzawd;
                    do {
                        afzVar.a(this.f1840a.zzawg());
                    } while (this.f1840a.zzawl() < zzawl);
                    return;
                default:
                    throw zzdok.f();
            }
            do {
                afzVar.a(this.f1840a.zzawg());
                if (this.f1840a.zzawk()) {
                    return;
                } else {
                    zzavu2 = this.f1840a.zzavu();
                }
            } while (zzavu2 == this.b);
            this.d = zzavu2;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int zzawd2 = this.f1840a.zzawd();
                b(zzawd2);
                int zzawl2 = this.f1840a.zzawl() + zzawd2;
                do {
                    list.add(Long.valueOf(this.f1840a.zzawg()));
                } while (this.f1840a.zzawl() < zzawl2);
                return;
            default:
                throw zzdok.f();
        }
        do {
            list.add(Long.valueOf(this.f1840a.zzawg()));
            if (this.f1840a.zzawk()) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == this.b);
        this.d = zzavu;
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final void p(List<Integer> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof afr) {
            afr afrVar = (afr) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzawl = this.f1840a.zzawl() + this.f1840a.zzawd();
                    do {
                        afrVar.zzgp(this.f1840a.zzawh());
                    } while (this.f1840a.zzawl() < zzawl);
                    d(zzawl);
                    return;
                }
                throw zzdok.f();
            }
            do {
                afrVar.zzgp(this.f1840a.zzawh());
                if (this.f1840a.zzawk()) {
                    return;
                } else {
                    zzavu2 = this.f1840a.zzavu();
                }
            } while (zzavu2 == this.b);
            this.d = zzavu2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzawl2 = this.f1840a.zzawl() + this.f1840a.zzawd();
                do {
                    list.add(Integer.valueOf(this.f1840a.zzawh()));
                } while (this.f1840a.zzawl() < zzawl2);
                d(zzawl2);
                return;
            }
            throw zzdok.f();
        }
        do {
            list.add(Integer.valueOf(this.f1840a.zzawh()));
            if (this.f1840a.zzawk()) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == this.b);
        this.d = zzavu;
    }

    @Override // com.google.android.gms.internal.ads.agw
    public final void q(List<Long> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof afz) {
            afz afzVar = (afz) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzawl = this.f1840a.zzawl() + this.f1840a.zzawd();
                    do {
                        afzVar.a(this.f1840a.zzawi());
                    } while (this.f1840a.zzawl() < zzawl);
                    d(zzawl);
                    return;
                }
                throw zzdok.f();
            }
            do {
                afzVar.a(this.f1840a.zzawi());
                if (this.f1840a.zzawk()) {
                    return;
                } else {
                    zzavu2 = this.f1840a.zzavu();
                }
            } while (zzavu2 == this.b);
            this.d = zzavu2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzawl2 = this.f1840a.zzawl() + this.f1840a.zzawd();
                do {
                    list.add(Long.valueOf(this.f1840a.zzawi()));
                } while (this.f1840a.zzawl() < zzawl2);
                d(zzawl2);
                return;
            }
            throw zzdok.f();
        }
        do {
            list.add(Long.valueOf(this.f1840a.zzawi()));
            if (this.f1840a.zzawk()) {
                return;
            } else {
                zzavu = this.f1840a.zzavu();
            }
        } while (zzavu == this.b);
        this.d = zzavu;
    }

    private static void b(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzdok.g();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0025. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.agw
    public final <K, V> void a(Map<K, V> map, age<K, V> ageVar, zzdno zzdnoVar) throws IOException {
        a(2);
        int zzfr = this.f1840a.zzfr(this.f1840a.zzawd());
        Object obj = ageVar.b;
        Object obj2 = ageVar.d;
        while (true) {
            try {
                int a2 = a();
                if (a2 != Integer.MAX_VALUE && !this.f1840a.zzawk()) {
                    switch (a2) {
                        case 1:
                            obj = a(ageVar.f1862a, (Class<?>) null, (zzdno) null);
                        case 2:
                            obj2 = a(ageVar.c, ageVar.d.getClass(), zzdnoVar);
                        default:
                            try {
                            } catch (zzdol unused) {
                                if (!c()) {
                                    throw new zzdok("Unable to parse map entry.");
                                }
                            }
                            if (!c()) {
                                throw new zzdok("Unable to parse map entry.");
                                break;
                            }
                    }
                }
            } finally {
                this.f1840a.zzfs(zzfr);
            }
        }
        map.put(obj, obj2);
    }

    private final Object a(zzdri zzdriVar, Class<?> cls, zzdno zzdnoVar) throws IOException {
        switch (afc.f1841a[zzdriVar.ordinal()]) {
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
                return c(ags.a().a((Class) cls), zzdnoVar);
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
            throw zzdok.g();
        }
    }

    private final void d(int i) throws IOException {
        if (this.f1840a.zzawl() != i) {
            throw zzdok.a();
        }
    }
}
