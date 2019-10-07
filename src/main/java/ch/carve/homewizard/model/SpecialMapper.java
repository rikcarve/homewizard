package ch.carve.homewizard.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface SpecialMapper {
    @Mapping(target = "maxTemperatur", source = "teMax", defaultValue = "1f")
    @Mapping(target = "name", source = "name", defaultValue = "blabla")
    public Special map(TemperaturSensor sensor);
}
