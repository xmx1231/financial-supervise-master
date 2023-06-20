package com.ruoyi.financial.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.financial.mapper.PawnshopBasicInfoMapper;
import com.ruoyi.financial.domain.PawnshopBasicInfo;
import com.ruoyi.financial.service.IPawnshopBasicInfoService;

/**
 * 典当行基本情况Service业务层处理
 *
 * @author xmx
 * @date 2023-06-12
 */
@Service
public class PawnshopBasicInfoServiceImpl implements IPawnshopBasicInfoService
{
    @Autowired
    private PawnshopBasicInfoMapper pawnshopBasicInfoMapper;

    /**
     * 查询典当行基本情况
     *
     * @param id 典当行基本情况主键
     * @return 典当行基本情况
     */
    @Override
    public PawnshopBasicInfo selectPawnshopBasicInfoById(Long id)
    {
        return pawnshopBasicInfoMapper.selectPawnshopBasicInfoById(id);
    }

    /**
     * 查询典当行基本情况列表
     *
     * @param pawnshopBasicInfo 典当行基本情况
     * @return 典当行基本情况
     */
    @Override
    @DataScope(deptAlias = "c")
    public List<PawnshopBasicInfo> selectPawnshopBasicInfoList(PawnshopBasicInfo pawnshopBasicInfo)
    {
        return pawnshopBasicInfoMapper.selectPawnshopBasicInfoList(pawnshopBasicInfo);
    }

    /**
     * 新增典当行基本情况
     *
     * @param pawnshopBasicInfo 典当行基本情况
     * @return 结果
     */
    @Override
    public int insertPawnshopBasicInfo(PawnshopBasicInfo pawnshopBasicInfo)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long deptId = user.getDeptId();
        pawnshopBasicInfo.setDeptId(deptId);
        pawnshopBasicInfo.setCreateTime(DateUtils.getNowDate());
        return pawnshopBasicInfoMapper.insertPawnshopBasicInfo(pawnshopBasicInfo);
    }

    /**
     * 修改典当行基本情况
     *
     * @param pawnshopBasicInfo 典当行基本情况
     * @return 结果
     */
    @Override
    public int updatePawnshopBasicInfo(PawnshopBasicInfo pawnshopBasicInfo)
    {
        pawnshopBasicInfo.setUpdateTime(DateUtils.getNowDate());
        return pawnshopBasicInfoMapper.updatePawnshopBasicInfo(pawnshopBasicInfo);
    }

    /**
     * 批量删除典当行基本情况
     *
     * @param ids 需要删除的典当行基本情况主键
     * @return 结果
     */
    @Override
    public int deletePawnshopBasicInfoByIds(Long[] ids)
    {
        return pawnshopBasicInfoMapper.deletePawnshopBasicInfoByIds(ids);
    }

    /**
     * 删除典当行基本情况信息
     *
     * @param id 典当行基本情况主键
     * @return 结果
     */
    @Override
    public int deletePawnshopBasicInfoById(Long id)
    {
        return pawnshopBasicInfoMapper.deletePawnshopBasicInfoById(id);
    }
}
