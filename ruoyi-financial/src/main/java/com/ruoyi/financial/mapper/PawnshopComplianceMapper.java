package com.ruoyi.financial.mapper;

import java.util.List;
import com.ruoyi.financial.domain.PawnshopCompliance;

/**
 * 典当行合规情况Mapper接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface PawnshopComplianceMapper 
{
    /**
     * 查询典当行合规情况
     * 
     * @param id 典当行合规情况主键
     * @return 典当行合规情况
     */
    public PawnshopCompliance selectPawnshopComplianceById(Long id);

    /**
     * 查询典当行合规情况列表
     * 
     * @param pawnshopCompliance 典当行合规情况
     * @return 典当行合规情况集合
     */
    public List<PawnshopCompliance> selectPawnshopComplianceList(PawnshopCompliance pawnshopCompliance);

    /**
     * 新增典当行合规情况
     * 
     * @param pawnshopCompliance 典当行合规情况
     * @return 结果
     */
    public int insertPawnshopCompliance(PawnshopCompliance pawnshopCompliance);

    /**
     * 修改典当行合规情况
     * 
     * @param pawnshopCompliance 典当行合规情况
     * @return 结果
     */
    public int updatePawnshopCompliance(PawnshopCompliance pawnshopCompliance);

    /**
     * 删除典当行合规情况
     * 
     * @param id 典当行合规情况主键
     * @return 结果
     */
    public int deletePawnshopComplianceById(Long id);

    /**
     * 批量删除典当行合规情况
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePawnshopComplianceByIds(Long[] ids);
}
