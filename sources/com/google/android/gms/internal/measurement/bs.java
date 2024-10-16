package com.google.android.gms.internal.measurement;

import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bs implements dm {

    /* renamed from: a, reason: collision with root package name */
    private final zzeb f4490a;
    private int b;
    private int c;
    private int d = 0;

    public static bs a(zzeb zzebVar) {
        if (zzebVar.c != null) {
            return zzebVar.c;
        }
        return new bs(zzebVar);
    }

    private bs(zzeb zzebVar) {
        this.f4490a = (zzeb) zzez.a(zzebVar, EvaluateItemInfo.ACTIONTYPE_INPUT);
        this.f4490a.c = this;
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final int a() throws IOException {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.f4490a.zzsg();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final boolean c() throws IOException {
        int i;
        if (this.f4490a.zzsw() || (i = this.b) == this.c) {
            return false;
        }
        return this.f4490a.zzau(i);
    }

    private final void a(int i) throws IOException {
        if ((this.b & 7) != i) {
            throw zzfi.f();
        }
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final double d() throws IOException {
        a(1);
        return this.f4490a.readDouble();
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final float e() throws IOException {
        a(5);
        return this.f4490a.readFloat();
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final long f() throws IOException {
        a(0);
        return this.f4490a.zzsh();
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final long g() throws IOException {
        a(0);
        return this.f4490a.zzsi();
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final int h() throws IOException {
        a(0);
        return this.f4490a.zzsj();
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final long i() throws IOException {
        a(1);
        return this.f4490a.zzsk();
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final int j() throws IOException {
        a(5);
        return this.f4490a.zzsl();
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final boolean k() throws IOException {
        a(0);
        return this.f4490a.zzsm();
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final String l() throws IOException {
        a(2);
        return this.f4490a.readString();
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final String m() throws IOException {
        a(2);
        return this.f4490a.zzsn();
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final <T> T a(dl<T> dlVar, zzel zzelVar) throws IOException {
        a(2);
        return (T) c(dlVar, zzelVar);
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final <T> T b(dl<T> dlVar, zzel zzelVar) throws IOException {
        a(3);
        return (T) d(dlVar, zzelVar);
    }

    private final <T> T c(dl<T> dlVar, zzel zzelVar) throws IOException {
        int zzsp = this.f4490a.zzsp();
        if (this.f4490a.f4553a >= this.f4490a.b) {
            throw zzfi.g();
        }
        int zzaw = this.f4490a.zzaw(zzsp);
        T a2 = dlVar.a();
        this.f4490a.f4553a++;
        dlVar.a(a2, this, zzelVar);
        dlVar.c(a2);
        this.f4490a.zzat(0);
        zzeb zzebVar = this.f4490a;
        zzebVar.f4553a--;
        this.f4490a.zzax(zzaw);
        return a2;
    }

    private final <T> T d(dl<T> dlVar, zzel zzelVar) throws IOException {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            T a2 = dlVar.a();
            dlVar.a(a2, this, zzelVar);
            dlVar.c(a2);
            if (this.b == this.c) {
                return a2;
            }
            throw zzfi.h();
        } finally {
            this.c = i;
        }
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final zzdp n() throws IOException {
        a(2);
        return this.f4490a.zzso();
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final int o() throws IOException {
        a(0);
        return this.f4490a.zzsp();
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final int p() throws IOException {
        a(0);
        return this.f4490a.zzsq();
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final int q() throws IOException {
        a(5);
        return this.f4490a.zzsr();
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final long r() throws IOException {
        a(1);
        return this.f4490a.zzss();
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final int s() throws IOException {
        a(0);
        return this.f4490a.zzst();
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final long t() throws IOException {
        a(0);
        return this.f4490a.zzsu();
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final void a(List<Double> list) throws IOException {
        int zzsg;
        int zzsg2;
        if (list instanceof bw) {
            bw bwVar = (bw) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int zzsp = this.f4490a.zzsp();
                    b(zzsp);
                    int zzsx = this.f4490a.zzsx() + zzsp;
                    do {
                        bwVar.a(this.f4490a.readDouble());
                    } while (this.f4490a.zzsx() < zzsx);
                    return;
                default:
                    throw zzfi.f();
            }
            do {
                bwVar.a(this.f4490a.readDouble());
                if (this.f4490a.zzsw()) {
                    return;
                } else {
                    zzsg2 = this.f4490a.zzsg();
                }
            } while (zzsg2 == this.b);
            this.d = zzsg2;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int zzsp2 = this.f4490a.zzsp();
                b(zzsp2);
                int zzsx2 = this.f4490a.zzsx() + zzsp2;
                do {
                    list.add(Double.valueOf(this.f4490a.readDouble()));
                } while (this.f4490a.zzsx() < zzsx2);
                return;
            default:
                throw zzfi.f();
        }
        do {
            list.add(Double.valueOf(this.f4490a.readDouble()));
            if (this.f4490a.zzsw()) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == this.b);
        this.d = zzsg;
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final void b(List<Float> list) throws IOException {
        int zzsg;
        int zzsg2;
        if (list instanceof cf) {
            cf cfVar = (cf) list;
            int i = this.b & 7;
            if (i == 2) {
                int zzsp = this.f4490a.zzsp();
                c(zzsp);
                int zzsx = this.f4490a.zzsx() + zzsp;
                do {
                    cfVar.a(this.f4490a.readFloat());
                } while (this.f4490a.zzsx() < zzsx);
                return;
            }
            if (i != 5) {
                throw zzfi.f();
            }
            do {
                cfVar.a(this.f4490a.readFloat());
                if (this.f4490a.zzsw()) {
                    return;
                } else {
                    zzsg2 = this.f4490a.zzsg();
                }
            } while (zzsg2 == this.b);
            this.d = zzsg2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 == 2) {
            int zzsp2 = this.f4490a.zzsp();
            c(zzsp2);
            int zzsx2 = this.f4490a.zzsx() + zzsp2;
            do {
                list.add(Float.valueOf(this.f4490a.readFloat()));
            } while (this.f4490a.zzsx() < zzsx2);
            return;
        }
        if (i2 != 5) {
            throw zzfi.f();
        }
        do {
            list.add(Float.valueOf(this.f4490a.readFloat()));
            if (this.f4490a.zzsw()) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == this.b);
        this.d = zzsg;
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final void c(List<Long> list) throws IOException {
        int zzsg;
        int zzsg2;
        if (list instanceof cr) {
            cr crVar = (cr) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzsx = this.f4490a.zzsx() + this.f4490a.zzsp();
                    do {
                        crVar.zzby(this.f4490a.zzsh());
                    } while (this.f4490a.zzsx() < zzsx);
                    d(zzsx);
                    return;
                }
                throw zzfi.f();
            }
            do {
                crVar.zzby(this.f4490a.zzsh());
                if (this.f4490a.zzsw()) {
                    return;
                } else {
                    zzsg2 = this.f4490a.zzsg();
                }
            } while (zzsg2 == this.b);
            this.d = zzsg2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzsx2 = this.f4490a.zzsx() + this.f4490a.zzsp();
                do {
                    list.add(Long.valueOf(this.f4490a.zzsh()));
                } while (this.f4490a.zzsx() < zzsx2);
                d(zzsx2);
                return;
            }
            throw zzfi.f();
        }
        do {
            list.add(Long.valueOf(this.f4490a.zzsh()));
            if (this.f4490a.zzsw()) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == this.b);
        this.d = zzsg;
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final void d(List<Long> list) throws IOException {
        int zzsg;
        int zzsg2;
        if (list instanceof cr) {
            cr crVar = (cr) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzsx = this.f4490a.zzsx() + this.f4490a.zzsp();
                    do {
                        crVar.zzby(this.f4490a.zzsi());
                    } while (this.f4490a.zzsx() < zzsx);
                    d(zzsx);
                    return;
                }
                throw zzfi.f();
            }
            do {
                crVar.zzby(this.f4490a.zzsi());
                if (this.f4490a.zzsw()) {
                    return;
                } else {
                    zzsg2 = this.f4490a.zzsg();
                }
            } while (zzsg2 == this.b);
            this.d = zzsg2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzsx2 = this.f4490a.zzsx() + this.f4490a.zzsp();
                do {
                    list.add(Long.valueOf(this.f4490a.zzsi()));
                } while (this.f4490a.zzsx() < zzsx2);
                d(zzsx2);
                return;
            }
            throw zzfi.f();
        }
        do {
            list.add(Long.valueOf(this.f4490a.zzsi()));
            if (this.f4490a.zzsw()) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == this.b);
        this.d = zzsg;
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final void e(List<Integer> list) throws IOException {
        int zzsg;
        int zzsg2;
        if (list instanceof ci) {
            ci ciVar = (ci) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzsx = this.f4490a.zzsx() + this.f4490a.zzsp();
                    do {
                        ciVar.b(this.f4490a.zzsj());
                    } while (this.f4490a.zzsx() < zzsx);
                    d(zzsx);
                    return;
                }
                throw zzfi.f();
            }
            do {
                ciVar.b(this.f4490a.zzsj());
                if (this.f4490a.zzsw()) {
                    return;
                } else {
                    zzsg2 = this.f4490a.zzsg();
                }
            } while (zzsg2 == this.b);
            this.d = zzsg2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzsx2 = this.f4490a.zzsx() + this.f4490a.zzsp();
                do {
                    list.add(Integer.valueOf(this.f4490a.zzsj()));
                } while (this.f4490a.zzsx() < zzsx2);
                d(zzsx2);
                return;
            }
            throw zzfi.f();
        }
        do {
            list.add(Integer.valueOf(this.f4490a.zzsj()));
            if (this.f4490a.zzsw()) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == this.b);
        this.d = zzsg;
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final void f(List<Long> list) throws IOException {
        int zzsg;
        int zzsg2;
        if (list instanceof cr) {
            cr crVar = (cr) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int zzsp = this.f4490a.zzsp();
                    b(zzsp);
                    int zzsx = this.f4490a.zzsx() + zzsp;
                    do {
                        crVar.zzby(this.f4490a.zzsk());
                    } while (this.f4490a.zzsx() < zzsx);
                    return;
                default:
                    throw zzfi.f();
            }
            do {
                crVar.zzby(this.f4490a.zzsk());
                if (this.f4490a.zzsw()) {
                    return;
                } else {
                    zzsg2 = this.f4490a.zzsg();
                }
            } while (zzsg2 == this.b);
            this.d = zzsg2;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int zzsp2 = this.f4490a.zzsp();
                b(zzsp2);
                int zzsx2 = this.f4490a.zzsx() + zzsp2;
                do {
                    list.add(Long.valueOf(this.f4490a.zzsk()));
                } while (this.f4490a.zzsx() < zzsx2);
                return;
            default:
                throw zzfi.f();
        }
        do {
            list.add(Long.valueOf(this.f4490a.zzsk()));
            if (this.f4490a.zzsw()) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == this.b);
        this.d = zzsg;
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final void g(List<Integer> list) throws IOException {
        int zzsg;
        int zzsg2;
        if (list instanceof ci) {
            ci ciVar = (ci) list;
            int i = this.b & 7;
            if (i == 2) {
                int zzsp = this.f4490a.zzsp();
                c(zzsp);
                int zzsx = this.f4490a.zzsx() + zzsp;
                do {
                    ciVar.b(this.f4490a.zzsl());
                } while (this.f4490a.zzsx() < zzsx);
                return;
            }
            if (i != 5) {
                throw zzfi.f();
            }
            do {
                ciVar.b(this.f4490a.zzsl());
                if (this.f4490a.zzsw()) {
                    return;
                } else {
                    zzsg2 = this.f4490a.zzsg();
                }
            } while (zzsg2 == this.b);
            this.d = zzsg2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 == 2) {
            int zzsp2 = this.f4490a.zzsp();
            c(zzsp2);
            int zzsx2 = this.f4490a.zzsx() + zzsp2;
            do {
                list.add(Integer.valueOf(this.f4490a.zzsl()));
            } while (this.f4490a.zzsx() < zzsx2);
            return;
        }
        if (i2 != 5) {
            throw zzfi.f();
        }
        do {
            list.add(Integer.valueOf(this.f4490a.zzsl()));
            if (this.f4490a.zzsw()) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == this.b);
        this.d = zzsg;
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final void h(List<Boolean> list) throws IOException {
        int zzsg;
        int zzsg2;
        if (list instanceof bj) {
            bj bjVar = (bj) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzsx = this.f4490a.zzsx() + this.f4490a.zzsp();
                    do {
                        bjVar.a(this.f4490a.zzsm());
                    } while (this.f4490a.zzsx() < zzsx);
                    d(zzsx);
                    return;
                }
                throw zzfi.f();
            }
            do {
                bjVar.a(this.f4490a.zzsm());
                if (this.f4490a.zzsw()) {
                    return;
                } else {
                    zzsg2 = this.f4490a.zzsg();
                }
            } while (zzsg2 == this.b);
            this.d = zzsg2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzsx2 = this.f4490a.zzsx() + this.f4490a.zzsp();
                do {
                    list.add(Boolean.valueOf(this.f4490a.zzsm()));
                } while (this.f4490a.zzsx() < zzsx2);
                d(zzsx2);
                return;
            }
            throw zzfi.f();
        }
        do {
            list.add(Boolean.valueOf(this.f4490a.zzsm()));
            if (this.f4490a.zzsw()) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == this.b);
        this.d = zzsg;
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final void i(List<String> list) throws IOException {
        a(list, false);
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final void j(List<String> list) throws IOException {
        a(list, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void a(List<String> list, boolean z) throws IOException {
        int zzsg;
        int zzsg2;
        if ((this.b & 7) != 2) {
            throw zzfi.f();
        }
        if ((list instanceof zzfp) && !z) {
            zzfp zzfpVar = (zzfp) list;
            do {
                zzfpVar.zzc(n());
                if (this.f4490a.zzsw()) {
                    return;
                } else {
                    zzsg2 = this.f4490a.zzsg();
                }
            } while (zzsg2 == this.b);
            this.d = zzsg2;
            return;
        }
        do {
            list.add(z ? m() : l());
            if (this.f4490a.zzsw()) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == this.b);
        this.d = zzsg;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.dm
    public final <T> void a(List<T> list, dl<T> dlVar, zzel zzelVar) throws IOException {
        int zzsg;
        int i = this.b;
        if ((i & 7) != 2) {
            throw zzfi.f();
        }
        do {
            list.add(c(dlVar, zzelVar));
            if (this.f4490a.zzsw() || this.d != 0) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == i);
        this.d = zzsg;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.dm
    public final <T> void b(List<T> list, dl<T> dlVar, zzel zzelVar) throws IOException {
        int zzsg;
        int i = this.b;
        if ((i & 7) != 3) {
            throw zzfi.f();
        }
        do {
            list.add(d(dlVar, zzelVar));
            if (this.f4490a.zzsw() || this.d != 0) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == i);
        this.d = zzsg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.dm
    public final void k(List<zzdp> list) throws IOException {
        int zzsg;
        if ((this.b & 7) != 2) {
            throw zzfi.f();
        }
        do {
            list.add(n());
            if (this.f4490a.zzsw()) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == this.b);
        this.d = zzsg;
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final void l(List<Integer> list) throws IOException {
        int zzsg;
        int zzsg2;
        if (list instanceof ci) {
            ci ciVar = (ci) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzsx = this.f4490a.zzsx() + this.f4490a.zzsp();
                    do {
                        ciVar.b(this.f4490a.zzsp());
                    } while (this.f4490a.zzsx() < zzsx);
                    d(zzsx);
                    return;
                }
                throw zzfi.f();
            }
            do {
                ciVar.b(this.f4490a.zzsp());
                if (this.f4490a.zzsw()) {
                    return;
                } else {
                    zzsg2 = this.f4490a.zzsg();
                }
            } while (zzsg2 == this.b);
            this.d = zzsg2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzsx2 = this.f4490a.zzsx() + this.f4490a.zzsp();
                do {
                    list.add(Integer.valueOf(this.f4490a.zzsp()));
                } while (this.f4490a.zzsx() < zzsx2);
                d(zzsx2);
                return;
            }
            throw zzfi.f();
        }
        do {
            list.add(Integer.valueOf(this.f4490a.zzsp()));
            if (this.f4490a.zzsw()) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == this.b);
        this.d = zzsg;
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final void m(List<Integer> list) throws IOException {
        int zzsg;
        int zzsg2;
        if (list instanceof ci) {
            ci ciVar = (ci) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzsx = this.f4490a.zzsx() + this.f4490a.zzsp();
                    do {
                        ciVar.b(this.f4490a.zzsq());
                    } while (this.f4490a.zzsx() < zzsx);
                    d(zzsx);
                    return;
                }
                throw zzfi.f();
            }
            do {
                ciVar.b(this.f4490a.zzsq());
                if (this.f4490a.zzsw()) {
                    return;
                } else {
                    zzsg2 = this.f4490a.zzsg();
                }
            } while (zzsg2 == this.b);
            this.d = zzsg2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzsx2 = this.f4490a.zzsx() + this.f4490a.zzsp();
                do {
                    list.add(Integer.valueOf(this.f4490a.zzsq()));
                } while (this.f4490a.zzsx() < zzsx2);
                d(zzsx2);
                return;
            }
            throw zzfi.f();
        }
        do {
            list.add(Integer.valueOf(this.f4490a.zzsq()));
            if (this.f4490a.zzsw()) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == this.b);
        this.d = zzsg;
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final void n(List<Integer> list) throws IOException {
        int zzsg;
        int zzsg2;
        if (list instanceof ci) {
            ci ciVar = (ci) list;
            int i = this.b & 7;
            if (i == 2) {
                int zzsp = this.f4490a.zzsp();
                c(zzsp);
                int zzsx = this.f4490a.zzsx() + zzsp;
                do {
                    ciVar.b(this.f4490a.zzsr());
                } while (this.f4490a.zzsx() < zzsx);
                return;
            }
            if (i != 5) {
                throw zzfi.f();
            }
            do {
                ciVar.b(this.f4490a.zzsr());
                if (this.f4490a.zzsw()) {
                    return;
                } else {
                    zzsg2 = this.f4490a.zzsg();
                }
            } while (zzsg2 == this.b);
            this.d = zzsg2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 == 2) {
            int zzsp2 = this.f4490a.zzsp();
            c(zzsp2);
            int zzsx2 = this.f4490a.zzsx() + zzsp2;
            do {
                list.add(Integer.valueOf(this.f4490a.zzsr()));
            } while (this.f4490a.zzsx() < zzsx2);
            return;
        }
        if (i2 != 5) {
            throw zzfi.f();
        }
        do {
            list.add(Integer.valueOf(this.f4490a.zzsr()));
            if (this.f4490a.zzsw()) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == this.b);
        this.d = zzsg;
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final void o(List<Long> list) throws IOException {
        int zzsg;
        int zzsg2;
        if (list instanceof cr) {
            cr crVar = (cr) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int zzsp = this.f4490a.zzsp();
                    b(zzsp);
                    int zzsx = this.f4490a.zzsx() + zzsp;
                    do {
                        crVar.zzby(this.f4490a.zzss());
                    } while (this.f4490a.zzsx() < zzsx);
                    return;
                default:
                    throw zzfi.f();
            }
            do {
                crVar.zzby(this.f4490a.zzss());
                if (this.f4490a.zzsw()) {
                    return;
                } else {
                    zzsg2 = this.f4490a.zzsg();
                }
            } while (zzsg2 == this.b);
            this.d = zzsg2;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int zzsp2 = this.f4490a.zzsp();
                b(zzsp2);
                int zzsx2 = this.f4490a.zzsx() + zzsp2;
                do {
                    list.add(Long.valueOf(this.f4490a.zzss()));
                } while (this.f4490a.zzsx() < zzsx2);
                return;
            default:
                throw zzfi.f();
        }
        do {
            list.add(Long.valueOf(this.f4490a.zzss()));
            if (this.f4490a.zzsw()) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == this.b);
        this.d = zzsg;
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final void p(List<Integer> list) throws IOException {
        int zzsg;
        int zzsg2;
        if (list instanceof ci) {
            ci ciVar = (ci) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzsx = this.f4490a.zzsx() + this.f4490a.zzsp();
                    do {
                        ciVar.b(this.f4490a.zzst());
                    } while (this.f4490a.zzsx() < zzsx);
                    d(zzsx);
                    return;
                }
                throw zzfi.f();
            }
            do {
                ciVar.b(this.f4490a.zzst());
                if (this.f4490a.zzsw()) {
                    return;
                } else {
                    zzsg2 = this.f4490a.zzsg();
                }
            } while (zzsg2 == this.b);
            this.d = zzsg2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzsx2 = this.f4490a.zzsx() + this.f4490a.zzsp();
                do {
                    list.add(Integer.valueOf(this.f4490a.zzst()));
                } while (this.f4490a.zzsx() < zzsx2);
                d(zzsx2);
                return;
            }
            throw zzfi.f();
        }
        do {
            list.add(Integer.valueOf(this.f4490a.zzst()));
            if (this.f4490a.zzsw()) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == this.b);
        this.d = zzsg;
    }

    @Override // com.google.android.gms.internal.measurement.dm
    public final void q(List<Long> list) throws IOException {
        int zzsg;
        int zzsg2;
        if (list instanceof cr) {
            cr crVar = (cr) list;
            int i = this.b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzsx = this.f4490a.zzsx() + this.f4490a.zzsp();
                    do {
                        crVar.zzby(this.f4490a.zzsu());
                    } while (this.f4490a.zzsx() < zzsx);
                    d(zzsx);
                    return;
                }
                throw zzfi.f();
            }
            do {
                crVar.zzby(this.f4490a.zzsu());
                if (this.f4490a.zzsw()) {
                    return;
                } else {
                    zzsg2 = this.f4490a.zzsg();
                }
            } while (zzsg2 == this.b);
            this.d = zzsg2;
            return;
        }
        int i2 = this.b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzsx2 = this.f4490a.zzsx() + this.f4490a.zzsp();
                do {
                    list.add(Long.valueOf(this.f4490a.zzsu()));
                } while (this.f4490a.zzsx() < zzsx2);
                d(zzsx2);
                return;
            }
            throw zzfi.f();
        }
        do {
            list.add(Long.valueOf(this.f4490a.zzsu()));
            if (this.f4490a.zzsw()) {
                return;
            } else {
                zzsg = this.f4490a.zzsg();
            }
        } while (zzsg == this.b);
        this.d = zzsg;
    }

    private static void b(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzfi.h();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0025. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.dm
    public final <K, V> void a(Map<K, V> map, cu<K, V> cuVar, zzel zzelVar) throws IOException {
        a(2);
        int zzaw = this.f4490a.zzaw(this.f4490a.zzsp());
        Object obj = cuVar.b;
        Object obj2 = cuVar.d;
        while (true) {
            try {
                int a2 = a();
                if (a2 != Integer.MAX_VALUE && !this.f4490a.zzsw()) {
                    switch (a2) {
                        case 1:
                            obj = a(cuVar.f4510a, (Class<?>) null, (zzel) null);
                        case 2:
                            obj2 = a(cuVar.c, cuVar.d.getClass(), zzelVar);
                        default:
                            try {
                            } catch (zzfh unused) {
                                if (!c()) {
                                    throw new zzfi("Unable to parse map entry.");
                                }
                            }
                            if (!c()) {
                                throw new zzfi("Unable to parse map entry.");
                                break;
                            }
                    }
                }
            } finally {
                this.f4490a.zzax(zzaw);
            }
        }
        map.put(obj, obj2);
    }

    private final Object a(zzig zzigVar, Class<?> cls, zzel zzelVar) throws IOException {
        switch (bu.f4491a[zzigVar.ordinal()]) {
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
                return c(dh.a().a((Class) cls), zzelVar);
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
            throw zzfi.h();
        }
    }

    private final void d(int i) throws IOException {
        if (this.f4490a.zzsx() != i) {
            throw zzfi.a();
        }
    }
}
