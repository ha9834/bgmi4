package com.google.android.gms.internal.ads;

import com.helpshift.db.conversation.tables.ConversationTable;

/* loaded from: classes2.dex */
class amf {
    public final int ay;

    /* renamed from: a, reason: collision with root package name */
    public static final int f1966a = zzsy.zzay("ftyp");
    public static final int b = zzsy.zzay("avc1");
    public static final int c = zzsy.zzay("avc3");
    public static final int d = zzsy.zzay("hvc1");
    public static final int e = zzsy.zzay("hev1");
    public static final int f = zzsy.zzay("s263");
    public static final int g = zzsy.zzay("d263");
    private static final int az = zzsy.zzay("mdat");
    public static final int h = zzsy.zzay("mp4a");
    public static final int i = zzsy.zzay(".mp3");
    public static final int j = zzsy.zzay("wave");
    public static final int k = zzsy.zzay("lpcm");
    public static final int l = zzsy.zzay("sowt");
    public static final int m = zzsy.zzay("ac-3");
    public static final int n = zzsy.zzay("dac3");
    public static final int o = zzsy.zzay("ec-3");
    public static final int p = zzsy.zzay("dec3");
    public static final int q = zzsy.zzay("dtsc");
    public static final int r = zzsy.zzay("dtsh");
    public static final int s = zzsy.zzay("dtsl");
    public static final int t = zzsy.zzay("dtse");
    public static final int u = zzsy.zzay("ddts");
    private static final int aA = zzsy.zzay("tfdt");
    private static final int aB = zzsy.zzay("tfhd");
    private static final int aC = zzsy.zzay("trex");
    private static final int aD = zzsy.zzay("trun");
    private static final int aE = zzsy.zzay("sidx");
    public static final int v = zzsy.zzay("moov");
    public static final int w = zzsy.zzay("mvhd");
    public static final int x = zzsy.zzay("trak");
    public static final int y = zzsy.zzay("mdia");
    public static final int z = zzsy.zzay("minf");
    public static final int A = zzsy.zzay("stbl");
    public static final int B = zzsy.zzay("avcC");
    public static final int C = zzsy.zzay("hvcC");
    public static final int D = zzsy.zzay("esds");
    public static final int E = zzsy.zzay("moof");
    private static final int aF = zzsy.zzay("traf");
    public static final int F = zzsy.zzay("mvex");
    private static final int aG = zzsy.zzay("mehd");
    public static final int G = zzsy.zzay("tkhd");
    public static final int H = zzsy.zzay("edts");
    public static final int I = zzsy.zzay("elst");
    public static final int J = zzsy.zzay("mdhd");
    public static final int K = zzsy.zzay("hdlr");
    public static final int L = zzsy.zzay("stsd");
    private static final int aH = zzsy.zzay("pssh");
    public static final int M = zzsy.zzay("sinf");
    public static final int N = zzsy.zzay("schm");
    public static final int O = zzsy.zzay("schi");
    public static final int P = zzsy.zzay("tenc");
    public static final int Q = zzsy.zzay("encv");
    public static final int R = zzsy.zzay("enca");
    public static final int S = zzsy.zzay("frma");
    private static final int aI = zzsy.zzay("saiz");
    private static final int aJ = zzsy.zzay("saio");
    private static final int aK = zzsy.zzay("sbgp");
    private static final int aL = zzsy.zzay("sgpd");
    private static final int aM = zzsy.zzay(ConversationTable.Columns.LOCAL_UUID);
    private static final int aN = zzsy.zzay("senc");
    public static final int T = zzsy.zzay("pasp");
    public static final int U = zzsy.zzay("TTML");
    private static final int aO = zzsy.zzay("vmhd");
    public static final int V = zzsy.zzay("mp4v");
    public static final int W = zzsy.zzay("stts");
    public static final int X = zzsy.zzay("stss");
    public static final int Y = zzsy.zzay("ctts");
    public static final int Z = zzsy.zzay("stsc");
    public static final int aa = zzsy.zzay("stsz");
    public static final int ab = zzsy.zzay("stz2");
    public static final int ac = zzsy.zzay("stco");
    public static final int ad = zzsy.zzay("co64");
    public static final int ae = zzsy.zzay("tx3g");
    public static final int af = zzsy.zzay("wvtt");
    public static final int ag = zzsy.zzay("stpp");
    public static final int ah = zzsy.zzay("c608");
    public static final int ai = zzsy.zzay("samr");
    public static final int aj = zzsy.zzay("sawb");
    public static final int ak = zzsy.zzay("udta");
    public static final int al = zzsy.zzay("meta");
    public static final int am = zzsy.zzay("ilst");
    public static final int an = zzsy.zzay("mean");
    public static final int ao = zzsy.zzay("name");
    public static final int ap = zzsy.zzay("data");
    private static final int aP = zzsy.zzay("emsg");
    public static final int aq = zzsy.zzay("st3d");
    public static final int ar = zzsy.zzay("sv3d");
    public static final int as = zzsy.zzay("proj");

    /* renamed from: at, reason: collision with root package name */
    public static final int f1967at = zzsy.zzay("vp08");
    public static final int au = zzsy.zzay("vp09");
    public static final int av = zzsy.zzay("vpcC");
    public static final int aw = zzsy.zzay("camm");
    public static final int ax = zzsy.zzay("alac");

    public amf(int i2) {
        this.ay = i2;
    }

    public static int a(int i2) {
        return (i2 >> 24) & 255;
    }

    public static int b(int i2) {
        return i2 & 16777215;
    }

    public String toString() {
        return c(this.ay);
    }

    public static String c(int i2) {
        StringBuilder sb = new StringBuilder(4);
        sb.append((char) (i2 >>> 24));
        sb.append((char) ((i2 >> 16) & 255));
        sb.append((char) ((i2 >> 8) & 255));
        sb.append((char) (i2 & 255));
        return sb.toString();
    }
}
