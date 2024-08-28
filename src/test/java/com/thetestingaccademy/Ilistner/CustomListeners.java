package com.thetestingaccademy.Ilistner;

import org.testng.IExecutionListener;
import org.testng.ISuiteListener;

public class CustomListeners implements IExecutionListener, ISuiteListener {


    @Override
    public void onExecutionStart() {
        System.out.println("Execution Started");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("Execution Finished");
    }

}

