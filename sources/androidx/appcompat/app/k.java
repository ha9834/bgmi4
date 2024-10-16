package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.util.ErrorReportProvider;
import java.util.Calendar;

/* loaded from: classes.dex */
class k {

    /* renamed from: a, reason: collision with root package name */
    private static k f190a;
    private final Context b;
    private final LocationManager c;
    private final a d = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k a(Context context) {
        if (f190a == null) {
            Context applicationContext = context.getApplicationContext();
            f190a = new k(applicationContext, (LocationManager) applicationContext.getSystemService(FirebaseAnalytics.Param.LOCATION));
        }
        return f190a;
    }

    k(Context context, LocationManager locationManager) {
        this.b = context;
        this.c = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        a aVar = this.d;
        if (c()) {
            return aVar.f191a;
        }
        Location b = b();
        if (b != null) {
            a(b);
            return aVar.f191a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location a2 = androidx.core.content.b.a(this.b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        Location a3 = androidx.core.content.b.a(this.b, "android.permission.ACCESS_FINE_LOCATION") == 0 ? a("gps") : null;
        return (a3 == null || a2 == null) ? a3 != null ? a3 : a2 : a3.getTime() > a2.getTime() ? a3 : a2;
    }

    private Location a(String str) {
        try {
            if (this.c.isProviderEnabled(str)) {
                return this.c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    private boolean c() {
        return this.d.f > System.currentTimeMillis();
    }

    private void a(Location location) {
        long j;
        a aVar = this.d;
        long currentTimeMillis = System.currentTimeMillis();
        j a2 = j.a();
        a2.a(currentTimeMillis - ErrorReportProvider.BATCH_TIME, location.getLatitude(), location.getLongitude());
        long j2 = a2.f189a;
        a2.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a2.c == 1;
        long j3 = a2.b;
        long j4 = a2.f189a;
        boolean z2 = z;
        a2.a(ErrorReportProvider.BATCH_TIME + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a2.b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        aVar.f191a = z2;
        aVar.b = j2;
        aVar.c = j3;
        aVar.d = j4;
        aVar.e = j5;
        aVar.f = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f191a;
        long b;
        long c;
        long d;
        long e;
        long f;

        a() {
        }
    }
}
