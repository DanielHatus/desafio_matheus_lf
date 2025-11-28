package com.example.desafio.utils.pageable.fields.name.get.use.reflect.user;

import com.example.desafio.model.user.User;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FieldsNameUser{
    private static FieldsNameUser instance;
    private List<String> fieldsNameCorrect;
    private List<String> fieldsNameIncorrect=List.of("password","lastUpdate");
    private FieldsNameUser(){
     deleteFieldsNameInvalids();
    }

    public static FieldsNameUser getInstance(){
        return (instance==null ? instance=new FieldsNameUser():instance);
    }

    public List<String> getListCorrect(){
        return this.fieldsNameCorrect;
    }

    private void deleteFieldsNameInvalids(){
      List<String> fieldsNameListCorrect=new ArrayList<>();
      Field[] fieldsReflection=User.class.getDeclaredFields();

      for(Field field:fieldsReflection){
          if(!this.fieldsNameIncorrect.contains(field.getName())){
              fieldsNameListCorrect.add(field.getName());
          }
      }
      this.fieldsNameCorrect=fieldsNameListCorrect;

    }
}
