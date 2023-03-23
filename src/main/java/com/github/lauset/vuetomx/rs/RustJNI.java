package com.github.lauset.vuetomx.rs;

import com.github.lauset.vuetomx.utils.OSInfo;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

public abstract class RustJNI extends IRust {
    // main
    public static native void init();

    public static native int divInt(int a, int b);

    // func
    public static native void factFn(int n, IRustFact callback);

    public static native void asyncFn(int count, int sleep, IRustAsync callback);

    // counter
    public static native long counterNew(RustJNI callback);

    public static native void counterIncrement(long counterPtr);

    public static native void counterDestroy(long counterPtr);

    static {
        String libName = "libvt_dc";
        String extName = OSInfo.getLibExt();
        String fs = System.getProperty("file.separator");
        String ps = System.getProperty("path.separator");

        try {
            String classPath = ResourceUtils.getURL("classpath:").getPath();
            System.load(classPath + "libs" + fs + libName + extName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public abstract void factCallback(int res);

    public abstract void asyncCallback(int progress);

}
