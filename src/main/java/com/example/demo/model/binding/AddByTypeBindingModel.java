package com.example.demo.model.binding;

import com.example.demo.model.entity.enums.TypeEnum;

public class AddByTypeBindingModel {

    private TypeEnum typeEnum;

    public AddByTypeBindingModel() {
    }

    public TypeEnum getTypeEnum() {
        return typeEnum;
    }

    public AddByTypeBindingModel setTypeEnum(TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
        return this;
    }
}
