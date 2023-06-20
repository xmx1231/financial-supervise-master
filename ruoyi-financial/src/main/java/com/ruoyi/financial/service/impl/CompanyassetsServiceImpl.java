package com.ruoyi.financial.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.financial.mapper.CompanyassetsMapper;
import com.ruoyi.financial.domain.Companyassets;
import com.ruoyi.financial.service.ICompanyassetsService;

/**
 * 企业资产状况Service业务层处理
 *
 * @author xmx
 * @date 2023-06-12
 */
@Service
public class CompanyassetsServiceImpl implements ICompanyassetsService
{
    @Autowired
    private CompanyassetsMapper companyassetsMapper;

    /**
     * 查询企业资产状况
     *
     * @param id 企业资产状况主键
     * @return 企业资产状况
     */
    @Override
    public Companyassets selectCompanyassetsById(Long id)
    {
        return companyassetsMapper.selectCompanyassetsById(id);
    }

    /**
     * 查询企业资产状况列表
     *
     * @param companyassets 企业资产状况
     * @return 企业资产状况
     */
    @Override
    @DataScope(deptAlias = "c")
    public List<Companyassets> selectCompanyassetsList(Companyassets companyassets)
    {
        return companyassetsMapper.selectCompanyassetsList(companyassets);
    }

    /**
     * 新增企业资产状况
     *
     * @param companyassets 企业资产状况
     * @return 结果
     */
    @Override
    public int insertCompanyassets(Companyassets companyassets)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long deptId = user.getDeptId();
        companyassets.setDeptId(deptId);
        companyassets.setCreateTime(DateUtils.getNowDate());
        return companyassetsMapper.insertCompanyassets(companyassets);
    }

    /**
     * 修改企业资产状况
     *
     * @param companyassets 企业资产状况
     * @return 结果
     */
    @Override
    public int updateCompanyassets(Companyassets companyassets)
    {
        companyassets.setUpdateTime(DateUtils.getNowDate());
        return companyassetsMapper.updateCompanyassets(companyassets);
    }

    /**
     * 批量删除企业资产状况
     *
     * @param ids 需要删除的企业资产状况主键
     * @return 结果
     */
    @Override
    public int deleteCompanyassetsByIds(Long[] ids)
    {
        return companyassetsMapper.deleteCompanyassetsByIds(ids);
    }

    /**
     * 删除企业资产状况信息
     *
     * @param id 企业资产状况主键
     * @return 结果
     */
    @Override
    public int deleteCompanyassetsById(Long id)
    {
        return companyassetsMapper.deleteCompanyassetsById(id);
    }
}
