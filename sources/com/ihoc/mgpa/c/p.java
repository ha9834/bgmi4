package com.ihoc.mgpa.c;

import com.ihoc.mgpa.f.H;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class p extends com.ihoc.mgpa.n.r {
    final /* synthetic */ q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(q qVar, int i, int i2) {
        super(i, i2);
        this.c = qVar;
    }

    @Override // com.ihoc.mgpa.n.r
    public void a(Map<Integer, String> map) {
        Pattern pattern;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            String value = entry.getValue();
            pattern = this.c.c;
            if (pattern.matcher(value).find()) {
                H.b().b(com.ihoc.mgpa.a.e.LIGHT_THREAD_TID.a(), String.valueOf(entry.getKey()));
            }
        }
    }
}
