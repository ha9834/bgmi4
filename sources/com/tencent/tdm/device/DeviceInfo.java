package com.tencent.tdm.device;

@Deprecated
/* loaded from: classes.dex */
public class DeviceInfo<T> extends com.tdatamaster.tdm.device.DeviceInfo<T> {
    public DeviceInfo(String str, T t, int i) {
        super(str, t, i);
    }

    public DeviceInfo(T t, int i) {
        super(t, i);
    }

    public DeviceInfo(T t) {
        super(t);
    }

    public DeviceInfo(com.tdatamaster.tdm.device.DeviceInfo<T> deviceInfo) {
        super(deviceInfo.name, deviceInfo.value, deviceInfo.status);
    }
}
