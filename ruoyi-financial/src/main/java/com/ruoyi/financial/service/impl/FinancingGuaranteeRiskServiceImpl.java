package com.ruoyi.financial.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.financial.mapper.FinancingGuaranteeRiskMapper;
import com.ruoyi.financial.domain.FinancingGuaranteeRisk;
import com.ruoyi.financial.service.IFinancingGuaranteeRiskService;

/**
 * 融资担保公司风险情况Service业务层处理
 *
 * @author xmx
 * @date 2023-06-12
 */
@Service
public class FinancingGuaranteeRiskServiceImpl implements IFinancingGuaranteeRiskService
{
    @Autowired
    private FinancingGuaranteeRiskMapper financingGuaranteeRiskMapper;

    /**
     * 查询融资担保公司风险情况
     *
     * @param id 融资担保公司风险情况主键
     * @return 融资担保公司风险情况
     */
    @Override
    public FinancingGuaranteeRisk selectFinancingGuaranteeRiskById(Long id)
    {
        return financingGuaranteeRiskMapper.selectFinancingGuaranteeRiskById(id);
    }

    /**
     * 查询融资担保公司风险情况列表
     *
     * @param financingGuaranteeRisk 融资担保公司风险情况
     * @return 融资担保公司风险情况
     */
    @Override
    @DataScope(deptAlias = "c")
    public List<FinancingGuaranteeRisk> selectFinancingGuaranteeRiskList(FinancingGuaranteeRisk financingGuaranteeRisk)
    {
        return financingGuaranteeRiskMapper.selectFinancingGuaranteeRiskList(financingGuaranteeRisk);
    }

    /**
     * 新增融资担保公司风险情况
     *
     * @param financingGuaranteeRisk 融资担保公司风险情况
     * @return 结果
     */
    @Override
    public int insertFinancingGuaranteeRisk(FinancingGuaranteeRisk financingGuaranteeRisk)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long deptId = user.getDeptId();
        financingGuaranteeRisk.setDeptId(deptId);
        financingGuaranteeRisk.setCreateTime(DateUtils.getNowDate());
        return financingGuaranteeRiskMapper.insertFinancingGuaranteeRisk(financingGuaranteeRisk);
    }

    /**
     * 修改融资担保公司风险情况
     *
     * @param financingGuaranteeRisk 融资担保公司风险情况
     * @return 结果
     */
    @Override
    public int updateFinancingGuaranteeRisk(FinancingGuaranteeRisk financingGuaranteeRisk)
    {
        financingGuaranteeRisk.setUpdateTime(DateUtils.getNowDate());
        return financingGuaranteeRiskMapper.updateFinancingGuaranteeRisk(financingGuaranteeRisk);
    }

    /**
     * 批量删除融资担保公司风险情况
     *
     * @param ids 需要删除的融资担保公司风险情况主键
     * @return 结果
     */
    @Override
    public int deleteFinancingGuaranteeRiskByIds(Long[] ids)
    {
        return financingGuaranteeRiskMapper.deleteFinancingGuaranteeRiskByIds(ids);
    }

    /**
     * 删除融资担保公司风险情况信息
     *
     * @param id 融资担保公司风险情况主键
     * @return 结果
     */
    @Override
    public int deleteFinancingGuaranteeRiskById(Long id)
    {
        return financingGuaranteeRiskMapper.deleteFinancingGuaranteeRiskById(id);
    }
}
