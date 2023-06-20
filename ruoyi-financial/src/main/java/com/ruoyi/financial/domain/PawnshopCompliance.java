package com.ruoyi.financial.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 典当行合规情况对象 pawnshop_compliance
 *
 * @author xmx
 * @date 2023-06-12
 */
public class PawnshopCompliance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 企业id */
    private Long deptId;

    /** 企业名称 */
    private String deptName;

    /** 当票使用 */
    @Excel(name = "当票使用")
    private String pawnTicketUsage;

    /** 息费收取 */
    @Excel(name = "息费收取")
    private String interestFeeCollection;

    /** 绝当物处置 */
    @Excel(name = "绝当物处置")
    private String forfeitedAssetDisposal;

    /** 股东资金往来 */
    @Excel(name = "股东资金往来")
    private String shareholderFundTransaction;

    /** 出资情况 */
    @Excel(name = "出资情况")
    private String capitalContribution;

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
    public void setPawnTicketUsage(String pawnTicketUsage)
    {
        this.pawnTicketUsage = pawnTicketUsage;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getPawnTicketUsage()
    {
        return pawnTicketUsage;
    }
    public void setInterestFeeCollection(String interestFeeCollection)
    {
        this.interestFeeCollection = interestFeeCollection;
    }

    public String getInterestFeeCollection()
    {
        return interestFeeCollection;
    }
    public void setForfeitedAssetDisposal(String forfeitedAssetDisposal)
    {
        this.forfeitedAssetDisposal = forfeitedAssetDisposal;
    }

    public String getForfeitedAssetDisposal()
    {
        return forfeitedAssetDisposal;
    }
    public void setShareholderFundTransaction(String shareholderFundTransaction)
    {
        this.shareholderFundTransaction = shareholderFundTransaction;
    }

    public String getShareholderFundTransaction()
    {
        return shareholderFundTransaction;
    }
    public void setCapitalContribution(String capitalContribution)
    {
        this.capitalContribution = capitalContribution;
    }

    public String getCapitalContribution()
    {
        return capitalContribution;
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
            .append("pawnTicketUsage", getPawnTicketUsage())
            .append("interestFeeCollection", getInterestFeeCollection())
            .append("forfeitedAssetDisposal", getForfeitedAssetDisposal())
            .append("shareholderFundTransaction", getShareholderFundTransaction())
            .append("capitalContribution", getCapitalContribution())
            .append("infoDate", getInfoDate())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
