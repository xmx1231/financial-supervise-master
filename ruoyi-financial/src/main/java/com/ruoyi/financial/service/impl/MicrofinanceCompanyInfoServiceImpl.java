package com.ruoyi.financial.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.financial.mapper.MicrofinanceCompanyInfoMapper;
import com.ruoyi.financial.domain.MicrofinanceCompanyInfo;
import com.ruoyi.financial.service.IMicrofinanceCompanyInfoService;

/**
 * 小贷公司基本情况Service业务层处理
 *
 * @author xmx
 * @date 2023-06-12
 */
@Service
public class MicrofinanceCompanyInfoServiceImpl implements IMicrofinanceCompanyInfoService
{
    @Autowired
    private MicrofinanceCompanyInfoMapper microfinanceCompanyInfoMapper;

    /**
     * 查询小贷公司基本情况
     *
     * @param id 小贷公司基本情况主键
     * @return 小贷公司基本情况
     */
    @Override
    public MicrofinanceCompanyInfo selectMicrofinanceCompanyInfoById(Long id)
    {
        return microfinanceCompanyInfoMapper.selectMicrofinanceCompanyInfoById(id);
    }

    /**
     * 查询小贷公司基本情况列表
     *
     * @param microfinanceCompanyInfo 小贷公司基本情况
     * @return 小贷公司基本情况
     */
    @Override
    @DataScope(deptAlias = "c")
    public List<MicrofinanceCompanyInfo> selectMicrofinanceCompanyInfoList(MicrofinanceCompanyInfo microfinanceCompanyInfo)
    {
        return microfinanceCompanyInfoMapper.selectMicrofinanceCompanyInfoList(microfinanceCompanyInfo);
    }

    /**
     * 新增小贷公司基本情况
     *
     * @param microfinanceCompanyInfo 小贷公司基本情况
     * @return 结果
     */
    @Override
    public int insertMicrofinanceCompanyInfo(MicrofinanceCompanyInfo microfinanceCompanyInfo)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long deptId = user.getDeptId();
        microfinanceCompanyInfo.setDeptId(deptId);
        microfinanceCompanyInfo.setCreateTime(DateUtils.getNowDate());
        return microfinanceCompanyInfoMapper.insertMicrofinanceCompanyInfo(microfinanceCompanyInfo);
    }

    /**
     * 修改小贷公司基本情况
     *
     * @param microfinanceCompanyInfo 小贷公司基本情况
     * @return 结果
     */
    @Override
    public int updateMicrofinanceCompanyInfo(MicrofinanceCompanyInfo microfinanceCompanyInfo)
    {
        microfinanceCompanyInfo.setUpdateTime(DateUtils.getNowDate());
        return microfinanceCompanyInfoMapper.updateMicrofinanceCompanyInfo(microfinanceCompanyInfo);
    }

    /**
     * 批量删除小贷公司基本情况
     *
     * @param ids 需要删除的小贷公司基本情况主键
     * @return 结果
     */
    @Override
    public int deleteMicrofinanceCompanyInfoByIds(Long[] ids)
    {
        return microfinanceCompanyInfoMapper.deleteMicrofinanceCompanyInfoByIds(ids);
    }

    /**
     * 删除小贷公司基本情况信息
     *
     * @param id 小贷公司基本情况主键
     * @return 结果
     */
    @Override
    public int deleteMicrofinanceCompanyInfoById(Long id)
    {
        return microfinanceCompanyInfoMapper.deleteMicrofinanceCompanyInfoById(id);
    }
}
