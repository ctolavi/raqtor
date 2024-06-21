package dev.ctolavi.resources.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;

@ApplicationScoped
public class Mapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public <T> T map(Object source, Class<T> destinationClass) {
        return modelMapper.map(source, destinationClass);
    }
    public <T> T map(Object source, Type destination) {
        return modelMapper.map(source, destination);
    }
}
