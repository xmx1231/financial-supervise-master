package com.ruoyi.financial.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.financial.mapper.FinancingGuaranteeInfoMapper;
import com.ruoyi.financial.domain.FinancingGuaranteeInfo;
import com.ruoyi.financial.service.IFinancingGuaranteeInfoService;

/**
 * 融资担保公司基本情况Service业务层处理
 *
 * @author xmx
 * @date 2023-06-12
 */
@Service
public class FinancingGuaranteeInfoServiceImpl implements IFinancingGuaranteeInfoService
{
    @Autowired
    private FinancingGuaranteeInfoMapper financingGuaranteeInfoMapper;

    /**
     * 查询融资担保公司基本情况
     *
     * @param id 融资担保公司基本情况主键
     * @return 融资担保公司基本情况
     */
    @Override
    public FinancingGuaranteeInfo selectFinancingGuaranteeInfoById(Long id)
    {
        return financingGuaranteeInfoMapper.selectFinancingGuaranteeInfoById(id);
    }

    /**
     * 查询融资担保公司基本情况列表
     *
     * @param financingGuaranteeInfo 融资担保公司基本情况
     * @return 融资担保公司基本情况
     */
    @Override
    @DataScope(deptAlias = "c")
    public List<FinancingGuaranteeInfo> selectFinancingGuaranteeInfoList(FinancingGuaranteeInfo financingGuaranteeInfo)
    {
        return financingGuaranteeInfoMapper.selectFinancingGuaranteeInfoList(financingGuaranteeInfo);
    }

    /**
     * 新增融资担保公司基本情况
     *
     * @param financingGuaranteeInfo 融资担保公司基本情况
     * @return 结果
     */
    @Override
    public int insertFinancingGuaranteeInfo(FinancingGuaranteeInfo financingGuaranteeInfo)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long deptId = user.getDeptId();
        financingGuaranteeInfo.setDeptId(deptId);
        financingGuaranteeInfo.setCreateTime(DateUtils.getNowDate());
        return financingGuaranteeInfoMapper.insertFinancingGuaranteeInfo(financingGuaranteeInfo);
    }

    /**
     * 修改融资担保公司基本情况
     *
     * @param financingGuaranteeInfo 融资担保公司基本情况
     * @return 结果
     */
    @Override
    public int updateFinancingGuaranteeInfo(FinancingGuaranteeInfo financingGuaranteeInfo)
    {
        financingGuaranteeInfo.setUpdateTime(DateUtils.getNowDate());
        return financingGuaranteeInfoMapper.updateFinancingGuaranteeInfo(financingGuaranteeInfo);
    }

    /**
     * 批量删除融资担保公司基本情况
     *
     * @param ids 需要删除的融资担保公司基本情况主键
     * @return 结果
     */
    @Override
    public int deleteFinancingGuaranteeInfoByIds(Long[] ids)
    {
        return financingGuaranteeInfoMapper.deleteFinancingGuaranteeInfoByIds(ids);
    }

    /**
     * 删除融资担保公司基本情况信息
     *
     * @param id 融资担保公司基本情况主键
     * @return 结果
     */
    @Override
    public int deleteFinancingGuaranteeInfoById(Long id)
    {
        return financingGuaranteeInfoMapper.deleteFinancingGuaranteeInfoById(id);
    }
}
