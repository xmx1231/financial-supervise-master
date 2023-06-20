package com.ruoyi.financial.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.financial.mapper.MicrofinanceCompanyComplianceMapper;
import com.ruoyi.financial.domain.MicrofinanceCompanyCompliance;
import com.ruoyi.financial.service.IMicrofinanceCompanyComplianceService;

/**
 * 小贷公司合规情况Service业务层处理
 *
 * @author xmx
 * @date 2023-06-12
 */
@Service
public class MicrofinanceCompanyComplianceServiceImpl implements IMicrofinanceCompanyComplianceService
{
    @Autowired
    private MicrofinanceCompanyComplianceMapper microfinanceCompanyComplianceMapper;

    /**
     * 查询小贷公司合规情况
     *
     * @param id 小贷公司合规情况主键
     * @return 小贷公司合规情况
     */
    @Override
    public MicrofinanceCompanyCompliance selectMicrofinanceCompanyComplianceById(Long id)
    {
        return microfinanceCompanyComplianceMapper.selectMicrofinanceCompanyComplianceById(id);
    }

    /**
     * 查询小贷公司合规情况列表
     *
     * @param microfinanceCompanyCompliance 小贷公司合规情况
     * @return 小贷公司合规情况
     */
    @Override
    @DataScope(deptAlias = "c")
    public List<MicrofinanceCompanyCompliance> selectMicrofinanceCompanyComplianceList(MicrofinanceCompanyCompliance microfinanceCompanyCompliance)
    {
        return microfinanceCompanyComplianceMapper.selectMicrofinanceCompanyComplianceList(microfinanceCompanyCompliance);
    }

    /**
     * 新增小贷公司合规情况
     *
     * @param microfinanceCompanyCompliance 小贷公司合规情况
     * @return 结果
     */
    @Override
    public int insertMicrofinanceCompanyCompliance(MicrofinanceCompanyCompliance microfinanceCompanyCompliance)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long deptId = user.getDeptId();
        microfinanceCompanyCompliance.setDeptId(deptId);
        microfinanceCompanyCompliance.setCreateTime(DateUtils.getNowDate());
        return microfinanceCompanyComplianceMapper.insertMicrofinanceCompanyCompliance(microfinanceCompanyCompliance);
    }

    /**
     * 修改小贷公司合规情况
     *
     * @param microfinanceCompanyCompliance 小贷公司合规情况
     * @return 结果
     */
    @Override
    public int updateMicrofinanceCompanyCompliance(MicrofinanceCompanyCompliance microfinanceCompanyCompliance)
    {
        microfinanceCompanyCompliance.setUpdateTime(DateUtils.getNowDate());
        return microfinanceCompanyComplianceMapper.updateMicrofinanceCompanyCompliance(microfinanceCompanyCompliance);
    }

    /**
     * 批量删除小贷公司合规情况
     *
     * @param ids 需要删除的小贷公司合规情况主键
     * @return 结果
     */
    @Override
    public int deleteMicrofinanceCompanyComplianceByIds(Long[] ids)
    {
        return microfinanceCompanyComplianceMapper.deleteMicrofinanceCompanyComplianceByIds(ids);
    }

    /**
     * 删除小贷公司合规情况信息
     *
     * @param id 小贷公司合规情况主键
     * @return 结果
     */
    @Override
    public int deleteMicrofinanceCompanyComplianceById(Long id)
    {
        return microfinanceCompanyComplianceMapper.deleteMicrofinanceCompanyComplianceById(id);
    }
}
