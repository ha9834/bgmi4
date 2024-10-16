package com.facebook.appevents.codeless.internal;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.amazonaws.event.ProgressEvent;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.nearby.connection.Connections;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ViewHierarchy {
    private static final String CLASS_RCTROOTVIEW = "com.facebook.react.ReactRootView";
    private static final String CLASS_RCTTEXTVIEW = "com.facebook.react.views.view.ReactTextView";
    private static final String CLASS_RCTVIEWGROUP = "com.facebook.react.views.view.ReactViewGroup";
    private static final String CLASS_TOUCHTARGETHELPER = "com.facebook.react.uimanager.TouchTargetHelper";
    private static final int ICON_MAX_EDGE_LENGTH = 44;
    private static final String METHOD_FIND_TOUCHTARGET_VIEW = "findTouchTargetView";
    private static final String TAG = ViewHierarchy.class.getCanonicalName();
    private static WeakReference<View> RCTRootViewReference = new WeakReference<>(null);
    private static Method methodFindTouchTargetView = null;

    public static ViewGroup getParentOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class) || view == null) {
            return null;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                return (ViewGroup) parent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static List<View> getChildrenOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    arrayList.add(viewGroup.getChildAt(i));
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static void updateBasicInfoOfView(View view, JSONObject jSONObject) {
        try {
            if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
                return;
            }
            try {
                String textOfView = getTextOfView(view);
                String hintOfView = getHintOfView(view);
                Object tag = view.getTag();
                CharSequence contentDescription = view.getContentDescription();
                jSONObject.put(ViewHierarchyConstants.CLASS_NAME_KEY, view.getClass().getCanonicalName());
                jSONObject.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, getClassTypeBitmask(view));
                jSONObject.put("id", view.getId());
                if (!SensitiveUserDataUtils.isSensitiveUserData(view)) {
                    jSONObject.put("text", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(textOfView), ""));
                } else {
                    jSONObject.put("text", "");
                    jSONObject.put(ViewHierarchyConstants.IS_USER_INPUT_KEY, true);
                }
                jSONObject.put(ViewHierarchyConstants.HINT_KEY, Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(hintOfView), ""));
                if (tag != null) {
                    jSONObject.put(ViewHierarchyConstants.TAG_KEY, Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(tag.toString()), ""));
                }
                if (contentDescription != null) {
                    jSONObject.put("description", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(contentDescription.toString()), ""));
                }
                jSONObject.put(ViewHierarchyConstants.DIMENSION_KEY, getDimensionOfView(view));
            } catch (JSONException e) {
                Utility.logd(TAG, e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
        }
    }

    public static void updateAppearanceOfView(View view, JSONObject jSONObject, float f) {
        Bitmap bitmap;
        TextView textView;
        Typeface typeface;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return;
        }
        try {
            try {
                JSONObject jSONObject2 = new JSONObject();
                if ((view instanceof TextView) && (typeface = (textView = (TextView) view).getTypeface()) != null) {
                    jSONObject2.put(ViewHierarchyConstants.TEXT_SIZE, textView.getTextSize());
                    jSONObject2.put(ViewHierarchyConstants.TEXT_IS_BOLD, typeface.isBold());
                    jSONObject2.put(ViewHierarchyConstants.TEXT_IS_ITALIC, typeface.isItalic());
                    jSONObject.put(ViewHierarchyConstants.TEXT_STYLE, jSONObject2);
                }
                if (view instanceof ImageView) {
                    Drawable drawable = ((ImageView) view).getDrawable();
                    if (!(drawable instanceof BitmapDrawable) || view.getHeight() / f > 44.0f || view.getWidth() / f > 44.0f || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) {
                        return;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    jSONObject.put(ViewHierarchyConstants.ICON_BITMAP, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                }
            } catch (JSONException e) {
                Utility.logd(TAG, e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
        }
    }

    public static JSONObject getDictionaryOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            if (view.getClass().getName().equals(CLASS_RCTROOTVIEW)) {
                RCTRootViewReference = new WeakReference<>(view);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                updateBasicInfoOfView(view, jSONObject);
                JSONArray jSONArray = new JSONArray();
                List<View> childrenOfView = getChildrenOfView(view);
                for (int i = 0; i < childrenOfView.size(); i++) {
                    jSONArray.put(getDictionaryOfView(childrenOfView.get(i)));
                }
                jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray);
            } catch (JSONException e) {
                Log.e(TAG, "Failed to create JSONObject for view.", e);
            }
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static int getClassTypeBitmask(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return 0;
        }
        try {
            int i = view instanceof ImageView ? 2 : 0;
            if (view.isClickable()) {
                i |= 32;
            }
            if (isAdapterViewItem(view)) {
                i |= 512;
            }
            if (view instanceof TextView) {
                int i2 = i | 1024 | 1;
                if (view instanceof Button) {
                    i2 |= 4;
                    if (view instanceof Switch) {
                        i2 |= 8192;
                    } else if (view instanceof CheckBox) {
                        i2 |= Connections.MAX_BYTES_DATA_SIZE;
                    }
                }
                return view instanceof EditText ? i2 | ProgressEvent.PART_COMPLETED_EVENT_CODE : i2;
            }
            if (!(view instanceof Spinner) && !(view instanceof DatePicker)) {
                return view instanceof RatingBar ? i | 65536 : view instanceof RadioGroup ? i | 16384 : ((view instanceof ViewGroup) && isRCTButton(view, RCTRootViewReference.get())) ? i | 64 : i;
            }
            return i | 4096;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return 0;
        }
    }

    private static boolean isAdapterViewItem(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return false;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof AdapterView) {
                return true;
            }
            Class<?> existingClass = getExistingClass("androidx.core.view.NestedScrollingChild");
            if (existingClass != null && existingClass.isInstance(parent)) {
                return true;
            }
            Class<?> existingClass2 = getExistingClass("androidx.core.view.NestedScrollingChild");
            if (existingClass2 != null) {
                if (existingClass2.isInstance(parent)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return false;
        }
    }

    public static String getTextOfView(View view) {
        String valueOf;
        Object selectedItem;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            if (view instanceof TextView) {
                CharSequence text = ((TextView) view).getText();
                if (view instanceof Switch) {
                    valueOf = ((Switch) view).isChecked() ? "1" : "0";
                } else {
                    valueOf = text;
                }
            } else if (view instanceof Spinner) {
                valueOf = (((Spinner) view).getCount() <= 0 || (selectedItem = ((Spinner) view).getSelectedItem()) == null) ? null : selectedItem.toString();
            } else {
                int i = 0;
                if (view instanceof DatePicker) {
                    DatePicker datePicker = (DatePicker) view;
                    valueOf = String.format("%04d-%02d-%02d", Integer.valueOf(datePicker.getYear()), Integer.valueOf(datePicker.getMonth()), Integer.valueOf(datePicker.getDayOfMonth()));
                } else if (view instanceof TimePicker) {
                    TimePicker timePicker = (TimePicker) view;
                    valueOf = String.format("%02d:%02d", Integer.valueOf(timePicker.getCurrentHour().intValue()), Integer.valueOf(timePicker.getCurrentMinute().intValue()));
                } else if (view instanceof RadioGroup) {
                    RadioGroup radioGroup = (RadioGroup) view;
                    int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                    int childCount = radioGroup.getChildCount();
                    while (true) {
                        if (i >= childCount) {
                            valueOf = null;
                            break;
                        }
                        View childAt = radioGroup.getChildAt(i);
                        if (childAt.getId() == checkedRadioButtonId && (childAt instanceof RadioButton)) {
                            valueOf = ((RadioButton) childAt).getText();
                            break;
                        }
                        i++;
                    }
                } else {
                    valueOf = view instanceof RatingBar ? String.valueOf(((RatingBar) view).getRating()) : null;
                }
            }
            return valueOf == null ? "" : valueOf.toString();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static String getHintOfView(View view) {
        CharSequence hint;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            if (view instanceof EditText) {
                hint = ((EditText) view).getHint();
            } else {
                hint = view instanceof TextView ? ((TextView) view).getHint() : null;
            }
            return hint == null ? "" : hint.toString();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    private static JSONObject getDimensionOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, view.getTop());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, view.getLeft());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, view.getWidth());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, view.getHeight());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_X_KEY, view.getScrollX());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_Y_KEY, view.getScrollY());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, view.getVisibility());
            } catch (JSONException e) {
                Log.e(TAG, "Failed to create JSONObject for dimension.", e);
            }
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static View.OnClickListener getExistingOnClickListener(View view) {
        Field declaredField;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj != null && (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener")) != null) {
                declaredField.setAccessible(true);
                return (View.OnClickListener) declaredField.get(obj);
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002c A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void setOnClickListener(android.view.View r4, android.view.View.OnClickListener r5) {
        /*
            java.lang.Class<com.facebook.appevents.codeless.internal.ViewHierarchy> r0 = com.facebook.appevents.codeless.internal.ViewHierarchy.class
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            if (r0 == 0) goto L9
            return
        L9:
            r0 = 0
            java.lang.String r1 = "android.view.View"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L23 java.lang.NoSuchFieldException -> L25 java.lang.ClassNotFoundException -> L28 java.lang.Exception -> L50
            java.lang.String r2 = "mListenerInfo"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch: java.lang.Throwable -> L23 java.lang.NoSuchFieldException -> L25 java.lang.ClassNotFoundException -> L28 java.lang.Exception -> L50
            java.lang.String r2 = "android.view.View$ListenerInfo"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L23 java.lang.NoSuchFieldException -> L26 java.lang.ClassNotFoundException -> L29 java.lang.Exception -> L50
            java.lang.String r3 = "mOnClickListener"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch: java.lang.Throwable -> L23 java.lang.NoSuchFieldException -> L26 java.lang.ClassNotFoundException -> L29 java.lang.Exception -> L50
            goto L2a
        L23:
            r4 = move-exception
            goto L4b
        L25:
            r1 = r0
        L26:
            r2 = r0
            goto L2a
        L28:
            r1 = r0
        L29:
            r2 = r0
        L2a:
            if (r1 == 0) goto L47
            if (r2 != 0) goto L2f
            goto L47
        L2f:
            r3 = 1
            r1.setAccessible(r3)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L50
            r2.setAccessible(r3)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L50
            r1.setAccessible(r3)     // Catch: java.lang.Throwable -> L23 java.lang.IllegalAccessException -> L3d java.lang.Exception -> L50
            java.lang.Object r0 = r1.get(r4)     // Catch: java.lang.Throwable -> L23 java.lang.IllegalAccessException -> L3d java.lang.Exception -> L50
        L3d:
            if (r0 != 0) goto L43
            r4.setOnClickListener(r5)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L50
            return
        L43:
            r2.set(r0, r5)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L50
            goto L50
        L47:
            r4.setOnClickListener(r5)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L50
            return
        L4b:
            java.lang.Class<com.facebook.appevents.codeless.internal.ViewHierarchy> r5 = com.facebook.appevents.codeless.internal.ViewHierarchy.class
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r5)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.setOnClickListener(android.view.View, android.view.View$OnClickListener):void");
    }

    public static View.OnTouchListener getExistingOnTouchListener(View view) {
        Field declaredField;
        try {
            if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
                return null;
            }
            try {
                try {
                    Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
                    if (declaredField2 != null) {
                        declaredField2.setAccessible(true);
                    }
                    Object obj = declaredField2.get(view);
                    if (obj != null && (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener")) != null) {
                        declaredField.setAccessible(true);
                        return (View.OnTouchListener) declaredField.get(obj);
                    }
                    return null;
                } catch (IllegalAccessException e) {
                    Utility.logd(TAG, e);
                    return null;
                }
            } catch (ClassNotFoundException e2) {
                Utility.logd(TAG, e2);
                return null;
            } catch (NoSuchFieldException e3) {
                Utility.logd(TAG, e3);
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static View getTouchReactView(float[] fArr, View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            initTouchTargetHelperMethods();
            if (methodFindTouchTargetView == null || view == null) {
                return null;
            }
            try {
                View view2 = (View) methodFindTouchTargetView.invoke(null, fArr, view);
                if (view2 != null && view2.getId() > 0) {
                    View view3 = (View) view2.getParent();
                    if (view3 != null) {
                        return view3;
                    }
                    return null;
                }
            } catch (IllegalAccessException e) {
                Utility.logd(TAG, e);
            } catch (InvocationTargetException e2) {
                Utility.logd(TAG, e2);
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static boolean isRCTButton(View view, View view2) {
        View touchReactView;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return false;
        }
        try {
            if (!view.getClass().getName().equals(CLASS_RCTVIEWGROUP) || (touchReactView = getTouchReactView(getViewLocationOnScreen(view), view2)) == null) {
                return false;
            }
            return touchReactView.getId() == view.getId();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return false;
        }
    }

    public static boolean isRCTRootView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return false;
        }
        try {
            return view.getClass().getName().equals(CLASS_RCTROOTVIEW);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return false;
        }
    }

    public static boolean isRCTTextView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return false;
        }
        try {
            return view.getClass().getName().equals(CLASS_RCTTEXTVIEW);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return false;
        }
    }

    public static boolean isRCTViewGroup(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return false;
        }
        try {
            return view.getClass().getName().equals(CLASS_RCTVIEWGROUP);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return false;
        }
    }

    public static View findRCTRootView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        while (view != null) {
            try {
                if (!isRCTRootView(view)) {
                    Object parent = view.getParent();
                    if (!(parent instanceof View)) {
                        break;
                    }
                    view = (View) parent;
                } else {
                    return view;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            }
        }
        return null;
    }

    private static float[] getViewLocationOnScreen(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            view.getLocationOnScreen(new int[2]);
            return new float[]{r2[0], r2[1]};
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    private static void initTouchTargetHelperMethods() {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return;
        }
        try {
            if (methodFindTouchTargetView != null) {
                return;
            }
            try {
                methodFindTouchTargetView = Class.forName(CLASS_TOUCHTARGETHELPER).getDeclaredMethod(METHOD_FIND_TOUCHTARGET_VIEW, float[].class, ViewGroup.class);
                methodFindTouchTargetView.setAccessible(true);
            } catch (ClassNotFoundException e) {
                Utility.logd(TAG, e);
            } catch (NoSuchMethodException e2) {
                Utility.logd(TAG, e2);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
        }
    }

    private static Class<?> getExistingClass(String str) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }
}
