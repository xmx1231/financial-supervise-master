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
import com.ruoyi.financial.domain.Company;
import com.ruoyi.financial.service.ICompanyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公司信息管理Controller
 * 
 * @author xmx
 * @date 2023-06-09
 */
@RestController
@RequestMapping("/financial/company")
public class CompanyController extends BaseController
{
    @Autowired
    private ICompanyService companyService;

    /**
     * 查询公司信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('financial:company:list')")
    @GetMapping("/list")
    public TableDataInfo list(Company company)
    {
        startPage();
        List<Company> list = companyService.selectCompanyList(company);
        return getDataTable(list);
    }

    /**
     * 导出公司信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('financial:company:export')")
    @Log(title = "公司信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Company company)
    {
        List<Company> list = companyService.selectCompanyList(company);
        ExcelUtil<Company> util = new ExcelUtil<Company>(Company.class);
        util.exportExcel(response, list, "公司信息管理数据");
    }

    /**
     * 获取公司信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:company:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(companyService.selectCompanyById(id));
    }

    /**
     * 新增公司信息管理
     */
    @PreAuthorize("@ss.hasPermi('financial:company:add')")
    @Log(title = "公司信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Company company)
    {
        return toAjax(companyService.insertCompany(company));
    }

    /**
     * 修改公司信息管理
     */
    @PreAuthorize("@ss.hasPermi('financial:company:edit')")
    @Log(title = "公司信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Company company)
    {
        return toAjax(companyService.updateCompany(company));
    }

    /**
     * 删除公司信息管理
     */
    @PreAuthorize("@ss.hasPermi('financial:company:remove')")
    @Log(title = "公司信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(companyService.deleteCompanyByIds(ids));
    }
}
