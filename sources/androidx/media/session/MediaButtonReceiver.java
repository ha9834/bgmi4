package androidx.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

/* loaded from: classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName a2 = a(context, "android.intent.action.MEDIA_BUTTON");
        if (a2 != null) {
            intent.setComponent(a2);
            a(context, intent);
            return;
        }
        ComponentName a3 = a(context, "android.media.browse.MediaBrowserService");
        if (a3 != null) {
            BroadcastReceiver.PendingResult goAsync = goAsync();
            Context applicationContext = context.getApplicationContext();
            a aVar = new a(applicationContext, intent, goAsync);
            MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, a3, aVar, null);
            aVar.a(mediaBrowserCompat);
            mediaBrowserCompat.a();
            return;
        }
        throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    }

    /* loaded from: classes.dex */
    private static class a extends MediaBrowserCompat.b {
        private final Context c;
        private final Intent d;
        private final BroadcastReceiver.PendingResult e;
        private MediaBrowserCompat f;

        a(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.c = context;
            this.d = intent;
            this.e = pendingResult;
        }

        void a(MediaBrowserCompat mediaBrowserCompat) {
            this.f = mediaBrowserCompat;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void a() {
            try {
                new MediaControllerCompat(this.c, this.f.c()).a((KeyEvent) this.d.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (RemoteException e) {
                Log.e("MediaButtonReceiver", "Failed to create a media controller", e);
            }
            d();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void b() {
            d();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void c() {
            d();
        }

        private void d() {
            this.f.b();
            this.e.finish();
        }
    }

    private static void a(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    private static ComponentName a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ResolveInfo resolveInfo = queryIntentServices.get(0);
            return new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        }
        if (queryIntentServices.isEmpty()) {
            return null;
        }
        throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + queryIntentServices.size());
    }
}
