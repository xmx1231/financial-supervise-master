package com.ruoyi.financial.mapper;

import java.util.List;
import com.ruoyi.financial.domain.FinancingGuaranteeRisk;

/**
 * 融资担保公司风险情况Mapper接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface FinancingGuaranteeRiskMapper 
{
    /**
     * 查询融资担保公司风险情况
     * 
     * @param id 融资担保公司风险情况主键
     * @return 融资担保公司风险情况
     */
    public FinancingGuaranteeRisk selectFinancingGuaranteeRiskById(Long id);

    /**
     * 查询融资担保公司风险情况列表
     * 
     * @param financingGuaranteeRisk 融资担保公司风险情况
     * @return 融资担保公司风险情况集合
     */
    public List<FinancingGuaranteeRisk> selectFinancingGuaranteeRiskList(FinancingGuaranteeRisk financingGuaranteeRisk);

    /**
     * 新增融资担保公司风险情况
     * 
     * @param financingGuaranteeRisk 融资担保公司风险情况
     * @return 结果
     */
    public int insertFinancingGuaranteeRisk(FinancingGuaranteeRisk financingGuaranteeRisk);

    /**
     * 修改融资担保公司风险情况
     * 
     * @param financingGuaranteeRisk 融资担保公司风险情况
     * @return 结果
     */
    public int updateFinancingGuaranteeRisk(FinancingGuaranteeRisk financingGuaranteeRisk);

    /**
     * 删除融资担保公司风险情况
     * 
     * @param id 融资担保公司风险情况主键
     * @return 结果
     */
    public int deleteFinancingGuaranteeRiskById(Long id);

    /**
     * 批量删除融资担保公司风险情况
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFinancingGuaranteeRiskByIds(Long[] ids);
}
