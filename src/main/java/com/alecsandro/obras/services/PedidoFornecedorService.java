package com.alecsandro.obras.services;

import com.alecsandro.obras.model.PedidoFornecedor;
import com.alecsandro.obras.utils.GenericDao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class PedidoFornecedorService extends AbstractCrudService<PedidoFornecedor> {

    @Inject
    private GenericDao<PedidoFornecedor> dao;

    @Override
    protected GenericDao<PedidoFornecedor> getDao() {
        return dao;
    }
}
