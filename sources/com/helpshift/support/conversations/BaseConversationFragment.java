package com.helpshift.support.conversations;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import com.helpshift.R;
import com.helpshift.support.controllers.SupportController;
import com.helpshift.support.fragments.MainFragment;
import com.helpshift.support.fragments.SupportFragment;
import com.helpshift.support.storage.IMAppSessionStorage;
import com.helpshift.support.util.AppSessionConstants;
import com.helpshift.support.util.SnackbarUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.KeyboardUtil;
import com.helpshift.util.PermissionUtil;
import com.helpshift.views.HSSnackbar;

/* loaded from: classes2.dex */
public abstract class BaseConversationFragment extends MainFragment {
    public static final int REQUEST_READ_STORAGE_PERMISSION_REQUEST_ID = 2;
    public static final int REQUEST_WRITE_STORAGE_PERMISSION_REQUEST_ID = 3;
    private static final String TAG = "Helpshift_BaseConvFrag";
    private Snackbar permissionDeniedSnackbar;
    private Snackbar showRationaleSnackbar;

    protected abstract int getAttachmentMode();

    protected abstract String getToolbarTitle();

    protected abstract AppSessionConstants.Screen getViewName();

    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }

    protected abstract void onPermissionGranted(int i);

    @Override // com.helpshift.support.fragments.MainFragment
    public boolean shouldRefreshMenu() {
        return true;
    }

    @Override // com.helpshift.support.fragments.MainFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        IMAppSessionStorage.getInstance().set(AppSessionConstants.CURRENT_OPEN_SCREEN, getViewName());
    }

    @Override // com.helpshift.support.fragments.MainFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Snackbar snackbar = this.showRationaleSnackbar;
        if (snackbar != null && snackbar.h()) {
            this.showRationaleSnackbar.g();
        }
        Snackbar snackbar2 = this.permissionDeniedSnackbar;
        if (snackbar2 != null && snackbar2.h()) {
            this.permissionDeniedSnackbar.g();
        }
        super.onPause();
    }

    @Override // com.helpshift.support.fragments.MainFragment, androidx.fragment.app.Fragment
    public void onStop() {
        AppSessionConstants.Screen screen = (AppSessionConstants.Screen) IMAppSessionStorage.getInstance().get(AppSessionConstants.CURRENT_OPEN_SCREEN);
        if (screen != null && screen.equals(getViewName())) {
            IMAppSessionStorage.getInstance().removeKey(AppSessionConstants.CURRENT_OPEN_SCREEN);
        }
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SupportFragment getSupportFragment() {
        return (SupportFragment) getParentFragment();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SupportController getSupportController() {
        return getSupportFragment().getSupportController();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void requestWriteExternalStoragePermission(boolean z) {
        requestPermission(z, 3);
    }

    public void requestPermission(boolean z, int i) {
        String str;
        switch (i) {
            case 2:
                str = "android.permission.READ_EXTERNAL_STORAGE";
                break;
            case 3:
                str = "android.permission.WRITE_EXTERNAL_STORAGE";
                break;
            default:
                str = null;
                break;
        }
        if (z && str != null) {
            KeyboardUtil.hideKeyboard(getContext(), getView());
            this.showRationaleSnackbar = PermissionUtil.requestPermissions(getParentFragment(), new String[]{str}, R.string.hs__permission_denied_message, R.string.hs__permission_rationale_snackbar_action_label, i, getView());
        } else {
            if (isDetached()) {
                return;
            }
            SnackbarUtil.showSnackbar(getView(), R.string.hs__permission_not_granted, -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        boolean z = false;
        if (iArr.length == 1 && iArr[0] == 0) {
            z = true;
        }
        HSLogger.d(TAG, "onRequestPermissionsResult : request: " + i + ", result: " + z);
        if (z) {
            onPermissionGranted(i);
        } else {
            this.permissionDeniedSnackbar = HSSnackbar.make(getView(), R.string.hs__permission_denied_message, -1).a(R.string.hs__permission_denied_snackbar_action, new View.OnClickListener() { // from class: com.helpshift.support.conversations.BaseConversationFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PermissionUtil.showSettingsPage(BaseConversationFragment.this.getContext());
                }
            });
            this.permissionDeniedSnackbar.f();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportFragment().resetNewMessageCount();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setToolbarTitle(getToolbarTitle());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SnackbarUtil.hideSnackbar(getView());
        super.onDestroyView();
    }
}
