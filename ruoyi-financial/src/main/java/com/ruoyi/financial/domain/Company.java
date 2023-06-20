package com.ruoyi.financial.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公司信息管理对象 company
 * 
 * @author xmx
 * @date 2023-06-09
 */
public class Company extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 经营范围 */
    @Excel(name = "经营范围")
    private String businessScope;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 审核状态（0代表未审核 2代表已审核） */
    @Excel(name = "审核状态", readConverterExp = "0=代表未审核,2=代表已审核")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 部门id */
    private Long deptId;

    /** 人员信息信息 */
    private List<PersonnelInfo> personnelInfoList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setBusinessScope(String businessScope) 
    {
        this.businessScope = businessScope;
    }

    public String getBusinessScope() 
    {
        return businessScope;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    public List<PersonnelInfo> getPersonnelInfoList()
    {
        return personnelInfoList;
    }

    public void setPersonnelInfoList(List<PersonnelInfo> personnelInfoList)
    {
        this.personnelInfoList = personnelInfoList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("businessScope", getBusinessScope())
            .append("address", getAddress())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("deptId", getDeptId())
            .append("personnelInfoList", getPersonnelInfoList())
            .toString();
    }
}
