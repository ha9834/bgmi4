package com.subao.common.e;

import android.os.AsyncTask;
import com.subao.common.j.b;
import java.io.IOException;
import java.net.URL;

/* loaded from: classes2.dex */
public class h extends AsyncTask<a, Void, Boolean> {

    /* renamed from: a, reason: collision with root package name */
    private final String f5988a;
    private final an b;
    private final String c;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z);
    }

    private h(String str, an anVar, String str2) {
        this.f5988a = str;
        this.b = anVar;
        this.c = str2;
    }

    public static void a(String str, an anVar, String str2, a aVar) {
        new h(str, new an(null, anVar.b, anVar.c), str2).executeOnExecutor(com.subao.common.m.d.a(), aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(a... aVarArr) {
        boolean z;
        com.subao.common.j.b bVar = new com.subao.common.j.b(15000, 15000);
        try {
            String str = this.b.f5971a;
            String str2 = this.b.b;
            int i = this.b.c;
            StringBuilder sb = new StringBuilder();
            sb.append("/api/v1/");
            sb.append(this.f5988a);
            sb.append("/counters/");
            sb.append(this.c);
            z = com.subao.common.j.b.a(bVar.a(new URL(str, str2, i, sb.toString()), b.EnumC0172b.POST, b.a.JSON.e), (byte[]) null).f6066a == 201;
        } catch (IOException e) {
            e.printStackTrace();
            z = false;
            aVarArr[0].a(z);
            return Boolean.valueOf(z);
        } catch (RuntimeException e2) {
            e2.printStackTrace();
            z = false;
            aVarArr[0].a(z);
            return Boolean.valueOf(z);
        }
        aVarArr[0].a(z);
        return Boolean.valueOf(z);
    }
}
