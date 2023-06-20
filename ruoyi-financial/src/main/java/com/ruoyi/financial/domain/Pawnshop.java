package com.ruoyi.financial.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 典当行经营情况对象 pawnshop
 *
 * @author xmx
 * @date 2023-06-12
 */
public class Pawnshop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 企业id */
    private Long deptId;

    /** 企业名称 */
    private String deptName;

    /** 当年新增放款 */
    @Excel(name = "当年新增放款")
    private BigDecimal newLoanAmount;

    /** 当息 */
    @Excel(name = "当息")
    private BigDecimal interest;

    /** 综合费率 */
    @Excel(name = "综合费率")
    private BigDecimal comprehensiveFeeRate;

    /** 年末投放余额 */
    @Excel(name = "年末投放余额")
    private BigDecimal yearEndOutstandingBalance;

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
    public void setNewLoanAmount(BigDecimal newLoanAmount)
    {
        this.newLoanAmount = newLoanAmount;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public BigDecimal getNewLoanAmount()
    {
        return newLoanAmount;
    }
    public void setInterest(BigDecimal interest)
    {
        this.interest = interest;
    }

    public BigDecimal getInterest()
    {
        return interest;
    }
    public void setComprehensiveFeeRate(BigDecimal comprehensiveFeeRate)
    {
        this.comprehensiveFeeRate = comprehensiveFeeRate;
    }

    public BigDecimal getComprehensiveFeeRate()
    {
        return comprehensiveFeeRate;
    }
    public void setYearEndOutstandingBalance(BigDecimal yearEndOutstandingBalance)
    {
        this.yearEndOutstandingBalance = yearEndOutstandingBalance;
    }

    public BigDecimal getYearEndOutstandingBalance()
    {
        return yearEndOutstandingBalance;
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
            .append("newLoanAmount", getNewLoanAmount())
            .append("interest", getInterest())
            .append("comprehensiveFeeRate", getComprehensiveFeeRate())
            .append("yearEndOutstandingBalance", getYearEndOutstandingBalance())
            .append("infoDate", getInfoDate())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
