package com.ruoyi.financial.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 小贷公司合规情况对象 microfinance_company_compliance
 *
 * @author xmx
 * @date 2023-06-12
 */
public class MicrofinanceCompanyCompliance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 企业id */
    private Long deptId;

    /** 企业名称 */
    private String deptName;

    /** 资金流水 */
    @Excel(name = "资金流水")
    private String fundFlows;

    /** 经营区域 */
    @Excel(name = "经营区域")
    private String operatingArea;

    /** 贷款利率 */
    @Excel(name = "贷款利率")
    private BigDecimal loanInterestRate;

    /** 贷款对象 */
    @Excel(name = "贷款对象")
    private String loanTarget;

    /** 贷款比例 */
    @Excel(name = "贷款比例")
    private BigDecimal loanRatio;

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
    public void setFundFlows(String fundFlows)
    {
        this.fundFlows = fundFlows;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getFundFlows()
    {
        return fundFlows;
    }
    public void setOperatingArea(String operatingArea)
    {
        this.operatingArea = operatingArea;
    }

    public String getOperatingArea()
    {
        return operatingArea;
    }
    public void setLoanInterestRate(BigDecimal loanInterestRate)
    {
        this.loanInterestRate = loanInterestRate;
    }

    public BigDecimal getLoanInterestRate()
    {
        return loanInterestRate;
    }
    public void setLoanTarget(String loanTarget)
    {
        this.loanTarget = loanTarget;
    }

    public String getLoanTarget()
    {
        return loanTarget;
    }
    public void setLoanRatio(BigDecimal loanRatio)
    {
        this.loanRatio = loanRatio;
    }

    public BigDecimal getLoanRatio()
    {
        return loanRatio;
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
            .append("fundFlows", getFundFlows())
            .append("operatingArea", getOperatingArea())
            .append("loanInterestRate", getLoanInterestRate())
            .append("loanTarget", getLoanTarget())
            .append("loanRatio", getLoanRatio())
            .append("infoDate", getInfoDate())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
