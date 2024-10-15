package org.example.demo.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostConvert {
    PostConvert INSTANCE = Mappers.getMapper(PostConvert.class);
}
