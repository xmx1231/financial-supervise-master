package com.ruoyi.financial.mapper;

import java.util.List;
import com.ruoyi.financial.domain.Companyassets;

/**
 * 企业资产状况Mapper接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface CompanyassetsMapper 
{
    /**
     * 查询企业资产状况
     * 
     * @param id 企业资产状况主键
     * @return 企业资产状况
     */
    public Companyassets selectCompanyassetsById(Long id);

    /**
     * 查询企业资产状况列表
     * 
     * @param companyassets 企业资产状况
     * @return 企业资产状况集合
     */
    public List<Companyassets> selectCompanyassetsList(Companyassets companyassets);

    /**
     * 新增企业资产状况
     * 
     * @param companyassets 企业资产状况
     * @return 结果
     */
    public int insertCompanyassets(Companyassets companyassets);

    /**
     * 修改企业资产状况
     * 
     * @param companyassets 企业资产状况
     * @return 结果
     */
    public int updateCompanyassets(Companyassets companyassets);

    /**
     * 删除企业资产状况
     * 
     * @param id 企业资产状况主键
     * @return 结果
     */
    public int deleteCompanyassetsById(Long id);

    /**
     * 批量删除企业资产状况
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompanyassetsByIds(Long[] ids);
}
