package com.hand.demo.domain.entity;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.MultiLanguage;
import io.choerodon.mybatis.annotation.MultiLanguageField;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hzero.core.util.Regexs;
import org.hzero.mybatis.annotation.Unique;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@MultiLanguage
@ApiModel("Mybatis增强组件测试")
@VersionAudit
@ModifyAudit
@Table(name = "test_demo")
public class Demo extends AuditDomain {

    public static final String FIELD_ID = "id";
    public static final String FIELD_CODE = "code";
    public static final String FIELD_NAME = "name";
    public static final String TEST_DEMO_U1 = "test_demo_u1";

    @ApiModelProperty("")
    @Id
    @GeneratedValue
    private Long id;
    @ApiModelProperty(value = "编码", required = true)
    @NotBlank
    @NotNull(message = "error.code.null")
    @Pattern(regexp = Regexs.CODE, message = "error.code.illegal")
    @Unique(TEST_DEMO_U1)
    private String code;
    @ApiModelProperty(value = "名称", required = true)
    @MultiLanguageField
    @NotBlank
    @NotNull(message = "error.name.null")
    private String name;

    private String mail;

    private Integer sex;

    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
