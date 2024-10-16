package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.smtt.sdk.TbsListener;

/* loaded from: classes.dex */
public class f extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f449a;
    private View b;
    private int c;

    public void setEmptyVisibility(int i) {
        this.c = i;
    }

    public int getEmptyVisibility() {
        return this.c;
    }

    public View getContent() {
        return this.b;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM);
            Paint paint = new Paint();
            paint.setARGB(255, TbsListener.ErrorCode.ROM_NOT_ENOUGH, TbsListener.ErrorCode.ROM_NOT_ENOUGH, TbsListener.ErrorCode.ROM_NOT_ENOUGH);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void a(ConstraintLayout constraintLayout) {
        if (this.f449a == -1 && !isInEditMode()) {
            setVisibility(this.c);
        }
        this.b = constraintLayout.findViewById(this.f449a);
        View view = this.b;
        if (view != null) {
            ((ConstraintLayout.a) view.getLayoutParams()).aa = true;
            this.b.setVisibility(0);
            setVisibility(0);
        }
    }

    public void setContentId(int i) {
        View findViewById;
        if (this.f449a == i) {
            return;
        }
        View view = this.b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.a) this.b.getLayoutParams()).aa = false;
            this.b = null;
        }
        this.f449a = i;
        if (i == -1 || (findViewById = ((View) getParent()).findViewById(i)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.b == null) {
            return;
        }
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        ConstraintLayout.a aVar2 = (ConstraintLayout.a) this.b.getLayoutParams();
        aVar2.al.e(0);
        aVar.al.h(aVar2.al.o());
        aVar.al.i(aVar2.al.q());
        aVar2.al.e(8);
    }
}
