package com.example.desafio.utils.pageable.fields.name.get.use.reflect.project;

import com.example.desafio.model.project.Project;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FieldsNameProject{
    private final List<String>  fieldsNameIncorrect=List.of("passwordAccess","user");
    private List<String> fieldsNameCorrect;
    private static FieldsNameProject instance;

    private FieldsNameProject(){
        deleteFieldsNameInvalids();
    }

    public static FieldsNameProject getInstance(){
        return (instance==null?instance=new FieldsNameProject():instance);
    }

    public List<String> getListCorrect(){
        return this.fieldsNameCorrect;
    }

    private void deleteFieldsNameInvalids(){
        List<String> fieldsNameListCorrect=new ArrayList<>();
        Field[] fieldsReflection= Project.class.getDeclaredFields();

        for(Field field:fieldsReflection){
            if(!this.fieldsNameIncorrect.contains(field.getName())){
                fieldsNameListCorrect.add(field.getName());
            }
        }
        this.fieldsNameCorrect=fieldsNameListCorrect;

    }
}
