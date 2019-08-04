package com.alecsandro.obras.rest.resources;

import com.alecsandro.obras.rest.AbstractCrudResource;
import com.alecsandro.obras.model.Cliente;
import com.alecsandro.obras.services.AbstractCrudService;
import com.alecsandro.obras.services.ClienteService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("clientes")
public class ClienteResource extends AbstractCrudResource<Cliente> {

    @Inject
    private ClienteService service;

    @Override
    protected AbstractCrudService<Cliente> getService() {
        return service;
    }

}
