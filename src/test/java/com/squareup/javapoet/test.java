package com.squareup.javapoet;

import org.junit.Test;

import java.io.IOException;
import javax.lang.model.element.Modifier;

public class test {
    @Test
    public void getParameterizedTypeMirror(){
        MethodSpec main = MethodSpec
                .methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "hello world")
                .build();
        TypeSpec hello = TypeSpec.enumBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC)
                .addMethod(main)
                .build();

        String packgeName = "com.zs.javapoet";
        JavaFile file = JavaFile.builder(packgeName, hello).build();
        try{
            file.writeTo(System.out);
        }catch (IOException e){
            return;
        }

    }




}
