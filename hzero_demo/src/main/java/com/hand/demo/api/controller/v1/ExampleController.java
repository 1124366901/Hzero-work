package com.hand.demo.api.controller.v1;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import com.hand.demo.app.service.ExampleService;
import com.hand.demo.config.SwaggerTags;
import com.hand.demo.domain.entity.Example;
import com.hand.demo.domain.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * API接口
 */
@Api(tags = SwaggerTags.EXAMPLE)
@RestController("exampleController.v1")
@RequestMapping("/v1/example")
public class ExampleController extends BaseController {

    @Autowired
    private ExampleService exampleService;
    @Autowired
    private ExampleRepository exampleRepository;

    @ApiOperation(value = "根据ID获取")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", paramType = "path")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Example> hello(@PathVariable Long id) {
        return Results.success(exampleRepository.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "新增方法")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Example example) {
        return Results.success(exampleRepository.insert(example));
    }

    @ApiOperation(value = "更新方法")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Example example) {
        return Results.success(exampleRepository.updateByPrimaryKeySelective(example));
    }

    @ApiOperation(value = "删除方法")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Example example = new Example();
        example.setId(id);
        return Results.success(exampleRepository.deleteByPrimaryKey(example));
    }

    @ApiOperation(value = "测试方法")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @GetMapping("/test2")
    public String test2() {
        return "ssssssssss";
    }



}