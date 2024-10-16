package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public class ErrorDialogFragment extends DialogFragment {

    /* renamed from: a, reason: collision with root package name */
    private Dialog f1277a = null;
    private DialogInterface.OnCancelListener b = null;

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f1277a == null) {
            setShowsDialog(false);
        }
        return this.f1277a;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public static ErrorDialogFragment newInstance(Dialog dialog) {
        return newInstance(dialog, null);
    }

    public static ErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.checkNotNull(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        errorDialogFragment.f1277a = dialog2;
        if (onCancelListener != null) {
            errorDialogFragment.b = onCancelListener;
        }
        return errorDialogFragment;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
