package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzpo;

/* loaded from: classes2.dex */
final class amq {

    /* renamed from: a, reason: collision with root package name */
    private static final int f1974a = zzsy.zzay("nam");
    private static final int b = zzsy.zzay("trk");
    private static final int c = zzsy.zzay("cmt");
    private static final int d = zzsy.zzay("day");
    private static final int e = zzsy.zzay("ART");
    private static final int f = zzsy.zzay("too");
    private static final int g = zzsy.zzay("alb");
    private static final int h = zzsy.zzay("com");
    private static final int i = zzsy.zzay("wrt");
    private static final int j = zzsy.zzay("lyr");
    private static final int k = zzsy.zzay("gen");
    private static final int l = zzsy.zzay("covr");
    private static final int m = zzsy.zzay("gnre");
    private static final int n = zzsy.zzay("grp");
    private static final int o = zzsy.zzay("disk");
    private static final int p = zzsy.zzay("trkn");
    private static final int q = zzsy.zzay("tmpo");
    private static final int r = zzsy.zzay("cpil");
    private static final int s = zzsy.zzay("aART");
    private static final int t = zzsy.zzay("sonm");
    private static final int u = zzsy.zzay("soal");
    private static final int v = zzsy.zzay("soar");
    private static final int w = zzsy.zzay("soaa");
    private static final int x = zzsy.zzay("soco");
    private static final int y = zzsy.zzay("rtng");
    private static final int z = zzsy.zzay("pgap");
    private static final int A = zzsy.zzay("sosn");
    private static final int B = zzsy.zzay("tvsh");
    private static final int C = zzsy.zzay("----");
    private static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzpo.zza a(zzst zzstVar) {
        zzpw zzpwVar;
        int position = zzstVar.getPosition() + zzstVar.readInt();
        int readInt = zzstVar.readInt();
        int i2 = readInt >>> 24;
        zzpo.zza zzaVar = null;
        try {
            if (i2 == 169 || i2 == 65533) {
                int i3 = 16777215 & readInt;
                if (i3 == c) {
                    int readInt2 = zzstVar.readInt();
                    if (zzstVar.readInt() == amf.ap) {
                        zzstVar.zzac(8);
                        String zzbp = zzstVar.zzbp(readInt2 - 16);
                        zzaVar = new zzps("und", zzbp, zzbp);
                    } else {
                        String valueOf = String.valueOf(amf.c(readInt));
                        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "));
                    }
                    return zzaVar;
                }
                if (i3 != f1974a && i3 != b) {
                    if (i3 != h && i3 != i) {
                        if (i3 == d) {
                            return a(readInt, "TDRC", zzstVar);
                        }
                        if (i3 == e) {
                            return a(readInt, "TPE1", zzstVar);
                        }
                        if (i3 == f) {
                            return a(readInt, "TSSE", zzstVar);
                        }
                        if (i3 == g) {
                            return a(readInt, "TALB", zzstVar);
                        }
                        if (i3 == j) {
                            return a(readInt, "USLT", zzstVar);
                        }
                        if (i3 == k) {
                            return a(readInt, "TCON", zzstVar);
                        }
                        if (i3 == n) {
                            return a(readInt, "TIT1", zzstVar);
                        }
                    }
                    return a(readInt, "TCOM", zzstVar);
                }
                return a(readInt, "TIT2", zzstVar);
            }
            if (readInt == m) {
                int b2 = b(zzstVar);
                String str = (b2 <= 0 || b2 > D.length) ? null : D[b2 - 1];
                if (str != null) {
                    zzpwVar = new zzpw("TCON", null, str);
                } else {
                    Log.w("MetadataUtil", "Failed to parse standard genre code");
                    zzpwVar = null;
                }
                return zzpwVar;
            }
            if (readInt == o) {
                return b(readInt, "TPOS", zzstVar);
            }
            if (readInt == p) {
                return b(readInt, "TRCK", zzstVar);
            }
            if (readInt == q) {
                return a(readInt, "TBPM", zzstVar, true, false);
            }
            if (readInt == r) {
                return a(readInt, "TCMP", zzstVar, true, true);
            }
            if (readInt == l) {
                int readInt3 = zzstVar.readInt();
                if (zzstVar.readInt() == amf.ap) {
                    int b3 = amf.b(zzstVar.readInt());
                    String str2 = b3 == 13 ? "image/jpeg" : b3 == 14 ? "image/png" : null;
                    if (str2 == null) {
                        StringBuilder sb = new StringBuilder(41);
                        sb.append("Unrecognized cover art flags: ");
                        sb.append(b3);
                        Log.w("MetadataUtil", sb.toString());
                    } else {
                        zzstVar.zzac(4);
                        byte[] bArr = new byte[readInt3 - 16];
                        zzstVar.zzb(bArr, 0, bArr.length);
                        zzaVar = new zzpq(str2, null, 3, bArr);
                    }
                } else {
                    Log.w("MetadataUtil", "Failed to parse cover art attribute");
                }
                return zzaVar;
            }
            if (readInt == s) {
                return a(readInt, "TPE2", zzstVar);
            }
            if (readInt == t) {
                return a(readInt, "TSOT", zzstVar);
            }
            if (readInt == u) {
                return a(readInt, "TSO2", zzstVar);
            }
            if (readInt == v) {
                return a(readInt, "TSOA", zzstVar);
            }
            if (readInt == w) {
                return a(readInt, "TSOP", zzstVar);
            }
            if (readInt == x) {
                return a(readInt, "TSOC", zzstVar);
            }
            if (readInt == y) {
                return a(readInt, "ITUNESADVISORY", zzstVar, false, false);
            }
            if (readInt == z) {
                return a(readInt, "ITUNESGAPLESS", zzstVar, false, true);
            }
            if (readInt == A) {
                return a(readInt, "TVSHOWSORT", zzstVar);
            }
            if (readInt == B) {
                return a(readInt, "TVSHOW", zzstVar);
            }
            if (readInt == C) {
                String str3 = null;
                String str4 = null;
                int i4 = -1;
                int i5 = -1;
                while (zzstVar.getPosition() < position) {
                    int position2 = zzstVar.getPosition();
                    int readInt4 = zzstVar.readInt();
                    int readInt5 = zzstVar.readInt();
                    zzstVar.zzac(4);
                    if (readInt5 == amf.an) {
                        str3 = zzstVar.zzbp(readInt4 - 12);
                    } else if (readInt5 == amf.ao) {
                        str4 = zzstVar.zzbp(readInt4 - 12);
                    } else {
                        if (readInt5 == amf.ap) {
                            i4 = position2;
                            i5 = readInt4;
                        }
                        zzstVar.zzac(readInt4 - 12);
                    }
                }
                if ("com.apple.iTunes".equals(str3) && "iTunSMPB".equals(str4) && i4 != -1) {
                    zzstVar.setPosition(i4);
                    zzstVar.zzac(16);
                    zzaVar = new zzps("und", str4, zzstVar.zzbp(i5 - 16));
                }
                return zzaVar;
            }
            String valueOf2 = String.valueOf(amf.c(readInt));
            Log.d("MetadataUtil", valueOf2.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf2) : new String("Skipped unknown metadata entry: "));
            return null;
        } finally {
            zzstVar.setPosition(position);
        }
    }

    private static zzpw a(int i2, String str, zzst zzstVar) {
        int readInt = zzstVar.readInt();
        if (zzstVar.readInt() == amf.ap) {
            zzstVar.zzac(8);
            return new zzpw(str, null, zzstVar.zzbp(readInt - 16));
        }
        String valueOf = String.valueOf(amf.c(i2));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static zzpv a(int i2, String str, zzst zzstVar, boolean z2, boolean z3) {
        int b2 = b(zzstVar);
        if (z3) {
            b2 = Math.min(1, b2);
        }
        if (b2 >= 0) {
            if (z2) {
                return new zzpw(str, null, Integer.toString(b2));
            }
            return new zzps("und", str, Integer.toString(b2));
        }
        String valueOf = String.valueOf(amf.c(i2));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }

    private static zzpw b(int i2, String str, zzst zzstVar) {
        int readInt = zzstVar.readInt();
        if (zzstVar.readInt() == amf.ap && readInt >= 22) {
            zzstVar.zzac(10);
            int readUnsignedShort = zzstVar.readUnsignedShort();
            if (readUnsignedShort > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(readUnsignedShort);
                String sb2 = sb.toString();
                int readUnsignedShort2 = zzstVar.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(readUnsignedShort2);
                    sb2 = sb3.toString();
                }
                return new zzpw(str, null, sb2);
            }
        }
        String valueOf2 = String.valueOf(amf.c(i2));
        Log.w("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    private static int b(zzst zzstVar) {
        zzstVar.zzac(4);
        if (zzstVar.readInt() == amf.ap) {
            zzstVar.zzac(8);
            return zzstVar.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
