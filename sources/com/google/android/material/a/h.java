package com.google.android.material.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.b.g<String, i> f5210a = new androidx.b.g<>();

    public boolean a(String str) {
        return this.f5210a.get(str) != null;
    }

    public i b(String str) {
        if (!a(str)) {
            throw new IllegalArgumentException();
        }
        return this.f5210a.get(str);
    }

    public void a(String str, i iVar) {
        this.f5210a.put(str, iVar);
    }

    public long a() {
        int size = this.f5210a.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            i c = this.f5210a.c(i);
            j = Math.max(j, c.a() + c.b());
        }
        return j;
    }

    public static h a(Context context, int i) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (loadAnimator instanceof AnimatorSet) {
                return a(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return a(arrayList);
        } catch (Exception e) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i), e);
            return null;
        }
    }

    private static h a(List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(hVar, list.get(i));
        }
        return hVar;
    }

    private static void a(h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.a(objectAnimator.getPropertyName(), i.a((ValueAnimator) objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f5210a.equals(((h) obj).f5210a);
    }

    public int hashCode() {
        return this.f5210a.hashCode();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f5210a + "}\n";
    }
}
