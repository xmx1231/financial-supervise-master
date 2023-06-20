package com.ruoyi.financial.service;

import java.util.List;
import com.ruoyi.financial.domain.FactoringCompany;

/**
 * 商业保理公司经营情况Service接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface IFactoringCompanyService 
{
    /**
     * 查询商业保理公司经营情况
     * 
     * @param id 商业保理公司经营情况主键
     * @return 商业保理公司经营情况
     */
    public FactoringCompany selectFactoringCompanyById(Long id);

    /**
     * 查询商业保理公司经营情况列表
     * 
     * @param factoringCompany 商业保理公司经营情况
     * @return 商业保理公司经营情况集合
     */
    public List<FactoringCompany> selectFactoringCompanyList(FactoringCompany factoringCompany);

    /**
     * 新增商业保理公司经营情况
     * 
     * @param factoringCompany 商业保理公司经营情况
     * @return 结果
     */
    public int insertFactoringCompany(FactoringCompany factoringCompany);

    /**
     * 修改商业保理公司经营情况
     * 
     * @param factoringCompany 商业保理公司经营情况
     * @return 结果
     */
    public int updateFactoringCompany(FactoringCompany factoringCompany);

    /**
     * 批量删除商业保理公司经营情况
     * 
     * @param ids 需要删除的商业保理公司经营情况主键集合
     * @return 结果
     */
    public int deleteFactoringCompanyByIds(Long[] ids);

    /**
     * 删除商业保理公司经营情况信息
     * 
     * @param id 商业保理公司经营情况主键
     * @return 结果
     */
    public int deleteFactoringCompanyById(Long id);
}
