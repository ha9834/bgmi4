package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor {

    /* renamed from: a, reason: collision with root package name */
    private AbstractWindowedCursor f1494a;

    @KeepForSdk
    public CursorWrapper(Cursor cursor) {
        super(cursor);
        for (int i = 0; i < 10 && (cursor instanceof android.database.CursorWrapper); i++) {
            cursor = ((android.database.CursorWrapper) cursor).getWrappedCursor();
        }
        if (!(cursor instanceof AbstractWindowedCursor)) {
            String valueOf = String.valueOf(cursor.getClass().getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unknown type: ".concat(valueOf) : new String("Unknown type: "));
        }
        this.f1494a = (AbstractWindowedCursor) cursor;
    }

    @Override // android.database.CrossProcessCursor
    @KeepForSdk
    public CursorWindow getWindow() {
        return this.f1494a.getWindow();
    }

    @KeepForSdk
    public void setWindow(CursorWindow cursorWindow) {
        this.f1494a.setWindow(cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    @KeepForSdk
    public void fillWindow(int i, CursorWindow cursorWindow) {
        this.f1494a.fillWindow(i, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int i, int i2) {
        return this.f1494a.onMove(i, i2);
    }

    @Override // android.database.CursorWrapper
    public /* synthetic */ Cursor getWrappedCursor() {
        return this.f1494a;
    }
}
