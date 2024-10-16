package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@VisibleForTesting
/* loaded from: classes2.dex */
public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f5064a = "gtm.lifetime".toString().split("\\.");
    private static final Pattern b = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<b, Integer> c;
    private final Map<String, Object> d;
    private final ReentrantLock e;
    private final LinkedList<Map<String, Object>> f;
    private final c g;
    private final CountDownLatch h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface b {
        void a(Map<String, Object> map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface c {
        void a(zzaq zzaqVar);

        void a(String str);

        void a(List<a> list, long j);
    }

    @VisibleForTesting
    DataLayer() {
        this(new m());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataLayer(c cVar) {
        this.g = cVar;
        this.c = new ConcurrentHashMap<>();
        this.d = new HashMap();
        this.e = new ReentrantLock();
        this.f = new LinkedList<>();
        this.h = new CountDownLatch(1);
        this.g.a(new n(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f5065a;
        public final Object b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(String str, Object obj) {
            this.f5065a = str;
            this.b = obj;
        }

        public final String toString() {
            String str = this.f5065a;
            String obj = this.b.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(obj).length());
            sb.append("Key: ");
            sb.append(str);
            sb.append(" value: ");
            sb.append(obj);
            return sb.toString();
        }

        public final int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.f5065a.hashCode()), Integer.valueOf(this.b.hashCode())});
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5065a.equals(aVar.f5065a) && this.b.equals(aVar.b);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        String sb;
        synchronized (this.d) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry<String, Object> entry : this.d.entrySet()) {
                sb2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", entry.getKey(), entry.getValue()));
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public void pushEvent(String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap(map);
        hashMap.put(EVENT_KEY, str);
        push(hashMap);
    }

    public void push(String str, Object obj) {
        push(a(str, obj));
    }

    public void push(Map<String, Object> map) {
        try {
            this.h.await();
        } catch (InterruptedException unused) {
            zzdi.zzac("DataLayer.push: unexpected InterruptedException");
        }
        a(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(Map<String, Object> map) {
        Long l;
        this.e.lock();
        try {
            this.f.offer(map);
            int i = 0;
            if (this.e.getHoldCount() == 1) {
                int i2 = 0;
                do {
                    Map<String, Object> poll = this.f.poll();
                    if (poll != null) {
                        synchronized (this.d) {
                            for (String str : poll.keySet()) {
                                a(a(str, poll.get(str)), this.d);
                            }
                        }
                        Iterator<b> it = this.c.keySet().iterator();
                        while (it.hasNext()) {
                            it.next().a(poll);
                        }
                        i2++;
                    }
                } while (i2 <= 500);
                this.f.clear();
                throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
            }
            String[] strArr = f5064a;
            int length = strArr.length;
            Object obj = map;
            while (true) {
                l = null;
                if (i >= length) {
                    break;
                }
                String str2 = strArr[i];
                if (!(obj instanceof Map)) {
                    obj = null;
                    break;
                } else {
                    obj = ((Map) obj).get(str2);
                    i++;
                }
            }
            if (obj != null) {
                l = b(obj.toString());
            }
            if (l != null) {
                ArrayList arrayList = new ArrayList();
                a(map, "", arrayList);
                this.g.a(arrayList, l.longValue());
            }
        } finally {
            this.e.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str) {
        push(str, null);
        this.g.a(str);
    }

    private final void a(Map<String, Object> map, String str, Collection<a> collection) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String str2 = str.length() == 0 ? "" : ".";
            String key = entry.getKey();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(key).length());
            sb.append(str);
            sb.append(str2);
            sb.append(key);
            String sb2 = sb.toString();
            if (entry.getValue() instanceof Map) {
                a((Map) entry.getValue(), sb2, collection);
            } else if (!sb2.equals("gtm.lifetime")) {
                collection.add(new a(sb2, entry.getValue()));
            }
        }
    }

    @VisibleForTesting
    private static Long b(String str) {
        long j;
        Matcher matcher = b.matcher(str);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(str);
            zzdi.zzaw(valueOf.length() != 0 ? "unknown _lifetime: ".concat(valueOf) : new String("unknown _lifetime: "));
            return null;
        }
        try {
            j = Long.parseLong(matcher.group(1));
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(str);
            zzdi.zzac(valueOf2.length() != 0 ? "illegal number in _lifetime value: ".concat(valueOf2) : new String("illegal number in _lifetime value: "));
            j = 0;
        }
        if (j <= 0) {
            String valueOf3 = String.valueOf(str);
            zzdi.zzaw(valueOf3.length() != 0 ? "non-positive _lifetime: ".concat(valueOf3) : new String("non-positive _lifetime: "));
            return null;
        }
        String group = matcher.group(2);
        if (group.length() == 0) {
            return Long.valueOf(j);
        }
        char charAt = group.charAt(0);
        if (charAt == 'd') {
            return Long.valueOf(j * 1000 * 60 * 60 * 24);
        }
        if (charAt == 'h') {
            return Long.valueOf(j * 1000 * 60 * 60);
        }
        if (charAt == 'm') {
            return Long.valueOf(j * 1000 * 60);
        }
        if (charAt == 's') {
            return Long.valueOf(j * 1000);
        }
        String valueOf4 = String.valueOf(str);
        zzdi.zzac(valueOf4.length() != 0 ? "unknown units in _lifetime: ".concat(valueOf4) : new String("unknown units in _lifetime: "));
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object get(String str) {
        synchronized (this.d) {
            Object obj = this.d;
            for (String str2 : str.split("\\.")) {
                if (!(obj instanceof Map)) {
                    return null;
                }
                obj = ((Map) obj).get(str2);
                if (obj == null) {
                    return null;
                }
            }
            return obj;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @VisibleForTesting
    public static Map<String, Object> mapOf(Object... objArr) {
        if (objArr.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < objArr.length; i += 2) {
            if (!(objArr[i] instanceof String)) {
                String valueOf = String.valueOf(objArr[i]);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
                sb.append("key is not a string: ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
            hashMap.put((String) objArr[i], objArr[i + 1]);
        }
        return hashMap;
    }

    @VisibleForTesting
    public static List<Object> listOf(Object... objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(b bVar) {
        this.c.put(bVar, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Object> a(String str, Object obj) {
        HashMap hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        HashMap hashMap2 = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap3 = new HashMap();
            hashMap2.put(split[i], hashMap3);
            i++;
            hashMap2 = hashMap3;
        }
        hashMap2.put(split[split.length - 1], obj);
        return hashMap;
    }

    @VisibleForTesting
    private final void a(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                a((List<Object>) obj, (List<Object>) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                a((Map<String, Object>) obj, (Map<String, Object>) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    @VisibleForTesting
    private final void a(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                a((List<Object>) obj, (List<Object>) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                a((Map<String, Object>) obj, (Map<String, Object>) list2.get(i));
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i, obj);
            }
        }
    }
}
