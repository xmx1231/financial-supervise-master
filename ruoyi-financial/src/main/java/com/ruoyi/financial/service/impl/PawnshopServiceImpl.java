package com.ruoyi.financial.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.financial.mapper.PawnshopMapper;
import com.ruoyi.financial.domain.Pawnshop;
import com.ruoyi.financial.service.IPawnshopService;

/**
 * 典当行经营情况Service业务层处理
 *
 * @author xmx
 * @date 2023-06-12
 */
@Service
public class PawnshopServiceImpl implements IPawnshopService
{
    @Autowired
    private PawnshopMapper pawnshopMapper;

    /**
     * 查询典当行经营情况
     *
     * @param id 典当行经营情况主键
     * @return 典当行经营情况
     */
    @Override
    public Pawnshop selectPawnshopById(Long id)
    {
        return pawnshopMapper.selectPawnshopById(id);
    }

    /**
     * 查询典当行经营情况列表
     *
     * @param pawnshop 典当行经营情况
     * @return 典当行经营情况
     */
    @Override
    @DataScope(deptAlias = "c")
    public List<Pawnshop> selectPawnshopList(Pawnshop pawnshop)
    {
        return pawnshopMapper.selectPawnshopList(pawnshop);
    }

    /**
     * 新增典当行经营情况
     *
     * @param pawnshop 典当行经营情况
     * @return 结果
     */
    @Override
    public int insertPawnshop(Pawnshop pawnshop)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long deptId = user.getDeptId();
        pawnshop.setDeptId(deptId);
        pawnshop.setCreateTime(DateUtils.getNowDate());
        return pawnshopMapper.insertPawnshop(pawnshop);
    }

    /**
     * 修改典当行经营情况
     *
     * @param pawnshop 典当行经营情况
     * @return 结果
     */
    @Override
    public int updatePawnshop(Pawnshop pawnshop)
    {
        pawnshop.setUpdateTime(DateUtils.getNowDate());
        return pawnshopMapper.updatePawnshop(pawnshop);
    }

    /**
     * 批量删除典当行经营情况
     *
     * @param ids 需要删除的典当行经营情况主键
     * @return 结果
     */
    @Override
    public int deletePawnshopByIds(Long[] ids)
    {
        return pawnshopMapper.deletePawnshopByIds(ids);
    }

    /**
     * 删除典当行经营情况信息
     *
     * @param id 典当行经营情况主键
     * @return 结果
     */
    @Override
    public int deletePawnshopById(Long id)
    {
        return pawnshopMapper.deletePawnshopById(id);
    }
}
