package com.alecsandro.obras.services;

import com.alecsandro.obras.model.Fornecedor;
import com.alecsandro.obras.utils.GenericDao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class FornecedorService extends AbstractCrudService<Fornecedor> {

    @Inject
    private GenericDao<Fornecedor> dao;

    @Override
    protected GenericDao<Fornecedor> getDao() {
        return dao;
    }
}
