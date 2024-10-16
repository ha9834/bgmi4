package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends DataSetObservable {

    /* renamed from: a, reason: collision with root package name */
    static final String f348a = "c";
    private static final Object e = new Object();
    private static final Map<String, c> f = new HashMap();
    final Context b;
    final String c;
    boolean d;
    private final Object g;
    private final List<a> h;
    private final List<C0032c> i;
    private Intent j;
    private b k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private d p;

    /* loaded from: classes.dex */
    public interface b {
        void a(Intent intent, List<a> list, List<C0032c> list2);
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean a(c cVar, Intent intent);
    }

    public int a() {
        int size;
        synchronized (this.g) {
            d();
            size = this.h.size();
        }
        return size;
    }

    public ResolveInfo a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.g) {
            d();
            resolveInfo = this.h.get(i).f349a;
        }
        return resolveInfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int a(ResolveInfo resolveInfo) {
        synchronized (this.g) {
            d();
            List<a> list = this.h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).f349a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public Intent b(int i) {
        synchronized (this.g) {
            if (this.j == null) {
                return null;
            }
            d();
            a aVar = this.h.get(i);
            ComponentName componentName = new ComponentName(aVar.f349a.activityInfo.packageName, aVar.f349a.activityInfo.name);
            Intent intent = new Intent(this.j);
            intent.setComponent(componentName);
            if (this.p != null) {
                if (this.p.a(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new C0032c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo b() {
        synchronized (this.g) {
            d();
            if (this.h.isEmpty()) {
                return null;
            }
            return this.h.get(0).f349a;
        }
    }

    public void c(int i) {
        synchronized (this.g) {
            d();
            a aVar = this.h.get(i);
            a aVar2 = this.h.get(0);
            a(new C0032c(new ComponentName(aVar.f349a.activityInfo.packageName, aVar.f349a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.b - aVar.b) + 5.0f : 1.0f));
        }
    }

    private void c() {
        if (!this.m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.n) {
            this.n = false;
            if (TextUtils.isEmpty(this.c)) {
                return;
            }
            new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.i), this.c);
        }
    }

    private void d() {
        boolean f2 = f() | g();
        h();
        if (f2) {
            e();
            notifyChanged();
        }
    }

    private boolean e() {
        if (this.k == null || this.j == null || this.h.isEmpty() || this.i.isEmpty()) {
            return false;
        }
        this.k.a(this.j, this.h, Collections.unmodifiableList(this.i));
        return true;
    }

    private boolean f() {
        if (!this.o || this.j == null) {
            return false;
        }
        this.o = false;
        this.h.clear();
        List<ResolveInfo> queryIntentActivities = this.b.getPackageManager().queryIntentActivities(this.j, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.h.add(new a(queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean g() {
        if (!this.d || !this.n || TextUtils.isEmpty(this.c)) {
            return false;
        }
        this.d = false;
        this.m = true;
        i();
        return true;
    }

    private boolean a(C0032c c0032c) {
        boolean add = this.i.add(c0032c);
        if (add) {
            this.n = true;
            h();
            c();
            e();
            notifyChanged();
        }
        return add;
    }

    private void h() {
        int size = this.i.size() - this.l;
        if (size <= 0) {
            return;
        }
        this.n = true;
        for (int i = 0; i < size; i++) {
            this.i.remove(0);
        }
    }

    /* renamed from: androidx.appcompat.widget.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0032c {

        /* renamed from: a, reason: collision with root package name */
        public final ComponentName f350a;
        public final long b;
        public final float c;

        public C0032c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public C0032c(ComponentName componentName, long j, float f) {
            this.f350a = componentName;
            this.b = j;
            this.c = f;
        }

        public int hashCode() {
            ComponentName componentName = this.f350a;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.b;
            return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0032c c0032c = (C0032c) obj;
            ComponentName componentName = this.f350a;
            if (componentName == null) {
                if (c0032c.f350a != null) {
                    return false;
                }
            } else if (!componentName.equals(c0032c.f350a)) {
                return false;
            }
            return this.b == c0032c.b && Float.floatToIntBits(this.c) == Float.floatToIntBits(c0032c.c);
        }

        public String toString() {
            return "[; activity:" + this.f350a + "; time:" + this.b + "; weight:" + new BigDecimal(this.c) + "]";
        }
    }

    /* loaded from: classes.dex */
    public static final class a implements Comparable<a> {

        /* renamed from: a, reason: collision with root package name */
        public final ResolveInfo f349a;
        public float b;

        public a(ResolveInfo resolveInfo) {
            this.f349a = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.b) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.b) == Float.floatToIntBits(((a) obj).b);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return Float.floatToIntBits(aVar.b) - Float.floatToIntBits(this.b);
        }

        public String toString() {
            return "[resolveInfo:" + this.f349a.toString() + "; weight:" + new BigDecimal(this.b) + "]";
        }
    }

    private void i() {
        XmlPullParser newPullParser;
        try {
            FileInputStream openFileInput = this.b.openFileInput(this.c);
            try {
                try {
                    try {
                        newPullParser = Xml.newPullParser();
                        newPullParser.setInput(openFileInput, "UTF-8");
                        for (int i = 0; i != 1 && i != 2; i = newPullParser.next()) {
                        }
                    } catch (Throwable th) {
                        if (openFileInput != null) {
                            try {
                                openFileInput.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (XmlPullParserException e2) {
                    Log.e(f348a, "Error reading historical recrod file: " + this.c, e2);
                    if (openFileInput == null) {
                        return;
                    }
                }
            } catch (IOException e3) {
                Log.e(f348a, "Error reading historical recrod file: " + this.c, e3);
                if (openFileInput == null) {
                    return;
                }
            }
            if (!"historical-records".equals(newPullParser.getName())) {
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            }
            List<C0032c> list = this.i;
            list.clear();
            while (true) {
                int next = newPullParser.next();
                if (next == 1) {
                    if (openFileInput == null) {
                        return;
                    }
                } else if (next != 3 && next != 4) {
                    if (!"historical-record".equals(newPullParser.getName())) {
                        throw new XmlPullParserException("Share records file not well-formed.");
                    }
                    list.add(new C0032c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                }
            }
            try {
                openFileInput.close();
            } catch (IOException unused2) {
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class e extends AsyncTask<Object, Void, Void> {
        e() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x006f, code lost:
        
            if (r12 != null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x00dd, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0071, code lost:
        
            r12.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00b8, code lost:
        
            if (r12 == null) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0096, code lost:
        
            if (r12 == null) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00da, code lost:
        
            if (r12 == null) goto L30;
         */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Void doInBackground(java.lang.Object... r12) {
            /*
                Method dump skipped, instructions count: 256
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.c.e.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }
}
