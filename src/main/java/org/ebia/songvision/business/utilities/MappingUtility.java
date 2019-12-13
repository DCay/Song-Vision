package org.ebia.songvision.business.utilities;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public final class MappingUtility {
    private final ModelMapper modelMapper;

    @Autowired
    public MappingUtility(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T> List<T> map(List collection, Class<T> targetType)  {
        return (List<T>) collection
                .stream()
                .map(el -> this.modelMapper.map(el, targetType))
                .collect(Collectors.toUnmodifiableList());
    }

    public <T> Collection<T> map(Collection collection, Class<T> targetType)  {
        return (Collection<T>) collection
                .stream()
                .map(el -> this.modelMapper.map(el, targetType))
                .collect(Collectors.toUnmodifiableList());
    }

    public <T> T map(Object object, Class<T> targetType) {
        return (T) this.modelMapper.map(object, targetType);
    }
}
