package com.tencent.mtt.spcialcall;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.tencent.mtt.spcialcall.sdk.ExtendItem;
import com.tencent.mtt.spcialcall.sdk.NinePatchUtils;

/* loaded from: classes.dex */
public class ThemeSwitcher {
    public static void doSwitch(View view, ExtendItem extendItem) {
        try {
            Drawable initTransDrawable = initTransDrawable(view.getContext(), extendItem);
            if (view instanceof ImageButton) {
                if (initTransDrawable != null) {
                    ((ImageButton) view).setImageDrawable(initTransDrawable);
                }
            } else {
                if (!(view instanceof Button)) {
                    if (initTransDrawable != null) {
                        view.setBackgroundDrawable(initTransDrawable);
                        return;
                    }
                    return;
                }
                if (initTransDrawable != null) {
                    view.setBackgroundDrawable(initTransDrawable);
                }
                if (extendItem.getLabel() != null) {
                    ((Button) view).setText(extendItem.getLabel());
                }
                if (extendItem.getTextColor() != 0) {
                    ((Button) view).setTextColor(extendItem.getTextColor());
                }
                if (extendItem.getTextSize() != 0) {
                    ((Button) view).setTextSize(1, extendItem.getTextSize());
                }
            }
        } catch (Exception unused) {
        }
    }

    public static Drawable initTransDrawable(Context context, ExtendItem extendItem) {
        Drawable bitmapDrawable;
        Drawable bitmapDrawable2;
        Bitmap image = extendItem.getImage();
        Bitmap imagePressed = extendItem.getImagePressed();
        if (image != null) {
            byte[] ninePatchChunk = image.getNinePatchChunk();
            byte[] imageNinePatchChunk = ninePatchChunk == null ? extendItem.getImageNinePatchChunk() : ninePatchChunk;
            Rect rect = new Rect();
            if (imageNinePatchChunk != null) {
                NinePatchUtils.readPaddingFromChunk(imageNinePatchChunk, rect);
                bitmapDrawable = new NinePatchDrawable(context.getResources(), image, imageNinePatchChunk, rect, null);
            } else {
                bitmapDrawable = new BitmapDrawable(context.getResources(), image);
            }
            if (imagePressed == null) {
                return bitmapDrawable;
            }
            if (imagePressed.getNinePatchChunk() != null) {
                imageNinePatchChunk = imagePressed.getNinePatchChunk();
            }
            if (imageNinePatchChunk != null) {
                bitmapDrawable2 = new NinePatchDrawable(context.getResources(), imagePressed, imageNinePatchChunk, rect, null);
            } else {
                bitmapDrawable2 = new BitmapDrawable(context.getResources(), imagePressed);
            }
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_enabled, R.attr.state_focused}, bitmapDrawable2);
            stateListDrawable.addState(new int[]{R.attr.state_pressed, R.attr.state_enabled}, bitmapDrawable2);
            stateListDrawable.addState(new int[]{R.attr.state_focused}, bitmapDrawable2);
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, bitmapDrawable2);
            stateListDrawable.addState(new int[]{R.attr.state_enabled}, bitmapDrawable);
            stateListDrawable.addState(new int[0], bitmapDrawable);
            return stateListDrawable;
        }
        if (extendItem.getDrawableName() == null) {
            return null;
        }
        String themePackage = extendItem.getThemePackage();
        if (themePackage == null) {
            themePackage = ExtraInfo.getOriPkg();
        }
        try {
            Context createPackageContext = context.createPackageContext(themePackage, 2);
            return createPackageContext.getResources().getDrawable(createPackageContext.getResources().getIdentifier(extendItem.getDrawableName(), extendItem.getType(), themePackage));
        } catch (Exception unused) {
            return null;
        }
    }
}
