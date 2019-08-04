package com.alecsandro.obras.rest.resources;

import com.alecsandro.obras.rest.AbstractCrudResource;
import com.alecsandro.obras.model.Fornecedor;
import com.alecsandro.obras.services.AbstractCrudService;
import com.alecsandro.obras.services.FornecedorService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("fornecedores")
public class FornecedorResource extends AbstractCrudResource<Fornecedor> {

    @Inject
    private FornecedorService service;

    @Override
    protected AbstractCrudService<Fornecedor> getService() {
        return service;
    }
}
