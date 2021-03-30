package ru.runanddone.admin.cityes.repository;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import ru.runanddone.admin.cityes.model.City;
import ru.runanddone.admin.utils.GuidIdGenerator;

import java.io.Serializable;

public class CityIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        if (object instanceof City) {
            City entity = ((City) object);
            return GuidIdGenerator.generate(entity.getOffice());
        } else {
            return null;
        }
    }

}
