package com.hand.demo.infra.repository.impl;

import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import com.hand.demo.domain.entity.DcjExample;
import com.hand.demo.domain.repository.DcjExampleRepository;
import org.springframework.stereotype.Component;

/**
 * 创建表测试 资源库实现
 *
 * @author changjie.ding@hand-china.com 2023-09-21 13:51:58
 */
@Component
public class DcjExampleRepositoryImpl extends BaseRepositoryImpl<DcjExample> implements DcjExampleRepository {
}
