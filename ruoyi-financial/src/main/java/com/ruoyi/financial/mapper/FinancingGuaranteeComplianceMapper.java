package com.ruoyi.financial.mapper;

import java.util.List;
import com.ruoyi.financial.domain.FinancingGuaranteeCompliance;

/**
 * 融资担保公司合规情况Mapper接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface FinancingGuaranteeComplianceMapper 
{
    /**
     * 查询融资担保公司合规情况
     * 
     * @param id 融资担保公司合规情况主键
     * @return 融资担保公司合规情况
     */
    public FinancingGuaranteeCompliance selectFinancingGuaranteeComplianceById(Long id);

    /**
     * 查询融资担保公司合规情况列表
     * 
     * @param financingGuaranteeCompliance 融资担保公司合规情况
     * @return 融资担保公司合规情况集合
     */
    public List<FinancingGuaranteeCompliance> selectFinancingGuaranteeComplianceList(FinancingGuaranteeCompliance financingGuaranteeCompliance);

    /**
     * 新增融资担保公司合规情况
     * 
     * @param financingGuaranteeCompliance 融资担保公司合规情况
     * @return 结果
     */
    public int insertFinancingGuaranteeCompliance(FinancingGuaranteeCompliance financingGuaranteeCompliance);

    /**
     * 修改融资担保公司合规情况
     * 
     * @param financingGuaranteeCompliance 融资担保公司合规情况
     * @return 结果
     */
    public int updateFinancingGuaranteeCompliance(FinancingGuaranteeCompliance financingGuaranteeCompliance);

    /**
     * 删除融资担保公司合规情况
     * 
     * @param id 融资担保公司合规情况主键
     * @return 结果
     */
    public int deleteFinancingGuaranteeComplianceById(Long id);

    /**
     * 批量删除融资担保公司合规情况
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFinancingGuaranteeComplianceByIds(Long[] ids);
}
