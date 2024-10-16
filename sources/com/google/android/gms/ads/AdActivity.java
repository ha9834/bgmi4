package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaqg;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzyt;

@KeepForSdkWithMembers
/* loaded from: classes.dex */
public class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";

    /* renamed from: a, reason: collision with root package name */
    private zzaqg f1117a;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1117a = zzyt.zzpb().zzb(this);
        zzaqg zzaqgVar = this.f1117a;
        if (zzaqgVar == null) {
            zzbad.zze("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            zzaqgVar.onCreate(bundle);
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        try {
            if (this.f1117a != null) {
                this.f1117a.onRestart();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        try {
            if (this.f1117a != null) {
                this.f1117a.onStart();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            if (this.f1117a != null) {
                this.f1117a.onResume();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            if (this.f1117a != null) {
                this.f1117a.onPause();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.f1117a != null) {
                this.f1117a.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStop() {
        try {
            if (this.f1117a != null) {
                this.f1117a.onStop();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            if (this.f1117a != null) {
                this.f1117a.onDestroy();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    private final void a() {
        zzaqg zzaqgVar = this.f1117a;
        if (zzaqgVar != null) {
            try {
                zzaqgVar.zzdd();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
        a();
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        super.setContentView(view);
        a();
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        a();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.f1117a != null) {
                z = this.f1117a.zztg();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.f1117a.onActivityResult(i, i2, intent);
        } catch (Exception e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.f1117a.zzac(ObjectWrapper.wrap(configuration));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}
