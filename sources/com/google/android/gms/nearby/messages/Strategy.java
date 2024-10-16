package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class Strategy extends zzbgl {
    public static final Strategy BLE_ONLY;
    public static final Parcelable.Creator<Strategy> CREATOR = new zzg();
    public static final Strategy DEFAULT = new Builder().build();
    public static final int DISCOVERY_MODE_BROADCAST = 1;
    public static final int DISCOVERY_MODE_DEFAULT = 3;
    public static final int DISCOVERY_MODE_SCAN = 2;
    public static final int DISTANCE_TYPE_DEFAULT = 0;
    public static final int DISTANCE_TYPE_EARSHOT = 1;
    public static final int TTL_SECONDS_DEFAULT = 300;
    public static final int TTL_SECONDS_INFINITE = Integer.MAX_VALUE;
    public static final int TTL_SECONDS_MAX = 86400;

    /* renamed from: a, reason: collision with root package name */
    @Hide
    @Deprecated
    private static Strategy f4986a;
    private int b;

    @Hide
    @Deprecated
    private int c;
    private int d;
    private int e;

    @Hide
    @Deprecated
    private boolean f;

    @Hide
    private int g;
    private int h;
    private final int i;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private int f4987a = 3;
        private int b = 300;
        private int c = 0;
        private int d = -1;
        private int e = 0;

        public Strategy build() {
            if (this.d == 2 && this.c == 1) {
                throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
            }
            return new Strategy(2, 0, this.b, this.c, false, this.d, this.f4987a, 0);
        }

        public Builder setDiscoveryMode(int i) {
            this.f4987a = i;
            return this;
        }

        public Builder setDistanceType(int i) {
            this.c = i;
            return this;
        }

        public Builder setTtlSeconds(int i) {
            zzbq.zzb(i == Integer.MAX_VALUE || (i > 0 && i <= 86400), "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", new Object[]{Integer.valueOf(i), Integer.valueOf(Strategy.TTL_SECONDS_MAX)});
            this.b = i;
            return this;
        }

        @Hide
        public final Builder zzes(int i) {
            this.d = 2;
            return this;
        }
    }

    static {
        Strategy build = new Builder().zzes(2).setTtlSeconds(Integer.MAX_VALUE).build();
        BLE_ONLY = build;
        f4986a = build;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Strategy(int i, int i2, int i3, int i4, boolean z, int i5, int i6, int i7) {
        int i8;
        this.b = i;
        this.c = i2;
        if (i2 != 0) {
            switch (i2) {
                case 2:
                    i8 = 1;
                    this.h = i8;
                    break;
                case 3:
                    this.h = 2;
                    break;
                default:
                    i8 = 3;
                    this.h = i8;
                    break;
            }
        } else {
            this.h = i6;
        }
        this.e = i4;
        this.f = z;
        if (z) {
            this.g = 2;
            this.d = Integer.MAX_VALUE;
        } else {
            this.d = i3;
            if (i5 != 6) {
                switch (i5) {
                    case -1:
                    case 0:
                    case 1:
                        break;
                    default:
                        this.g = i5;
                        break;
                }
            }
            this.g = -1;
        }
        this.i = i7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        return this.b == strategy.b && this.h == strategy.h && this.d == strategy.d && this.e == strategy.e && this.g == strategy.g && this.i == strategy.i;
    }

    public int hashCode() {
        return (((((((((this.b * 31) + this.h) * 31) + this.d) * 31) + this.e) * 31) + this.g) * 31) + this.i;
    }

    public String toString() {
        String str;
        String obj;
        String obj2;
        String str2;
        int i = this.d;
        int i2 = this.e;
        switch (i2) {
            case 0:
                str = MessengerShareContentUtility.PREVIEW_DEFAULT;
                break;
            case 1:
                str = "EARSHOT";
                break;
            default:
                StringBuilder sb = new StringBuilder(19);
                sb.append("UNKNOWN:");
                sb.append(i2);
                str = sb.toString();
                break;
        }
        int i3 = this.g;
        if (i3 == -1) {
            obj = MessengerShareContentUtility.PREVIEW_DEFAULT;
        } else {
            ArrayList arrayList = new ArrayList();
            if ((i3 & 4) > 0) {
                arrayList.add("ULTRASOUND");
            }
            if ((i3 & 2) > 0) {
                arrayList.add("BLE");
            }
            if (arrayList.isEmpty()) {
                StringBuilder sb2 = new StringBuilder(19);
                sb2.append("UNKNOWN:");
                sb2.append(i3);
                obj = sb2.toString();
            } else {
                obj = arrayList.toString();
            }
        }
        int i4 = this.h;
        if (i4 == 3) {
            obj2 = MessengerShareContentUtility.PREVIEW_DEFAULT;
        } else {
            ArrayList arrayList2 = new ArrayList();
            if ((i4 & 1) > 0) {
                arrayList2.add("BROADCAST");
            }
            if ((i4 & 2) > 0) {
                arrayList2.add("SCAN");
            }
            if (arrayList2.isEmpty()) {
                StringBuilder sb3 = new StringBuilder(19);
                sb3.append("UNKNOWN:");
                sb3.append(i4);
                obj2 = sb3.toString();
            } else {
                obj2 = arrayList2.toString();
            }
        }
        int i5 = this.i;
        switch (i5) {
            case 0:
                str2 = MessengerShareContentUtility.PREVIEW_DEFAULT;
                break;
            case 1:
                str2 = "ALWAYS_ON";
                break;
            default:
                StringBuilder sb4 = new StringBuilder(20);
                sb4.append("UNKNOWN: ");
                sb4.append(i5);
                str2 = sb4.toString();
                break;
        }
        StringBuilder sb5 = new StringBuilder(String.valueOf(str).length() + 102 + String.valueOf(obj).length() + String.valueOf(obj2).length() + String.valueOf(str2).length());
        sb5.append("Strategy{ttlSeconds=");
        sb5.append(i);
        sb5.append(", distanceType=");
        sb5.append(str);
        sb5.append(", discoveryMedium=");
        sb5.append(obj);
        sb5.append(", discoveryMode=");
        sb5.append(obj2);
        sb5.append(", backgroundScanMode=");
        sb5.append(str2);
        sb5.append('}');
        return sb5.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.c);
        zzbgo.zzc(parcel, 2, this.d);
        zzbgo.zzc(parcel, 3, this.e);
        zzbgo.zza(parcel, 4, this.f);
        zzbgo.zzc(parcel, 5, this.g);
        zzbgo.zzc(parcel, 6, this.h);
        zzbgo.zzc(parcel, 7, this.i);
        zzbgo.zzc(parcel, 1000, this.b);
        zzbgo.zzai(parcel, zze);
    }

    @Hide
    public final int zzbdu() {
        return this.i;
    }
}
