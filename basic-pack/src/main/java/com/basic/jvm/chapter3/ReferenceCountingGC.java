package com.basic.jvm.chapter3;

public class ReferenceCountingGC {
    public Object instance=null;
    private static final int _1MB=1024*1024;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGc() {
        ReferenceCountingGC referenceCountingGC=new ReferenceCountingGC();
        ReferenceCountingGC referenceCountingGC1 = new ReferenceCountingGC();
        referenceCountingGC.instance = referenceCountingGC1;
        referenceCountingGC1.instance=referenceCountingGC;
        referenceCountingGC=null;
        referenceCountingGC1=null;
        System.gc();

    }

    public static void main(String[] args) {

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
