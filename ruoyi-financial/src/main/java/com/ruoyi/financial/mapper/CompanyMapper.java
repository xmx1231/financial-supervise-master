package com.ruoyi.financial.mapper;

import java.util.List;
import com.ruoyi.financial.domain.Company;
import com.ruoyi.financial.domain.PersonnelInfo;

/**
 * 公司信息管理Mapper接口
 * 
 * @author xmx
 * @date 2023-06-09
 */
public interface CompanyMapper 
{
    /**
     * 查询公司信息管理
     * 
     * @param id 公司信息管理主键
     * @return 公司信息管理
     */
    public Company selectCompanyById(Long id);

    /**
     * 查询公司信息管理列表
     * 
     * @param company 公司信息管理
     * @return 公司信息管理集合
     */
    public List<Company> selectCompanyList(Company company);

    /**
     * 新增公司信息管理
     * 
     * @param company 公司信息管理
     * @return 结果
     */
    public int insertCompany(Company company);

    /**
     * 修改公司信息管理
     * 
     * @param company 公司信息管理
     * @return 结果
     */
    public int updateCompany(Company company);

    /**
     * 删除公司信息管理
     * 
     * @param id 公司信息管理主键
     * @return 结果
     */
    public int deleteCompanyById(Long id);

    /**
     * 批量删除公司信息管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompanyByIds(Long[] ids);

    /**
     * 批量删除人员信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePersonnelInfoByCompanyIds(Long[] ids);
    
    /**
     * 批量新增人员信息
     * 
     * @param personnelInfoList 人员信息列表
     * @return 结果
     */
    public int batchPersonnelInfo(List<PersonnelInfo> personnelInfoList);
    

    /**
     * 通过公司信息管理主键删除人员信息信息
     * 
     * @param id 公司信息管理ID
     * @return 结果
     */
    public int deletePersonnelInfoByCompanyId(Long id);
}
