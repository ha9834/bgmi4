package com.google.android.gms.internal.ads;

import com.helpshift.db.conversation.tables.ConversationTable;

/* loaded from: classes2.dex */
class akc {
    public final int type;

    /* renamed from: a, reason: collision with root package name */
    private static final int f1928a = zzkq.zzay("ftyp");
    public static final int zzaka = zzkq.zzay("avc1");
    public static final int zzakb = zzkq.zzay("avc3");
    public static final int zzakc = zzkq.zzay("esds");
    private static final int b = zzkq.zzay("mdat");
    public static final int zzake = zzkq.zzay("mp4a");
    public static final int zzakf = zzkq.zzay("ac-3");
    public static final int zzakg = zzkq.zzay("dac3");
    public static final int zzakh = zzkq.zzay("ec-3");
    public static final int zzaki = zzkq.zzay("dec3");
    private static final int c = zzkq.zzay("tfdt");
    private static final int d = zzkq.zzay("tfhd");
    private static final int e = zzkq.zzay("trex");
    private static final int f = zzkq.zzay("trun");
    private static final int g = zzkq.zzay("sidx");
    public static final int zzako = zzkq.zzay("moov");
    public static final int zzakp = zzkq.zzay("mvhd");
    public static final int zzakq = zzkq.zzay("trak");
    public static final int zzakr = zzkq.zzay("mdia");
    public static final int zzaks = zzkq.zzay("minf");
    public static final int zzakt = zzkq.zzay("stbl");
    public static final int zzaku = zzkq.zzay("avcC");
    private static final int h = zzkq.zzay("moof");
    private static final int i = zzkq.zzay("traf");
    private static final int j = zzkq.zzay("mvex");
    public static final int zzaky = zzkq.zzay("tkhd");
    public static final int zzakz = zzkq.zzay("mdhd");
    public static final int zzala = zzkq.zzay("hdlr");
    public static final int zzalb = zzkq.zzay("stsd");
    private static final int k = zzkq.zzay("pssh");
    public static final int zzald = zzkq.zzay("sinf");
    public static final int zzale = zzkq.zzay("schm");
    public static final int zzalf = zzkq.zzay("schi");
    public static final int zzalg = zzkq.zzay("tenc");
    public static final int zzalh = zzkq.zzay("encv");
    public static final int zzali = zzkq.zzay("enca");
    public static final int zzalj = zzkq.zzay("frma");
    private static final int l = zzkq.zzay("saiz");
    private static final int m = zzkq.zzay(ConversationTable.Columns.LOCAL_UUID);
    private static final int n = zzkq.zzay("senc");
    public static final int zzaln = zzkq.zzay("pasp");
    public static final int zzalo = zzkq.zzay("TTML");
    public static final int zzalp = zzkq.zzay("vmhd");
    public static final int zzalq = zzkq.zzay("smhd");
    public static final int zzalr = zzkq.zzay("mp4v");
    public static final int zzals = zzkq.zzay("stts");
    public static final int zzalt = zzkq.zzay("stss");
    public static final int zzalu = zzkq.zzay("ctts");
    public static final int zzalv = zzkq.zzay("stsc");
    public static final int zzalw = zzkq.zzay("stsz");
    public static final int zzalx = zzkq.zzay("stco");
    public static final int zzaly = zzkq.zzay("co64");

    /* JADX INFO: Access modifiers changed from: package-private */
    public akc(int i2) {
        this.type = i2;
    }

    public static int zzt(int i2) {
        return (i2 >> 24) & 255;
    }

    public String toString() {
        return zzu(this.type);
    }

    public static String zzu(int i2) {
        StringBuilder sb = new StringBuilder(4);
        sb.append((char) (i2 >> 24));
        sb.append((char) ((i2 >> 16) & 255));
        sb.append((char) ((i2 >> 8) & 255));
        sb.append((char) (i2 & 255));
        return sb.toString();
    }
}
