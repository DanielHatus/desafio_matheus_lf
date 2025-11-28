package com.example.desafio.utils.pageable.interfaces;

import org.springframework.data.domain.Pageable;

public interface PageableGenerator {
    public Pageable generatePageable(Integer page,Integer size,String order,String direction);

}
