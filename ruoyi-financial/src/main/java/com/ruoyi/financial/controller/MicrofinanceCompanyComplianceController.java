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
import com.ruoyi.financial.domain.MicrofinanceCompanyCompliance;
import com.ruoyi.financial.service.IMicrofinanceCompanyComplianceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 小贷公司合规情况Controller
 * 
 * @author xmx
 * @date 2023-06-12
 */
@RestController
@RequestMapping("/financial/microfinanceCompanyCompliance")
public class MicrofinanceCompanyComplianceController extends BaseController
{
    @Autowired
    private IMicrofinanceCompanyComplianceService microfinanceCompanyComplianceService;

    /**
     * 查询小贷公司合规情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyCompliance:list')")
    @GetMapping("/list")
    public TableDataInfo list(MicrofinanceCompanyCompliance microfinanceCompanyCompliance)
    {
        startPage();
        List<MicrofinanceCompanyCompliance> list = microfinanceCompanyComplianceService.selectMicrofinanceCompanyComplianceList(microfinanceCompanyCompliance);
        return getDataTable(list);
    }

    /**
     * 导出小贷公司合规情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyCompliance:export')")
    @Log(title = "小贷公司合规情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MicrofinanceCompanyCompliance microfinanceCompanyCompliance)
    {
        List<MicrofinanceCompanyCompliance> list = microfinanceCompanyComplianceService.selectMicrofinanceCompanyComplianceList(microfinanceCompanyCompliance);
        ExcelUtil<MicrofinanceCompanyCompliance> util = new ExcelUtil<MicrofinanceCompanyCompliance>(MicrofinanceCompanyCompliance.class);
        util.exportExcel(response, list, "小贷公司合规情况数据");
    }

    /**
     * 获取小贷公司合规情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyCompliance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(microfinanceCompanyComplianceService.selectMicrofinanceCompanyComplianceById(id));
    }

    /**
     * 新增小贷公司合规情况
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyCompliance:add')")
    @Log(title = "小贷公司合规情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MicrofinanceCompanyCompliance microfinanceCompanyCompliance)
    {
        return toAjax(microfinanceCompanyComplianceService.insertMicrofinanceCompanyCompliance(microfinanceCompanyCompliance));
    }

    /**
     * 修改小贷公司合规情况
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyCompliance:edit')")
    @Log(title = "小贷公司合规情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MicrofinanceCompanyCompliance microfinanceCompanyCompliance)
    {
        return toAjax(microfinanceCompanyComplianceService.updateMicrofinanceCompanyCompliance(microfinanceCompanyCompliance));
    }

    /**
     * 删除小贷公司合规情况
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyCompliance:remove')")
    @Log(title = "小贷公司合规情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(microfinanceCompanyComplianceService.deleteMicrofinanceCompanyComplianceByIds(ids));
    }
}
