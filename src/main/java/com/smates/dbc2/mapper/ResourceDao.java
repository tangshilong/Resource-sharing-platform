package com.smates.dbc2.mapper;

import java.util.List;

import com.smates.dbc2.po.Resource;
import com.smates.dbc2.vo.CostumResource;

public interface ResourceDao {
	
	/**
	 * 查找某一类资源
	 * @return
	 */
	public List<Resource> getResourceByType(CostumResource costumResource); 
	
	/**
	 * 符合条件的记录个数
	 * @param costumResource
	 * @return
	 */
	public int countSum(CostumResource costumResource);
	
}
