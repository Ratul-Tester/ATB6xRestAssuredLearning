package com.thetestingaccademy.Ilistner;

import org.testng.IExecutionListener;
import org.testng.ISuiteListener;

public class CustomListeners implements IExecutionListener, ISuiteListener {


    @Override
    public void onExecutionStart() {
        System.out.println("Execution Started");
        long startTime = System.currentTimeMillis();
        System.out.println("****************Execution Started at Time : "+startTime+"****************");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("Execution Finished");
        long endTime = System.currentTimeMillis();
        System.out.println("****************Execution Started at Time : "+endTime+"****************");
    }

}

