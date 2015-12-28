package com.github.leonardocouto.pontodigital.view;

import com.github.leonardocouto.pontodigital.entity.WorkActivity;

public interface AddWorkActivityActionHandler {

    public void differentFrom(WorkActivity ... excludes);

}
