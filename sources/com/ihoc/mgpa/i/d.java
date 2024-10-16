package com.ihoc.mgpa.i;

import com.tencent.midas.oversea.api.CocosPayHelper;

/* loaded from: classes2.dex */
public class d {
    /* JADX INFO: Access modifiers changed from: protected */
    public float a(float[] fArr) {
        float f = 0.0f;
        for (float f2 : fArr) {
            f += f2;
        }
        return f / fArr.length;
    }

    public void a(int i, String str) {
        throw null;
    }

    public void a(int i, float[] fArr) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (f.q.compareTo(CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR) == 0) {
            f.b(currentTimeMillis);
        } else {
            if (f.q.compareTo(str) == 0) {
                return;
            }
            m.b(str, f.q);
            f.b(currentTimeMillis);
        }
    }
}
