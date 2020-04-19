package com.ECommerce.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ECommerce.Dto.CanvasjsChartData;
@Component
public class CanvasjsChartDaoImpl implements CanvasjsChartDao {

	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		return CanvasjsChartData.getCanvasjsDataList();
	}
}