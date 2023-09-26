package com.hand.demo.config;

import org.hzero.boot.scheduler.infra.annotation.JobHandler;
import org.hzero.boot.scheduler.infra.enums.ReturnT;
import org.hzero.boot.scheduler.infra.handler.IJobHandler;
import org.hzero.boot.scheduler.infra.tool.SchedulerTool;

import java.util.Map;

@JobHandler("yydz")
public class DemoJob implements IJobHandler {

    @Override
    public ReturnT execute(Map<String, String> map, SchedulerTool tool) {
        tool.info("Hello World!");
        return ReturnT.SUCCESS;
    }
}
