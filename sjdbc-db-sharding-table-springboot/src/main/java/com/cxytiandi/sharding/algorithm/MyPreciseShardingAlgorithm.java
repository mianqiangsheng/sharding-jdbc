package com.cxytiandi.sharding.algorithm;

import java.util.Collection;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

/**
 * 自定义分片算法
 * 
 * @author yinjihuan
 *
 */
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
		for (String tableName : availableTargetNames) {
			if (tableName.endsWith(shardingValue.getValue() % 4 + "")) {
				return tableName;
			}
		}
		/**
		 * 如果可选的表没有一个满足分片规则的，则抛出异常，这里库只有ds0,ds1，当id是3时，ds0,ds1均不满足，则抛出异常
		 */
		throw new IllegalArgumentException();
	}

}
