package com.ruoyi.financial.mapper;

import java.util.List;
import com.ruoyi.financial.domain.PawnshopBasicInfo;

/**
 * 典当行基本情况Mapper接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface PawnshopBasicInfoMapper 
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
     * 删除典当行基本情况
     * 
     * @param id 典当行基本情况主键
     * @return 结果
     */
    public int deletePawnshopBasicInfoById(Long id);

    /**
     * 批量删除典当行基本情况
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePawnshopBasicInfoByIds(Long[] ids);
}
