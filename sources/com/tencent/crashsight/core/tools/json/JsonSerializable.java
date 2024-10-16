package com.tencent.crashsight.core.tools.json;

import com.tencent.crashsight.core.tools.UQMLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class JsonSerializable {
    private static volatile ConcurrentHashMap<Class, ArrayList<Field>> mFields = new ConcurrentHashMap<>();
    public JSONObject rawObject = null;

    public JsonSerializable() {
    }

    public JsonSerializable(JSONObject jSONObject) throws JSONException {
        fillWithJSON(jSONObject == null ? new JSONObject() : jSONObject);
    }

    public JsonSerializable(String str) throws JSONException {
        fillWithJSON(new JSONObject(str == null ? "" : str));
    }

    private ArrayList<Field> getFields(Object obj) {
        return getFields((Class) obj.getClass());
    }

    private ArrayList<Field> getFields(Class cls) {
        if (mFields.containsKey(cls)) {
            return mFields.get(cls);
        }
        ArrayList<Field> arrayList = new ArrayList<>();
        for (Field field : cls.getDeclaredFields()) {
            if (Modifier.isPublic(field.getModifiers()) && field.isAnnotationPresent(JsonProp.class)) {
                arrayList.add(field);
            }
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null && JsonSerializable.class.isAssignableFrom(superclass)) {
            arrayList.addAll(0, getFields(superclass));
        }
        mFields.put(cls, arrayList);
        return arrayList;
    }

    public JSONObject toUnityJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Iterator<Field> it = getFields(this).iterator();
        while (it.hasNext()) {
            Field next = it.next();
            try {
                Object obj = next.get(this);
                if (obj != null) {
                    if (obj instanceof JsonSerializable) {
                        jSONObject.put(next.getName(), ((JsonSerializable) obj).toUnityJSONObject());
                    } else if (obj instanceof List) {
                        JSONArray jSONArray = new JSONArray();
                        for (Object obj2 : (List) obj) {
                            if (JsonSerializable.class.isAssignableFrom(obj2.getClass())) {
                                jSONArray.put(((JsonSerializable) obj2).toUnityJSONObject());
                            } else {
                                jSONArray.put(obj2);
                            }
                        }
                        jSONObject.put(next.getName(), jSONArray);
                    } else {
                        jSONObject.put(next.getName(), obj);
                    }
                }
            } catch (IllegalAccessException e) {
                UQMLog.e(e.getMessage());
            }
        }
        return jSONObject;
    }

    public String toUnityString() throws JSONException {
        return toUnityJSONObject().toString();
    }

    public String toJSONString() throws JSONException {
        return toJSONObject().toString();
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Iterator<Field> it = getFields(this).iterator();
        while (it.hasNext()) {
            Field next = it.next();
            JsonProp jsonProp = (JsonProp) next.getAnnotation(JsonProp.class);
            JsonList jsonList = (JsonList) next.getAnnotation(JsonList.class);
            if (jsonProp != null) {
                try {
                    Object obj = next.get(this);
                    if (obj != null) {
                        if (jsonList != null) {
                            JSONArray jSONArray = new JSONArray();
                            if (obj instanceof List) {
                                for (Object obj2 : (List) obj) {
                                    if (JsonSerializable.class.isAssignableFrom(obj2.getClass())) {
                                        jSONArray.put(((JsonSerializable) obj2).toJSONObject());
                                    } else {
                                        jSONArray.put(obj2);
                                    }
                                }
                                jSONObject.put(jsonProp.value(), jSONArray);
                            }
                        } else if (JsonSerializable.class.isAssignableFrom(next.getType())) {
                            if (obj instanceof JsonSerializable) {
                                jSONObject.put(jsonProp.value(), ((JsonSerializable) obj).toJSONObject());
                            }
                        } else {
                            jSONObject.put(jsonProp.value(), obj);
                        }
                    }
                } catch (IllegalAccessException e) {
                    UQMLog.e("parse to json string error : " + e.getMessage());
                }
            }
        }
        return jSONObject;
    }

    private Object getDefaultValue(Field field) {
        Class<?> type = field.getType();
        if (Integer.TYPE.isAssignableFrom(type)) {
            if (field.isAnnotationPresent(JsonInt.class)) {
                return Integer.valueOf(((JsonInt) field.getAnnotation(JsonInt.class)).def());
            }
        } else if (Long.TYPE.isAssignableFrom(type)) {
            if (field.isAnnotationPresent(JsonLong.class)) {
                return Long.valueOf(((JsonLong) field.getAnnotation(JsonLong.class)).def());
            }
        } else if (String.class.isAssignableFrom(type)) {
            if (field.isAnnotationPresent(JsonString.class)) {
                return ((JsonString) field.getAnnotation(JsonString.class)).def();
            }
        } else if (Boolean.TYPE.isAssignableFrom(type)) {
            if (field.isAnnotationPresent(JsonBoolean.class)) {
                return Boolean.valueOf(((JsonBoolean) field.getAnnotation(JsonBoolean.class)).def());
            }
        } else if (Short.TYPE.isAssignableFrom(JsonShort.class)) {
            if (field.isAnnotationPresent(JsonShort.class)) {
                return Short.valueOf(((JsonShort) field.getAnnotation(JsonShort.class)).def());
            }
        } else if (Float.TYPE.isAssignableFrom(JsonFloat.class)) {
            if (field.isAnnotationPresent(JsonFloat.class)) {
                return Float.valueOf(((JsonFloat) field.getAnnotation(JsonFloat.class)).def());
            }
        } else if (Double.TYPE.isAssignableFrom(JsonDouble.class) && field.isAnnotationPresent(JsonDouble.class)) {
            return Double.valueOf(((JsonDouble) field.getAnnotation(JsonDouble.class)).def());
        }
        return null;
    }

    private void fillWithJSON(JSONObject jSONObject) throws JSONException {
        this.rawObject = jSONObject;
        if (jSONObject.length() > 0) {
            Iterator<Field> it = getFields(this).iterator();
            while (it.hasNext()) {
                Field next = it.next();
                if (next.isAnnotationPresent(JsonProp.class)) {
                    JsonProp jsonProp = (JsonProp) next.getAnnotation(JsonProp.class);
                    JsonList jsonList = (JsonList) next.getAnnotation(JsonList.class);
                    try {
                        Object opt = jSONObject.opt(jsonProp.value());
                        if (opt != null || (opt = getDefaultValue(next)) != null) {
                            if (jsonList != null && (opt instanceof JSONArray)) {
                                JSONArray jSONArray = (JSONArray) opt;
                                Object obj = next.get(this);
                                if (next.getType() == List.class && obj == null) {
                                    obj = new LinkedList();
                                }
                                List list = (List) obj;
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    Object obj2 = jSONArray.get(i);
                                    Class cls = Class.forName(jsonList.value());
                                    if (JsonSerializable.class.isAssignableFrom(cls)) {
                                        list.add(constructWithJSON(cls, (JSONObject) obj2));
                                    } else {
                                        list.add(obj2);
                                    }
                                }
                                next.set(this, list);
                            } else if (JsonSerializable.class.isAssignableFrom(next.getType())) {
                                if (opt instanceof JSONObject) {
                                    next.set(this, constructWithJSON(next.getType(), (JSONObject) opt));
                                }
                            } else {
                                next.set(this, opt);
                            }
                        }
                    } catch (Exception e) {
                        UQMLog.d(e.getMessage());
                    } catch (ExceptionInInitializerError e2) {
                        UQMLog.d(e2.getMessage());
                    } catch (IllegalAccessException e3) {
                        UQMLog.d(e3.getMessage());
                    } catch (IllegalArgumentException e4) {
                        UQMLog.d(e4.getMessage());
                    } catch (NullPointerException e5) {
                        UQMLog.d(e5.getMessage());
                    }
                }
            }
        }
    }

    private Object constructWithJSON(Class cls, JSONObject jSONObject) throws JSONException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor declaredConstructor = cls.getDeclaredConstructor(JSONObject.class);
        if (declaredConstructor == null) {
            return null;
        }
        return declaredConstructor.newInstance(jSONObject);
    }
}
