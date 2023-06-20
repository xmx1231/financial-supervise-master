package com.ruoyi.financial.mapper;

import java.util.List;
import com.ruoyi.financial.domain.PersonnelInfo;

/**
 * 人员信息Mapper接口
 * 
 * @author xmx
 * @date 2023-06-09
 */
public interface PersonnelInfoMapper 
{
    /**
     * 查询人员信息
     * 
     * @param id 人员信息主键
     * @return 人员信息
     */
    public PersonnelInfo selectPersonnelInfoById(Long id);

    /**
     * 查询人员信息列表
     * 
     * @param personnelInfo 人员信息
     * @return 人员信息集合
     */
    public List<PersonnelInfo> selectPersonnelInfoList(PersonnelInfo personnelInfo);

    /**
     * 新增人员信息
     * 
     * @param personnelInfo 人员信息
     * @return 结果
     */
    public int insertPersonnelInfo(PersonnelInfo personnelInfo);

    /**
     * 修改人员信息
     * 
     * @param personnelInfo 人员信息
     * @return 结果
     */
    public int updatePersonnelInfo(PersonnelInfo personnelInfo);

    /**
     * 删除人员信息
     * 
     * @param id 人员信息主键
     * @return 结果
     */
    public int deletePersonnelInfoById(Long id);

    /**
     * 批量删除人员信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePersonnelInfoByIds(Long[] ids);
}
