package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.MapEntryLite;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public interface an {
    <T> T a(ao<T> aoVar, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    <T> T a(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    void a(List<Double> list) throws IOException;

    <T> void a(List<T> list, ao<T> aoVar, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    <K, V> void a(Map<K, V> map, MapEntryLite.a<K, V> aVar, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    boolean a();

    int b() throws IOException;

    @Deprecated
    <T> T b(ao<T> aoVar, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    @Deprecated
    <T> T b(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    void b(List<Float> list) throws IOException;

    @Deprecated
    <T> void b(List<T> list, ao<T> aoVar, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    int c();

    void c(List<Long> list) throws IOException;

    void d(List<Long> list) throws IOException;

    boolean d() throws IOException;

    double e() throws IOException;

    void e(List<Integer> list) throws IOException;

    float f() throws IOException;

    void f(List<Long> list) throws IOException;

    long g() throws IOException;

    void g(List<Integer> list) throws IOException;

    long h() throws IOException;

    void h(List<Boolean> list) throws IOException;

    int i() throws IOException;

    void i(List<String> list) throws IOException;

    long j() throws IOException;

    void j(List<String> list) throws IOException;

    int k() throws IOException;

    void k(List<ByteString> list) throws IOException;

    void l(List<Integer> list) throws IOException;

    boolean l() throws IOException;

    String m() throws IOException;

    void m(List<Integer> list) throws IOException;

    String n() throws IOException;

    void n(List<Integer> list) throws IOException;

    ByteString o() throws IOException;

    void o(List<Long> list) throws IOException;

    int p() throws IOException;

    void p(List<Integer> list) throws IOException;

    int q() throws IOException;

    void q(List<Long> list) throws IOException;

    int r() throws IOException;

    long s() throws IOException;

    int t() throws IOException;

    long u() throws IOException;
}
