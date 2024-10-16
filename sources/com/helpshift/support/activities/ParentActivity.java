package com.helpshift.support.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.s;
import com.helpshift.R;
import com.helpshift.activities.MainActivity;
import com.helpshift.support.fragments.SupportFragment;
import com.helpshift.support.fragments.SupportFragmentConstants;
import com.helpshift.util.ActivityUtil;
import com.helpshift.util.HelpshiftContext;
import java.util.List;

/* loaded from: classes2.dex */
public class ParentActivity extends MainActivity {
    private static final String TAG = "Helpshift_PrntAct";
    FragmentManager fragmentManager;

    @Override // com.helpshift.activities.MainActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            if (!HelpshiftContext.installCallSuccessful.get()) {
                Log.d(TAG, "Install call not successful, falling back to launcher activity");
                ActivityUtil.startLauncherActivityAndFinish(this);
                return;
            }
            setContentView(R.layout.hs__parent_activity);
            this.fragmentManager = getSupportFragmentManager();
            if (bundle == null) {
                Bundle extras = getIntent().getExtras();
                if (extras == null) {
                    extras = new Bundle();
                }
                extras.putBoolean(SupportFragmentConstants.IS_EMBEDDED, false);
                s a2 = this.fragmentManager.a();
                a2.a(R.id.support_fragment_container, SupportFragment.newInstance(extras));
                a2.b();
            }
        } catch (Exception e) {
            Log.e(TAG, "Caught exception in ParentActivity.onCreate()", e);
            if (HelpshiftContext.installCallSuccessful.get()) {
                return;
            }
            ActivityUtil.startLauncherActivityAndFinish(this);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        List<Fragment> g = this.fragmentManager.g();
        if (g != null) {
            for (Fragment fragment : g) {
                if (fragment != null && fragment.isVisible() && (fragment instanceof SupportFragment)) {
                    if (((SupportFragment) fragment).onBackPressed()) {
                        return;
                    }
                    FragmentManager childFragmentManager = fragment.getChildFragmentManager();
                    if (childFragmentManager.f() > 0) {
                        childFragmentManager.d();
                        return;
                    }
                }
            }
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        List<Fragment> g = this.fragmentManager.g();
        if (g == null) {
            return;
        }
        for (Fragment fragment : g) {
            if (fragment instanceof SupportFragment) {
                ((SupportFragment) fragment).onNewIntent(intent.getExtras());
            }
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
