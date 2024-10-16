package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import com.google.android.gms.drive.DriveFile;

@zzard
/* loaded from: classes2.dex */
public final class zzbim extends MutableContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    private Activity f2877a;
    private Context b;
    private Context c;

    public zzbim(Context context) {
        super(context);
        setBaseContext(context);
    }

    @Override // android.content.MutableContextWrapper
    public final void setBaseContext(Context context) {
        this.b = context.getApplicationContext();
        this.f2877a = context instanceof Activity ? (Activity) context : null;
        this.c = context;
        super.setBaseContext(this.b);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        Activity activity = this.f2877a;
        if (activity != null) {
            activity.startActivity(intent);
        } else {
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            this.b.startActivity(intent);
        }
    }

    public final Activity zzyd() {
        return this.f2877a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return this.c.getSystemService(str);
    }

    public final Context zzaad() {
        return this.c;
    }
}
