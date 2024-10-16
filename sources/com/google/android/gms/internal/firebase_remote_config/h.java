package com.google.android.gms.internal.firebase_remote_config;

import com.amazonaws.services.s3.internal.Constants;
import com.facebook.internal.ServerProtocol;
import com.uqm.crashsight.CrashSight;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class h extends zzba {

    /* renamed from: a, reason: collision with root package name */
    private final zzfj f4098a;
    private final zzbf b;
    private List<String> c = new ArrayList();
    private zzbg d;
    private String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(zzbf zzbfVar, zzfj zzfjVar) {
        this.b = zzbfVar;
        this.f4098a = zzfjVar;
        zzfjVar.setLenient(true);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzba
    public final void close() throws IOException {
        this.f4098a.close();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzba
    public final String zzbb() {
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.get(r0.size() - 1);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzba
    public final zzbg zzba() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzba
    public final zzaw zzay() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzba
    public final byte zzbd() {
        a();
        return Byte.parseByte(this.e);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzba
    public final short zzbe() {
        a();
        return Short.parseShort(this.e);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzba
    public final int getIntValue() {
        a();
        return Integer.parseInt(this.e);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzba
    public final float zzbf() {
        a();
        return Float.parseFloat(this.e);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzba
    public final BigInteger zzbi() {
        a();
        return new BigInteger(this.e);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzba
    public final BigDecimal zzbj() {
        a();
        return new BigDecimal(this.e);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzba
    public final double zzbh() {
        a();
        return Double.parseDouble(this.e);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzba
    public final long zzbg() {
        a();
        return Long.parseLong(this.e);
    }

    private final void a() {
        if (!(this.d == zzbg.VALUE_NUMBER_INT || this.d == zzbg.VALUE_NUMBER_FLOAT)) {
            throw new IllegalArgumentException();
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzba
    public final String getText() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzba
    public final zzbg zzaz() throws IOException {
        zzfl zzflVar;
        if (this.d != null) {
            switch (g.f4097a[this.d.ordinal()]) {
                case 1:
                    this.f4098a.beginArray();
                    this.c.add(null);
                    break;
                case 2:
                    this.f4098a.beginObject();
                    this.c.add(null);
                    break;
            }
        }
        try {
            zzflVar = this.f4098a.zzdy();
        } catch (EOFException unused) {
            zzflVar = zzfl.END_DOCUMENT;
        }
        switch (g.b[zzflVar.ordinal()]) {
            case 1:
                this.e = "[";
                this.d = zzbg.START_ARRAY;
                break;
            case 2:
                this.e = "]";
                this.d = zzbg.END_ARRAY;
                this.c.remove(r0.size() - 1);
                this.f4098a.endArray();
                break;
            case 3:
                this.e = "{";
                this.d = zzbg.START_OBJECT;
                break;
            case 4:
                this.e = "}";
                this.d = zzbg.END_OBJECT;
                this.c.remove(r0.size() - 1);
                this.f4098a.endObject();
                break;
            case 5:
                if (this.f4098a.nextBoolean()) {
                    this.e = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
                    this.d = zzbg.VALUE_TRUE;
                    break;
                } else {
                    this.e = CrashSight.SDK_IS_DEV;
                    this.d = zzbg.VALUE_FALSE;
                    break;
                }
            case 6:
                this.e = Constants.NULL_VERSION_ID;
                this.d = zzbg.VALUE_NULL;
                this.f4098a.nextNull();
                break;
            case 7:
                this.e = this.f4098a.nextString();
                this.d = zzbg.VALUE_STRING;
                break;
            case 8:
                this.e = this.f4098a.nextString();
                this.d = this.e.indexOf(46) == -1 ? zzbg.VALUE_NUMBER_INT : zzbg.VALUE_NUMBER_FLOAT;
                break;
            case 9:
                this.e = this.f4098a.nextName();
                this.d = zzbg.FIELD_NAME;
                this.c.set(r0.size() - 1, this.e);
                break;
            default:
                this.e = null;
                this.d = null;
                break;
        }
        return this.d;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.firebase_remote_config.zzba
    public final zzba zzbc() throws IOException {
        if (this.d != null) {
            switch (g.f4097a[this.d.ordinal()]) {
                case 1:
                    this.f4098a.skipValue();
                    this.e = "]";
                    this.d = zzbg.END_ARRAY;
                    break;
                case 2:
                    this.f4098a.skipValue();
                    this.e = "}";
                    this.d = zzbg.END_OBJECT;
                    break;
            }
        }
        return this;
    }
}
