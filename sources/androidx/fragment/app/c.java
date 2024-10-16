package androidx.fragment.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.aa;

/* loaded from: classes.dex */
public class c extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private int mBackStackId;
    private boolean mCancelable;
    private boolean mCreatingDialog;
    private Dialog mDialog;
    private boolean mDialogCreated;
    private Runnable mDismissRunnable;
    private boolean mDismissed;
    private Handler mHandler;
    private androidx.lifecycle.q<androidx.lifecycle.k> mObserver;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private boolean mShownByMe;
    private boolean mShowsDialog;
    private int mStyle;
    private int mTheme;
    private boolean mViewDestroyed;

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    public c() {
        this.mDismissRunnable = new Runnable() { // from class: androidx.fragment.app.c.1
            @Override // java.lang.Runnable
            @SuppressLint({"SyntheticAccessor"})
            public void run() {
                c.this.mOnDismissListener.onDismiss(c.this.mDialog);
            }
        };
        this.mOnCancelListener = new DialogInterface.OnCancelListener() { // from class: androidx.fragment.app.c.2
            @Override // android.content.DialogInterface.OnCancelListener
            @SuppressLint({"SyntheticAccessor"})
            public void onCancel(DialogInterface dialogInterface) {
                if (c.this.mDialog != null) {
                    c cVar = c.this;
                    cVar.onCancel(cVar.mDialog);
                }
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: androidx.fragment.app.c.3
            @Override // android.content.DialogInterface.OnDismissListener
            @SuppressLint({"SyntheticAccessor"})
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.mDialog != null) {
                    c cVar = c.this;
                    cVar.onDismiss(cVar.mDialog);
                }
            }
        };
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new androidx.lifecycle.q<androidx.lifecycle.k>() { // from class: androidx.fragment.app.c.4
            @Override // androidx.lifecycle.q
            @SuppressLint({"SyntheticAccessor"})
            public void a(androidx.lifecycle.k kVar) {
                if (kVar == null || !c.this.mShowsDialog) {
                    return;
                }
                View requireView = c.this.requireView();
                if (requireView.getParent() == null) {
                    if (c.this.mDialog != null) {
                        if (FragmentManager.a(3)) {
                            Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + c.this.mDialog);
                        }
                        c.this.mDialog.setContentView(requireView);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
        };
        this.mDialogCreated = false;
    }

    public c(int i) {
        super(i);
        this.mDismissRunnable = new Runnable() { // from class: androidx.fragment.app.c.1
            @Override // java.lang.Runnable
            @SuppressLint({"SyntheticAccessor"})
            public void run() {
                c.this.mOnDismissListener.onDismiss(c.this.mDialog);
            }
        };
        this.mOnCancelListener = new DialogInterface.OnCancelListener() { // from class: androidx.fragment.app.c.2
            @Override // android.content.DialogInterface.OnCancelListener
            @SuppressLint({"SyntheticAccessor"})
            public void onCancel(DialogInterface dialogInterface) {
                if (c.this.mDialog != null) {
                    c cVar = c.this;
                    cVar.onCancel(cVar.mDialog);
                }
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: androidx.fragment.app.c.3
            @Override // android.content.DialogInterface.OnDismissListener
            @SuppressLint({"SyntheticAccessor"})
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.mDialog != null) {
                    c cVar = c.this;
                    cVar.onDismiss(cVar.mDialog);
                }
            }
        };
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new androidx.lifecycle.q<androidx.lifecycle.k>() { // from class: androidx.fragment.app.c.4
            @Override // androidx.lifecycle.q
            @SuppressLint({"SyntheticAccessor"})
            public void a(androidx.lifecycle.k kVar) {
                if (kVar == null || !c.this.mShowsDialog) {
                    return;
                }
                View requireView = c.this.requireView();
                if (requireView.getParent() == null) {
                    if (c.this.mDialog != null) {
                        if (FragmentManager.a(3)) {
                            Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + c.this.mDialog);
                        }
                        c.this.mDialog.setContentView(requireView);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
        };
        this.mDialogCreated = false;
    }

    public void setStyle(int i, int i2) {
        if (FragmentManager.a(2)) {
            Log.d("FragmentManager", "Setting style and theme for DialogFragment " + this + " to " + i + ", " + i2);
        }
        this.mStyle = i;
        int i3 = this.mStyle;
        if (i3 == 2 || i3 == 3) {
            this.mTheme = R.style.Theme.Panel;
        }
        if (i2 != 0) {
            this.mTheme = i2;
        }
    }

    public void show(FragmentManager fragmentManager, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        s a2 = fragmentManager.a();
        a2.a(this, str);
        a2.b();
    }

    public int show(s sVar, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        sVar.a(this, str);
        this.mViewDestroyed = false;
        this.mBackStackId = sVar.b();
        return this.mBackStackId;
    }

    public void showNow(FragmentManager fragmentManager, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        s a2 = fragmentManager.a();
        a2.a(this, str);
        a2.d();
    }

    public void dismiss() {
        dismissInternal(false, false);
    }

    public void dismissAllowingStateLoss() {
        dismissInternal(true, false);
    }

    private void dismissInternal(boolean z, boolean z2) {
        if (this.mDismissed) {
            return;
        }
        this.mDismissed = true;
        this.mShownByMe = false;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.mHandler.getLooper()) {
                    onDismiss(this.mDialog);
                } else {
                    this.mHandler.post(this.mDismissRunnable);
                }
            }
        }
        this.mViewDestroyed = true;
        if (this.mBackStackId >= 0) {
            getParentFragmentManager().a(this.mBackStackId, 1);
            this.mBackStackId = -1;
            return;
        }
        s a2 = getParentFragmentManager().a();
        a2.a(this);
        if (z) {
            a2.c();
        } else {
            a2.b();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public int getTheme() {
        return this.mTheme;
    }

    public void setCancelable(boolean z) {
        this.mCancelable = z;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    public void setShowsDialog(boolean z) {
        this.mShowsDialog = z;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().a(this.mObserver);
        if (this.mShownByMe) {
            return;
        }
        this.mDismissed = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
        getViewLifecycleOwnerLiveData().b(this.mObserver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new Handler();
        this.mShowsDialog = this.mContainerId == 0;
        if (bundle != null) {
            this.mStyle = bundle.getInt(SAVED_STYLE, 0);
            this.mTheme = bundle.getInt(SAVED_THEME, 0);
            this.mCancelable = bundle.getBoolean(SAVED_CANCELABLE, true);
            this.mShowsDialog = bundle.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
            this.mBackStackId = bundle.getInt(SAVED_BACK_STACK_ID, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.Fragment
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null || this.mDialog == null || bundle == null || (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) == null) {
            return;
        }
        this.mDialog.onRestoreInstanceState(bundle2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.Fragment
    public e createFragmentContainer() {
        final e createFragmentContainer = super.createFragmentContainer();
        return new e() { // from class: androidx.fragment.app.c.5
            @Override // androidx.fragment.app.e
            public View a(int i) {
                if (createFragmentContainer.a()) {
                    return createFragmentContainer.a(i);
                }
                return c.this.onFindViewById(i);
            }

            @Override // androidx.fragment.app.e
            public boolean a() {
                return createFragmentContainer.a() || c.this.onHasView();
            }
        };
    }

    View onFindViewById(int i) {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    boolean onHasView() {
        return this.mDialogCreated;
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        if (!this.mShowsDialog || this.mCreatingDialog) {
            if (FragmentManager.a(2)) {
                String str = "getting layout inflater for DialogFragment " + this;
                if (!this.mShowsDialog) {
                    Log.d("FragmentManager", "mShowsDialog = false: " + str);
                } else {
                    Log.d("FragmentManager", "mCreatingDialog = true: " + str);
                }
            }
            return onGetLayoutInflater;
        }
        prepareDialog(bundle);
        if (FragmentManager.a(2)) {
            Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
        }
        Dialog dialog = this.mDialog;
        return dialog != null ? onGetLayoutInflater.cloneInContext(dialog.getContext()) : onGetLayoutInflater;
    }

    public void setupDialog(Dialog dialog, int i) {
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                Window window = dialog.getWindow();
                if (window != null) {
                    window.addFlags(24);
                    break;
                }
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(requireContext(), getTheme());
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.mViewDestroyed) {
            return;
        }
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        dismissInternal(true, true);
    }

    private void prepareDialog(Bundle bundle) {
        if (this.mShowsDialog && !this.mDialogCreated) {
            try {
                this.mCreatingDialog = true;
                this.mDialog = onCreateDialog(bundle);
                if (this.mShowsDialog) {
                    setupDialog(this.mDialog, this.mStyle);
                    Context context = getContext();
                    if (context instanceof Activity) {
                        this.mDialog.setOwnerActivity((Activity) context);
                    }
                    this.mDialog.setCancelable(this.mCancelable);
                    this.mDialog.setOnCancelListener(this.mOnCancelListener);
                    this.mDialog.setOnDismissListener(this.mOnDismissListener);
                    this.mDialogCreated = true;
                } else {
                    this.mDialog = null;
                }
            } finally {
                this.mCreatingDialog = false;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.mDialog == null || bundle == null || (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) == null) {
            return;
        }
        this.mDialog.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
            View decorView = this.mDialog.getWindow().getDecorView();
            androidx.lifecycle.z.a(decorView, this);
            aa.a(decorView, this);
            androidx.savedstate.e.a(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean(SAVED_INTERNAL_DIALOG_SHOWING, false);
            bundle.putBundle(SAVED_DIALOG_STATE_TAG, onSaveInstanceState);
        }
        int i = this.mStyle;
        if (i != 0) {
            bundle.putInt(SAVED_STYLE, i);
        }
        int i2 = this.mTheme;
        if (i2 != 0) {
            bundle.putInt(SAVED_THEME, i2);
        }
        boolean z = this.mCancelable;
        if (!z) {
            bundle.putBoolean(SAVED_CANCELABLE, z);
        }
        boolean z2 = this.mShowsDialog;
        if (!z2) {
            bundle.putBoolean(SAVED_SHOWS_DIALOG, z2);
        }
        int i3 = this.mBackStackId;
        if (i3 != -1) {
            bundle.putInt(SAVED_BACK_STACK_ID, i3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = true;
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!this.mDismissed) {
                onDismiss(this.mDialog);
            }
            this.mDialog = null;
            this.mDialogCreated = false;
        }
    }
}
