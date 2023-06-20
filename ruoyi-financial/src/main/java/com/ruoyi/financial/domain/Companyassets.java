package com.ruoyi.financial.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 企业资产状况对象 companyassets
 *
 * @author xmx
 * @date 2023-06-12
 */
public class Companyassets extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 企业id */
    private Long deptId;

    /** 企业名称 */
    private String deptName;

    /** 货币资金 */
    @Excel(name = "货币资金")
    private BigDecimal currencyFunds;

    /** 当年营业收入 */
    @Excel(name = "当年营业收入")
    private BigDecimal annualRevenue;

    /** 净利润资产总额 */
    @Excel(name = "净利润资产总额")
    private BigDecimal netProfit;

    /** 净资产应收代偿金额 */
    @Excel(name = "净资产应收代偿金额")
    private BigDecimal totalAssets;

    /** 三级资产情况 */
    @Excel(name = "三级资产情况")
    private BigDecimal netAssetCompensation;

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
    public void setCurrencyFunds(BigDecimal currencyFunds)
    {
        this.currencyFunds = currencyFunds;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public BigDecimal getCurrencyFunds()
    {
        return currencyFunds;
    }
    public void setAnnualRevenue(BigDecimal annualRevenue)
    {
        this.annualRevenue = annualRevenue;
    }

    public BigDecimal getAnnualRevenue()
    {
        return annualRevenue;
    }
    public void setNetProfit(BigDecimal netProfit)
    {
        this.netProfit = netProfit;
    }

    public BigDecimal getNetProfit()
    {
        return netProfit;
    }
    public void setTotalAssets(BigDecimal totalAssets)
    {
        this.totalAssets = totalAssets;
    }

    public BigDecimal getTotalAssets()
    {
        return totalAssets;
    }
    public void setNetAssetCompensation(BigDecimal netAssetCompensation)
    {
        this.netAssetCompensation = netAssetCompensation;
    }

    public BigDecimal getNetAssetCompensation()
    {
        return netAssetCompensation;
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
            .append("currencyFunds", getCurrencyFunds())
            .append("annualRevenue", getAnnualRevenue())
            .append("netProfit", getNetProfit())
            .append("totalAssets", getTotalAssets())
            .append("netAssetCompensation", getNetAssetCompensation())
            .append("infoDate", getInfoDate())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
