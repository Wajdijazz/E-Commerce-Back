package com.ECommerce.controller;

import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ECommerce.service.CanvasjsChartServiceImpl;
import com.ECommerce.util.Routes;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(Routes.CHART)
@AllArgsConstructor
public class CanvasjsChartController {
	
	private CanvasjsChartServiceImpl canvasjsChartService;
 
    @GetMapping("/")
	public List<List<Map<Object, Object>>> getChartData() {
		return  canvasjsChartService.getCanvasjsChartData();
	}

}
