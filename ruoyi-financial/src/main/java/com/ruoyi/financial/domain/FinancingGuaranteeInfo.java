package com.ruoyi.financial.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 融资担保公司基本情况对象 financing_guarantee_info
 *
 * @author xmx
 * @date 2023-06-12
 */
public class FinancingGuaranteeInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 企业id */
    private Long deptId;

    /** 企业名称 */
    private String deptName;

    /** 公司地址 */
    @Excel(name = "公司地址")
    private String companyAddress;

    /** 经营资质 */
    @Excel(name = "经营资质")
    private String businessLicense;

    /** 存续情况 */
    @Excel(name = "存续情况")
    private String existenceStatus;

    /** 人员资质 */
    @Excel(name = "人员资质")
    private String personnelQualification;

    /** 主营业务 */
    @Excel(name = "主营业务")
    private String mainBusiness;

    /** 在保余额 */
    @Excel(name = "在保余额")
    private BigDecimal outstandingBalance;

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
    public void setCompanyAddress(String companyAddress)
    {
        this.companyAddress = companyAddress;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getCompanyAddress()
    {
        return companyAddress;
    }
    public void setBusinessLicense(String businessLicense)
    {
        this.businessLicense = businessLicense;
    }

    public String getBusinessLicense()
    {
        return businessLicense;
    }
    public void setExistenceStatus(String existenceStatus)
    {
        this.existenceStatus = existenceStatus;
    }

    public String getExistenceStatus()
    {
        return existenceStatus;
    }
    public void setPersonnelQualification(String personnelQualification)
    {
        this.personnelQualification = personnelQualification;
    }

    public String getPersonnelQualification()
    {
        return personnelQualification;
    }
    public void setMainBusiness(String mainBusiness)
    {
        this.mainBusiness = mainBusiness;
    }

    public String getMainBusiness()
    {
        return mainBusiness;
    }
    public void setOutstandingBalance(BigDecimal outstandingBalance)
    {
        this.outstandingBalance = outstandingBalance;
    }

    public BigDecimal getOutstandingBalance()
    {
        return outstandingBalance;
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
            .append("companyAddress", getCompanyAddress())
            .append("businessLicense", getBusinessLicense())
            .append("existenceStatus", getExistenceStatus())
            .append("personnelQualification", getPersonnelQualification())
            .append("mainBusiness", getMainBusiness())
            .append("outstandingBalance", getOutstandingBalance())
            .append("infoDate", getInfoDate())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
