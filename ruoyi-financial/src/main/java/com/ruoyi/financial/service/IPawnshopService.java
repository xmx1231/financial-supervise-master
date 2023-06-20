package com.ruoyi.financial.service;

import java.util.List;
import com.ruoyi.financial.domain.Pawnshop;

/**
 * 典当行经营情况Service接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface IPawnshopService 
{
    /**
     * 查询典当行经营情况
     * 
     * @param id 典当行经营情况主键
     * @return 典当行经营情况
     */
    public Pawnshop selectPawnshopById(Long id);

    /**
     * 查询典当行经营情况列表
     * 
     * @param pawnshop 典当行经营情况
     * @return 典当行经营情况集合
     */
    public List<Pawnshop> selectPawnshopList(Pawnshop pawnshop);

    /**
     * 新增典当行经营情况
     * 
     * @param pawnshop 典当行经营情况
     * @return 结果
     */
    public int insertPawnshop(Pawnshop pawnshop);

    /**
     * 修改典当行经营情况
     * 
     * @param pawnshop 典当行经营情况
     * @return 结果
     */
    public int updatePawnshop(Pawnshop pawnshop);

    /**
     * 批量删除典当行经营情况
     * 
     * @param ids 需要删除的典当行经营情况主键集合
     * @return 结果
     */
    public int deletePawnshopByIds(Long[] ids);

    /**
     * 删除典当行经营情况信息
     * 
     * @param id 典当行经营情况主键
     * @return 结果
     */
    public int deletePawnshopById(Long id);
}
