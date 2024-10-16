package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.a;
import androidx.appcompat.widget.ak;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final PorterDuff.Mode f357a = PorterDuff.Mode.SRC_IN;
    private static j b;
    private ak c;

    public static synchronized void a() {
        synchronized (j.class) {
            if (b == null) {
                b = new j();
                b.c = ak.a();
                b.c.a(new ak.e() { // from class: androidx.appcompat.widget.j.1

                    /* renamed from: a, reason: collision with root package name */
                    private final int[] f358a = {a.e.abc_textfield_search_default_mtrl_alpha, a.e.abc_textfield_default_mtrl_alpha, a.e.abc_ab_share_pack_mtrl_alpha};
                    private final int[] b = {a.e.abc_ic_commit_search_api_mtrl_alpha, a.e.abc_seekbar_tick_mark_material, a.e.abc_ic_menu_share_mtrl_alpha, a.e.abc_ic_menu_copy_mtrl_am_alpha, a.e.abc_ic_menu_cut_mtrl_alpha, a.e.abc_ic_menu_selectall_mtrl_alpha, a.e.abc_ic_menu_paste_mtrl_am_alpha};
                    private final int[] c = {a.e.abc_textfield_activated_mtrl_alpha, a.e.abc_textfield_search_activated_mtrl_alpha, a.e.abc_cab_background_top_mtrl_alpha, a.e.abc_text_cursor_material, a.e.abc_text_select_handle_left_mtrl_dark, a.e.abc_text_select_handle_middle_mtrl_dark, a.e.abc_text_select_handle_right_mtrl_dark, a.e.abc_text_select_handle_left_mtrl_light, a.e.abc_text_select_handle_middle_mtrl_light, a.e.abc_text_select_handle_right_mtrl_light};
                    private final int[] d = {a.e.abc_popup_background_mtrl_mult, a.e.abc_cab_background_internal_bg, a.e.abc_menu_hardkey_panel_mtrl_mult};
                    private final int[] e = {a.e.abc_tab_indicator_material, a.e.abc_textfield_search_material};
                    private final int[] f = {a.e.abc_btn_check_material, a.e.abc_btn_radio_material, a.e.abc_btn_check_material_anim, a.e.abc_btn_radio_material_anim};

                    private ColorStateList a(Context context) {
                        return b(context, ap.a(context, a.C0024a.colorButtonNormal));
                    }

                    private ColorStateList b(Context context) {
                        return b(context, 0);
                    }

                    private ColorStateList c(Context context) {
                        return b(context, ap.a(context, a.C0024a.colorAccent));
                    }

                    private ColorStateList b(Context context, int i) {
                        int a2 = ap.a(context, a.C0024a.colorControlHighlight);
                        return new ColorStateList(new int[][]{ap.f333a, ap.d, ap.b, ap.h}, new int[]{ap.c(context, a.C0024a.colorButtonNormal), androidx.core.graphics.b.a(a2, i), androidx.core.graphics.b.a(a2, i), i});
                    }

                    private ColorStateList d(Context context) {
                        int[][] iArr = new int[3];
                        int[] iArr2 = new int[3];
                        ColorStateList b2 = ap.b(context, a.C0024a.colorSwitchThumbNormal);
                        if (b2 != null && b2.isStateful()) {
                            iArr[0] = ap.f333a;
                            iArr2[0] = b2.getColorForState(iArr[0], 0);
                            iArr[1] = ap.e;
                            iArr2[1] = ap.a(context, a.C0024a.colorControlActivated);
                            iArr[2] = ap.h;
                            iArr2[2] = b2.getDefaultColor();
                        } else {
                            iArr[0] = ap.f333a;
                            iArr2[0] = ap.c(context, a.C0024a.colorSwitchThumbNormal);
                            iArr[1] = ap.e;
                            iArr2[1] = ap.a(context, a.C0024a.colorControlActivated);
                            iArr[2] = ap.h;
                            iArr2[2] = ap.a(context, a.C0024a.colorSwitchThumbNormal);
                        }
                        return new ColorStateList(iArr, iArr2);
                    }

                    @Override // androidx.appcompat.widget.ak.e
                    public Drawable a(ak akVar, Context context, int i) {
                        if (i == a.e.abc_cab_background_top_material) {
                            return new LayerDrawable(new Drawable[]{akVar.a(context, a.e.abc_cab_background_internal_bg), akVar.a(context, a.e.abc_cab_background_top_mtrl_alpha)});
                        }
                        return null;
                    }

                    private void a(Drawable drawable, int i, PorterDuff.Mode mode) {
                        if (ac.b(drawable)) {
                            drawable = drawable.mutate();
                        }
                        if (mode == null) {
                            mode = j.f357a;
                        }
                        drawable.setColorFilter(j.a(i, mode));
                    }

                    @Override // androidx.appcompat.widget.ak.e
                    public boolean a(Context context, int i, Drawable drawable) {
                        if (i == a.e.abc_seekbar_track_material) {
                            LayerDrawable layerDrawable = (LayerDrawable) drawable;
                            a(layerDrawable.findDrawableByLayerId(R.id.background), ap.a(context, a.C0024a.colorControlNormal), j.f357a);
                            a(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), ap.a(context, a.C0024a.colorControlNormal), j.f357a);
                            a(layerDrawable.findDrawableByLayerId(R.id.progress), ap.a(context, a.C0024a.colorControlActivated), j.f357a);
                            return true;
                        }
                        if (i != a.e.abc_ratingbar_material && i != a.e.abc_ratingbar_indicator_material && i != a.e.abc_ratingbar_small_material) {
                            return false;
                        }
                        LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                        a(layerDrawable2.findDrawableByLayerId(R.id.background), ap.c(context, a.C0024a.colorControlNormal), j.f357a);
                        a(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), ap.a(context, a.C0024a.colorControlActivated), j.f357a);
                        a(layerDrawable2.findDrawableByLayerId(R.id.progress), ap.a(context, a.C0024a.colorControlActivated), j.f357a);
                        return true;
                    }

                    private boolean a(int[] iArr, int i) {
                        for (int i2 : iArr) {
                            if (i2 == i) {
                                return true;
                            }
                        }
                        return false;
                    }

                    @Override // androidx.appcompat.widget.ak.e
                    public ColorStateList a(Context context, int i) {
                        if (i == a.e.abc_edit_text_material) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_edittext);
                        }
                        if (i == a.e.abc_switch_track_mtrl_alpha) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_switch_track);
                        }
                        if (i == a.e.abc_switch_thumb_material) {
                            return d(context);
                        }
                        if (i == a.e.abc_btn_default_mtrl_shape) {
                            return a(context);
                        }
                        if (i == a.e.abc_btn_borderless_material) {
                            return b(context);
                        }
                        if (i == a.e.abc_btn_colored_material) {
                            return c(context);
                        }
                        if (i == a.e.abc_spinner_mtrl_am_alpha || i == a.e.abc_spinner_textfield_background_material) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_spinner);
                        }
                        if (a(this.b, i)) {
                            return ap.b(context, a.C0024a.colorControlNormal);
                        }
                        if (a(this.e, i)) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_default);
                        }
                        if (a(this.f, i)) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_btn_checkable);
                        }
                        if (i == a.e.abc_seekbar_thumb_material) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_seek_thumb);
                        }
                        return null;
                    }

                    @Override // androidx.appcompat.widget.ak.e
                    public boolean b(Context context, int i, Drawable drawable) {
                        PorterDuff.Mode mode;
                        boolean z;
                        int i2;
                        PorterDuff.Mode mode2 = j.f357a;
                        boolean a2 = a(this.f358a, i);
                        int i3 = R.attr.colorBackground;
                        if (a2) {
                            i3 = a.C0024a.colorControlNormal;
                            mode = mode2;
                            z = true;
                            i2 = -1;
                        } else if (a(this.c, i)) {
                            i3 = a.C0024a.colorControlActivated;
                            mode = mode2;
                            z = true;
                            i2 = -1;
                        } else if (a(this.d, i)) {
                            mode = PorterDuff.Mode.MULTIPLY;
                            z = true;
                            i2 = -1;
                        } else if (i == a.e.abc_list_divider_mtrl_alpha) {
                            i3 = R.attr.colorForeground;
                            mode = mode2;
                            i2 = Math.round(40.8f);
                            z = true;
                        } else if (i == a.e.abc_dialog_material_background) {
                            mode = mode2;
                            z = true;
                            i2 = -1;
                        } else {
                            mode = mode2;
                            z = false;
                            i2 = -1;
                            i3 = 0;
                        }
                        if (!z) {
                            return false;
                        }
                        if (ac.b(drawable)) {
                            drawable = drawable.mutate();
                        }
                        drawable.setColorFilter(j.a(ap.a(context, i3), mode));
                        if (i2 != -1) {
                            drawable.setAlpha(i2);
                        }
                        return true;
                    }

                    @Override // androidx.appcompat.widget.ak.e
                    public PorterDuff.Mode a(int i) {
                        if (i == a.e.abc_switch_thumb_material) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }
                });
            }
        }
    }

    public static synchronized j b() {
        j jVar;
        synchronized (j.class) {
            if (b == null) {
                a();
            }
            jVar = b;
        }
        return jVar;
    }

    public synchronized Drawable a(Context context, int i) {
        return this.c.a(context, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable a(Context context, int i, boolean z) {
        return this.c.a(context, i, z);
    }

    public synchronized void a(Context context) {
        this.c.a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList b(Context context, int i) {
        return this.c.b(context, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Drawable drawable, as asVar, int[] iArr) {
        ak.a(drawable, asVar, iArr);
    }

    public static synchronized PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (j.class) {
            a2 = ak.a(i, mode);
        }
        return a2;
    }
}
