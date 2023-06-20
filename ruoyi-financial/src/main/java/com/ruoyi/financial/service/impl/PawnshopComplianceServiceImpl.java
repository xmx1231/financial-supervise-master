package com.ruoyi.financial.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.financial.mapper.PawnshopComplianceMapper;
import com.ruoyi.financial.domain.PawnshopCompliance;
import com.ruoyi.financial.service.IPawnshopComplianceService;

/**
 * 典当行合规情况Service业务层处理
 *
 * @author xmx
 * @date 2023-06-12
 */
@Service
public class PawnshopComplianceServiceImpl implements IPawnshopComplianceService
{
    @Autowired
    private PawnshopComplianceMapper pawnshopComplianceMapper;

    /**
     * 查询典当行合规情况
     *
     * @param id 典当行合规情况主键
     * @return 典当行合规情况
     */
    @Override
    public PawnshopCompliance selectPawnshopComplianceById(Long id)
    {
        return pawnshopComplianceMapper.selectPawnshopComplianceById(id);
    }

    /**
     * 查询典当行合规情况列表
     *
     * @param pawnshopCompliance 典当行合规情况
     * @return 典当行合规情况
     */
    @Override
    @DataScope(deptAlias = "c")
    public List<PawnshopCompliance> selectPawnshopComplianceList(PawnshopCompliance pawnshopCompliance)
    {
        return pawnshopComplianceMapper.selectPawnshopComplianceList(pawnshopCompliance);
    }

    /**
     * 新增典当行合规情况
     *
     * @param pawnshopCompliance 典当行合规情况
     * @return 结果
     */
    @Override
    public int insertPawnshopCompliance(PawnshopCompliance pawnshopCompliance)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long deptId = user.getDeptId();
        pawnshopCompliance.setDeptId(deptId);
        pawnshopCompliance.setCreateTime(DateUtils.getNowDate());
        return pawnshopComplianceMapper.insertPawnshopCompliance(pawnshopCompliance);
    }

    /**
     * 修改典当行合规情况
     *
     * @param pawnshopCompliance 典当行合规情况
     * @return 结果
     */
    @Override
    public int updatePawnshopCompliance(PawnshopCompliance pawnshopCompliance)
    {
        pawnshopCompliance.setUpdateTime(DateUtils.getNowDate());
        return pawnshopComplianceMapper.updatePawnshopCompliance(pawnshopCompliance);
    }

    /**
     * 批量删除典当行合规情况
     *
     * @param ids 需要删除的典当行合规情况主键
     * @return 结果
     */
    @Override
    public int deletePawnshopComplianceByIds(Long[] ids)
    {
        return pawnshopComplianceMapper.deletePawnshopComplianceByIds(ids);
    }

    /**
     * 删除典当行合规情况信息
     *
     * @param id 典当行合规情况主键
     * @return 结果
     */
    @Override
    public int deletePawnshopComplianceById(Long id)
    {
        return pawnshopComplianceMapper.deletePawnshopComplianceById(id);
    }
}
