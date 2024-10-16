package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzdh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class zzdf<MessageType extends zzdf<MessageType, BuilderType>, BuilderType extends zzdh<MessageType, BuilderType>> implements zzgi {
    private static boolean zzacu;
    protected int zzact = 0;

    @Override // com.google.android.gms.internal.measurement.zzgi
    public final zzdp zzrs() {
        try {
            bp b = zzdp.b(zzuk());
            zzb(b.b());
            return b.a();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("ByteString").length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzuk()];
            zzee zzf = zzee.zzf(bArr);
            zzb(zzf);
            zzf.zzth();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("byte array").length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> void a(Iterable<T> iterable, List<? super T> list) {
        zzez.a(iterable);
        if (iterable instanceof zzfp) {
            List<?> zzvf = ((zzfp) iterable).zzvf();
            zzfp zzfpVar = (zzfp) list;
            int size = list.size();
            for (Object obj : zzvf) {
                if (obj == null) {
                    int size2 = zzfpVar.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size3 = zzfpVar.size() - 1; size3 >= size; size3--) {
                        zzfpVar.remove(size3);
                    }
                    throw new NullPointerException(sb2);
                }
                if (obj instanceof zzdp) {
                    zzfpVar.zzc((zzdp) obj);
                } else {
                    zzfpVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof di) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size4 = list.size();
        for (T t : iterable) {
            if (t == null) {
                int size5 = list.size() - size4;
                StringBuilder sb3 = new StringBuilder(37);
                sb3.append("Element at index ");
                sb3.append(size5);
                sb3.append(" is null.");
                String sb4 = sb3.toString();
                for (int size6 = list.size() - 1; size6 >= size4; size6--) {
                    list.remove(size6);
                }
                throw new NullPointerException(sb4);
            }
            list.add(t);
        }
    }
}
