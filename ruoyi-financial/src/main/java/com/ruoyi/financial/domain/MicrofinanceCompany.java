package com.ruoyi.financial.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 小贷公司经营情况对象 microfinance_company
 *
 * @author xmx
 * @date 2023-06-12
 */
public class MicrofinanceCompany extends BaseEntity
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

    /** 利率 */
    @Excel(name = "利率")
    private BigDecimal interestRate;

    /** 年末放贷余额 */
    @Excel(name = "年末放贷余额")
    private BigDecimal yearEndLoanBalance;

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
    public void setInterestRate(BigDecimal interestRate)
    {
        this.interestRate = interestRate;
    }

    public BigDecimal getInterestRate()
    {
        return interestRate;
    }
    public void setYearEndLoanBalance(BigDecimal yearEndLoanBalance)
    {
        this.yearEndLoanBalance = yearEndLoanBalance;
    }

    public BigDecimal getYearEndLoanBalance()
    {
        return yearEndLoanBalance;
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
            .append("interestRate", getInterestRate())
            .append("yearEndLoanBalance", getYearEndLoanBalance())
            .append("infoDate", getInfoDate())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
