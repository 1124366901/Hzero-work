package com.hand.demo.app.service.impl;

import com.hand.demo.domain.entity.DcjExample;
import com.hand.demo.domain.repository.DcjExampleRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;
import io.choerodon.mybatis.domain.AuditDomain;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.hand.demo.app.service.DcjExampleService;
import java.util.List;

import org.hzero.mybatis.helper.UniqueHelper;

/**
 * 创建表测试应用服务默认实现
 *
 * @author changjie.ding@hand-china.com 2023-09-21 13:51:58
 */
@Service
public class DcjExampleServiceImpl implements DcjExampleService {
                                        
    @Autowired
    private DcjExampleRepository dcjExampleRepository;


    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<DcjExample> batchSave(List<DcjExample> dcjExampleList) {
        Map<AuditDomain.RecordStatus, List<DcjExample>> statusMap = dcjExampleList.stream().collect(Collectors.groupingBy(DcjExample::get_status));
        // 删除
        if (statusMap.containsKey(AuditDomain.RecordStatus.delete)) {
            List<DcjExample> deleteList = statusMap.get(AuditDomain.RecordStatus.delete);
            dcjExampleRepository.batchDeleteByPrimaryKey(deleteList);
        }
        // 更新
        if (statusMap.containsKey(AuditDomain.RecordStatus.update)) {
            List<DcjExample> updateList = statusMap.get(AuditDomain.RecordStatus.update);
            updateList.forEach(item -> {
                // TODO: 唯一性校验
                UniqueHelper.valid(item,DcjExample.DCJ_EXAMPLE_U1);
                dcjExampleRepository.updateByPrimaryKeySelective(item);
            });
        }
        // 新增
        if (statusMap.containsKey(AuditDomain.RecordStatus.create)) {
            List<DcjExample> createList = statusMap.get(AuditDomain.RecordStatus.create);
            createList.forEach(item -> {
                // TODO: 唯一性校验
                UniqueHelper.valid(item,DcjExample.DCJ_EXAMPLE_U1);
                dcjExampleRepository.insertSelective(item);
            });
        }
        return dcjExampleList;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public DcjExample save(DcjExample dcjExample) {
        //保存创建表测试
        UniqueHelper.valid(dcjExample,DcjExample.DCJ_EXAMPLE_U1);
        if (dcjExample.getId() == null) {
            dcjExampleRepository.insertSelective(dcjExample);
        } else {
            dcjExampleRepository.updateOptional(dcjExample,
                    DcjExample.FIELD_CODE,
                    DcjExample.FIELD_NAME
            );
        }

        return dcjExample;
    }
}
