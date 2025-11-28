package com.example.desafio.utils.pageable.implementations.project;

import com.example.desafio.utils.pageable.fields.name.get.use.reflect.project.FieldsNameProject;
import com.example.desafio.utils.pageable.interfaces.PageableGenerator;
import com.example.desafio.utils.pageable.logic.default_.PageableLogicDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ImplementPageableProject implements PageableGenerator{
    private final PageableLogicDefault logicDefault;
    private final FieldsNameProject fieldsNameProject=FieldsNameProject.getInstance();

    public ImplementPageableProject(PageableLogicDefault logicDefault) {
        this.logicDefault = logicDefault;
    }

    @Override
    public Pageable generatePageable(Integer page, Integer size, String order, String direction) {
      return logicDefault.generate(page,size,order,direction,this.fieldsNameProject.getListCorrect());
    }
}
