package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdmi;
import com.google.android.gms.internal.ads.zzdmj;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class zzdmi<MessageType extends zzdmi<MessageType, BuilderType>, BuilderType extends zzdmj<MessageType, BuilderType>> implements zzdpk {
    private static boolean zzhcg;
    protected int zzhcf = 0;

    @Override // com.google.android.gms.internal.ads.zzdpk
    public final zzdmr zzavf() {
        try {
            aew b = zzdmr.b(zzaxj());
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

    @Override // com.google.android.gms.internal.ads.zzdpk
    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzaxj()];
            zzdni zzab = zzdni.zzab(bArr);
            zzb(zzab);
            zzab.zzawv();
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
        zzdod.a(iterable);
        if (iterable instanceof zzdot) {
            List<?> zzayo = ((zzdot) iterable).zzayo();
            zzdot zzdotVar = (zzdot) list;
            int size = list.size();
            for (Object obj : zzayo) {
                if (obj == null) {
                    int size2 = zzdotVar.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size3 = zzdotVar.size() - 1; size3 >= size; size3--) {
                        zzdotVar.remove(size3);
                    }
                    throw new NullPointerException(sb2);
                }
                if (obj instanceof zzdmr) {
                    zzdotVar.zzdb((zzdmr) obj);
                } else {
                    zzdotVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof agr) {
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
