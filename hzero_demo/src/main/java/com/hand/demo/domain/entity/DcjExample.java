package com.hand.demo.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotBlank;
import io.choerodon.mybatis.domain.AuditDomain;
import org.hzero.mybatis.annotation.Unique;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 创建表测试
 *
 * @author changjie.ding@hand-china.com 2023-09-21 13:51:58
 */
@ApiModel("创建表测试")
@VersionAudit
@ModifyAudit
@Table(name = "dcj_example")
public class DcjExample extends AuditDomain {

    public static final String FIELD_ID = "id";
    public static final String FIELD_CODE = "code";
    public static final String FIELD_NAME = "name";
    public static final String DCJ_EXAMPLE_U1 = "dcj_example_u1";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("")
    @Id
    @GeneratedValue
    private Long id;
    @ApiModelProperty(value = "编码", required = true)
    @NotBlank
    @Unique(DCJ_EXAMPLE_U1)
    private String code;
    @ApiModelProperty(value = "名称", required = true)
    @NotBlank
    private String name;

	//
    // 非数据库字段
    // ------------------------------------------------------------------------------
    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 
     */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    /**
     * @return 编码
     */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
    /**
     * @return 名称
     */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

