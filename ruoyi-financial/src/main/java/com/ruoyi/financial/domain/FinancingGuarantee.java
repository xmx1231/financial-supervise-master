package com.ruoyi.financial.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 融资担保公司经营情况对象 financing_guarantee
 *
 * @author xmx
 * @date 2023-06-12
 */
public class FinancingGuarantee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 企业id */
    private Long deptId;

    /** 企业名称 */
    private String deptName;

    /** 当年新增担保额 */
    @Excel(name = "当年新增担保额")
    private BigDecimal newGuaranteeAmount;

    /** 担保余额 */
    @Excel(name = "担保余额")
    private BigDecimal guaranteeBalance;

    /** 担保户数 */
    @Excel(name = "担保户数")
    private Long guaranteeCount;

    /** 担保费率 */
    @Excel(name = "担保费率")
    private BigDecimal guaranteeFeeRate;

    /** 融资担保放大倍数 */
    @Excel(name = "融资担保放大倍数")
    private BigDecimal financingGuaranteeAmplificationFactor;

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
    public void setNewGuaranteeAmount(BigDecimal newGuaranteeAmount)
    {
        this.newGuaranteeAmount = newGuaranteeAmount;
    }


    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public BigDecimal getNewGuaranteeAmount()
    {
        return newGuaranteeAmount;
    }
    public void setGuaranteeBalance(BigDecimal guaranteeBalance)
    {
        this.guaranteeBalance = guaranteeBalance;
    }

    public BigDecimal getGuaranteeBalance()
    {
        return guaranteeBalance;
    }
    public void setGuaranteeCount(Long guaranteeCount)
    {
        this.guaranteeCount = guaranteeCount;
    }

    public Long getGuaranteeCount()
    {
        return guaranteeCount;
    }
    public void setGuaranteeFeeRate(BigDecimal guaranteeFeeRate)
    {
        this.guaranteeFeeRate = guaranteeFeeRate;
    }

    public BigDecimal getGuaranteeFeeRate()
    {
        return guaranteeFeeRate;
    }
    public void setFinancingGuaranteeAmplificationFactor(BigDecimal financingGuaranteeAmplificationFactor)
    {
        this.financingGuaranteeAmplificationFactor = financingGuaranteeAmplificationFactor;
    }

    public BigDecimal getFinancingGuaranteeAmplificationFactor()
    {
        return financingGuaranteeAmplificationFactor;
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
            .append("newGuaranteeAmount", getNewGuaranteeAmount())
            .append("guaranteeBalance", getGuaranteeBalance())
            .append("guaranteeCount", getGuaranteeCount())
            .append("guaranteeFeeRate", getGuaranteeFeeRate())
            .append("financingGuaranteeAmplificationFactor", getFinancingGuaranteeAmplificationFactor())
            .append("infoDate", getInfoDate())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
