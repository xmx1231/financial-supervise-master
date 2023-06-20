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
import com.ruoyi.financial.domain.PawnshopRisk;
import com.ruoyi.financial.service.IPawnshopRiskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 典当行风险情况Controller
 * 
 * @author xmx
 * @date 2023-06-12
 */
@RestController
@RequestMapping("/financial/pawnshopRisk")
public class PawnshopRiskController extends BaseController
{
    @Autowired
    private IPawnshopRiskService pawnshopRiskService;

    /**
     * 查询典当行风险情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopRisk:list')")
    @GetMapping("/list")
    public TableDataInfo list(PawnshopRisk pawnshopRisk)
    {
        startPage();
        List<PawnshopRisk> list = pawnshopRiskService.selectPawnshopRiskList(pawnshopRisk);
        return getDataTable(list);
    }

    /**
     * 导出典当行风险情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopRisk:export')")
    @Log(title = "典当行风险情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PawnshopRisk pawnshopRisk)
    {
        List<PawnshopRisk> list = pawnshopRiskService.selectPawnshopRiskList(pawnshopRisk);
        ExcelUtil<PawnshopRisk> util = new ExcelUtil<PawnshopRisk>(PawnshopRisk.class);
        util.exportExcel(response, list, "典当行风险情况数据");
    }

    /**
     * 获取典当行风险情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopRisk:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pawnshopRiskService.selectPawnshopRiskById(id));
    }

    /**
     * 新增典当行风险情况
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopRisk:add')")
    @Log(title = "典当行风险情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PawnshopRisk pawnshopRisk)
    {
        return toAjax(pawnshopRiskService.insertPawnshopRisk(pawnshopRisk));
    }

    /**
     * 修改典当行风险情况
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopRisk:edit')")
    @Log(title = "典当行风险情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PawnshopRisk pawnshopRisk)
    {
        return toAjax(pawnshopRiskService.updatePawnshopRisk(pawnshopRisk));
    }

    /**
     * 删除典当行风险情况
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshopRisk:remove')")
    @Log(title = "典当行风险情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pawnshopRiskService.deletePawnshopRiskByIds(ids));
    }
}
