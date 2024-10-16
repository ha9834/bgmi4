package androidx.core.c;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.b.e;
import androidx.b.g;
import androidx.core.c.c;
import androidx.core.content.a.f;
import androidx.core.graphics.l;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static final e<String, Typeface> f482a = new e<>(16);
    private static final androidx.core.c.c d = new androidx.core.c.c("fonts", 10, 10000);
    static final Object b = new Object();
    static final g<String, ArrayList<c.a<c>>> c = new g<>();
    private static final Comparator<byte[]> e = new Comparator<byte[]>() { // from class: androidx.core.c.b.4
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return bArr[i] - bArr2[i];
                }
            }
            return 0;
        }
    };

    static c a(Context context, androidx.core.c.a aVar, int i) {
        try {
            a a2 = a(context, (CancellationSignal) null, aVar);
            if (a2.a() == 0) {
                Typeface a3 = androidx.core.graphics.e.a(context, null, a2.b(), i);
                return new c(a3, a3 != null ? 0 : -3);
            }
            return new c(null, a2.a() == 1 ? -2 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new c(null, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        final Typeface f488a;
        final int b;

        c(Typeface typeface, int i) {
            this.f488a = typeface;
            this.b = i;
        }
    }

    public static Typeface a(final Context context, final androidx.core.c.a aVar, final f.a aVar2, final Handler handler, boolean z, int i, final int i2) {
        final String str = aVar.f() + "-" + i2;
        Typeface typeface = f482a.get(str);
        if (typeface != null) {
            if (aVar2 != null) {
                aVar2.a(typeface);
            }
            return typeface;
        }
        if (z && i == -1) {
            c a2 = a(context, aVar, i2);
            if (aVar2 != null) {
                if (a2.b == 0) {
                    aVar2.a(a2.f488a, handler);
                } else {
                    aVar2.a(a2.b, handler);
                }
            }
            return a2.f488a;
        }
        Callable<c> callable = new Callable<c>() { // from class: androidx.core.c.b.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c call() throws Exception {
                c a3 = b.a(context, aVar, i2);
                if (a3.f488a != null) {
                    b.f482a.put(str, a3.f488a);
                }
                return a3;
            }
        };
        if (z) {
            try {
                return ((c) d.a(callable, i)).f488a;
            } catch (InterruptedException unused) {
                return null;
            }
        }
        c.a<c> aVar3 = aVar2 == null ? null : new c.a<c>() { // from class: androidx.core.c.b.2
            @Override // androidx.core.c.c.a
            public void a(c cVar) {
                if (cVar == null) {
                    f.a.this.a(1, handler);
                } else if (cVar.b == 0) {
                    f.a.this.a(cVar.f488a, handler);
                } else {
                    f.a.this.a(cVar.b, handler);
                }
            }
        };
        synchronized (b) {
            ArrayList<c.a<c>> arrayList = c.get(str);
            if (arrayList != null) {
                if (aVar3 != null) {
                    arrayList.add(aVar3);
                }
                return null;
            }
            if (aVar3 != null) {
                ArrayList<c.a<c>> arrayList2 = new ArrayList<>();
                arrayList2.add(aVar3);
                c.put(str, arrayList2);
            }
            d.a(callable, new c.a<c>() { // from class: androidx.core.c.b.3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // androidx.core.c.c.a
                public void a(c cVar) {
                    synchronized (b.b) {
                        ArrayList<c.a<c>> arrayList3 = b.c.get(str);
                        if (arrayList3 == null) {
                            return;
                        }
                        b.c.remove(str);
                        for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                            arrayList3.get(i3).a(cVar);
                        }
                    }
                }
            });
            return null;
        }
    }

    /* renamed from: androidx.core.c.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0043b {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f487a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;

        public C0043b(Uri uri, int i, int i2, boolean z, int i3) {
            this.f487a = (Uri) androidx.core.e.e.a(uri);
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        public Uri a() {
            return this.f487a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f486a;
        private final C0043b[] b;

        public a(int i, C0043b[] c0043bArr) {
            this.f486a = i;
            this.b = c0043bArr;
        }

        public int a() {
            return this.f486a;
        }

        public C0043b[] b() {
            return this.b;
        }
    }

    public static Map<Uri, ByteBuffer> a(Context context, C0043b[] c0043bArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (C0043b c0043b : c0043bArr) {
            if (c0043b.e() == 0) {
                Uri a2 = c0043b.a();
                if (!hashMap.containsKey(a2)) {
                    hashMap.put(a2, l.a(context, cancellationSignal, a2));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static a a(Context context, CancellationSignal cancellationSignal, androidx.core.c.a aVar) throws PackageManager.NameNotFoundException {
        ProviderInfo a2 = a(context.getPackageManager(), aVar, context.getResources());
        if (a2 == null) {
            return new a(1, null);
        }
        return new a(0, a(context, aVar, a2.authority, cancellationSignal));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ProviderInfo a(PackageManager packageManager, androidx.core.c.a aVar, Resources resources) throws PackageManager.NameNotFoundException {
        String a2 = aVar.a();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(a2, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + a2);
        }
        if (!resolveContentProvider.packageName.equals(aVar.b())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + a2 + ", but package was not " + aVar.b());
        }
        List<byte[]> a3 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
        Collections.sort(a3, e);
        List<List<byte[]>> a4 = a(aVar, resources);
        for (int i = 0; i < a4.size(); i++) {
            ArrayList arrayList = new ArrayList(a4.get(i));
            Collections.sort(arrayList, e);
            if (a(a3, arrayList)) {
                return resolveContentProvider;
            }
        }
        return null;
    }

    private static List<List<byte[]>> a(androidx.core.c.a aVar, Resources resources) {
        if (aVar.d() != null) {
            return aVar.d();
        }
        return androidx.core.content.a.c.a(resources, aVar.e());
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static C0043b[] a(Context context, androidx.core.c.a aVar, String str, CancellationSignal cancellationSignal) {
        Uri withAppendedId;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(str).build();
        Uri build2 = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(str).appendPath(TransferTable.COLUMN_FILE).build();
        Cursor cursor = null;
        try {
            if (Build.VERSION.SDK_INT > 16) {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.c()}, null, cancellationSignal);
            } else {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.c()}, null);
            }
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    arrayList2.add(new C0043b(withAppendedId, i2, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i));
                }
                arrayList = arrayList2;
            }
            return (C0043b[]) arrayList.toArray(new C0043b[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
