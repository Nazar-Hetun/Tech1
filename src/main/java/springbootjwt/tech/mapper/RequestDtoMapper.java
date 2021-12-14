package springbootjwt.tech.mapper;

public interface RequestDtoMapper<T, R> {
    R mapToModel(T dto);
}
