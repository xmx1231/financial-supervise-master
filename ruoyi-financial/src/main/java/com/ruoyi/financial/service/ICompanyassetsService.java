package com.ruoyi.financial.service;

import java.util.List;
import com.ruoyi.financial.domain.Companyassets;

/**
 * 企业资产状况Service接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface ICompanyassetsService 
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
     * 批量删除企业资产状况
     * 
     * @param ids 需要删除的企业资产状况主键集合
     * @return 结果
     */
    public int deleteCompanyassetsByIds(Long[] ids);

    /**
     * 删除企业资产状况信息
     * 
     * @param id 企业资产状况主键
     * @return 结果
     */
    public int deleteCompanyassetsById(Long id);
}
