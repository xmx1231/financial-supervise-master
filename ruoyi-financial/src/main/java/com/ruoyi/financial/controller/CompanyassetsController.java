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
import com.ruoyi.financial.domain.Companyassets;
import com.ruoyi.financial.service.ICompanyassetsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 企业资产状况Controller
 * 
 * @author xmx
 * @date 2023-06-12
 */
@RestController
@RequestMapping("/financial/companyassets")
public class CompanyassetsController extends BaseController
{
    @Autowired
    private ICompanyassetsService companyassetsService;

    /**
     * 查询企业资产状况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:companyassets:list')")
    @GetMapping("/list")
    public TableDataInfo list(Companyassets companyassets)
    {
        startPage();
        List<Companyassets> list = companyassetsService.selectCompanyassetsList(companyassets);
        return getDataTable(list);
    }

    /**
     * 导出企业资产状况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:companyassets:export')")
    @Log(title = "企业资产状况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Companyassets companyassets)
    {
        List<Companyassets> list = companyassetsService.selectCompanyassetsList(companyassets);
        ExcelUtil<Companyassets> util = new ExcelUtil<Companyassets>(Companyassets.class);
        util.exportExcel(response, list, "企业资产状况数据");
    }

    /**
     * 获取企业资产状况详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:companyassets:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(companyassetsService.selectCompanyassetsById(id));
    }

    /**
     * 新增企业资产状况
     */
    @PreAuthorize("@ss.hasPermi('financial:companyassets:add')")
    @Log(title = "企业资产状况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Companyassets companyassets)
    {
        return toAjax(companyassetsService.insertCompanyassets(companyassets));
    }

    /**
     * 修改企业资产状况
     */
    @PreAuthorize("@ss.hasPermi('financial:companyassets:edit')")
    @Log(title = "企业资产状况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Companyassets companyassets)
    {
        return toAjax(companyassetsService.updateCompanyassets(companyassets));
    }

    /**
     * 删除企业资产状况
     */
    @PreAuthorize("@ss.hasPermi('financial:companyassets:remove')")
    @Log(title = "企业资产状况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(companyassetsService.deleteCompanyassetsByIds(ids));
    }
}
