package com.alecsandro.obras.rest.resources;

import com.alecsandro.obras.model.Obra;
import com.alecsandro.obras.rest.AbstractCrudResource;
import com.alecsandro.obras.services.AbstractCrudService;
import com.alecsandro.obras.services.ObraService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("obras")
public class ObraResource extends AbstractCrudResource<Obra> {

    @Inject
    private ObraService service;

    @Override
    protected AbstractCrudService<Obra> getService() {
        return service;
    }

}
