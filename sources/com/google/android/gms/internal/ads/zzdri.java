package com.google.android.gms.internal.ads;

import com.helpshift.logger.model.LogDatabaseTable;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzhmp' uses external variables
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
public class zzdri {

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ zzdri[] f3600a;
    public static final zzdri zzhmh = new zzdri("DOUBLE", 0, zzdrn.DOUBLE, 1);
    public static final zzdri zzhmi = new zzdri("FLOAT", 1, zzdrn.FLOAT, 5);
    public static final zzdri zzhmj = new zzdri("INT64", 2, zzdrn.LONG, 0);
    public static final zzdri zzhmk = new zzdri("UINT64", 3, zzdrn.LONG, 0);
    public static final zzdri zzhml = new zzdri("INT32", 4, zzdrn.INT, 0);
    public static final zzdri zzhmm = new zzdri("FIXED64", 5, zzdrn.LONG, 1);
    public static final zzdri zzhmn = new zzdri("FIXED32", 6, zzdrn.INT, 5);
    public static final zzdri zzhmo = new zzdri("BOOL", 7, zzdrn.BOOLEAN, 0);
    public static final zzdri zzhmp;
    public static final zzdri zzhmq;
    public static final zzdri zzhmr;
    public static final zzdri zzhms;
    public static final zzdri zzhmt;
    public static final zzdri zzhmu;
    public static final zzdri zzhmv;
    public static final zzdri zzhmw;
    public static final zzdri zzhmx;
    public static final zzdri zzhmy;
    private final zzdrn zzhmz;
    private final int zzhna;

    public static zzdri[] values() {
        return (zzdri[]) f3600a.clone();
    }

    private zzdri(String str, int i, zzdrn zzdrnVar, int i2) {
        this.zzhmz = zzdrnVar;
        this.zzhna = i2;
    }

    public final zzdrn zzbaj() {
        return this.zzhmz;
    }

    public final int zzbak() {
        return this.zzhna;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdri(String str, int i, zzdrn zzdrnVar, int i2, aia aiaVar) {
        this(str, i, zzdrnVar, i2);
    }

    static {
        final int i = 2;
        final int i2 = 3;
        final String str = "STRING";
        final zzdrn zzdrnVar = zzdrn.STRING;
        final int i3 = 8;
        zzhmp = new zzdri(str, i3, zzdrnVar, i) { // from class: com.google.android.gms.internal.ads.zzdrj
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i4 = 8;
                int i5 = 2;
                aia aiaVar = null;
            }
        };
        final String str2 = "GROUP";
        final zzdrn zzdrnVar2 = zzdrn.MESSAGE;
        final int i4 = 9;
        zzhmq = new zzdri(str2, i4, zzdrnVar2, i2) { // from class: com.google.android.gms.internal.ads.zzdrk
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i5 = 9;
                int i6 = 3;
                aia aiaVar = null;
            }
        };
        final String str3 = LogDatabaseTable.LogTableColumns.MESSAGE;
        final zzdrn zzdrnVar3 = zzdrn.MESSAGE;
        final int i5 = 10;
        zzhmr = new zzdri(str3, i5, zzdrnVar3, i) { // from class: com.google.android.gms.internal.ads.zzdrl
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i6 = 10;
                int i7 = 2;
                aia aiaVar = null;
            }
        };
        final String str4 = "BYTES";
        final zzdrn zzdrnVar4 = zzdrn.BYTE_STRING;
        final int i6 = 11;
        zzhms = new zzdri(str4, i6, zzdrnVar4, i) { // from class: com.google.android.gms.internal.ads.zzdrm
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i7 = 11;
                int i8 = 2;
                aia aiaVar = null;
            }
        };
        zzhmt = new zzdri("UINT32", 12, zzdrn.INT, 0);
        zzhmu = new zzdri("ENUM", 13, zzdrn.ENUM, 0);
        zzhmv = new zzdri("SFIXED32", 14, zzdrn.INT, 5);
        zzhmw = new zzdri("SFIXED64", 15, zzdrn.LONG, 1);
        zzhmx = new zzdri("SINT32", 16, zzdrn.INT, 0);
        zzhmy = new zzdri("SINT64", 17, zzdrn.LONG, 0);
        f3600a = new zzdri[]{zzhmh, zzhmi, zzhmj, zzhmk, zzhml, zzhmm, zzhmn, zzhmo, zzhmp, zzhmq, zzhmr, zzhms, zzhmt, zzhmu, zzhmv, zzhmw, zzhmx, zzhmy};
    }
}
