package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";

    /* renamed from: a, reason: collision with root package name */
    private static final GoogleApiAvailabilityLight f5051a = GoogleApiAvailabilityLight.getInstance();
    private static final Object b = new Object();
    private static Method c = null;

    /* loaded from: classes2.dex */
    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        Preconditions.checkNotNull(context, "Context must not be null");
        f5051a.verifyGooglePlayServicesIsAvailable(context, 11925000);
        Context a2 = a(context);
        if (a2 == null) {
            a2 = b(context);
        }
        if (a2 == null) {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        synchronized (b) {
            try {
                if (c == null) {
                    c = a2.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", Context.class);
                }
                c.invoke(null, a2);
            } catch (Exception e) {
                e = e;
                Throwable cause = e.getCause();
                if (Log.isLoggable("ProviderInstaller", 6)) {
                    String valueOf = String.valueOf(cause == null ? e.getMessage() : cause.getMessage());
                    Log.e("ProviderInstaller", valueOf.length() != 0 ? "Failed to install provider: ".concat(valueOf) : new String("Failed to install provider: "));
                }
                if (cause != null) {
                    e = cause;
                }
                CrashUtils.addDynamiteErrorToDropBox(context, e);
                throw new GooglePlayServicesNotAvailableException(8);
            } finally {
            }
        }
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerInstallListener) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new a(context, providerInstallListener).execute(new Void[0]);
    }

    private static Context a(Context context) {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "providerinstaller").getModuleContext();
        } catch (DynamiteModule.LoadingException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("ProviderInstaller", valueOf.length() != 0 ? "Failed to load providerinstaller module: ".concat(valueOf) : new String("Failed to load providerinstaller module: "));
            return null;
        }
    }

    private static Context b(Context context) {
        try {
            return GooglePlayServicesUtilLight.getRemoteContext(context);
        } catch (Resources.NotFoundException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("ProviderInstaller", valueOf.length() != 0 ? "Failed to load GMS Core context for providerinstaller: ".concat(valueOf) : new String("Failed to load GMS Core context for providerinstaller: "));
            CrashUtils.addDynamiteErrorToDropBox(context, e);
            return null;
        }
    }
}
