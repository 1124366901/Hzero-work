package com.hand.demo.api.controller.v1;import io.choerodon.core.iam.ResourceLevel;import io.choerodon.swagger.annotation.Permission;import io.swagger.annotations.ApiOperation;import org.hzero.boot.platform.code.builder.CodeRuleBuilder;import org.hzero.boot.platform.profile.ProfileClient;import org.hzero.core.base.BaseController;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.*;import java.util.Map;@RestController("codeController.v1")@RequestMapping("/v1/code")public class TestCodeController extends BaseController {    @Autowired    private CodeRuleBuilder codeRuleBuilder;    @Autowired    private ProfileClient profileClient;    @ApiOperation(value = "生成租户级编码规则（按照租户隔离）")    @Permission(level = ResourceLevel.SITE, permissionLogin = true)    @PostMapping("/code-rule")    public String generateCode(            Long tenantId,            String ruleCode,            String levelCode,            String levelValue,            Map<String, String> variableMap) {        return codeRuleBuilder.generateCode(tenantId, ruleCode, levelCode, levelValue, variableMap);    }    @ApiOperation(value = "维护测试")    @Permission(level = ResourceLevel.ORGANIZATION, permissionLogin = true)    @PostMapping("/respect")    public String getProfileValueByOptions(Long tenantId, Long userId, Long roleId, String profileName){        return profileClient.getProfileValueByOptions(tenantId, userId, roleId, profileName);    }}