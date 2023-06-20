package com.ruoyi.financial.mapper;

import java.util.List;
import com.ruoyi.financial.domain.MicrofinanceCompanyInfo;

/**
 * 小贷公司基本情况Mapper接口
 * 
 * @author xmx
 * @date 2023-06-12
 */
public interface MicrofinanceCompanyInfoMapper 
{
    /**
     * 查询小贷公司基本情况
     * 
     * @param id 小贷公司基本情况主键
     * @return 小贷公司基本情况
     */
    public MicrofinanceCompanyInfo selectMicrofinanceCompanyInfoById(Long id);

    /**
     * 查询小贷公司基本情况列表
     * 
     * @param microfinanceCompanyInfo 小贷公司基本情况
     * @return 小贷公司基本情况集合
     */
    public List<MicrofinanceCompanyInfo> selectMicrofinanceCompanyInfoList(MicrofinanceCompanyInfo microfinanceCompanyInfo);

    /**
     * 新增小贷公司基本情况
     * 
     * @param microfinanceCompanyInfo 小贷公司基本情况
     * @return 结果
     */
    public int insertMicrofinanceCompanyInfo(MicrofinanceCompanyInfo microfinanceCompanyInfo);

    /**
     * 修改小贷公司基本情况
     * 
     * @param microfinanceCompanyInfo 小贷公司基本情况
     * @return 结果
     */
    public int updateMicrofinanceCompanyInfo(MicrofinanceCompanyInfo microfinanceCompanyInfo);

    /**
     * 删除小贷公司基本情况
     * 
     * @param id 小贷公司基本情况主键
     * @return 结果
     */
    public int deleteMicrofinanceCompanyInfoById(Long id);

    /**
     * 批量删除小贷公司基本情况
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMicrofinanceCompanyInfoByIds(Long[] ids);
}
