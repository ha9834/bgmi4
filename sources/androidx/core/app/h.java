package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.a;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class h {

    /* loaded from: classes.dex */
    public static class e {
        String A;
        Bundle B;
        int C;
        int D;
        Notification E;
        RemoteViews F;
        RemoteViews G;
        RemoteViews H;
        String I;
        int J;
        String K;
        long L;
        int M;
        boolean N;
        d O;
        Notification P;
        boolean Q;

        @Deprecated
        public ArrayList<String> R;

        /* renamed from: a, reason: collision with root package name */
        public Context f473a;
        public ArrayList<a> b;
        ArrayList<a> c;
        CharSequence d;
        CharSequence e;
        PendingIntent f;
        PendingIntent g;
        RemoteViews h;
        Bitmap i;
        CharSequence j;
        int k;
        int l;
        boolean m;
        boolean n;
        f o;
        CharSequence p;
        CharSequence[] q;
        int r;
        int s;
        boolean t;
        String u;
        boolean v;
        String w;
        boolean x;
        boolean y;
        boolean z;

        public e(Context context, String str) {
            this.b = new ArrayList<>();
            this.c = new ArrayList<>();
            this.m = true;
            this.x = false;
            this.C = 0;
            this.D = 0;
            this.J = 0;
            this.M = 0;
            this.P = new Notification();
            this.f473a = context;
            this.I = str;
            this.P.when = System.currentTimeMillis();
            this.P.audioStreamType = -1;
            this.l = 0;
            this.R = new ArrayList<>();
            this.N = true;
        }

        @Deprecated
        public e(Context context) {
            this(context, null);
        }

        public e a(long j) {
            this.P.when = j;
            return this;
        }

        public e a(int i) {
            this.P.icon = i;
            return this;
        }

        public e a(CharSequence charSequence) {
            this.d = e(charSequence);
            return this;
        }

        public e b(CharSequence charSequence) {
            this.e = e(charSequence);
            return this;
        }

        public e c(CharSequence charSequence) {
            this.j = e(charSequence);
            return this;
        }

        public e a(int i, int i2, boolean z) {
            this.r = i;
            this.s = i2;
            this.t = z;
            return this;
        }

        public e a(PendingIntent pendingIntent) {
            this.f = pendingIntent;
            return this;
        }

        public e b(PendingIntent pendingIntent) {
            this.P.deleteIntent = pendingIntent;
            return this;
        }

        public e d(CharSequence charSequence) {
            this.P.tickerText = e(charSequence);
            return this;
        }

        public e a(Bitmap bitmap) {
            this.i = b(bitmap);
            return this;
        }

        private Bitmap b(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f473a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(a.b.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(a.b.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double d = dimensionPixelSize;
            double max = Math.max(1, bitmap.getWidth());
            Double.isNaN(d);
            Double.isNaN(max);
            double d2 = d / max;
            double d3 = dimensionPixelSize2;
            double max2 = Math.max(1, bitmap.getHeight());
            Double.isNaN(d3);
            Double.isNaN(max2);
            double min = Math.min(d2, d3 / max2);
            double width = bitmap.getWidth();
            Double.isNaN(width);
            int ceil = (int) Math.ceil(width * min);
            double height = bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, ceil, (int) Math.ceil(height * min), true);
        }

        public e a(Uri uri) {
            Notification notification = this.P;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                this.P.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public e a(boolean z) {
            a(2, z);
            return this;
        }

        public e b(boolean z) {
            a(8, z);
            return this;
        }

        public e c(boolean z) {
            a(16, z);
            return this;
        }

        public e d(boolean z) {
            this.x = z;
            return this;
        }

        public e a(String str) {
            this.A = str;
            return this;
        }

        public e b(int i) {
            Notification notification = this.P;
            notification.defaults = i;
            if ((i & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        private void a(int i, boolean z) {
            if (z) {
                Notification notification = this.P;
                notification.flags = i | notification.flags;
            } else {
                Notification notification2 = this.P;
                notification2.flags = (i ^ (-1)) & notification2.flags;
            }
        }

        public e c(int i) {
            this.l = i;
            return this;
        }

        public Bundle a() {
            if (this.B == null) {
                this.B = new Bundle();
            }
            return this.B;
        }

        public e a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.b.add(new a(i, charSequence, pendingIntent));
            return this;
        }

        public e a(f fVar) {
            if (this.o != fVar) {
                this.o = fVar;
                f fVar2 = this.o;
                if (fVar2 != null) {
                    fVar2.a(this);
                }
            }
            return this;
        }

        public e d(int i) {
            this.C = i;
            return this;
        }

        public e b(String str) {
            this.I = str;
            return this;
        }

        public Notification b() {
            return new i(this).b();
        }

        protected static CharSequence e(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        protected e f474a;
        CharSequence b;
        CharSequence c;
        boolean d = false;

        public void a(Bundle bundle) {
        }

        public void a(g gVar) {
        }

        public RemoteViews b(g gVar) {
            return null;
        }

        public RemoteViews c(g gVar) {
            return null;
        }

        public RemoteViews d(g gVar) {
            return null;
        }

        public void a(e eVar) {
            if (this.f474a != eVar) {
                this.f474a = eVar;
                e eVar2 = this.f474a;
                if (eVar2 != null) {
                    eVar2.a(this);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends f {
        private Bitmap e;
        private Bitmap f;
        private boolean g;

        public b a(Bitmap bitmap) {
            this.e = bitmap;
            return this;
        }

        public b b(Bitmap bitmap) {
            this.f = bitmap;
            this.g = true;
            return this;
        }

        @Override // androidx.core.app.h.f
        public void a(g gVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(gVar.a()).setBigContentTitle(this.b).bigPicture(this.e);
                if (this.g) {
                    bigPicture.bigLargeIcon(this.f);
                }
                if (this.d) {
                    bigPicture.setSummaryText(this.c);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends f {
        private CharSequence e;

        public c a(CharSequence charSequence) {
            this.e = e.e(charSequence);
            return this;
        }

        @Override // androidx.core.app.h.f
        public void a(g gVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(gVar.a()).setBigContentTitle(this.b).bigText(this.e);
                if (this.d) {
                    bigText.setSummaryText(this.c);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Bundle f471a;
        boolean b;

        @Deprecated
        public int c;
        public CharSequence d;
        public PendingIntent e;
        private IconCompat f;
        private final l[] g;
        private final l[] h;
        private boolean i;
        private final int j;
        private final boolean k;

        public a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i != 0 ? IconCompat.a(null, "", i) : null, charSequence, pendingIntent);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, l[] lVarArr, l[] lVarArr2, boolean z, int i, boolean z2, boolean z3) {
            this.b = true;
            this.f = iconCompat;
            if (iconCompat != null && iconCompat.a() == 2) {
                this.c = iconCompat.c();
            }
            this.d = e.e(charSequence);
            this.e = pendingIntent;
            this.f471a = bundle == null ? new Bundle() : bundle;
            this.g = lVarArr;
            this.h = lVarArr2;
            this.i = z;
            this.j = i;
            this.b = z2;
            this.k = z3;
        }

        public IconCompat a() {
            int i;
            if (this.f == null && (i = this.c) != 0) {
                this.f = IconCompat.a(null, "", i);
            }
            return this.f;
        }

        public CharSequence b() {
            return this.d;
        }

        public PendingIntent c() {
            return this.e;
        }

        public Bundle d() {
            return this.f471a;
        }

        public boolean e() {
            return this.i;
        }

        public l[] f() {
            return this.g;
        }

        public int g() {
            return this.j;
        }

        public boolean h() {
            return this.k;
        }

        public l[] i() {
            return this.h;
        }

        public boolean j() {
            return this.b;
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private PendingIntent f472a;
        private PendingIntent b;
        private IconCompat c;
        private int d;
        private int e;
        private int f;

        public PendingIntent a() {
            return this.f472a;
        }

        public PendingIntent b() {
            return this.b;
        }

        public IconCompat c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }

        public boolean f() {
            return (this.f & 1) != 0;
        }

        public boolean g() {
            return (this.f & 2) != 0;
        }

        public static Notification.BubbleMetadata a(d dVar) {
            if (dVar == null) {
                return null;
            }
            Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setAutoExpandBubble(dVar.f()).setDeleteIntent(dVar.b()).setIcon(dVar.c().e()).setIntent(dVar.a()).setSuppressNotification(dVar.g());
            if (dVar.d() != 0) {
                suppressNotification.setDesiredHeight(dVar.d());
            }
            if (dVar.e() != 0) {
                suppressNotification.setDesiredHeightResId(dVar.e());
            }
            return suppressNotification.build();
        }
    }

    public static Bundle a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return j.a(notification);
        }
        return null;
    }
}
