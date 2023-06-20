package com.ruoyi.financial.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 融资担保公司合规情况对象 financing_guarantee_compliance
 *
 * @author xmx
 * @date 2023-06-12
 */
public class FinancingGuaranteeCompliance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 企业id */
    private Long deptId;

    /** 企业名称 */
    private String deptName;

    /** 放大倍数 */
    @Excel(name = "放大倍数")
    private BigDecimal amplificationFactor;

    /** 支农支小占比 */
    @Excel(name = "支农支小占比")
    private BigDecimal ruralSmallRatio;

    /** 担保费率 */
    @Excel(name = "担保费率")
    private BigDecimal guaranteeFeeRate;

    /** 单户担保规模 */
    @Excel(name = "单户担保规模")
    private BigDecimal singleGuaranteeScale;

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
    public void setAmplificationFactor(BigDecimal amplificationFactor)
    {
        this.amplificationFactor = amplificationFactor;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public BigDecimal getAmplificationFactor()
    {
        return amplificationFactor;
    }
    public void setRuralSmallRatio(BigDecimal ruralSmallRatio)
    {
        this.ruralSmallRatio = ruralSmallRatio;
    }

    public BigDecimal getRuralSmallRatio()
    {
        return ruralSmallRatio;
    }
    public void setGuaranteeFeeRate(BigDecimal guaranteeFeeRate)
    {
        this.guaranteeFeeRate = guaranteeFeeRate;
    }

    public BigDecimal getGuaranteeFeeRate()
    {
        return guaranteeFeeRate;
    }
    public void setSingleGuaranteeScale(BigDecimal singleGuaranteeScale)
    {
        this.singleGuaranteeScale = singleGuaranteeScale;
    }

    public BigDecimal getSingleGuaranteeScale()
    {
        return singleGuaranteeScale;
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
            .append("amplificationFactor", getAmplificationFactor())
            .append("ruralSmallRatio", getRuralSmallRatio())
            .append("guaranteeFeeRate", getGuaranteeFeeRate())
            .append("singleGuaranteeScale", getSingleGuaranteeScale())
            .append("infoDate", getInfoDate())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
