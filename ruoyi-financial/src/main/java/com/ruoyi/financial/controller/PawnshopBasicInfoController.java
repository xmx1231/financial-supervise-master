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
import com.ruoyi.financial.domain.PawnshopBasicInfo;
import com.ruoyi.financial.service.IPawnshopBasicInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 典当行基本情况Controller
 * 
 * @author xmx
 * @date 2023-06-12
 */
@RestController
@RequestMapping("/financial/pawnshopBasicInfo")
public class PawnshopBasicInfoController extends BaseController
{
    @Autowired
    private IPawnshopBasicInfoService pawnshopBasicInfoService;

    /**
     * 查询典当行基本情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopBasicInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(PawnshopBasicInfo pawnshopBasicInfo)
    {
        startPage();
        List<PawnshopBasicInfo> list = pawnshopBasicInfoService.selectPawnshopBasicInfoList(pawnshopBasicInfo);
        return getDataTable(list);
    }

    /**
     * 导出典当行基本情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopBasicInfo:export')")
    @Log(title = "典当行基本情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PawnshopBasicInfo pawnshopBasicInfo)
    {
        List<PawnshopBasicInfo> list = pawnshopBasicInfoService.selectPawnshopBasicInfoList(pawnshopBasicInfo);
        ExcelUtil<PawnshopBasicInfo> util = new ExcelUtil<PawnshopBasicInfo>(PawnshopBasicInfo.class);
        util.exportExcel(response, list, "典当行基本情况数据");
    }

    /**
     * 获取典当行基本情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopBasicInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pawnshopBasicInfoService.selectPawnshopBasicInfoById(id));
    }

    /**
     * 新增典当行基本情况
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopBasicInfo:add')")
    @Log(title = "典当行基本情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PawnshopBasicInfo pawnshopBasicInfo)
    {
        return toAjax(pawnshopBasicInfoService.insertPawnshopBasicInfo(pawnshopBasicInfo));
    }

    /**
     * 修改典当行基本情况
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopBasicInfo:edit')")
    @Log(title = "典当行基本情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PawnshopBasicInfo pawnshopBasicInfo)
    {
        return toAjax(pawnshopBasicInfoService.updatePawnshopBasicInfo(pawnshopBasicInfo));
    }

    /**
     * 删除典当行基本情况
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopBasicInfo:remove')")
    @Log(title = "典当行基本情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pawnshopBasicInfoService.deletePawnshopBasicInfoByIds(ids));
    }
}
