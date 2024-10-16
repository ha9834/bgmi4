package com.google.android.gms.internal.gtm;

import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bj implements cz {

    /* renamed from: a, reason: collision with root package name */
    private final zzqe f4314a;
    private int b;
    private int c;
    private int d = 0;

    public static bj a(zzqe zzqeVar) {
        if (zzqeVar.c != null) {
            return zzqeVar.c;
        }
        return new bj(zzqeVar);
    }

    private bj(zzqe zzqeVar) {
        this.f4314a = (zzqe) zzre.a(zzqeVar, EvaluateItemInfo.ACTIONTYPE_INPUT);
        this.f4314a.c = this;
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final int a() throws IOException {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.f4314a.zzni();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final boolean c() throws IOException {
        int i;
        if (this.f4314a.zzny() || (i = this.b) == this.c) {
            return false;
        }
        return this.f4314a.zzao(i);
    }

    private final void a(int i) throws IOException {
        if ((this.b & 7) != i) {
            throw zzrk.e();
        }
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final double d() throws IOException {
        a(1);
        return this.f4314a.readDouble();
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final float e() throws IOException {
        a(5);
        return this.f4314a.readFloat();
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final long f() throws IOException {
        a(0);
        return this.f4314a.zznj();
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final long g() throws IOException {
        a(0);
        return this.f4314a.zznk();
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final int h() throws IOException {
        a(0);
        return this.f4314a.zznl();
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final long i() throws IOException {
        a(1);
        return this.f4314a.zznm();
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final int j() throws IOException {
        a(5);
        return this.f4314a.zznn();
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final boolean k() throws IOException {
        a(0);
        return this.f4314a.zzno();
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final String l() throws IOException {
        a(2);
        return this.f4314a.readString();
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final String m() throws IOException {
        a(2);
        return this.f4314a.zznp();
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final <T> T a(da<T> daVar, zzqp zzqpVar) throws IOException {
        a(2);
        return (T) c(daVar, zzqpVar);
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final <T> T b(da<T> daVar, zzqp zzqpVar) throws IOException {
        a(3);
        return (T) d(daVar, zzqpVar);
    }

    private final <T> T c(da<T> daVar, zzqp zzqpVar) throws IOException {
        int zznr = this.f4314a.zznr();
        if (this.f4314a.f4433a >= this.f4314a.b) {
            throw zzrk.f();
        }
        int zzaq = this.f4314a.zzaq(zznr);
        T a2 = daVar.a();
        this.f4314a.f4433a++;
        daVar.a(a2, this, zzqpVar);
        daVar.c(a2);
        this.f4314a.zzan(0);
        zzqe zzqeVar = this.f4314a;
        zzqeVar.f4433a--;
        this.f4314a.zzar(zzaq);
        return a2;
    }

    private final <T> T d(da<T> daVar, zzqp zzqpVar) throws IOException {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            T a2 = daVar.a();
            daVar.a(a2, this, zzqpVar);
            daVar.c(a2);
            if (this.b == this.c) {
                return a2;
            }
            throw zzrk.g();
        } finally {
            this.c = i;
        }
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final zzps n() throws IOException {
        a(2);
        return this.f4314a.zznq();
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final int o() throws IOException {
        a(0);
        return this.f4314a.zznr();
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final int p() throws IOException {
        a(0);
        return this.f4314a.zzns();
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final int q() throws IOException {
        a(5);
        return this.f4314a.zznt();
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final long r() throws IOException {
        a(1);
        return this.f4314a.zznu();
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final int s() throws IOException {
        a(0);
        return this.f4314a.zznv();
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final long t() throws IOException {
        a(0);
        return this.f4314a.zznw();
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final void a(List<Double> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof bn) {
            bn bnVar = (bn) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int zznr = this.f4314a.zznr();
                    b(zznr);
                    int zznz = this.f4314a.zznz() + zznr;
                    do {
                        bnVar.a(this.f4314a.readDouble());
                    } while (this.f4314a.zznz() < zznz);
                    return;
                default:
                    throw zzrk.e();
            }
            do {
                bnVar.a(this.f4314a.readDouble());
                if (this.f4314a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f4314a.zzni();
                }
            } while (zzni2 == this.b);
            this.d = zzni2;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int zznr2 = this.f4314a.zznr();
                b(zznr2);
                int zznz2 = this.f4314a.zznz() + zznr2;
                do {
                    list.add(Double.valueOf(this.f4314a.readDouble()));
                } while (this.f4314a.zznz() < zznz2);
                return;
            default:
                throw zzrk.e();
        }
        do {
            list.add(Double.valueOf(this.f4314a.readDouble()));
            if (this.f4314a.zzny()) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == this.b);
        this.d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final void b(List<Float> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof bv) {
            bv bvVar = (bv) list;
            int i = this.b & 7;
            if (i == 2) {
                int zznr = this.f4314a.zznr();
                c(zznr);
                int zznz = this.f4314a.zznz() + zznr;
                do {
                    bvVar.a(this.f4314a.readFloat());
                } while (this.f4314a.zznz() < zznz);
                return;
            }
            if (i != 5) {
                throw zzrk.e();
            }
            do {
                bvVar.a(this.f4314a.readFloat());
                if (this.f4314a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f4314a.zzni();
                }
            } while (zzni2 == this.b);
            this.d = zzni2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 == 2) {
            int zznr2 = this.f4314a.zznr();
            c(zznr2);
            int zznz2 = this.f4314a.zznz() + zznr2;
            do {
                list.add(Float.valueOf(this.f4314a.readFloat()));
            } while (this.f4314a.zznz() < zznz2);
            return;
        }
        if (i2 != 5) {
            throw zzrk.e();
        }
        do {
            list.add(Float.valueOf(this.f4314a.readFloat()));
            if (this.f4314a.zzny()) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == this.b);
        this.d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final void c(List<Long> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof cg) {
            cg cgVar = (cg) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zznz = this.f4314a.zznz() + this.f4314a.zznr();
                    do {
                        cgVar.a(this.f4314a.zznj());
                    } while (this.f4314a.zznz() < zznz);
                    d(zznz);
                    return;
                }
                throw zzrk.e();
            }
            do {
                cgVar.a(this.f4314a.zznj());
                if (this.f4314a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f4314a.zzni();
                }
            } while (zzni2 == this.b);
            this.d = zzni2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zznz2 = this.f4314a.zznz() + this.f4314a.zznr();
                do {
                    list.add(Long.valueOf(this.f4314a.zznj()));
                } while (this.f4314a.zznz() < zznz2);
                d(zznz2);
                return;
            }
            throw zzrk.e();
        }
        do {
            list.add(Long.valueOf(this.f4314a.zznj()));
            if (this.f4314a.zzny()) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == this.b);
        this.d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final void d(List<Long> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof cg) {
            cg cgVar = (cg) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zznz = this.f4314a.zznz() + this.f4314a.zznr();
                    do {
                        cgVar.a(this.f4314a.zznk());
                    } while (this.f4314a.zznz() < zznz);
                    d(zznz);
                    return;
                }
                throw zzrk.e();
            }
            do {
                cgVar.a(this.f4314a.zznk());
                if (this.f4314a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f4314a.zzni();
                }
            } while (zzni2 == this.b);
            this.d = zzni2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zznz2 = this.f4314a.zznz() + this.f4314a.zznr();
                do {
                    list.add(Long.valueOf(this.f4314a.zznk()));
                } while (this.f4314a.zznz() < zznz2);
                d(zznz2);
                return;
            }
            throw zzrk.e();
        }
        do {
            list.add(Long.valueOf(this.f4314a.zznk()));
            if (this.f4314a.zzny()) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == this.b);
        this.d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final void e(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof by) {
            by byVar = (by) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zznz = this.f4314a.zznz() + this.f4314a.zznr();
                    do {
                        byVar.b(this.f4314a.zznl());
                    } while (this.f4314a.zznz() < zznz);
                    d(zznz);
                    return;
                }
                throw zzrk.e();
            }
            do {
                byVar.b(this.f4314a.zznl());
                if (this.f4314a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f4314a.zzni();
                }
            } while (zzni2 == this.b);
            this.d = zzni2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zznz2 = this.f4314a.zznz() + this.f4314a.zznr();
                do {
                    list.add(Integer.valueOf(this.f4314a.zznl()));
                } while (this.f4314a.zznz() < zznz2);
                d(zznz2);
                return;
            }
            throw zzrk.e();
        }
        do {
            list.add(Integer.valueOf(this.f4314a.zznl()));
            if (this.f4314a.zzny()) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == this.b);
        this.d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final void f(List<Long> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof cg) {
            cg cgVar = (cg) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int zznr = this.f4314a.zznr();
                    b(zznr);
                    int zznz = this.f4314a.zznz() + zznr;
                    do {
                        cgVar.a(this.f4314a.zznm());
                    } while (this.f4314a.zznz() < zznz);
                    return;
                default:
                    throw zzrk.e();
            }
            do {
                cgVar.a(this.f4314a.zznm());
                if (this.f4314a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f4314a.zzni();
                }
            } while (zzni2 == this.b);
            this.d = zzni2;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int zznr2 = this.f4314a.zznr();
                b(zznr2);
                int zznz2 = this.f4314a.zznz() + zznr2;
                do {
                    list.add(Long.valueOf(this.f4314a.zznm()));
                } while (this.f4314a.zznz() < zznz2);
                return;
            default:
                throw zzrk.e();
        }
        do {
            list.add(Long.valueOf(this.f4314a.zznm()));
            if (this.f4314a.zzny()) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == this.b);
        this.d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final void g(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof by) {
            by byVar = (by) list;
            int i = this.b & 7;
            if (i == 2) {
                int zznr = this.f4314a.zznr();
                c(zznr);
                int zznz = this.f4314a.zznz() + zznr;
                do {
                    byVar.b(this.f4314a.zznn());
                } while (this.f4314a.zznz() < zznz);
                return;
            }
            if (i != 5) {
                throw zzrk.e();
            }
            do {
                byVar.b(this.f4314a.zznn());
                if (this.f4314a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f4314a.zzni();
                }
            } while (zzni2 == this.b);
            this.d = zzni2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 == 2) {
            int zznr2 = this.f4314a.zznr();
            c(zznr2);
            int zznz2 = this.f4314a.zznz() + zznr2;
            do {
                list.add(Integer.valueOf(this.f4314a.zznn()));
            } while (this.f4314a.zznz() < zznz2);
            return;
        }
        if (i2 != 5) {
            throw zzrk.e();
        }
        do {
            list.add(Integer.valueOf(this.f4314a.zznn()));
            if (this.f4314a.zzny()) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == this.b);
        this.d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final void h(List<Boolean> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof az) {
            az azVar = (az) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zznz = this.f4314a.zznz() + this.f4314a.zznr();
                    do {
                        azVar.a(this.f4314a.zzno());
                    } while (this.f4314a.zznz() < zznz);
                    d(zznz);
                    return;
                }
                throw zzrk.e();
            }
            do {
                azVar.a(this.f4314a.zzno());
                if (this.f4314a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f4314a.zzni();
                }
            } while (zzni2 == this.b);
            this.d = zzni2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zznz2 = this.f4314a.zznz() + this.f4314a.zznr();
                do {
                    list.add(Boolean.valueOf(this.f4314a.zzno()));
                } while (this.f4314a.zznz() < zznz2);
                d(zznz2);
                return;
            }
            throw zzrk.e();
        }
        do {
            list.add(Boolean.valueOf(this.f4314a.zzno()));
            if (this.f4314a.zzny()) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == this.b);
        this.d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final void i(List<String> list) throws IOException {
        a(list, false);
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final void j(List<String> list) throws IOException {
        a(list, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void a(List<String> list, boolean z) throws IOException {
        int zzni;
        int zzni2;
        if ((this.b & 7) != 2) {
            throw zzrk.e();
        }
        if ((list instanceof zzrt) && !z) {
            zzrt zzrtVar = (zzrt) list;
            do {
                zzrtVar.zzc(n());
                if (this.f4314a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f4314a.zzni();
                }
            } while (zzni2 == this.b);
            this.d = zzni2;
            return;
        }
        do {
            list.add(z ? m() : l());
            if (this.f4314a.zzny()) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == this.b);
        this.d = zzni;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.gtm.cz
    public final <T> void a(List<T> list, da<T> daVar, zzqp zzqpVar) throws IOException {
        int zzni;
        int i = this.b;
        if ((i & 7) != 2) {
            throw zzrk.e();
        }
        do {
            list.add(c(daVar, zzqpVar));
            if (this.f4314a.zzny() || this.d != 0) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == i);
        this.d = zzni;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.gtm.cz
    public final <T> void b(List<T> list, da<T> daVar, zzqp zzqpVar) throws IOException {
        int zzni;
        int i = this.b;
        if ((i & 7) != 3) {
            throw zzrk.e();
        }
        do {
            list.add(d(daVar, zzqpVar));
            if (this.f4314a.zzny() || this.d != 0) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == i);
        this.d = zzni;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.gtm.cz
    public final void k(List<zzps> list) throws IOException {
        int zzni;
        if ((this.b & 7) != 2) {
            throw zzrk.e();
        }
        do {
            list.add(n());
            if (this.f4314a.zzny()) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == this.b);
        this.d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final void l(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof by) {
            by byVar = (by) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zznz = this.f4314a.zznz() + this.f4314a.zznr();
                    do {
                        byVar.b(this.f4314a.zznr());
                    } while (this.f4314a.zznz() < zznz);
                    d(zznz);
                    return;
                }
                throw zzrk.e();
            }
            do {
                byVar.b(this.f4314a.zznr());
                if (this.f4314a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f4314a.zzni();
                }
            } while (zzni2 == this.b);
            this.d = zzni2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zznz2 = this.f4314a.zznz() + this.f4314a.zznr();
                do {
                    list.add(Integer.valueOf(this.f4314a.zznr()));
                } while (this.f4314a.zznz() < zznz2);
                d(zznz2);
                return;
            }
            throw zzrk.e();
        }
        do {
            list.add(Integer.valueOf(this.f4314a.zznr()));
            if (this.f4314a.zzny()) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == this.b);
        this.d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final void m(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof by) {
            by byVar = (by) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zznz = this.f4314a.zznz() + this.f4314a.zznr();
                    do {
                        byVar.b(this.f4314a.zzns());
                    } while (this.f4314a.zznz() < zznz);
                    d(zznz);
                    return;
                }
                throw zzrk.e();
            }
            do {
                byVar.b(this.f4314a.zzns());
                if (this.f4314a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f4314a.zzni();
                }
            } while (zzni2 == this.b);
            this.d = zzni2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zznz2 = this.f4314a.zznz() + this.f4314a.zznr();
                do {
                    list.add(Integer.valueOf(this.f4314a.zzns()));
                } while (this.f4314a.zznz() < zznz2);
                d(zznz2);
                return;
            }
            throw zzrk.e();
        }
        do {
            list.add(Integer.valueOf(this.f4314a.zzns()));
            if (this.f4314a.zzny()) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == this.b);
        this.d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final void n(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof by) {
            by byVar = (by) list;
            int i = this.b & 7;
            if (i == 2) {
                int zznr = this.f4314a.zznr();
                c(zznr);
                int zznz = this.f4314a.zznz() + zznr;
                do {
                    byVar.b(this.f4314a.zznt());
                } while (this.f4314a.zznz() < zznz);
                return;
            }
            if (i != 5) {
                throw zzrk.e();
            }
            do {
                byVar.b(this.f4314a.zznt());
                if (this.f4314a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f4314a.zzni();
                }
            } while (zzni2 == this.b);
            this.d = zzni2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 == 2) {
            int zznr2 = this.f4314a.zznr();
            c(zznr2);
            int zznz2 = this.f4314a.zznz() + zznr2;
            do {
                list.add(Integer.valueOf(this.f4314a.zznt()));
            } while (this.f4314a.zznz() < zznz2);
            return;
        }
        if (i2 != 5) {
            throw zzrk.e();
        }
        do {
            list.add(Integer.valueOf(this.f4314a.zznt()));
            if (this.f4314a.zzny()) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == this.b);
        this.d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final void o(List<Long> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof cg) {
            cg cgVar = (cg) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int zznr = this.f4314a.zznr();
                    b(zznr);
                    int zznz = this.f4314a.zznz() + zznr;
                    do {
                        cgVar.a(this.f4314a.zznu());
                    } while (this.f4314a.zznz() < zznz);
                    return;
                default:
                    throw zzrk.e();
            }
            do {
                cgVar.a(this.f4314a.zznu());
                if (this.f4314a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f4314a.zzni();
                }
            } while (zzni2 == this.b);
            this.d = zzni2;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int zznr2 = this.f4314a.zznr();
                b(zznr2);
                int zznz2 = this.f4314a.zznz() + zznr2;
                do {
                    list.add(Long.valueOf(this.f4314a.zznu()));
                } while (this.f4314a.zznz() < zznz2);
                return;
            default:
                throw zzrk.e();
        }
        do {
            list.add(Long.valueOf(this.f4314a.zznu()));
            if (this.f4314a.zzny()) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == this.b);
        this.d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final void p(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof by) {
            by byVar = (by) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zznz = this.f4314a.zznz() + this.f4314a.zznr();
                    do {
                        byVar.b(this.f4314a.zznv());
                    } while (this.f4314a.zznz() < zznz);
                    d(zznz);
                    return;
                }
                throw zzrk.e();
            }
            do {
                byVar.b(this.f4314a.zznv());
                if (this.f4314a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f4314a.zzni();
                }
            } while (zzni2 == this.b);
            this.d = zzni2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zznz2 = this.f4314a.zznz() + this.f4314a.zznr();
                do {
                    list.add(Integer.valueOf(this.f4314a.zznv()));
                } while (this.f4314a.zznz() < zznz2);
                d(zznz2);
                return;
            }
            throw zzrk.e();
        }
        do {
            list.add(Integer.valueOf(this.f4314a.zznv()));
            if (this.f4314a.zzny()) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == this.b);
        this.d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.cz
    public final void q(List<Long> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof cg) {
            cg cgVar = (cg) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zznz = this.f4314a.zznz() + this.f4314a.zznr();
                    do {
                        cgVar.a(this.f4314a.zznw());
                    } while (this.f4314a.zznz() < zznz);
                    d(zznz);
                    return;
                }
                throw zzrk.e();
            }
            do {
                cgVar.a(this.f4314a.zznw());
                if (this.f4314a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f4314a.zzni();
                }
            } while (zzni2 == this.b);
            this.d = zzni2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zznz2 = this.f4314a.zznz() + this.f4314a.zznr();
                do {
                    list.add(Long.valueOf(this.f4314a.zznw()));
                } while (this.f4314a.zznz() < zznz2);
                d(zznz2);
                return;
            }
            throw zzrk.e();
        }
        do {
            list.add(Long.valueOf(this.f4314a.zznw()));
            if (this.f4314a.zzny()) {
                return;
            } else {
                zzni = this.f4314a.zzni();
            }
        } while (zzni == this.b);
        this.d = zzni;
    }

    private static void b(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzrk.g();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0025. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.gtm.cz
    public final <K, V> void a(Map<K, V> map, ck<K, V> ckVar, zzqp zzqpVar) throws IOException {
        a(2);
        int zzaq = this.f4314a.zzaq(this.f4314a.zznr());
        Object obj = ckVar.b;
        Object obj2 = ckVar.d;
        while (true) {
            try {
                int a2 = a();
                if (a2 != Integer.MAX_VALUE && !this.f4314a.zzny()) {
                    switch (a2) {
                        case 1:
                            obj = a(ckVar.f4335a, (Class<?>) null, (zzqp) null);
                        case 2:
                            obj2 = a(ckVar.c, ckVar.d.getClass(), zzqpVar);
                        default:
                            try {
                            } catch (zzrl unused) {
                                if (!c()) {
                                    throw new zzrk("Unable to parse map entry.");
                                }
                            }
                            if (!c()) {
                                throw new zzrk("Unable to parse map entry.");
                                break;
                            }
                    }
                }
            } finally {
                this.f4314a.zzar(zzaq);
            }
        }
        map.put(obj, obj2);
    }

    private final Object a(zzug zzugVar, Class<?> cls, zzqp zzqpVar) throws IOException {
        switch (bk.f4315a[zzugVar.ordinal()]) {
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
                return c(cx.a().a((Class) cls), zzqpVar);
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
            throw zzrk.g();
        }
    }

    private final void d(int i) throws IOException {
        if (this.f4314a.zznz() != i) {
            throw zzrk.a();
        }
    }
}
