package com.github.lauset.vuetomx.rs;

public class VuetomRs extends RustJNI {

    public void factCallback(int res) {
        System.out.println("factCallback: res = " + res);
    }

    public void asyncCallback(int progress) {
        System.out.println("asyncCallback: thread id = " + Thread.currentThread().getId() + ", progress = " + progress + "%");
    }
}
