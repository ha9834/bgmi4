package com.ihoc.mgpa.h;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class o implements n {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f5600a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(p pVar) {
        this.f5600a = pVar;
    }

    @Override // com.ihoc.mgpa.h.n
    public void a(String str) {
        if (str == null) {
            Log.d("TGPA_MID", "OAID get failed, this manufacture get null. ");
            str = "-11";
        }
        String unused = p.f5601a = str;
        this.f5600a.c();
    }
}
