package com.tencent.msdk.a.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static File a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        if (!file.getParentFile().exists()) {
            a(file.getParentFile().getAbsolutePath());
        }
        file.mkdir();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> a(File file) {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                fileReader.close();
                bufferedReader.close();
                return arrayList;
            }
            arrayList.add(readLine.trim());
        }
    }
}
