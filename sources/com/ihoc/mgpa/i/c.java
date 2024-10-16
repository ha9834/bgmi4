package com.ihoc.mgpa.i;

import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.Locale;

/* loaded from: classes2.dex */
public class c extends d {

    /* renamed from: a, reason: collision with root package name */
    private k f5611a = null;

    @Override // com.ihoc.mgpa.i.d
    public void a(int i, String str) {
        int i2 = b.f5610a[com.ihoc.mgpa.a.e.a(i).ordinal()];
        if (i2 == 1) {
            a(str);
            f.f(str);
        } else if (i2 == 2 || i2 == 3) {
            f.a(com.ihoc.mgpa.a.e.COMMOND_ID.a(), String.valueOf(h.a()));
        }
        f.a(i, str);
    }

    @Override // com.ihoc.mgpa.i.d
    public void a(int i, float[] fArr) {
        try {
            if (i == com.ihoc.mgpa.a.e.FPS.a()) {
                if (this.f5611a == null) {
                    this.f5611a = new k(0);
                }
                if (this.f5611a.a() < com.ihoc.mgpa.a.c.c) {
                    this.f5611a.a(com.ihoc.mgpa.n.b.a(fArr, EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR), String.format(Locale.CHINA, "%.2f", Float.valueOf(a(fArr))));
                }
                if (this.f5611a.a() >= com.ihoc.mgpa.a.c.c) {
                    m.l(this.f5611a.b);
                    this.f5611a = new k(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.a("TGPA", "DataDealer:dealData: exception2.");
        }
    }
}
