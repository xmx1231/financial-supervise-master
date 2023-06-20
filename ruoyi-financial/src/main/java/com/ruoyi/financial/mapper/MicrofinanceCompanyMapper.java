package com.ruoyi.financial.mapper;

import java.util.List;
import com.ruoyi.financial.domain.MicrofinanceCompany;

/**
 * 小贷公司经营情况Mapper接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface MicrofinanceCompanyMapper 
{
    /**
     * 查询小贷公司经营情况
     * 
     * @param id 小贷公司经营情况主键
     * @return 小贷公司经营情况
     */
    public MicrofinanceCompany selectMicrofinanceCompanyById(Long id);

    /**
     * 查询小贷公司经营情况列表
     * 
     * @param microfinanceCompany 小贷公司经营情况
     * @return 小贷公司经营情况集合
     */
    public List<MicrofinanceCompany> selectMicrofinanceCompanyList(MicrofinanceCompany microfinanceCompany);

    /**
     * 新增小贷公司经营情况
     * 
     * @param microfinanceCompany 小贷公司经营情况
     * @return 结果
     */
    public int insertMicrofinanceCompany(MicrofinanceCompany microfinanceCompany);

    /**
     * 修改小贷公司经营情况
     * 
     * @param microfinanceCompany 小贷公司经营情况
     * @return 结果
     */
    public int updateMicrofinanceCompany(MicrofinanceCompany microfinanceCompany);

    /**
     * 删除小贷公司经营情况
     * 
     * @param id 小贷公司经营情况主键
     * @return 结果
     */
    public int deleteMicrofinanceCompanyById(Long id);

    /**
     * 批量删除小贷公司经营情况
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMicrofinanceCompanyByIds(Long[] ids);
}
