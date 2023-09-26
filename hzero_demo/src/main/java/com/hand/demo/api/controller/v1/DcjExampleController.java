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
@RestController("dcjExampleController.v1")
@RequestMapping("/v1/{organizationId}/dcj-examples")
public class DcjExampleController extends BaseController {

    @Autowired
    private DcjExampleRepository dcjExampleRepository;
    @Autowired
    private DcjExampleService dcjExampleService;

    @ApiOperation(value = "创建表测试维护-分页查询创建表测试列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<DcjExample>> page(@PathVariable(value = "organizationId") Long organizationId,
                                                            DcjExample dcjExample,
                                                            @ApiIgnore @SortDefault(value = DcjExample.FIELD_ID,
                                                                     direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<DcjExample> list = dcjExampleRepository.pageAndSort(pageRequest, dcjExample);
        return Results.success(list);
    }

    @ApiOperation(value = "创建表测试维护-查询创建表测试明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{id}")
    public ResponseEntity<DcjExample> detail(@PathVariable(value = "organizationId") Long organizationId,
                                                        @ApiParam(value = "创建表测试ID", required = true) @PathVariable Long id) {
        DcjExample dcjExample = dcjExampleRepository.selectByPrimaryKey(id);
        return Results.success(dcjExample);
    }

    @ApiOperation(value = "创建表测试维护-创建创建表测试")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<DcjExample> create(@PathVariable(value = "organizationId") Long organizationId,
                                                       @RequestBody DcjExample dcjExample) {
        validObject(dcjExample);
        dcjExampleService.save(dcjExample);
        return Results.success(dcjExample);
    }

    @ApiOperation(value = "创建表测试维护-修改创建表测试")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<DcjExample> update(@PathVariable(value = "organizationId") Long organizationId,
                                                       @RequestBody DcjExample dcjExample) {
        SecurityTokenHelper.validToken(dcjExample);
        dcjExampleService.save(dcjExample);
        return Results.success(dcjExample);
    }

        @ApiOperation(value = "创建表测试维护-批量保存创建表测试")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("/batch-saving")
    public ResponseEntity<List<DcjExample>> batchSave(@PathVariable(value = "organizationId") Long organizationId,
                                                       @RequestBody List<DcjExample> dcjExampleList) {
        SecurityTokenHelper.validToken(dcjExampleList);
        dcjExampleService.batchSave(dcjExampleList);
        return Results.success(dcjExampleList);
    }

    @ApiOperation(value = "创建表测试维护-删除创建表测试")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<Void> remove(@PathVariable(value = "organizationId") Long organizationId,
                                       @RequestBody DcjExample dcjExample) {
        SecurityTokenHelper.validToken(dcjExample);
        dcjExampleRepository.deleteByPrimaryKey(dcjExample);
        return Results.success();
    }

    @ApiOperation(value = "API权限测试")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/testapi")
    public String testAPI() {
        return "测试成功";
    }


//    @ApiOperation(value = "值集测试")
//    @Permission(level = ResourceLevel.ORGANIZATION)
//    @GetMapping("/testSQLAPI")
//    public ResponseEntity<Page<DcjExample>> testSQLAPI(@ApiParam(value = "值集测试", required = true) @PathVariable Long id) {
//        Page<DcjExample> list = dcjExampleRepository.pageAndSort(pageRequest, dcjExample);
//        return Results.success(list);
//    }


}
