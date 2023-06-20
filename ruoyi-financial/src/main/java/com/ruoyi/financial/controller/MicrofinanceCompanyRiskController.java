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
import com.ruoyi.financial.domain.MicrofinanceCompanyRisk;
import com.ruoyi.financial.service.IMicrofinanceCompanyRiskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 小贷公司风险情况Controller
 * 
 * @author xmx
 * @date 2023-06-12
 */
@RestController
@RequestMapping("/financial/microfinanceCompanyRisk")
public class MicrofinanceCompanyRiskController extends BaseController
{
    @Autowired
    private IMicrofinanceCompanyRiskService microfinanceCompanyRiskService;

    /**
     * 查询小贷公司风险情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyRisk:list')")
    @GetMapping("/list")
    public TableDataInfo list(MicrofinanceCompanyRisk microfinanceCompanyRisk)
    {
        startPage();
        List<MicrofinanceCompanyRisk> list = microfinanceCompanyRiskService.selectMicrofinanceCompanyRiskList(microfinanceCompanyRisk);
        return getDataTable(list);
    }

    /**
     * 导出小贷公司风险情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyRisk:export')")
    @Log(title = "小贷公司风险情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MicrofinanceCompanyRisk microfinanceCompanyRisk)
    {
        List<MicrofinanceCompanyRisk> list = microfinanceCompanyRiskService.selectMicrofinanceCompanyRiskList(microfinanceCompanyRisk);
        ExcelUtil<MicrofinanceCompanyRisk> util = new ExcelUtil<MicrofinanceCompanyRisk>(MicrofinanceCompanyRisk.class);
        util.exportExcel(response, list, "小贷公司风险情况数据");
    }

    /**
     * 获取小贷公司风险情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyRisk:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(microfinanceCompanyRiskService.selectMicrofinanceCompanyRiskById(id));
    }

    /**
     * 新增小贷公司风险情况
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyRisk:add')")
    @Log(title = "小贷公司风险情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MicrofinanceCompanyRisk microfinanceCompanyRisk)
    {
        return toAjax(microfinanceCompanyRiskService.insertMicrofinanceCompanyRisk(microfinanceCompanyRisk));
    }

    /**
     * 修改小贷公司风险情况
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyRisk:edit')")
    @Log(title = "小贷公司风险情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MicrofinanceCompanyRisk microfinanceCompanyRisk)
    {
        return toAjax(microfinanceCompanyRiskService.updateMicrofinanceCompanyRisk(microfinanceCompanyRisk));
    }

    /**
     * 删除小贷公司风险情况
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyRisk:remove')")
    @Log(title = "小贷公司风险情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(microfinanceCompanyRiskService.deleteMicrofinanceCompanyRiskByIds(ids));
    }
}
