package com.tencent.gsdk.utils.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import java.util.Map;

/* loaded from: classes2.dex */
final class g extends com.tencent.gsdk.utils.a.a {
    public String toString() {
        return "TDMReporterImpl{}";
    }

    @Override // com.tencent.gsdk.utils.a.a
    @TargetApi(11)
    boolean b(Context context, String str) {
        if (11 > Build.VERSION.SDK_INT || !(context instanceof Activity) || !h.a(context.getApplicationContext())) {
            com.tencent.gsdk.utils.g.b("TDM init failed");
            return false;
        }
        ((Activity) context).getFragmentManager().beginTransaction().add(new a(), "LifeCycleObserver").commitAllowingStateLoss();
        return true;
    }

    @Override // com.tencent.gsdk.utils.a.a
    boolean b(String str, Map<String, String> map) {
        return h.a(str, map);
    }

    @SuppressLint({"ValidFragment"})
    @TargetApi(11)
    /* loaded from: classes2.dex */
    private static class a extends Fragment {
        private a() {
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            h.a();
        }

        @Override // android.app.Fragment
        public void onStart() {
            super.onStart();
            h.b();
        }

        @Override // android.app.Fragment
        public void onPause() {
            super.onPause();
            h.c();
        }

        @Override // android.app.Fragment
        public void onStop() {
            super.onStop();
            h.d();
        }

        @Override // android.app.Fragment
        public void onDestroy() {
            super.onDestroy();
            h.e();
        }
    }
}
