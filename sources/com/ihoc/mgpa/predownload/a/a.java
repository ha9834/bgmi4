package com.ihoc.mgpa.predownload.a;

import com.ihoc.mgpa.c.g;
import com.ihoc.mgpa.g.t;
import com.ihoc.mgpa.i.m;
import com.ihoc.mgpa.n.i;
import com.tencent.smtt.sdk.TbsReaderView;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final String f5687a;
    private final String b;
    private final String c;
    private final e d;
    private final c f;
    private boolean j;
    private int e = 4;
    private final List<InterfaceC0139a> g = new ArrayList();
    private long h = -52428800;
    private volatile boolean i = false;

    /* renamed from: com.ihoc.mgpa.predownload.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0139a {
        void a(e eVar, int i, int i2);
    }

    public a(c cVar, e eVar, boolean z) {
        this.j = false;
        this.f = cVar;
        this.d = eVar;
        t.a aVar = eVar.f5689a;
        this.f5687a = aVar.f5581a;
        this.b = aVar.c;
        this.c = eVar.b;
        this.j = z;
    }

    private void a(e eVar, int i, int i2) {
        Iterator<InterfaceC0139a> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().a(eVar, i, i2);
        }
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void a(Throwable th, HashMap<String, String> hashMap) {
        if (th != null) {
            hashMap.put("errorCode", th instanceof IOException ? "1" : "0");
        }
    }

    private void a(ArrayList<String> arrayList) {
        if (i.f(new File(com.ihoc.mgpa.n.a.g() + File.separator + "noDeletePD.tmp"))) {
            return;
        }
        b(this.f.a(arrayList));
    }

    private void b(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("fileName", this.f5687a);
        hashMap.put("fileMD5", this.b);
        hashMap.put(TbsReaderView.KEY_FILE_PATH, this.c);
        hashMap.put("action", "1");
        hashMap.put("scenes", this.j ? "0" : "1");
        hashMap.put("state", z ? "1" : "2");
        m.g(hashMap);
    }

    private boolean f() {
        File file = new File(com.ihoc.mgpa.n.a.g() + File.separator + this.f5687a);
        if (!file.exists() || !file.canRead()) {
            return false;
        }
        if (this.d.f5689a.b == i.e(file)) {
            return true;
        }
        com.ihoc.mgpa.n.m.a("TGPA-MoveTask", "[checkLocalFileBySize]: file size incorrect, delete it.");
        file.delete();
        return false;
    }

    private boolean g() {
        if (!this.f5687a.endsWith(".pd")) {
            return false;
        }
        return new File(com.ihoc.mgpa.n.a.g() + File.separator + i.g(this.f5687a) + ".apk").exists();
    }

    private void h() {
        HashMap hashMap = new HashMap();
        hashMap.put("fileName", this.f5687a);
        hashMap.put("fileMD5", this.b);
        hashMap.put(TbsReaderView.KEY_FILE_PATH, this.c);
        hashMap.put("action", "0");
        hashMap.put("scenes", this.j ? "0" : "1");
        hashMap.put("state", "0");
        m.g(hashMap);
    }

    public int a() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x019e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0179 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v12, types: [java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.ihoc.mgpa.predownload.a.a] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(java.lang.String r24, java.lang.String r25, java.util.HashMap<java.lang.String, java.lang.String> r26) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ihoc.mgpa.predownload.a.a.a(java.lang.String, java.lang.String, java.util.HashMap):int");
    }

    public void a(InterfaceC0139a interfaceC0139a) {
        if (interfaceC0139a != null) {
            this.g.add(interfaceC0139a);
        }
    }

    public void a(boolean z) {
        this.j = z;
    }

    public e b() {
        return this.d;
    }

    public boolean c() {
        return this.j;
    }

    public void d() {
        this.i = true;
    }

    public void e() {
        this.i = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.b;
        return str != null && str.equals(aVar.b);
    }

    public int hashCode() {
        if (this.b == null) {
            return -1;
        }
        return this.f5687a.hashCode();
    }

    @Override // java.lang.Runnable
    public void run() {
        int a2;
        String str;
        String str2;
        com.ihoc.mgpa.n.m.a("TGPA-MoveTask", "CopyFileFromUriTask uri fileUri: " + this.c + " in state = " + this.e);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("fileName", this.f5687a);
        hashMap.put("fileMD5", this.b);
        hashMap.put(TbsReaderView.KEY_FILE_PATH, this.c);
        hashMap.put("action", "0");
        hashMap.put("owner", this.j ? "0" : "1");
        try {
            try {
                if (this.e == 4) {
                    if (!f() && !g()) {
                        long j = this.d.f5689a.b;
                        long a3 = g.c().a();
                        double d = j;
                        Double.isNaN(d);
                        if (d * 1.2d > a3) {
                            com.ihoc.mgpa.n.m.b("TGPA-MoveTask", "[moveTask]: fail: space no enough.");
                            this.e = -1;
                            a(this.d, 0, -1);
                            hashMap.put("errorCode", "4");
                            hashMap.put("state", "2");
                            return;
                        }
                        this.h = -52428800L;
                        this.e = 0;
                        h();
                        a(this.d, 0, 0);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("CopyFileFromUriTask exist in tgpa, needn't copy from");
                    sb.append(this.c);
                    com.ihoc.mgpa.n.m.a("TGPA-MoveTask", sb.toString());
                    this.e = 3;
                    a(this.d, 100, 3);
                    c cVar = this.f;
                    String str3 = this.b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.f5687a);
                    sb2.append(" exist in tgpa local and md5 is equal");
                    cVar.a(str3, true, sb2.toString());
                    return;
                }
                long nanoTime = System.nanoTime();
                a2 = a(this.c, com.ihoc.mgpa.n.a.g() + File.separator + this.f5687a, hashMap);
                double nanoTime2 = System.nanoTime() - nanoTime;
                Double.isNaN(nanoTime2);
                String format = String.format("%.2f", Float.valueOf((float) (nanoTime2 / 1.0E9d)));
                StringBuilder sb3 = new StringBuilder();
                sb3.append("copy ");
                sb3.append(this.f5687a);
                sb3.append(" took : ");
                sb3.append(format);
                sb3.append("S  copyResult: ");
                sb3.append(a2);
                sb3.append("\n");
                com.ihoc.mgpa.n.m.a("TGPA-MoveTask", sb3.toString());
                if (a2 == 3 && !f()) {
                    com.ihoc.mgpa.n.m.b("TGPA-MoveTask", "[run]: copy finish but file size is error!");
                    hashMap.put("errorCode", "3");
                    a2 = -1;
                }
            } catch (Throwable th) {
                this.e = -1;
                a(this.d, 0, -1);
                c cVar2 = this.f;
                String str4 = this.b;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("copy from ");
                sb4.append(this.c);
                sb4.append(" is failed");
                cVar2.a(str4, false, sb4.toString());
                a(th, hashMap);
                hashMap.put("state", "2");
                th.printStackTrace();
            }
            if (a2 == -1) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.f5687a);
                sb5.append(" copy from uri fail");
                com.ihoc.mgpa.n.m.a("TGPA-MoveTask", sb5.toString());
                this.e = -1;
                a(this.d, 0, -1);
                f();
                str = "state";
                str2 = "2";
            } else {
                if (a2 != 2) {
                    if (a2 == 3) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(this.f5687a);
                        sb6.append(" copy from uri success");
                        com.ihoc.mgpa.n.m.a("TGPA-MoveTask", sb6.toString());
                        this.e = 3;
                        c cVar3 = this.f;
                        String str5 = this.b;
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(this.f5687a);
                        sb7.append(" copy from uri success");
                        cVar3.a(str5, true, sb7.toString());
                        a(this.d, 100, 3);
                        hashMap.put("state", "1");
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(this.f5687a);
                        a(arrayList);
                    }
                }
                StringBuilder sb8 = new StringBuilder();
                sb8.append(this.f5687a);
                sb8.append(" copy from uri pause");
                com.ihoc.mgpa.n.m.a("TGPA-MoveTask", sb8.toString());
                this.e = 2;
                a(this.d, 0, 2);
                str = "state";
                str2 = "3";
            }
            hashMap.put(str, str2);
        } finally {
            m.g(hashMap);
        }
    }
}
