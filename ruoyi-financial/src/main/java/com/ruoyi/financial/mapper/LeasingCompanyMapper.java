package com.ruoyi.financial.mapper;

import java.util.List;
import com.ruoyi.financial.domain.LeasingCompany;

/**
 * 融资租赁经营情况Mapper接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface LeasingCompanyMapper 
{
    /**
     * 查询融资租赁经营情况
     * 
     * @param id 融资租赁经营情况主键
     * @return 融资租赁经营情况
     */
    public LeasingCompany selectLeasingCompanyById(Long id);

    /**
     * 查询融资租赁经营情况列表
     * 
     * @param leasingCompany 融资租赁经营情况
     * @return 融资租赁经营情况集合
     */
    public List<LeasingCompany> selectLeasingCompanyList(LeasingCompany leasingCompany);

    /**
     * 新增融资租赁经营情况
     * 
     * @param leasingCompany 融资租赁经营情况
     * @return 结果
     */
    public int insertLeasingCompany(LeasingCompany leasingCompany);

    /**
     * 修改融资租赁经营情况
     * 
     * @param leasingCompany 融资租赁经营情况
     * @return 结果
     */
    public int updateLeasingCompany(LeasingCompany leasingCompany);

    /**
     * 删除融资租赁经营情况
     * 
     * @param id 融资租赁经营情况主键
     * @return 结果
     */
    public int deleteLeasingCompanyById(Long id);

    /**
     * 批量删除融资租赁经营情况
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLeasingCompanyByIds(Long[] ids);
}
