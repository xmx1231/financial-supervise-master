package com.ruoyi.financial.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.financial.mapper.PawnshopRiskMapper;
import com.ruoyi.financial.domain.PawnshopRisk;
import com.ruoyi.financial.service.IPawnshopRiskService;

/**
 * 典当行风险情况Service业务层处理
 *
 * @author xmx
 * @date 2023-06-12
 */
@Service
public class PawnshopRiskServiceImpl implements IPawnshopRiskService
{
    @Autowired
    private PawnshopRiskMapper pawnshopRiskMapper;

    /**
     * 查询典当行风险情况
     *
     * @param id 典当行风险情况主键
     * @return 典当行风险情况
     */
    @Override
    public PawnshopRisk selectPawnshopRiskById(Long id)
    {
        return pawnshopRiskMapper.selectPawnshopRiskById(id);
    }

    /**
     * 查询典当行风险情况列表
     *
     * @param pawnshopRisk 典当行风险情况
     * @return 典当行风险情况
     */
    @Override
    @DataScope(deptAlias = "c")
    public List<PawnshopRisk> selectPawnshopRiskList(PawnshopRisk pawnshopRisk)
    {
        return pawnshopRiskMapper.selectPawnshopRiskList(pawnshopRisk);
    }

    /**
     * 新增典当行风险情况
     *
     * @param pawnshopRisk 典当行风险情况
     * @return 结果
     */
    @Override
    public int insertPawnshopRisk(PawnshopRisk pawnshopRisk)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long deptId = user.getDeptId();
        pawnshopRisk.setDeptId(deptId);
        pawnshopRisk.setCreateTime(DateUtils.getNowDate());
        return pawnshopRiskMapper.insertPawnshopRisk(pawnshopRisk);
    }

    /**
     * 修改典当行风险情况
     *
     * @param pawnshopRisk 典当行风险情况
     * @return 结果
     */
    @Override
    public int updatePawnshopRisk(PawnshopRisk pawnshopRisk)
    {
        pawnshopRisk.setUpdateTime(DateUtils.getNowDate());
        return pawnshopRiskMapper.updatePawnshopRisk(pawnshopRisk);
    }

    /**
     * 批量删除典当行风险情况
     *
     * @param ids 需要删除的典当行风险情况主键
     * @return 结果
     */
    @Override
    public int deletePawnshopRiskByIds(Long[] ids)
    {
        return pawnshopRiskMapper.deletePawnshopRiskByIds(ids);
    }

    /**
     * 删除典当行风险情况信息
     *
     * @param id 典当行风险情况主键
     * @return 结果
     */
    @Override
    public int deletePawnshopRiskById(Long id)
    {
        return pawnshopRiskMapper.deletePawnshopRiskById(id);
    }
}
