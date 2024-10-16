package com.helpshift.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* loaded from: classes2.dex */
public class ByteArrayUtil {
    public static byte[] toByteArray(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeObject(obj);
                    objectOutputStream2.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    IOUtils.closeQuitely(objectOutputStream2);
                    IOUtils.closeQuitely(byteArrayOutputStream);
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    IOUtils.closeQuitely(objectOutputStream);
                    IOUtils.closeQuitely(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    public static Object toObject(byte[] bArr) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(byteArrayInputStream);
                try {
                    Object readObject = objectInputStream2.readObject();
                    IOUtils.closeQuitely(byteArrayInputStream);
                    IOUtils.closeQuitely(objectInputStream2);
                    return readObject;
                } catch (Throwable th) {
                    objectInputStream = objectInputStream2;
                    th = th;
                    IOUtils.closeQuitely(byteArrayInputStream);
                    IOUtils.closeQuitely(objectInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
        }
    }
}
