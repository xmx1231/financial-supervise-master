package com.ruoyi.financial.mapper;

import java.util.List;
import com.ruoyi.financial.domain.FinancingGuaranteeInfo;

/**
 * 融资担保公司基本情况Mapper接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface FinancingGuaranteeInfoMapper 
{
    /**
     * 查询融资担保公司基本情况
     * 
     * @param id 融资担保公司基本情况主键
     * @return 融资担保公司基本情况
     */
    public FinancingGuaranteeInfo selectFinancingGuaranteeInfoById(Long id);

    /**
     * 查询融资担保公司基本情况列表
     * 
     * @param financingGuaranteeInfo 融资担保公司基本情况
     * @return 融资担保公司基本情况集合
     */
    public List<FinancingGuaranteeInfo> selectFinancingGuaranteeInfoList(FinancingGuaranteeInfo financingGuaranteeInfo);

    /**
     * 新增融资担保公司基本情况
     * 
     * @param financingGuaranteeInfo 融资担保公司基本情况
     * @return 结果
     */
    public int insertFinancingGuaranteeInfo(FinancingGuaranteeInfo financingGuaranteeInfo);

    /**
     * 修改融资担保公司基本情况
     * 
     * @param financingGuaranteeInfo 融资担保公司基本情况
     * @return 结果
     */
    public int updateFinancingGuaranteeInfo(FinancingGuaranteeInfo financingGuaranteeInfo);

    /**
     * 删除融资担保公司基本情况
     * 
     * @param id 融资担保公司基本情况主键
     * @return 结果
     */
    public int deleteFinancingGuaranteeInfoById(Long id);

    /**
     * 批量删除融资担保公司基本情况
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFinancingGuaranteeInfoByIds(Long[] ids);
}
