package com.helpshift.support.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.helpshift.R;

/* loaded from: classes2.dex */
public class HSRoundedImageView extends AppCompatImageView {
    private ImageView.ScaleType SCALE_TYPE;
    private Paint backgroundPaint;
    private Paint bitmapPaint;
    private BitmapShader bitmapShader;
    private Paint borderPaint;
    private RectF borderRect;
    private float borderWidth;
    private float cornerRadius;
    private RectF drawableRect;
    private Bitmap imageBitmap;
    private final Matrix shaderMatrix;

    public HSRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HSRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.shaderMatrix = new Matrix();
        this.SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
        this.drawableRect = new RectF();
        this.borderRect = new RectF();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.HSRoundedImageView, 0, 0);
        int color = obtainStyledAttributes.getColor(R.styleable.HSRoundedImageView_hs__borderColor, -1);
        int color2 = obtainStyledAttributes.getColor(R.styleable.HSRoundedImageView_hs__backgroundColor, -1);
        this.borderWidth = obtainStyledAttributes.getDimension(R.styleable.HSRoundedImageView_hs__borderWidth, 0.0f);
        if (this.borderWidth < 0.0f) {
            this.borderWidth = 0.0f;
        }
        this.cornerRadius = obtainStyledAttributes.getDimension(R.styleable.HSRoundedImageView_hs__cornerRadius, 0.0f);
        obtainStyledAttributes.recycle();
        this.bitmapPaint = new Paint();
        this.bitmapPaint.setStyle(Paint.Style.FILL);
        this.bitmapPaint.setAntiAlias(true);
        this.borderPaint = new Paint();
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.borderPaint.setAntiAlias(true);
        this.borderPaint.setColor(color);
        this.borderPaint.setStrokeWidth(this.borderWidth);
        if (color2 != -1) {
            this.backgroundPaint = new Paint();
            this.backgroundPaint.setStyle(Paint.Style.FILL);
            this.backgroundPaint.setColor(color2);
            this.backgroundPaint.setAntiAlias(true);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.imageBitmap = bitmap;
        setup();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (drawable instanceof BitmapDrawable) {
            this.imageBitmap = ((BitmapDrawable) drawable).getBitmap();
            setup();
        }
    }

    private void setup() {
        Bitmap bitmap = this.imageBitmap;
        if (bitmap != null) {
            updateGlobalParamsAndBitmapShader(bitmap);
        } else {
            invalidate();
        }
    }

    private void updateGlobalParamsAndBitmapShader(Bitmap bitmap) {
        if (bitmap == null || getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.borderRect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.drawableRect.set(this.borderRect);
        RectF rectF = this.borderRect;
        float f = this.borderWidth;
        rectF.inset(f / 2.0f, f / 2.0f);
        RectF rectF2 = this.drawableRect;
        float f2 = this.borderWidth;
        rectF2.inset(f2, f2);
        this.bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        updateShaderMatrix(this.bitmapShader, width, height);
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.SCALE_TYPE;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.bitmapPaint.setShader(this.bitmapShader);
        float f = this.borderWidth;
        if (f > 0.0f) {
            Paint paint = this.backgroundPaint;
            if (paint != null) {
                RectF rectF = this.drawableRect;
                float f2 = this.cornerRadius;
                canvas.drawRoundRect(rectF, f2 - f, f2 - f, paint);
            }
            RectF rectF2 = this.drawableRect;
            float f3 = this.cornerRadius;
            float f4 = this.borderWidth;
            canvas.drawRoundRect(rectF2, f3 - f4, f3 - f4, this.bitmapPaint);
            RectF rectF3 = this.borderRect;
            float f5 = this.cornerRadius;
            canvas.drawRoundRect(rectF3, f5, f5, this.borderPaint);
            return;
        }
        Paint paint2 = this.backgroundPaint;
        if (paint2 != null) {
            RectF rectF4 = this.drawableRect;
            float f6 = this.cornerRadius;
            canvas.drawRoundRect(rectF4, f6, f6, paint2);
        }
        RectF rectF5 = this.drawableRect;
        float f7 = this.cornerRadius;
        canvas.drawRoundRect(rectF5, f7, f7, this.bitmapPaint);
    }

    private void updateShaderMatrix(BitmapShader bitmapShader, int i, int i2) {
        float width;
        float f;
        if (getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        float f2 = 0.0f;
        if (i > i2) {
            width = this.drawableRect.height() / i2;
            f = (this.drawableRect.width() - (i * width)) * 0.5f;
        } else {
            width = this.drawableRect.width() / i;
            f2 = (this.drawableRect.height() - (i2 * width)) * 0.5f;
            f = 0.0f;
        }
        this.shaderMatrix.setScale(width, width);
        Matrix matrix = this.shaderMatrix;
        float f3 = this.borderWidth;
        matrix.postTranslate(((int) (f + 0.5f)) + f3, ((int) (f2 + 0.5f)) + f3);
        bitmapShader.setLocalMatrix(this.shaderMatrix);
    }
}
