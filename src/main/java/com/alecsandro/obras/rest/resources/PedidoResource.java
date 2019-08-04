package com.alecsandro.obras.rest.resources;

import com.alecsandro.obras.model.Pedido;
import com.alecsandro.obras.rest.AbstractCrudResource;
import com.alecsandro.obras.services.AbstractCrudService;
import com.alecsandro.obras.services.PedidoFornecedorService;
import com.alecsandro.obras.services.PedidoService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("pedidos")
public class PedidoResource extends AbstractCrudResource<Pedido> {

    @Inject
    private PedidoService service;

    @Override
    protected AbstractCrudService<Pedido> getService() {
        return service;
    }

}
