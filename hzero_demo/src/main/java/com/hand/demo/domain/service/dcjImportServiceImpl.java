package com.hand.demo.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hand.demo.domain.entity.DcjExample;
import com.hand.demo.domain.repository.DcjExampleRepository;
import org.hzero.boot.imported.app.service.IDoImportService;
import org.hzero.boot.imported.infra.validator.annotation.ImportService;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;

@ImportService(templateCode = "TEST")
public class dcjImportServiceImpl implements IDoImportService {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DcjExampleRepository repository;
    @Override
    public Boolean doImport(String data) {
        DcjExample dcjExample;
        try {
            dcjExample = objectMapper.readValue(data, DcjExample.class);
        } catch (IOException e) {
            // 失败
            return false;
        }
        repository.insertSelective(dcjExample);
        // 成功
        return true;
    }
}