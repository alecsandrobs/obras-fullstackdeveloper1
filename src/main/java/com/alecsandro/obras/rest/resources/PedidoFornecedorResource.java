package com.alecsandro.obras.rest.resources;

import com.alecsandro.obras.model.PedidoFornecedor;
import com.alecsandro.obras.rest.AbstractCrudResource;
import com.alecsandro.obras.services.AbstractCrudService;
import com.alecsandro.obras.services.PedidoFornecedorService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("pedidos-fornecedores")
public class PedidoFornecedorResource extends AbstractCrudResource<PedidoFornecedor> {

    @Inject
    private PedidoFornecedorService service;

    @Override
    protected AbstractCrudService<PedidoFornecedor> getService() {
        return service;
    }

}
