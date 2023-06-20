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
import com.ruoyi.financial.domain.MicrofinanceCompanyInfo;
import com.ruoyi.financial.service.IMicrofinanceCompanyInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 小贷公司基本情况Controller
 * 
 * @author xmx
 * @date 2023-06-12
 */
@RestController
@RequestMapping("/financial/microfinanceCompanyInfo")
public class MicrofinanceCompanyInfoController extends BaseController
{
    @Autowired
    private IMicrofinanceCompanyInfoService microfinanceCompanyInfoService;

    /**
     * 查询小贷公司基本情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(MicrofinanceCompanyInfo microfinanceCompanyInfo)
    {
        startPage();
        List<MicrofinanceCompanyInfo> list = microfinanceCompanyInfoService.selectMicrofinanceCompanyInfoList(microfinanceCompanyInfo);
        return getDataTable(list);
    }

    /**
     * 导出小贷公司基本情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyInfo:export')")
    @Log(title = "小贷公司基本情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MicrofinanceCompanyInfo microfinanceCompanyInfo)
    {
        List<MicrofinanceCompanyInfo> list = microfinanceCompanyInfoService.selectMicrofinanceCompanyInfoList(microfinanceCompanyInfo);
        ExcelUtil<MicrofinanceCompanyInfo> util = new ExcelUtil<MicrofinanceCompanyInfo>(MicrofinanceCompanyInfo.class);
        util.exportExcel(response, list, "小贷公司基本情况数据");
    }

    /**
     * 获取小贷公司基本情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(microfinanceCompanyInfoService.selectMicrofinanceCompanyInfoById(id));
    }

    /**
     * 新增小贷公司基本情况
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyInfo:add')")
    @Log(title = "小贷公司基本情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MicrofinanceCompanyInfo microfinanceCompanyInfo)
    {
        return toAjax(microfinanceCompanyInfoService.insertMicrofinanceCompanyInfo(microfinanceCompanyInfo));
    }

    /**
     * 修改小贷公司基本情况
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyInfo:edit')")
    @Log(title = "小贷公司基本情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MicrofinanceCompanyInfo microfinanceCompanyInfo)
    {
        return toAjax(microfinanceCompanyInfoService.updateMicrofinanceCompanyInfo(microfinanceCompanyInfo));
    }

    /**
     * 删除小贷公司基本情况
     */
    @PreAuthorize("@ss.hasPermi('financial:microfinanceCompanyInfo:remove')")
    @Log(title = "小贷公司基本情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(microfinanceCompanyInfoService.deleteMicrofinanceCompanyInfoByIds(ids));
    }
}
