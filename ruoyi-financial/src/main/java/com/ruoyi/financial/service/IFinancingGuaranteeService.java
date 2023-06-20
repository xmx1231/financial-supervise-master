package com.ruoyi.financial.service;

import java.util.List;
import com.ruoyi.financial.domain.FinancingGuarantee;

/**
 * 融资担保公司经营情况Service接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface IFinancingGuaranteeService 
{
    /**
     * 查询融资担保公司经营情况
     * 
     * @param id 融资担保公司经营情况主键
     * @return 融资担保公司经营情况
     */
    public FinancingGuarantee selectFinancingGuaranteeById(Long id);

    /**
     * 查询融资担保公司经营情况列表
     * 
     * @param financingGuarantee 融资担保公司经营情况
     * @return 融资担保公司经营情况集合
     */
    public List<FinancingGuarantee> selectFinancingGuaranteeList(FinancingGuarantee financingGuarantee);

    /**
     * 新增融资担保公司经营情况
     * 
     * @param financingGuarantee 融资担保公司经营情况
     * @return 结果
     */
    public int insertFinancingGuarantee(FinancingGuarantee financingGuarantee);

    /**
     * 修改融资担保公司经营情况
     * 
     * @param financingGuarantee 融资担保公司经营情况
     * @return 结果
     */
    public int updateFinancingGuarantee(FinancingGuarantee financingGuarantee);

    /**
     * 批量删除融资担保公司经营情况
     * 
     * @param ids 需要删除的融资担保公司经营情况主键集合
     * @return 结果
     */
    public int deleteFinancingGuaranteeByIds(Long[] ids);

    /**
     * 删除融资担保公司经营情况信息
     * 
     * @param id 融资担保公司经营情况主键
     * @return 结果
     */
    public int deleteFinancingGuaranteeById(Long id);
}
