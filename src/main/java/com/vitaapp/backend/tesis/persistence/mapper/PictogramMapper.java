package com.vitaapp.backend.tesis.persistence.mapper;

import com.vitaapp.backend.tesis.domain.Pictogram;
import com.vitaapp.backend.tesis.persistence.entity.Pictograma;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PictogramMapper {

    @Mappings({
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "imagenURL", target = "imageURL"),
            @Mapping(source = "idSubcategoria", target = "subcategoryId"),
    })
    Pictogram toPictogram(Pictograma pictograma);

    List<Pictogram> toPictograms(List<Pictograma> pictogramas);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "subcategoria", ignore = true)
    })
    Pictograma toPictograma(Pictogram pictogram);
}