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
import com.ruoyi.financial.domain.FinancingGuarantee;
import com.ruoyi.financial.service.IFinancingGuaranteeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 融资担保公司经营情况Controller
 * 
 * @author xmx
 * @date 2023-06-12
 */
@RestController
@RequestMapping("/financial/financingGuarantee")
public class FinancingGuaranteeController extends BaseController
{
    @Autowired
    private IFinancingGuaranteeService financingGuaranteeService;

    /**
     * 查询融资担保公司经营情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuarantee:list')")
    @GetMapping("/list")
    public TableDataInfo list(FinancingGuarantee financingGuarantee)
    {
        startPage();
        List<FinancingGuarantee> list = financingGuaranteeService.selectFinancingGuaranteeList(financingGuarantee);
        return getDataTable(list);
    }

    /**
     * 导出融资担保公司经营情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuarantee:export')")
    @Log(title = "融资担保公司经营情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FinancingGuarantee financingGuarantee)
    {
        List<FinancingGuarantee> list = financingGuaranteeService.selectFinancingGuaranteeList(financingGuarantee);
        ExcelUtil<FinancingGuarantee> util = new ExcelUtil<FinancingGuarantee>(FinancingGuarantee.class);
        util.exportExcel(response, list, "融资担保公司经营情况数据");
    }

    /**
     * 获取融资担保公司经营情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuarantee:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(financingGuaranteeService.selectFinancingGuaranteeById(id));
    }

    /**
     * 新增融资担保公司经营情况
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuarantee:add')")
    @Log(title = "融资担保公司经营情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FinancingGuarantee financingGuarantee)
    {
        return toAjax(financingGuaranteeService.insertFinancingGuarantee(financingGuarantee));
    }

    /**
     * 修改融资担保公司经营情况
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuarantee:edit')")
    @Log(title = "融资担保公司经营情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FinancingGuarantee financingGuarantee)
    {
        return toAjax(financingGuaranteeService.updateFinancingGuarantee(financingGuarantee));
    }

    /**
     * 删除融资担保公司经营情况
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuarantee:remove')")
    @Log(title = "融资担保公司经营情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(financingGuaranteeService.deleteFinancingGuaranteeByIds(ids));
    }
}
