package com.subao.common.e;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ao extends com.subao.common.g<a> {

    /* renamed from: a, reason: collision with root package name */
    private static final ao f5972a = new ao();
    private com.subao.common.f.c[] b;
    private String c;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str);
    }

    private ao() {
    }

    public static ao b() {
        return f5972a;
    }

    public static boolean a(String str) {
        return (str == null || str.length() != 36 || "00000000-0000-0000-0000-000000000000".equals(str)) ? false : true;
    }

    private static boolean d() {
        return com.subao.common.d.a("SubaoData");
    }

    private static com.subao.common.f.c[] b(Context context) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        return new com.subao.common.f.c[]{com.subao.common.f.d.a(new File(externalStorageDirectory, ".sys")), com.subao.common.f.d.a(new File(new File(externalStorageDirectory, "Android"), ".sys")), com.subao.common.f.d.a(new File(new File(externalStorageDirectory, "9C52E85A-374A-4709-866F-0E708AE2B727"), ".sys")), com.subao.common.f.d.a(new File(context.getFilesDir(), ".sys"))};
    }

    private static String a(com.subao.common.f.c[] cVarArr) {
        Pair<String, Integer> b = b(cVarArr);
        if (b == null) {
            com.subao.common.d.a("SubaoData", "No SubaoId load, maybe first install");
            return null;
        }
        String str = (String) b.first;
        if (((Integer) b.second).intValue() != cVarArr.length) {
            a(cVarArr, str);
        }
        return str;
    }

    private static Pair<String, Integer> b(com.subao.common.f.c[] cVarArr) {
        ArrayList<Pair<String, Integer>> arrayList = new ArrayList(cVarArr.length);
        for (com.subao.common.f.c cVar : cVarArr) {
            if (cVar != null) {
                a(arrayList, a(cVar));
            }
        }
        Pair<String, Integer> pair = null;
        for (Pair<String, Integer> pair2 : arrayList) {
            if (pair == null || ((Integer) pair.second).intValue() < ((Integer) pair2.second).intValue()) {
                pair = pair2;
            }
        }
        return pair;
    }

    private static void a(List<Pair<String, Integer>> list, String str) {
        if (str == null || str.length() != 36) {
            return;
        }
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            Pair<String, Integer> pair = list.get(size);
            if (com.subao.common.n.h.a(str, (CharSequence) pair.first)) {
                list.set(size, new Pair<>(pair.first, Integer.valueOf(((Integer) pair.second).intValue() + 1)));
                break;
            }
            size--;
        }
        if (size < 0) {
            list.add(new Pair<>(str, 1));
        }
    }

    private static String a(com.subao.common.f.c cVar) {
        String str = null;
        if (cVar.a()) {
            try {
                byte[] a2 = cVar.a(512);
                if (a2 != null) {
                    str = new String(a2);
                }
            } catch (IOException | RuntimeException unused) {
            }
        }
        if (d()) {
            Log.d("SubaoData", String.format("Load SubaoId [%s] from \"%s\"", com.subao.common.n.h.a((Object) str), cVar.f()));
        }
        return str;
    }

    private static void a(com.subao.common.f.c[] cVarArr, String str) {
        if (TextUtils.isEmpty(str)) {
            c(cVarArr);
            return;
        }
        boolean d = d();
        for (com.subao.common.f.c cVar : cVarArr) {
            if (cVar != null) {
                boolean a2 = a(cVar, str);
                if (d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Save SubaoId to ");
                    sb.append(cVar.f());
                    sb.append(a2 ? " ok" : " failed");
                    Log.d("SubaoData", sb.toString());
                }
            }
        }
    }

    private static boolean a(com.subao.common.f.c cVar, String str) {
        boolean z;
        OutputStream outputStream = null;
        try {
            outputStream = cVar.c();
            outputStream.write(str.getBytes());
            z = true;
        } catch (IOException | RuntimeException unused) {
            z = false;
        } catch (Throwable th) {
            com.subao.common.e.a(outputStream);
            throw th;
        }
        com.subao.common.e.a(outputStream);
        return z;
    }

    private static void c(com.subao.common.f.c[] cVarArr) {
        boolean z;
        if (cVarArr == null) {
            return;
        }
        for (com.subao.common.f.c cVar : cVarArr) {
            if (cVar != null) {
                try {
                    z = cVar.d();
                } catch (RuntimeException unused) {
                    z = false;
                }
                if (d()) {
                    Object[] objArr = new Object[2];
                    objArr[0] = cVar.f();
                    objArr[1] = z ? "OK" : "failed";
                    com.subao.common.d.a("SubaoData", String.format("Delete file \"%s\" %s", objArr));
                }
            }
        }
    }

    public void a(Context context) {
        a(context, (com.subao.common.f.c[]) null);
    }

    void a(Context context, com.subao.common.f.c[] cVarArr) {
        if (cVarArr == null) {
            cVarArr = b(context);
        }
        this.b = cVarArr;
        b(a(cVarArr));
    }

    public String c() {
        return this.c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void b(String str) {
        if (d()) {
            Log.d("SubaoData", "set SubaoId: " + str);
        }
        if (!com.subao.common.n.h.a((CharSequence) this.c, (CharSequence) str)) {
            this.c = str;
            a(this.b, str);
            List<a> a2 = a();
            if (a2 != null) {
                Iterator<a> it = a2.iterator();
                while (it.hasNext()) {
                    it.next().a(str);
                }
            }
        }
    }
}
