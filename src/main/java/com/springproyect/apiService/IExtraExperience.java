package com.springproyect.apiService;

import com.springproyect.model.ExtraExperience;

import java.util.List;

public interface IExtraExperience {

    public void saveExperience(ExtraExperience extraExperience);

    public ExtraExperience findExperience(Long id);

    public List<ExtraExperience> getExperience();
}
