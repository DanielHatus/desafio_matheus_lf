package com.example.desafio.utils.pageable.implementations.user;

import com.example.desafio.utils.pageable.logic.default_.PageableLogicDefault;
import com.example.desafio.utils.pageable.fields.name.get.use.reflect.user.FieldsNameUser;
import com.example.desafio.utils.pageable.interfaces.PageableGenerator;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ImplementPageableUser implements PageableGenerator {
    private final PageableLogicDefault logicDefault;
    private final FieldsNameUser instance=FieldsNameUser.getInstance();

    public ImplementPageableUser(PageableLogicDefault logicDefault) {
        this.logicDefault = logicDefault;
    }

    @Override
    public Pageable generatePageable(Integer page, Integer size, String order, String direction) {
       return this.logicDefault.generate(page,size,order,direction,instance.getListCorrect());
    }
}
