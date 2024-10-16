package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import com.google.android.gms.internal.zzcuu;
import com.google.android.gms.internal.zzcuz;
import com.google.android.gms.nearby.messages.internal.zzad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes2.dex */
public class MessageFilter extends zzbgl {
    public static final Parcelable.Creator<MessageFilter> CREATOR = new zzc();
    public static final MessageFilter INCLUDE_ALL_MY_TYPES = new Builder().includeAllMyTypes().build();

    /* renamed from: a, reason: collision with root package name */
    private int f4981a;
    private final List<zzad> b;
    private final List<zzcuz> c;
    private final boolean d;
    private final List<zzcuu> e;
    private final int f;

    /* loaded from: classes2.dex */
    public static final class Builder {
        private boolean d;

        /* renamed from: a, reason: collision with root package name */
        private final Set<zzad> f4982a = new HashSet();
        private final List<zzcuz> b = new ArrayList();
        private final Set<zzcuu> c = new HashSet();
        private int e = 0;

        private final Builder a(String str, String str2) {
            this.f4982a.add(new zzad(str, str2));
            return this;
        }

        public final MessageFilter build() {
            zzbq.zza(this.d || !this.f4982a.isEmpty(), "At least one of the include methods must be called.");
            return new MessageFilter(new ArrayList(this.f4982a), this.b, this.d, new ArrayList(this.c), this.e);
        }

        public final Builder includeAllMyTypes() {
            this.d = true;
            return this;
        }

        public final Builder includeAudioBytes(int i) {
            zzbq.checkArgument(this.e == 0, "includeAudioBytes() can only be called once per MessageFilter instance.");
            boolean z = i > 0;
            StringBuilder sb = new StringBuilder(44);
            sb.append("Invalid value for numAudioBytes: ");
            sb.append(i);
            zzbq.checkArgument(z, sb.toString());
            zzbq.checkArgument(i <= 10, "numAudioBytes is capped by AudioBytes.MAX_SIZE = 10");
            a(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_AUDIO_BYTES);
            this.e = i;
            return this;
        }

        public final Builder includeEddystoneUids(String str, String str2) {
            a(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_EDDYSTONE_UID);
            this.b.add(zzcuz.zzau(str, str2));
            return this;
        }

        public final Builder includeFilter(MessageFilter messageFilter) {
            this.f4982a.addAll(messageFilter.zzbdq());
            this.b.addAll(messageFilter.a());
            this.c.addAll(messageFilter.zzbdt());
            this.d = messageFilter.zzbdr() | this.d;
            return this;
        }

        public final Builder includeIBeaconIds(UUID uuid, Short sh, Short sh2) {
            a(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_I_BEACON_ID);
            this.b.add(zzcuz.zza(uuid, sh, sh2));
            return this;
        }

        public final Builder includeNamespacedType(String str, String str2) {
            zzbq.zzb((str == null || str.isEmpty() || str.contains("*")) ? false : true, "namespace(%s) cannot be null, empty or contain (*).", new Object[]{str});
            zzbq.zzb((str2 == null || str2.contains("*")) ? false : true, "type(%s) cannot be null or contain (*).", new Object[]{str2});
            return a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageFilter(int i, List<zzad> list, List<zzcuz> list2, boolean z, List<zzcuu> list3, int i2) {
        this.f4981a = i;
        this.b = Collections.unmodifiableList((List) zzbq.checkNotNull(list));
        this.d = z;
        this.c = Collections.unmodifiableList(list2 == null ? Collections.emptyList() : list2);
        this.e = Collections.unmodifiableList(list3 == null ? Collections.emptyList() : list3);
        this.f = i2;
    }

    private MessageFilter(List<zzad> list, List<zzcuz> list2, boolean z, List<zzcuu> list3, int i) {
        this(2, list, list2, z, list3, i);
    }

    @Hide
    final List<zzcuz> a() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageFilter)) {
            return false;
        }
        MessageFilter messageFilter = (MessageFilter) obj;
        return this.d == messageFilter.d && zzbg.equal(this.b, messageFilter.b) && zzbg.equal(this.c, messageFilter.c) && zzbg.equal(this.e, messageFilter.e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, Boolean.valueOf(this.d), this.e});
    }

    public String toString() {
        boolean z = this.d;
        String valueOf = String.valueOf(this.b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 53);
        sb.append("MessageFilter{includeAllMyTypes=");
        sb.append(z);
        sb.append(", messageTypes=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.b, false);
        zzbgo.zzc(parcel, 2, this.c, false);
        zzbgo.zza(parcel, 3, this.d);
        zzbgo.zzc(parcel, 4, this.e, false);
        zzbgo.zzc(parcel, 5, this.f);
        zzbgo.zzc(parcel, 1000, this.f4981a);
        zzbgo.zzai(parcel, zze);
    }

    @Hide
    public final List<zzad> zzbdq() {
        return this.b;
    }

    @Hide
    public final boolean zzbdr() {
        return this.d;
    }

    @Hide
    public final List<zzcuu> zzbdt() {
        return this.e;
    }
}
