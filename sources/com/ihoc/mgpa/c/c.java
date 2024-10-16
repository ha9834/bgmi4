package com.ihoc.mgpa.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ihoc.mgpa.dataforwardsdk.TGPADataForwardManager;
import com.ihoc.mgpa.f.H;
import com.ihoc.mgpa.f.RunnableC0236b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private b f5494a;
    private TGPADataForwardManager b;

    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f5495a = new c(null);
    }

    /* loaded from: classes2.dex */
    private class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(c cVar, com.ihoc.mgpa.c.b bVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.ihoc.mgpa.n.m.c("TGPA_DataForward", "onReceive: " + intent.getAction());
            c.this.b.bind();
        }
    }

    private c() {
        this.f5494a = new b(this, null);
    }

    /* synthetic */ c(com.ihoc.mgpa.c.b bVar) {
        this();
    }

    public static c a() {
        return a.f5495a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (com.ihoc.mgpa.i.f.J()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.ihoc.mgpa.a.h.APP_CALLBACK.a(), str);
                H.b().a(new RunnableC0236b(com.ihoc.mgpa.a.a.APP_DATEFORWARD, jSONObject.toString()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(String str) {
        TGPADataForwardManager tGPADataForwardManager = this.b;
        if (tGPADataForwardManager != null) {
            tGPADataForwardManager.updateGameInfo(str);
        }
    }

    public void b() {
        if (com.ihoc.mgpa.g.o.b().b.N) {
            Context a2 = com.ihoc.mgpa.n.a.a();
            this.b = new TGPADataForwardManager(a2);
            this.b.bind();
            this.b.registerCallBack(new com.ihoc.mgpa.c.b(this));
            a2.registerReceiver(this.f5494a, new IntentFilter("com.ihoc.mgpa.ACTION_DATAFORWARD_REQUEST"));
        }
    }
}
