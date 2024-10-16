package com.tencent.gcloud.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.abase.TX;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class GCloudAppLifecycle {
    public static final GCloudAppLifecycle Instance = new GCloudAppLifecycle();
    List<GCloudAppLifecycleObserver> _observers = new ArrayList();
    List<Object> _genericobservers = new ArrayList();

    private GCloudAppLifecycle() {
    }

    public void addObserver(GCloudAppLifecycleObserver gCloudAppLifecycleObserver) {
        Log.i("", "addObserver begin _observers.size():" + this._observers.size());
        if (gCloudAppLifecycleObserver == null) {
            return;
        }
        this._observers.add(gCloudAppLifecycleObserver);
    }

    public void removeObserver(GCloudAppLifecycleObserver gCloudAppLifecycleObserver) {
        if (gCloudAppLifecycleObserver != null && this._observers.size() > 0) {
            gCloudAppLifecycleObserver.equals(this._observers.get(0));
            this._observers.remove(0);
        }
    }

    public void addObserverByName(String str) {
        Log.i("", "addObserverByName Name:" + str);
        if (str == null) {
            return;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (GCloudAppLifecycleObserver.class.isAssignableFrom(cls)) {
                Log.i("", "GCloudAppLifecycleObserver.class.isAssignableFrom(clz) true");
                cls.newInstance();
                Log.i("", "addObserverByName Success, observerName:" + str);
            } else {
                Log.i("", "GCloudAppLifecycleObserver.class.isAssignableFrom(clz) false");
                this._genericobservers.add(cls.newInstance());
                Log.i("", "addGenericObserverByName Success, observerName:" + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onCreate(Activity activity, Bundle bundle) {
        TX.Instance.Initialize(activity);
        for (int i = 0; i < this._observers.size(); i++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i("", "observer pos:" + i + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gCloudAppLifecycleObserver.onCreate(bundle);
                gCloudAppLifecycleObserver.onCreate(activity, bundle);
            }
        }
        for (int i2 = 0; i2 < this._genericobservers.size(); i2++) {
            Object obj = this._genericobservers.get(i2);
            if (obj != null) {
                try {
                    Log.i("", "genericobserver pos:" + i2 + " className:" + obj.getClass().getName());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    obj.getClass().getMethod("onCreate", Bundle.class).invoke(obj, bundle);
                    obj.getClass().getMethod("onCreate", Activity.class, Bundle.class).invoke(obj, activity, bundle);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        PluginUtils.Startup();
        PluginUtils.PostStartup();
    }

    public void onStart() {
        for (int i = 0; i < this._observers.size(); i++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i("", "observer pos:" + i + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gCloudAppLifecycleObserver.onStart();
            }
        }
        for (int i2 = 0; i2 < this._genericobservers.size(); i2++) {
            Object obj = this._genericobservers.get(i2);
            if (obj != null) {
                try {
                    Log.i("", "genericobserver pos:" + i2 + " className:" + obj.getClass().getName());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    obj.getClass().getMethod("onStart", new Class[0]).invoke(obj, new Object[0]);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void onResume() {
        for (int i = 0; i < this._observers.size(); i++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i("", "observer pos:" + i + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gCloudAppLifecycleObserver.onResume();
            }
        }
        for (int i2 = 0; i2 < this._genericobservers.size(); i2++) {
            Object obj = this._genericobservers.get(i2);
            if (obj != null) {
                try {
                    Log.i("", "genericobserver pos:" + i2 + " className:" + obj.getClass().getName());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    obj.getClass().getMethod("onResume", new Class[0]).invoke(obj, new Object[0]);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void onPause() {
        for (int i = 0; i < this._observers.size(); i++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i("", "observer pos:" + i + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gCloudAppLifecycleObserver.onPause();
            }
        }
        for (int i2 = 0; i2 < this._genericobservers.size(); i2++) {
            Object obj = this._genericobservers.get(i2);
            if (obj != null) {
                try {
                    Log.i("", "genericobserver pos:" + i2 + " className:" + obj.getClass().getName());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    obj.getClass().getMethod("onPause", new Class[0]).invoke(obj, new Object[0]);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void onStop() {
        for (int i = 0; i < this._observers.size(); i++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i("", "observer pos:" + i + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gCloudAppLifecycleObserver.onStop();
            }
        }
        for (int i2 = 0; i2 < this._genericobservers.size(); i2++) {
            Object obj = this._genericobservers.get(i2);
            if (obj != null) {
                try {
                    Log.i("", "genericobserver pos:" + i2 + " className:" + obj.getClass().getName());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    obj.getClass().getMethod("onStop", new Class[0]).invoke(obj, new Object[0]);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        for (int i = 0; i < this._observers.size(); i++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i("", "observer pos:" + i + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gCloudAppLifecycleObserver.onDestroy();
            }
        }
        for (int i2 = 0; i2 < this._genericobservers.size(); i2++) {
            Object obj = this._genericobservers.get(i2);
            if (obj != null) {
                try {
                    Log.i("", "genericobserver pos:" + i2 + " className:" + obj.getClass().getName());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    obj.getClass().getMethod("onDestroy", new Class[0]).invoke(obj, new Object[0]);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void onRestart() {
        for (int i = 0; i < this._observers.size(); i++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i("", "observer pos:" + i + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gCloudAppLifecycleObserver.onRestart();
            }
        }
        for (int i2 = 0; i2 < this._genericobservers.size(); i2++) {
            Object obj = this._genericobservers.get(i2);
            if (obj != null) {
                try {
                    Log.i("", "genericobserver pos:" + i2 + " className:" + obj.getClass().getName());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    obj.getClass().getMethod("onRestart", new Class[0]).invoke(obj, new Object[0]);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void onNewIntent(Intent intent) {
        for (int i = 0; i < this._observers.size(); i++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i("", "observer pos:" + i + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gCloudAppLifecycleObserver.onNewIntent(intent);
            }
        }
        for (int i2 = 0; i2 < this._genericobservers.size(); i2++) {
            Object obj = this._genericobservers.get(i2);
            if (obj != null) {
                try {
                    Log.i("", "genericobserver pos:" + i2 + " className:" + obj.getClass().getName());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    obj.getClass().getMethod("onNewIntent", Intent.class).invoke(obj, intent);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        for (int i3 = 0; i3 < this._observers.size(); i3++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i3);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i("", "observer pos:" + i3 + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gCloudAppLifecycleObserver.onActivityResult(i, i2, intent);
            }
        }
        for (int i4 = 0; i4 < this._genericobservers.size(); i4++) {
            Object obj = this._genericobservers.get(i4);
            if (obj != null) {
                try {
                    Log.i("", "genericobserver pos:" + i4 + " className:" + obj.getClass().getName());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    obj.getClass().getMethod("onActivityResult", Integer.TYPE, Integer.TYPE, Intent.class).invoke(obj, Integer.valueOf(i), Integer.valueOf(i2), intent);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        for (int i2 = 0; i2 < this._observers.size(); i2++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i2);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i("", "observer pos:" + i2 + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gCloudAppLifecycleObserver.onRequestPermissionsResult(i, strArr, iArr);
            }
        }
        for (int i3 = 0; i3 < this._genericobservers.size(); i3++) {
            Object obj = this._genericobservers.get(i3);
            if (obj != null) {
                try {
                    Log.i("", "genericobserver pos:" + i3 + " className:" + obj.getClass().getName());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    obj.getClass().getMethod("onRequestPermissionsResult", Integer.TYPE, String[].class, int[].class).invoke(obj, Integer.valueOf(i), strArr, iArr);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }
}
