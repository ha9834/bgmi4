package com.google.android.gms.internal.firebase_remote_config;

import com.helpshift.logger.model.LogDatabaseTable;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzyr' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public class zzkk {

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ zzkk[] f4192a;
    public static final zzkk zzyj = new zzkk("DOUBLE", 0, zzkr.DOUBLE, 1);
    public static final zzkk zzyk = new zzkk("FLOAT", 1, zzkr.FLOAT, 5);
    public static final zzkk zzyl = new zzkk("INT64", 2, zzkr.LONG, 0);
    public static final zzkk zzym = new zzkk("UINT64", 3, zzkr.LONG, 0);
    public static final zzkk zzyn = new zzkk("INT32", 4, zzkr.INT, 0);
    public static final zzkk zzyo = new zzkk("FIXED64", 5, zzkr.LONG, 1);
    public static final zzkk zzyp = new zzkk("FIXED32", 6, zzkr.INT, 5);
    public static final zzkk zzyq = new zzkk("BOOL", 7, zzkr.BOOLEAN, 0);
    public static final zzkk zzyr;
    public static final zzkk zzys;
    public static final zzkk zzyt;
    public static final zzkk zzyu;
    public static final zzkk zzyv;
    public static final zzkk zzyw;
    public static final zzkk zzyx;
    public static final zzkk zzyy;
    public static final zzkk zzyz;
    public static final zzkk zzza;
    private final zzkr zzzb;
    private final int zzzc;

    public static zzkk[] values() {
        return (zzkk[]) f4192a.clone();
    }

    private zzkk(String str, int i, zzkr zzkrVar, int i2) {
        this.zzzb = zzkrVar;
        this.zzzc = i2;
    }

    public final zzkr zzjj() {
        return this.zzzb;
    }

    public final int zzjk() {
        return this.zzzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzkk(String str, int i, zzkr zzkrVar, int i2, en enVar) {
        this(str, i, zzkrVar, i2);
    }

    static {
        final int i = 2;
        final int i2 = 3;
        final String str = "STRING";
        final zzkr zzkrVar = zzkr.STRING;
        final int i3 = 8;
        zzyr = new zzkk(str, i3, zzkrVar, i) { // from class: com.google.android.gms.internal.firebase_remote_config.zzkn
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i4 = 8;
                int i5 = 2;
                en enVar = null;
            }
        };
        final String str2 = "GROUP";
        final zzkr zzkrVar2 = zzkr.MESSAGE;
        final int i4 = 9;
        zzys = new zzkk(str2, i4, zzkrVar2, i2) { // from class: com.google.android.gms.internal.firebase_remote_config.zzkm
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i5 = 9;
                int i6 = 3;
                en enVar = null;
            }
        };
        final String str3 = LogDatabaseTable.LogTableColumns.MESSAGE;
        final zzkr zzkrVar3 = zzkr.MESSAGE;
        final int i5 = 10;
        zzyt = new zzkk(str3, i5, zzkrVar3, i) { // from class: com.google.android.gms.internal.firebase_remote_config.zzkp
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i6 = 10;
                int i7 = 2;
                en enVar = null;
            }
        };
        final String str4 = "BYTES";
        final zzkr zzkrVar4 = zzkr.BYTE_STRING;
        final int i6 = 11;
        zzyu = new zzkk(str4, i6, zzkrVar4, i) { // from class: com.google.android.gms.internal.firebase_remote_config.zzko
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i7 = 11;
                int i8 = 2;
                en enVar = null;
            }
        };
        zzyv = new zzkk("UINT32", 12, zzkr.INT, 0);
        zzyw = new zzkk("ENUM", 13, zzkr.ENUM, 0);
        zzyx = new zzkk("SFIXED32", 14, zzkr.INT, 5);
        zzyy = new zzkk("SFIXED64", 15, zzkr.LONG, 1);
        zzyz = new zzkk("SINT32", 16, zzkr.INT, 0);
        zzza = new zzkk("SINT64", 17, zzkr.LONG, 0);
        f4192a = new zzkk[]{zzyj, zzyk, zzyl, zzym, zzyn, zzyo, zzyp, zzyq, zzyr, zzys, zzyt, zzyu, zzyv, zzyw, zzyx, zzyy, zzyz, zzza};
    }
}
