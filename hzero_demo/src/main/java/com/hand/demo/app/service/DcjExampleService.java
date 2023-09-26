package com.hand.demo.app.service;

import com.hand.demo.domain.entity.DcjExample;
import java.util.List;


/**
 * 创建表测试应用服务
 *
 * @author changjie.ding@hand-china.com 2023-09-21 13:51:58
 */
public interface DcjExampleService {

    
    /**
     * 批量保存创建表测试
     *
     * @param dcjExampleList 创建表测试对象列表
     * @return 创建表测试对象列表
     */
    List<DcjExample> batchSave(List<DcjExample> dcjExampleList);


    /**
     * 保存创建表测试
     *
     * @param dcjExample 创建表测试对象
     * @return 创建表测试对象
     */
    DcjExample save(DcjExample dcjExample);
}
