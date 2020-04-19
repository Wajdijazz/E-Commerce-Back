package com.ECommerce.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

public interface CanvasjsChartDao {

	List<List<Map<Object, Object>>> getCanvasjsChartData();

}
