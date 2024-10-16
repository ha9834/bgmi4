package com.amazonaws.services.s3.model.inventory;

import com.tdatamaster.tdm.device.DeviceInfoName;

/* loaded from: classes.dex */
public enum InventoryIncludedObjectVersions {
    All(DeviceInfoName.ALL_DEVICE_INFO_STRING),
    Current("Current");

    private final String name;

    InventoryIncludedObjectVersions(String str) {
        this.name = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
