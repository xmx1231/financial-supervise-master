package com.ruoyi.financial.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.financial.mapper.FactoringCompanyMapper;
import com.ruoyi.financial.domain.FactoringCompany;
import com.ruoyi.financial.service.IFactoringCompanyService;

/**
 * 商业保理公司经营情况Service业务层处理
 *
 * @author xmx
 * @date 2023-06-12
 */
@Service
public class FactoringCompanyServiceImpl implements IFactoringCompanyService
{
    @Autowired
    private FactoringCompanyMapper factoringCompanyMapper;

    /**
     * 查询商业保理公司经营情况
     *
     * @param id 商业保理公司经营情况主键
     * @return 商业保理公司经营情况
     */
    @Override
    public FactoringCompany selectFactoringCompanyById(Long id)
    {
        return factoringCompanyMapper.selectFactoringCompanyById(id);
    }

    /**
     * 查询商业保理公司经营情况列表
     *
     * @param factoringCompany 商业保理公司经营情况
     * @return 商业保理公司经营情况
     */
    @Override
    @DataScope(deptAlias = "c")
    public List<FactoringCompany> selectFactoringCompanyList(FactoringCompany factoringCompany)
    {
        return factoringCompanyMapper.selectFactoringCompanyList(factoringCompany);
    }

    /**
     * 新增商业保理公司经营情况
     *
     * @param factoringCompany 商业保理公司经营情况
     * @return 结果
     */
    @Override
    public int insertFactoringCompany(FactoringCompany factoringCompany)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long deptId = user.getDeptId();
        factoringCompany.setDeptId(deptId);
        factoringCompany.setCreateTime(DateUtils.getNowDate());
        return factoringCompanyMapper.insertFactoringCompany(factoringCompany);
    }

    /**
     * 修改商业保理公司经营情况
     *
     * @param factoringCompany 商业保理公司经营情况
     * @return 结果
     */
    @Override
    public int updateFactoringCompany(FactoringCompany factoringCompany)
    {
        factoringCompany.setUpdateTime(DateUtils.getNowDate());
        return factoringCompanyMapper.updateFactoringCompany(factoringCompany);
    }

    /**
     * 批量删除商业保理公司经营情况
     *
     * @param ids 需要删除的商业保理公司经营情况主键
     * @return 结果
     */
    @Override
    public int deleteFactoringCompanyByIds(Long[] ids)
    {
        return factoringCompanyMapper.deleteFactoringCompanyByIds(ids);
    }

    /**
     * 删除商业保理公司经营情况信息
     *
     * @param id 商业保理公司经营情况主键
     * @return 结果
     */
    @Override
    public int deleteFactoringCompanyById(Long id)
    {
        return factoringCompanyMapper.deleteFactoringCompanyById(id);
    }
}
