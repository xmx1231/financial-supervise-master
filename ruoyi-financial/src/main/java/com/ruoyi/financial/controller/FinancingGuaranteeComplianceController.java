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
import com.ruoyi.financial.domain.FinancingGuaranteeCompliance;
import com.ruoyi.financial.service.IFinancingGuaranteeComplianceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 融资担保公司合规情况Controller
 * 
 * @author xmx
 * @date 2023-06-12
 */
@RestController
@RequestMapping("/financial/financingGuaranteeCompliance")
public class FinancingGuaranteeComplianceController extends BaseController
{
    @Autowired
    private IFinancingGuaranteeComplianceService financingGuaranteeComplianceService;

    /**
     * 查询融资担保公司合规情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeCompliance:list')")
    @GetMapping("/list")
    public TableDataInfo list(FinancingGuaranteeCompliance financingGuaranteeCompliance)
    {
        startPage();
        List<FinancingGuaranteeCompliance> list = financingGuaranteeComplianceService.selectFinancingGuaranteeComplianceList(financingGuaranteeCompliance);
        return getDataTable(list);
    }

    /**
     * 导出融资担保公司合规情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeCompliance:export')")
    @Log(title = "融资担保公司合规情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FinancingGuaranteeCompliance financingGuaranteeCompliance)
    {
        List<FinancingGuaranteeCompliance> list = financingGuaranteeComplianceService.selectFinancingGuaranteeComplianceList(financingGuaranteeCompliance);
        ExcelUtil<FinancingGuaranteeCompliance> util = new ExcelUtil<FinancingGuaranteeCompliance>(FinancingGuaranteeCompliance.class);
        util.exportExcel(response, list, "融资担保公司合规情况数据");
    }

    /**
     * 获取融资担保公司合规情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeCompliance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(financingGuaranteeComplianceService.selectFinancingGuaranteeComplianceById(id));
    }

    /**
     * 新增融资担保公司合规情况
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeCompliance:add')")
    @Log(title = "融资担保公司合规情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FinancingGuaranteeCompliance financingGuaranteeCompliance)
    {
        return toAjax(financingGuaranteeComplianceService.insertFinancingGuaranteeCompliance(financingGuaranteeCompliance));
    }

    /**
     * 修改融资担保公司合规情况
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeCompliance:edit')")
    @Log(title = "融资担保公司合规情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FinancingGuaranteeCompliance financingGuaranteeCompliance)
    {
        return toAjax(financingGuaranteeComplianceService.updateFinancingGuaranteeCompliance(financingGuaranteeCompliance));
    }

    /**
     * 删除融资担保公司合规情况
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeCompliance:remove')")
    @Log(title = "融资担保公司合规情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(financingGuaranteeComplianceService.deleteFinancingGuaranteeComplianceByIds(ids));
    }
}
