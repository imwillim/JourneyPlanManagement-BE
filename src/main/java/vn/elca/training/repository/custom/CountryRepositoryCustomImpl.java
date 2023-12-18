package vn.elca.training.repository.custom;

import com.querydsl.jpa.impl.JPAQueryFactory;
import vn.elca.training.model.entity.Country;
import vn.elca.training.model.entity.QCountry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountryRepositoryCustomImpl implements CountryRepositoryCustom{
    @PersistenceContext
    private EntityManager em;
    @Override
    public Set<Country> getAll() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Country> countries =
                queryFactory.selectFrom(QCountry.country)
                        .orderBy(QCountry.country.name.toUpperCase().asc())
                .fetch();
        return new HashSet<>(countries);
    }
}
