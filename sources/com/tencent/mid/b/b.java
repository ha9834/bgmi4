package com.tencent.mid.b;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b {
    public static List<String> a(File file) {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                arrayList.add(readLine.trim());
            } else {
                fileReader.close();
                bufferedReader.close();
                return arrayList;
            }
        }
    }

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
}
