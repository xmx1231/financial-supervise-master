package com.ruoyi.financial.service;

import java.util.List;
import com.ruoyi.financial.domain.MicrofinanceCompanyCompliance;

/**
 * 小贷公司合规情况Service接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface IMicrofinanceCompanyComplianceService 
{
    /**
     * 查询小贷公司合规情况
     * 
     * @param id 小贷公司合规情况主键
     * @return 小贷公司合规情况
     */
    public MicrofinanceCompanyCompliance selectMicrofinanceCompanyComplianceById(Long id);

    /**
     * 查询小贷公司合规情况列表
     * 
     * @param microfinanceCompanyCompliance 小贷公司合规情况
     * @return 小贷公司合规情况集合
     */
    public List<MicrofinanceCompanyCompliance> selectMicrofinanceCompanyComplianceList(MicrofinanceCompanyCompliance microfinanceCompanyCompliance);

    /**
     * 新增小贷公司合规情况
     * 
     * @param microfinanceCompanyCompliance 小贷公司合规情况
     * @return 结果
     */
    public int insertMicrofinanceCompanyCompliance(MicrofinanceCompanyCompliance microfinanceCompanyCompliance);

    /**
     * 修改小贷公司合规情况
     * 
     * @param microfinanceCompanyCompliance 小贷公司合规情况
     * @return 结果
     */
    public int updateMicrofinanceCompanyCompliance(MicrofinanceCompanyCompliance microfinanceCompanyCompliance);

    /**
     * 批量删除小贷公司合规情况
     * 
     * @param ids 需要删除的小贷公司合规情况主键集合
     * @return 结果
     */
    public int deleteMicrofinanceCompanyComplianceByIds(Long[] ids);

    /**
     * 删除小贷公司合规情况信息
     * 
     * @param id 小贷公司合规情况主键
     * @return 结果
     */
    public int deleteMicrofinanceCompanyComplianceById(Long id);
}
