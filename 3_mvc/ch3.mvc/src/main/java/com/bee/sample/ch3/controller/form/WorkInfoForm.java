package com.bee.sample.ch3.controller.form;

import com.bee.sample.ch3.controller.validate.WorkOverTime;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class WorkInfoForm {

    /**
     * 两种校验上下文Update以及Add。
     */
    public interface Update {}

    public interface Add {}

    /**
     * 下面两个注解表示当上下文为Update时，必须不为空。 当上下文为Add时，id必须为空。
     */
    @NotNull(groups = {Update.class})
    @Null(groups = {Add.class})
    Long id;
    @Size(min = 3, max = 20)
    String name;
    @Email
    String email;
    @WorkOverTime(max = 5)
    Integer workTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

}
