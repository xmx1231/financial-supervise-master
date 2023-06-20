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
import com.ruoyi.financial.domain.Pawnshop;
import com.ruoyi.financial.service.IPawnshopService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 典当行经营情况Controller
 * 
 * @author xmx
 * @date 2023-06-12
 */
@RestController
@RequestMapping("/financial/pawnshop")
public class PawnshopController extends BaseController
{
    @Autowired
    private IPawnshopService pawnshopService;

    /**
     * 查询典当行经营情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshop:list')")
    @GetMapping("/list")
    public TableDataInfo list(Pawnshop pawnshop)
    {
        startPage();
        List<Pawnshop> list = pawnshopService.selectPawnshopList(pawnshop);
        return getDataTable(list);
    }

    /**
     * 导出典当行经营情况列表
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshop:export')")
    @Log(title = "典当行经营情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Pawnshop pawnshop)
    {
        List<Pawnshop> list = pawnshopService.selectPawnshopList(pawnshop);
        ExcelUtil<Pawnshop> util = new ExcelUtil<Pawnshop>(Pawnshop.class);
        util.exportExcel(response, list, "典当行经营情况数据");
    }

    /**
     * 获取典当行经营情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshop:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pawnshopService.selectPawnshopById(id));
    }

    /**
     * 新增典当行经营情况
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshop:add')")
    @Log(title = "典当行经营情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Pawnshop pawnshop)
    {
        return toAjax(pawnshopService.insertPawnshop(pawnshop));
    }

    /**
     * 修改典当行经营情况
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshop:edit')")
    @Log(title = "典当行经营情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Pawnshop pawnshop)
    {
        return toAjax(pawnshopService.updatePawnshop(pawnshop));
    }

    /**
     * 删除典当行经营情况
     */
    @PreAuthorize("@ss.hasPermi('financial:pawnshop:remove')")
    @Log(title = "典当行经营情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pawnshopService.deletePawnshopByIds(ids));
    }
}
