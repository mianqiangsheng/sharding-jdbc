package com.cxytiandi.sharding.algorithm;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * 库和表可以共用一个RangeShardingAlgorithm，这里因为写死所以分了2个/或者分库和分表规则不一样可以分开写
 * @author ：li zhen
 * @description:
 * @date ：2022/1/19 16:02
 */
public class MyRangeDatabaseShardingAlgoithm implements RangeShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection collection, RangeShardingValue rangeShardingValue) {
        return Arrays.asList("ds0");
    }
}
