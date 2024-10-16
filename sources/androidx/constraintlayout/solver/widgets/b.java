package androidx.constraintlayout.solver.widgets;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(d dVar, androidx.constraintlayout.solver.e eVar, int i) {
        int i2;
        int i3;
        c[] cVarArr;
        if (i == 0) {
            int i4 = dVar.ah;
            cVarArr = dVar.ak;
            i3 = i4;
            i2 = 0;
        } else {
            i2 = 2;
            i3 = dVar.ai;
            cVarArr = dVar.aj;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            c cVar = cVarArr[i5];
            cVar.a();
            if (dVar.q(4)) {
                if (!g.a(dVar, eVar, i, i2, cVar)) {
                    a(dVar, eVar, i, i2, cVar);
                }
            } else {
                a(dVar, eVar, i, i2, cVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a2  */
    /* JADX WARN: Type inference failed for: r2v43, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void a(androidx.constraintlayout.solver.widgets.d r34, androidx.constraintlayout.solver.e r35, int r36, int r37, androidx.constraintlayout.solver.widgets.c r38) {
        /*
            Method dump skipped, instructions count: 1294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.b.a(androidx.constraintlayout.solver.widgets.d, androidx.constraintlayout.solver.e, int, int, androidx.constraintlayout.solver.widgets.c):void");
    }
}
