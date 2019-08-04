package com.alecsandro.obras.services;

import com.alecsandro.obras.model.Obra;
import com.alecsandro.obras.utils.GenericDao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ObraService extends AbstractCrudService<Obra> {

    @Inject
    private GenericDao<Obra> dao;

    @Override
    protected GenericDao<Obra> getDao() {
        return dao;
    }
}
