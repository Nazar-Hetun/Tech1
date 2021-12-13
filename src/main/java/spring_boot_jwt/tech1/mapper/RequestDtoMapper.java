package spring_boot_jwt.tech1.mapper;

public interface RequestDtoMapper<T, R> {
    R mapToModel(T dto);
}
