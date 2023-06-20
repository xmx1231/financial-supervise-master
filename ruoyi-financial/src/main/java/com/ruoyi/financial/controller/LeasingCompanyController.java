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
import com.ruoyi.financial.domain.LeasingCompany;
import com.ruoyi.financial.service.ILeasingCompanyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 融资租赁经营情况Controller
 * 
 * @author xmx
 * @date 2023-06-12
 */
@RestController
@RequestMapping("/financial/leasingCompany")
public class LeasingCompanyController extends BaseController
{
    @Autowired
    private ILeasingCompanyService leasingCompanyService;

    /**
     * 查询融资租赁经营情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:leasingCompany:list')")
    @GetMapping("/list")
    public TableDataInfo list(LeasingCompany leasingCompany)
    {
        startPage();
        List<LeasingCompany> list = leasingCompanyService.selectLeasingCompanyList(leasingCompany);
        return getDataTable(list);
    }

    /**
     * 导出融资租赁经营情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:leasingCompany:export')")
    @Log(title = "融资租赁经营情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LeasingCompany leasingCompany)
    {
        List<LeasingCompany> list = leasingCompanyService.selectLeasingCompanyList(leasingCompany);
        ExcelUtil<LeasingCompany> util = new ExcelUtil<LeasingCompany>(LeasingCompany.class);
        util.exportExcel(response, list, "融资租赁经营情况数据");
    }

    /**
     * 获取融资租赁经营情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:leasingCompany:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(leasingCompanyService.selectLeasingCompanyById(id));
    }

    /**
     * 新增融资租赁经营情况
     */
    @PreAuthorize("@ss.hasPermi('financial:leasingCompany:add')")
    @Log(title = "融资租赁经营情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LeasingCompany leasingCompany)
    {
        return toAjax(leasingCompanyService.insertLeasingCompany(leasingCompany));
    }

    /**
     * 修改融资租赁经营情况
     */
    @PreAuthorize("@ss.hasPermi('financial:leasingCompany:edit')")
    @Log(title = "融资租赁经营情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LeasingCompany leasingCompany)
    {
        return toAjax(leasingCompanyService.updateLeasingCompany(leasingCompany));
    }

    /**
     * 删除融资租赁经营情况
     */
    @PreAuthorize("@ss.hasPermi('financial:leasingCompany:remove')")
    @Log(title = "融资租赁经营情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(leasingCompanyService.deleteLeasingCompanyByIds(ids));
    }
}
