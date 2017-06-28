package com.allen.demo.ValidatingFormInput;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Allen on 2017/6/28.
 */
public class PersonForm {
    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @Override
    public String toString() {
        return "PersonForm{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @NotNull
    @Min(18)

    private Integer age;
}
