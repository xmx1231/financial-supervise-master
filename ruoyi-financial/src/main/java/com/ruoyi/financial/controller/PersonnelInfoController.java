package com.ruoyi.financial.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.financial.domain.PersonnelInfo;
import com.ruoyi.financial.service.IPersonnelInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人员信息Controller
 * 
 * @author xmx
 * @date 2023-06-09
 */
@RestController
@RequestMapping("/financial/personnelInfo")
public class PersonnelInfoController extends BaseController
{
    @Autowired
    private IPersonnelInfoService personnelInfoService;

    /**
     * 查询人员信息列表
     */
    @PreAuthorize("@ss.hasPermi('financial:personnelInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonnelInfo personnelInfo)
    {
        startPage();
        List<PersonnelInfo> list = personnelInfoService.selectPersonnelInfoList(personnelInfo);
        return getDataTable(list);
    }

    /**
     * 导出人员信息列表
     */
    @PreAuthorize("@ss.hasPermi('financial:personnelInfo:export')")
    @Log(title = "人员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonnelInfo personnelInfo)
    {
        List<PersonnelInfo> list = personnelInfoService.selectPersonnelInfoList(personnelInfo);
        ExcelUtil<PersonnelInfo> util = new ExcelUtil<PersonnelInfo>(PersonnelInfo.class);
        util.exportExcel(response, list, "人员信息数据");
    }

    /**
     * 获取人员信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:personnelInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(personnelInfoService.selectPersonnelInfoById(id));
    }

    /**
     * 新增人员信息
     */
    @PreAuthorize("@ss.hasPermi('financial:personnelInfo:add')")
    @Log(title = "人员信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonnelInfo personnelInfo)
    {
        return toAjax(personnelInfoService.insertPersonnelInfo(personnelInfo));
    }

    /**
     * 修改人员信息
     */
    @PreAuthorize("@ss.hasPermi('financial:personnelInfo:edit')")
    @Log(title = "人员信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonnelInfo personnelInfo)
    {
        return toAjax(personnelInfoService.updatePersonnelInfo(personnelInfo));
    }

    /**
     * 删除人员信息
     */
    @PreAuthorize("@ss.hasPermi('financial:personnelInfo:remove')")
    @Log(title = "人员信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(personnelInfoService.deletePersonnelInfoByIds(ids));
    }
}
