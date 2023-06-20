package com.ruoyi.financial.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.financial.mapper.PersonnelInfoMapper;
import com.ruoyi.financial.domain.PersonnelInfo;
import com.ruoyi.financial.service.IPersonnelInfoService;

/**
 * 人员信息Service业务层处理
 * 
 * @author xmx
 * @date 2023-06-09
 */
@Service
public class PersonnelInfoServiceImpl implements IPersonnelInfoService 
{
    @Autowired
    private PersonnelInfoMapper personnelInfoMapper;

    /**
     * 查询人员信息
     * 
     * @param id 人员信息主键
     * @return 人员信息
     */
    @Override
    public PersonnelInfo selectPersonnelInfoById(Long id)
    {
        return personnelInfoMapper.selectPersonnelInfoById(id);
    }

    /**
     * 查询人员信息列表
     * 
     * @param personnelInfo 人员信息
     * @return 人员信息
     */
    @Override
    public List<PersonnelInfo> selectPersonnelInfoList(PersonnelInfo personnelInfo)
    {
        return personnelInfoMapper.selectPersonnelInfoList(personnelInfo);
    }

    /**
     * 新增人员信息
     * 
     * @param personnelInfo 人员信息
     * @return 结果
     */
    @Override
    public int insertPersonnelInfo(PersonnelInfo personnelInfo)
    {
        personnelInfo.setCreateTime(DateUtils.getNowDate());
        return personnelInfoMapper.insertPersonnelInfo(personnelInfo);
    }

    /**
     * 修改人员信息
     * 
     * @param personnelInfo 人员信息
     * @return 结果
     */
    @Override
    public int updatePersonnelInfo(PersonnelInfo personnelInfo)
    {
        personnelInfo.setUpdateTime(DateUtils.getNowDate());
        return personnelInfoMapper.updatePersonnelInfo(personnelInfo);
    }

    /**
     * 批量删除人员信息
     * 
     * @param ids 需要删除的人员信息主键
     * @return 结果
     */
    @Override
    public int deletePersonnelInfoByIds(Long[] ids)
    {
        return personnelInfoMapper.deletePersonnelInfoByIds(ids);
    }

    /**
     * 删除人员信息信息
     * 
     * @param id 人员信息主键
     * @return 结果
     */
    @Override
    public int deletePersonnelInfoById(Long id)
    {
        return personnelInfoMapper.deletePersonnelInfoById(id);
    }
}
