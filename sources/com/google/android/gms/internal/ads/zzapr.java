package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;

@zzard
/* loaded from: classes2.dex */
public final class zzapr extends zzaqb {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<String> f2776a = CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private String b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private final Object j;
    private final zzbgz k;
    private final Activity l;
    private zzbin m;
    private ImageView n;
    private LinearLayout o;
    private zzaqc p;
    private PopupWindow q;
    private RelativeLayout r;
    private ViewGroup s;

    public zzapr(zzbgz zzbgzVar, zzaqc zzaqcVar) {
        super(zzbgzVar, "resize");
        this.b = "top-right";
        this.c = true;
        this.d = 0;
        this.e = 0;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.i = -1;
        this.j = new Object();
        this.k = zzbgzVar;
        this.l = zzbgzVar.zzyd();
        this.p = zzaqcVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:145:0x023d A[Catch: all -> 0x04bb, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:10:0x0012, B:12:0x001a, B:13:0x001f, B:15:0x0021, B:17:0x002d, B:18:0x0032, B:20:0x0034, B:22:0x003c, B:23:0x0041, B:25:0x0043, B:27:0x0051, B:28:0x0062, B:30:0x0070, B:31:0x0081, B:33:0x008f, B:34:0x00a0, B:36:0x00ae, B:37:0x00bf, B:39:0x00cd, B:40:0x00db, B:42:0x00e9, B:43:0x00eb, B:45:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0133, B:62:0x0139, B:64:0x013d, B:67:0x0143, B:69:0x0147, B:71:0x014b, B:75:0x029d, B:76:0x02a2, B:78:0x02a4, B:80:0x02c6, B:82:0x02ca, B:84:0x02da, B:85:0x030e, B:88:0x0344, B:89:0x0378, B:93:0x03c2, B:94:0x03c5, B:95:0x03f2, B:96:0x03f5, B:98:0x040d, B:99:0x042c, B:101:0x0434, B:102:0x043d, B:103:0x0463, B:107:0x0466, B:109:0x0476, B:110:0x0480, B:112:0x0492, B:113:0x04ab, B:115:0x047b, B:116:0x03c9, B:117:0x03d0, B:118:0x03d7, B:119:0x03de, B:120:0x03e4, B:121:0x03eb, B:122:0x037c, B:125:0x0386, B:128:0x0390, B:131:0x0399, B:134:0x03a3, B:137:0x03ad, B:141:0x0309, B:142:0x04ad, B:143:0x04b2, B:145:0x023d, B:147:0x0241, B:148:0x0252, B:151:0x0280, B:153:0x0284, B:154:0x0294, B:155:0x0287, B:157:0x028e, B:158:0x0276, B:160:0x027b, B:162:0x0153, B:164:0x0157, B:165:0x015d, B:168:0x019e, B:169:0x01a1, B:170:0x020e, B:172:0x021c, B:174:0x021f, B:176:0x0223, B:179:0x01a4, B:180:0x01b7, B:181:0x01cc, B:182:0x01db, B:183:0x01f2, B:184:0x0203, B:185:0x0161, B:188:0x016b, B:191:0x0175, B:194:0x017f, B:197:0x0189, B:200:0x0193, B:204:0x022c, B:205:0x0233, B:206:0x04b4, B:207:0x04b9), top: B:3:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x029d A[Catch: all -> 0x04bb, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:10:0x0012, B:12:0x001a, B:13:0x001f, B:15:0x0021, B:17:0x002d, B:18:0x0032, B:20:0x0034, B:22:0x003c, B:23:0x0041, B:25:0x0043, B:27:0x0051, B:28:0x0062, B:30:0x0070, B:31:0x0081, B:33:0x008f, B:34:0x00a0, B:36:0x00ae, B:37:0x00bf, B:39:0x00cd, B:40:0x00db, B:42:0x00e9, B:43:0x00eb, B:45:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0133, B:62:0x0139, B:64:0x013d, B:67:0x0143, B:69:0x0147, B:71:0x014b, B:75:0x029d, B:76:0x02a2, B:78:0x02a4, B:80:0x02c6, B:82:0x02ca, B:84:0x02da, B:85:0x030e, B:88:0x0344, B:89:0x0378, B:93:0x03c2, B:94:0x03c5, B:95:0x03f2, B:96:0x03f5, B:98:0x040d, B:99:0x042c, B:101:0x0434, B:102:0x043d, B:103:0x0463, B:107:0x0466, B:109:0x0476, B:110:0x0480, B:112:0x0492, B:113:0x04ab, B:115:0x047b, B:116:0x03c9, B:117:0x03d0, B:118:0x03d7, B:119:0x03de, B:120:0x03e4, B:121:0x03eb, B:122:0x037c, B:125:0x0386, B:128:0x0390, B:131:0x0399, B:134:0x03a3, B:137:0x03ad, B:141:0x0309, B:142:0x04ad, B:143:0x04b2, B:145:0x023d, B:147:0x0241, B:148:0x0252, B:151:0x0280, B:153:0x0284, B:154:0x0294, B:155:0x0287, B:157:0x028e, B:158:0x0276, B:160:0x027b, B:162:0x0153, B:164:0x0157, B:165:0x015d, B:168:0x019e, B:169:0x01a1, B:170:0x020e, B:172:0x021c, B:174:0x021f, B:176:0x0223, B:179:0x01a4, B:180:0x01b7, B:181:0x01cc, B:182:0x01db, B:183:0x01f2, B:184:0x0203, B:185:0x0161, B:188:0x016b, B:191:0x0175, B:194:0x017f, B:197:0x0189, B:200:0x0193, B:204:0x022c, B:205:0x0233, B:206:0x04b4, B:207:0x04b9), top: B:3:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02a4 A[Catch: all -> 0x04bb, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:10:0x0012, B:12:0x001a, B:13:0x001f, B:15:0x0021, B:17:0x002d, B:18:0x0032, B:20:0x0034, B:22:0x003c, B:23:0x0041, B:25:0x0043, B:27:0x0051, B:28:0x0062, B:30:0x0070, B:31:0x0081, B:33:0x008f, B:34:0x00a0, B:36:0x00ae, B:37:0x00bf, B:39:0x00cd, B:40:0x00db, B:42:0x00e9, B:43:0x00eb, B:45:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0133, B:62:0x0139, B:64:0x013d, B:67:0x0143, B:69:0x0147, B:71:0x014b, B:75:0x029d, B:76:0x02a2, B:78:0x02a4, B:80:0x02c6, B:82:0x02ca, B:84:0x02da, B:85:0x030e, B:88:0x0344, B:89:0x0378, B:93:0x03c2, B:94:0x03c5, B:95:0x03f2, B:96:0x03f5, B:98:0x040d, B:99:0x042c, B:101:0x0434, B:102:0x043d, B:103:0x0463, B:107:0x0466, B:109:0x0476, B:110:0x0480, B:112:0x0492, B:113:0x04ab, B:115:0x047b, B:116:0x03c9, B:117:0x03d0, B:118:0x03d7, B:119:0x03de, B:120:0x03e4, B:121:0x03eb, B:122:0x037c, B:125:0x0386, B:128:0x0390, B:131:0x0399, B:134:0x03a3, B:137:0x03ad, B:141:0x0309, B:142:0x04ad, B:143:0x04b2, B:145:0x023d, B:147:0x0241, B:148:0x0252, B:151:0x0280, B:153:0x0284, B:154:0x0294, B:155:0x0287, B:157:0x028e, B:158:0x0276, B:160:0x027b, B:162:0x0153, B:164:0x0157, B:165:0x015d, B:168:0x019e, B:169:0x01a1, B:170:0x020e, B:172:0x021c, B:174:0x021f, B:176:0x0223, B:179:0x01a4, B:180:0x01b7, B:181:0x01cc, B:182:0x01db, B:183:0x01f2, B:184:0x0203, B:185:0x0161, B:188:0x016b, B:191:0x0175, B:194:0x017f, B:197:0x0189, B:200:0x0193, B:204:0x022c, B:205:0x0233, B:206:0x04b4, B:207:0x04b9), top: B:3:0x0007, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzg(java.util.Map<java.lang.String, java.lang.String> r17) {
        /*
            Method dump skipped, instructions count: 1298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapr.zzg(java.util.Map):void");
    }

    public final void zzw(boolean z) {
        synchronized (this.j) {
            if (this.q != null) {
                this.q.dismiss();
                this.r.removeView(this.k.getView());
                if (this.s != null) {
                    this.s.removeView(this.n);
                    this.s.addView(this.k.getView());
                    this.k.zza(this.m);
                }
                if (z) {
                    zzdj(com.huawei.game.gamekit.b.a.f5471a);
                    if (this.p != null) {
                        this.p.zztc();
                    }
                }
                this.q = null;
                this.r = null;
                this.s = null;
                this.o = null;
            }
        }
    }

    public final void zza(int i, int i2, boolean z) {
        synchronized (this.j) {
            this.d = i;
            this.e = i2;
        }
    }

    public final boolean zztb() {
        boolean z;
        synchronized (this.j) {
            z = this.q != null;
        }
        return z;
    }

    public final void zzi(int i, int i2) {
        this.d = i;
        this.e = i2;
    }
}
