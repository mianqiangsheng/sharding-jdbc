package com.cxytiandi.sharding.algorithm;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author ：li zhen
 * @description:
 * @date ：2022/1/19 16:02
 */
public class MyRangeTableShardingAlgoithm implements RangeShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection collection, RangeShardingValue rangeShardingValue) {
        return Arrays.asList("user_0");
    }
}
