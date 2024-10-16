package com.google.android.gms.internal.ads;

import com.helpshift.db.conversation.tables.ConversationTable;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class zzay implements zzba {

    /* renamed from: a, reason: collision with root package name */
    private static Logger f2825a = Logger.getLogger(zzay.class.getName());
    private ThreadLocal<ByteBuffer> b = new gi(this);

    public abstract zzbd zza(String str, byte[] bArr, String str2);

    @Override // com.google.android.gms.internal.ads.zzba
    public final zzbd zza(zzdsw zzdswVar, zzbe zzbeVar) throws IOException {
        int read;
        long size;
        long j;
        long position = zzdswVar.position();
        this.b.get().rewind().limit(8);
        do {
            read = zzdswVar.read(this.b.get());
            if (read == 8) {
                this.b.get().rewind();
                long zza = zzbc.zza(this.b.get());
                byte[] bArr = null;
                if (zza < 8 && zza > 1) {
                    Logger logger = f2825a;
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(zza);
                    sb.append("). Stop parsing!");
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
                String zzf = zzbc.zzf(this.b.get());
                if (zza == 1) {
                    this.b.get().limit(16);
                    zzdswVar.read(this.b.get());
                    this.b.get().position(8);
                    size = zzbc.zzc(this.b.get()) - 16;
                } else {
                    size = zza == 0 ? zzdswVar.size() - zzdswVar.position() : zza - 8;
                }
                if (ConversationTable.Columns.LOCAL_UUID.equals(zzf)) {
                    this.b.get().limit(this.b.get().limit() + 16);
                    zzdswVar.read(this.b.get());
                    bArr = new byte[16];
                    for (int position2 = this.b.get().position() - 16; position2 < this.b.get().position(); position2++) {
                        bArr[position2 - (this.b.get().position() - 16)] = this.b.get().get(position2);
                    }
                    j = size - 16;
                } else {
                    j = size;
                }
                zzbd zza2 = zza(zzf, bArr, zzbeVar instanceof zzbd ? ((zzbd) zzbeVar).getType() : "");
                zza2.zza(zzbeVar);
                this.b.get().rewind();
                zza2.zza(zzdswVar, this.b.get(), j, this);
                return zza2;
            }
        } while (read >= 0);
        zzdswVar.zzff(position);
        throw new EOFException();
    }
}
