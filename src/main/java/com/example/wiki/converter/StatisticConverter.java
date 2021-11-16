package com.example.wiki.converter;

import com.example.wiki.domain.Statistic;
import com.example.wiki.response.StatisticResponse;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * @author 付海鑫
 * @date 2021年11月16日 11:56
 */
@Mapper(componentModel = "spring")
public interface StatisticConverter {
  StatisticResponse do2Vo(Statistic var1);

  List<StatisticResponse> do2voList(List<Statistic> userList);
}
