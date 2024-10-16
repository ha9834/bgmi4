package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public class SupportErrorDialogFragment extends androidx.fragment.app.c {

    /* renamed from: a, reason: collision with root package name */
    private Dialog f1285a = null;
    private DialogInterface.OnCancelListener b = null;

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f1285a == null) {
            setShowsDialog(false);
        }
        return this.f1285a;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public static SupportErrorDialogFragment newInstance(Dialog dialog) {
        return newInstance(dialog, null);
    }

    public static SupportErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.checkNotNull(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        supportErrorDialogFragment.f1285a = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.b = onCancelListener;
        }
        return supportErrorDialogFragment;
    }

    @Override // androidx.fragment.app.c
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
