package com.ruoyi.financial.mapper;

import java.util.List;
import com.ruoyi.financial.domain.MicrofinanceCompanyCompliance;

/**
 * 小贷公司合规情况Mapper接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface MicrofinanceCompanyComplianceMapper 
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
     * 删除小贷公司合规情况
     * 
     * @param id 小贷公司合规情况主键
     * @return 结果
     */
    public int deleteMicrofinanceCompanyComplianceById(Long id);

    /**
     * 批量删除小贷公司合规情况
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMicrofinanceCompanyComplianceByIds(Long[] ids);
}
