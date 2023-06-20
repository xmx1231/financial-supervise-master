package com.ruoyi.financial.service;

import java.util.List;
import com.ruoyi.financial.domain.PawnshopBasicInfo;

/**
 * 典当行基本情况Service接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface IPawnshopBasicInfoService 
{
    /**
     * 查询典当行基本情况
     * 
     * @param id 典当行基本情况主键
     * @return 典当行基本情况
     */
    public PawnshopBasicInfo selectPawnshopBasicInfoById(Long id);

    /**
     * 查询典当行基本情况列表
     * 
     * @param pawnshopBasicInfo 典当行基本情况
     * @return 典当行基本情况集合
     */
    public List<PawnshopBasicInfo> selectPawnshopBasicInfoList(PawnshopBasicInfo pawnshopBasicInfo);

    /**
     * 新增典当行基本情况
     * 
     * @param pawnshopBasicInfo 典当行基本情况
     * @return 结果
     */
    public int insertPawnshopBasicInfo(PawnshopBasicInfo pawnshopBasicInfo);

    /**
     * 修改典当行基本情况
     * 
     * @param pawnshopBasicInfo 典当行基本情况
     * @return 结果
     */
    public int updatePawnshopBasicInfo(PawnshopBasicInfo pawnshopBasicInfo);

    /**
     * 批量删除典当行基本情况
     * 
     * @param ids 需要删除的典当行基本情况主键集合
     * @return 结果
     */
    public int deletePawnshopBasicInfoByIds(Long[] ids);

    /**
     * 删除典当行基本情况信息
     * 
     * @param id 典当行基本情况主键
     * @return 结果
     */
    public int deletePawnshopBasicInfoById(Long id);
}
