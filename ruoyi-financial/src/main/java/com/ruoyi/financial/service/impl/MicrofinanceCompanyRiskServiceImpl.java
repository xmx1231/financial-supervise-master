package com.ruoyi.financial.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.financial.mapper.MicrofinanceCompanyRiskMapper;
import com.ruoyi.financial.domain.MicrofinanceCompanyRisk;
import com.ruoyi.financial.service.IMicrofinanceCompanyRiskService;

/**
 * 小贷公司风险情况Service业务层处理
 *
 * @author xmx
 * @date 2023-06-12
 */
@Service
public class MicrofinanceCompanyRiskServiceImpl implements IMicrofinanceCompanyRiskService
{
    @Autowired
    private MicrofinanceCompanyRiskMapper microfinanceCompanyRiskMapper;

    /**
     * 查询小贷公司风险情况
     *
     * @param id 小贷公司风险情况主键
     * @return 小贷公司风险情况
     */
    @Override
    public MicrofinanceCompanyRisk selectMicrofinanceCompanyRiskById(Long id)
    {
        return microfinanceCompanyRiskMapper.selectMicrofinanceCompanyRiskById(id);
    }

    /**
     * 查询小贷公司风险情况列表
     *
     * @param microfinanceCompanyRisk 小贷公司风险情况
     * @return 小贷公司风险情况
     */
    @Override
    @DataScope(deptAlias = "c")
    public List<MicrofinanceCompanyRisk> selectMicrofinanceCompanyRiskList(MicrofinanceCompanyRisk microfinanceCompanyRisk)
    {
        return microfinanceCompanyRiskMapper.selectMicrofinanceCompanyRiskList(microfinanceCompanyRisk);
    }

    /**
     * 新增小贷公司风险情况
     *
     * @param microfinanceCompanyRisk 小贷公司风险情况
     * @return 结果
     */
    @Override
    public int insertMicrofinanceCompanyRisk(MicrofinanceCompanyRisk microfinanceCompanyRisk)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long deptId = user.getDeptId();
        microfinanceCompanyRisk.setDeptId(deptId);
        microfinanceCompanyRisk.setCreateTime(DateUtils.getNowDate());
        return microfinanceCompanyRiskMapper.insertMicrofinanceCompanyRisk(microfinanceCompanyRisk);
    }

    /**
     * 修改小贷公司风险情况
     *
     * @param microfinanceCompanyRisk 小贷公司风险情况
     * @return 结果
     */
    @Override
    public int updateMicrofinanceCompanyRisk(MicrofinanceCompanyRisk microfinanceCompanyRisk)
    {
        microfinanceCompanyRisk.setUpdateTime(DateUtils.getNowDate());
        return microfinanceCompanyRiskMapper.updateMicrofinanceCompanyRisk(microfinanceCompanyRisk);
    }

    /**
     * 批量删除小贷公司风险情况
     *
     * @param ids 需要删除的小贷公司风险情况主键
     * @return 结果
     */
    @Override
    public int deleteMicrofinanceCompanyRiskByIds(Long[] ids)
    {
        return microfinanceCompanyRiskMapper.deleteMicrofinanceCompanyRiskByIds(ids);
    }

    /**
     * 删除小贷公司风险情况信息
     *
     * @param id 小贷公司风险情况主键
     * @return 结果
     */
    @Override
    public int deleteMicrofinanceCompanyRiskById(Long id)
    {
        return microfinanceCompanyRiskMapper.deleteMicrofinanceCompanyRiskById(id);
    }
}
