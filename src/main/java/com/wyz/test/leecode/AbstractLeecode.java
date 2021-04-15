package com.wyz.test.leecode;

import com.wyz.test.Leecode;
import com.wyz.test.Utils;

public abstract class AbstractLeecode implements Leecode {

    @Override
    public void run() {
        before();
        long startTime = System.currentTimeMillis();
        onRun();
        long stopTime = System.currentTimeMillis();
        Utils.println("%s , runTime = %d", this.getClass(), stopTime - startTime);
    }

    public abstract void onRun();
}
