package com.ruoyi.financial.service;

import java.util.List;
import com.ruoyi.financial.domain.PawnshopRisk;

/**
 * 典当行风险情况Service接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface IPawnshopRiskService 
{
    /**
     * 查询典当行风险情况
     * 
     * @param id 典当行风险情况主键
     * @return 典当行风险情况
     */
    public PawnshopRisk selectPawnshopRiskById(Long id);

    /**
     * 查询典当行风险情况列表
     * 
     * @param pawnshopRisk 典当行风险情况
     * @return 典当行风险情况集合
     */
    public List<PawnshopRisk> selectPawnshopRiskList(PawnshopRisk pawnshopRisk);

    /**
     * 新增典当行风险情况
     * 
     * @param pawnshopRisk 典当行风险情况
     * @return 结果
     */
    public int insertPawnshopRisk(PawnshopRisk pawnshopRisk);

    /**
     * 修改典当行风险情况
     * 
     * @param pawnshopRisk 典当行风险情况
     * @return 结果
     */
    public int updatePawnshopRisk(PawnshopRisk pawnshopRisk);

    /**
     * 批量删除典当行风险情况
     * 
     * @param ids 需要删除的典当行风险情况主键集合
     * @return 结果
     */
    public int deletePawnshopRiskByIds(Long[] ids);

    /**
     * 删除典当行风险情况信息
     * 
     * @param id 典当行风险情况主键
     * @return 结果
     */
    public int deletePawnshopRiskById(Long id);
}
