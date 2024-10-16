package com.subao.common.k;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.ParcelFileDescriptor;
import com.subao.common.j.l;
import com.subao.common.k.m;
import java.io.IOException;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class a implements com.subao.common.a {

    /* renamed from: a, reason: collision with root package name */
    private final b f6092a;
    private Object b;

    /* renamed from: com.subao.common.k.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0174a {
        void a(boolean z);
    }

    private a(InterfaceC0174a interfaceC0174a) {
        this.f6092a = new b(interfaceC0174a);
    }

    public static a a(Context context, InterfaceC0174a interfaceC0174a) {
        m.a(context);
        a aVar = new a(interfaceC0174a);
        aVar.b = m.a(m.e.CELLULAR, aVar.f6092a);
        return aVar;
    }

    @Override // com.subao.common.a
    public void a() {
        synchronized (this) {
            if (this.b != null) {
                m.a(this.b);
                this.b = null;
            }
        }
    }

    public int a(Context context) {
        return this.f6092a.a(context);
    }

    /* loaded from: classes2.dex */
    static class b implements m.a {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC0174a f6094a;
        private final List<m.b> b = new ArrayList(2);

        b(InterfaceC0174a interfaceC0174a) {
            this.f6094a = interfaceC0174a;
        }

        @TargetApi(14)
        static int a(m.b bVar) {
            try {
                DatagramSocket datagramSocket = new DatagramSocket();
                try {
                    try {
                        bVar.a(datagramSocket);
                        ParcelFileDescriptor fromDatagramSocket = ParcelFileDescriptor.fromDatagramSocket(datagramSocket);
                        if (fromDatagramSocket == null) {
                            throw new m.d(2015);
                        }
                        return fromDatagramSocket.detachFd();
                    } catch (RuntimeException unused) {
                        throw new m.d(2015);
                    }
                } finally {
                    datagramSocket.close();
                }
            } catch (IOException e) {
                com.subao.common.d.b("SubaoParallel", e.getMessage());
                throw new m.d(2005);
            }
        }

        static int a(com.subao.common.h hVar) {
            switch (hVar) {
                case OFF:
                    return 2003;
                case ON:
                    return 2007;
                default:
                    return 2008;
            }
        }

        static void a(Context context, m.b bVar) {
            try {
                NetworkInfo a2 = bVar.a(context);
                if (a2 != null) {
                    if (a2.getType() != 0) {
                        com.subao.common.d.a("SubaoParallel", "The network type is not mobile, can not create FD by mobile");
                        throw new m.d(2014);
                    }
                    if (l.a.MOBILE_2G != com.subao.common.j.h.a(a2.getSubtype())) {
                        return;
                    }
                    com.subao.common.d.a("SubaoParallel", "The network type is 2G, can not create FD by mobile");
                    throw new m.d(2004);
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }

        private m.b a() {
            m.b bVar;
            synchronized (this) {
                bVar = this.b.isEmpty() ? null : this.b.get(this.b.size() - 1);
            }
            return bVar;
        }

        int a(Context context) {
            m.b a2 = a();
            if (a2 == null) {
                com.subao.common.d.a("SubaoParallel", "No available cellular network.");
                throw new m.d(a(com.subao.common.j.k.a(context)));
            }
            a(context, a2);
            return a(a2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.subao.common.k.m.a
        public void b(m.b bVar) {
            synchronized (this) {
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    if (this.b.get(size).equals(bVar)) {
                        this.b.set(size, bVar);
                        return;
                    }
                }
                this.b.add(bVar);
                int size2 = this.b.size();
                InterfaceC0174a interfaceC0174a = this.f6094a;
                if (interfaceC0174a == null || size2 != 1) {
                    return;
                }
                interfaceC0174a.a(true);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.subao.common.k.m.a
        public void c(m.b bVar) {
            boolean isEmpty;
            InterfaceC0174a interfaceC0174a;
            if (this.b.isEmpty()) {
                return;
            }
            synchronized (this) {
                int size = this.b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    if (this.b.get(size).equals(bVar)) {
                        this.b.remove(size);
                        break;
                    }
                    size--;
                }
                isEmpty = this.b.isEmpty();
            }
            if (!isEmpty || (interfaceC0174a = this.f6094a) == null) {
                return;
            }
            interfaceC0174a.a(false);
        }
    }
}
