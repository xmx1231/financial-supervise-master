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
import com.ruoyi.financial.domain.FactoringCompany;
import com.ruoyi.financial.service.IFactoringCompanyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商业保理公司经营情况Controller
 * 
 * @author xmx
 * @date 2023-06-12
 */
@RestController
@RequestMapping("/financial/factoringCompany")
public class FactoringCompanyController extends BaseController
{
    @Autowired
    private IFactoringCompanyService factoringCompanyService;

    /**
     * 查询商业保理公司经营情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:factoringCompany:list')")
    @GetMapping("/list")
    public TableDataInfo list(FactoringCompany factoringCompany)
    {
        startPage();
        List<FactoringCompany> list = factoringCompanyService.selectFactoringCompanyList(factoringCompany);
        return getDataTable(list);
    }

    /**
     * 导出商业保理公司经营情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:factoringCompany:export')")
    @Log(title = "商业保理公司经营情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FactoringCompany factoringCompany)
    {
        List<FactoringCompany> list = factoringCompanyService.selectFactoringCompanyList(factoringCompany);
        ExcelUtil<FactoringCompany> util = new ExcelUtil<FactoringCompany>(FactoringCompany.class);
        util.exportExcel(response, list, "商业保理公司经营情况数据");
    }

    /**
     * 获取商业保理公司经营情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:factoringCompany:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(factoringCompanyService.selectFactoringCompanyById(id));
    }

    /**
     * 新增商业保理公司经营情况
     */
    @PreAuthorize("@ss.hasPermi('financial:factoringCompany:add')")
    @Log(title = "商业保理公司经营情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FactoringCompany factoringCompany)
    {
        return toAjax(factoringCompanyService.insertFactoringCompany(factoringCompany));
    }

    /**
     * 修改商业保理公司经营情况
     */
    @PreAuthorize("@ss.hasPermi('financial:factoringCompany:edit')")
    @Log(title = "商业保理公司经营情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FactoringCompany factoringCompany)
    {
        return toAjax(factoringCompanyService.updateFactoringCompany(factoringCompany));
    }

    /**
     * 删除商业保理公司经营情况
     */
    @PreAuthorize("@ss.hasPermi('financial:factoringCompany:remove')")
    @Log(title = "商业保理公司经营情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(factoringCompanyService.deleteFactoringCompanyByIds(ids));
    }
}
