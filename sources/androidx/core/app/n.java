package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.drive.DriveFile;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class n implements Iterable<Intent> {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Intent> f480a = new ArrayList<>();
    private final Context b;

    /* loaded from: classes.dex */
    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private n(Context context) {
        this.b = context;
    }

    public static n a(Context context) {
        return new n(context);
    }

    public n a(Intent intent) {
        this.f480a.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n a(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = f.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.b.getPackageManager());
            }
            a(component);
            a(supportParentActivityIntent);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public n a(ComponentName componentName) {
        int size = this.f480a.size();
        try {
            Intent a2 = f.a(this.b, componentName);
            while (a2 != null) {
                this.f480a.add(size, a2);
                a2 = f.a(this.b, a2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f480a.iterator();
    }

    public void a() {
        a((Bundle) null);
    }

    public void a(Bundle bundle) {
        if (this.f480a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        ArrayList<Intent> arrayList = this.f480a;
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (androidx.core.content.a.a(this.b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        this.b.startActivity(intent);
    }
}
