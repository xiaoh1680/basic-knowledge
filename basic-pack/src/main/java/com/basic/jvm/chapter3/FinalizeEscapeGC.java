package com.basic.jvm.chapter3;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK=null;

    public void isAlive() {
        System.out.printf("yes,i am still alive:");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.printf("finalize method executed！");
        FinalizeEscapeGC.SAVE_HOOK=this;
    }

    public static void main(String[] args) throws Throwable{
        SAVE_HOOK=new FinalizeEscapeGC();
        SAVE_HOOK=null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        }else {
            System.out.printf("no,i am dead");
        }
        SAVE_HOOK=null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        }else {
            System.out.printf("no,i am dead");
        }

    }
}
