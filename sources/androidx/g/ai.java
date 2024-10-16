package androidx.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.g.a;
import androidx.g.m;

/* loaded from: classes.dex */
public abstract class ai extends m {
    private static final String[] h = {"android:visibility:visibility", "android:visibility:parent"};
    private int i = 3;

    public Animator a(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        return null;
    }

    public Animator b(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        boolean f712a;
        boolean b;
        int c;
        int d;
        ViewGroup e;
        ViewGroup f;

        b() {
        }
    }

    public void a(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.i = i;
    }

    @Override // androidx.g.m
    public String[] a() {
        return h;
    }

    private void d(s sVar) {
        sVar.f740a.put("android:visibility:visibility", Integer.valueOf(sVar.b.getVisibility()));
        sVar.f740a.put("android:visibility:parent", sVar.b.getParent());
        int[] iArr = new int[2];
        sVar.b.getLocationOnScreen(iArr);
        sVar.f740a.put("android:visibility:screenLocation", iArr);
    }

    @Override // androidx.g.m
    public void a(s sVar) {
        d(sVar);
    }

    @Override // androidx.g.m
    public void b(s sVar) {
        d(sVar);
    }

    private b b(s sVar, s sVar2) {
        b bVar = new b();
        bVar.f712a = false;
        bVar.b = false;
        if (sVar != null && sVar.f740a.containsKey("android:visibility:visibility")) {
            bVar.c = ((Integer) sVar.f740a.get("android:visibility:visibility")).intValue();
            bVar.e = (ViewGroup) sVar.f740a.get("android:visibility:parent");
        } else {
            bVar.c = -1;
            bVar.e = null;
        }
        if (sVar2 != null && sVar2.f740a.containsKey("android:visibility:visibility")) {
            bVar.d = ((Integer) sVar2.f740a.get("android:visibility:visibility")).intValue();
            bVar.f = (ViewGroup) sVar2.f740a.get("android:visibility:parent");
        } else {
            bVar.d = -1;
            bVar.f = null;
        }
        if (sVar != null && sVar2 != null) {
            if (bVar.c == bVar.d && bVar.e == bVar.f) {
                return bVar;
            }
            if (bVar.c != bVar.d) {
                if (bVar.c == 0) {
                    bVar.b = false;
                    bVar.f712a = true;
                } else if (bVar.d == 0) {
                    bVar.b = true;
                    bVar.f712a = true;
                }
            } else if (bVar.f == null) {
                bVar.b = false;
                bVar.f712a = true;
            } else if (bVar.e == null) {
                bVar.b = true;
                bVar.f712a = true;
            }
        } else if (sVar == null && bVar.d == 0) {
            bVar.b = true;
            bVar.f712a = true;
        } else if (sVar2 == null && bVar.c == 0) {
            bVar.b = false;
            bVar.f712a = true;
        }
        return bVar;
    }

    @Override // androidx.g.m
    public Animator a(ViewGroup viewGroup, s sVar, s sVar2) {
        b b2 = b(sVar, sVar2);
        if (!b2.f712a) {
            return null;
        }
        if (b2.e == null && b2.f == null) {
            return null;
        }
        if (b2.b) {
            return a(viewGroup, sVar, b2.c, sVar2, b2.d);
        }
        return b(viewGroup, sVar, b2.c, sVar2, b2.d);
    }

    public Animator a(ViewGroup viewGroup, s sVar, int i, s sVar2, int i2) {
        if ((this.i & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.b.getParent();
            if (b(b(view, false), a(view, false)).f712a) {
                return null;
            }
        }
        return a(viewGroup, sVar2.b, sVar, sVar2);
    }

    public Animator b(ViewGroup viewGroup, s sVar, int i, s sVar2, int i2) {
        int id;
        if ((this.i & 2) != 2) {
            return null;
        }
        final View view = sVar != null ? sVar.b : null;
        View view2 = sVar2 != null ? sVar2.b : null;
        if (view2 == null || view2.getParent() == null) {
            if (view2 != null) {
                view = view2;
                view2 = null;
            } else {
                if (view != null) {
                    if (view.getParent() != null) {
                        if (view.getParent() instanceof View) {
                            View view3 = (View) view.getParent();
                            if (!b(a(view3, true), b(view3, true)).f712a) {
                                view = r.a(viewGroup, view, view3);
                            } else if (view3.getParent() != null || (id = view3.getId()) == -1 || viewGroup.findViewById(id) == null || !this.e) {
                                view = null;
                            }
                            view2 = null;
                        }
                    }
                    view2 = null;
                }
                view = null;
                view2 = null;
            }
        } else if (i2 == 4 || view == view2) {
            view = null;
        } else {
            if (!this.e) {
                view = r.a(viewGroup, view, (View) view.getParent());
                view2 = null;
            }
            view2 = null;
        }
        if (view == null || sVar == null) {
            if (view2 == null) {
                return null;
            }
            int visibility = view2.getVisibility();
            ad.a(view2, 0);
            Animator b2 = b(viewGroup, view2, sVar, sVar2);
            if (b2 != null) {
                a aVar = new a(view2, i2, true);
                b2.addListener(aVar);
                androidx.g.a.a(b2, aVar);
                a(aVar);
            } else {
                ad.a(view2, visibility);
            }
            return b2;
        }
        int[] iArr = (int[]) sVar.f740a.get("android:visibility:screenLocation");
        int i3 = iArr[0];
        int i4 = iArr[1];
        int[] iArr2 = new int[2];
        viewGroup.getLocationOnScreen(iArr2);
        view.offsetLeftAndRight((i3 - iArr2[0]) - view.getLeft());
        view.offsetTopAndBottom((i4 - iArr2[1]) - view.getTop());
        final w a2 = x.a(viewGroup);
        a2.a(view);
        Animator b3 = b(viewGroup, view, sVar, sVar2);
        if (b3 == null) {
            a2.b(view);
        } else {
            b3.addListener(new AnimatorListenerAdapter() { // from class: androidx.g.ai.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a2.b(view);
                }
            });
        }
        return b3;
    }

    @Override // androidx.g.m
    public boolean a(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar != null && sVar2 != null && sVar2.f740a.containsKey("android:visibility:visibility") != sVar.f740a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b b2 = b(sVar, sVar2);
        if (b2.f712a) {
            return b2.c == 0 || b2.d == 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter implements a.InterfaceC0055a, m.c {

        /* renamed from: a, reason: collision with root package name */
        boolean f711a = false;
        private final View b;
        private final int c;
        private final ViewGroup d;
        private final boolean e;
        private boolean f;

        @Override // androidx.g.m.c
        public void d(m mVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        a(View view, int i, boolean z) {
            this.b = view;
            this.c = i;
            this.d = (ViewGroup) view.getParent();
            this.e = z;
            a(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.g.a.InterfaceC0055a
        public void onAnimationPause(Animator animator) {
            if (this.f711a) {
                return;
            }
            ad.a(this.b, this.c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.g.a.InterfaceC0055a
        public void onAnimationResume(Animator animator) {
            if (this.f711a) {
                return;
            }
            ad.a(this.b, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f711a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // androidx.g.m.c
        public void a(m mVar) {
            a();
            mVar.b(this);
        }

        @Override // androidx.g.m.c
        public void b(m mVar) {
            a(false);
        }

        @Override // androidx.g.m.c
        public void c(m mVar) {
            a(true);
        }

        private void a() {
            if (!this.f711a) {
                ad.a(this.b, this.c);
                ViewGroup viewGroup = this.d;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        private void a(boolean z) {
            ViewGroup viewGroup;
            if (!this.e || this.f == z || (viewGroup = this.d) == null) {
                return;
            }
            this.f = z;
            x.a(viewGroup, z);
        }
    }
}
