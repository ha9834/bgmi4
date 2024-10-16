package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.a.a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f444a = {0, 4, 8};
    private static SparseIntArray c = new SparseIntArray();
    private HashMap<Integer, a> b = new HashMap<>();

    static {
        c.append(a.b.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        c.append(a.b.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        c.append(a.b.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        c.append(a.b.ConstraintSet_layout_constraintRight_toRightOf, 30);
        c.append(a.b.ConstraintSet_layout_constraintTop_toTopOf, 36);
        c.append(a.b.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        c.append(a.b.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        c.append(a.b.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        c.append(a.b.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        c.append(a.b.ConstraintSet_layout_editor_absoluteX, 6);
        c.append(a.b.ConstraintSet_layout_editor_absoluteY, 7);
        c.append(a.b.ConstraintSet_layout_constraintGuide_begin, 17);
        c.append(a.b.ConstraintSet_layout_constraintGuide_end, 18);
        c.append(a.b.ConstraintSet_layout_constraintGuide_percent, 19);
        c.append(a.b.ConstraintSet_android_orientation, 27);
        c.append(a.b.ConstraintSet_layout_constraintStart_toEndOf, 32);
        c.append(a.b.ConstraintSet_layout_constraintStart_toStartOf, 33);
        c.append(a.b.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        c.append(a.b.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        c.append(a.b.ConstraintSet_layout_goneMarginLeft, 13);
        c.append(a.b.ConstraintSet_layout_goneMarginTop, 16);
        c.append(a.b.ConstraintSet_layout_goneMarginRight, 14);
        c.append(a.b.ConstraintSet_layout_goneMarginBottom, 11);
        c.append(a.b.ConstraintSet_layout_goneMarginStart, 15);
        c.append(a.b.ConstraintSet_layout_goneMarginEnd, 12);
        c.append(a.b.ConstraintSet_layout_constraintVertical_weight, 40);
        c.append(a.b.ConstraintSet_layout_constraintHorizontal_weight, 39);
        c.append(a.b.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        c.append(a.b.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        c.append(a.b.ConstraintSet_layout_constraintHorizontal_bias, 20);
        c.append(a.b.ConstraintSet_layout_constraintVertical_bias, 37);
        c.append(a.b.ConstraintSet_layout_constraintDimensionRatio, 5);
        c.append(a.b.ConstraintSet_layout_constraintLeft_creator, 64);
        c.append(a.b.ConstraintSet_layout_constraintTop_creator, 64);
        c.append(a.b.ConstraintSet_layout_constraintRight_creator, 64);
        c.append(a.b.ConstraintSet_layout_constraintBottom_creator, 64);
        c.append(a.b.ConstraintSet_layout_constraintBaseline_creator, 64);
        c.append(a.b.ConstraintSet_android_layout_marginLeft, 24);
        c.append(a.b.ConstraintSet_android_layout_marginRight, 28);
        c.append(a.b.ConstraintSet_android_layout_marginStart, 31);
        c.append(a.b.ConstraintSet_android_layout_marginEnd, 8);
        c.append(a.b.ConstraintSet_android_layout_marginTop, 34);
        c.append(a.b.ConstraintSet_android_layout_marginBottom, 2);
        c.append(a.b.ConstraintSet_android_layout_width, 23);
        c.append(a.b.ConstraintSet_android_layout_height, 21);
        c.append(a.b.ConstraintSet_android_visibility, 22);
        c.append(a.b.ConstraintSet_android_alpha, 43);
        c.append(a.b.ConstraintSet_android_elevation, 44);
        c.append(a.b.ConstraintSet_android_rotationX, 45);
        c.append(a.b.ConstraintSet_android_rotationY, 46);
        c.append(a.b.ConstraintSet_android_rotation, 60);
        c.append(a.b.ConstraintSet_android_scaleX, 47);
        c.append(a.b.ConstraintSet_android_scaleY, 48);
        c.append(a.b.ConstraintSet_android_transformPivotX, 49);
        c.append(a.b.ConstraintSet_android_transformPivotY, 50);
        c.append(a.b.ConstraintSet_android_translationX, 51);
        c.append(a.b.ConstraintSet_android_translationY, 52);
        c.append(a.b.ConstraintSet_android_translationZ, 53);
        c.append(a.b.ConstraintSet_layout_constraintWidth_default, 54);
        c.append(a.b.ConstraintSet_layout_constraintHeight_default, 55);
        c.append(a.b.ConstraintSet_layout_constraintWidth_max, 56);
        c.append(a.b.ConstraintSet_layout_constraintHeight_max, 57);
        c.append(a.b.ConstraintSet_layout_constraintWidth_min, 58);
        c.append(a.b.ConstraintSet_layout_constraintHeight_min, 59);
        c.append(a.b.ConstraintSet_layout_constraintCircle, 61);
        c.append(a.b.ConstraintSet_layout_constraintCircleRadius, 62);
        c.append(a.b.ConstraintSet_layout_constraintCircleAngle, 63);
        c.append(a.b.ConstraintSet_android_id, 38);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public float Q;
        public float R;
        public int S;
        public int T;
        public float U;
        public boolean V;
        public float W;
        public float X;
        public float Y;
        public float Z;

        /* renamed from: a, reason: collision with root package name */
        boolean f445a;
        public float aa;
        public float ab;
        public float ac;
        public float ad;
        public float ae;
        public float af;
        public float ag;
        public boolean ah;
        public boolean ai;
        public int aj;
        public int ak;
        public int al;
        public int am;
        public int an;
        public int ao;
        public float ap;
        public float aq;
        public int ar;
        public int as;

        /* renamed from: at, reason: collision with root package name */
        public int[] f446at;
        public int b;
        public int c;
        int d;
        public int e;
        public int f;
        public float g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public float u;
        public float v;
        public String w;
        public int x;
        public int y;
        public float z;

        private a() {
            this.f445a = false;
            this.e = -1;
            this.f = -1;
            this.g = -1.0f;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = 0.5f;
            this.v = 0.5f;
            this.w = null;
            this.x = -1;
            this.y = 0;
            this.z = 0.0f;
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = -1;
            this.G = -1;
            this.H = -1;
            this.I = -1;
            this.J = 0;
            this.K = -1;
            this.L = -1;
            this.M = -1;
            this.N = -1;
            this.O = -1;
            this.P = -1;
            this.Q = 0.0f;
            this.R = 0.0f;
            this.S = 0;
            this.T = 0;
            this.U = 1.0f;
            this.V = false;
            this.W = 0.0f;
            this.X = 0.0f;
            this.Y = 0.0f;
            this.Z = 0.0f;
            this.aa = 1.0f;
            this.ab = 1.0f;
            this.ac = Float.NaN;
            this.ad = Float.NaN;
            this.ae = 0.0f;
            this.af = 0.0f;
            this.ag = 0.0f;
            this.ah = false;
            this.ai = false;
            this.aj = 0;
            this.ak = 0;
            this.al = -1;
            this.am = -1;
            this.an = -1;
            this.ao = -1;
            this.ap = 1.0f;
            this.aq = 1.0f;
            this.ar = -1;
            this.as = -1;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f445a = this.f445a;
            aVar.b = this.b;
            aVar.c = this.c;
            aVar.e = this.e;
            aVar.f = this.f;
            aVar.g = this.g;
            aVar.h = this.h;
            aVar.i = this.i;
            aVar.j = this.j;
            aVar.k = this.k;
            aVar.l = this.l;
            aVar.m = this.m;
            aVar.n = this.n;
            aVar.o = this.o;
            aVar.p = this.p;
            aVar.q = this.q;
            aVar.r = this.r;
            aVar.s = this.s;
            aVar.t = this.t;
            aVar.u = this.u;
            aVar.v = this.v;
            aVar.w = this.w;
            aVar.A = this.A;
            aVar.B = this.B;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.C = this.C;
            aVar.D = this.D;
            aVar.E = this.E;
            aVar.F = this.F;
            aVar.G = this.G;
            aVar.H = this.H;
            aVar.I = this.I;
            aVar.J = this.J;
            aVar.K = this.K;
            aVar.L = this.L;
            aVar.M = this.M;
            aVar.N = this.N;
            aVar.O = this.O;
            aVar.P = this.P;
            aVar.Q = this.Q;
            aVar.R = this.R;
            aVar.S = this.S;
            aVar.T = this.T;
            aVar.U = this.U;
            aVar.V = this.V;
            aVar.W = this.W;
            aVar.X = this.X;
            aVar.Y = this.Y;
            aVar.Z = this.Z;
            aVar.aa = this.aa;
            aVar.ab = this.ab;
            aVar.ac = this.ac;
            aVar.ad = this.ad;
            aVar.ae = this.ae;
            aVar.af = this.af;
            aVar.ag = this.ag;
            aVar.ah = this.ah;
            aVar.ai = this.ai;
            aVar.aj = this.aj;
            aVar.ak = this.ak;
            aVar.al = this.al;
            aVar.am = this.am;
            aVar.an = this.an;
            aVar.ao = this.ao;
            aVar.ap = this.ap;
            aVar.aq = this.aq;
            aVar.ar = this.ar;
            aVar.as = this.as;
            int[] iArr = this.f446at;
            if (iArr != null) {
                aVar.f446at = Arrays.copyOf(iArr, iArr.length);
            }
            aVar.x = this.x;
            aVar.y = this.y;
            aVar.z = this.z;
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(b bVar, int i, d.a aVar) {
            a(i, aVar);
            if (bVar instanceof androidx.constraintlayout.widget.a) {
                this.as = 1;
                androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) bVar;
                this.ar = aVar2.getType();
                this.f446at = aVar2.getReferencedIds();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, d.a aVar) {
            a(i, (ConstraintLayout.a) aVar);
            this.U = aVar.an;
            this.X = aVar.aq;
            this.Y = aVar.ar;
            this.Z = aVar.as;
            this.aa = aVar.f448at;
            this.ab = aVar.au;
            this.ac = aVar.av;
            this.ad = aVar.aw;
            this.ae = aVar.ax;
            this.af = aVar.ay;
            this.ag = aVar.az;
            this.W = aVar.ap;
            this.V = aVar.ao;
        }

        private void a(int i, ConstraintLayout.a aVar) {
            this.d = i;
            this.h = aVar.d;
            this.i = aVar.e;
            this.j = aVar.f;
            this.k = aVar.g;
            this.l = aVar.h;
            this.m = aVar.i;
            this.n = aVar.j;
            this.o = aVar.k;
            this.p = aVar.l;
            this.q = aVar.p;
            this.r = aVar.q;
            this.s = aVar.r;
            this.t = aVar.s;
            this.u = aVar.z;
            this.v = aVar.A;
            this.w = aVar.B;
            this.x = aVar.m;
            this.y = aVar.n;
            this.z = aVar.o;
            this.A = aVar.Q;
            this.B = aVar.R;
            this.C = aVar.S;
            this.g = aVar.c;
            this.e = aVar.f441a;
            this.f = aVar.b;
            this.b = aVar.width;
            this.c = aVar.height;
            this.D = aVar.leftMargin;
            this.E = aVar.rightMargin;
            this.F = aVar.topMargin;
            this.G = aVar.bottomMargin;
            this.Q = aVar.F;
            this.R = aVar.E;
            this.T = aVar.H;
            this.S = aVar.G;
            this.ah = aVar.T;
            this.ai = aVar.U;
            this.aj = aVar.I;
            this.ak = aVar.J;
            this.ah = aVar.T;
            this.al = aVar.M;
            this.am = aVar.N;
            this.an = aVar.K;
            this.ao = aVar.L;
            this.ap = aVar.O;
            this.aq = aVar.P;
            if (Build.VERSION.SDK_INT >= 17) {
                this.H = aVar.getMarginEnd();
                this.I = aVar.getMarginStart();
            }
        }

        public void a(ConstraintLayout.a aVar) {
            aVar.d = this.h;
            aVar.e = this.i;
            aVar.f = this.j;
            aVar.g = this.k;
            aVar.h = this.l;
            aVar.i = this.m;
            aVar.j = this.n;
            aVar.k = this.o;
            aVar.l = this.p;
            aVar.p = this.q;
            aVar.q = this.r;
            aVar.r = this.s;
            aVar.s = this.t;
            aVar.leftMargin = this.D;
            aVar.rightMargin = this.E;
            aVar.topMargin = this.F;
            aVar.bottomMargin = this.G;
            aVar.x = this.P;
            aVar.y = this.O;
            aVar.z = this.u;
            aVar.A = this.v;
            aVar.m = this.x;
            aVar.n = this.y;
            aVar.o = this.z;
            aVar.B = this.w;
            aVar.Q = this.A;
            aVar.R = this.B;
            aVar.F = this.Q;
            aVar.E = this.R;
            aVar.H = this.T;
            aVar.G = this.S;
            aVar.T = this.ah;
            aVar.U = this.ai;
            aVar.I = this.aj;
            aVar.J = this.ak;
            aVar.M = this.al;
            aVar.N = this.am;
            aVar.K = this.an;
            aVar.L = this.ao;
            aVar.O = this.ap;
            aVar.P = this.aq;
            aVar.S = this.C;
            aVar.c = this.g;
            aVar.f441a = this.e;
            aVar.b = this.f;
            aVar.width = this.b;
            aVar.height = this.c;
            if (Build.VERSION.SDK_INT >= 17) {
                aVar.setMarginStart(this.I);
                aVar.setMarginEnd(this.H);
            }
            aVar.a();
        }
    }

    public void a(d dVar) {
        int childCount = dVar.getChildCount();
        this.b.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = dVar.getChildAt(i);
            d.a aVar = (d.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.b.containsKey(Integer.valueOf(id))) {
                this.b.put(Integer.valueOf(id), new a());
            }
            a aVar2 = this.b.get(Integer.valueOf(id));
            if (childAt instanceof b) {
                aVar2.a((b) childAt, id, aVar);
            }
            aVar2.a(id, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.b.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (this.b.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                a aVar = this.b.get(Integer.valueOf(id));
                if (aVar.as != -1 && aVar.as == 1) {
                    androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) childAt;
                    aVar2.setId(id);
                    aVar2.setReferencedIds(aVar.f446at);
                    aVar2.setType(aVar.ar);
                    aVar.a(constraintLayout.generateDefaultLayoutParams());
                }
                ConstraintLayout.a aVar3 = (ConstraintLayout.a) childAt.getLayoutParams();
                aVar.a(aVar3);
                childAt.setLayoutParams(aVar3);
                childAt.setVisibility(aVar.J);
                if (Build.VERSION.SDK_INT >= 17) {
                    childAt.setAlpha(aVar.U);
                    childAt.setRotation(aVar.X);
                    childAt.setRotationX(aVar.Y);
                    childAt.setRotationY(aVar.Z);
                    childAt.setScaleX(aVar.aa);
                    childAt.setScaleY(aVar.ab);
                    if (!Float.isNaN(aVar.ac)) {
                        childAt.setPivotX(aVar.ac);
                    }
                    if (!Float.isNaN(aVar.ad)) {
                        childAt.setPivotY(aVar.ad);
                    }
                    childAt.setTranslationX(aVar.ae);
                    childAt.setTranslationY(aVar.af);
                    if (Build.VERSION.SDK_INT >= 21) {
                        childAt.setTranslationZ(aVar.ag);
                        if (aVar.V) {
                            childAt.setElevation(aVar.W);
                        }
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar4 = this.b.get(num);
            if (aVar4.as != -1 && aVar4.as == 1) {
                androidx.constraintlayout.widget.a aVar5 = new androidx.constraintlayout.widget.a(constraintLayout.getContext());
                aVar5.setId(num.intValue());
                aVar5.setReferencedIds(aVar4.f446at);
                aVar5.setType(aVar4.ar);
                ConstraintLayout.a generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                aVar4.a(generateDefaultLayoutParams);
                constraintLayout.addView(aVar5, generateDefaultLayoutParams);
            }
            if (aVar4.f445a) {
                e eVar = new e(constraintLayout.getContext());
                eVar.setId(num.intValue());
                ConstraintLayout.a generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                aVar4.a(generateDefaultLayoutParams2);
                constraintLayout.addView(eVar, generateDefaultLayoutParams2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003a, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0011. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.content.Context r5, int r6) {
        /*
            r4 = this;
            android.content.res.Resources r0 = r5.getResources()
            android.content.res.XmlResourceParser r6 = r0.getXml(r6)
            int r0 = r6.getEventType()     // Catch: java.io.IOException -> L3f org.xmlpull.v1.XmlPullParserException -> L44
        Lc:
            r1 = 1
            if (r0 == r1) goto L48
            if (r0 == 0) goto L37
            switch(r0) {
                case 2: goto L15;
                case 3: goto L3a;
                default: goto L14;
            }     // Catch: java.io.IOException -> L3f org.xmlpull.v1.XmlPullParserException -> L44
        L14:
            goto L3a
        L15:
            java.lang.String r0 = r6.getName()     // Catch: java.io.IOException -> L3f org.xmlpull.v1.XmlPullParserException -> L44
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r6)     // Catch: java.io.IOException -> L3f org.xmlpull.v1.XmlPullParserException -> L44
            androidx.constraintlayout.widget.c$a r2 = r4.a(r5, r2)     // Catch: java.io.IOException -> L3f org.xmlpull.v1.XmlPullParserException -> L44
            java.lang.String r3 = "Guideline"
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch: java.io.IOException -> L3f org.xmlpull.v1.XmlPullParserException -> L44
            if (r0 == 0) goto L2b
            r2.f445a = r1     // Catch: java.io.IOException -> L3f org.xmlpull.v1.XmlPullParserException -> L44
        L2b:
            java.util.HashMap<java.lang.Integer, androidx.constraintlayout.widget.c$a> r0 = r4.b     // Catch: java.io.IOException -> L3f org.xmlpull.v1.XmlPullParserException -> L44
            int r1 = r2.d     // Catch: java.io.IOException -> L3f org.xmlpull.v1.XmlPullParserException -> L44
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.io.IOException -> L3f org.xmlpull.v1.XmlPullParserException -> L44
            r0.put(r1, r2)     // Catch: java.io.IOException -> L3f org.xmlpull.v1.XmlPullParserException -> L44
            goto L3a
        L37:
            r6.getName()     // Catch: java.io.IOException -> L3f org.xmlpull.v1.XmlPullParserException -> L44
        L3a:
            int r0 = r6.next()     // Catch: java.io.IOException -> L3f org.xmlpull.v1.XmlPullParserException -> L44
            goto Lc
        L3f:
            r5 = move-exception
            r5.printStackTrace()
            goto L48
        L44:
            r5 = move-exception
            r5.printStackTrace()
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.c.a(android.content.Context, int):void");
    }

    private static int a(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    private a a(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.ConstraintSet);
        a(aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private void a(a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            int i2 = c.get(index);
            switch (i2) {
                case 1:
                    aVar.p = a(typedArray, index, aVar.p);
                    break;
                case 2:
                    aVar.G = typedArray.getDimensionPixelSize(index, aVar.G);
                    break;
                case 3:
                    aVar.o = a(typedArray, index, aVar.o);
                    break;
                case 4:
                    aVar.n = a(typedArray, index, aVar.n);
                    break;
                case 5:
                    aVar.w = typedArray.getString(index);
                    break;
                case 6:
                    aVar.A = typedArray.getDimensionPixelOffset(index, aVar.A);
                    break;
                case 7:
                    aVar.B = typedArray.getDimensionPixelOffset(index, aVar.B);
                    break;
                case 8:
                    aVar.H = typedArray.getDimensionPixelSize(index, aVar.H);
                    break;
                case 9:
                    aVar.t = a(typedArray, index, aVar.t);
                    break;
                case 10:
                    aVar.s = a(typedArray, index, aVar.s);
                    break;
                case 11:
                    aVar.N = typedArray.getDimensionPixelSize(index, aVar.N);
                    break;
                case 12:
                    aVar.O = typedArray.getDimensionPixelSize(index, aVar.O);
                    break;
                case 13:
                    aVar.K = typedArray.getDimensionPixelSize(index, aVar.K);
                    break;
                case 14:
                    aVar.M = typedArray.getDimensionPixelSize(index, aVar.M);
                    break;
                case 15:
                    aVar.P = typedArray.getDimensionPixelSize(index, aVar.P);
                    break;
                case 16:
                    aVar.L = typedArray.getDimensionPixelSize(index, aVar.L);
                    break;
                case 17:
                    aVar.e = typedArray.getDimensionPixelOffset(index, aVar.e);
                    break;
                case 18:
                    aVar.f = typedArray.getDimensionPixelOffset(index, aVar.f);
                    break;
                case 19:
                    aVar.g = typedArray.getFloat(index, aVar.g);
                    break;
                case 20:
                    aVar.u = typedArray.getFloat(index, aVar.u);
                    break;
                case 21:
                    aVar.c = typedArray.getLayoutDimension(index, aVar.c);
                    break;
                case 22:
                    aVar.J = typedArray.getInt(index, aVar.J);
                    aVar.J = f444a[aVar.J];
                    break;
                case 23:
                    aVar.b = typedArray.getLayoutDimension(index, aVar.b);
                    break;
                case 24:
                    aVar.D = typedArray.getDimensionPixelSize(index, aVar.D);
                    break;
                case 25:
                    aVar.h = a(typedArray, index, aVar.h);
                    break;
                case 26:
                    aVar.i = a(typedArray, index, aVar.i);
                    break;
                case 27:
                    aVar.C = typedArray.getInt(index, aVar.C);
                    break;
                case 28:
                    aVar.E = typedArray.getDimensionPixelSize(index, aVar.E);
                    break;
                case 29:
                    aVar.j = a(typedArray, index, aVar.j);
                    break;
                case 30:
                    aVar.k = a(typedArray, index, aVar.k);
                    break;
                case 31:
                    aVar.I = typedArray.getDimensionPixelSize(index, aVar.I);
                    break;
                case 32:
                    aVar.q = a(typedArray, index, aVar.q);
                    break;
                case 33:
                    aVar.r = a(typedArray, index, aVar.r);
                    break;
                case 34:
                    aVar.F = typedArray.getDimensionPixelSize(index, aVar.F);
                    break;
                case 35:
                    aVar.m = a(typedArray, index, aVar.m);
                    break;
                case 36:
                    aVar.l = a(typedArray, index, aVar.l);
                    break;
                case 37:
                    aVar.v = typedArray.getFloat(index, aVar.v);
                    break;
                case 38:
                    aVar.d = typedArray.getResourceId(index, aVar.d);
                    break;
                case 39:
                    aVar.R = typedArray.getFloat(index, aVar.R);
                    break;
                case 40:
                    aVar.Q = typedArray.getFloat(index, aVar.Q);
                    break;
                case 41:
                    aVar.S = typedArray.getInt(index, aVar.S);
                    break;
                case 42:
                    aVar.T = typedArray.getInt(index, aVar.T);
                    break;
                case 43:
                    aVar.U = typedArray.getFloat(index, aVar.U);
                    break;
                case 44:
                    aVar.V = true;
                    aVar.W = typedArray.getDimension(index, aVar.W);
                    break;
                case 45:
                    aVar.Y = typedArray.getFloat(index, aVar.Y);
                    break;
                case 46:
                    aVar.Z = typedArray.getFloat(index, aVar.Z);
                    break;
                case 47:
                    aVar.aa = typedArray.getFloat(index, aVar.aa);
                    break;
                case 48:
                    aVar.ab = typedArray.getFloat(index, aVar.ab);
                    break;
                case 49:
                    aVar.ac = typedArray.getFloat(index, aVar.ac);
                    break;
                case 50:
                    aVar.ad = typedArray.getFloat(index, aVar.ad);
                    break;
                case 51:
                    aVar.ae = typedArray.getDimension(index, aVar.ae);
                    break;
                case 52:
                    aVar.af = typedArray.getDimension(index, aVar.af);
                    break;
                case 53:
                    aVar.ag = typedArray.getDimension(index, aVar.ag);
                    break;
                default:
                    switch (i2) {
                        case 60:
                            aVar.X = typedArray.getFloat(index, aVar.X);
                            break;
                        case 61:
                            aVar.x = a(typedArray, index, aVar.x);
                            break;
                        case 62:
                            aVar.y = typedArray.getDimensionPixelSize(index, aVar.y);
                            break;
                        case 63:
                            aVar.z = typedArray.getFloat(index, aVar.z);
                            break;
                        case 64:
                            Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + c.get(index));
                            break;
                        default:
                            Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + c.get(index));
                            break;
                    }
            }
        }
    }
}
