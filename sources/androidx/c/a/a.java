package androidx.c.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.c.a.b;

/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f406a;
    protected boolean b;
    protected Cursor c;
    protected Context d;
    protected int e;
    protected C0037a f;
    protected DataSetObserver g;
    protected androidx.c.a.b h;
    protected FilterQueryProvider i;

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void a(View view, Context context, Cursor cursor);

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public a(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    void a(Context context, Cursor cursor, int i) {
        if ((i & 1) == 1) {
            i |= 2;
            this.b = true;
        } else {
            this.b = false;
        }
        boolean z = cursor != null;
        this.c = cursor;
        this.f406a = z;
        this.d = context;
        this.e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f = new C0037a();
            this.g = new b();
        } else {
            this.f = null;
            this.g = null;
        }
        if (z) {
            C0037a c0037a = this.f;
            if (c0037a != null) {
                cursor.registerContentObserver(c0037a);
            }
            DataSetObserver dataSetObserver = this.g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    @Override // androidx.c.a.b.a
    public Cursor a() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f406a || (cursor = this.c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.f406a || (cursor = this.c) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.f406a && (cursor = this.c) != null && cursor.moveToPosition(i)) {
            return this.c.getLong(this.e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f406a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.c.moveToPosition(i)) {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
        if (view == null) {
            view = a(this.d, this.c, viewGroup);
        }
        a(view, this.d, this.c);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f406a) {
            return null;
        }
        this.c.moveToPosition(i);
        if (view == null) {
            view = b(this.d, this.c, viewGroup);
        }
        a(view, this.d, this.c);
        return view;
    }

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return a(context, cursor, viewGroup);
    }

    public void a(Cursor cursor) {
        Cursor c = c(cursor);
        if (c != null) {
            c.close();
        }
    }

    public Cursor c(Cursor cursor) {
        Cursor cursor2 = this.c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0037a c0037a = this.f;
            if (c0037a != null) {
                cursor2.unregisterContentObserver(c0037a);
            }
            DataSetObserver dataSetObserver = this.g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.c = cursor;
        if (cursor != null) {
            C0037a c0037a2 = this.f;
            if (c0037a2 != null) {
                cursor.registerContentObserver(c0037a2);
            }
            DataSetObserver dataSetObserver2 = this.g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.e = cursor.getColumnIndexOrThrow("_id");
            this.f406a = true;
            notifyDataSetChanged();
        } else {
            this.e = -1;
            this.f406a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public CharSequence b(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor a(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.i;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(charSequence);
        }
        return this.c;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.h == null) {
            this.h = new androidx.c.a.b(this);
        }
        return this.h;
    }

    protected void b() {
        Cursor cursor;
        if (!this.b || (cursor = this.c) == null || cursor.isClosed()) {
            return;
        }
        this.f406a = this.c.requery();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.c.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0037a extends ContentObserver {
        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        C0037a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            a.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f406a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f406a = false;
            aVar.notifyDataSetInvalidated();
        }
    }
}
