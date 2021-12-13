package spring_boot_jwt.tech1.mapper;

public interface ResponseDtoMapper<T, R> {
    T mapToDto(R r);
}
