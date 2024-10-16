package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.a;
import androidx.appcompat.app.AlertController;

/* loaded from: classes.dex */
public class c extends f implements DialogInterface {

    /* renamed from: a, reason: collision with root package name */
    final AlertController f177a;

    protected c(Context context, int i) {
        super(context, a(context, i));
        this.f177a = new AlertController(getContext(), this, getWindow());
    }

    static int a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.C0024a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView a() {
        return this.f177a.b();
    }

    @Override // androidx.appcompat.app.f, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f177a.a(charSequence);
    }

    public void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f177a.a(i, charSequence, onClickListener, (Message) null, (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.f, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f177a.a();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f177a.a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f177a.b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final AlertController.a f178a;
        private final int b;

        public a(Context context) {
            this(context, c.a(context, 0));
        }

        public a(Context context, int i) {
            this.f178a = new AlertController.a(new ContextThemeWrapper(context, c.a(context, i)));
            this.b = i;
        }

        public Context a() {
            return this.f178a.f146a;
        }

        public a a(CharSequence charSequence) {
            this.f178a.f = charSequence;
            return this;
        }

        public a a(View view) {
            this.f178a.g = view;
            return this;
        }

        public a a(int i) {
            AlertController.a aVar = this.f178a;
            aVar.h = aVar.f146a.getText(i);
            return this;
        }

        public a a(Drawable drawable) {
            this.f178a.d = drawable;
            return this;
        }

        public a a(DialogInterface.OnKeyListener onKeyListener) {
            this.f178a.u = onKeyListener;
            return this;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f178a;
            aVar.w = listAdapter;
            aVar.x = onClickListener;
            return this;
        }

        public a a(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f178a;
            aVar.w = listAdapter;
            aVar.x = onClickListener;
            aVar.I = i;
            aVar.H = true;
            return this;
        }

        public c b() {
            c cVar = new c(this.f178a.f146a, this.b);
            this.f178a.a(cVar.f177a);
            cVar.setCancelable(this.f178a.r);
            if (this.f178a.r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.f178a.s);
            cVar.setOnDismissListener(this.f178a.t);
            if (this.f178a.u != null) {
                cVar.setOnKeyListener(this.f178a.u);
            }
            return cVar;
        }
    }
}
