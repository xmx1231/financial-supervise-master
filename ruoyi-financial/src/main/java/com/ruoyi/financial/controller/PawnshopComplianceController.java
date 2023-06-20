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
import com.ruoyi.financial.domain.PawnshopCompliance;
import com.ruoyi.financial.service.IPawnshopComplianceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 典当行合规情况Controller
 * 
 * @author xmx
 * @date 2023-06-12
 */
@RestController
@RequestMapping("/financial/pawnshopCompliance")
public class PawnshopComplianceController extends BaseController
{
    @Autowired
    private IPawnshopComplianceService pawnshopComplianceService;

    /**
     * 查询典当行合规情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopCompliance:list')")
    @GetMapping("/list")
    public TableDataInfo list(PawnshopCompliance pawnshopCompliance)
    {
        startPage();
        List<PawnshopCompliance> list = pawnshopComplianceService.selectPawnshopComplianceList(pawnshopCompliance);
        return getDataTable(list);
    }

    /**
     * 导出典当行合规情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopCompliance:export')")
    @Log(title = "典当行合规情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PawnshopCompliance pawnshopCompliance)
    {
        List<PawnshopCompliance> list = pawnshopComplianceService.selectPawnshopComplianceList(pawnshopCompliance);
        ExcelUtil<PawnshopCompliance> util = new ExcelUtil<PawnshopCompliance>(PawnshopCompliance.class);
        util.exportExcel(response, list, "典当行合规情况数据");
    }

    /**
     * 获取典当行合规情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopCompliance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pawnshopComplianceService.selectPawnshopComplianceById(id));
    }

    /**
     * 新增典当行合规情况
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopCompliance:add')")
    @Log(title = "典当行合规情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PawnshopCompliance pawnshopCompliance)
    {
        return toAjax(pawnshopComplianceService.insertPawnshopCompliance(pawnshopCompliance));
    }

    /**
     * 修改典当行合规情况
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopCompliance:edit')")
    @Log(title = "典当行合规情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PawnshopCompliance pawnshopCompliance)
    {
        return toAjax(pawnshopComplianceService.updatePawnshopCompliance(pawnshopCompliance));
    }

    /**
     * 删除典当行合规情况
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopCompliance:remove')")
    @Log(title = "典当行合规情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pawnshopComplianceService.deletePawnshopComplianceByIds(ids));
    }
}
