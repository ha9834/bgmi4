package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class RemoteCreator<T> {

    /* renamed from: a, reason: collision with root package name */
    private final String f1585a;
    private T b;

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public RemoteCreator(String str) {
        this.f1585a = str;
    }

    @KeepForSdk
    protected abstract T getRemoteCreator(IBinder iBinder);

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class RemoteCreatorException extends Exception {
        public RemoteCreatorException(String str) {
            super(str);
        }

        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public final T a(Context context) throws RemoteCreatorException {
        if (this.b == null) {
            Preconditions.checkNotNull(context);
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext == null) {
                throw new RemoteCreatorException("Could not get remote context.");
            }
            try {
                this.b = getRemoteCreator((IBinder) remoteContext.getClassLoader().loadClass(this.f1585a).newInstance());
            } catch (ClassNotFoundException e) {
                throw new RemoteCreatorException("Could not load creator class.", e);
            } catch (IllegalAccessException e2) {
                throw new RemoteCreatorException("Could not access creator.", e2);
            } catch (InstantiationException e3) {
                throw new RemoteCreatorException("Could not instantiate creator.", e3);
            }
        }
        return this.b;
    }
}
