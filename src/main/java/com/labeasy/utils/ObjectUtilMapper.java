package com.labeasy.utils;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Nasruddin
 */
public final class ObjectUtilMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT).setPropertyCondition(Conditions.isNotNull());
    }

    private ObjectUtilMapper() {
        super();
    }

    /**
     *
     * @param source
     * @param destination
     * @param <S>
     * @param <D>
     * @return
     */
    public static <S, D> D map(final S source, Class<D> destination) {
        return modelMapper.map(source, destination);
    }

    /**
     *
     * @param source
     * @param destination
     * @param <S>
     * @param <D>
     * @return
     */
    public static <S, D> List<D> mapAll(final List<S> source, Class<D> destination) {
        return source.stream().map(m -> map(m, destination)).collect(Collectors.toList());
    }
}
