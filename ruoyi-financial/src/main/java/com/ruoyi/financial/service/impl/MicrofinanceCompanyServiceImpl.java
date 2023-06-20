package com.ruoyi.financial.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.financial.mapper.MicrofinanceCompanyMapper;
import com.ruoyi.financial.domain.MicrofinanceCompany;
import com.ruoyi.financial.service.IMicrofinanceCompanyService;

/**
 * 小贷公司经营情况Service业务层处理
 *
 * @author xmx
 * @date 2023-06-12
 */
@Service
public class MicrofinanceCompanyServiceImpl implements IMicrofinanceCompanyService
{
    @Autowired
    private MicrofinanceCompanyMapper microfinanceCompanyMapper;

    /**
     * 查询小贷公司经营情况
     *
     * @param id 小贷公司经营情况主键
     * @return 小贷公司经营情况
     */
    @Override
    public MicrofinanceCompany selectMicrofinanceCompanyById(Long id)
    {
        return microfinanceCompanyMapper.selectMicrofinanceCompanyById(id);
    }

    /**
     * 查询小贷公司经营情况列表
     *
     * @param microfinanceCompany 小贷公司经营情况
     * @return 小贷公司经营情况
     */
    @Override
    @DataScope(deptAlias = "c")
    public List<MicrofinanceCompany> selectMicrofinanceCompanyList(MicrofinanceCompany microfinanceCompany)
    {
        return microfinanceCompanyMapper.selectMicrofinanceCompanyList(microfinanceCompany);
    }

    /**
     * 新增小贷公司经营情况
     *
     * @param microfinanceCompany 小贷公司经营情况
     * @return 结果
     */
    @Override
    public int insertMicrofinanceCompany(MicrofinanceCompany microfinanceCompany)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long deptId = user.getDeptId();
        microfinanceCompany.setDeptId(deptId);
        microfinanceCompany.setCreateTime(DateUtils.getNowDate());
        return microfinanceCompanyMapper.insertMicrofinanceCompany(microfinanceCompany);
    }

    /**
     * 修改小贷公司经营情况
     *
     * @param microfinanceCompany 小贷公司经营情况
     * @return 结果
     */
    @Override
    public int updateMicrofinanceCompany(MicrofinanceCompany microfinanceCompany)
    {
        microfinanceCompany.setUpdateTime(DateUtils.getNowDate());
        return microfinanceCompanyMapper.updateMicrofinanceCompany(microfinanceCompany);
    }

    /**
     * 批量删除小贷公司经营情况
     *
     * @param ids 需要删除的小贷公司经营情况主键
     * @return 结果
     */
    @Override
    public int deleteMicrofinanceCompanyByIds(Long[] ids)
    {
        return microfinanceCompanyMapper.deleteMicrofinanceCompanyByIds(ids);
    }

    /**
     * 删除小贷公司经营情况信息
     *
     * @param id 小贷公司经营情况主键
     * @return 结果
     */
    @Override
    public int deleteMicrofinanceCompanyById(Long id)
    {
        return microfinanceCompanyMapper.deleteMicrofinanceCompanyById(id);
    }
}
