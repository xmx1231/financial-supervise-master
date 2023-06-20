package com.ruoyi.financial.service;

import java.util.List;
import com.ruoyi.financial.domain.MicrofinanceCompanyRisk;

/**
 * 小贷公司风险情况Service接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface IMicrofinanceCompanyRiskService 
{
    /**
     * 查询小贷公司风险情况
     * 
     * @param id 小贷公司风险情况主键
     * @return 小贷公司风险情况
     */
    public MicrofinanceCompanyRisk selectMicrofinanceCompanyRiskById(Long id);

    /**
     * 查询小贷公司风险情况列表
     * 
     * @param microfinanceCompanyRisk 小贷公司风险情况
     * @return 小贷公司风险情况集合
     */
    public List<MicrofinanceCompanyRisk> selectMicrofinanceCompanyRiskList(MicrofinanceCompanyRisk microfinanceCompanyRisk);

    /**
     * 新增小贷公司风险情况
     * 
     * @param microfinanceCompanyRisk 小贷公司风险情况
     * @return 结果
     */
    public int insertMicrofinanceCompanyRisk(MicrofinanceCompanyRisk microfinanceCompanyRisk);

    /**
     * 修改小贷公司风险情况
     * 
     * @param microfinanceCompanyRisk 小贷公司风险情况
     * @return 结果
     */
    public int updateMicrofinanceCompanyRisk(MicrofinanceCompanyRisk microfinanceCompanyRisk);

    /**
     * 批量删除小贷公司风险情况
     * 
     * @param ids 需要删除的小贷公司风险情况主键集合
     * @return 结果
     */
    public int deleteMicrofinanceCompanyRiskByIds(Long[] ids);

    /**
     * 删除小贷公司风险情况信息
     * 
     * @param id 小贷公司风险情况主键
     * @return 结果
     */
    public int deleteMicrofinanceCompanyRiskById(Long id);
}
