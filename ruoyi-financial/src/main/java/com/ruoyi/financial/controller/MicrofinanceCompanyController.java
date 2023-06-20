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
import com.ruoyi.financial.domain.MicrofinanceCompany;
import com.ruoyi.financial.service.IMicrofinanceCompanyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 小贷公司经营情况Controller
 * 
 * @author xmx
 * @date 2023-06-12
 */
@RestController
@RequestMapping("/financial/microfinanceCompany")
public class MicrofinanceCompanyController extends BaseController
{
    @Autowired
    private IMicrofinanceCompanyService microfinanceCompanyService;

    /**
     * 查询小贷公司经营情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompany:list')")
    @GetMapping("/list")
    public TableDataInfo list(MicrofinanceCompany microfinanceCompany)
    {
        startPage();
        List<MicrofinanceCompany> list = microfinanceCompanyService.selectMicrofinanceCompanyList(microfinanceCompany);
        return getDataTable(list);
    }

    /**
     * 导出小贷公司经营情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompany:export')")
    @Log(title = "小贷公司经营情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MicrofinanceCompany microfinanceCompany)
    {
        List<MicrofinanceCompany> list = microfinanceCompanyService.selectMicrofinanceCompanyList(microfinanceCompany);
        ExcelUtil<MicrofinanceCompany> util = new ExcelUtil<MicrofinanceCompany>(MicrofinanceCompany.class);
        util.exportExcel(response, list, "小贷公司经营情况数据");
    }

    /**
     * 获取小贷公司经营情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompany:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(microfinanceCompanyService.selectMicrofinanceCompanyById(id));
    }

    /**
     * 新增小贷公司经营情况
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompany:add')")
    @Log(title = "小贷公司经营情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MicrofinanceCompany microfinanceCompany)
    {
        return toAjax(microfinanceCompanyService.insertMicrofinanceCompany(microfinanceCompany));
    }

    /**
     * 修改小贷公司经营情况
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompany:edit')")
    @Log(title = "小贷公司经营情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MicrofinanceCompany microfinanceCompany)
    {
        return toAjax(microfinanceCompanyService.updateMicrofinanceCompany(microfinanceCompany));
    }

    /**
     * 删除小贷公司经营情况
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompany:remove')")
    @Log(title = "小贷公司经营情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(microfinanceCompanyService.deleteMicrofinanceCompanyByIds(ids));
    }
}
