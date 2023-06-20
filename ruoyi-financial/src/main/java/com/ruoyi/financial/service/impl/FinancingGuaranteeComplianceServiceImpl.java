package com.ruoyi.financial.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.financial.mapper.FinancingGuaranteeComplianceMapper;
import com.ruoyi.financial.domain.FinancingGuaranteeCompliance;
import com.ruoyi.financial.service.IFinancingGuaranteeComplianceService;

/**
 * 融资担保公司合规情况Service业务层处理
 *
 * @author xmx
 * @date 2023-06-12
 */
@Service
public class FinancingGuaranteeComplianceServiceImpl implements IFinancingGuaranteeComplianceService
{
    @Autowired
    private FinancingGuaranteeComplianceMapper financingGuaranteeComplianceMapper;

    /**
     * 查询融资担保公司合规情况
     *
     * @param id 融资担保公司合规情况主键
     * @return 融资担保公司合规情况
     */
    @Override
    public FinancingGuaranteeCompliance selectFinancingGuaranteeComplianceById(Long id)
    {
        return financingGuaranteeComplianceMapper.selectFinancingGuaranteeComplianceById(id);
    }

    /**
     * 查询融资担保公司合规情况列表
     *
     * @param financingGuaranteeCompliance 融资担保公司合规情况
     * @return 融资担保公司合规情况
     */
    @Override
    @DataScope(deptAlias = "c")
    public List<FinancingGuaranteeCompliance> selectFinancingGuaranteeComplianceList(FinancingGuaranteeCompliance financingGuaranteeCompliance)
    {
        return financingGuaranteeComplianceMapper.selectFinancingGuaranteeComplianceList(financingGuaranteeCompliance);
    }

    /**
     * 新增融资担保公司合规情况
     *
     * @param financingGuaranteeCompliance 融资担保公司合规情况
     * @return 结果
     */
    @Override
    public int insertFinancingGuaranteeCompliance(FinancingGuaranteeCompliance financingGuaranteeCompliance)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long deptId = user.getDeptId();
        financingGuaranteeCompliance.setDeptId(deptId);
        financingGuaranteeCompliance.setCreateTime(DateUtils.getNowDate());
        return financingGuaranteeComplianceMapper.insertFinancingGuaranteeCompliance(financingGuaranteeCompliance);
    }

    /**
     * 修改融资担保公司合规情况
     *
     * @param financingGuaranteeCompliance 融资担保公司合规情况
     * @return 结果
     */
    @Override
    public int updateFinancingGuaranteeCompliance(FinancingGuaranteeCompliance financingGuaranteeCompliance)
    {
        financingGuaranteeCompliance.setUpdateTime(DateUtils.getNowDate());
        return financingGuaranteeComplianceMapper.updateFinancingGuaranteeCompliance(financingGuaranteeCompliance);
    }

    /**
     * 批量删除融资担保公司合规情况
     *
     * @param ids 需要删除的融资担保公司合规情况主键
     * @return 结果
     */
    @Override
    public int deleteFinancingGuaranteeComplianceByIds(Long[] ids)
    {
        return financingGuaranteeComplianceMapper.deleteFinancingGuaranteeComplianceByIds(ids);
    }

    /**
     * 删除融资担保公司合规情况信息
     *
     * @param id 融资担保公司合规情况主键
     * @return 结果
     */
    @Override
    public int deleteFinancingGuaranteeComplianceById(Long id)
    {
        return financingGuaranteeComplianceMapper.deleteFinancingGuaranteeComplianceById(id);
    }
}
