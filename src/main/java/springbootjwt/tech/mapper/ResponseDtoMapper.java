package springbootjwt.tech.mapper;

public interface ResponseDtoMapper<T, R> {
    T mapToDto(R r);
}
