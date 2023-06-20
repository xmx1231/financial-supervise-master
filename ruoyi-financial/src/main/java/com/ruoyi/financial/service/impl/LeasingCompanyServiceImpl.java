package com.ruoyi.financial.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.financial.mapper.LeasingCompanyMapper;
import com.ruoyi.financial.domain.LeasingCompany;
import com.ruoyi.financial.service.ILeasingCompanyService;

/**
 * 融资租赁经营情况Service业务层处理
 *
 * @author xmx
 * @date 2023-06-12
 */
@Service
public class LeasingCompanyServiceImpl implements ILeasingCompanyService
{
    @Autowired
    private LeasingCompanyMapper leasingCompanyMapper;

    /**
     * 查询融资租赁经营情况
     *
     * @param id 融资租赁经营情况主键
     * @return 融资租赁经营情况
     */
    @Override
    public LeasingCompany selectLeasingCompanyById(Long id)
    {
        return leasingCompanyMapper.selectLeasingCompanyById(id);
    }

    /**
     * 查询融资租赁经营情况列表
     *
     * @param leasingCompany 融资租赁经营情况
     * @return 融资租赁经营情况
     */
    @Override
    @DataScope(deptAlias = "c")
    public List<LeasingCompany> selectLeasingCompanyList(LeasingCompany leasingCompany)
    {
        return leasingCompanyMapper.selectLeasingCompanyList(leasingCompany);
    }

    /**
     * 新增融资租赁经营情况
     *
     * @param leasingCompany 融资租赁经营情况
     * @return 结果
     */
    @Override
    public int insertLeasingCompany(LeasingCompany leasingCompany)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long deptId = user.getDeptId();
        leasingCompany.setDeptId(deptId);
        leasingCompany.setCreateTime(DateUtils.getNowDate());
        return leasingCompanyMapper.insertLeasingCompany(leasingCompany);
    }

    /**
     * 修改融资租赁经营情况
     *
     * @param leasingCompany 融资租赁经营情况
     * @return 结果
     */
    @Override
    public int updateLeasingCompany(LeasingCompany leasingCompany)
    {
        leasingCompany.setUpdateTime(DateUtils.getNowDate());
        return leasingCompanyMapper.updateLeasingCompany(leasingCompany);
    }

    /**
     * 批量删除融资租赁经营情况
     *
     * @param ids 需要删除的融资租赁经营情况主键
     * @return 结果
     */
    @Override
    public int deleteLeasingCompanyByIds(Long[] ids)
    {
        return leasingCompanyMapper.deleteLeasingCompanyByIds(ids);
    }

    /**
     * 删除融资租赁经营情况信息
     *
     * @param id 融资租赁经营情况主键
     * @return 结果
     */
    @Override
    public int deleteLeasingCompanyById(Long id)
    {
        return leasingCompanyMapper.deleteLeasingCompanyById(id);
    }
}
