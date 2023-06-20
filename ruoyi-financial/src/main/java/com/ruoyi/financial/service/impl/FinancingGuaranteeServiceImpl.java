package com.ruoyi.financial.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.financial.mapper.FinancingGuaranteeMapper;
import com.ruoyi.financial.domain.FinancingGuarantee;
import com.ruoyi.financial.service.IFinancingGuaranteeService;

/**
 * 融资担保公司经营情况Service业务层处理
 *
 * @author xmx
 * @date 2023-06-12
 */
@Service
public class FinancingGuaranteeServiceImpl implements IFinancingGuaranteeService
{
    @Autowired
    private FinancingGuaranteeMapper financingGuaranteeMapper;

    /**
     * 查询融资担保公司经营情况
     *
     * @param id 融资担保公司经营情况主键
     * @return 融资担保公司经营情况
     */
    @Override
    public FinancingGuarantee selectFinancingGuaranteeById(Long id)
    {
        return financingGuaranteeMapper.selectFinancingGuaranteeById(id);
    }

    /**
     * 查询融资担保公司经营情况列表
     *
     * @param financingGuarantee 融资担保公司经营情况
     * @return 融资担保公司经营情况
     */
    @Override
    @DataScope(deptAlias = "c")
    public List<FinancingGuarantee> selectFinancingGuaranteeList(FinancingGuarantee financingGuarantee)
    {
        return financingGuaranteeMapper.selectFinancingGuaranteeList(financingGuarantee);
    }

    /**
     * 新增融资担保公司经营情况
     *
     * @param financingGuarantee 融资担保公司经营情况
     * @return 结果
     */
    @Override
    public int insertFinancingGuarantee(FinancingGuarantee financingGuarantee)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long deptId = user.getDeptId();
        financingGuarantee.setDeptId(deptId);
        financingGuarantee.setCreateTime(DateUtils.getNowDate());
        return financingGuaranteeMapper.insertFinancingGuarantee(financingGuarantee);
    }

    /**
     * 修改融资担保公司经营情况
     *
     * @param financingGuarantee 融资担保公司经营情况
     * @return 结果
     */
    @Override
    public int updateFinancingGuarantee(FinancingGuarantee financingGuarantee)
    {
        financingGuarantee.setUpdateTime(DateUtils.getNowDate());
        return financingGuaranteeMapper.updateFinancingGuarantee(financingGuarantee);
    }

    /**
     * 批量删除融资担保公司经营情况
     *
     * @param ids 需要删除的融资担保公司经营情况主键
     * @return 结果
     */
    @Override
    public int deleteFinancingGuaranteeByIds(Long[] ids)
    {
        return financingGuaranteeMapper.deleteFinancingGuaranteeByIds(ids);
    }

    /**
     * 删除融资担保公司经营情况信息
     *
     * @param id 融资担保公司经营情况主键
     * @return 结果
     */
    @Override
    public int deleteFinancingGuaranteeById(Long id)
    {
        return financingGuaranteeMapper.deleteFinancingGuaranteeById(id);
    }
}
