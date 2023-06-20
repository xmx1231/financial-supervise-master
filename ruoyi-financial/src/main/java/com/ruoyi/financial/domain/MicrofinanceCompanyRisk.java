package com.ruoyi.financial.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 小贷公司风险情况对象 microfinance_company_risk
 *
 * @author xmx
 * @date 2023-06-12
 */
public class MicrofinanceCompanyRisk extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 企业id */
    private Long deptId;

    /** 企业名称 */
    private String deptName;

    /** 内控制度 */
    @Excel(name = "内控制度")
    private String internalControls;

    /** 财务管理 */
    @Excel(name = "财务管理")
    private String financialManagement;

    /** 风控制度 */
    @Excel(name = "风控制度")
    private String riskManagement;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date infoDate;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setInternalControls(String internalControls)
    {
        this.internalControls = internalControls;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getInternalControls()
    {
        return internalControls;
    }
    public void setFinancialManagement(String financialManagement)
    {
        this.financialManagement = financialManagement;
    }

    public String getFinancialManagement()
    {
        return financialManagement;
    }
    public void setRiskManagement(String riskManagement)
    {
        this.riskManagement = riskManagement;
    }

    public String getRiskManagement()
    {
        return riskManagement;
    }
    public void setInfoDate(Date infoDate)
    {
        this.infoDate = infoDate;
    }

    public Date getInfoDate()
    {
        return infoDate;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deptId", getDeptId())
                .append("deptName", getDeptName())
            .append("internalControls", getInternalControls())
            .append("financialManagement", getFinancialManagement())
            .append("riskManagement", getRiskManagement())
            .append("infoDate", getInfoDate())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
