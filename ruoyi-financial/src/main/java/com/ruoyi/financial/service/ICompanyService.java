package com.ruoyi.financial.service;

import java.util.List;
import com.ruoyi.financial.domain.Company;

/**
 * 公司信息管理Service接口
 * 
 * @author xmx
 * @date 2023-06-09
 */
public interface ICompanyService 
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
     * 批量删除公司信息管理
     * 
     * @param ids 需要删除的公司信息管理主键集合
     * @return 结果
     */
    public int deleteCompanyByIds(Long[] ids);

    /**
     * 删除公司信息管理信息
     * 
     * @param id 公司信息管理主键
     * @return 结果
     */
    public int deleteCompanyById(Long id);
}
