package com.subao.common.b;

import com.subao.common.intf.UserInfo;
import com.subao.common.intf.XunyouUserStateCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private final a f5935a = new a();

    public int a(UserInfo userInfo, XunyouUserStateCallback xunyouUserStateCallback, Object obj) {
        if (userInfo == null) {
            throw new NullPointerException("UserInfo can not be null");
        }
        return this.f5935a.a(userInfo, xunyouUserStateCallback, obj);
    }

    public void a(int i, int i2, int i3, String str) {
        XunyouUserStateCallback xunyouUserStateCallback;
        a.C0165a a2 = this.f5935a.a(i);
        if (a2 == null || (xunyouUserStateCallback = a2.c) == null) {
            return;
        }
        xunyouUserStateCallback.onXunyouUserState(a2.b, a2.d, i2, i3, str);
    }

    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static volatile int f5936a = 1000;
        private final List<C0165a> b;

        private a() {
            this.b = new ArrayList(8);
        }

        int a(UserInfo userInfo, XunyouUserStateCallback xunyouUserStateCallback, Object obj) {
            int i;
            synchronized (a.class) {
                i = f5936a + 1;
                f5936a = i;
            }
            C0165a c0165a = new C0165a(i, userInfo, xunyouUserStateCallback, obj);
            synchronized (this.b) {
                this.b.add(c0165a);
            }
            return i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C0165a a(int i) {
            C0165a c0165a;
            synchronized (this.b) {
                int size = this.b.size() - 1;
                while (true) {
                    if (size < 0) {
                        c0165a = null;
                        break;
                    }
                    if (this.b.get(size).f5937a == i) {
                        c0165a = this.b.remove(size);
                        break;
                    }
                    size--;
                }
            }
            return c0165a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.subao.common.b.q$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0165a {

            /* renamed from: a, reason: collision with root package name */
            final int f5937a;
            final UserInfo b;
            final XunyouUserStateCallback c;
            final Object d;

            C0165a(int i, UserInfo userInfo, XunyouUserStateCallback xunyouUserStateCallback, Object obj) {
                this.f5937a = i;
                this.b = userInfo;
                this.c = xunyouUserStateCallback;
                this.d = obj;
            }
        }
    }
}
