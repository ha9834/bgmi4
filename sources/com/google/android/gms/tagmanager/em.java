package com.google.android.gms.tagmanager;

import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tagmanager.ContainerHolder;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class em implements ContainerHolder {

    /* renamed from: a, reason: collision with root package name */
    private final Looper f5140a;
    private Container b;
    private Container c;
    private Status d;
    private en e;
    private zzw f;
    private boolean g;
    private TagManager h;

    public em(Status status) {
        this.d = status;
        this.f5140a = null;
    }

    public em(TagManager tagManager, Looper looper, Container container, zzw zzwVar) {
        this.h = tagManager;
        this.f5140a = looper == null ? Looper.getMainLooper() : looper;
        this.b = container;
        this.f = zzwVar;
        this.d = Status.RESULT_SUCCESS;
        tagManager.zza(this);
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.d;
    }

    @Override // com.google.android.gms.tagmanager.ContainerHolder
    public final synchronized Container getContainer() {
        if (this.g) {
            zzdi.zzav("ContainerHolder is released.");
            return null;
        }
        if (this.c != null) {
            this.b = this.c;
            this.c = null;
        }
        return this.b;
    }

    @Override // com.google.android.gms.tagmanager.ContainerHolder
    public final synchronized void setContainerAvailableListener(ContainerHolder.ContainerAvailableListener containerAvailableListener) {
        if (this.g) {
            zzdi.zzav("ContainerHolder is released.");
        } else {
            if (containerAvailableListener == null) {
                this.e = null;
                return;
            }
            this.e = new en(this, containerAvailableListener, this.f5140a);
            if (this.c != null) {
                c();
            }
        }
    }

    @Override // com.google.android.gms.tagmanager.ContainerHolder
    public final synchronized void refresh() {
        if (this.g) {
            zzdi.zzav("Refreshing a released ContainerHolder.");
        } else {
            this.f.zzhe();
        }
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final synchronized void release() {
        if (this.g) {
            zzdi.zzav("Releasing a released ContainerHolder.");
            return;
        }
        this.g = true;
        this.h.zzb(this);
        this.b.a();
        this.b = null;
        this.c = null;
        this.f = null;
        this.e = null;
    }

    public final synchronized void a(Container container) {
        if (this.g) {
            return;
        }
        this.c = container;
        c();
    }

    public final synchronized void a(String str) {
        if (this.g) {
            return;
        }
        this.b.zzan(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        if (this.g) {
            zzdi.zzav("getContainerId called on a released ContainerHolder.");
            return "";
        }
        return this.b.getContainerId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str) {
        if (this.g) {
            zzdi.zzav("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.f.zzao(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b() {
        if (this.g) {
            zzdi.zzav("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
            return "";
        }
        return this.f.zzhc();
    }

    private final void c() {
        en enVar = this.e;
        if (enVar != null) {
            enVar.sendMessage(enVar.obtainMessage(1, this.c.zzha()));
        }
    }
}
