package com.ruoyi.financial.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.financial.domain.PersonnelInfo;
import com.ruoyi.financial.mapper.CompanyMapper;
import com.ruoyi.financial.domain.Company;
import com.ruoyi.financial.service.ICompanyService;

/**
 * 公司信息管理Service业务层处理
 *
 * @author xmx
 * @date 2023-06-09
 */
@Service
public class CompanyServiceImpl implements ICompanyService
{
    @Autowired
    private CompanyMapper companyMapper;

    /**
     * 查询公司信息管理
     *
     * @param id 公司信息管理主键
     * @return 公司信息管理
     */
    @Override
    public Company selectCompanyById(Long id)
    {
        return companyMapper.selectCompanyById(id);
    }

    /**
     * 查询公司信息管理列表
     *
     * @param company 公司信息管理
     * @return 公司信息管理
     */
    @Override
    @DataScope(deptAlias = "c")
    public List<Company> selectCompanyList(Company company)
    {
        return companyMapper.selectCompanyList(company);
    }

    /**
     * 新增公司信息管理
     *
     * @param company 公司信息管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertCompany(Company company)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long deptId = user.getDeptId();
        company.setDeptId(deptId);
        company.setCreateTime(DateUtils.getNowDate());
        int rows = companyMapper.insertCompany(company);
        insertPersonnelInfo(company);
        return rows;
    }

    /**
     * 修改公司信息管理
     *
     * @param company 公司信息管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateCompany(Company company)
    {
        company.setUpdateTime(DateUtils.getNowDate());
        companyMapper.deletePersonnelInfoByCompanyId(company.getId());
        insertPersonnelInfo(company);
        return companyMapper.updateCompany(company);
    }

    /**
     * 批量删除公司信息管理
     *
     * @param ids 需要删除的公司信息管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteCompanyByIds(Long[] ids)
    {
        companyMapper.deletePersonnelInfoByCompanyIds(ids);
        return companyMapper.deleteCompanyByIds(ids);
    }

    /**
     * 删除公司信息管理信息
     *
     * @param id 公司信息管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteCompanyById(Long id)
    {
        companyMapper.deletePersonnelInfoByCompanyId(id);
        return companyMapper.deleteCompanyById(id);
    }

    /**
     * 新增人员信息信息
     *
     * @param company 公司信息管理对象
     */
    public void insertPersonnelInfo(Company company)
    {
        List<PersonnelInfo> personnelInfoList = company.getPersonnelInfoList();
        Long id = company.getId();
        if (StringUtils.isNotNull(personnelInfoList))
        {
            List<PersonnelInfo> list = new ArrayList<PersonnelInfo>();
            for (PersonnelInfo personnelInfo : personnelInfoList)
            {
                personnelInfo.setCompanyId(id);
                list.add(personnelInfo);
            }
            if (list.size() > 0)
            {
                companyMapper.batchPersonnelInfo(list);
            }
        }
    }
}
