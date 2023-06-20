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
import com.ruoyi.financial.domain.FinancingGuaranteeRisk;
import com.ruoyi.financial.service.IFinancingGuaranteeRiskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 融资担保公司风险情况Controller
 * 
 * @author xmx
 * @date 2023-06-12
 */
@RestController
@RequestMapping("/financial/financingGuaranteeRisk")
public class FinancingGuaranteeRiskController extends BaseController
{
    @Autowired
    private IFinancingGuaranteeRiskService financingGuaranteeRiskService;

    /**
     * 查询融资担保公司风险情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeRisk:list')")
    @GetMapping("/list")
    public TableDataInfo list(FinancingGuaranteeRisk financingGuaranteeRisk)
    {
        startPage();
        List<FinancingGuaranteeRisk> list = financingGuaranteeRiskService.selectFinancingGuaranteeRiskList(financingGuaranteeRisk);
        return getDataTable(list);
    }

    /**
     * 导出融资担保公司风险情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeRisk:export')")
    @Log(title = "融资担保公司风险情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FinancingGuaranteeRisk financingGuaranteeRisk)
    {
        List<FinancingGuaranteeRisk> list = financingGuaranteeRiskService.selectFinancingGuaranteeRiskList(financingGuaranteeRisk);
        ExcelUtil<FinancingGuaranteeRisk> util = new ExcelUtil<FinancingGuaranteeRisk>(FinancingGuaranteeRisk.class);
        util.exportExcel(response, list, "融资担保公司风险情况数据");
    }

    /**
     * 获取融资担保公司风险情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeRisk:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(financingGuaranteeRiskService.selectFinancingGuaranteeRiskById(id));
    }

    /**
     * 新增融资担保公司风险情况
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeRisk:add')")
    @Log(title = "融资担保公司风险情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FinancingGuaranteeRisk financingGuaranteeRisk)
    {
        return toAjax(financingGuaranteeRiskService.insertFinancingGuaranteeRisk(financingGuaranteeRisk));
    }

    /**
     * 修改融资担保公司风险情况
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeRisk:edit')")
    @Log(title = "融资担保公司风险情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FinancingGuaranteeRisk financingGuaranteeRisk)
    {
        return toAjax(financingGuaranteeRiskService.updateFinancingGuaranteeRisk(financingGuaranteeRisk));
    }

    /**
     * 删除融资担保公司风险情况
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeRisk:remove')")
    @Log(title = "融资担保公司风险情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(financingGuaranteeRiskService.deleteFinancingGuaranteeRiskByIds(ids));
    }
}
