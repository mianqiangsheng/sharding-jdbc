package com.cxytiandi.sharding.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import com.cxytiandi.sharding.config.ShardingRangeConfig;

/**
 * 自定义分片算法
 *
 * 考虑到后期扩容数据迁移，最好是使用一致性hash算法来定位数据的分库分表位置，可以最大限度降低迁移涉及的库和表
 * 
 * @author yinjihuan
 *
 */
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

	private static List<ShardingRangeConfig> configs = new ArrayList<>();
	
	static {
		ShardingRangeConfig config = new ShardingRangeConfig();
		config.setStart(1);
		config.setEnd(30);
		config.setDatasourceList(Arrays.asList("ds0", "ds1"));
		configs.add(config);
		
		config = new ShardingRangeConfig();
		config.setStart(31);
		config.setEnd(60);
		config.setDatasourceList(Arrays.asList("dss0", "dss1"));
		configs.add(config);
	}

	/**
	 * 针对id从1-30的记录全部只存入ds0、ds1，31-60的记录存入到dss0、dss1....（这里实际情况可能id范围 1-100万）
	 * 预先估计好未来几年的数据量，一次性建立好库，避免后面扩容迁移数据
	 */
	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
		Optional<ShardingRangeConfig> configOptional = configs.stream().filter(
				c -> shardingValue.getValue() >= c.getStart() && shardingValue.getValue() <= c.getEnd()).findFirst();
		if (configOptional.isPresent()) {
			ShardingRangeConfig rangeConfig = configOptional.get();
			for (String ds : rangeConfig.getDatasourceList()) {
				if (ds.endsWith(shardingValue.getValue() % 2 + "")) {
					System.err.println(ds);
					return ds;
				}
			}
		}
		throw new IllegalArgumentException();
	}

}
