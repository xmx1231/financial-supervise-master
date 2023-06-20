package com.ruoyi.financial.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 融资担保公司风险情况对象 financing_guarantee_risk
 *
 * @author xmx
 * @date 2023-06-12
 */
public class FinancingGuaranteeRisk extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 企业id */
    private Long deptId;

    /** 企业名称 */
    private String deptName;

    /** 融资担保代偿率 */
    @Excel(name = "融资担保代偿率")
    private BigDecimal guaranteeCompensationRatio;

    /** 三类资产占比 */
    @Excel(name = "三类资产占比")
    private BigDecimal threeAssetRatio;

    /** 准备金提取 */
    @Excel(name = "准备金提取")
    private BigDecimal reserveExtraction;

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
    public void setGuaranteeCompensationRatio(BigDecimal guaranteeCompensationRatio)
    {
        this.guaranteeCompensationRatio = guaranteeCompensationRatio;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public BigDecimal getGuaranteeCompensationRatio()
    {
        return guaranteeCompensationRatio;
    }
    public void setThreeAssetRatio(BigDecimal threeAssetRatio)
    {
        this.threeAssetRatio = threeAssetRatio;
    }

    public BigDecimal getThreeAssetRatio()
    {
        return threeAssetRatio;
    }
    public void setReserveExtraction(BigDecimal reserveExtraction)
    {
        this.reserveExtraction = reserveExtraction;
    }

    public BigDecimal getReserveExtraction()
    {
        return reserveExtraction;
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
            .append("guaranteeCompensationRatio", getGuaranteeCompensationRatio())
            .append("threeAssetRatio", getThreeAssetRatio())
            .append("reserveExtraction", getReserveExtraction())
            .append("infoDate", getInfoDate())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
