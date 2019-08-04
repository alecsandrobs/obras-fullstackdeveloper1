package com.alecsandro.obras.services;

import com.alecsandro.obras.model.Produto;
import com.alecsandro.obras.utils.GenericDao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ProdutoService extends AbstractCrudService<Produto>{

    @Inject
    private GenericDao<Produto> dao;
    
    @Override
    protected GenericDao<Produto> getDao() {
        return dao;
    }
}
