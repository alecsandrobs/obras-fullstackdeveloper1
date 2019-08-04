package com.alecsandro.obras.rest.resources;

import com.alecsandro.obras.rest.AbstractCrudResource;
import com.alecsandro.obras.model.Produto;
import com.alecsandro.obras.services.AbstractCrudService;
import com.alecsandro.obras.services.ProdutoService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("produtos")
public class ProdutoResource extends AbstractCrudResource<Produto> {

    @Inject
    private ProdutoService service;
    
    @Override
    protected AbstractCrudService<Produto> getService() {
        return service;
    }
    
}
