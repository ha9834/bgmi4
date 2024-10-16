package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;

/* loaded from: classes.dex */
public class g extends androidx.fragment.app.c {
    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        return new f(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.c
    public void setupDialog(Dialog dialog, int i) {
        if (dialog instanceof f) {
            f fVar = (f) dialog;
            switch (i) {
                case 1:
                case 2:
                    break;
                case 3:
                    dialog.getWindow().addFlags(24);
                    break;
                default:
                    return;
            }
            fVar.a(1);
            return;
        }
        super.setupDialog(dialog, i);
    }
}
