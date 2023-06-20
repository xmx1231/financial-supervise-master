package com.ruoyi.financial.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 小贷公司基本情况对象 microfinance_company_info
 *
 * @author xmx
 * @date 2023-06-12
 */
public class MicrofinanceCompanyInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 企业id */
    private Long deptId;

    /** 企业名称 */
    private String deptName;

    /** 经营资质 */
    @Excel(name = "经营资质")
    private String businessLicense;

    /** 存续情况 */
    @Excel(name = "存续情况")
    private String existenceStatus;

    /** 登记情况 */
    @Excel(name = "登记情况")
    private String registrationStatus;

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
    public void setBusinessLicense(String businessLicense)
    {
        this.businessLicense = businessLicense;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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
    public void setRegistrationStatus(String registrationStatus)
    {
        this.registrationStatus = registrationStatus;
    }

    public String getRegistrationStatus()
    {
        return registrationStatus;
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
            .append("businessLicense", getBusinessLicense())
            .append("existenceStatus", getExistenceStatus())
            .append("registrationStatus", getRegistrationStatus())
            .append("infoDate", getInfoDate())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
