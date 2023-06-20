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
import com.ruoyi.financial.domain.FinancingGuaranteeInfo;
import com.ruoyi.financial.service.IFinancingGuaranteeInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 融资担保公司基本情况Controller
 * 
 * @author xmx
 * @date 2023-06-12
 */
@RestController
@RequestMapping("/financial/financingGuaranteeInfo")
public class FinancingGuaranteeInfoController extends BaseController
{
    @Autowired
    private IFinancingGuaranteeInfoService financingGuaranteeInfoService;

    /**
     * 查询融资担保公司基本情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(FinancingGuaranteeInfo financingGuaranteeInfo)
    {
        startPage();
        List<FinancingGuaranteeInfo> list = financingGuaranteeInfoService.selectFinancingGuaranteeInfoList(financingGuaranteeInfo);
        return getDataTable(list);
    }

    /**
     * 导出融资担保公司基本情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeInfo:export')")
    @Log(title = "融资担保公司基本情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FinancingGuaranteeInfo financingGuaranteeInfo)
    {
        List<FinancingGuaranteeInfo> list = financingGuaranteeInfoService.selectFinancingGuaranteeInfoList(financingGuaranteeInfo);
        ExcelUtil<FinancingGuaranteeInfo> util = new ExcelUtil<FinancingGuaranteeInfo>(FinancingGuaranteeInfo.class);
        util.exportExcel(response, list, "融资担保公司基本情况数据");
    }

    /**
     * 获取融资担保公司基本情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(financingGuaranteeInfoService.selectFinancingGuaranteeInfoById(id));
    }

    /**
     * 新增融资担保公司基本情况
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeInfo:add')")
    @Log(title = "融资担保公司基本情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FinancingGuaranteeInfo financingGuaranteeInfo)
    {
        return toAjax(financingGuaranteeInfoService.insertFinancingGuaranteeInfo(financingGuaranteeInfo));
    }

    /**
     * 修改融资担保公司基本情况
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeInfo:edit')")
    @Log(title = "融资担保公司基本情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FinancingGuaranteeInfo financingGuaranteeInfo)
    {
        return toAjax(financingGuaranteeInfoService.updateFinancingGuaranteeInfo(financingGuaranteeInfo));
    }

    /**
     * 删除融资担保公司基本情况
     */
    @PreAuthorize("@ss.hasPermi('financial:financingGuaranteeInfo:remove')")
    @Log(title = "融资担保公司基本情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(financingGuaranteeInfoService.deleteFinancingGuaranteeInfoByIds(ids));
    }
}
