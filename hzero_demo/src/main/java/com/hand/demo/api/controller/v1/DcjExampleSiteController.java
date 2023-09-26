package com.hand.demo.api.controller.v1;

import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.hand.demo.domain.entity.DcjExample;
import com.hand.demo.domain.repository.DcjExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import com.hand.demo.app.service.DcjExampleService;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
import io.swagger.annotations.ApiParam;
import java.util.List;

/**
 * 创建表测试 管理 API
 *
 * @author changjie.ding@hand-china.com 2023-09-21 13:51:58
 */
@RestController("dcjExampleSiteController.v1")
@RequestMapping("/v1/dcj-examples")
public class DcjExampleSiteController extends BaseController {

    @Autowired
    private DcjExampleRepository dcjExampleRepository;
    @Autowired
    private DcjExampleService dcjExampleService;

    @ApiOperation(value = "创建表测试维护-分页查询创建表测试列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<Page<DcjExample>> page(DcjExample dcjExample, @ApiIgnore @SortDefault(value = DcjExample.FIELD_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<DcjExample> list = dcjExampleRepository.pageAndSort(pageRequest, dcjExample);
        return Results.success(list);
    }

    @ApiOperation(value = "创建表测试维护-查询创建表测试明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{id}")
    public ResponseEntity<DcjExample> detail(@ApiParam(value = "创建表测试ID", required = true) @PathVariable Long id) {
        DcjExample dcjExample = dcjExampleRepository.selectByPrimaryKey(id);
        return Results.success(dcjExample);
    }

    @ApiOperation(value = "创建表测试维护-创建创建表测试")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<DcjExample> create(@RequestBody DcjExample dcjExample) {
        validObject(dcjExample);
        dcjExampleService.save(dcjExample);
        return Results.success(dcjExample);
    }

    @ApiOperation(value = "创建表测试维护-修改创建表测试")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<DcjExample> update(@RequestBody DcjExample dcjExample) {
        SecurityTokenHelper.validToken(dcjExample);
        dcjExampleService.save(dcjExample);
        return Results.success(dcjExample);
    }

        @ApiOperation(value = "创建表测试维护-批量保存创建表测试")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping("/batch-saving")
    public ResponseEntity<List<DcjExample>> batchSave(@RequestBody List<DcjExample> dcjExampleList) {
        SecurityTokenHelper.validToken(dcjExampleList);
        dcjExampleService.batchSave(dcjExampleList);
        return Results.success(dcjExampleList);
    }

    @ApiOperation(value = "创建表测试维护-删除创建表测试")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<Void> remove(@RequestBody DcjExample dcjExample) {
        SecurityTokenHelper.validToken(dcjExample);
        dcjExampleRepository.deleteByPrimaryKey(dcjExample);
        return Results.success();
    }

}
