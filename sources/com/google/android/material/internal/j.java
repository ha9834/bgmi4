package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class j {
    private final ArrayList<a> b = new ArrayList<>();
    private a c = null;

    /* renamed from: a, reason: collision with root package name */
    ValueAnimator f5297a = null;
    private final Animator.AnimatorListener d = new AnimatorListenerAdapter() { // from class: com.google.android.material.internal.j.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (j.this.f5297a == animator) {
                j.this.f5297a = null;
            }
        }
    };

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        a aVar = new a(iArr, valueAnimator);
        valueAnimator.addListener(this.d);
        this.b.add(aVar);
    }

    public void a(int[] iArr) {
        a aVar;
        int size = this.b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.b.get(i);
            if (StateSet.stateSetMatches(aVar.f5299a, iArr)) {
                break;
            } else {
                i++;
            }
        }
        a aVar2 = this.c;
        if (aVar == aVar2) {
            return;
        }
        if (aVar2 != null) {
            b();
        }
        this.c = aVar;
        if (aVar != null) {
            a(aVar);
        }
    }

    private void a(a aVar) {
        this.f5297a = aVar.b;
        this.f5297a.start();
    }

    private void b() {
        ValueAnimator valueAnimator = this.f5297a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f5297a = null;
        }
    }

    public void a() {
        ValueAnimator valueAnimator = this.f5297a;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f5297a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final int[] f5299a;
        final ValueAnimator b;

        a(int[] iArr, ValueAnimator valueAnimator) {
            this.f5299a = iArr;
            this.b = valueAnimator;
        }
    }
}
