package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class zzdsu implements zzbe, Closeable, Iterator<zzbd> {
    private static final zzbd f = new ain("eof ");
    private static zzdtc g = zzdtc.zzm(zzdsu.class);

    /* renamed from: a, reason: collision with root package name */
    protected zzba f3613a;
    protected zzdsw b;
    private zzbd h = null;
    long c = 0;
    long d = 0;
    long e = 0;
    private List<zzbd> i = new ArrayList();

    public final List<zzbd> zzbbd() {
        if (this.b != null && this.h != f) {
            return new zzdta(this.i, this);
        }
        return this.i;
    }

    public void zza(zzdsw zzdswVar, long j, zzba zzbaVar) throws IOException {
        this.b = zzdswVar;
        long position = zzdswVar.position();
        this.d = position;
        this.c = position;
        zzdswVar.zzff(zzdswVar.position() + j);
        this.e = zzdswVar.position();
        this.f3613a = zzbaVar;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        zzbd zzbdVar = this.h;
        if (zzbdVar == f) {
            return false;
        }
        if (zzbdVar != null) {
            return true;
        }
        try {
            this.h = (zzbd) next();
            return true;
        } catch (NoSuchElementException unused) {
            this.h = f;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzbd next() {
        zzbd zza;
        zzbd zzbdVar = this.h;
        if (zzbdVar != null && zzbdVar != f) {
            this.h = null;
            return zzbdVar;
        }
        zzdsw zzdswVar = this.b;
        if (zzdswVar == null || this.c >= this.e) {
            this.h = f;
            throw new NoSuchElementException();
        }
        try {
            synchronized (zzdswVar) {
                this.b.zzff(this.c);
                zza = this.f3613a.zza(this.b, this);
                this.c = this.b.position();
            }
            return zza;
        } catch (EOFException unused) {
            throw new NoSuchElementException();
        } catch (IOException unused2) {
            throw new NoSuchElementException();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.i.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.i.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public void close() throws IOException {
        this.b.close();
    }
}
