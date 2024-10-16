package com.ihoc.mgpa.i;

import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes2.dex */
public class j extends d {

    /* renamed from: a, reason: collision with root package name */
    private int f5617a = 0;
    private ArrayList<k> b = new ArrayList<>();
    private k c = null;

    private void a() {
        Iterator<k> it = this.b.iterator();
        while (it.hasNext()) {
            m.l(it.next().b);
        }
        this.b.clear();
        this.f5617a = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:
    
        if (com.ihoc.mgpa.i.f.q.compareTo(com.ihoc.mgpa.a.g.PLAYING.a()) == 0) goto L31;
     */
    @Override // com.ihoc.mgpa.i.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r5, java.lang.String r6) {
        /*
            r4 = this;
            com.ihoc.mgpa.a.e r0 = com.ihoc.mgpa.a.e.a(r5)
            int[] r1 = com.ihoc.mgpa.i.i.f5616a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L2b
            r1 = 2
            if (r0 == r1) goto L16
            r1 = 3
            if (r0 == r1) goto L16
            goto L27
        L16:
            com.ihoc.mgpa.a.e r0 = com.ihoc.mgpa.a.e.COMMOND_ID
            int r0 = r0.a()
            long r1 = com.ihoc.mgpa.i.h.a()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            com.ihoc.mgpa.i.f.a(r0, r1)
        L27:
            com.ihoc.mgpa.i.f.a(r5, r6)
            goto L75
        L2b:
            r0 = -1
            int r2 = r6.hashCode()     // Catch: java.lang.Exception -> L63
            r3 = 52
            if (r2 == r3) goto L43
            r3 = 53
            if (r2 == r3) goto L39
            goto L4c
        L39:
            java.lang.String r2 = "5"
            boolean r2 = r6.equals(r2)     // Catch: java.lang.Exception -> L63
            if (r2 == 0) goto L4c
            r0 = 1
            goto L4c
        L43:
            java.lang.String r2 = "4"
            boolean r2 = r6.equals(r2)     // Catch: java.lang.Exception -> L63
            if (r2 == 0) goto L4c
            r0 = 0
        L4c:
            if (r0 == 0) goto L51
            if (r0 == r1) goto L5f
            goto L6e
        L51:
            java.lang.String r0 = com.ihoc.mgpa.i.f.q     // Catch: java.lang.Exception -> L63
            com.ihoc.mgpa.a.g r1 = com.ihoc.mgpa.a.g.PLAYING     // Catch: java.lang.Exception -> L63
            java.lang.String r1 = r1.a()     // Catch: java.lang.Exception -> L63
            int r0 = r0.compareTo(r1)     // Catch: java.lang.Exception -> L63
            if (r0 != 0) goto L6e
        L5f:
            r4.a()     // Catch: java.lang.Exception -> L63
            goto L6e
        L63:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r0 = "TGPA"
            java.lang.String r1 = "DataDealer:dealData: exception."
            com.ihoc.mgpa.n.m.a(r0, r1)
        L6e:
            r4.a(r6)
            com.ihoc.mgpa.i.f.f(r6)
            goto L27
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ihoc.mgpa.i.j.a(int, java.lang.String):void");
    }

    @Override // com.ihoc.mgpa.i.d
    public void a(int i, float[] fArr) {
        try {
            if (i == com.ihoc.mgpa.a.e.FPS.a()) {
                if (this.f5617a >= com.ihoc.mgpa.a.c.b) {
                    String str = f.q;
                    char c = 65535;
                    if (str.hashCode() == 55 && str.equals("7")) {
                        c = 0;
                    }
                    if (c == 0) {
                        return;
                    } else {
                        a();
                    }
                }
                this.f5617a++;
                if (this.c == null) {
                    this.c = new k(this.f5617a);
                }
                if (this.c.a() < com.ihoc.mgpa.a.c.c) {
                    this.c.a(com.ihoc.mgpa.n.b.a(fArr, EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR), String.format(Locale.CHINA, "%.2f", Float.valueOf(a(fArr))));
                }
                if (this.c.a() >= com.ihoc.mgpa.a.c.c) {
                    this.b.add(this.c);
                    this.c = new k(this.f5617a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.a("TGPA", "DataDealer:dealData: exception2.");
        }
    }
}
