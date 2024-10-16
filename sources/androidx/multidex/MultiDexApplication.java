package androidx.multidex;

import android.content.Context;
import com.tencent.tpshell.TPShellApplication;

/* loaded from: classes.dex */
public class MultiDexApplication extends TPShellApplication {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tpshell.TPShellApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }
}
